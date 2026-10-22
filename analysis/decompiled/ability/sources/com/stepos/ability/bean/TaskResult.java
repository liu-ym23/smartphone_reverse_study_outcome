package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJH\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000fJ\u001a\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b)\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010\u001c¨\u0006,"}, d2 = {"Lcom/stepos/ability/bean/TaskResult;", "Landroid/os/Parcelable;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", "success", SettingsConfig.KEY_DATA, "message", "", "code", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "()Z", "component3", "component4", "component5", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/ability/bean/TaskResult;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "Z", "getSuccess", "getData", "getMessage", "Ljava/lang/Integer;", "getCode", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskResult implements Parcelable {
    public static final Parcelable.Creator<TaskResult> CREATOR = new Creator();
    private final Integer code;
    private final String data;
    private final String message;
    private final boolean success;
    private final String taskId;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskResult createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new TaskResult(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskResult[] newArray(int i) {
            return new TaskResult[i];
        }
    }

    public TaskResult(String taskId, boolean z10, String str, String str2, Integer num) {
        k.f(taskId, "taskId");
        this.taskId = taskId;
        this.success = z10;
        this.data = str;
        this.message = str2;
        this.code = num;
    }

    public static /* synthetic */ TaskResult copy$default(TaskResult taskResult, String str, boolean z10, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskResult.taskId;
        }
        if ((i & 2) != 0) {
            z10 = taskResult.success;
        }
        if ((i & 4) != 0) {
            str2 = taskResult.data;
        }
        if ((i & 8) != 0) {
            str3 = taskResult.message;
        }
        if ((i & 16) != 0) {
            num = taskResult.code;
        }
        Integer num2 = num;
        String str4 = str2;
        return taskResult.copy(str, z10, str4, str3, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    public final TaskResult copy(String taskId, boolean success, String data, String message, Integer code) {
        k.f(taskId, "taskId");
        return new TaskResult(taskId, success, data, message, code);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResult)) {
            return false;
        }
        TaskResult taskResult = (TaskResult) other;
        return k.b(this.taskId, taskResult.taskId) && this.success == taskResult.success && k.b(this.data, taskResult.data) && k.b(this.message, taskResult.message) && k.b(this.code, taskResult.code);
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
        int iD = a.d(this.taskId.hashCode() * 31, 31, this.success);
        String str = this.data;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.code;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        boolean z10 = this.success;
        String str2 = this.data;
        boolean z11 = str2 == null || str2.length() == 0;
        String str3 = this.message;
        Integer num = this.code;
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("TaskResult(taskId=", str, ", success=", ", data=<redacted>, hasData=", z10);
        sbL.append(!z11);
        sbL.append(", message=");
        sbL.append(str3);
        sbL.append(", code=");
        sbL.append(num);
        sbL.append(")");
        return sbL.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
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

    public /* synthetic */ TaskResult(String str, boolean z10, String str2, String str3, Integer num, int i, e eVar) {
        this(str, z10, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num);
    }
}
