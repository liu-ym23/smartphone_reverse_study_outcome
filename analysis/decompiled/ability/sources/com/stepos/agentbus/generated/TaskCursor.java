package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/generated/TaskCursor;", "", "updatedAt", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", AppAgent.CONSTRUCT, "(JLjava/lang/String;)V", "getUpdatedAt", "()J", "getTaskId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskCursor {
    private final String taskId;
    private final long updatedAt;

    public TaskCursor(long j5, String taskId) {
        k.f(taskId, "taskId");
        this.updatedAt = j5;
        this.taskId = taskId;
    }

    public static /* synthetic */ TaskCursor copy$default(TaskCursor taskCursor, long j5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = taskCursor.updatedAt;
        }
        if ((i & 2) != 0) {
            str = taskCursor.taskId;
        }
        return taskCursor.copy(j5, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final TaskCursor copy(long updatedAt, String taskId) {
        k.f(taskId, "taskId");
        return new TaskCursor(updatedAt, taskId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskCursor)) {
            return false;
        }
        TaskCursor taskCursor = (TaskCursor) other;
        return this.updatedAt == taskCursor.updatedAt && k.b(this.taskId, taskCursor.taskId);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return this.taskId.hashCode() + (Long.hashCode(this.updatedAt) * 31);
    }

    public String toString() {
        return "TaskCursor(updatedAt=" + this.updatedAt + ", taskId=" + this.taskId + ")";
    }
}
