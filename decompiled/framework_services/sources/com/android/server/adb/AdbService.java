package com.android.server.adb;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.debug.AdbManagerInternal;
import android.debug.FingerprintAndPairDevice;
import android.debug.IAdbCallback;
import android.debug.IAdbManager;
import android.debug.IAdbTransport;
import android.debug.PairDevice;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.testharness.TestHarnessModeService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdbService extends IAdbManager.Stub {
    static final String ADBD = "adbd";
    static final String CTL_START = "ctl.start";
    static final String CTL_STOP = "ctl.stop";
    private static final String TAG = null;
    private static final String USB_PERSISTENT_CONFIG_PROPERTY = "persist.sys.usb.config";
    static final String WIFI_PERSISTENT_CONFIG_PROPERTY = "persist.adb.tls_server.enable";
    private WifiManager.MulticastLock mAdbMulticastLock;
    private final RemoteCallbackList<IAdbCallback> mCallbacks;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final AdbDebuggingManager mDebuggingManager;
    private boolean mIsAdbUsbEnabled;
    private boolean mIsAdbWifiEnabled;
    private ContentObserver mObserver;
    private final ArrayMap<IBinder, IAdbTransport> mTransports;

    private class AdbManagerInternalImpl extends AdbManagerInternal {
        final /* synthetic */ AdbService this$0;

        public static /* synthetic */ void $r8$lambda$mxHjsfzVGaenlkCb9wBh4XrNQKM(AdbService r0, boolean r1, byte r2) {
            AdbService.m980$$Nest$msetAdbdEnabledForTransport(r0, r1, r2);
        }

        /* synthetic */ AdbManagerInternalImpl(AdbService r1, AdbServiceIA r2) {
            this(r1);
        }

        private AdbManagerInternalImpl(AdbService r1) {
            this.this$0 = r1;
        }

        public void registerTransport(IAdbTransport transport) {
            AdbService.m978$$Nest$fgetmTransports(this.this$0).put(transport.asBinder(), transport);
        }

        public void unregisterTransport(IAdbTransport transport) {
            AdbService.m978$$Nest$fgetmTransports(this.this$0).remove(transport.asBinder());
        }

        public boolean isAdbEnabled(byte transportType) {
            if (transportType != 0) goto L6;
            return AdbService.m976$$Nest$fgetmIsAdbUsbEnabled(this.this$0);
        L6:
            if (transportType != 1) goto L10;
            return AdbService.m977$$Nest$fgetmIsAdbWifiEnabled(this.this$0);
        L10:
            throw new IllegalArgumentException("isAdbEnabled called with unimplemented transport type=" + transportType);
        }

        public File getAdbKeysFile() {
            return AdbService.m975$$Nest$fgetmDebuggingManager(this.this$0).getUserKeyFile();
        }

        public File getAdbTempKeysFile() {
            return AdbService.m975$$Nest$fgetmDebuggingManager(this.this$0).getAdbTempKeysFile();
        }

        public void notifyKeyFilesUpdated() {
            AdbService.m975$$Nest$fgetmDebuggingManager(this.this$0).notifyKeyFilesUpdated();
        }

        public void startAdbdForTransport(byte transportType) {
            FgThread.getHandler().sendMessage(PooledLambda.obtainMessage(new AdbService$AdbManagerInternalImpl$$ExternalSyntheticLambda0(), this.this$0, true, Byte.valueOf(transportType)));
        }

        public void stopAdbdForTransport(byte transportType) {
            FgThread.getHandler().sendMessage(PooledLambda.obtainMessage(new AdbService$AdbManagerInternalImpl$$ExternalSyntheticLambda0(), this.this$0, false, Byte.valueOf(transportType)));
        }
    }

    private class AdbSettingsObserver extends ContentObserver {
        private final Uri mAdbUsbUri;
        private final Uri mAdbWifiUri;
        final /* synthetic */ AdbService this$0;

        /* JADX INFO: renamed from: $r8$lambda$QsA9Am4S85-6tzWrx_VQgRFMz-I, reason: not valid java name */
        public static /* synthetic */ void m981$r8$lambda$QsA9Am4S856tzWrx_VQgRFMzI(AdbService r0, boolean r1, byte r2) {
            AdbService.m979$$Nest$msetAdbEnabled(r0, r1, r2);
        }

        AdbSettingsObserver(AdbService r1) {
            this.this$0 = r1;
            super(null);
            this.mAdbUsbUri = Settings.Global.getUriFor("adb_enabled");
            this.mAdbWifiUri = Settings.Global.getUriFor("adb_wifi_enabled");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            Slog.d("AdbSettingsObserver", "onChange " + uri.toString());
            boolean shouldEnable = true;
            boolean shouldEnable2 = false;
            if (this.mAdbUsbUri.equals(uri) == false) goto L11;
            if (Settings.Global.getInt(AdbService.m974$$Nest$fgetmContentResolver(this.this$0), "adb_enabled", 0) > 0) goto L8;
            shouldEnable = false;
        L8:
            FgThread.getHandler().sendMessage(PooledLambda.obtainMessage(new AdbService$AdbSettingsObserver$$ExternalSyntheticLambda0(), this.this$0, Boolean.valueOf(shouldEnable), (byte) 0));
            return;
        L11:
            if (this.mAdbWifiUri.equals(uri) == true) goto L13;
            return;
        L13:
            if (Settings.Global.getInt(AdbService.m974$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 0) <= 0) goto L15;
            shouldEnable2 = true;
        L15:
            FgThread.getHandler().sendMessage(PooledLambda.obtainMessage(new AdbService$AdbSettingsObserver$$ExternalSyntheticLambda0(), this.this$0, Boolean.valueOf(shouldEnable2), (byte) 1));
        }
    }

    public static class Lifecycle extends SystemService {
        private AdbService mAdbService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mAdbService = new AdbService(getContext(), null);
            publishBinderService("adb", this.mAdbService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 550) goto L6;
            this.mAdbService.systemReady();
            return;
        L6:
            if (phase != 1000) goto L10;
            FgThread.getHandler().sendMessage(PooledLambda.obtainMessage(new AdbService$Lifecycle$$ExternalSyntheticLambda0(), this.mAdbService));
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$xbcMIYeTKOftYJCcFP1Hzxo3GuY(boolean r0, byte r1, IAdbCallback r2) {
        lambda$setAdbEnabled$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m974$$Nest$fgetmContentResolver(AdbService r0) {
        return r0.mContentResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDebuggingManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdbDebuggingManager m975$$Nest$fgetmDebuggingManager(AdbService r0) {
        return r0.mDebuggingManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsAdbUsbEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m976$$Nest$fgetmIsAdbUsbEnabled(AdbService r0) {
        return r0.mIsAdbUsbEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsAdbWifiEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m977$$Nest$fgetmIsAdbWifiEnabled(AdbService r0) {
        return r0.mIsAdbWifiEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransports, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m978$$Nest$fgetmTransports(AdbService r0) {
        return r0.mTransports;
    }

    /* JADX INFO: renamed from: -$$Nest$msetAdbEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m979$$Nest$msetAdbEnabled(AdbService r0, boolean r1, byte r2) {
        r0.setAdbEnabled(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetAdbdEnabledForTransport, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m980$$Nest$msetAdbdEnabledForTransport(AdbService r0, boolean r1, byte r2) {
        r0.setAdbdEnabledForTransport(r1, r2);
    }

    /* synthetic */ AdbService(Context r1, AdbServiceIA r2) {
        this(r1);
    }

    private void registerContentObservers() {
        this.mObserver = new AdbSettingsObserver(this);     // Catch: Exception -> L4
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("adb_enabled"), false, this.mObserver);     // Catch: Exception -> L4
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("adb_wifi_enabled"), false, this.mObserver);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Error in registerContentObservers", e);
    }

    private static boolean containsFunction(String functions, String function) {
        int index = functions.indexOf(function);
        if (index >= 0) goto L6;
        return false;
    L6:
        if (index > 0) goto L8;
    L10:
        int charAfter = function.length() + index;
        if (charAfter < functions.length()) goto L13;
        return true;
    L13:
        if (functions.charAt(charAfter) == ',') goto L17;
        return false;
    L17:
        return true;
    L8:
        if (functions.charAt(index - 1) == ',') goto L10;
        return false;
    }

    static {
        TAG = AdbService.class.getSimpleName();
    }

    private AdbService(Context context) {
        this.mCallbacks = new RemoteCallbackList();
        this.mTransports = new ArrayMap();
        this.mAdbMulticastLock = null;
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        this.mDebuggingManager = new AdbDebuggingManager(context);
        registerContentObservers();
        LocalServices.addService(AdbManagerInternal.class, new AdbManagerInternalImpl(this, null));
    }

    public void systemReady() {
        Slog.d(TAG, "systemReady");
        this.mIsAdbUsbEnabled = containsFunction(SystemProperties.get(USB_PERSISTENT_CONFIG_PROPERTY, ""), "adb");
        int r1 = 1;
        if (this.mIsAdbUsbEnabled == false) goto L5;
    L8:
        boolean shouldEnableAdbUsb = true;
    L9:
        this.mIsAdbWifiEnabled = "1".equals(SystemProperties.get(WIFI_PERSISTENT_CONFIG_PROPERTY, "0"));
        ContentResolver r3 = this.mContentResolver;     // Catch: SecurityException -> L20
        if (shouldEnableAdbUsb == false) goto L13;
        int r5 = 1;
    L14:
        Settings.Global.putInt(r3, "adb_enabled", r5);     // Catch: SecurityException -> L20
        ContentResolver r4 = this.mContentResolver;     // Catch: SecurityException -> L20
        if (this.mIsAdbWifiEnabled == true) goto L18;
        r1 = 0;
    L18:
        Settings.Global.putInt(r4, "adb_wifi_enabled", r1);     // Catch: SecurityException -> L20
        return;
    L13:
        r5 = 0;
    L21:
        Slog.d(TAG, "ADB_ENABLED is restricted.");
        return;
    L5:
        if (SystemProperties.getBoolean(TestHarnessModeService.TEST_HARNESS_MODE_PROPERTY, false) == true) goto L8;
        shouldEnableAdbUsb = false;
        goto L9
    }

    public void bootCompleted() {
        Slog.d(TAG, "boot completed");
        this.mDebuggingManager.setAdbEnabled(this.mIsAdbUsbEnabled, (byte) 0);
        this.mDebuggingManager.setAdbEnabled(this.mIsAdbWifiEnabled, (byte) 1);
    }

    public void allowDebugging(boolean alwaysAllow, String publicKey) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        Preconditions.checkStringNotEmpty(publicKey);
        this.mDebuggingManager.allowDebugging(alwaysAllow, publicKey);
    }

    public void denyDebugging() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        this.mDebuggingManager.denyDebugging();
    }

    public void clearDebuggingKeys() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        this.mDebuggingManager.clearDebuggingKeys();
    }

    public boolean isAdbWifiSupported() {
        this.mContext.enforceCallingPermission("android.permission.MANAGE_DEBUGGING", "AdbService");
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.wifi") == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.ethernet") == true) goto L8;
        return false;
    }

    public boolean isAdbWifiQrSupported() {
        this.mContext.enforceCallingPermission("android.permission.MANAGE_DEBUGGING", "AdbService");
        if (isAdbWifiSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.any") == false) goto L7;
        return true;
    }

    public void allowWirelessDebugging(boolean alwaysAllow, String bssid) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        Preconditions.checkStringNotEmpty(bssid);
        this.mDebuggingManager.allowWirelessDebugging(alwaysAllow, bssid);
    }

    public void denyWirelessDebugging() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        this.mDebuggingManager.denyWirelessDebugging();
    }

    public FingerprintAndPairDevice[] getPairedDevices() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        Map<String, PairDevice> map = this.mDebuggingManager.getPairedDevices();
        FingerprintAndPairDevice[] ret = new FingerprintAndPairDevice[map.size()];
        int i = 0;
        Iterator<Map.Entry<String, PairDevice>> r3 = map.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<String, PairDevice> entry = r3.next();
        ret[i] = new FingerprintAndPairDevice();
        FingerprintAndPairDevice r5 = ret[i];
        r5.keyFingerprint = entry.getKey();
        FingerprintAndPairDevice r6 = ret[i];
        r6.device = entry.getValue();
        i = i + 1;
        goto L4
    L6:
        return ret;
    }

    public void unpairDevice(String fingerprint) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        Preconditions.checkStringNotEmpty(fingerprint);
        this.mDebuggingManager.unpairDevice(fingerprint);
    }

    public void enablePairingByPairingCode() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        this.mDebuggingManager.enablePairingByPairingCode();
    }

    public void enablePairingByQrCode(String serviceName, String password) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        Preconditions.checkStringNotEmpty(serviceName);
        Preconditions.checkStringNotEmpty(password);
        this.mDebuggingManager.enablePairingByQrCode(serviceName, password);
    }

    public void disablePairing() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        this.mDebuggingManager.disablePairing();
    }

    public int getAdbWirelessPort() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DEBUGGING", null);
        return this.mDebuggingManager.getAdbWirelessPort();
    }

    public void registerCallback(IAdbCallback callback) throws RemoteException {
        Slog.d(TAG, "Registering callback " + callback);
        this.mCallbacks.register(callback);
    }

    public void unregisterCallback(IAdbCallback callback) throws RemoteException {
        Slog.d(TAG, "Unregistering callback " + callback);
        this.mCallbacks.unregister(callback);
    }

    private void startAdbd() {
        SystemProperties.set(CTL_START, ADBD);
    }

    private void stopAdbd() {
        if (this.mIsAdbUsbEnabled == false) goto L5;
        return;
    L5:
        if (this.mIsAdbWifiEnabled == true) goto L9;
        SystemProperties.set(CTL_STOP, ADBD);
        return;
    }

    private void setAdbdEnabledForTransport(boolean enable, byte transportType) {
        if (transportType != 0) goto L5;
        this.mIsAdbUsbEnabled = enable;
    L7:
        if (enable == false) goto L9;
        startAdbd();
        return;
    L9:
        stopAdbd();
        return;
    L5:
        if (transportType != 1) goto L7;
        this.mIsAdbWifiEnabled = enable;
        goto L7
    }

    private void acquireMulticastLock() {
        if (this.mAdbMulticastLock != null) goto L6;
        WifiManager wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
        this.mAdbMulticastLock = wifiManager.createMulticastLock("AdbMulticastLock");
    L6:
        if (this.mAdbMulticastLock.isHeld() == true) goto L9;
        this.mAdbMulticastLock.acquire();
        Slog.d(TAG, "Acquired multicast lock");
        return;
    }

    private void releaseMulticastLock() {
        if (this.mAdbMulticastLock != null) goto L5;
        return;
    L5:
        if (this.mAdbMulticastLock.isHeld() == false) goto L9;
        this.mAdbMulticastLock.release();
        Slog.d(TAG, "Released multicast lock");
        return;
    }

    private void setAdbEnabled(final boolean enable, final byte transportType) {
        Slog.d(TAG, "setAdbEnabled(" + enable + "), mIsAdbUsbEnabled=" + this.mIsAdbUsbEnabled + ", mIsAdbWifiEnabled=" + this.mIsAdbWifiEnabled + ", transportType=" + transportType);
        if (transportType != 0) goto L8;
        if (enable == this.mIsAdbUsbEnabled) goto L8;
        this.mIsAdbUsbEnabled = enable;
    L15:
        if (enable == false) goto L17;
        startAdbd();
    L18:
        Iterator<IAdbTransport> r0 = this.mTransports.values().iterator();
    L20:
        if (r0.hasNext() == false) goto L27;
        IAdbTransport transport = r0.next();
        transport.onAdbEnabled(enable, transportType);     // Catch: RemoteException -> L24
    L25:
        Slog.w(TAG, "Unable to send onAdbEnabled to transport " + transport.toString());
        goto L20
    L27:
        this.mDebuggingManager.setAdbEnabled(enable, transportType);
        Slog.d(TAG, "Broadcasting enable = " + enable + ", type = " + transportType);
        this.mCallbacks.broadcast(new AdbService$$ExternalSyntheticLambda0(enable, transportType));
        return;
    L17:
        stopAdbd();
    L8:
        if (transportType == 1) goto L10;
        return;
    L10:
        if (enable == this.mIsAdbWifiEnabled) goto L36;
        this.mIsAdbWifiEnabled = enable;
        if (this.mIsAdbWifiEnabled == false) goto L14;
        SystemProperties.set(WIFI_PERSISTENT_CONFIG_PROPERTY, "1");
        acquireMulticastLock();
        goto L15
    L14:
        SystemProperties.set(WIFI_PERSISTENT_CONFIG_PROPERTY, "0");
        releaseMulticastLock();
        goto L15
    }

    private static /* synthetic */ void lambda$setAdbEnabled$0(boolean enable, byte transportType, IAdbCallback callback) {
        Slog.d(TAG, "Sending enable = " + enable + ", type = " + transportType + " to " + callback);
        callback.onDebuggingChanged(enable, transportType);     // Catch: RemoteException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "Unable to send onDebuggingChanged:", ex);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
        return new AdbShellCommand(this).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
        long ident = Binder.clearCallingIdentity();
        ArraySet<String> argsSet = new ArraySet();     // Catch: Throwable -> L16
        Collections.addAll(argsSet, args);     // Catch: Throwable -> L16
        boolean dumpAsProto = false;
        if (argsSet.contains("--proto") == false) goto L10;
        dumpAsProto = true;
    L10:
        if (argsSet.size() == 0) goto L18;
        if (argsSet.contains("-a") == true) goto L18;
        if (dumpAsProto == true) goto L18;
        pw.println("Dump current ADB state");     // Catch: Throwable -> L16
        pw.println("  No commands available");     // Catch: Throwable -> L16
    L22:
        Binder.restoreCallingIdentity(ident);
        return;
    L18:
        if (dumpAsProto == false) goto L20;
        DualDumpOutputStream dump = new DualDumpOutputStream(new ProtoOutputStream(fd));     // Catch: Throwable -> L16
    L21:
        this.mDebuggingManager.dump(dump, "debugging_manager", 1146756268033L);     // Catch: Throwable -> L16
        dump.flush();     // Catch: Throwable -> L16
        goto L22
    L20:
        pw.println("ADB MANAGER STATE (dumpsys adb):");     // Catch: Throwable -> L16
        dump = new DualDumpOutputStream(new IndentingPrintWriter(pw, "  "));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }
}
