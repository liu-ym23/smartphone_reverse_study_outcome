package com.stepos.core.performance.data;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCategory {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ModelCategory[] $VALUES;
    public static final ModelCategory LLM = new ModelCategory("LLM", 0);
    public static final ModelCategory VLM = new ModelCategory("VLM", 1);
    public static final ModelCategory ASR = new ModelCategory("ASR", 2);
    public static final ModelCategory TTS = new ModelCategory("TTS", 3);
    public static final ModelCategory EMBEDDING = new ModelCategory("EMBEDDING", 4);
    public static final ModelCategory VISION = new ModelCategory("VISION", 5);
    public static final ModelCategory OTHER = new ModelCategory("OTHER", 6);

    private static final /* synthetic */ ModelCategory[] $values() {
        return new ModelCategory[]{LLM, VLM, ASR, TTS, EMBEDDING, VISION, OTHER};
    }

    static {
        ModelCategory[] modelCategoryArr$values = $values();
        $VALUES = modelCategoryArr$values;
        $ENTRIES = kotlin.enums.a.a(modelCategoryArr$values);
    }

    private ModelCategory(String str, int i10) {
    }

    public static a<ModelCategory> getEntries() {
        return $ENTRIES;
    }

    public static ModelCategory valueOf(String str) {
        return (ModelCategory) Enum.valueOf(ModelCategory.class, str);
    }

    public static ModelCategory[] values() {
        return (ModelCategory[]) $VALUES.clone();
    }
}
