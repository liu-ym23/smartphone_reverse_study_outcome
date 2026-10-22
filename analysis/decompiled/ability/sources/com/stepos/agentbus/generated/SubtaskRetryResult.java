package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentbus/generated/SubtaskRetryResult;", "", "task", "Lcom/stepos/agentbus/generated/Task;", "subtask", "error", "Lcom/stepos/agentbus/generated/ErrorShape;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/Task;Lcom/stepos/agentbus/generated/Task;Lcom/stepos/agentbus/generated/ErrorShape;)V", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getSubtask", "getError", "()Lcom/stepos/agentbus/generated/ErrorShape;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubtaskRetryResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorShape error;
    private final Task subtask;
    private final Task task;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/stepos/agentbus/generated/SubtaskRetryResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "error", "Lcom/stepos/agentbus/generated/SubtaskRetryResult;", "code", "", "message", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final SubtaskRetryResult error(String code, String message) {
            k.f(code, "code");
            k.f(message, "message");
            return new SubtaskRetryResult(null, null, new ErrorShape(code, message));
        }

        private Companion() {
        }
    }

    public SubtaskRetryResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SubtaskRetryResult copy$default(SubtaskRetryResult subtaskRetryResult, Task task, Task task2, ErrorShape errorShape, int i, Object obj) {
        if ((i & 1) != 0) {
            task = subtaskRetryResult.task;
        }
        if ((i & 2) != 0) {
            task2 = subtaskRetryResult.subtask;
        }
        if ((i & 4) != 0) {
            errorShape = subtaskRetryResult.error;
        }
        return subtaskRetryResult.copy(task, task2, errorShape);
    }

    /* renamed from: component1, reason: from getter */
    public final Task getTask() {
        return this.task;
    }

    /* renamed from: component2, reason: from getter */
    public final Task getSubtask() {
        return this.subtask;
    }

    /* renamed from: component3, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final SubtaskRetryResult copy(Task task, Task subtask, ErrorShape error) {
        return new SubtaskRetryResult(task, subtask, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtaskRetryResult)) {
            return false;
        }
        SubtaskRetryResult subtaskRetryResult = (SubtaskRetryResult) other;
        return k.b(this.task, subtaskRetryResult.task) && k.b(this.subtask, subtaskRetryResult.subtask) && k.b(this.error, subtaskRetryResult.error);
    }

    public final ErrorShape getError() {
        return this.error;
    }

    public final Task getSubtask() {
        return this.subtask;
    }

    public final Task getTask() {
        return this.task;
    }

    public int hashCode() {
        Task task = this.task;
        int iHashCode = (task == null ? 0 : task.hashCode()) * 31;
        Task task2 = this.subtask;
        int iHashCode2 = (iHashCode + (task2 == null ? 0 : task2.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode2 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "SubtaskRetryResult(task=" + this.task + ", subtask=" + this.subtask + ", error=" + this.error + ")";
    }

    public SubtaskRetryResult(Task task, Task task2, ErrorShape errorShape) {
        this.task = task;
        this.subtask = task2;
        this.error = errorShape;
    }

    public /* synthetic */ SubtaskRetryResult(Task task, Task task2, ErrorShape errorShape, int i, e eVar) {
        this((i & 1) != 0 ? null : task, (i & 2) != 0 ? null : task2, (i & 4) != 0 ? null : errorShape);
    }
}
