package com.android.server.backup.utils;

import android.app.IBackupAgent;
import android.app.backup.BackupRestoreEventLogger;
import android.app.backup.IBackupManagerMonitor;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import com.android.server.backup.BackupManagerService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class BackupManagerMonitorEventSender {
    private static final int AGENT_LOGGER_RESULTS_TIMEOUT_MILLIS = 500;
    private final BackupManagerMonitorDumpsysUtils mBackupManagerMonitorDumpsysUtils;
    private IBackupManagerMonitor mMonitor;

    public BackupManagerMonitorEventSender(IBackupManagerMonitor monitor) {
        this.mMonitor = monitor;
        this.mBackupManagerMonitorDumpsysUtils = new BackupManagerMonitorDumpsysUtils();
    }

    BackupManagerMonitorEventSender(IBackupManagerMonitor monitor, BackupManagerMonitorDumpsysUtils backupManagerMonitorDumpsysUtils) {
        this.mMonitor = monitor;
        this.mBackupManagerMonitorDumpsysUtils = backupManagerMonitorDumpsysUtils;
    }

    public void setMonitor(IBackupManagerMonitor monitor) {
        this.mMonitor = monitor;
    }

    public IBackupManagerMonitor getMonitor() {
        return this.mMonitor;
    }

    public void monitorEvent(int id, PackageInfo pkg, int category, Bundle extras) {
        Bundle bundle = new Bundle();     // Catch: RemoteException -> L6
        bundle.putInt("android.app.backup.extra.LOG_EVENT_ID", id);     // Catch: RemoteException -> L6
        bundle.putInt("android.app.backup.extra.LOG_EVENT_CATEGORY", category);     // Catch: RemoteException -> L6
        if (pkg == null) goto L8;
        bundle.putString("android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", pkg.packageName);     // Catch: RemoteException -> L6
        bundle.putInt("android.app.backup.extra.LOG_EVENT_PACKAGE_VERSION", pkg.versionCode);     // Catch: RemoteException -> L6
        bundle.putLong("android.app.backup.extra.LOG_EVENT_PACKAGE_FULL_VERSION", pkg.getLongVersionCode());     // Catch: RemoteException -> L6
    L8:
        if (extras == null) goto L15;
        bundle.putAll(extras);     // Catch: RemoteException -> L6
        if (extras.containsKey("android.app.backup.extra.OPERATION_TYPE") == false) goto L15;
        if (extras.getInt("android.app.backup.extra.OPERATION_TYPE") != 1) goto L15;
        this.mBackupManagerMonitorDumpsysUtils.parseBackupManagerMonitorRestoreEventForDumpsys(bundle);     // Catch: RemoteException -> L6
    L15:
        if (this.mMonitor == null) goto L17;
        this.mMonitor.onEvent(bundle);     // Catch: RemoteException -> L6
        return;
    L17:
        Slog.w(BackupManagerService.TAG, "backup manager monitor is null unable to send event");     // Catch: RemoteException -> L6
        return;
    L19:
        this.mMonitor = null;
        Slog.w(BackupManagerService.TAG, "backup manager monitor went away");
    }

    public void monitorAgentLoggingResults(PackageInfo pkg, IBackupAgent agent) {
        if (this.mMonitor != null) goto L14;
        Slog.i(BackupManagerService.TAG, "backup manager monitor is null unable to send event" + pkg);
    L14:
        AndroidFuture<List<BackupRestoreEventLogger.DataTypeResult>> resultsFuture = new AndroidFuture();     // Catch: Exception -> L7 TimeoutException -> L9
        AndroidFuture<Integer> operationTypeFuture = new AndroidFuture();     // Catch: Exception -> L7 TimeoutException -> L9
        agent.getLoggerResults(resultsFuture);     // Catch: Exception -> L7 TimeoutException -> L9
        agent.getOperationType(operationTypeFuture);     // Catch: Exception -> L7 TimeoutException -> L9
        sendAgentLoggingResults(pkg, (List) resultsFuture.get(500, TimeUnit.MILLISECONDS), ((Integer) operationTypeFuture.get(500, TimeUnit.MILLISECONDS)).intValue());     // Catch: Exception -> L7 TimeoutException -> L9
    L16:
        return;
    L9:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Timeout while waiting to retrieve logging results from agent", e);
        return;
    L7:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Failed to retrieve logging results from agent", e);
    }

    public void sendAgentLoggingResults(PackageInfo pkg, List<BackupRestoreEventLogger.DataTypeResult> results, int operationType) {
        Bundle loggerResultsBundle = new Bundle();
        loggerResultsBundle.putParcelableList("android.app.backup.extra.LOG_AGENT_LOGGING_RESULTS", results);
        loggerResultsBundle.putInt("android.app.backup.extra.OPERATION_TYPE", operationType);
        monitorEvent(52, pkg, 2, loggerResultsBundle);
    }

    public static Bundle putMonitoringExtra(Bundle extras, String key, String value) {
        if (extras != null) goto L4;
        extras = new Bundle();
    L4:
        extras.putString(key, value);
        return extras;
    }

    public static Bundle putMonitoringExtra(Bundle extras, String key, long value) {
        if (extras != null) goto L4;
        extras = new Bundle();
    L4:
        extras.putLong(key, value);
        return extras;
    }

    public static Bundle putMonitoringExtra(Bundle extras, String key, boolean value) {
        if (extras != null) goto L4;
        extras = new Bundle();
    L4:
        extras.putBoolean(key, value);
        return extras;
    }

    public static Bundle putMonitoringExtra(Bundle extras, String key, int value) {
        if (extras != null) goto L4;
        extras = new Bundle();
    L4:
        extras.putInt(key, value);
        return extras;
    }
}
