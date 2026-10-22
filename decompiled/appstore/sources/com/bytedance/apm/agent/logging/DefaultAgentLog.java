package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAgentLog implements AgentLog {
    private AgentLog impl;

    public DefaultAgentLog() {
        this.impl = new NullAgentLog();
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r10) {
        monitor-enter(this);
        this.impl.audit(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r10) {
        monitor-enter(this);
        this.impl.debug(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10) {
        monitor-enter(this);
        this.impl.error(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        monitor-enter(this);
        int r10 = this.impl.getLevel();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r10) {
        monitor-enter(this);
        this.impl.info(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setImpl(AgentLog r10) {
        monitor-enter(this);
        this.impl = r10;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r10) {
        monitor-enter(this);
        this.impl.setLevel(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r10) {
        monitor-enter(this);
        this.impl.verbose(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r10) {
        monitor-enter(this);
        this.impl.warning(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r10, Throwable r11) {
        monitor-enter(this);
        this.impl.error(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
