package com.stepos.core.cta;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaGate {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ CtaGate[] $VALUES;
    public static final CtaGate CTA_ONLY = new CtaGate("CTA_ONLY", 0);
    public static final CtaGate CTA_AND_SERVICE = new CtaGate("CTA_AND_SERVICE", 1);

    private static final /* synthetic */ CtaGate[] $values() {
        return new CtaGate[]{CTA_ONLY, CTA_AND_SERVICE};
    }

    static {
        CtaGate[] ctaGateArr$values = $values();
        $VALUES = ctaGateArr$values;
        $ENTRIES = kotlin.enums.a.a(ctaGateArr$values);
    }

    private CtaGate(String str, int i10) {
    }

    public static sb.a<CtaGate> getEntries() {
        return $ENTRIES;
    }

    public static CtaGate valueOf(String str) {
        return (CtaGate) Enum.valueOf(CtaGate.class, str);
    }

    public static CtaGate[] values() {
        return (CtaGate[]) $VALUES.clone();
    }
}
