package com.android.server.backup.restore;

import android.util.Slog;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.UserBackupManagerService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AdbRestoreFinishedLatch implements BackupRestoreTask {
    private static final String TAG = "AdbRestoreFinishedLatch";
    private UserBackupManagerService backupManagerService;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private final int mCurrentOpToken;
    final CountDownLatch mLatch;
    private final OperationStorage mOperationStorage;

    public AdbRestoreFinishedLatch(UserBackupManagerService backupManagerService, OperationStorage operationStorage, int currentOpToken) {
        this.backupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mLatch = new CountDownLatch(1);
        this.mCurrentOpToken = currentOpToken;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
    }

    void await() {
        long fullBackupAgentTimeoutMillis = this.mAgentTimeoutParameters.getFullBackupAgentTimeoutMillis();
        boolean r3 = this.mLatch.await(fullBackupAgentTimeoutMillis, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
        return;
    L6:
        Slog.w(TAG, "Interrupted!");
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void execute() {
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void operationComplete(long result) {
        this.mLatch.countDown();
        this.mOperationStorage.removeOperation(this.mCurrentOpToken);
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void handleCancel(int cancellationReason) {
        Slog.w(TAG, "adb onRestoreFinished() timed out");
        this.mLatch.countDown();
        this.mOperationStorage.removeOperation(this.mCurrentOpToken);
    }
}
