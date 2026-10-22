package com.stepos.core.model.task;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskSessionState {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ TaskSessionState[] $VALUES;
    public static final TaskSessionState PENDING = new TaskSessionState("PENDING", 0);
    public static final TaskSessionState QUEUED = new TaskSessionState("QUEUED", 1);
    public static final TaskSessionState RUNNING = new TaskSessionState("RUNNING", 2);
    public static final TaskSessionState COMPLETED = new TaskSessionState("COMPLETED", 3);
    public static final TaskSessionState FAILED = new TaskSessionState("FAILED", 4);
    public static final TaskSessionState CANCELLED = new TaskSessionState("CANCELLED", 5);
    public static final TaskSessionState TIMEOUT = new TaskSessionState("TIMEOUT", 6);

    private static final /* synthetic */ TaskSessionState[] $values() {
        return new TaskSessionState[]{PENDING, QUEUED, RUNNING, COMPLETED, FAILED, CANCELLED, TIMEOUT};
    }

    static {
        TaskSessionState[] taskSessionStateArr$values = $values();
        $VALUES = taskSessionStateArr$values;
        $ENTRIES = kotlin.enums.a.a(taskSessionStateArr$values);
    }

    private TaskSessionState(String str, int i10) {
    }

    public static sb.a<TaskSessionState> getEntries() {
        return $ENTRIES;
    }

    public static TaskSessionState valueOf(String str) {
        return (TaskSessionState) Enum.valueOf(TaskSessionState.class, str);
    }

    public static TaskSessionState[] values() {
        return (TaskSessionState[]) $VALUES.clone();
    }
}
