package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes14.dex */
public class ConsoleAgentLog implements AgentLog {
    private int mLevel;

    public ConsoleAgentLog() {
        this.mLevel = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.mLevel;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r100) {
        if (this.mLevel != 6) goto L6;
        print("AUDIT", r100);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r100) {
        if (this.mLevel < 5) goto L6;
        print("DEBUG", r100);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r100) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r100);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r100) {
        if (this.mLevel < 3) goto L6;
        print("INFO", r100);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r100) {
        this.mLevel = r100;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r100) {
        if (this.mLevel < 4) goto L6;
        print("VERBOSE", r100);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r100) {
        if (this.mLevel < 2) goto L6;
        print("WARN", r100);
        return;
    }

    private static void print(String r100, String r101) {
        System.out.println("[" + r100 + "] " + r101);
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r100, Throwable r101) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r100 + " " + r101.getMessage());
        return;
    }
}
