package com.stepos.core.common.telemetry;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Phase {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ Phase[] $VALUES;
    public static final Phase QUEUE_WAIT = new Phase(FailStage.QUEUE_WAIT, 0);
    public static final Phase MODEL_LOAD = new Phase(FailStage.MODEL_LOAD, 1);
    public static final Phase IMAGE_PREPROCESS = new Phase(FailStage.IMAGE_PREPROCESS, 2);
    public static final Phase VIT_ENCODE = new Phase(FailStage.VIT_ENCODE, 3);
    public static final Phase AUDIO_PREPROCESS = new Phase(FailStage.AUDIO_PREPROCESS, 4);
    public static final Phase AUDIO_ENCODE = new Phase(FailStage.AUDIO_ENCODE, 5);
    public static final Phase TOKENIZE = new Phase("TOKENIZE", 6);
    public static final Phase PREFILL = new Phase(FailStage.PREFILL, 7);
    public static final Phase DECODE = new Phase(FailStage.DECODE, 8);
    public static final Phase FLOW_MATCH = new Phase(FailStage.FLOW_MATCH, 9);
    public static final Phase HIFT = new Phase(FailStage.HIFT, 10);
    public static final Phase POST_PROCESS = new Phase("POST_PROCESS", 11);
    public static final Phase INFERENCE = new Phase(FailStage.INFERENCE, 12);

    private static final /* synthetic */ Phase[] $values() {
        return new Phase[]{QUEUE_WAIT, MODEL_LOAD, IMAGE_PREPROCESS, VIT_ENCODE, AUDIO_PREPROCESS, AUDIO_ENCODE, TOKENIZE, PREFILL, DECODE, FLOW_MATCH, HIFT, POST_PROCESS, INFERENCE};
    }

    static {
        Phase[] phaseArr$values = $values();
        $VALUES = phaseArr$values;
        $ENTRIES = kotlin.enums.a.a(phaseArr$values);
    }

    private Phase(String str, int i10) {
    }

    public static sb.a<Phase> getEntries() {
        return $ENTRIES;
    }

    public static Phase valueOf(String str) {
        return (Phase) Enum.valueOf(Phase.class, str);
    }

    public static Phase[] values() {
        return (Phase[]) $VALUES.clone();
    }
}
