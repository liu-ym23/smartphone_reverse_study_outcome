package com.stepos.cpuset;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AffinityPolicy {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ AffinityPolicy[] $VALUES;
    public static final AffinityPolicy POWER_SAVE = new AffinityPolicy("POWER_SAVE", 0);
    public static final AffinityPolicy POWER_LOWEST = new AffinityPolicy("POWER_LOWEST", 1);

    private static final /* synthetic */ AffinityPolicy[] $values() {
        return new AffinityPolicy[]{POWER_SAVE, POWER_LOWEST};
    }

    static {
        AffinityPolicy[] affinityPolicyArr$values = $values();
        $VALUES = affinityPolicyArr$values;
        $ENTRIES = kotlin.enums.a.a(affinityPolicyArr$values);
    }

    private AffinityPolicy(String str, int i10) {
    }

    public static sb.a<AffinityPolicy> getEntries() {
        return $ENTRIES;
    }

    public static AffinityPolicy valueOf(String str) {
        return (AffinityPolicy) Enum.valueOf(AffinityPolicy.class, str);
    }

    public static AffinityPolicy[] values() {
        return (AffinityPolicy[]) $VALUES.clone();
    }
}
