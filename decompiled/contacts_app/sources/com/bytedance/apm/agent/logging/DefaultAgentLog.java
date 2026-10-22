package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAgentLog implements AgentLog {
    private AgentLog impl;

    public DefaultAgentLog() {
        this.impl = new NullAgentLog();
    }

    public void setImpl(AgentLog r1) {
        monitor-enter(this);
        this.impl = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r2) {
        monitor-enter(this);
        this.impl.audit(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r2) {
        monitor-enter(this);
        this.impl.debug(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r2) {
        monitor-enter(this);
        this.impl.info(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r2) {
        monitor-enter(this);
        this.impl.verbose(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r2) {
        monitor-enter(this);
        this.impl.warning(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r2) {
        monitor-enter(this);
        this.impl.error(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r2, Throwable r3) {
        monitor-enter(this);
        this.impl.error(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        monitor-enter(this);
        int r0 = this.impl.getLevel();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r2) {
        monitor-enter(this);
        this.impl.setLevel(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
