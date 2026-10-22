package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes.dex */
public class NullAgentLog implements AgentLog {
    public NullAgentLog() {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return 5;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r10) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10, Throwable r11) {
    }
}
