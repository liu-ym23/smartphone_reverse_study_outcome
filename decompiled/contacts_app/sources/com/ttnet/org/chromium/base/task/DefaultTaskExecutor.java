package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap;

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits r1) {
        return false;
    }

    DefaultTaskExecutor() {
        this.mTraitsToRunnerMap = new HashMap();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits r2) {
        if (r2.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new TaskRunnerImpl(r2);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits r2) {
        if (r2.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SequencedTaskRunnerImpl(r2);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r2) {
        if (r2.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SingleThreadTaskRunnerImpl(null, r2);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits r3, Runnable r4, long r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r3.hasExtension() == false) goto L6;
        createTaskRunner(r3).postDelayedTask(r4, r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        TaskRunner r0 = this.mTraitsToRunnerMap.get(r3);     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        r0 = createTaskRunner(r3);     // Catch: Throwable -> L12
        this.mTraitsToRunnerMap.put(r3, r0);     // Catch: Throwable -> L12
    L9:
        r0.postDelayedTask(r4, r5);     // Catch: Throwable -> L12
        goto L10
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        monitor-enter(this);
        ChoreographerTaskRunner r0 = (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(new DefaultTaskExecutor$$ExternalSyntheticLambda0());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() throws Exception {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }
}
