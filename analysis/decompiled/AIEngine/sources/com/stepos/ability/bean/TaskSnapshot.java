package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskSnapshot implements Parcelable {
    public static final Parcelable.Creator<TaskSnapshot> CREATOR = new a();
    private final String appName;
    private final boolean foreground;
    private final String packageName;
    private final String state;
    private final String taskId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<TaskSnapshot> {
        @Override // android.os.Parcelable.Creator
        public final TaskSnapshot createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new TaskSnapshot(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final TaskSnapshot[] newArray(int i10) {
            return new TaskSnapshot[i10];
        }
    }

    public TaskSnapshot(String taskId, String str, String str2, String state, boolean z) {
        g.f(taskId, "taskId");
        g.f(state, "state");
        this.taskId = taskId;
        this.packageName = str;
        this.appName = str2;
        this.state = state;
        this.foreground = z;
    }

    public static /* synthetic */ TaskSnapshot copy$default(TaskSnapshot taskSnapshot, String str, String str2, String str3, String str4, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskSnapshot.taskId;
        }
        if ((i10 & 2) != 0) {
            str2 = taskSnapshot.packageName;
        }
        if ((i10 & 4) != 0) {
            str3 = taskSnapshot.appName;
        }
        if ((i10 & 8) != 0) {
            str4 = taskSnapshot.state;
        }
        if ((i10 & 16) != 0) {
            z = taskSnapshot.foreground;
        }
        boolean z3 = z;
        String str5 = str3;
        return taskSnapshot.copy(str, str2, str5, str4, z3);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.appName;
    }

    public final String component4() {
        return this.state;
    }

    public final boolean component5() {
        return this.foreground;
    }

    public final TaskSnapshot copy(String taskId, String str, String str2, String state, boolean z) {
        g.f(taskId, "taskId");
        g.f(state, "state");
        return new TaskSnapshot(taskId, str, str2, state, z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskSnapshot)) {
            return false;
        }
        TaskSnapshot taskSnapshot = (TaskSnapshot) obj;
        return g.b(this.taskId, taskSnapshot.taskId) && g.b(this.packageName, taskSnapshot.packageName) && g.b(this.appName, taskSnapshot.appName) && g.b(this.state, taskSnapshot.state) && this.foreground == taskSnapshot.foreground;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getForeground() {
        return this.foreground;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getState() {
        return this.state;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.packageName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appName;
        return Boolean.hashCode(this.foreground) + d.a((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.state);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.packageName;
        String str3 = this.appName;
        String str4 = this.state;
        boolean z = this.foreground;
        StringBuilder sbS = ai.onnxruntime.a.s("TaskSnapshot(taskId=", str, ", packageName=", str2, ", appName=");
        ai.onnxruntime.a.z(sbS, str3, ", state=", str4, ", foreground=");
        return a0.a.m(sbS, z, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.packageName);
        dest.writeString(this.appName);
        dest.writeString(this.state);
        dest.writeInt(this.foreground ? 1 : 0);
    }
}
