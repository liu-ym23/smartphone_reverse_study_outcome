package com.stepos.core.model.task;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AITaskState {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ AITaskState[] $VALUES;
    public static final AITaskState PENDING = new AITaskState("PENDING", 0);
    public static final AITaskState QUEUED = new AITaskState("QUEUED", 1);
    public static final AITaskState RUNNING = new AITaskState("RUNNING", 2);
    public static final AITaskState COMPLETED = new AITaskState("COMPLETED", 3);
    public static final AITaskState FAILED = new AITaskState("FAILED", 4);
    public static final AITaskState CANCELLED = new AITaskState("CANCELLED", 5);
    public static final AITaskState TIMEOUT = new AITaskState("TIMEOUT", 6);

    private static final /* synthetic */ AITaskState[] $values() {
        return new AITaskState[]{PENDING, QUEUED, RUNNING, COMPLETED, FAILED, CANCELLED, TIMEOUT};
    }

    static {
        AITaskState[] aITaskStateArr$values = $values();
        $VALUES = aITaskStateArr$values;
        $ENTRIES = kotlin.enums.a.a(aITaskStateArr$values);
    }

    private AITaskState(String str, int i10) {
    }

    public static sb.a<AITaskState> getEntries() {
        return $ENTRIES;
    }

    public static AITaskState valueOf(String str) {
        return (AITaskState) Enum.valueOf(AITaskState.class, str);
    }

    public static AITaskState[] values() {
        return (AITaskState[]) $VALUES.clone();
    }
}
