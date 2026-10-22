package com.stepos.ailauncher.taskstore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000bJB\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000bJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b%\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b&\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b'\u0010\u000b¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "Landroid/os/Parcelable;", "", "completed", "total", "failed", "inProgress", AuthSessionDto.STATUS_PENDING, "<init>", "(IIIII)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "(IIIII)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCompleted", "getTotal", "getFailed", "getInProgress", "getPending", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoProgress implements Parcelable {
    public static final Parcelable.Creator<TaskInfoProgress> CREATOR = new Creator();
    private final int completed;
    private final int failed;
    private final int inProgress;
    private final int pending;
    private final int total;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfoProgress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoProgress createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new TaskInfoProgress(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoProgress[] newArray(int i10) {
            return new TaskInfoProgress[i10];
        }
    }

    public TaskInfoProgress() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ TaskInfoProgress copy$default(TaskInfoProgress taskInfoProgress, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = taskInfoProgress.completed;
        }
        if ((i15 & 2) != 0) {
            i11 = taskInfoProgress.total;
        }
        if ((i15 & 4) != 0) {
            i12 = taskInfoProgress.failed;
        }
        if ((i15 & 8) != 0) {
            i13 = taskInfoProgress.inProgress;
        }
        if ((i15 & 16) != 0) {
            i14 = taskInfoProgress.pending;
        }
        int i16 = i14;
        int i17 = i12;
        return taskInfoProgress.copy(i10, i11, i17, i13, i16);
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

    public final TaskInfoProgress copy(int completed, int total, int failed, int inProgress, int pending) {
        return new TaskInfoProgress(completed, total, failed, inProgress, pending);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoProgress)) {
            return false;
        }
        TaskInfoProgress taskInfoProgress = (TaskInfoProgress) other;
        return this.completed == taskInfoProgress.completed && this.total == taskInfoProgress.total && this.failed == taskInfoProgress.failed && this.inProgress == taskInfoProgress.inProgress && this.pending == taskInfoProgress.pending;
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
        return (((((((Integer.hashCode(this.completed) * 31) + Integer.hashCode(this.total)) * 31) + Integer.hashCode(this.failed)) * 31) + Integer.hashCode(this.inProgress)) * 31) + Integer.hashCode(this.pending);
    }

    public String toString() {
        return "TaskInfoProgress(completed=" + this.completed + ", total=" + this.total + ", failed=" + this.failed + ", inProgress=" + this.inProgress + ", pending=" + this.pending + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.completed);
        dest.writeInt(this.total);
        dest.writeInt(this.failed);
        dest.writeInt(this.inProgress);
        dest.writeInt(this.pending);
    }

    public TaskInfoProgress(int i10, int i11, int i12, int i13, int i14) {
        this.completed = i10;
        this.total = i11;
        this.failed = i12;
        this.inProgress = i13;
        this.pending = i14;
    }

    public /* synthetic */ TaskInfoProgress(int i10, int i11, int i12, int i13, int i14, int i15, i iVar) {
        this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
    }
}
