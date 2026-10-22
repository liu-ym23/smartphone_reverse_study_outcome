package com.stepos.agentframework.adapter.netcore;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/BusAnswerPhase;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "APPLIED", "REJECTED", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BusAnswerPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ BusAnswerPhase[] $VALUES;
    public static final BusAnswerPhase ACCEPTED = new BusAnswerPhase("ACCEPTED", 0);
    public static final BusAnswerPhase APPLIED = new BusAnswerPhase("APPLIED", 1);
    public static final BusAnswerPhase REJECTED = new BusAnswerPhase("REJECTED", 2);

    private static final /* synthetic */ BusAnswerPhase[] $values() {
        return new BusAnswerPhase[]{ACCEPTED, APPLIED, REJECTED};
    }

    static {
        BusAnswerPhase[] busAnswerPhaseArr$values = $values();
        $VALUES = busAnswerPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(busAnswerPhaseArr$values);
    }

    private BusAnswerPhase(String str, int i10) {
    }

    public static InterfaceC4149a<BusAnswerPhase> getEntries() {
        return $ENTRIES;
    }

    public static BusAnswerPhase valueOf(String str) {
        return (BusAnswerPhase) Enum.valueOf(BusAnswerPhase.class, str);
    }

    public static BusAnswerPhase[] values() {
        return (BusAnswerPhase[]) $VALUES.clone();
    }
}
