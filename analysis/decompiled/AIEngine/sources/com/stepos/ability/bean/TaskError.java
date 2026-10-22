package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskError implements Parcelable {
    public static final Parcelable.Creator<TaskError> CREATOR = new a();
    private final int code;
    private final String codeString;
    private final String errorMessage;
    private final boolean retryAble;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<TaskError> {
        @Override // android.os.Parcelable.Creator
        public final TaskError createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new TaskError(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final TaskError[] newArray(int i10) {
            return new TaskError[i10];
        }
    }

    public TaskError(int i10, String codeString, String errorMessage, boolean z) {
        g.f(codeString, "codeString");
        g.f(errorMessage, "errorMessage");
        this.code = i10;
        this.codeString = codeString;
        this.errorMessage = errorMessage;
        this.retryAble = z;
    }

    public static /* synthetic */ TaskError copy$default(TaskError taskError, int i10, String str, String str2, boolean z, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = taskError.code;
        }
        if ((i11 & 2) != 0) {
            str = taskError.codeString;
        }
        if ((i11 & 4) != 0) {
            str2 = taskError.errorMessage;
        }
        if ((i11 & 8) != 0) {
            z = taskError.retryAble;
        }
        return taskError.copy(i10, str, str2, z);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.codeString;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final boolean component4() {
        return this.retryAble;
    }

    public final TaskError copy(int i10, String codeString, String errorMessage, boolean z) {
        g.f(codeString, "codeString");
        g.f(errorMessage, "errorMessage");
        return new TaskError(i10, codeString, errorMessage, z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskError)) {
            return false;
        }
        TaskError taskError = (TaskError) obj;
        return this.code == taskError.code && g.b(this.codeString, taskError.codeString) && g.b(this.errorMessage, taskError.errorMessage) && this.retryAble == taskError.retryAble;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getCodeString() {
        return this.codeString;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getRetryAble() {
        return this.retryAble;
    }

    public int hashCode() {
        return Boolean.hashCode(this.retryAble) + d.a(d.a(Integer.hashCode(this.code) * 31, 31, this.codeString), 31, this.errorMessage);
    }

    public String toString() {
        int i10 = this.code;
        String str = this.codeString;
        String str2 = this.errorMessage;
        boolean z = this.retryAble;
        StringBuilder sbE = e.e("TaskError(code=", i10, ", codeString=", str, ", errorMessage=");
        sbE.append(str2);
        sbE.append(", retryAble=");
        sbE.append(z);
        sbE.append(")");
        return sbE.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.code);
        dest.writeString(this.codeString);
        dest.writeString(this.errorMessage);
        dest.writeInt(this.retryAble ? 1 : 0);
    }

    public /* synthetic */ TaskError(int i10, String str, String str2, boolean z, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? 0 : i10, str, str2, (i11 & 8) != 0 ? true : z);
    }
}
