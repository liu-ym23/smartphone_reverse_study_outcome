package com.stepos.core.model.task;

import com.stepos.core.common.telemetry.e;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AITaskStack {
    private final PriorityBlockingQueue<TaskSession> sessionQueue = new PriorityBlockingQueue<>(11, new Comparator() { // from class: com.stepos.core.model.task.AITaskStack$special$$inlined$compareBy$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t8, T t10) {
            return ob.b.a(Integer.valueOf(((TaskSession) t8).getPriority().f6402a), Integer.valueOf(((TaskSession) t10).getPriority().f6402a));
        }
    });
    private final ConcurrentHashMap<String, TaskSession> runningSessions = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, TaskSession> allSessions = new ConcurrentHashMap<>();
    private final PriorityBlockingQueue<AITaskRecord> waitingQueue = new PriorityBlockingQueue<>(11, new Comparator() { // from class: com.stepos.core.model.task.AITaskStack$special$$inlined$compareBy$2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t8, T t10) {
            return ob.b.a(Integer.valueOf(((AITaskRecord) t8).getPriority().f6402a), Integer.valueOf(((AITaskRecord) t10).getPriority().f6402a));
        }
    });
    private final ConcurrentHashMap<String, AITaskRecord> runningTasks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AITaskRecord> allTasks = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean markCancelled$lambda$10(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean markCancelled$lambda$9(String str, AITaskRecord aITaskRecord) {
        return g.b(aITaskRecord.getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean markSessionCancelled$lambda$2(String str, TaskSession taskSession) {
        return g.b(taskSession.getRequest().f9710a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean markSessionCancelled$lambda$3(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean remove$lambda$13(String str, AITaskRecord aITaskRecord) {
        return g.b(aITaskRecord.getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean remove$lambda$14(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSession$lambda$4(String str, TaskSession taskSession) {
        return g.b(taskSession.getRequest().f9710a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSession$lambda$5(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final void clear() {
        this.waitingQueue.clear();
        this.runningTasks.clear();
        this.allTasks.clear();
        this.sessionQueue.clear();
        this.runningSessions.clear();
        this.allSessions.clear();
    }

    public final void enqueue(TaskSession session) {
        g.f(session, "session");
        session.setState(TaskSessionState.QUEUED);
        session.setEnqueueTimeMs(System.currentTimeMillis());
        this.allSessions.put(session.getRequest().f9710a, session);
        this.sessionQueue.offer(session);
    }

    public final int getRunningCount() {
        return this.runningSessions.size() + this.runningTasks.size();
    }

    public final List<AITaskRecord> getRunningTasks() {
        Collection<AITaskRecord> collectionValues = this.runningTasks.values();
        g.e(collectionValues, "<get-values>(...)");
        return kotlin.collections.a.O0(collectionValues);
    }

    public final TaskSession getSession(String taskId) {
        g.f(taskId, "taskId");
        return this.allSessions.get(taskId);
    }

    public final AITaskRecord getTask(String taskId) {
        g.f(taskId, "taskId");
        return this.allTasks.get(taskId);
    }

    public final int getTotalCount() {
        return this.allSessions.size() + this.allTasks.size();
    }

    public final int getWaitingCount() {
        return this.sessionQueue.size() + this.waitingQueue.size();
    }

    public final List<AITaskRecord> getWaitingTasks() {
        return kotlin.collections.a.O0(this.waitingQueue);
    }

    public final boolean hasRunningTasks() {
        return (this.runningTasks.isEmpty() && this.runningSessions.isEmpty()) ? false : true;
    }

    public final boolean hasWaitingTasks() {
        return (this.waitingQueue.isEmpty() && this.sessionQueue.isEmpty()) ? false : true;
    }

    public final void markCancelled(String taskId) {
        g.f(taskId, "taskId");
        this.waitingQueue.removeIf(new e(new com.stepos.core.common.telemetry.d(taskId, 2), 2));
        AITaskRecord aITaskRecordRemove = this.runningTasks.remove(taskId);
        if (aITaskRecordRemove != null) {
            aITaskRecordRemove.transitionTo(AITaskState.CANCELLED);
        }
        AITaskRecord aITaskRecord = this.allTasks.get(taskId);
        if (aITaskRecord != null) {
            aITaskRecord.transitionTo(AITaskState.CANCELLED);
        }
        markSessionCancelled(taskId);
    }

    public final void markCompleted(String taskId, boolean z) {
        g.f(taskId, "taskId");
        AITaskRecord aITaskRecordRemove = this.runningTasks.remove(taskId);
        if (aITaskRecordRemove != null) {
            aITaskRecordRemove.transitionTo(z ? AITaskState.COMPLETED : AITaskState.FAILED);
        }
        markSessionCompleted(taskId, z);
    }

    public final void markRunning(TaskSession session) {
        g.f(session, "session");
        session.markStarted();
        this.runningSessions.put(session.getRequest().f9710a, session);
    }

    public final void markSessionCancelled(String taskId) {
        g.f(taskId, "taskId");
        this.sessionQueue.removeIf(new e(new com.stepos.core.common.telemetry.d(taskId, 4), 4));
        TaskSession taskSessionRemove = this.runningSessions.remove(taskId);
        if (taskSessionRemove != null) {
            taskSessionRemove.markCancelled();
        }
        TaskSession taskSession = this.allSessions.get(taskId);
        if (taskSession != null) {
            taskSession.markCancelled();
        }
    }

    public final void markSessionCompleted(String taskId, boolean z) {
        g.f(taskId, "taskId");
        TaskSession taskSessionRemove = this.runningSessions.remove(taskId);
        if (taskSessionRemove != null) {
            if (z) {
                taskSessionRemove.markCompleted();
            } else {
                taskSessionRemove.markFailed(0, null);
            }
        }
    }

    public final void markSessionTimeout(String taskId) {
        g.f(taskId, "taskId");
        TaskSession taskSessionRemove = this.runningSessions.remove(taskId);
        if (taskSessionRemove != null) {
            taskSessionRemove.markTimeout();
        }
    }

    public final void markTimeout(String taskId) {
        g.f(taskId, "taskId");
        AITaskRecord aITaskRecordRemove = this.runningTasks.remove(taskId);
        if (aITaskRecordRemove != null) {
            aITaskRecordRemove.transitionTo(AITaskState.TIMEOUT);
        }
        markSessionTimeout(taskId);
    }

    public final AITaskRecord peekNext() {
        return this.waitingQueue.peek();
    }

    public final AITaskRecord pollNext() {
        return this.waitingQueue.poll();
    }

    public final void remove(String taskId) {
        g.f(taskId, "taskId");
        this.allTasks.remove(taskId);
        this.runningTasks.remove(taskId);
        this.waitingQueue.removeIf(new e(new com.stepos.core.common.telemetry.d(taskId, 1), 1));
        removeSession(taskId);
    }

    public final void removeSession(String taskId) {
        g.f(taskId, "taskId");
        this.allSessions.remove(taskId);
        this.runningSessions.remove(taskId);
        int i10 = 3;
        this.sessionQueue.removeIf(new e(new com.stepos.core.common.telemetry.d(taskId, i10), i10));
    }

    public final void markRunning(AITaskRecord task) {
        g.f(task, "task");
        task.transitionTo(AITaskState.RUNNING);
        this.runningTasks.put(task.getId(), task);
    }

    public final void enqueue(AITaskRecord task) {
        g.f(task, "task");
        task.transitionTo(AITaskState.QUEUED);
        task.setQueuedAt(Long.valueOf(System.currentTimeMillis()));
        this.allTasks.put(task.getId(), task);
        this.waitingQueue.offer(task);
    }
}
