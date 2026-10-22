package com.stepos.core.performance.data;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AicGroupPressureLevel {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ AicGroupPressureLevel[] $VALUES;
    public static final AicGroupPressureLevel NORMAL = new AicGroupPressureLevel("NORMAL", 0);
    public static final AicGroupPressureLevel LOW = new AicGroupPressureLevel("LOW", 1);
    public static final AicGroupPressureLevel ULTRA_LOW = new AicGroupPressureLevel("ULTRA_LOW", 2);

    private static final /* synthetic */ AicGroupPressureLevel[] $values() {
        return new AicGroupPressureLevel[]{NORMAL, LOW, ULTRA_LOW};
    }

    static {
        AicGroupPressureLevel[] aicGroupPressureLevelArr$values = $values();
        $VALUES = aicGroupPressureLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(aicGroupPressureLevelArr$values);
    }

    private AicGroupPressureLevel(String str, int i10) {
    }

    public static a<AicGroupPressureLevel> getEntries() {
        return $ENTRIES;
    }

    public static AicGroupPressureLevel valueOf(String str) {
        return (AicGroupPressureLevel) Enum.valueOf(AicGroupPressureLevel.class, str);
    }

    public static AicGroupPressureLevel[] values() {
        return (AicGroupPressureLevel[]) $VALUES.clone();
    }
}
