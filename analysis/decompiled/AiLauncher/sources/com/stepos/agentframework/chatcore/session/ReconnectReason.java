package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "", "<init>", "(Ljava/lang/String;I)V", "NETWORK_FAILED", "AI_TIMEOUT", "AGENT_OFFLINE", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReconnectReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ReconnectReason[] $VALUES;
    public static final ReconnectReason NETWORK_FAILED = new ReconnectReason("NETWORK_FAILED", 0);
    public static final ReconnectReason AI_TIMEOUT = new ReconnectReason("AI_TIMEOUT", 1);
    public static final ReconnectReason AGENT_OFFLINE = new ReconnectReason("AGENT_OFFLINE", 2);

    private static final /* synthetic */ ReconnectReason[] $values() {
        return new ReconnectReason[]{NETWORK_FAILED, AI_TIMEOUT, AGENT_OFFLINE};
    }

    static {
        ReconnectReason[] reconnectReasonArr$values = $values();
        $VALUES = reconnectReasonArr$values;
        $ENTRIES = kotlin.enums.a.a(reconnectReasonArr$values);
    }

    private ReconnectReason(String str, int i10) {
    }

    public static InterfaceC4149a<ReconnectReason> getEntries() {
        return $ENTRIES;
    }

    public static ReconnectReason valueOf(String str) {
        return (ReconnectReason) Enum.valueOf(ReconnectReason.class, str);
    }

    public static ReconnectReason[] values() {
        return (ReconnectReason[]) $VALUES.clone();
    }
}
