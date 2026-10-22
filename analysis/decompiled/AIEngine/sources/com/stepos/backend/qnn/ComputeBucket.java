package com.stepos.backend.qnn;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ComputeBucket {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ ComputeBucket[] $VALUES;
    public static final ComputeBucket HTP = new ComputeBucket("HTP", 0);
    public static final ComputeBucket CDSP = new ComputeBucket("CDSP", 1);

    private static final /* synthetic */ ComputeBucket[] $values() {
        return new ComputeBucket[]{HTP, CDSP};
    }

    static {
        ComputeBucket[] computeBucketArr$values = $values();
        $VALUES = computeBucketArr$values;
        $ENTRIES = kotlin.enums.a.a(computeBucketArr$values);
    }

    private ComputeBucket(String str, int i10) {
    }

    public static sb.a<ComputeBucket> getEntries() {
        return $ENTRIES;
    }

    public static ComputeBucket valueOf(String str) {
        return (ComputeBucket) Enum.valueOf(ComputeBucket.class, str);
    }

    public static ComputeBucket[] values() {
        return (ComputeBucket[]) $VALUES.clone();
    }
}
