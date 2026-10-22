package com.android.server.backup;

import android.app.backup.BackupRestoreEventLogger;

/* JADX INFO: loaded from: classes.dex */
public interface WearBackupInternal {
    void applyRestoredPayload(byte[] r1);

    byte[] getBackupPayload(BackupRestoreEventLogger r1);
}
