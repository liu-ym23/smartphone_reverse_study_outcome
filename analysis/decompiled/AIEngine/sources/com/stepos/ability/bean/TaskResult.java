package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ota.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskResult implements Parcelable {
    public static final Parcelable.Creator<TaskResult> CREATOR = new a();
    private final Integer code;
    private final String data;
    private final String message;
    private final boolean success;
    private final String taskId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<TaskResult> {
        @Override // android.os.Parcelable.Creator
        public final TaskResult createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new TaskResult(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final TaskResult[] newArray(int i10) {
            return new TaskResult[i10];
        }
    }

    public TaskResult(String taskId, boolean z, String str, String str2, Integer num) {
        g.f(taskId, "taskId");
        this.taskId = taskId;
        this.success = z;
        this.data = str;
        this.message = str2;
        this.code = num;
    }

    public static /* synthetic */ TaskResult copy$default(TaskResult taskResult, String str, boolean z, String str2, String str3, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskResult.taskId;
        }
        if ((i10 & 2) != 0) {
            z = taskResult.success;
        }
        if ((i10 & 4) != 0) {
            str2 = taskResult.data;
        }
        if ((i10 & 8) != 0) {
            str3 = taskResult.message;
        }
        if ((i10 & 16) != 0) {
            num = taskResult.code;
        }
        Integer num2 = num;
        String str4 = str2;
        return taskResult.copy(str, z, str4, str3, num2);
    }

    public final String component1() {
        return this.taskId;
    }

    public final boolean component2() {
        return this.success;
    }

    public final String component3() {
        return this.data;
    }

    public final String component4() {
        return this.message;
    }

    public final Integer component5() {
        return this.code;
    }

    public final TaskResult copy(String taskId, boolean z, String str, String str2, Integer num) {
        g.f(taskId, "taskId");
        return new TaskResult(taskId, z, str, str2, num);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskResult)) {
            return false;
        }
        TaskResult taskResult = (TaskResult) obj;
        return g.b(this.taskId, taskResult.taskId) && this.success == taskResult.success && g.b(this.data, taskResult.data) && g.b(this.message, taskResult.message) && g.b(this.code, taskResult.code);
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iF = ai.onnxruntime.a.f(this.taskId.hashCode() * 31, 31, this.success);
        String str = this.data;
        int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.code;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        boolean z = this.success;
        String str2 = this.data;
        String str3 = this.message;
        Integer num = this.code;
        StringBuilder sbM = d.m("TaskResult(taskId=", str, ", success=", ", data=", z);
        ai.onnxruntime.a.z(sbM, str2, ", message=", str3, ", code=");
        sbM.append(num);
        sbM.append(")");
        return sbM.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeInt(this.success ? 1 : 0);
        dest.writeString(this.data);
        dest.writeString(this.message);
        Integer num = this.code;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    public /* synthetic */ TaskResult(String str, boolean z, String str2, String str3, Integer num, int i10, e eVar) {
        this(str, z, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : num);
    }
}
