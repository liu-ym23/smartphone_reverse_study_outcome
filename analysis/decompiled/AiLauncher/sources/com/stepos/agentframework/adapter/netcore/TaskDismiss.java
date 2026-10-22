package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/z;", "", "", "taskId", "surface", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.z, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskDismiss {
    private final String reason;
    private final String surface;
    private final String taskId;

    public TaskDismiss(String taskId, String surface, String reason) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(surface, "surface");
        kotlin.jvm.internal.p.i(reason, "reason");
        this.taskId = taskId;
        this.surface = surface;
        this.reason = reason;
    }

    /* renamed from: a, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: b, reason: from getter */
    public final String getSurface() {
        return this.surface;
    }

    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskDismiss)) {
            return false;
        }
        TaskDismiss taskDismiss = (TaskDismiss) other;
        return kotlin.jvm.internal.p.d(this.taskId, taskDismiss.taskId) && kotlin.jvm.internal.p.d(this.surface, taskDismiss.surface) && kotlin.jvm.internal.p.d(this.reason, taskDismiss.reason);
    }

    public int hashCode() {
        return (((this.taskId.hashCode() * 31) + this.surface.hashCode()) * 31) + this.reason.hashCode();
    }

    public String toString() {
        return "TaskDismiss(taskId=" + this.taskId + ", surface=" + this.surface + ", reason=" + this.reason + ")";
    }
}
