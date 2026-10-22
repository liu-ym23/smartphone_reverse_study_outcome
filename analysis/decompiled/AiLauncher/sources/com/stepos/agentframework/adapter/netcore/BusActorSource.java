package com.stepos.agentframework.adapter.netcore;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/BusActorSource;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "MODEL", "SYSTEM", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BusActorSource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ BusActorSource[] $VALUES;
    public static final BusActorSource USER = new BusActorSource("USER", 0);
    public static final BusActorSource MODEL = new BusActorSource("MODEL", 1);
    public static final BusActorSource SYSTEM = new BusActorSource("SYSTEM", 2);

    private static final /* synthetic */ BusActorSource[] $values() {
        return new BusActorSource[]{USER, MODEL, SYSTEM};
    }

    static {
        BusActorSource[] busActorSourceArr$values = $values();
        $VALUES = busActorSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(busActorSourceArr$values);
    }

    private BusActorSource(String str, int i10) {
    }

    public static InterfaceC4149a<BusActorSource> getEntries() {
        return $ENTRIES;
    }

    public static BusActorSource valueOf(String str) {
        return (BusActorSource) Enum.valueOf(BusActorSource.class, str);
    }

    public static BusActorSource[] values() {
        return (BusActorSource[]) $VALUES.clone();
    }
}
