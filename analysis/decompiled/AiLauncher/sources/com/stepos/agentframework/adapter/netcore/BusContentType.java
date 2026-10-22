package com.stepos.agentframework.adapter.netcore;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/BusContentType;", "", "<init>", "(Ljava/lang/String;I)V", "INLINE", "URL", "FILE", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BusContentType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ BusContentType[] $VALUES;
    public static final BusContentType INLINE = new BusContentType("INLINE", 0);
    public static final BusContentType URL = new BusContentType("URL", 1);
    public static final BusContentType FILE = new BusContentType("FILE", 2);

    private static final /* synthetic */ BusContentType[] $values() {
        return new BusContentType[]{INLINE, URL, FILE};
    }

    static {
        BusContentType[] busContentTypeArr$values = $values();
        $VALUES = busContentTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(busContentTypeArr$values);
    }

    private BusContentType(String str, int i10) {
    }

    public static InterfaceC4149a<BusContentType> getEntries() {
        return $ENTRIES;
    }

    public static BusContentType valueOf(String str) {
        return (BusContentType) Enum.valueOf(BusContentType.class, str);
    }

    public static BusContentType[] values() {
        return (BusContentType[]) $VALUES.clone();
    }
}
