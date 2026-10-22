package com.android.server.backup.fullbackup;

import android.app.IBackupAgent;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes.dex */
public interface FullBackupPreflight {
    long getExpectedSizeOrErrorCode();

    int preflightFullBackup(PackageInfo r1, IBackupAgent r2);
}
