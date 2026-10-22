package com.stepos.core.common.telemetry;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallExecutionPath {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ ModelCallExecutionPath[] $VALUES;
    public static final ModelCallExecutionPath CLOUD = new ModelCallExecutionPath("CLOUD", 0);
    public static final ModelCallExecutionPath EDGE = new ModelCallExecutionPath("EDGE", 1);

    private static final /* synthetic */ ModelCallExecutionPath[] $values() {
        return new ModelCallExecutionPath[]{CLOUD, EDGE};
    }

    static {
        ModelCallExecutionPath[] modelCallExecutionPathArr$values = $values();
        $VALUES = modelCallExecutionPathArr$values;
        $ENTRIES = kotlin.enums.a.a(modelCallExecutionPathArr$values);
    }

    private ModelCallExecutionPath(String str, int i10) {
    }

    public static sb.a<ModelCallExecutionPath> getEntries() {
        return $ENTRIES;
    }

    public static ModelCallExecutionPath valueOf(String str) {
        return (ModelCallExecutionPath) Enum.valueOf(ModelCallExecutionPath.class, str);
    }

    public static ModelCallExecutionPath[] values() {
        return (ModelCallExecutionPath[]) $VALUES.clone();
    }
}
