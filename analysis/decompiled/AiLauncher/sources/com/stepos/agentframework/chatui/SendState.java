package com.stepos.agentframework.chatui;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatui/SendState;", "", "<init>", "(Ljava/lang/String;I)V", "SENDING", "SENT", "FAILED", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SendState[] $VALUES;
    public static final SendState SENDING = new SendState("SENDING", 0);
    public static final SendState SENT = new SendState("SENT", 1);
    public static final SendState FAILED = new SendState("FAILED", 2);

    private static final /* synthetic */ SendState[] $values() {
        return new SendState[]{SENDING, SENT, FAILED};
    }

    static {
        SendState[] sendStateArr$values = $values();
        $VALUES = sendStateArr$values;
        $ENTRIES = kotlin.enums.a.a(sendStateArr$values);
    }

    private SendState(String str, int i10) {
    }

    public static InterfaceC4149a<SendState> getEntries() {
        return $ENTRIES;
    }

    public static SendState valueOf(String str) {
        return (SendState) Enum.valueOf(SendState.class, str);
    }

    public static SendState[] values() {
        return (SendState[]) $VALUES.clone();
    }
}
