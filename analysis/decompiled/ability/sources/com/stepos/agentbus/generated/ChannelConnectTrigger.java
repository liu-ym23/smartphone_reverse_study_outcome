package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "COLD_START", "WAKE", "AUTO_RECONNECT", "MANUAL_RECONNECT", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChannelConnectTrigger {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ ChannelConnectTrigger[] $VALUES;
    public static final ChannelConnectTrigger COLD_START = new ChannelConnectTrigger("COLD_START", 0);
    public static final ChannelConnectTrigger WAKE = new ChannelConnectTrigger("WAKE", 1);
    public static final ChannelConnectTrigger AUTO_RECONNECT = new ChannelConnectTrigger("AUTO_RECONNECT", 2);
    public static final ChannelConnectTrigger MANUAL_RECONNECT = new ChannelConnectTrigger("MANUAL_RECONNECT", 3);

    private static final /* synthetic */ ChannelConnectTrigger[] $values() {
        return new ChannelConnectTrigger[]{COLD_START, WAKE, AUTO_RECONNECT, MANUAL_RECONNECT};
    }

    static {
        ChannelConnectTrigger[] channelConnectTriggerArr$values = $values();
        $VALUES = channelConnectTriggerArr$values;
        $ENTRIES = kotlin.enums.a.a(channelConnectTriggerArr$values);
    }

    private ChannelConnectTrigger(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static ChannelConnectTrigger valueOf(String str) {
        return (ChannelConnectTrigger) Enum.valueOf(ChannelConnectTrigger.class, str);
    }

    public static ChannelConnectTrigger[] values() {
        return (ChannelConnectTrigger[]) $VALUES.clone();
    }
}
