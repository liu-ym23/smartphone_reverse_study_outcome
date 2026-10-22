package com.obric.eventkit.task.model;

/* JADX INFO: compiled from: TimerTaskTableEnum.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerTaskTableEnum {
    public static final int CONDITION_TASK = 3;
    public static final int CONDITION_TASK_RECORD = 4;
    public static final TimerTaskTableEnum INSTANCE = null;
    public static final int SHORTCUT_TASK = 5;
    public static final int SHORTCUT_TASK_RECORD = 6;
    public static final int TASK_EXECUTION_DETAIL_RECORD = 8;
    public static final int TASK_EXECUTION_RECORD = 7;
    public static final int TIMER_TASK = 1;
    public static final int TIMER_TASK_RECORD = 2;

    static {
        INSTANCE = new TimerTaskTableEnum();
    }

    private TimerTaskTableEnum() {
    }
}
