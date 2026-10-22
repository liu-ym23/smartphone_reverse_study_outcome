package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentbus/generated/TaskProgress;", "", FlowType.COMPLETED, "", "total", FlowType.FAILED, "inProgress", "pending", AppAgent.CONSTRUCT, "(IIIII)V", "getCompleted", "()I", "getTotal", "getFailed", "getInProgress", "getPending", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskProgress {
    private final int completed;
    private final int failed;
    private final int inProgress;
    private final int pending;
    private final int total;

    public TaskProgress() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ TaskProgress copy$default(TaskProgress taskProgress, int i, int i6, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i = taskProgress.completed;
        }
        if ((i13 & 2) != 0) {
            i6 = taskProgress.total;
        }
        if ((i13 & 4) != 0) {
            i10 = taskProgress.failed;
        }
        if ((i13 & 8) != 0) {
            i11 = taskProgress.inProgress;
        }
        if ((i13 & 16) != 0) {
            i12 = taskProgress.pending;
        }
        int i14 = i12;
        int i15 = i10;
        return taskProgress.copy(i, i6, i15, i11, i14);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCompleted() {
        return this.completed;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFailed() {
        return this.failed;
    }

    /* renamed from: component4, reason: from getter */
    public final int getInProgress() {
        return this.inProgress;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPending() {
        return this.pending;
    }

    public final TaskProgress copy(int completed, int total, int failed, int inProgress, int pending) {
        return new TaskProgress(completed, total, failed, inProgress, pending);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskProgress)) {
            return false;
        }
        TaskProgress taskProgress = (TaskProgress) other;
        return this.completed == taskProgress.completed && this.total == taskProgress.total && this.failed == taskProgress.failed && this.inProgress == taskProgress.inProgress && this.pending == taskProgress.pending;
    }

    public final int getCompleted() {
        return this.completed;
    }

    public final int getFailed() {
        return this.failed;
    }

    public final int getInProgress() {
        return this.inProgress;
    }

    public final int getPending() {
        return this.pending;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return Integer.hashCode(this.pending) + androidx.constraintlayout.core.dsl.a.a(this.inProgress, androidx.constraintlayout.core.dsl.a.a(this.failed, androidx.constraintlayout.core.dsl.a.a(this.total, Integer.hashCode(this.completed) * 31, 31), 31), 31);
    }

    public String toString() {
        int i = this.completed;
        int i6 = this.total;
        int i10 = this.failed;
        int i11 = this.inProgress;
        int i12 = this.pending;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "TaskProgress(completed=", i6, ", total=", ", failed=");
        androidx.constraintlayout.core.dsl.a.y(sbS, i10, ", inProgress=", i11, ", pending=");
        return androidx.appfunctions.metadata.a.o(sbS, ")", i12);
    }

    public TaskProgress(int i, int i6, int i10, int i11, int i12) {
        this.completed = i;
        this.total = i6;
        this.failed = i10;
        this.inProgress = i11;
        this.pending = i12;
    }

    public /* synthetic */ TaskProgress(int i, int i6, int i10, int i11, int i12, int i13, e eVar) {
        this((i13 & 1) != 0 ? 0 : i, (i13 & 2) != 0 ? 0 : i6, (i13 & 4) != 0 ? 0 : i10, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12);
    }
}
