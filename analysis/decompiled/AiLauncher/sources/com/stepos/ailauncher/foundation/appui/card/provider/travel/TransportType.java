package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportType;", "", "<init>", "(Ljava/lang/String;I)V", "FLIGHT", "TRAIN", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransportType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TransportType[] $VALUES;
    public static final TransportType FLIGHT = new TransportType("FLIGHT", 0);
    public static final TransportType TRAIN = new TransportType("TRAIN", 1);

    private static final /* synthetic */ TransportType[] $values() {
        return new TransportType[]{FLIGHT, TRAIN};
    }

    static {
        TransportType[] transportTypeArr$values = $values();
        $VALUES = transportTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(transportTypeArr$values);
    }

    private TransportType(String str, int i10) {
    }

    public static InterfaceC4149a<TransportType> getEntries() {
        return $ENTRIES;
    }

    public static TransportType valueOf(String str) {
        return (TransportType) Enum.valueOf(TransportType.class, str);
    }

    public static TransportType[] values() {
        return (TransportType[]) $VALUES.clone();
    }
}
