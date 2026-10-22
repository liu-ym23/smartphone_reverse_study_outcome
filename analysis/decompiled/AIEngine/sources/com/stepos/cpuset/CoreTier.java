package com.stepos.cpuset;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CoreTier {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ CoreTier[] $VALUES;
    public static final CoreTier ULTRA_BIG = new CoreTier("ULTRA_BIG", 0);
    public static final CoreTier BIG = new CoreTier("BIG", 1);
    public static final CoreTier MEDIUM = new CoreTier("MEDIUM", 2);
    public static final CoreTier SMALL = new CoreTier("SMALL", 3);

    private static final /* synthetic */ CoreTier[] $values() {
        return new CoreTier[]{ULTRA_BIG, BIG, MEDIUM, SMALL};
    }

    static {
        CoreTier[] coreTierArr$values = $values();
        $VALUES = coreTierArr$values;
        $ENTRIES = kotlin.enums.a.a(coreTierArr$values);
    }

    private CoreTier(String str, int i10) {
    }

    public static sb.a<CoreTier> getEntries() {
        return $ENTRIES;
    }

    public static CoreTier valueOf(String str) {
        return (CoreTier) Enum.valueOf(CoreTier.class, str);
    }

    public static CoreTier[] values() {
        return (CoreTier[]) $VALUES.clone();
    }
}
