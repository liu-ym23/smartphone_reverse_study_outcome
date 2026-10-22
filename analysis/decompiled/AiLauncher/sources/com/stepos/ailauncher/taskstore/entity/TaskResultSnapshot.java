package com.stepos.ailauncher.taskstore.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskResultSnapshot;", "", "taskId", "", "sequence", "", "result", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "savedAt", "", "<init>", "(Ljava/lang/String;ILjava/util/List;J)V", "getTaskId", "()Ljava/lang/String;", "getSequence", "()I", "getResult", "()Ljava/util/List;", "getSavedAt", "()J", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskResultSnapshot {
    private final List<TaskInfoPart> result;
    private final long savedAt;
    private final int sequence;
    private final String taskId;

    public TaskResultSnapshot(String taskId, int i10, List<TaskInfoPart> result, long j10) {
        p.i(taskId, "taskId");
        p.i(result, "result");
        this.taskId = taskId;
        this.sequence = i10;
        this.result = result;
        this.savedAt = j10;
    }

    public static /* synthetic */ TaskResultSnapshot copy$default(TaskResultSnapshot taskResultSnapshot, String str, int i10, List list, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = taskResultSnapshot.taskId;
        }
        if ((i11 & 2) != 0) {
            i10 = taskResultSnapshot.sequence;
        }
        if ((i11 & 4) != 0) {
            list = taskResultSnapshot.result;
        }
        if ((i11 & 8) != 0) {
            j10 = taskResultSnapshot.savedAt;
        }
        List list2 = list;
        return taskResultSnapshot.copy(str, i10, list2, j10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    public final List<TaskInfoPart> component3() {
        return this.result;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSavedAt() {
        return this.savedAt;
    }

    public final TaskResultSnapshot copy(String taskId, int sequence, List<TaskInfoPart> result, long savedAt) {
        p.i(taskId, "taskId");
        p.i(result, "result");
        return new TaskResultSnapshot(taskId, sequence, result, savedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultSnapshot)) {
            return false;
        }
        TaskResultSnapshot taskResultSnapshot = (TaskResultSnapshot) other;
        return p.d(this.taskId, taskResultSnapshot.taskId) && this.sequence == taskResultSnapshot.sequence && p.d(this.result, taskResultSnapshot.result) && this.savedAt == taskResultSnapshot.savedAt;
    }

    public final List<TaskInfoPart> getResult() {
        return this.result;
    }

    public final long getSavedAt() {
        return this.savedAt;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return (((((this.taskId.hashCode() * 31) + Integer.hashCode(this.sequence)) * 31) + this.result.hashCode()) * 31) + Long.hashCode(this.savedAt);
    }

    public String toString() {
        return "TaskResultSnapshot(taskId=" + this.taskId + ", sequence=" + this.sequence + ", result=" + this.result + ", savedAt=" + this.savedAt + ")";
    }
}
