package com.ttnet.org.chromium.base.task;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class d implements TaskExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f18353a;

    public d() {
        this.f18353a = new HashMap();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(e r10) {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(e r10) {
        throw null;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(e r10) {
        throw null;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(e r10) {
        throw null;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(e r10, Runnable r11, long r12) {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
