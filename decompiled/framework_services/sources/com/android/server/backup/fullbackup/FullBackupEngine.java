package com.android.server.backup.fullbackup;

import android.app.IBackupAgent;
import android.app.backup.FullBackupDataOutput;
import android.app.backup.IBackupCallback;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.AppWidgetBackupBridge;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.remote.RemoteCall;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.backup.utils.FullBackupUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FullBackupEngine {
    private UserBackupManagerService backupManagerService;
    private IBackupAgent mAgent;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private final BackupEligibilityRules mBackupEligibilityRules;
    private final BackupManagerMonitorEventSender mBackupManagerMonitorEventSender;
    private boolean mIncludeApks;
    private final int mOpToken;
    private OutputStream mOutput;
    private final PackageInfo mPkg;
    private FullBackupPreflight mPreflightHook;
    private final long mQuota;
    private BackupRestoreTask mTimeoutMonitor;
    private final int mTransportFlags;

    class FullBackupRunner implements Runnable {
        private final IBackupAgent mAgent;
        private final File mFilesDir;
        private final boolean mIncludeApks;
        private final PackageInfo mPackage;
        private final PackageManager mPackageManager;
        private final ParcelFileDescriptor mPipe;
        private final int mToken;
        private final int mUserId;
        final /* synthetic */ FullBackupEngine this$0;

        FullBackupRunner(FullBackupEngine this$0, UserBackupManagerService userBackupManagerService, PackageInfo packageInfo, IBackupAgent agent, ParcelFileDescriptor pipe, int token, boolean includeApks) throws IOException {
            this.this$0 = this$0;
            this.mUserId = userBackupManagerService.getUserId();
            this.mPackageManager = FullBackupEngine.m2521$$Nest$fgetbackupManagerService(this$0).getPackageManager();
            this.mPackage = packageInfo;
            this.mAgent = agent;
            this.mPipe = ParcelFileDescriptor.dup(pipe.getFileDescriptor());
            this.mToken = token;
            this.mIncludeApks = includeApks;
            this.mFilesDir = userBackupManagerService.getDataDir();
        }

        @Override // java.lang.Runnable
        public void run() {
            FullBackupDataOutput output = new FullBackupDataOutput(this.mPipe, -1, FullBackupEngine.m2525$$Nest$fgetmTransportFlags(this.this$0));     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            AppMetadataBackupWriter appMetadataBackupWriter = new AppMetadataBackupWriter(output, this.mPackageManager);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            String packageName = this.mPackage.packageName;     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            boolean isSharedStorage = UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE.equals(packageName);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            boolean writeApk = shouldWriteApk(this.mPackage.applicationInfo, this.mIncludeApks, isSharedStorage);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            if (isSharedStorage == true) goto L16;
            File manifestFile = new File(this.mFilesDir, UserBackupManagerService.BACKUP_MANIFEST_FILENAME);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            appMetadataBackupWriter.backupManifest(this.mPackage, manifestFile, this.mFilesDir, writeApk);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            manifestFile.delete();     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            byte[] widgetData = AppWidgetBackupBridge.getWidgetState(packageName, this.mUserId);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            if (widgetData == null) goto L16;
            if (widgetData.length <= 0) goto L16;
            File metadataFile = new File(this.mFilesDir, UserBackupManagerService.BACKUP_METADATA_FILENAME);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            appMetadataBackupWriter.backupWidget(this.mPackage, metadataFile, this.mFilesDir, widgetData);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            metadataFile.delete();     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
        L16:
            if (writeApk == false) goto L18;
            appMetadataBackupWriter.backupApk(this.mPackage);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            appMetadataBackupWriter.backupObb(this.mUserId, this.mPackage);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
        L18:
            Slog.d(BackupManagerService.TAG, "Calling doFullBackup() on " + packageName);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            if (isSharedStorage == false) goto L21;
            long r7 = FullBackupEngine.m2522$$Nest$fgetmAgentTimeoutParameters(this.this$0).getSharedBackupAgentTimeoutMillis();     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
        L22:
            long timeout = r7;
            FullBackupEngine.m2521$$Nest$fgetbackupManagerService(this.this$0).prepareOperationTimeout(this.mToken, timeout, FullBackupEngine.m2524$$Nest$fgetmTimeoutMonitor(this.this$0), 0);     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            this.mAgent.doFullBackup(this.mPipe, FullBackupEngine.m2523$$Nest$fgetmQuota(this.this$0), this.mToken, FullBackupEngine.m2521$$Nest$fgetbackupManagerService(this.this$0).getBackupManagerBinder(), FullBackupEngine.m2525$$Nest$fgetmTransportFlags(this.this$0));     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
            this.mPipe.close();     // Catch: IOException -> L25
        L43:
            return;
        L21:
            r7 = FullBackupEngine.m2522$$Nest$fgetmAgentTimeoutParameters(this.this$0).getFullBackupAgentTimeoutMillis();     // Catch: Throwable -> L10 RemoteException -> L12 IOException -> L14
        L10:
            th = move-exception;
            this.mPipe.close();     // Catch: IOException -> L38
            throw th;
        L39:
            throw th;
        L12:
            e = move-exception;
            Slog.e(BackupManagerService.TAG, "Remote agent vanished during full backup of " + this.mPackage.packageName, e);     // Catch: Throwable -> L10
            this.mPipe.close();     // Catch: IOException -> L25
        L14:
            e = move-exception;
            Slog.e(BackupManagerService.TAG, "Error running full backup for " + this.mPackage.packageName, e);     // Catch: Throwable -> L10
            this.mPipe.close();     // Catch: IOException -> L25
        }

        private boolean shouldWriteApk(ApplicationInfo applicationInfo, boolean includeApks, boolean isSharedStorage) {
            if ((applicationInfo.flags & 1) == 0) goto L5;
            boolean isSystemApp = true;
        L7:
            if ((applicationInfo.flags & 128) == 0) goto L9;
            boolean isUpdatedSystemApp = true;
        L10:
            if (includeApks == false) goto L16;
            if (isSharedStorage == true) goto L16;
            if (isSystemApp == false) goto L17;
            if (isUpdatedSystemApp == false) goto L16;
            return true;
        L17:
            return true;
        L16:
            return false;
        L9:
            isUpdatedSystemApp = false;
            goto L10
        L5:
            isSystemApp = false;
            goto L7
        }
    }

    public static /* synthetic */ void $r8$lambda$FGtmhs2ylSdGKzhElWdVTXv9xn4(FullBackupEngine r0, long r1, long r3, IBackupCallback r5) {
        r0.lambda$sendQuotaExceeded$0(r1, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetbackupManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserBackupManagerService m2521$$Nest$fgetbackupManagerService(FullBackupEngine r0) {
        return r0.backupManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAgentTimeoutParameters, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupAgentTimeoutParameters m2522$$Nest$fgetmAgentTimeoutParameters(FullBackupEngine r0) {
        return r0.mAgentTimeoutParameters;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQuota, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2523$$Nest$fgetmQuota(FullBackupEngine r2) {
        return r2.mQuota;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimeoutMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupRestoreTask m2524$$Nest$fgetmTimeoutMonitor(FullBackupEngine r0) {
        return r0.mTimeoutMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransportFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2525$$Nest$fgetmTransportFlags(FullBackupEngine r0) {
        return r0.mTransportFlags;
    }

    public FullBackupEngine(UserBackupManagerService backupManagerService, OutputStream output, FullBackupPreflight preflightHook, PackageInfo pkg, boolean alsoApks, BackupRestoreTask timeoutMonitor, long quota, int opToken, int transportFlags, BackupEligibilityRules backupEligibilityRules, BackupManagerMonitorEventSender backupManagerMonitorEventSender) {
        this.backupManagerService = backupManagerService;
        this.mOutput = output;
        this.mPreflightHook = preflightHook;
        this.mPkg = pkg;
        this.mIncludeApks = alsoApks;
        this.mTimeoutMonitor = timeoutMonitor;
        this.mQuota = quota;
        this.mOpToken = opToken;
        this.mTransportFlags = transportFlags;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
        this.mBackupEligibilityRules = backupEligibilityRules;
        this.mBackupManagerMonitorEventSender = backupManagerMonitorEventSender;
    }

    public int preflightCheck() throws RemoteException {
        if (this.mPreflightHook != null) goto L7;
        return 0;
    L7:
        if (initializeAgent() == false) goto L10;
        int result = this.mPreflightHook.preflightFullBackup(this.mPkg, this.mAgent);
        this.mAgent.clearBackupRestoreEventLogger();
        return result;
    L10:
        Slog.w(BackupManagerService.TAG, "Unable to bind to full agent for " + this.mPkg.packageName);
        return -1003;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int backupOnePackage() throws RemoteException {
        int r9 = -1003;
        if (initializeAgent() == false) goto L58;
        Object r2 = null;
        ParcelFileDescriptor[] r3 = null;
        ParcelFileDescriptor[] r14 = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L26 IOException -> L28
        FullBackupRunner r0 = new FullBackupRunner(this, this.backupManagerService, this.mPkg, this.mAgent, r14[1], this.mOpToken, this.mIncludeApks);     // Catch: Throwable -> L10 IOException -> L12
        r14[1].close();     // Catch: Throwable -> L10 IOException -> L12
        r14[1] = null;     // Catch: Throwable -> L10 IOException -> L12
        Thread r4 = new Thread(r0, "app-data-runner");     // Catch: Throwable -> L10 IOException -> L12
        r4.start();     // Catch: Throwable -> L10 IOException -> L12
        FullBackupUtils.routeSocketDataToOutput(r14[0], this.mOutput);     // Catch: Throwable -> L10 IOException -> L12
        if (this.backupManagerService.waitUntilOperationComplete(this.mOpToken) == true) goto L14;
        Slog.e(BackupManagerService.TAG, "Full backup failed on package " + this.mPkg.packageName);     // Catch: Throwable -> L10 IOException -> L12
    L15:
        this.mBackupManagerMonitorEventSender.monitorAgentLoggingResults(this.mPkg, this.mAgent);     // Catch: Throwable -> L10 IOException -> L12
        this.mOutput.flush();     // Catch: IOException -> L19
        if (r14[0] == null) goto L21;
        r14[0].close();     // Catch: IOException -> L19
    L21:
        r2 = r4;
        if (r14[1] == null) goto L65;
        r14[1].close();     // Catch: IOException -> L19
        r2 = r4;
    L65:
    L59:
        tearDown();
        return r9;
    L25:
        Slog.w(BackupManagerService.TAG, "Error bringing down backup stack");
        r9 = -1000;
        r2 = r4;
        goto L65
    L14:
        r9 = 0;
    L12:
        e = e;
        r3 = r14;
    L30:
        Slog.e(BackupManagerService.TAG, "Error backing up " + this.mPkg.packageName + ": " + e.getMessage());     // Catch: Throwable -> L26
        this.mBackupManagerMonitorEventSender.monitorEvent(82, this.mPkg, 2, null);     // Catch: Throwable -> L26
        this.mOutput.flush();     // Catch: IOException -> L37
        if (r3 != null) goto L35;
    L42:
        r9 = -1003;
        r2 = r3;
        goto L65
    L35:
        if (r3[0] == null) goto L40;
        r3[0].close();     // Catch: IOException -> L37
    L40:
        if (r3[1] == null) goto L42;
        r3[1].close();     // Catch: IOException -> L37
    L43:
        Slog.w(BackupManagerService.TAG, "Error bringing down backup stack");
        r9 = -1000;
        r2 = r3;
    L10:
        th = move-exception;
        Throwable r5 = th;
        Object[] r15 = r14;
    L63:
        this.mOutput.flush();     // Catch: IOException -> L50
        if (r15 != 0) goto L48;
        throw r5;
    L48:
        if (r15[0] == 0) goto L53;
        r15[0].close();     // Catch: IOException -> L50
    L53:
        if (r15[1] == 0) goto L75;
        r15[1].close();     // Catch: IOException -> L50
        throw r5;
    L75:
        throw r5;
    L56:
        Slog.w(BackupManagerService.TAG, "Error bringing down backup stack");
        throw r5;
    L26:
        th = move-exception;
        r15 = r2;
        r5 = th;
    L28:
        e = e;
        goto L30
    L58:
        Slog.w(BackupManagerService.TAG, "Unable to bind to full agent for " + this.mPkg.packageName);
        goto L59
    }

    public void sendQuotaExceeded(final long backupDataBytes, final long quotaBytes) {
        if (initializeAgent() == false) goto L14;
        RemoteCall.execute(new FullBackupEngine$$ExternalSyntheticLambda0(this, backupDataBytes, quotaBytes), this.mAgentTimeoutParameters.getQuotaExceededTimeoutMillis());     // Catch: RemoteException -> L8
        return;
    L12:
        Slog.e(BackupManagerService.TAG, "Remote exception while telling agent about quota exceeded");
        return;
    }

    private /* synthetic */ void lambda$sendQuotaExceeded$0(long backupDataBytes, long quotaBytes, IBackupCallback callback) throws RemoteException {
        this.mAgent.doQuotaExceeded(backupDataBytes, quotaBytes, callback);
    }

    private boolean initializeAgent() {
        if (this.mAgent != null) goto L6;
        this.mAgent = this.backupManagerService.getBackupAgentConnectionManager().bindToAgentSynchronous(this.mPkg.applicationInfo, 1, this.mBackupEligibilityRules.getBackupDestination());
    L6:
        if (this.mAgent != null) goto L10;
        return false;
    L10:
        return true;
    }

    private void tearDown() {
        if (this.mPkg == null) goto L6;
        this.backupManagerService.getBackupAgentConnectionManager().unbindAgent(this.mPkg.applicationInfo, true);
        return;
    }
}
