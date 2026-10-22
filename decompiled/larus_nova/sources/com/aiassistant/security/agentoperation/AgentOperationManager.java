package com.aiassistant.security.agentoperation;

/* JADX INFO: loaded from: classes28.dex */
public final class AgentOperationManager {
    public static final String ACTION_AGENT_OPERATION_STATUS_CHANGED = "com.aiassistant.agentrobots.action.AGENT_OPERATION_STATUS_CHANGED";
    public static final String EXTRA_AGENT_UUID = "agent_uuid";
    public static final String EXTRA_STATUS = "status";
    public static final String STATUS_START = "start";
    public static final String STATUS_STOP = "stop";

    public static AgentOperationManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    private AgentOperationManager() {
        throw new RuntimeException("Stub!!");
    }

    public void notifyOperationState(String r100, String r101, String r102) {
        throw new RuntimeException("Stub!!");
    }
}
