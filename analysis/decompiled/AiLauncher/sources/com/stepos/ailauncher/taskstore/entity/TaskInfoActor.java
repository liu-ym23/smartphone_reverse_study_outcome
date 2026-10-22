package com.stepos.ailauncher.taskstore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J2\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b$\u0010\u0015¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", "Landroid/os/Parcelable;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", "source", "", "id", "displayName", "<init>", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;Ljava/lang/String;Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", "component2", "()Ljava/lang/String;", "component3", ChatTracker.CLICK_COPY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", "getSource", "Ljava/lang/String;", "getId", "getDisplayName", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoActor implements Parcelable {
    public static final Parcelable.Creator<TaskInfoActor> CREATOR = new Creator();
    private final String displayName;
    private final String id;
    private final TaskInfoActorSource source;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfoActor> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoActor createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new TaskInfoActor(TaskInfoActorSource.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoActor[] newArray(int i10) {
            return new TaskInfoActor[i10];
        }
    }

    public TaskInfoActor(TaskInfoActorSource source, String str, String str2) {
        p.i(source, "source");
        this.source = source;
        this.id = str;
        this.displayName = str2;
    }

    public static /* synthetic */ TaskInfoActor copy$default(TaskInfoActor taskInfoActor, TaskInfoActorSource taskInfoActorSource, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            taskInfoActorSource = taskInfoActor.source;
        }
        if ((i10 & 2) != 0) {
            str = taskInfoActor.id;
        }
        if ((i10 & 4) != 0) {
            str2 = taskInfoActor.displayName;
        }
        return taskInfoActor.copy(taskInfoActorSource, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final TaskInfoActorSource getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final TaskInfoActor copy(TaskInfoActorSource source, String id, String displayName) {
        p.i(source, "source");
        return new TaskInfoActor(source, id, displayName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoActor)) {
            return false;
        }
        TaskInfoActor taskInfoActor = (TaskInfoActor) other;
        return this.source == taskInfoActor.source && p.d(this.id, taskInfoActor.id) && p.d(this.displayName, taskInfoActor.displayName);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }

    public final TaskInfoActorSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.id;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TaskInfoActor(source=" + this.source + ", id=" + this.id + ", displayName=" + this.displayName + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.source.name());
        dest.writeString(this.id);
        dest.writeString(this.displayName);
    }

    public /* synthetic */ TaskInfoActor(TaskInfoActorSource taskInfoActorSource, String str, String str2, int i10, i iVar) {
        this(taskInfoActorSource, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
