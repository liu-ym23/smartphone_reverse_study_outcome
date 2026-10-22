package com.stepos.core.model.manager;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelAcquireSource {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ ModelAcquireSource[] $VALUES;
    public static final ModelAcquireSource FIRST_LOAD = new ModelAcquireSource("FIRST_LOAD", 0);
    public static final ModelAcquireSource HOT_REUSE = new ModelAcquireSource("HOT_REUSE", 1);
    public static final ModelAcquireSource SELF_HEAL_REACQUIRE = new ModelAcquireSource("SELF_HEAL_REACQUIRE", 2);

    private static final /* synthetic */ ModelAcquireSource[] $values() {
        return new ModelAcquireSource[]{FIRST_LOAD, HOT_REUSE, SELF_HEAL_REACQUIRE};
    }

    static {
        ModelAcquireSource[] modelAcquireSourceArr$values = $values();
        $VALUES = modelAcquireSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(modelAcquireSourceArr$values);
    }

    private ModelAcquireSource(String str, int i10) {
    }

    public static sb.a<ModelAcquireSource> getEntries() {
        return $ENTRIES;
    }

    public static ModelAcquireSource valueOf(String str) {
        return (ModelAcquireSource) Enum.valueOf(ModelAcquireSource.class, str);
    }

    public static ModelAcquireSource[] values() {
        return (ModelAcquireSource[]) $VALUES.clone();
    }
}
