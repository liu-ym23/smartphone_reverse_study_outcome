package com.stepos.core.transport.channel;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/core/transport/channel/ChannelType;", "", "<init>", "(Ljava/lang/String;I)V", "PURE_BINDER", "FD_TRANSPORT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChannelType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChannelType[] $VALUES;
    public static final ChannelType PURE_BINDER = new ChannelType("PURE_BINDER", 0);
    public static final ChannelType FD_TRANSPORT = new ChannelType("FD_TRANSPORT", 1);

    private static final /* synthetic */ ChannelType[] $values() {
        return new ChannelType[]{PURE_BINDER, FD_TRANSPORT};
    }

    static {
        ChannelType[] channelTypeArr$values = $values();
        $VALUES = channelTypeArr$values;
        $ENTRIES = a.a(channelTypeArr$values);
    }

    private ChannelType(String str, int i10) {
    }

    public static InterfaceC4149a<ChannelType> getEntries() {
        return $ENTRIES;
    }

    public static ChannelType valueOf(String str) {
        return (ChannelType) Enum.valueOf(ChannelType.class, str);
    }

    public static ChannelType[] values() {
        return (ChannelType[]) $VALUES.clone();
    }
}
