package com.android.server.backup.keyvalue;

import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IBackupObserver;
import android.content.pm.PackageInfo;
import android.util.EventLog;
import android.util.Slog;
import com.android.server.EventLogTags;
import com.android.server.backup.DataChangedJournal;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.remote.RemoteResult;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.backup.utils.BackupObserverUtils;
import com.android.server.job.JobSchedulerShellCommand;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueBackupReporter {
    static final boolean DEBUG = false;
    static final String TAG = "KeyValueBackupTask";
    private final BackupManagerMonitorEventSender mBackupManagerMonitorEventSender;
    private final UserBackupManagerService mBackupManagerService;
    private final IBackupObserver mObserver;

    static void onNewThread(String threadName) {
        Slog.d(TAG, "Spinning thread " + threadName);
    }

    KeyValueBackupReporter(UserBackupManagerService backupManagerService, IBackupObserver observer, BackupManagerMonitorEventSender backupManagerMonitorEventSender) {
        this.mBackupManagerService = backupManagerService;
        this.mObserver = observer;
        this.mBackupManagerMonitorEventSender = backupManagerMonitorEventSender;
    }

    IBackupManagerMonitor getMonitor() {
        return this.mBackupManagerMonitorEventSender.getMonitor();
    }

    IBackupObserver getObserver() {
        return this.mObserver;
    }

    void onSkipBackup() {
        Slog.d(TAG, "Skipping backup since one is already in progress");
    }

    void onEmptyQueueAtStart() {
        Slog.w(TAG, "Backup begun with an empty queue, nothing to do");
    }

    void onQueueReady(List<String> queue) {
        Slog.d(TAG, "Beginning backup of " + queue.size() + " targets");
    }

    void onTransportReady(String transportName) {
        EventLog.writeEvent(EventLogTags.BACKUP_START, transportName);
    }

    void onInitializeTransport(String transportName) {
        Slog.i(TAG, "Initializing transport and resetting backup state");
    }

    void onTransportInitialized(int status) {
        if (status != 0) goto L4;
        EventLog.writeEvent(EventLogTags.BACKUP_INITIALIZE, new Object[0]);
        return;
    L4:
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_FAILURE, "(initialize)");
        Slog.e(TAG, "Transport error in initializeDevice()");
    }

    void onInitializeTransportError(Exception e) {
        Slog.e(TAG, "Error during initialization", e);
    }

    void onSkipPm() {
        Slog.d(TAG, "Skipping backup of PM metadata");
    }

    void onExtractPmAgentDataError(Exception e) {
        Slog.e(TAG, "Error during PM metadata backup", e);
    }

    void onStartPackageBackup(String packageName) {
        Slog.d(TAG, "Starting key-value backup of " + packageName);
    }

    void onPackageNotEligibleForBackup(String packageName) {
        Slog.i(TAG, "Package " + packageName + " no longer supports backup, skipping");
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -2001);
    }

    void onPackageEligibleForFullBackup(String packageName) {
        Slog.i(TAG, "Package " + packageName + " performs full-backup rather than key-value, skipping");
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -2001);
    }

    void onPackageStopped(String packageName) {
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -2001);
    }

    void onAgentUnknown(String packageName) {
        Slog.d(TAG, "Package does not exist, skipping");
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -2002);
    }

    void onBindAgentError(String packageName, SecurityException e) {
        Slog.d(TAG, "Error in bind/backup", e);
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1003);
    }

    void onAgentError(String packageName) {
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1003);
    }

    void onExtractAgentData(String packageName) {
        Slog.d(TAG, "Invoking agent on " + packageName);
    }

    void onAgentFilesReady(File backupDataFile) {
    }

    void onRestoreconFailed(File backupDataFile) {
        Slog.e(TAG, "SELinux restorecon failed on " + backupDataFile);
    }

    void onCallAgentDoBackupError(String packageName, boolean callingAgent, Exception e) {
        if (callingAgent == false) goto L5;
        Slog.e(TAG, "Error invoking agent on " + packageName + ": " + e);
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1003);
    L6:
        EventLog.writeEvent(EventLogTags.BACKUP_AGENT_FAILURE, new Object[]{packageName, e.toString()});
        return;
    L5:
        Slog.e(TAG, "Error before invoking agent on " + packageName + ": " + e);
        goto L6
    }

    void onFailAgentError(String packageName) {
        Slog.w(TAG, "Error conveying failure to " + packageName);
    }

    void onAgentIllegalKey(PackageInfo packageInfo, String key) {
        String packageName = packageInfo.packageName;
        EventLog.writeEvent(EventLogTags.BACKUP_AGENT_FAILURE, new Object[]{packageName, "bad key"});
        this.mBackupManagerMonitorEventSender.monitorEvent(5, packageInfo, 3, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_ILLEGAL_KEY", key));
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1003);
    }

    void onAgentDataError(String packageName, IOException e) {
        Slog.w(TAG, "Unable to read/write agent data for " + packageName + ": " + e);
    }

    void onDigestError(NoSuchAlgorithmException e) {
        Slog.e(TAG, "Unable to use SHA-1!");
    }

    void onWriteWidgetData(boolean priorStateExists, byte[] widgetState) {
    }

    void onTransportPerformBackup(String packageName) {
    }

    void onEmptyData(PackageInfo packageInfo) {
        this.mBackupManagerMonitorEventSender.monitorEvent(7, packageInfo, 3, null);
    }

    void onPackageBackupComplete(String packageName, long size) {
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, 0);
        EventLog.writeEvent(EventLogTags.BACKUP_PACKAGE, new Object[]{packageName, Long.valueOf(size)});
        this.mBackupManagerService.logBackupComplete(packageName);
    }

    void onPackageBackupRejected(String packageName) {
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, JobSchedulerShellCommand.CMD_ERR_CONSTRAINTS);
        EventLogTags.writeBackupAgentFailure(packageName, "Transport rejected");
    }

    void onPackageBackupQuotaExceeded(String packageName) {
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1005);
        EventLog.writeEvent(EventLogTags.BACKUP_QUOTA_EXCEEDED, packageName);
    }

    void onAgentDoQuotaExceededError(Exception e) {
        Slog.e(TAG, "Unable to notify about quota exceeded: " + e);
    }

    void onPackageBackupNonIncrementalRequired(PackageInfo packageInfo) {
        Slog.i(TAG, "Transport lost data, retrying package");
        this.mBackupManagerMonitorEventSender.monitorEvent(51, packageInfo, 1, null);
    }

    void onPackageBackupNonIncrementalAndNonIncrementalRequired(String packageName) {
        Slog.e(TAG, "Transport requested non-incremental but already the case");
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1000);
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_FAILURE, packageName);
    }

    void onPackageBackupTransportFailure(String packageName) {
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1000);
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_FAILURE, packageName);
    }

    void onPackageBackupTransportError(String packageName, Exception e) {
        Slog.e(TAG, "Transport error backing up " + packageName, e);
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1000);
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_FAILURE, packageName);
    }

    void onCloseFileDescriptorError(String logName) {
        Slog.w(TAG, "Error closing " + logName + " file-descriptor");
    }

    void onCancel() {
    }

    void onAgentTimedOut(PackageInfo packageInfo) {
        String packageName = getPackageName(packageInfo);
        Slog.i(TAG, "Agent " + packageName + " timed out");
        EventLog.writeEvent(EventLogTags.BACKUP_AGENT_FAILURE, packageName);
        this.mBackupManagerMonitorEventSender.monitorEvent(21, packageInfo, 2, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_CANCEL_ALL", false));
    }

    void onAgentCancelled(PackageInfo packageInfo) {
        String packageName = getPackageName(packageInfo);
        Slog.i(TAG, "Cancel backing up " + packageName);
        EventLog.writeEvent(EventLogTags.BACKUP_AGENT_FAILURE, packageName);
        this.mBackupManagerMonitorEventSender.monitorEvent(21, packageInfo, 2, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_CANCEL_ALL", true));
    }

    void onAgentResultError(PackageInfo packageInfo) {
        String packageName = getPackageName(packageInfo);
        BackupObserverUtils.sendBackupOnPackageResult(this.mObserver, packageName, -1003);
        EventLog.writeEvent(EventLogTags.BACKUP_AGENT_FAILURE, new Object[]{packageName, "result error"});
        Slog.w(TAG, "Agent " + packageName + " error in onBackup()");
    }

    private String getPackageName(PackageInfo packageInfo) {
        if (packageInfo != null) goto L6;
        return "no_package_yet";
    L6:
        return packageInfo.packageName;
    }

    void onRevertTask() {
    }

    void onTransportRequestBackupTimeError(Exception e) {
        Slog.w(TAG, "Unable to contact transport for recommended backoff: " + e);
    }

    void onRemoteCallReturned(RemoteResult result, String logIdentifier) {
    }

    void onJournalDeleteFailed(DataChangedJournal journal) {
        Slog.e(TAG, "Unable to remove backup journal file " + journal);
    }

    void onSetCurrentTokenError(Exception e) {
        Slog.e(TAG, "Transport threw reporting restore set: " + e);
    }

    void onTransportNotInitialized(String transportName) {
        EventLog.writeEvent(EventLogTags.BACKUP_RESET, transportName);
    }

    void onPendingInitializeTransportError(Exception e) {
        Slog.w(TAG, "Failed to query transport name for pending init: " + e);
    }

    void onBackupFinished(int status) {
        BackupObserverUtils.sendBackupFinished(this.mObserver, status);
    }

    void onStartFullBackup(List<String> pendingFullBackups) {
        Slog.d(TAG, "Starting full backups for: " + pendingFullBackups);
    }

    void onTaskFinished() {
        Slog.i(TAG, "K/V backup pass finished");
    }
}
