package com.bytedance.apm.agent.logging;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAgentLog implements AgentLog {
    private static final String TAG = "[tt_apm]";
    private int level;

    public AndroidAgentLog() {
        this.level = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r10) {
        if (this.level != 6) goto L6;
        Log.d("[tt_apm]", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r10) {
        if (this.level < 5) goto L6;
        Log.d("[tt_apm]", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10) {
        if (this.level < 1) goto L6;
        Log.e("[tt_apm]", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r10) {
        if (this.level < 3) goto L6;
        Log.i("[tt_apm]", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r10) {
        if (r10 > 6) goto L9;
        if (r10 < 1) goto L9;
        this.level = r10;
        return;
    L9:
        throw new IllegalArgumentException("Log level is not between ERROR and AUDIT");
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r10) {
        if (this.level < 4) goto L6;
        Log.v("[tt_apm]", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r10) {
        if (this.level < 2) goto L6;
        Log.w("[tt_apm]", r10);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10, Throwable r11) {
        if (this.level < 1) goto L6;
        Log.e("[tt_apm]", r10, r11);
        return;
    }
}
