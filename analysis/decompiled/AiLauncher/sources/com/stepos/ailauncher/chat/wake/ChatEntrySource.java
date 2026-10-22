package com.stepos.ailauncher.chat.wake;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "", "<init>", "(Ljava/lang/String;I)V", "EXTERNAL_AGENT", "AGENT_MARKET", "SIDEBAR_AGENT", "AGENT_SPACE", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatEntrySource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChatEntrySource[] $VALUES;
    public static final ChatEntrySource EXTERNAL_AGENT = new ChatEntrySource("EXTERNAL_AGENT", 0);
    public static final ChatEntrySource AGENT_MARKET = new ChatEntrySource("AGENT_MARKET", 1);
    public static final ChatEntrySource SIDEBAR_AGENT = new ChatEntrySource("SIDEBAR_AGENT", 2);
    public static final ChatEntrySource AGENT_SPACE = new ChatEntrySource("AGENT_SPACE", 3);

    private static final /* synthetic */ ChatEntrySource[] $values() {
        return new ChatEntrySource[]{EXTERNAL_AGENT, AGENT_MARKET, SIDEBAR_AGENT, AGENT_SPACE};
    }

    static {
        ChatEntrySource[] chatEntrySourceArr$values = $values();
        $VALUES = chatEntrySourceArr$values;
        $ENTRIES = kotlin.enums.a.a(chatEntrySourceArr$values);
    }

    private ChatEntrySource(String str, int i10) {
    }

    public static InterfaceC4149a<ChatEntrySource> getEntries() {
        return $ENTRIES;
    }

    public static ChatEntrySource valueOf(String str) {
        return (ChatEntrySource) Enum.valueOf(ChatEntrySource.class, str);
    }

    public static ChatEntrySource[] values() {
        return (ChatEntrySource[]) $VALUES.clone();
    }
}
