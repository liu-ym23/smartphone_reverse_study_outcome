package com.stepos.ailauncher.chat.view;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/view/AgentAction;", "", "<init>", "(Ljava/lang/String;I)V", "Disconnect", "Uninstall", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentAction[] $VALUES;
    public static final AgentAction Disconnect = new AgentAction("Disconnect", 0);
    public static final AgentAction Uninstall = new AgentAction("Uninstall", 1);

    private static final /* synthetic */ AgentAction[] $values() {
        return new AgentAction[]{Disconnect, Uninstall};
    }

    static {
        AgentAction[] agentActionArr$values = $values();
        $VALUES = agentActionArr$values;
        $ENTRIES = kotlin.enums.a.a(agentActionArr$values);
    }

    private AgentAction(String str, int i10) {
    }

    public static InterfaceC4149a<AgentAction> getEntries() {
        return $ENTRIES;
    }

    public static AgentAction valueOf(String str) {
        return (AgentAction) Enum.valueOf(AgentAction.class, str);
    }

    public static AgentAction[] values() {
        return (AgentAction[]) $VALUES.clone();
    }
}
