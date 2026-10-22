package com.stepos.core.performance.signal;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AdjSegment {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ AdjSegment[] $VALUES;
    public static final AdjSegment LT100 = new AdjSegment("LT100", 0);
    public static final AdjSegment LT400 = new AdjSegment("LT400", 1);
    public static final AdjSegment GE400 = new AdjSegment("GE400", 2);

    private static final /* synthetic */ AdjSegment[] $values() {
        return new AdjSegment[]{LT100, LT400, GE400};
    }

    static {
        AdjSegment[] adjSegmentArr$values = $values();
        $VALUES = adjSegmentArr$values;
        $ENTRIES = kotlin.enums.a.a(adjSegmentArr$values);
    }

    private AdjSegment(String str, int i10) {
    }

    public static a<AdjSegment> getEntries() {
        return $ENTRIES;
    }

    public static AdjSegment valueOf(String str) {
        return (AdjSegment) Enum.valueOf(AdjSegment.class, str);
    }

    public static AdjSegment[] values() {
        return (AdjSegment[]) $VALUES.clone();
    }
}
