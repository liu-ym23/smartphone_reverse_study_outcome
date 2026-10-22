package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskId.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskId implements Parcelable {
    public static final Parcelable.Creator<TaskId> CREATOR = null;
    public static final a Companion = null;
    private final String value;

    /* JADX INFO: compiled from: TaskId.kt */
    public static final class Creator implements Parcelable.Creator<TaskId> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskId createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new TaskId(r1.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskId createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskId[] newArray(int r1) {
            return new TaskId[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskId[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: TaskId.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final TaskId a(String r3, TaskType r4) {
            o.e(r3, "command");
            o.e(r4, "type");
            return new TaskId("task_" + r3 + '_' + r4);
        }

        public final TaskId a(String r1) {
            o.e(r1, "value");
            return new TaskId(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ TaskId copy$default(TaskId r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.value;
    }

    public final TaskId copy(String r1) {
        o.e(r1, "value");
        return new TaskId(r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskId.class) == true) goto L8;
        return false;
    L8:
        TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(r5, TaskId.class, "com.obric.aiagent.plugin");
        if (o.a(this.value, r6.value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "TaskId(value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.value);
    }

    public TaskId(String r2) {
        o.e(r2, "value");
        this.value = r2;
    }

    public final String getValue() {
        return this.value;
    }
}
