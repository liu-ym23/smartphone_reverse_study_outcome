package com.android.server.backup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface OperationStorage {

    @Retention(RetentionPolicy.SOURCE)
    public @interface OpState {
        public static final int ACKNOWLEDGED = 1;
        public static final int PENDING = 0;
        public static final int TIMEOUT = -1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OpType {
        public static final int BACKUP = 2;
        public static final int BACKUP_WAIT = 0;
        public static final int RESTORE_WAIT = 1;
    }

    boolean isBackupOperationInProgress();

    int numOperations();

    Set<Integer> operationTokensForOpState(int r1);

    Set<Integer> operationTokensForOpType(int r1);

    Set<Integer> operationTokensForPackage(String r1);

    void registerOperation(int r1, int r2, BackupRestoreTask r3, int r4);

    void registerOperationForPackages(int r1, int r2, Set<String> r3, BackupRestoreTask r4, int r5);

    void removeOperation(int r1);
}
