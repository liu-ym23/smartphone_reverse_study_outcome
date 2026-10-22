package com.stepos.ailauncher.foundation.task.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/foundation/task/entity/UiAgentNotify;", "", "taskId", "", "<init>", "(Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiAgentNotify {
    private final String taskId;

    public UiAgentNotify(String taskId) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
    }

    public static /* synthetic */ UiAgentNotify copy$default(UiAgentNotify uiAgentNotify, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = uiAgentNotify.taskId;
        }
        return uiAgentNotify.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final UiAgentNotify copy(String taskId) {
        p.i(taskId, "taskId");
        return new UiAgentNotify(taskId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UiAgentNotify) && p.d(this.taskId, ((UiAgentNotify) other).taskId);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return this.taskId.hashCode();
    }

    public String toString() {
        return "UiAgentNotify(taskId=" + this.taskId + ")";
    }
}
