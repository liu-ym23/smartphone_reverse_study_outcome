package com.obric.eventkit.task.model;

/* JADX INFO: compiled from: TimerTaskStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerTaskStatus {
    public static final TimerTaskStatus INSTANCE = null;
    public static final int STATE_ACTIONING = 1;
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_FAILED = 3;
    public static final int STATE_PENDING = 0;

    static {
        INSTANCE = new TimerTaskStatus();
    }

    private TimerTaskStatus() {
    }
}
