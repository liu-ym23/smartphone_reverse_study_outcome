package com.stepos.agentframework.chatui;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatui/AgentWorkUiEvent;", "", "<init>", "(Ljava/lang/String;I)V", "THINKING_START", "THINKING_END", "EXECUTE_START", "EXECUTE_END", "AUTO_TTS_START", "AUTO_TTS_END", "AUTO_TTS_INTERRUPTED", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentWorkUiEvent {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentWorkUiEvent[] $VALUES;
    public static final AgentWorkUiEvent THINKING_START = new AgentWorkUiEvent("THINKING_START", 0);
    public static final AgentWorkUiEvent THINKING_END = new AgentWorkUiEvent("THINKING_END", 1);
    public static final AgentWorkUiEvent EXECUTE_START = new AgentWorkUiEvent("EXECUTE_START", 2);
    public static final AgentWorkUiEvent EXECUTE_END = new AgentWorkUiEvent("EXECUTE_END", 3);
    public static final AgentWorkUiEvent AUTO_TTS_START = new AgentWorkUiEvent("AUTO_TTS_START", 4);
    public static final AgentWorkUiEvent AUTO_TTS_END = new AgentWorkUiEvent("AUTO_TTS_END", 5);
    public static final AgentWorkUiEvent AUTO_TTS_INTERRUPTED = new AgentWorkUiEvent("AUTO_TTS_INTERRUPTED", 6);

    private static final /* synthetic */ AgentWorkUiEvent[] $values() {
        return new AgentWorkUiEvent[]{THINKING_START, THINKING_END, EXECUTE_START, EXECUTE_END, AUTO_TTS_START, AUTO_TTS_END, AUTO_TTS_INTERRUPTED};
    }

    static {
        AgentWorkUiEvent[] agentWorkUiEventArr$values = $values();
        $VALUES = agentWorkUiEventArr$values;
        $ENTRIES = kotlin.enums.a.a(agentWorkUiEventArr$values);
    }

    private AgentWorkUiEvent(String str, int i10) {
    }

    public static InterfaceC4149a<AgentWorkUiEvent> getEntries() {
        return $ENTRIES;
    }

    public static AgentWorkUiEvent valueOf(String str) {
        return (AgentWorkUiEvent) Enum.valueOf(AgentWorkUiEvent.class, str);
    }

    public static AgentWorkUiEvent[] values() {
        return (AgentWorkUiEvent[]) $VALUES.clone();
    }
}
