package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes.dex */
public class AgentLogManager {
    private static DefaultAgentLog instance;

    static {
        instance = new DefaultAgentLog();
    }

    public AgentLogManager() {
    }

    public static AgentLog getAgentLog() {
        return instance;
    }

    public static void setAgentLog(AgentLog r10) {
        instance.setImpl(r10);
    }
}
