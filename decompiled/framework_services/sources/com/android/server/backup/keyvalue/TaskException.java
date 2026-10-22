package com.android.server.backup.keyvalue;

import com.android.internal.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class TaskException extends BackupException {
    private static final int DEFAULT_STATUS = -1000;
    private final boolean mStateCompromised;
    private final int mStatus;

    static TaskException stateCompromised() {
        return new TaskException(true, -1000);
    }

    static TaskException stateCompromised(Exception cause) {
        if ((cause instanceof TaskException) == false) goto L7;
        TaskException exception = (TaskException) cause;
        return new TaskException(cause, true, exception.getStatus());
    L7:
        return new TaskException(cause, true, -1000);
    }

    static TaskException forStatus(int status) {
        if (status == 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Exception based on TRANSPORT_OK");
        return new TaskException(false, status);
    L5:
        r1 = false;
        goto L6
    }

    static TaskException causedBy(Exception cause) {
        if ((cause instanceof TaskException) == false) goto L7;
        return (TaskException) cause;
    L7:
        return new TaskException(cause, false, -1000);
    }

    static TaskException create() {
        return new TaskException(false, -1000);
    }

    private TaskException(Exception cause, boolean stateCompromised, int status) {
        super(cause);
        this.mStateCompromised = stateCompromised;
        this.mStatus = status;
    }

    private TaskException(boolean stateCompromised, int status) {
        this.mStateCompromised = stateCompromised;
        this.mStatus = status;
    }

    boolean isStateCompromised() {
        return this.mStateCompromised;
    }

    int getStatus() {
        return this.mStatus;
    }
}
