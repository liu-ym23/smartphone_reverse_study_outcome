package com.stepos.core.common.telemetry;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCacheState {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ ModelCacheState[] $VALUES;
    public static final ModelCacheState COLD = new ModelCacheState("COLD", 0);
    public static final ModelCacheState WARM = new ModelCacheState("WARM", 1);

    private static final /* synthetic */ ModelCacheState[] $values() {
        return new ModelCacheState[]{COLD, WARM};
    }

    static {
        ModelCacheState[] modelCacheStateArr$values = $values();
        $VALUES = modelCacheStateArr$values;
        $ENTRIES = kotlin.enums.a.a(modelCacheStateArr$values);
    }

    private ModelCacheState(String str, int i10) {
    }

    public static sb.a<ModelCacheState> getEntries() {
        return $ENTRIES;
    }

    public static ModelCacheState valueOf(String str) {
        return (ModelCacheState) Enum.valueOf(ModelCacheState.class, str);
    }

    public static ModelCacheState[] values() {
        return (ModelCacheState[]) $VALUES.clone();
    }
}
