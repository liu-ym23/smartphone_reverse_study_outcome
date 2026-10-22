package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidAgentLog implements AgentLog {
    private static final String TAG = "[tt_apm]";
    private int level;

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
    public void info(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r100) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r100) {
    }

    public AndroidAgentLog() {
        this.level = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r100) {
        if (r100 > 6) goto L9;
        if (r100 < 1) goto L9;
        this.level = r100;
        return;
    L9:
        throw new IllegalArgumentException("Log level is not between ERROR and AUDIT");
    }
}
