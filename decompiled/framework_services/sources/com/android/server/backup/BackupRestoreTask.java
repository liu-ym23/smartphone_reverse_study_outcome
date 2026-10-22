package com.android.server.backup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public interface BackupRestoreTask {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CancellationReason {
        public static final int AGENT_DISCONNECTED = 1;
        public static final int EXTERNAL = 2;
        public static final int SCHEDULED_JOB_STOPPED = 3;
        public static final int TIMEOUT = 0;
    }

    void execute();

    void handleCancel(int r1);

    void operationComplete(long r1);
}
