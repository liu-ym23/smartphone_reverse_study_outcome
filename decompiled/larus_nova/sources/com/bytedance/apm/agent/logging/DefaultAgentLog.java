package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultAgentLog implements AgentLog {
    private AgentLog impl;

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        monitor-enter(this);
        int r100 = this.impl.getLevel();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public DefaultAgentLog() {
        this.impl = new NullAgentLog();
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r100) {
        monitor-enter(this);
        this.impl.audit(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r100) {
        monitor-enter(this);
        this.impl.debug(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r100) {
        monitor-enter(this);
        this.impl.error(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r100) {
        monitor-enter(this);
        this.impl.info(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setImpl(AgentLog r100) {
        monitor-enter(this);
        this.impl = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r100) {
        monitor-enter(this);
        this.impl.setLevel(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r100) {
        monitor-enter(this);
        this.impl.verbose(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r100) {
        monitor-enter(this);
        this.impl.warning(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r100, Throwable r101) {
        monitor-enter(this);
        this.impl.error(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
