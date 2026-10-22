package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class AgentMessage$RequestCase {

    /* renamed from: a, reason: collision with root package name */
    public static final AgentMessage$RequestCase f4247a;
    public static final AgentMessage$RequestCase b;
    public static final /* synthetic */ AgentMessage$RequestCase[] c;

    static {
        AgentMessage$RequestCase agentMessage$RequestCase = new AgentMessage$RequestCase("GET_STORE_REQUEST", 0);
        f4247a = agentMessage$RequestCase;
        AgentMessage$RequestCase agentMessage$RequestCase2 = new AgentMessage$RequestCase("REQUEST_NOT_SET", 1);
        b = agentMessage$RequestCase2;
        c = new AgentMessage$RequestCase[]{agentMessage$RequestCase, agentMessage$RequestCase2};
    }

    public static AgentMessage$RequestCase valueOf(String str) {
        return (AgentMessage$RequestCase) Enum.valueOf(AgentMessage$RequestCase.class, str);
    }

    public static AgentMessage$RequestCase[] values() {
        return (AgentMessage$RequestCase[]) c.clone();
    }
}
