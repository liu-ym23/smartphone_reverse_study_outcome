package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes.dex */
public class ConsoleAgentLog implements AgentLog {
    private int mLevel;

    public ConsoleAgentLog() {
        this.mLevel = 3;
    }

    private static void print(String r10, String r11) {
        System.out.println("[" + r10 + "] " + r11);
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r10) {
        if (this.mLevel != 6) goto L6;
        print("AUDIT", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r10) {
        if (this.mLevel < 5) goto L6;
        print("DEBUG", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10, Throwable r11) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r10 + " " + r11.getMessage());
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.mLevel;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r10) {
        if (this.mLevel < 3) goto L6;
        print("INFO", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r10) {
        this.mLevel = r10;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r10) {
        if (this.mLevel < 4) goto L6;
        print("VERBOSE", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r10) {
        if (this.mLevel < 2) goto L6;
        print("WARN", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r10);
        return;
    }
}
