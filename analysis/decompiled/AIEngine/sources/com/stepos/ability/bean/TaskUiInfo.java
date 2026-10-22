package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskUiInfo implements Parcelable {
    public static final Parcelable.Creator<TaskUiInfo> CREATOR = new a();
    private final String coverUri;
    private final String description;
    private String name;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<TaskUiInfo> {
        @Override // android.os.Parcelable.Creator
        public final TaskUiInfo createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new TaskUiInfo(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final TaskUiInfo[] newArray(int i10) {
            return new TaskUiInfo[i10];
        }
    }

    public TaskUiInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TaskUiInfo copy$default(TaskUiInfo taskUiInfo, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskUiInfo.name;
        }
        if ((i10 & 2) != 0) {
            str2 = taskUiInfo.coverUri;
        }
        if ((i10 & 4) != 0) {
            str3 = taskUiInfo.description;
        }
        return taskUiInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.coverUri;
    }

    public final String component3() {
        return this.description;
    }

    public final TaskUiInfo copy(String str, String str2, String str3) {
        return new TaskUiInfo(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskUiInfo)) {
            return false;
        }
        TaskUiInfo taskUiInfo = (TaskUiInfo) obj;
        return g.b(this.name, taskUiInfo.name) && g.b(this.coverUri, taskUiInfo.coverUri) && g.b(this.description, taskUiInfo.description);
    }

    public final String getCoverUri() {
        return this.coverUri;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coverUri;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.coverUri;
        return ai.onnxruntime.a.o(ai.onnxruntime.a.s("TaskUiInfo(name=", str, ", coverUri=", str2, ", description="), this.description, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.coverUri);
        dest.writeString(this.description);
    }

    public TaskUiInfo(String str, String str2, String str3) {
        this.name = str;
        this.coverUri = str2;
        this.description = str3;
    }

    public /* synthetic */ TaskUiInfo(String str, String str2, String str3, int i10, e eVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
