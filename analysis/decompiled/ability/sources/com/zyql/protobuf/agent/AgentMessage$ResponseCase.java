package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class AgentMessage$ResponseCase {

    /* renamed from: a, reason: collision with root package name */
    public static final AgentMessage$ResponseCase f4248a;
    public static final AgentMessage$ResponseCase b;
    public static final AgentMessage$ResponseCase c;
    public static final AgentMessage$ResponseCase d;
    public static final AgentMessage$ResponseCase e;
    public static final /* synthetic */ AgentMessage$ResponseCase[] f;

    static {
        AgentMessage$ResponseCase agentMessage$ResponseCase = new AgentMessage$ResponseCase("GET_AGENT_INFO_RESPONSE", 0);
        f4248a = agentMessage$ResponseCase;
        AgentMessage$ResponseCase agentMessage$ResponseCase2 = new AgentMessage$ResponseCase("TOOL_EXECUTION_RESULT", 1);
        b = agentMessage$ResponseCase2;
        AgentMessage$ResponseCase agentMessage$ResponseCase3 = new AgentMessage$ResponseCase("HOOK_EXECUTION_RESULT", 2);
        c = agentMessage$ResponseCase3;
        AgentMessage$ResponseCase agentMessage$ResponseCase4 = new AgentMessage$ResponseCase("ERROR", 3);
        d = agentMessage$ResponseCase4;
        AgentMessage$ResponseCase agentMessage$ResponseCase5 = new AgentMessage$ResponseCase("RESPONSE_NOT_SET", 4);
        e = agentMessage$ResponseCase5;
        f = new AgentMessage$ResponseCase[]{agentMessage$ResponseCase, agentMessage$ResponseCase2, agentMessage$ResponseCase3, agentMessage$ResponseCase4, agentMessage$ResponseCase5};
    }

    public static AgentMessage$ResponseCase valueOf(String str) {
        return (AgentMessage$ResponseCase) Enum.valueOf(AgentMessage$ResponseCase.class, str);
    }

    public static AgentMessage$ResponseCase[] values() {
        return (AgentMessage$ResponseCase[]) f.clone();
    }
}
