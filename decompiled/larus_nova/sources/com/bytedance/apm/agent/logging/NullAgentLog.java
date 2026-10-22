package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes14.dex */
public class NullAgentLog implements AgentLog {
    public NullAgentLog() {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r100, Throwable r101) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return 5;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r100) {
    }
}
