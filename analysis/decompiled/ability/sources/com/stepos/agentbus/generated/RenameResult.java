package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentbus/generated/RenameResult;", "", "ok", "", "task", "Lcom/stepos/agentbus/generated/Task;", "error", "Lcom/stepos/agentbus/generated/ErrorShape;", AppAgent.CONSTRUCT, "(ZLcom/stepos/agentbus/generated/Task;Lcom/stepos/agentbus/generated/ErrorShape;)V", "getOk", "()Z", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getError", "()Lcom/stepos/agentbus/generated/ErrorShape;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RenameResult {
    private final ErrorShape error;
    private final boolean ok;
    private final Task task;

    public RenameResult(boolean z10, Task task, ErrorShape errorShape) {
        this.ok = z10;
        this.task = task;
        this.error = errorShape;
    }

    public static /* synthetic */ RenameResult copy$default(RenameResult renameResult, boolean z10, Task task, ErrorShape errorShape, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = renameResult.ok;
        }
        if ((i & 2) != 0) {
            task = renameResult.task;
        }
        if ((i & 4) != 0) {
            errorShape = renameResult.error;
        }
        return renameResult.copy(z10, task, errorShape);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final Task getTask() {
        return this.task;
    }

    /* renamed from: component3, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final RenameResult copy(boolean ok, Task task, ErrorShape error) {
        return new RenameResult(ok, task, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenameResult)) {
            return false;
        }
        RenameResult renameResult = (RenameResult) other;
        return this.ok == renameResult.ok && k.b(this.task, renameResult.task) && k.b(this.error, renameResult.error);
    }

    public final ErrorShape getError() {
        return this.error;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final Task getTask() {
        return this.task;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        Task task = this.task;
        int iHashCode2 = (iHashCode + (task == null ? 0 : task.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode2 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "RenameResult(ok=" + this.ok + ", task=" + this.task + ", error=" + this.error + ")";
    }
}
