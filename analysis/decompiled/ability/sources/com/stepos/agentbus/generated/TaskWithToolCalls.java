package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentbus/generated/TaskWithToolCalls;", "", "task", "Lcom/stepos/agentbus/generated/Task;", "recentToolCalls", "", "Lcom/stepos/agentbus/generated/TaskToolCall;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/Task;Ljava/util/List;)V", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getRecentToolCalls", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskWithToolCalls {
    private final List<TaskToolCall> recentToolCalls;
    private final Task task;

    public TaskWithToolCalls(Task task, List<TaskToolCall> recentToolCalls) {
        k.f(task, "task");
        k.f(recentToolCalls, "recentToolCalls");
        this.task = task;
        this.recentToolCalls = recentToolCalls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskWithToolCalls copy$default(TaskWithToolCalls taskWithToolCalls, Task task, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            task = taskWithToolCalls.task;
        }
        if ((i & 2) != 0) {
            list = taskWithToolCalls.recentToolCalls;
        }
        return taskWithToolCalls.copy(task, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Task getTask() {
        return this.task;
    }

    public final List<TaskToolCall> component2() {
        return this.recentToolCalls;
    }

    public final TaskWithToolCalls copy(Task task, List<TaskToolCall> recentToolCalls) {
        k.f(task, "task");
        k.f(recentToolCalls, "recentToolCalls");
        return new TaskWithToolCalls(task, recentToolCalls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskWithToolCalls)) {
            return false;
        }
        TaskWithToolCalls taskWithToolCalls = (TaskWithToolCalls) other;
        return k.b(this.task, taskWithToolCalls.task) && k.b(this.recentToolCalls, taskWithToolCalls.recentToolCalls);
    }

    public final List<TaskToolCall> getRecentToolCalls() {
        return this.recentToolCalls;
    }

    public final Task getTask() {
        return this.task;
    }

    public int hashCode() {
        return this.recentToolCalls.hashCode() + (this.task.hashCode() * 31);
    }

    public String toString() {
        return "TaskWithToolCalls(task=" + this.task + ", recentToolCalls=" + this.recentToolCalls + ")";
    }
}
