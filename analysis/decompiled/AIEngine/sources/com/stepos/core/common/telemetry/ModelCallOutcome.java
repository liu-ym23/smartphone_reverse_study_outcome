package com.stepos.core.common.telemetry;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallOutcome {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ ModelCallOutcome[] $VALUES;
    public static final ModelCallOutcome SUCCESS = new ModelCallOutcome("SUCCESS", 0);
    public static final ModelCallOutcome FAILED = new ModelCallOutcome("FAILED", 1);
    public static final ModelCallOutcome CANCELLED = new ModelCallOutcome("CANCELLED", 2);
    public static final ModelCallOutcome TIMEOUT = new ModelCallOutcome("TIMEOUT", 3);
    public static final ModelCallOutcome TRUNCATED = new ModelCallOutcome("TRUNCATED", 4);

    private static final /* synthetic */ ModelCallOutcome[] $values() {
        return new ModelCallOutcome[]{SUCCESS, FAILED, CANCELLED, TIMEOUT, TRUNCATED};
    }

    static {
        ModelCallOutcome[] modelCallOutcomeArr$values = $values();
        $VALUES = modelCallOutcomeArr$values;
        $ENTRIES = kotlin.enums.a.a(modelCallOutcomeArr$values);
    }

    private ModelCallOutcome(String str, int i10) {
    }

    public static sb.a<ModelCallOutcome> getEntries() {
        return $ENTRIES;
    }

    public static ModelCallOutcome valueOf(String str) {
        return (ModelCallOutcome) Enum.valueOf(ModelCallOutcome.class, str);
    }

    public static ModelCallOutcome[] values() {
        return (ModelCallOutcome[]) $VALUES.clone();
    }
}
