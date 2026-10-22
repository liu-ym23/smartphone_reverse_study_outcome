package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes14.dex */
public class AgentLogManager {
    private static DefaultAgentLog instance;

    public AgentLogManager() {
    }

    static {
        instance = new DefaultAgentLog();
    }

    public static AgentLog getAgentLog() {
        return instance;
    }

    public static void setAgentLog(AgentLog r100) {
        instance.setImpl(r100);
    }
}
