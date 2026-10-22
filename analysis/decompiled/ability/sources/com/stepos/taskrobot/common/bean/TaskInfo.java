package com.stepos.taskrobot.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stepos/taskrobot/common/bean/TaskInfo;", "Landroid/os/Parcelable;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", "currentStatus", "originStatus", "Landroid/view/Surface;", "surface", "platform", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;IILandroid/view/Surface;I)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "getTaskName", "I", "getCurrentStatus", "getOriginStatus", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "getPlatform", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfo implements Parcelable {
    public static final Parcelable.Creator<TaskInfo> CREATOR = new Creator();
    private final int currentStatus;
    private final int originStatus;
    private final int platform;
    private final Surface surface;
    private final String taskId;
    private final String taskName;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfo createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new TaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), (Surface) parcel.readParcelable(TaskInfo.class.getClassLoader()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfo[] newArray(int i) {
            return new TaskInfo[i];
        }
    }

    public TaskInfo(String taskId, String taskName, int i, int i6, Surface surface, int i10) {
        k.f(taskId, "taskId");
        k.f(taskName, "taskName");
        k.f(surface, "surface");
        this.taskId = taskId;
        this.taskName = taskName;
        this.currentStatus = i;
        this.originStatus = i6;
        this.surface = surface;
        this.platform = i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getCurrentStatus() {
        return this.currentStatus;
    }

    public final int getOriginStatus() {
        return this.originStatus;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final Surface getSurface() {
        return this.surface;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.taskName);
        dest.writeInt(this.currentStatus);
        dest.writeInt(this.originStatus);
        dest.writeParcelable(this.surface, flags);
        dest.writeInt(this.platform);
    }
}
