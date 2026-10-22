package com.android.server.recoverysystem;

import android.apex.CompressedApexInfo;
import android.apex.CompressedApexInfoList;
import android.content.Context;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.hardware.boot.IBootControl;
import android.hardware.security.secretkeeper.ISecretkeeper;
import android.net.INetd;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Environment;
import android.os.IRecoverySystem;
import android.os.IRecoverySystemProgressListener;
import android.os.PowerManager;
import android.os.RecoverySystem;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.ota.nano.OtaPackageMetadata;
import android.provider.DeviceConfig;
import android.security.AndroidKeyStoreMaintenance;
import android.security.KeyStoreException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.FastImmutableArraySet;
import android.util.Log;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.widget.LockSettingsInternal;
import com.android.internal.widget.RebootEscrowListener;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.Watchdog;
import com.android.server.pm.ApexManager;
import com.android.server.recoverysystem.hal.BootControlHIDL;
import com.android.server.utils.Slogf;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RecoverySystemService extends IRecoverySystem.Stub implements RebootEscrowListener {
    static final String AB_UPDATE = "ro.build.ab_update";
    private static final long APEX_INFO_SIZE_LIMIT = 2457600;
    private static final boolean DEBUG = false;
    static final FastImmutableArraySet<Integer> FATAL_ARM_ESCROW_ERRORS = null;
    static final String INIT_SERVICE_CLEAR_BCB = "init.svc.clear-bcb";
    static final String INIT_SERVICE_SETUP_BCB = "init.svc.setup-bcb";
    static final String INIT_SERVICE_UNCRYPT = "init.svc.uncrypt";
    static final String LSKF_CAPTURED_COUNT_PREF = "lskf_captured_count";
    static final String LSKF_CAPTURED_TIMESTAMP_PREF = "lskf_captured_timestamp";
    private static final int REBOOT_WATCHDOG_PAUSE_DURATION_MS = 20000;
    static final String RECOVERY_WIPE_DATA_COMMAND = "--wipe_data";
    static final String REQUEST_LSKF_COUNT_PREF_SUFFIX = "_request_lskf_count";
    static final String REQUEST_LSKF_TIMESTAMP_PREF_SUFFIX = "_request_lskf_timestamp";
    private static final int ROR_NEED_PREPARATION = 0;
    private static final int ROR_NOT_REQUESTED = 0;
    private static final int ROR_REQUESTED_NEED_CLEAR = 1;
    private static final int ROR_REQUESTED_SKIP_CLEAR = 2;
    private static final int ROR_SKIP_PREPARATION_AND_NOTIFY = 1;
    private static final int ROR_SKIP_PREPARATION_NOT_NOTIFY = 2;
    private static final int SOCKET_CONNECTION_MAX_RETRY = 30;
    private static final String TAG = "RecoverySystemService";
    private static final String UNCRYPT_SOCKET = "uncrypt";
    private static final Object sRequestLock = null;
    private final ArrayMap<String, IntentSender> mCallerPendingRequest;
    private final ArraySet<String> mCallerPreparedForReboot;
    private final Context mContext;
    private final Injector mInjector;

    static class Injector {
        protected final Context mContext;
        protected final PreferencesManager mPrefs;

        Injector(Context context) {
            this.mContext = context;
            this.mPrefs = new PreferencesManager(context);
        }

        public Context getContext() {
            return this.mContext;
        }

        public LockSettingsInternal getLockSettingsService() {
            return (LockSettingsInternal) LocalServices.getService(LockSettingsInternal.class);
        }

        public PowerManager getPowerManager() {
            return (PowerManager) this.mContext.getSystemService("power");
        }

        public String systemPropertiesGet(String key) {
            return SystemProperties.get(key);
        }

        public void systemPropertiesSet(String key, String value) {
            SystemProperties.set(key, value);
        }

        public boolean uncryptPackageFileDelete() {
            return RecoverySystem.UNCRYPT_PACKAGE_FILE.delete();
        }

        public String getUncryptPackageFileName() {
            return RecoverySystem.UNCRYPT_PACKAGE_FILE.getName();
        }

        public FileWriter getUncryptPackageFileWriter() throws IOException {
            return new FileWriter(RecoverySystem.UNCRYPT_PACKAGE_FILE);
        }

        public UncryptSocket connectService() {
            UncryptSocket socket = new UncryptSocket();
            if (socket.connectService() == true) goto L6;
            socket.close();
            return null;
        L6:
            return socket;
        }

        public IBootControl getBootControl() throws RemoteException {
            String serviceName = IBootControl.DESCRIPTOR + "/default";
            if (ServiceManager.isDeclared(serviceName) == false) goto L6;
            Slog.i(RecoverySystemService.TAG, "AIDL version of BootControl HAL present, using instance " + serviceName);
            return IBootControl.Stub.asInterface(ServiceManager.waitForDeclaredService(serviceName));
        L6:
            IBootControl bootcontrol = BootControlHIDL.getService();
            if (BootControlHIDL.isServicePresent() == true) goto L11;
            Slog.e(RecoverySystemService.TAG, "Neither AIDL nor HIDL version of the BootControl HAL is present.");
            return null;
        L11:
            if (BootControlHIDL.isV1_2ServicePresent() == true) goto L14;
            Slog.w(RecoverySystemService.TAG, "Device doesn't implement boot control HAL V1_2.");
            return null;
        L14:
            return bootcontrol;
        }

        public void threadSleep(long millis) throws InterruptedException {
            Thread.sleep(millis);
        }

        public int getUidFromPackageName(String packageName) {
            return this.mContext.getPackageManager().getPackageUidAsUser(packageName, 0);
        L5:
            Slog.w(RecoverySystemService.TAG, "Failed to find uid for " + packageName);
            return -1;
        }

        public PreferencesManager getMetricsPrefs() {
            return this.mPrefs;
        }

        public long getCurrentTimeMillis() {
            return System.currentTimeMillis();
        }

        public void reportRebootEscrowPreparationMetrics(int uid, int requestResult, int requestedClientCount) {
            FrameworkStatsLog.write(FrameworkStatsLog.REBOOT_ESCROW_PREPARATION_REPORTED, uid, requestResult, requestedClientCount);
        }

        public void reportRebootEscrowLskfCapturedMetrics(int uid, int requestedClientCount, int requestedToLskfCapturedDurationInSeconds) {
            FrameworkStatsLog.write(FrameworkStatsLog.REBOOT_ESCROW_LSKF_CAPTURE_REPORTED, uid, requestedClientCount, requestedToLskfCapturedDurationInSeconds);
        }

        public void reportRebootEscrowRebootMetrics(int errorCode, int uid, int preparedClientCount, int requestCount, boolean slotSwitch, boolean serverBased, int lskfCapturedToRebootDurationInSeconds, int lskfCapturedCounts) {
            FrameworkStatsLog.write(FrameworkStatsLog.REBOOT_ESCROW_REBOOT_REPORTED, errorCode, uid, preparedClientCount, requestCount, slotSwitch, serverBased, lskfCapturedToRebootDurationInSeconds, lskfCapturedCounts);
        }
    }

    public static final class Lifecycle extends SystemService {
        private RecoverySystemService mRecoverySystemService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L6;
            this.mRecoverySystemService.onSystemServicesReady();
            return;
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mRecoverySystemService = new RecoverySystemService(getContext(), null);
            publishBinderService("recovery", this.mRecoverySystemService);
        }
    }

    public static class PreferencesManager {
        private static final String METRICS_DIR = "recovery_system";
        private static final String METRICS_PREFS_FILE = "RecoverySystemMetricsPrefs.xml";
        private final File mMetricsPrefsFile;
        protected final SharedPreferences mSharedPreferences;

        PreferencesManager(Context context) {
            File prefsDir = new File(Environment.getDataSystemCeDirectory(0), METRICS_DIR);
            this.mMetricsPrefsFile = new File(prefsDir, METRICS_PREFS_FILE);
            this.mSharedPreferences = context.getSharedPreferences(this.mMetricsPrefsFile, 0);
        }

        public long getLong(String key, long defaultValue) {
            return this.mSharedPreferences.getLong(key, defaultValue);
        }

        public int getInt(String key, int defaultValue) {
            return this.mSharedPreferences.getInt(key, defaultValue);
        }

        public void putLong(String key, long value) {
            this.mSharedPreferences.edit().putLong(key, value).commit();
        }

        public void putInt(String key, int value) {
            this.mSharedPreferences.edit().putInt(key, value).commit();
        }

        public synchronized void incrementIntKey(String key, int defaultInitialValue) {
            monitor-enter(this);
            int oldValue = getInt(key, defaultInitialValue);     // Catch: Throwable -> L6
            putInt(key, oldValue + 1);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void deletePrefsFile() {
            if (this.mMetricsPrefsFile.delete() == true) goto L6;
            Slog.w(RecoverySystemService.TAG, "Failed to delete metrics prefs");
            return;
        }
    }

    static class RebootPreparationError {
        final int mProviderErrorCode;
        final int mRebootErrorCode;

        RebootPreparationError(int rebootErrorCode, int providerErrorCode) {
            this.mRebootErrorCode = rebootErrorCode;
            this.mProviderErrorCode = providerErrorCode;
        }

        int getErrorCodeForMetrics() {
            return this.mRebootErrorCode + this.mProviderErrorCode;
        }
    }

    private @interface ResumeOnRebootActionsOnClear {
    }

    private @interface ResumeOnRebootActionsOnRequest {
    }

    public static class UncryptSocket {
        private DataInputStream mInputStream;
        private LocalSocket mLocalSocket;
        private DataOutputStream mOutputStream;

        public UncryptSocket() {
        }

        public boolean connectService() {
            this.mLocalSocket = new LocalSocket();
            boolean done = false;
            int retry = 0;
        L4:
            if (retry >= 30) goto L15;
            this.mLocalSocket.connect(new LocalSocketAddress(RecoverySystemService.UNCRYPT_SOCKET, LocalSocketAddress.Namespace.RESERVED));     // Catch: IOException -> L7
            done = true;
        L28:
            Thread.sleep(1000);     // Catch: InterruptedException -> L11
        L13:
            retry = retry + 1;
        L11:
            e = move-exception;
            Slog.w(RecoverySystemService.TAG, "Interrupted:", e);
        L15:
            if (done == true) goto L24;
            Slog.e(RecoverySystemService.TAG, "Timed out connecting to uncrypt socket");
            close();
            return false;
        L24:
            this.mInputStream = new DataInputStream(this.mLocalSocket.getInputStream());     // Catch: IOException -> L21
            this.mOutputStream = new DataOutputStream(this.mLocalSocket.getOutputStream());     // Catch: IOException -> L21
            return true;
        L22:
            close();
            return false;
        }

        public void sendCommand(String command) throws IOException {
            byte[] cmdUtf8 = command.getBytes(StandardCharsets.UTF_8);
            this.mOutputStream.writeInt(cmdUtf8.length);
            this.mOutputStream.write(cmdUtf8, 0, cmdUtf8.length);
        }

        public int getPercentageUncrypted() throws IOException {
            return this.mInputStream.readInt();
        }

        public void sendAck() throws IOException {
            this.mOutputStream.writeInt(0);
        }

        public void close() {
            IoUtils.closeQuietly(this.mInputStream);
            IoUtils.closeQuietly(this.mOutputStream);
            IoUtils.closeQuietly(this.mLocalSocket);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7tKeJyLjs6InXh4MDrJ9aFW6-1Y, reason: not valid java name */
    public static /* synthetic */ boolean m7970$r8$lambda$7tKeJyLjs6InXh4MDrJ9aFW61Y(OtaPackageMetadata.ApexInfo r0) {
        return lambda$getCompressedApexInfoList$0(r0);
    }

    public static /* synthetic */ CompressedApexInfo $r8$lambda$9YaBRC9xFwBx5Uacz0_s2CFo5Ws(OtaPackageMetadata.ApexInfo r0) {
        return lambda$getCompressedApexInfoList$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$aCcdPPfc6F5DG_3isM92-9pxwAA, reason: not valid java name */
    public static /* synthetic */ CompressedApexInfo[] m7971$r8$lambda$aCcdPPfc6F5DG_3isM929pxwAA(int r0) {
        return lambda$getCompressedApexInfoList$2(r0);
    }

    /* synthetic */ RecoverySystemService(Context r1, RecoverySystemServiceIA r2) {
        this(r1);
    }

    static {
        sRequestLock = new Object();
        FATAL_ARM_ESCROW_ERRORS = new FastImmutableArraySet(new Integer[]{2, 3, 4, 5, 6});
    }

    private RecoverySystemService(Context context) {
        this(new Injector(context));
    }

    RecoverySystemService(Injector injector) {
        this.mCallerPendingRequest = new ArrayMap();
        this.mCallerPreparedForReboot = new ArraySet();
        this.mInjector = injector;
        this.mContext = injector.getContext();
    }

    void onSystemServicesReady() {
        LockSettingsInternal lockSettings = this.mInjector.getLockSettingsService();
        if (lockSettings != null) goto L6;
        Slog.e(TAG, "Failed to get lock settings service, skipping set RebootEscrowListener");
        return;
    L6:
        lockSettings.setRebootEscrowListener(this);
    }

    public boolean uncrypt(String filename, IRecoverySystemProgressListener listener) {
        Object r0 = sRequestLock;
        monitor-enter(r0);
        this.mContext.enforceCallingOrSelfPermission("android.permission.RECOVERY", null);     // Catch: Throwable -> L9
        if (checkAndWaitForUncryptService() == true) goto L11;
        Slog.e(TAG, "uncrypt service is unavailable.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mInjector.uncryptPackageFileDelete();     // Catch: Throwable -> L9
        FileWriter uncryptFile = this.mInjector.getUncryptPackageFileWriter();     // Catch: Throwable -> L9 IOException -> L58
        uncryptFile.write(filename + "\n");     // Catch: Throwable -> L60
        uncryptFile.close();     // Catch: Throwable -> L9 IOException -> L58
        this.mInjector.systemPropertiesSet("ctl.start", UNCRYPT_SOCKET);     // Catch: Throwable -> L9
        UncryptSocket socket = this.mInjector.connectService();     // Catch: Throwable -> L9
        if (socket != null) goto L20;
        Slog.e(TAG, "Failed to connect to uncrypt socket");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L20:
        int lastStatus = Integer.MIN_VALUE;
    L79:
        int status = socket.getPercentageUncrypted();     // Catch: Throwable -> L34 IOException -> L36
        if (status != lastStatus) goto L26;
        if (lastStatus != Integer.MIN_VALUE) goto L79;
    L26:
        lastStatus = status;
        if (status < 0) goto L47;
        if (status > 100) goto L47;
        Slog.i(TAG, "uncrypt read status: " + status);     // Catch: Throwable -> L34 IOException -> L36
        if (listener != null) goto L74;
    L40:
        if (status != 100) goto L79;
        Slog.i(TAG, "uncrypt successfully finished.");     // Catch: Throwable -> L34 IOException -> L36
        socket.sendAck();     // Catch: Throwable -> L34 IOException -> L36
        socket.close();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L74:
        listener.onProgress(status);     // Catch: Throwable -> L34 IOException -> L36 RemoteException -> L38
    L39:
        Slog.w(TAG, "RemoteException when posting progress");     // Catch: Throwable -> L34 IOException -> L36
    L47:
        Slog.e(TAG, "uncrypt failed with status: " + status);     // Catch: Throwable -> L34 IOException -> L36
        socket.sendAck();     // Catch: Throwable -> L34 IOException -> L36
        socket.close();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L36:
        e = move-exception;
        Slog.e(TAG, "IOException when reading status: ", e);     // Catch: Throwable -> L34
        socket.close();     // Catch: Throwable -> L9
        return false;
    L34:
        th = move-exception;
        socket.close();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L60:
        th = move-exception;
        if (uncryptFile != null) goto L81;
    L67:
        throw th;     // Catch: Throwable -> L9 IOException -> L58
    L81:
        uncryptFile.close();     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 IOException -> L58
    L58:
        e = move-exception;
        Slog.e(TAG, "IOException when writing \"" + this.mInjector.getUncryptPackageFileName() + "\":", e);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean clearBcb() {
        Object r0 = sRequestLock;
        monitor-enter(r0);
        boolean r1 = setupOrClearBcb(false, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean setupBcb(String command) {
        Object r0 = sRequestLock;
        monitor-enter(r0);
        boolean r1 = setupOrClearBcb(true, command);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    public void rebootRecoveryWithCommand(String command) {
        if (command != null) goto L5;
    L7:
        boolean isForcedWipe = false;
    L8:
        Object r2 = sRequestLock;
        monitor-enter(r2);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (setupOrClearBcb(true, command) == true) goto L17;
        Slog.e(TAG, "rebootRecoveryWithCommand failed to setup BCB");     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L17:
        if (isForcedWipe == false) goto L19;
        deleteSecrets();     // Catch: Throwable -> L15
    L19:
        PowerManager pm = this.mInjector.getPowerManager();     // Catch: Throwable -> L15
        pm.reboot("recovery");     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L5:
        if (command.contains(RECOVERY_WIPE_DATA_COMMAND) == false) goto L7;
        isForcedWipe = true;
        goto L8
    }

    private static void deleteSecrets() {
        Slogf.w(TAG, "deleteSecrets");
        AndroidKeyStoreMaintenance.deleteAllKeys();     // Catch: KeyStoreException -> L5
    L16:
        ISecretkeeper secretKeeper = getSecretKeeper();     // Catch: RemoteException -> L11
        if (secretKeeper == null) goto L20;
        Slogf.i(TAG, "ISecretkeeper.deleteAll();");     // Catch: RemoteException -> L11
        secretKeeper.deleteAll();     // Catch: RemoteException -> L11
        return;
    L20:
        return;
    L11:
        e = move-exception;
        Log.wtf(TAG, "Failed to delete all secrets from secretkeeper.", e);
        return;
    L5:
        e = move-exception;
        Log.wtf(TAG, "Failed to delete all keys from keystore.", e);
        goto L16
    }

    private static ISecretkeeper getSecretKeeper() {
        ISecretkeeper result = ISecretkeeper.Stub.asInterface(ServiceManager.waitForDeclaredService(ISecretkeeper.DESCRIPTOR + "/default"));     // Catch: SecurityException -> L5
        return result;
    L6:
        Slog.w(TAG, "Does not have permissions to get AIDL secretkeeper service");
        return null;
    }

    private void enforcePermissionForResumeOnReboot() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.RECOVERY") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REBOOT") != 0) goto L8;
        return;
    L8:
        throw new SecurityException("Caller must have android.permission.RECOVERY or android.permission.REBOOT for resume on reboot.");
    }

    private void reportMetricsOnRequestLskf(String packageName, int requestResult) {
        int uid = this.mInjector.getUidFromPackageName(packageName);
        monitor-enter(this);
        int pendingRequestCount = this.mCallerPendingRequest.size();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        PreferencesManager prefs = this.mInjector.getMetricsPrefs();
        prefs.putLong(packageName + REQUEST_LSKF_TIMESTAMP_PREF_SUFFIX, this.mInjector.getCurrentTimeMillis());
        prefs.incrementIntKey(packageName + REQUEST_LSKF_COUNT_PREF_SUFFIX, 0);
        this.mInjector.reportRebootEscrowPreparationMetrics(uid, requestResult, pendingRequestCount);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean requestLskf(String packageName, IntentSender intentSender) {
        enforcePermissionForResumeOnReboot();
        if (packageName != null) goto L6;
        Slog.w(TAG, "Missing packageName when requesting lskf.");
        return false;
    L6:
        int action = updateRoRPreparationStateOnNewRequest(packageName, intentSender);
        reportMetricsOnRequestLskf(packageName, action);
        switch(action) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L10;
            default: goto L9;
        };
    L10:
        return true;
    L11:
        sendPreparedForRebootIntentIfNeeded(intentSender);
        return true;
    L13:
        long origId = Binder.clearCallingIdentity();
        LockSettingsInternal lockSettings = this.mInjector.getLockSettingsService();     // Catch: Throwable -> L19
        if (lockSettings != null) goto L22;
        Slog.e(TAG, "Failed to get lock settings service, skipping prepareRebootEscrow");     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(origId);
        return false;
    L22:
        if (lockSettings.prepareRebootEscrow() == true) goto L26;
        clearRoRPreparationState();     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(origId);
        return false;
    L26:
        Binder.restoreCallingIdentity(origId);
        return true;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L9:
        throw new IllegalStateException("Unsupported action type on new request " + action);
    }

    private synchronized int updateRoRPreparationStateOnNewRequest(String packageName, IntentSender intentSender) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mCallerPreparedForReboot.isEmpty() == false) goto L6;
        boolean needPreparation = this.mCallerPendingRequest.isEmpty();     // Catch: Throwable -> L8
        if (this.mCallerPendingRequest.containsKey(packageName) == false) goto L17;
        Slog.i(TAG, "Duplicate RoR preparation request for " + packageName);     // Catch: Throwable -> L8
    L17:
        this.mCallerPendingRequest.put(packageName, intentSender);     // Catch: Throwable -> L8
        if (needPreparation == false) goto L20;
        int r1 = 0;
    L21:
        monitor-exit(this);
        return r1;
    L20:
        r1 = 2;
        goto L21
    L6:
        if (this.mCallerPreparedForReboot.contains(packageName) == false) goto L10;
        Slog.i(TAG, "RoR already has prepared for " + packageName);     // Catch: Throwable -> L8
    L10:
        this.mCallerPreparedForReboot.add(packageName);     // Catch: Throwable -> L8
        monitor-exit(this);
        return 1;
    }

    private void reportMetricsOnPreparedForReboot() {
        long currentTimestamp = this.mInjector.getCurrentTimeMillis();
        monitor-enter(this);
        List<String> preparedClients = new ArrayList(this.mCallerPreparedForReboot);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        PreferencesManager prefs = this.mInjector.getMetricsPrefs();
        prefs.putLong(LSKF_CAPTURED_TIMESTAMP_PREF, currentTimestamp);
        prefs.incrementIntKey(LSKF_CAPTURED_COUNT_PREF, 0);
        Iterator<String> r4 = preparedClients.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        String packageName = r4.next();
        int uid = this.mInjector.getUidFromPackageName(packageName);
        int durationSeconds = -1;
        long requestLskfTimestamp = prefs.getLong(packageName + REQUEST_LSKF_TIMESTAMP_PREF_SUFFIX, -1);
        if (requestLskfTimestamp == (-1)) goto L14;
        if (currentTimestamp <= requestLskfTimestamp) goto L14;
        durationSeconds = ((int) (currentTimestamp - requestLskfTimestamp)) / 1000;
    L14:
        Slog.i(TAG, String.format("Reporting lskf captured, lskf capture takes %d seconds for package %s", new Object[]{Integer.valueOf(durationSeconds), packageName}));
        this.mInjector.reportRebootEscrowLskfCapturedMetrics(uid, preparedClients.size(), durationSeconds);
        goto L8
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void onPreparedForReboot(boolean ready) {
        if (ready == true) goto L4;
        return;
    L4:
        updateRoRPreparationStateOnPreparedForReboot();
        reportMetricsOnPreparedForReboot();
    }

    private synchronized void updateRoRPreparationStateOnPreparedForReboot() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mCallerPreparedForReboot.isEmpty() == true) goto L9;
        Slog.w(TAG, "onPreparedForReboot called when some clients have prepared.");     // Catch: Throwable -> L6
    L9:
        if (this.mCallerPendingRequest.isEmpty() == false) goto L11;
        Slog.w(TAG, "onPreparedForReboot called but no client has requested.");     // Catch: Throwable -> L6
    L11:
        int i = 0;
    L13:
        if (i >= this.mCallerPendingRequest.size()) goto L15;
        sendPreparedForRebootIntentIfNeeded(this.mCallerPendingRequest.valueAt(i));     // Catch: Throwable -> L6
        this.mCallerPreparedForReboot.add(this.mCallerPendingRequest.keyAt(i));     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L13
    L15:
        this.mCallerPendingRequest.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    private void sendPreparedForRebootIntentIfNeeded(IntentSender intentSender) {
        if (intentSender == null) goto L9;
        intentSender.sendIntent(null, 0, null, null, null);     // Catch: IntentSender.SendIntentException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Could not send intent for prepared reboot: " + e.getMessage());
        return;
    }

    public boolean clearLskf(String packageName) {
        enforcePermissionForResumeOnReboot();
        if (packageName != null) goto L6;
        Slog.w(TAG, "Missing packageName when clearing lskf.");
        return false;
    L6:
        int action = updateRoRPreparationStateOnClear(packageName);
        switch(action) {
            case 0: goto L24;
            case 1: goto L11;
            case 2: goto L10;
            default: goto L9;
        };
    L10:
        return true;
    L11:
        long origId = Binder.clearCallingIdentity();
        LockSettingsInternal lockSettings = this.mInjector.getLockSettingsService();     // Catch: Throwable -> L17
        if (lockSettings != null) goto L19;
        Slog.e(TAG, "Failed to get lock settings service, skipping clearRebootEscrow");     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(origId);
        return false;
    L19:
        boolean r0 = lockSettings.clearRebootEscrow();     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(origId);
        return r0;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L24:
        Slog.w(TAG, "RoR clear called before preparation for caller " + packageName);
        return true;
    L9:
        throw new IllegalStateException("Unsupported action type on clear " + action);
    }

    private synchronized int updateRoRPreparationStateOnClear(String packageName) {
        monitor-enter(this);
        boolean needClear = false;
        if (this.mCallerPreparedForReboot.contains(packageName) == false) goto L6;
    L12:
        this.mCallerPendingRequest.remove(packageName);     // Catch: Throwable -> L10
        this.mCallerPreparedForReboot.remove(packageName);     // Catch: Throwable -> L10
        int r2 = 1;
        if (this.mCallerPendingRequest.isEmpty() == true) goto L15;
    L18:
        if (needClear == true) goto L21;
        r2 = 2;
    L21:
        monitor-exit(this);
        return r2;
    L15:
        if (this.mCallerPreparedForReboot.isEmpty() == false) goto L18;
        needClear = true;
        goto L18
    L6:
        if (this.mCallerPendingRequest.containsKey(packageName) == true) goto L12;
        Slog.w(TAG, packageName + " hasn't prepared for resume on reboot");     // Catch: Throwable -> L10
        monitor-exit(this);
        return 0;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isAbDevice() {
        return "true".equalsIgnoreCase(this.mInjector.systemPropertiesGet(AB_UPDATE));
    }

    private boolean verifySlotForNextBoot(boolean slotSwitch) {
        if (isAbDevice() == true) goto L36;
        Slog.w(TAG, "Device isn't a/b, skipping slot verification.");
        return true;
    L36:
        IBootControl bootControl = this.mInjector.getBootControl();     // Catch: RemoteException -> L32
        if (bootControl != null) goto L35;
        Slog.w(TAG, "Cannot get the boot control HAL, skipping slot verification.");
        return true;
    L35:
        int current_slot = bootControl.getCurrentSlot();     // Catch: RemoteException -> L17
        if (current_slot == 0) goto L19;
        if (current_slot == 1) goto L19;
        throw new IllegalStateException("Current boot slot should be 0 or 1, got " + current_slot);     // Catch: RemoteException -> L17
    L19:
        int next_active_slot = bootControl.getActiveBootSlot();     // Catch: RemoteException -> L17
        int expected_active_slot = current_slot;
        if (slotSwitch == false) goto L26;
        if (current_slot != 0) goto L24;
        int r7 = 1;
    L25:
        expected_active_slot = r7;
        goto L26
    L24:
        r7 = 0;
    L26:
        if (next_active_slot == expected_active_slot) goto L29;
        Slog.w(TAG, "The next active boot slot doesn't match the expected value, expected " + expected_active_slot + ", got " + next_active_slot);
        return false;
    L29:
        return true;
    L17:
        e = move-exception;
        Slog.w(TAG, "Failed to query the active slots", e);
        return false;
    L32:
        e = move-exception;
        Slog.w(TAG, "Failed to get the boot control HAL " + e);
        return false;
    }

    private RebootPreparationError armRebootEscrow(String packageName, boolean slotSwitch) {
        if (packageName != null) goto L7;
        Slog.w(TAG, "Missing packageName when rebooting with lskf.");
        return new RebootPreparationError(2000, 0);
    L7:
        if (isLskfCaptured(packageName) == true) goto L11;
        return new RebootPreparationError(3000, 0);
    L11:
        if (verifySlotForNextBoot(slotSwitch) == false) goto L13;
        long origId = Binder.clearCallingIdentity();
        LockSettingsInternal lockSettings = this.mInjector.getLockSettingsService();     // Catch: Throwable -> L20
        if (lockSettings != null) goto L22;
        Slog.e(TAG, "Failed to get lock settings service, skipping armRebootEscrow");     // Catch: Throwable -> L20
        RebootPreparationError r0 = new RebootPreparationError(5000, 3);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return r0;
    L22:
        int providerErrorCode = lockSettings.armRebootEscrow();     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        if (providerErrorCode == 0) goto L28;
        Slog.w(TAG, "Failure to escrow key for reboot, providerErrorCode: " + providerErrorCode);
        return new RebootPreparationError(5000, providerErrorCode);
    L28:
        return new RebootPreparationError(0, 0);
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L13:
        return new RebootPreparationError(4000, 0);
    }

    private boolean useServerBasedRoR() {
        long origId = Binder.clearCallingIdentity();
        boolean r2 = DeviceConfig.getBoolean("ota", "server_based_ror_enabled", false);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private void reportMetricsOnRebootWithLskf(String packageName, boolean slotSwitch, RebootPreparationError escrowError) {
        int uid = this.mInjector.getUidFromPackageName(packageName);
        boolean serverBased = useServerBasedRoR();
        monitor-enter(this);
        int preparedClientCount = this.mCallerPreparedForReboot.size();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        long currentTimestamp = this.mInjector.getCurrentTimeMillis();
        PreferencesManager prefs = this.mInjector.getMetricsPrefs();
        long lskfCapturedTimestamp = prefs.getLong(LSKF_CAPTURED_TIMESTAMP_PREF, -1);
        if (lskfCapturedTimestamp != (-1)) goto L9;
    L11:
        int durationSeconds = -1;
    L12:
        int requestCount = prefs.getInt(packageName + REQUEST_LSKF_COUNT_PREF_SUFFIX, -1);
        int lskfCapturedCount = prefs.getInt(LSKF_CAPTURED_COUNT_PREF, -1);
        Slog.i(TAG, String.format("Reporting reboot with lskf, package name %s, client count %d, request count %d, lskf captured count %d, duration since lskf captured %d seconds.", new Object[]{packageName, Integer.valueOf(preparedClientCount), Integer.valueOf(requestCount), Integer.valueOf(lskfCapturedCount), Integer.valueOf(durationSeconds)}));
        this.mInjector.reportRebootEscrowRebootMetrics(escrowError.getErrorCodeForMetrics(), uid, preparedClientCount, requestCount, slotSwitch, serverBased, durationSeconds, lskfCapturedCount);
        return;
    L9:
        if (currentTimestamp <= lskfCapturedTimestamp) goto L11;
        int durationSeconds2 = ((int) (currentTimestamp - lskfCapturedTimestamp)) / 1000;
        durationSeconds = durationSeconds2;
    L14:
        th = th;
    L20:
        throw th;
    L18:
        th = th;
        goto L20
    }

    private synchronized void clearRoRPreparationState() {
        monitor-enter(this);
        this.mCallerPendingRequest.clear();     // Catch: Throwable -> L6
        this.mCallerPreparedForReboot.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void clearRoRPreparationStateOnRebootFailure(RebootPreparationError escrowError) {
        if (FATAL_ARM_ESCROW_ERRORS.contains(Integer.valueOf(escrowError.mProviderErrorCode)) == true) goto L5;
        return;
    L5:
        Slog.w(TAG, "Clearing resume on reboot states for all clients on arm escrow error: " + escrowError.mProviderErrorCode);
        clearRoRPreparationState();
    }

    private int rebootWithLskfImpl(String packageName, String reason, boolean slotSwitch) {
        RebootPreparationError escrowError = armRebootEscrow(packageName, slotSwitch);
        reportMetricsOnRebootWithLskf(packageName, slotSwitch, escrowError);
        clearRoRPreparationStateOnRebootFailure(escrowError);
        int errorCode = escrowError.mRebootErrorCode;
        if (errorCode == 0) goto L5;
        return errorCode;
    L5:
        this.mInjector.getMetricsPrefs().deletePrefsFile();
        Watchdog.getInstance().pauseWatchingCurrentThreadFor(REBOOT_WATCHDOG_PAUSE_DURATION_MS, "reboot can be slow");
        PowerManager pm = this.mInjector.getPowerManager();
        pm.reboot(reason);
        return 1000;
    }

    public int rebootWithLskfAssumeSlotSwitch(String packageName, String reason) {
        rebootWithLskfAssumeSlotSwitch_enforcePermission();
        return rebootWithLskfImpl(packageName, reason, true);
    }

    public int rebootWithLskf(String packageName, String reason, boolean slotSwitch) {
        enforcePermissionForResumeOnReboot();
        return rebootWithLskfImpl(packageName, reason, slotSwitch);
    }

    private static CompressedApexInfoList getCompressedApexInfoList(String packageFile) throws IOException {
        ZipFile zipFile = new ZipFile(packageFile);
        ZipEntry entry = zipFile.getEntry("apex_info.pb");     // Catch: Throwable -> L14
        if (entry != null) goto L8;
        zipFile.close();
        return null;
    L8:
        if (entry.getSize() >= APEX_INFO_SIZE_LIMIT) goto L33;
        if (entry.getSize() != 0) goto L16;
        CompressedApexInfoList infoList = new CompressedApexInfoList();     // Catch: Throwable -> L14
        infoList.apexInfos = new CompressedApexInfo[0];     // Catch: Throwable -> L14
        zipFile.close();
        return infoList;
    L16:
        Log.i(TAG, "Allocating " + entry.getSize() + " bytes of memory to store OTA Metadata");     // Catch: Throwable -> L14
        byte[] data = new byte[(int) entry.getSize()];     // Catch: Throwable -> L14
        InputStream is = zipFile.getInputStream(entry);     // Catch: Throwable -> L14
        int bytesRead = is.read(data);     // Catch: Throwable -> L24
        String msg = "Read " + bytesRead + " when expecting " + data.length;     // Catch: Throwable -> L24
        Log.e(TAG, msg);     // Catch: Throwable -> L24
        if (bytesRead != data.length) goto L23;
        is.close();     // Catch: Throwable -> L14
        OtaPackageMetadata.ApexMetadata metadata = OtaPackageMetadata.ApexMetadata.parseFrom(data);     // Catch: Throwable -> L14
        CompressedApexInfoList apexInfoList = new CompressedApexInfoList();     // Catch: Throwable -> L14
        apexInfoList.apexInfos = (CompressedApexInfo[]) Arrays.stream(metadata.apexInfo).filter(new RecoverySystemService$$ExternalSyntheticLambda0()).map(new RecoverySystemService$$ExternalSyntheticLambda1()).toArray(new RecoverySystemService$$ExternalSyntheticLambda2());     // Catch: Throwable -> L14
        zipFile.close();
        return apexInfoList;
    L23:
        throw new IOException(msg);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (is != null) goto L44;
    L31:
        throw th;     // Catch: Throwable -> L14
    L44:
        is.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
        goto L31
    L33:
        throw new IllegalArgumentException("apex_info.pb has size " + entry.getSize() + " which is larger than the permitted limit" + APEX_INFO_SIZE_LIMIT);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        zipFile.close();     // Catch: Throwable -> L36
    L38:
        throw th;
    L36:
        th = move-exception;
        th.addSuppressed(th);
        goto L38
    }

    private static /* synthetic */ boolean lambda$getCompressedApexInfoList$0(OtaPackageMetadata.ApexInfo apex) {
        return apex.isCompressed;
    }

    private static /* synthetic */ CompressedApexInfo lambda$getCompressedApexInfoList$1(OtaPackageMetadata.ApexInfo apex) {
        CompressedApexInfo info = new CompressedApexInfo();
        info.moduleName = apex.packageName;
        info.decompressedSize = apex.decompressedSize;
        info.versionCode = apex.version;
        return info;
    }

    private static /* synthetic */ CompressedApexInfo[] lambda$getCompressedApexInfoList$2(int x$0) {
        return new CompressedApexInfo[x$0];
    }

    public boolean allocateSpaceForUpdate(String packageFile) {
        allocateSpaceForUpdate_enforcePermission();
        long token = Binder.clearCallingIdentity();
        CompressedApexInfoList apexInfoList = getCompressedApexInfoList(packageFile);     // Catch: Throwable -> L8 Throwable -> L10 RemoteException -> L12
        if (apexInfoList != null) goto L14;
        Log.i(TAG, "apex_info.pb not present in OTA package. Assuming device doesn't support compressedAPEX, continueing without allocating space.");     // Catch: Throwable -> L8 Throwable -> L10 RemoteException -> L12
        Binder.restoreCallingIdentity(token);
        return true;
    L14:
        ApexManager apexManager = ApexManager.getInstance();     // Catch: Throwable -> L8 Throwable -> L10 Throwable -> L10 RemoteException -> L12
        apexManager.reserveSpaceForCompressedApex(apexInfoList);     // Catch: Throwable -> L8 Throwable -> L10 Throwable -> L10 RemoteException -> L12
        Binder.restoreCallingIdentity(token);
        return true;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to reserve space for compressed apex: ", e);     // Catch: Throwable -> L8
    L19:
        Binder.restoreCallingIdentity(token);
        return false;
    L12:
        e = move-exception;
        e.rethrowAsRuntimeException();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean isLskfCaptured(String packageName) {
        enforcePermissionForResumeOnReboot();
        monitor-enter(this);
        boolean captured = this.mCallerPreparedForReboot.contains(packageName);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (captured == true) goto L9;
        Slog.i(TAG, "Reboot requested before prepare completed for caller " + packageName);
        return false;
    L9:
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean checkAndWaitForUncryptService() {
        int retry = 0;
    L3:
        boolean busy = false;
        if (retry >= 30) goto L20;
        String uncryptService = this.mInjector.systemPropertiesGet(INIT_SERVICE_UNCRYPT);
        String setupBcbService = this.mInjector.systemPropertiesGet(INIT_SERVICE_SETUP_BCB);
        String clearBcbService = this.mInjector.systemPropertiesGet(INIT_SERVICE_CLEAR_BCB);
        if (INetd.IF_FLAG_RUNNING.equals(uncryptService) == false) goto L8;
    L11:
        busy = true;
    L12:
        if (busy == false) goto L13;
        this.mInjector.threadSleep(1000);     // Catch: InterruptedException -> L16
    L18:
        retry = retry + 1;
    L16:
        e = move-exception;
        Slog.w(TAG, "Interrupted:", e);
        goto L18
    L13:
        return true;
    L8:
        if (INetd.IF_FLAG_RUNNING.equals(setupBcbService) == true) goto L11;
        if (INetd.IF_FLAG_RUNNING.equals(clearBcbService) == false) goto L12;
    L20:
        return false;
    }

    private boolean setupOrClearBcb(boolean isSetup, String command) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.RECOVERY", null);
        boolean available = checkAndWaitForUncryptService();
        if (available == true) goto L7;
        Slog.e(TAG, "uncrypt service is unavailable.");
        return false;
    L7:
        if (isSetup == false) goto L9;
        this.mInjector.systemPropertiesSet("ctl.start", "setup-bcb");
    L10:
        UncryptSocket socket = this.mInjector.connectService();
        if (socket != null) goto L38;
        Slog.e(TAG, "Failed to connect to uncrypt socket");
        return false;
    L38:
        if (isSetup == true) goto L39;
    L20:
        int status = socket.getPercentageUncrypted();     // Catch: Throwable -> L16 IOException -> L18
        socket.sendAck();     // Catch: Throwable -> L16 IOException -> L18
        if (status != 100) goto L29;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L16 IOException -> L18
        r5.append("uncrypt ");     // Catch: Throwable -> L16 IOException -> L18
        if (isSetup == false) goto L25;
        String r6 = "setup";
    L26:
        r5.append(r6);     // Catch: Throwable -> L16 IOException -> L18
        r5.append(" bcb successfully finished.");     // Catch: Throwable -> L16 IOException -> L18
        Slog.i(TAG, r5.toString());     // Catch: Throwable -> L16 IOException -> L18
        socket.close();
        return true;
    L25:
        r6 = "clear";
        goto L26
    L29:
        Slog.e(TAG, "uncrypt failed with status: " + status);     // Catch: Throwable -> L16 IOException -> L18
        socket.close();
        return false;
    L39:
        socket.sendCommand(command);     // Catch: Throwable -> L16 IOException -> L18
    L18:
        e = move-exception;
        Slog.e(TAG, "IOException when communicating with uncrypt:", e);     // Catch: Throwable -> L16
        socket.close();
        return false;
    L16:
        th = move-exception;
        socket.close();
        throw th;
    L9:
        this.mInjector.systemPropertiesSet("ctl.start", "clear-bcb");
        goto L10
    }

    private boolean isCallerShell() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L7;
        if (callingUid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void enforceShell() {
        if (isCallerShell() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Caller must be shell");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        enforceShell();
        long origId = Binder.clearCallingIdentity();
        new RecoverySystemShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }
}
