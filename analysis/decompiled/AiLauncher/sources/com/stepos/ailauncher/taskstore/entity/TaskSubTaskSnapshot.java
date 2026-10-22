package com.stepos.ailauncher.taskstore.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskSubTaskSnapshot;", "", "taskId", "", "sequence", "", "taskVersion", "subTasks", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "savedAt", "", "<init>", "(Ljava/lang/String;IILjava/util/List;J)V", "getTaskId", "()Ljava/lang/String;", "getSequence", "()I", "getTaskVersion", "getSubTasks", "()Ljava/util/List;", "getSavedAt", "()J", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskSubTaskSnapshot {
    private final long savedAt;
    private final int sequence;
    private final List<TaskInfoCard> subTasks;
    private final String taskId;
    private final int taskVersion;

    public TaskSubTaskSnapshot(String taskId, int i10, int i11, List<TaskInfoCard> subTasks, long j10) {
        p.i(taskId, "taskId");
        p.i(subTasks, "subTasks");
        this.taskId = taskId;
        this.sequence = i10;
        this.taskVersion = i11;
        this.subTasks = subTasks;
        this.savedAt = j10;
    }

    public static /* synthetic */ TaskSubTaskSnapshot copy$default(TaskSubTaskSnapshot taskSubTaskSnapshot, String str, int i10, int i11, List list, long j10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = taskSubTaskSnapshot.taskId;
        }
        if ((i12 & 2) != 0) {
            i10 = taskSubTaskSnapshot.sequence;
        }
        if ((i12 & 4) != 0) {
            i11 = taskSubTaskSnapshot.taskVersion;
        }
        if ((i12 & 8) != 0) {
            list = taskSubTaskSnapshot.subTasks;
        }
        if ((i12 & 16) != 0) {
            j10 = taskSubTaskSnapshot.savedAt;
        }
        long j11 = j10;
        return taskSubTaskSnapshot.copy(str, i10, i11, list, j11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    public final List<TaskInfoCard> component4() {
        return this.subTasks;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSavedAt() {
        return this.savedAt;
    }

    public final TaskSubTaskSnapshot copy(String taskId, int sequence, int taskVersion, List<TaskInfoCard> subTasks, long savedAt) {
        p.i(taskId, "taskId");
        p.i(subTasks, "subTasks");
        return new TaskSubTaskSnapshot(taskId, sequence, taskVersion, subTasks, savedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskSubTaskSnapshot)) {
            return false;
        }
        TaskSubTaskSnapshot taskSubTaskSnapshot = (TaskSubTaskSnapshot) other;
        return p.d(this.taskId, taskSubTaskSnapshot.taskId) && this.sequence == taskSubTaskSnapshot.sequence && this.taskVersion == taskSubTaskSnapshot.taskVersion && p.d(this.subTasks, taskSubTaskSnapshot.subTasks) && this.savedAt == taskSubTaskSnapshot.savedAt;
    }

    public final long getSavedAt() {
        return this.savedAt;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final List<TaskInfoCard> getSubTasks() {
        return this.subTasks;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskVersion() {
        return this.taskVersion;
    }

    public int hashCode() {
        return (((((((this.taskId.hashCode() * 31) + Integer.hashCode(this.sequence)) * 31) + Integer.hashCode(this.taskVersion)) * 31) + this.subTasks.hashCode()) * 31) + Long.hashCode(this.savedAt);
    }

    public String toString() {
        return "TaskSubTaskSnapshot(taskId=" + this.taskId + ", sequence=" + this.sequence + ", taskVersion=" + this.taskVersion + ", subTasks=" + this.subTasks + ", savedAt=" + this.savedAt + ")";
    }
}
