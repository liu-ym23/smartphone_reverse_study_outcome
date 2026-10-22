package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/stepos/agentbus/generated/BatchDeleteItem;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", "ok", "", "deletedAt", "", "error", "Lcom/stepos/agentbus/generated/ErrorShape;", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLjava/lang/Long;Lcom/stepos/agentbus/generated/ErrorShape;)V", "getTaskId", "()Ljava/lang/String;", "getOk", "()Z", "getDeletedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getError", "()Lcom/stepos/agentbus/generated/ErrorShape;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ZLjava/lang/Long;Lcom/stepos/agentbus/generated/ErrorShape;)Lcom/stepos/agentbus/generated/BatchDeleteItem;", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchDeleteItem {
    private final Long deletedAt;
    private final ErrorShape error;
    private final boolean ok;
    private final String taskId;

    public BatchDeleteItem(String taskId, boolean z10, Long l, ErrorShape errorShape) {
        k.f(taskId, "taskId");
        this.taskId = taskId;
        this.ok = z10;
        this.deletedAt = l;
        this.error = errorShape;
    }

    public static /* synthetic */ BatchDeleteItem copy$default(BatchDeleteItem batchDeleteItem, String str, boolean z10, Long l, ErrorShape errorShape, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batchDeleteItem.taskId;
        }
        if ((i & 2) != 0) {
            z10 = batchDeleteItem.ok;
        }
        if ((i & 4) != 0) {
            l = batchDeleteItem.deletedAt;
        }
        if ((i & 8) != 0) {
            errorShape = batchDeleteItem.error;
        }
        return batchDeleteItem.copy(str, z10, l, errorShape);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getDeletedAt() {
        return this.deletedAt;
    }

    /* renamed from: component4, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final BatchDeleteItem copy(String taskId, boolean ok, Long deletedAt, ErrorShape error) {
        k.f(taskId, "taskId");
        return new BatchDeleteItem(taskId, ok, deletedAt, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchDeleteItem)) {
            return false;
        }
        BatchDeleteItem batchDeleteItem = (BatchDeleteItem) other;
        return k.b(this.taskId, batchDeleteItem.taskId) && this.ok == batchDeleteItem.ok && k.b(this.deletedAt, batchDeleteItem.deletedAt) && k.b(this.error, batchDeleteItem.error);
    }

    public final Long getDeletedAt() {
        return this.deletedAt;
    }

    public final ErrorShape getError() {
        return this.error;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(this.taskId.hashCode() * 31, 31, this.ok);
        Long l = this.deletedAt;
        int iHashCode = (iD + (l == null ? 0 : l.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        boolean z10 = this.ok;
        Long l = this.deletedAt;
        ErrorShape errorShape = this.error;
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("BatchDeleteItem(taskId=", str, ", ok=", ", deletedAt=", z10);
        sbL.append(l);
        sbL.append(", error=");
        sbL.append(errorShape);
        sbL.append(")");
        return sbL.toString();
    }

    public /* synthetic */ BatchDeleteItem(String str, boolean z10, Long l, ErrorShape errorShape, int i, e eVar) {
        this(str, z10, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : errorShape);
    }
}
