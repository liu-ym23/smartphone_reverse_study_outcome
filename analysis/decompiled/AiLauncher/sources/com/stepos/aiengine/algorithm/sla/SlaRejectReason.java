package com.stepos.aiengine.algorithm.sla;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaRejectReason;", "", "<init>", "(Ljava/lang/String;I)V", "OUT_OF_DOMAIN", "LOW_CONFIDENCE", "NO_MATCH", "TIMEOUT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SlaRejectReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SlaRejectReason[] $VALUES;
    public static final SlaRejectReason OUT_OF_DOMAIN = new SlaRejectReason("OUT_OF_DOMAIN", 0);
    public static final SlaRejectReason LOW_CONFIDENCE = new SlaRejectReason("LOW_CONFIDENCE", 1);
    public static final SlaRejectReason NO_MATCH = new SlaRejectReason("NO_MATCH", 2);
    public static final SlaRejectReason TIMEOUT = new SlaRejectReason("TIMEOUT", 3);

    private static final /* synthetic */ SlaRejectReason[] $values() {
        return new SlaRejectReason[]{OUT_OF_DOMAIN, LOW_CONFIDENCE, NO_MATCH, TIMEOUT};
    }

    static {
        SlaRejectReason[] slaRejectReasonArr$values = $values();
        $VALUES = slaRejectReasonArr$values;
        $ENTRIES = a.a(slaRejectReasonArr$values);
    }

    private SlaRejectReason(String str, int i10) {
    }

    public static InterfaceC4149a<SlaRejectReason> getEntries() {
        return $ENTRIES;
    }

    public static SlaRejectReason valueOf(String str) {
        return (SlaRejectReason) Enum.valueOf(SlaRejectReason.class, str);
    }

    public static SlaRejectReason[] values() {
        return (SlaRejectReason[]) $VALUES.clone();
    }
}
