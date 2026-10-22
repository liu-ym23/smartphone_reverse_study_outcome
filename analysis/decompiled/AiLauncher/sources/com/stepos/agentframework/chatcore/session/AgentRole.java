package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentRole;", "", "<init>", "(Ljava/lang/String;I)V", "SYSTEM", "USER", "ASSISTANT", "TOOL", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentRole {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentRole[] $VALUES;
    public static final AgentRole SYSTEM = new AgentRole("SYSTEM", 0);
    public static final AgentRole USER = new AgentRole("USER", 1);
    public static final AgentRole ASSISTANT = new AgentRole("ASSISTANT", 2);
    public static final AgentRole TOOL = new AgentRole("TOOL", 3);

    private static final /* synthetic */ AgentRole[] $values() {
        return new AgentRole[]{SYSTEM, USER, ASSISTANT, TOOL};
    }

    static {
        AgentRole[] agentRoleArr$values = $values();
        $VALUES = agentRoleArr$values;
        $ENTRIES = kotlin.enums.a.a(agentRoleArr$values);
    }

    private AgentRole(String str, int i10) {
    }

    public static InterfaceC4149a<AgentRole> getEntries() {
        return $ENTRIES;
    }

    public static AgentRole valueOf(String str) {
        return (AgentRole) Enum.valueOf(AgentRole.class, str);
    }

    public static AgentRole[] values() {
        return (AgentRole[]) $VALUES.clone();
    }
}
