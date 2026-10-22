package com.stepos.agentframework.adapter.agentbus.bff;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/AgentProxyCommand;", "", UxipConstants.f30680s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMMAND_CHAT", "COMMAND_RECEIVE", "COMMAND_CHAT_APPROVAL", "COMMAND_CHAT_CANCEL", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentProxyCommand {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentProxyCommand[] $VALUES;
    private final String value;
    public static final AgentProxyCommand COMMAND_CHAT = new AgentProxyCommand("COMMAND_CHAT", 0, "Chat");
    public static final AgentProxyCommand COMMAND_RECEIVE = new AgentProxyCommand("COMMAND_RECEIVE", 1, "Receive");
    public static final AgentProxyCommand COMMAND_CHAT_APPROVAL = new AgentProxyCommand("COMMAND_CHAT_APPROVAL", 2, "ChatApproval");
    public static final AgentProxyCommand COMMAND_CHAT_CANCEL = new AgentProxyCommand("COMMAND_CHAT_CANCEL", 3, "ChatCancel");

    private static final /* synthetic */ AgentProxyCommand[] $values() {
        return new AgentProxyCommand[]{COMMAND_CHAT, COMMAND_RECEIVE, COMMAND_CHAT_APPROVAL, COMMAND_CHAT_CANCEL};
    }

    static {
        AgentProxyCommand[] agentProxyCommandArr$values = $values();
        $VALUES = agentProxyCommandArr$values;
        $ENTRIES = kotlin.enums.a.a(agentProxyCommandArr$values);
    }

    private AgentProxyCommand(String str, int i10, String str2) {
        this.value = str2;
    }

    public static InterfaceC4149a<AgentProxyCommand> getEntries() {
        return $ENTRIES;
    }

    public static AgentProxyCommand valueOf(String str) {
        return (AgentProxyCommand) Enum.valueOf(AgentProxyCommand.class, str);
    }

    public static AgentProxyCommand[] values() {
        return (AgentProxyCommand[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
