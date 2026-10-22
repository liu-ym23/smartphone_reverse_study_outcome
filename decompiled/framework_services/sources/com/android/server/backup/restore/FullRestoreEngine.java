package com.android.server.backup.restore;

import android.app.IBackupAgent;
import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IFullBackupRestoreObserver;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.provider.Settings;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.backup.BackupAgentConnectionManager;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.FileMetadata;
import com.android.server.backup.KeyValueAdbRestoreEngine;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.fullbackup.FullBackupObbConnection;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.backup.utils.BytesReadListener;
import com.android.server.backup.utils.FullBackupRestoreObserverUtils;
import com.android.server.backup.utils.RestoreUtils;
import com.android.server.backup.utils.TarBackupReader;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FullRestoreEngine extends RestoreEngine {
    private IBackupAgent mAgent;
    private String mAgentPackage;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    final boolean mAllowApks;
    private long mAppVersion;
    private final BackupEligibilityRules mBackupEligibilityRules;
    private BackupManagerMonitorEventSender mBackupManagerMonitorEventSender;
    private final UserBackupManagerService mBackupManagerService;
    final byte[] mBuffer;
    private final HashSet<String> mClearedPackages;
    private final RestoreDeleteObserver mDeleteObserver;
    final int mEphemeralOpToken;
    private final boolean mIsAdbRestore;
    private final HashMap<String, Signature[]> mManifestSignatures;
    final IBackupManagerMonitor mMonitor;
    private final BackupRestoreTask mMonitorTask;
    private FullBackupObbConnection mObbConnection;
    private IFullBackupRestoreObserver mObserver;
    final PackageInfo mOnlyPackage;
    private final OperationStorage mOperationStorage;
    private final HashMap<String, String> mPackageInstallers;
    private final HashMap<String, RestorePolicy> mPackagePolicies;
    private ParcelFileDescriptor[] mPipes;
    private boolean mPipesClosed;
    private final Object mPipesLock;
    private FileMetadata mReadOnlyParent;
    private ApplicationInfo mTargetApp;
    private final int mUserId;
    private byte[] mWidgetData;

    /* JADX INFO: renamed from: com.android.server.backup.restore.FullRestoreEngine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$backup$restore$RestorePolicy = null;

        static {
            $SwitchMap$com$android$server$backup$restore$RestorePolicy = new int[RestorePolicy.values().length];
            $SwitchMap$com$android$server$backup$restore$RestorePolicy[RestorePolicy.IGNORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$com$android$server$backup$restore$RestorePolicy[RestorePolicy.ACCEPT_IF_APK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$com$android$server$backup$restore$RestorePolicy[RestorePolicy.ACCEPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$mvOpQ8iGB4ZvFtqRrTmz7hGfVD8(long r0) {
        lambda$restoreOneFile$0(r0);
    }

    public FullRestoreEngine(UserBackupManagerService backupManagerService, OperationStorage operationStorage, BackupRestoreTask monitorTask, IFullBackupRestoreObserver observer, IBackupManagerMonitor monitor, PackageInfo onlyPackage, boolean allowApks, int ephemeralOpToken, boolean isAdbRestore, BackupEligibilityRules backupEligibilityRules) {
        this.mDeleteObserver = new RestoreDeleteObserver();
        this.mObbConnection = null;
        this.mPackagePolicies = new HashMap();
        this.mPackageInstallers = new HashMap();
        this.mManifestSignatures = new HashMap();
        this.mClearedPackages = new HashSet();
        this.mPipes = null;
        this.mPipesLock = new Object();
        this.mWidgetData = null;
        this.mReadOnlyParent = null;
        this.mBackupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mEphemeralOpToken = ephemeralOpToken;
        this.mMonitorTask = monitorTask;
        this.mObserver = observer;
        this.mMonitor = monitor;
        this.mBackupManagerMonitorEventSender = new BackupManagerMonitorEventSender(monitor);
        this.mOnlyPackage = onlyPackage;
        this.mAllowApks = allowApks;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
        this.mIsAdbRestore = isAdbRestore;
        this.mUserId = backupManagerService.getUserId();
        this.mBackupEligibilityRules = backupEligibilityRules;
        this.mBuffer = new byte[65536];
    }

    FullRestoreEngine() {
        this.mDeleteObserver = new RestoreDeleteObserver();
        this.mObbConnection = null;
        this.mPackagePolicies = new HashMap();
        this.mPackageInstallers = new HashMap();
        this.mManifestSignatures = new HashMap();
        this.mClearedPackages = new HashSet();
        this.mPipes = null;
        this.mPipesLock = new Object();
        this.mWidgetData = null;
        this.mReadOnlyParent = null;
        this.mIsAdbRestore = false;
        this.mAllowApks = false;
        this.mEphemeralOpToken = 0;
        this.mUserId = 0;
        this.mBackupEligibilityRules = null;
        this.mAgentTimeoutParameters = null;
        this.mBuffer = null;
        this.mBackupManagerService = null;
        this.mOperationStorage = null;
        this.mMonitor = null;
        this.mMonitorTask = null;
        this.mOnlyPackage = null;
    }

    public IBackupAgent getAgent() {
        return this.mAgent;
    }

    public byte[] getWidgetData() {
        return this.mWidgetData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 40, insn: 0x010a: MOVE (r14 I:??[OBJECT, ARRAY]) = (r40 I:??[OBJECT, ARRAY]), block:B:36:0x0106 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public boolean restoreOneFile(InputStream r56, boolean r57, byte[] r58, PackageInfo r59, boolean r60, int r61, IBackupManagerMonitor r62) {
        boolean r0 = isRunning();
        String r14 = BackupManagerService.TAG;
        if (r0 == true) goto L6;
        Slog.w(BackupManagerService.TAG, "Restore engine used after halting");
        return false;
    L6:
        BytesReadListener r9 = new FullRestoreEngine$$ExternalSyntheticLambda0();
        IBackupManagerMonitor r15 = r62;
        TarBackupReader r1 = new TarBackupReader(r56, r9, r15);
        FileMetadata r7 = r1.readTarHeaders();     // Catch: IOException -> L248
        if (r7 == null) goto L254;
        r15 = r7.packageName;     // Catch: IOException -> L248
        if (r15.equals(this.mAgentPackage) == true) goto L25;
        if (r59 == null) goto L20;
    L17:
        e = e;
        ?? r16 = r14;
    L253:
        Slog.w(r16, "io exception on restore socket read: " + e.getMessage());
        logBMMEvent(81, r59);
        setResult(-3);
        r7 = null;
        goto L254
    L14:
        if (r15.equals(r59.packageName) == true) goto L20;
        logBMMEvent(76, r59);     // Catch: IOException -> L17
        Slog.w(BackupManagerService.TAG, "Expected data for " + r59 + " but saw " + r15);     // Catch: IOException -> L17
        setResult(-3);     // Catch: IOException -> L17
        setRunning(false);     // Catch: IOException -> L17
        return false;
    L20:
        if (this.mPackagePolicies.containsKey(r15) == true) goto L23;
        this.mPackagePolicies.put(r15, RestorePolicy.IGNORE);     // Catch: IOException -> L17
    L23:
        if (this.mAgent == null) goto L25;
        Slog.d(BackupManagerService.TAG, "Saw new package; finalizing old one");     // Catch: IOException -> L17
        tearDownPipes();     // Catch: IOException -> L17
        tearDownAgent(this.mTargetApp, this.mIsAdbRestore);     // Catch: IOException -> L17
        this.mTargetApp = null;     // Catch: IOException -> L17
        this.mAgentPackage = null;     // Catch: IOException -> L17
    L25:
        if (r7.path.equals(UserBackupManagerService.BACKUP_MANIFEST_FILENAME) == false) goto L293;
        Signature[] r20 = r1.readAppManifestAndReturnSignatures(r7);     // Catch: IOException -> L42
        this.mAppVersion = r7.version;     // Catch: IOException -> L39
        RestorePolicy r2 = r1.chooseRestorePolicy(this.mBackupManagerService.getPackageManager(), r60, r7, r20, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), this.mUserId, this.mBackupEligibilityRules, this.mBackupManagerService.getContext());     // Catch: IOException -> L37
        this.mManifestSignatures.put(r7.packageName, r20);     // Catch: IOException -> L35
        this.mPackagePolicies.put(r15, r2);     // Catch: IOException -> L35
        this.mPackageInstallers.put(r15, r7.installerPackageName);     // Catch: IOException -> L35
        r1.skipTarPadding(r7.size);     // Catch: IOException -> L35
        this.mObserver = FullBackupRestoreObserverUtils.sendOnRestorePackage(this.mObserver, r15);     // Catch: IOException -> L35
    L37:
        e = e;
        r16 = BackupManagerService.TAG;
    L39:
        e = e;
        r16 = BackupManagerService.TAG;
    L42:
        e = e;
        r16 = r14;
        goto L253
    L293:
    L246:
        e = e;
        String r17 = BackupManagerService.TAG;
    L217:
        r15 = r62;
        r16 = r17;
        goto L253
    L46:
        if (r7.path.equals(UserBackupManagerService.BACKUP_METADATA_FILENAME) == false) goto L53;
        r1.readMetadata(r7);     // Catch: IOException -> L35
        this.mWidgetData = r1.getWidgetData();     // Catch: IOException -> L35
        IBackupManagerMonitor r3 = r1.getMonitor();     // Catch: IOException -> L35
        r1.skipTarPadding(r7.size);     // Catch: IOException -> L51
    L51:
        e = e;
        r15 = r3;
        r16 = BackupManagerService.TAG;
        goto L253
    L53:
        boolean r4 = true;
        ?? r18 = this.mPackagePolicies.get(r15);     // Catch: IOException -> L246
        switch(AnonymousClass1.$SwitchMap$com$android$server$backup$restore$RestorePolicy[r18.ordinal()]) {
            case 1: goto L90;
            case 2: goto L273;
            case 3: goto L64;
            default: goto L58;
        };
    L64:
        String r10 = BackupManagerService.TAG;
        if (r7.domain.equals(ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD) == false) goto L68;
        Slog.d(r10, "apk present but ACCEPT");     // Catch: IOException -> L60
        r4 = false;
        String r19 = r10;
    L271:
    L282:
    L224:
        e = e;
        r17 = r19;
        goto L217
    L92:
        if (isRestorableFile(r7) == false) goto L97;
        if (isCanonicalFilePath(r7.path) == false) goto L97;
        boolean r5 = r4;
    L98:
        if (r5 == true) goto L100;
    L114:
        if (r5 == false) goto L120;
        if (r15.equals(this.mAgentPackage) == true) goto L120;
        Slog.e(r19, "Restoring data for " + r15 + " but agent is for " + this.mAgentPackage);     // Catch: IOException -> L79
        r5 = false;
    L120:
        if (shouldSkipReadOnlyDir(r7) == false) goto L122;
        r5 = false;
    L122:
        if (r5 == false) goto L232;
        boolean r8 = true;
        long r110 = 0;
        long r6 = r7.size;     // Catch: IOException -> L224
        if (r15.equals(UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE) == true) goto L127;
        long r21 = this.mAgentTimeoutParameters.getRestoreAgentTimeoutMillis(this.mTargetApp.uid);     // Catch: IOException -> L224
    L306:
        this.mBackupManagerService.prepareOperationTimeout(r61, r21, this.mMonitorTask, 1);     // Catch: RemoteException -> L180 IOException -> L182
    L304:
        if ("obb".equals(r7.domain) == false) goto L159;
        StringBuilder r11 = new StringBuilder();     // Catch: RemoteException -> L155 IOException -> L157
        boolean r23 = r5;
        r11.append("Restoring OBB file for ");     // Catch: RemoteException -> L151 IOException -> L153
        r11.append(r15);     // Catch: RemoteException -> L151 IOException -> L153
        r11.append(" : ");     // Catch: RemoteException -> L151 IOException -> L153
        r11.append(r7.path);     // Catch: RemoteException -> L151 IOException -> L153
        Slog.d(r19, r11.toString());     // Catch: RemoteException -> L151 IOException -> L153
        long r53 = r6;
        IBackupManagerMonitor r27 = r15;
        this.mObbConnection.restoreObbFile(r27, this.mPipes[0], r7.size, r7.type, r7.path, r7.mode, r7.mtime, r61, this.mBackupManagerService.getBackupManagerBinder());     // Catch: RemoteException -> L143 IOException -> L145
    L179:
        boolean r29 = r23;
    L189:
        if (r29 == false) goto L226;
        FileOutputStream r12 = new FileOutputStream(this.mPipes[1].getFileDescriptor());     // Catch: IOException -> L224
        boolean r24 = true;
        long r13 = r53;
    L193:
        if (r13 <= 0) goto L219;
        boolean r26 = r8;
        BytesReadListener r25 = r9;
        if (r13 > r58.length) goto L289;
        int r22 = (int) r13;     // Catch: IOException -> L198
    L202:
        int r28 = r56.read(r58, 0, r22);     // Catch: IOException -> L198
        if (r28 <= 0) goto L219;
        r13 = r13 - ((long) r28);
        if (r24 == false) goto L213;
        boolean r210 = r29;
        r12.write(r58, 0, r28);     // Catch: IOException -> L211
    L214:
        r9 = r25;
        r8 = r26;
        r29 = r210;
    L211:
        e = move-exception;
        Slog.e(r19, "Failed to write to restore pipe: " + e.getMessage());     // Catch: IOException -> L198
        logBMMEvent(79, r59);     // Catch: IOException -> L198
        r24 = false;
    L198:
        e = e;
    L200:
        r15 = r62;
        r16 = r19;
        goto L253
    L213:
        r210 = r29;
        goto L214
    L289:
        r22 = r58.length;     // Catch: IOException -> L198
    L215:
        e = e;
        r17 = r19;
    L219:
        r1.skipTarPadding(r7.size);     // Catch: IOException -> L198
        r8 = this.mBackupManagerService.waitUntilOperationComplete(r61);     // Catch: IOException -> L222
    L227:
        if (r8 == true) goto L233;
        logBMMEvent(80, r59);     // Catch: IOException -> L222
        Slog.w(r19, "Agent failure restoring " + r15 + "; ending restore");     // Catch: IOException -> L222
        this.mBackupManagerService.getBackupHandler().removeMessages(18);     // Catch: IOException -> L222
        tearDownPipes();     // Catch: IOException -> L222
        tearDownAgent(this.mTargetApp, false);     // Catch: IOException -> L222
        this.mAgent = null;     // Catch: IOException -> L222
        this.mPackagePolicies.put(r15, RestorePolicy.IGNORE);     // Catch: IOException -> L222
        if (r59 == null) goto L233;
        setResult(-2);     // Catch: IOException -> L222
        setRunning(false);     // Catch: IOException -> L222
        return false;
    L233:
        if (r29 == true) goto L254;
        long r30 = (r7.size + 511) & (-512);     // Catch: IOException -> L222
    L236:
        if (r30 <= r110) goto L254;
        if (r30 <= r58.length) goto L240;
        int r31 = r58.length;     // Catch: IOException -> L222
    L242:
        long r32 = r56.read(r58, 0, r31);     // Catch: IOException -> L222
        if (r32 <= r110) goto L254;
        r30 = r30 - r32;
        goto L236
    L240:
        r31 = (int) r30;     // Catch: IOException -> L222
    L222:
        e = e;
        goto L200
    L226:
        r29 = r29;
        goto L227
    L144:
        r15 = r27;
    L146:
        r15 = r27;
        goto L188
    L152:
        r53 = r6;
    L154:
        r53 = r6;
        goto L188
    L159:
        r23 = r5;
        r53 = r6;
        if ("k".equals(r7.domain) == false) goto L172;
        Slog.d(r19, "Restoring key-value file for " + r15 + " : " + r7.path);     // Catch: RemoteException -> L147 IOException -> L149
        r7.version = this.mAppVersion;     // Catch: RemoteException -> L147 IOException -> L149
        FileMetadata r211 = r7;
        new Thread(new KeyValueAdbRestoreEngine(this.mBackupManagerService, this.mBackupManagerService.getDataDir(), r211, this.mPipes[0], this.mAgent, r61), "restore-key-value-runner").start();     // Catch: RemoteException -> L147 IOException -> L149
    L297:
    L172:
        if (this.mTargetApp.processName.equals("system") == false) goto L178;
        Slog.d(r19, "system process agent - spinning a thread");     // Catch: RemoteException -> L147 IOException -> L149
        r211 = r7;
        new Thread(new RestoreFileRunnable(this.mBackupManagerService, this.mAgent, r211, this.mPipes[0], r61), "restore-sys-runner").start();     // Catch: RemoteException -> L147 IOException -> L149
        goto L297
    L178:
        this.mAgent.doRestoreFile(this.mPipes[0], r7.size, r7.type, r7.domain, r7.path, r7.mode, r7.mtime, r61, this.mBackupManagerService.getBackupManagerBinder());     // Catch: RemoteException -> L147 IOException -> L149
    L168:
        r7 = r211;
    L170:
        r7 = r211;
    L185:
        logBMMEvent(78, r59);     // Catch: IOException -> L79
        Slog.e(r19, "Agent crashed during full restore");     // Catch: IOException -> L79
        r8 = false;
        r29 = false;
    L188:
        Slog.d(r19, "Couldn't establish restore");     // Catch: IOException -> L224
        r8 = false;
        r29 = false;
    L156:
        r53 = r6;
    L158:
        r53 = r6;
    L181:
        r53 = r6;
    L183:
        r53 = r6;
        goto L188
    L127:
        r21 = this.mAgentTimeoutParameters.getSharedBackupAgentTimeoutMillis();     // Catch: IOException -> L79
        goto L306
    L232:
        r110 = 0;
        r29 = r5;
        goto L233
    L100:
        if (this.mAgent != null) goto L114;
        this.mTargetApp = this.mBackupManagerService.getPackageManager().getApplicationInfoAsUser(r15, 0, this.mUserId);     // Catch: Throwable -> L108
        if (this.mClearedPackages.contains(r15) == true) goto L110;
        boolean r33 = shouldForceClearAppDataOnFullRestore(this.mTargetApp.packageName);     // Catch: Throwable -> L108
        if (this.mTargetApp.backupAgentName == null) goto L106;
        if (r33 == true) goto L106;
    L107:
        this.mClearedPackages.add(r15);     // Catch: Throwable -> L108
    L106:
        Slog.d(r19, "Clearing app data preparatory to full restore");     // Catch: Throwable -> L108
        this.mBackupManagerService.clearApplicationDataBeforeRestore(r15);     // Catch: Throwable -> L108
    L110:
        setUpPipes();     // Catch: Throwable -> L108
        this.mAgent = bindToAgent(r7);     // Catch: Throwable -> L108
        this.mAgentPackage = r15;     // Catch: Throwable -> L108
    L112:
        if (this.mAgent != null) goto L114;
        logBMMEvent(77, r59);     // Catch: IOException -> L79
        Slog.e(r19, "Unable to create agent for " + r15);     // Catch: IOException -> L79
        r5 = false;
        tearDownPipes();     // Catch: IOException -> L79
        this.mPackagePolicies.put(r15, RestorePolicy.IGNORE);     // Catch: IOException -> L79
    L97:
        r5 = false;
        goto L98
    L68:
        r19 = r10;
        goto L271
    L90:
        r15 = r15;
        r19 = BackupManagerService.TAG;
        r4 = false;
        goto L282
    L58:
        r10 = BackupManagerService.TAG;
        Slog.e(r10, "Invalid policy from manifest");     // Catch: IOException -> L60
        r4 = false;
        this.mPackagePolicies.put(r15, RestorePolicy.IGNORE);     // Catch: IOException -> L60
        r19 = r10;
        goto L271
    L273:
    L86:
        e = e;
        r18 = BackupManagerService.TAG;
    L80:
        r15 = r62;
        r16 = r18;
        goto L253
    L71:
        if (r7.domain.equals(ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD) == false) goto L88;
        Slog.d(BackupManagerService.TAG, "APK file; installing");     // Catch: IOException -> L86
        boolean r34 = RestoreUtils.installApk(r56, this.mBackupManagerService.getContext(), this.mDeleteObserver, this.mManifestSignatures, this.mPackagePolicies, r7, this.mPackageInstallers.get(r15), r9, this.mUserId);     // Catch: IOException -> L79
        HashMap<String, RestorePolicy> r35 = this.mPackagePolicies;     // Catch: IOException -> L79
        if (r34 == false) goto L81;
        RestorePolicy r36 = RestorePolicy.ACCEPT;     // Catch: IOException -> L79
    L82:
        r35.put(r15, r36);     // Catch: IOException -> L79
        r1.skipTarPadding(r7.size);     // Catch: IOException -> L79
        return true;
    L81:
        r36 = RestorePolicy.IGNORE;     // Catch: IOException -> L79
    L84:
        e = e;
        r18 = BackupManagerService.TAG;
        goto L80
    L88:
        r15 = r15;
        r19 = BackupManagerService.TAG;
        this.mPackagePolicies.put(r15, RestorePolicy.IGNORE);     // Catch: IOException -> L79
        r4 = false;
    L79:
        e = e;
    L60:
        e = e;
        r16 = r10;
    L35:
        e = e;
        r16 = r40;
    L254:
        if (r7 != null) goto L258;
        tearDownPipes();
        boolean r37 = false;
        setRunning(false);
        if (r57 == false) goto L259;
        tearDownAgent(this.mTargetApp, this.mIsAdbRestore);
    L259:
        if (r7 == null) goto L262;
        return true;
    L262:
        return r37;
    L258:
        r37 = false;
    L248:
        e = e;
        r15 = r62;
        r16 = r14;
        goto L253
    }

    private static /* synthetic */ void lambda$restoreOneFile$0(long bytesRead) {
    }

    boolean shouldSkipReadOnlyDir(FileMetadata info) {
        if (isValidParent(this.mReadOnlyParent, info) == false) goto L6;
        return true;
    L6:
        if (isReadOnlyDir(info) == false) goto L9;
        this.mReadOnlyParent = info;
        Slog.w(BackupManagerService.TAG, "Skipping restore of " + info.path + " and its contents as read-only dirs are currently not supported.");
        return true;
    L9:
        this.mReadOnlyParent = null;
        return false;
    }

    private void logBMMEvent(int eventId, PackageInfo pkgInfo) {
    }

    private static boolean isValidParent(FileMetadata parentDir, FileMetadata childDir) {
        if (parentDir != null) goto L4;
    L10:
        return false;
    L4:
        if (childDir.packageName.equals(parentDir.packageName) == false) goto L10;
        if (childDir.domain.equals(parentDir.domain) == false) goto L10;
        if (childDir.path.startsWith(getPathWithTrailingSeparator(parentDir.path)) == false) goto L10;
        return true;
    }

    private static String getPathWithTrailingSeparator(String path) {
        if (path.endsWith(File.separator) == false) goto L6;
        return path;
    L6:
        return path + File.separator;
    }

    private static boolean isReadOnlyDir(FileMetadata file) {
        if (file.type == 2) goto L5;
    L7:
        return false;
    L5:
        if ((file.mode & ((long) OsConstants.S_IWUSR)) != 0) goto L7;
        return true;
    }

    private void setUpPipes() throws IOException {
        Object r0 = this.mPipesLock;
        monitor-enter(r0);
        this.mPipes = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L7
        this.mPipesClosed = false;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void tearDownPipes() {
        Object r0 = this.mPipesLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPipesClosed == false) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        if (this.mPipes == null) goto L14;
        this.mPipes[0].close();     // Catch: Throwable -> L10 IOException -> L12
        this.mPipes[1].close();     // Catch: Throwable -> L10 IOException -> L12
        this.mPipesClosed = true;     // Catch: Throwable -> L10 IOException -> L12
    L12:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Couldn't close agent pipes", e);     // Catch: Throwable -> L10
        goto L14
    }

    private void tearDownAgent(ApplicationInfo app, boolean doRestoreFinished) {
        if (this.mAgent == null) goto L19;
        if (doRestoreFinished == true) goto L17;
    L12:
        this.mBackupManagerService.getBackupAgentConnectionManager().unbindAgent(app, true);     // Catch: RemoteException -> L8
    L15:
        this.mAgent = null;
        return;
    L14:
        Slog.d(BackupManagerService.TAG, "Lost app trying to shut down");
        goto L15
    L17:
        int token = this.mBackupManagerService.generateRandomIntegerToken();     // Catch: RemoteException -> L8
        long fullBackupAgentTimeoutMillis = this.mAgentTimeoutParameters.getFullBackupAgentTimeoutMillis();     // Catch: RemoteException -> L8
        AdbRestoreFinishedLatch latch = new AdbRestoreFinishedLatch(this.mBackupManagerService, this.mOperationStorage, token);     // Catch: RemoteException -> L8
        this.mBackupManagerService.prepareOperationTimeout(token, fullBackupAgentTimeoutMillis, latch, 1);     // Catch: RemoteException -> L8
        if (this.mTargetApp.processName.equals("system") == false) goto L10;
        Runnable runner = new AdbRestoreFinishedRunnable(this.mAgent, token, this.mBackupManagerService);     // Catch: RemoteException -> L8
        new Thread(runner, "restore-sys-finished-runner").start();     // Catch: RemoteException -> L8
    L11:
        latch.await();     // Catch: RemoteException -> L8
        goto L12
    L10:
        this.mAgent.doRestoreFinished(token, this.mBackupManagerService.getBackupManagerBinder());     // Catch: RemoteException -> L8
        goto L11
    }

    void handleTimeout() {
        tearDownPipes();
        setResult(-2);
        setRunning(false);
    }

    private boolean isRestorableFile(FileMetadata info) {
        if (this.mBackupEligibilityRules.getBackupDestination() != 1) goto L6;
        return true;
    L6:
        if ("c".equals(info.domain) == false) goto L9;
        return false;
    L9:
        if (ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD.equals(info.domain) == true) goto L11;
    L13:
        return true;
    L11:
        if (info.path.startsWith("no_backup/") == false) goto L13;
        return false;
    }

    private static boolean isCanonicalFilePath(String path) {
        if (path.contains("..") == false) goto L5;
        return false;
    L5:
        if (path.contains("//") == true) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean shouldForceClearAppDataOnFullRestore(String packageName) {
        String packageListString = Settings.Secure.getStringForUser(this.mBackupManagerService.getContext().getContentResolver(), "packages_to_clear_data_before_full_restore", this.mUserId);
        if (TextUtils.isEmpty(packageListString) == false) goto L6;
        return false;
    L6:
        List<String> packages = Arrays.asList(packageListString.split(";"));
        return packages.contains(packageName);
    }

    private IBackupAgent bindToAgent(FileMetadata info) {
        BackupAgentConnectionManager r0 = this.mBackupManagerService.getBackupAgentConnectionManager();
        ApplicationInfo r1 = this.mTargetApp;
        if ("k".equals(info.domain) == false) goto L5;
        int r2 = 2;
    L7:
        return r0.bindToAgentSynchronous(r1, r2, this.mBackupEligibilityRules.getBackupDestination());
    L5:
        r2 = 3;
        goto L7
    }
}
