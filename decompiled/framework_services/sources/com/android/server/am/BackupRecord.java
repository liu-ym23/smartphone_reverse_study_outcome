package com.android.server.am;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes.dex */
final class BackupRecord {
    public static final int BACKUP_FULL = 1;
    public static final int BACKUP_NORMAL = 0;
    public static final int RESTORE = 2;
    public static final int RESTORE_FULL = 3;
    ProcessRecord app;
    final ApplicationInfo appInfo;
    final int backupDestination;
    final int backupMode;
    String stringName;
    final boolean useRestrictedMode;
    final int userId;

    BackupRecord(ApplicationInfo _appInfo, int _backupMode, int _userId, int _backupDestination, boolean _useRestrictedMode) {
        this.appInfo = _appInfo;
        this.backupMode = _backupMode;
        this.userId = _userId;
        this.backupDestination = _backupDestination;
        this.useRestrictedMode = _useRestrictedMode;
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackupRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.appInfo.packageName);
        sb.append(' ');
        sb.append(this.appInfo.name);
        sb.append(' ');
        sb.append(this.appInfo.backupAgentName);
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L5:
        return this.stringName;
    }
}
