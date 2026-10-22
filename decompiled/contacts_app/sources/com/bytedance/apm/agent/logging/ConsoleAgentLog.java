package com.bytedance.apm.agent.logging;

import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes2.dex */
public class ConsoleAgentLog implements AgentLog {
    private int mLevel;

    public ConsoleAgentLog() {
        this.mLevel = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r2) {
        if (this.mLevel != 6) goto L6;
        print("AUDIT", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r2) {
        if (this.mLevel < 5) goto L6;
        print("DEBUG", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r2) {
        if (this.mLevel < 4) goto L6;
        print("VERBOSE", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r2) {
        if (this.mLevel < 3) goto L6;
        print("INFO", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r2) {
        if (this.mLevel < 2) goto L6;
        print("WARN", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r2, Throwable r3) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r2 + HanziToPinyin.Token.SEPARATOR + r3.getMessage());
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r2) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.mLevel;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r1) {
        this.mLevel = r1;
    }

    private static void print(String r3, String r4) {
        System.out.println("[" + r3 + "] " + r4);
    }
}
