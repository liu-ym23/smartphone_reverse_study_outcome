package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.h;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJF\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b'\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u001a¨\u0006*"}, d2 = {"Lcom/stepos/ability/bean/TaskSnapshot;", "Landroid/os/Parcelable;", "", "taskId", "packageName", "appName", VoiceWakeupReceiver.EXTRA_STATE, "", h.APP_FOREGROUND, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Z", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/ability/bean/TaskSnapshot;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getPackageName", "getAppName", "getState", "Z", "getForeground", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TaskSnapshot implements Parcelable {
    public static final Parcelable.Creator<TaskSnapshot> CREATOR = new a();
    private final String appName;
    private final boolean foreground;
    private final String packageName;
    private final String state;
    private final String taskId;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskSnapshot> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TaskSnapshot createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new TaskSnapshot(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TaskSnapshot[] newArray(int i10) {
            return new TaskSnapshot[i10];
        }
    }

    public TaskSnapshot(String taskId, String str, String str2, String state, boolean z10) {
        p.i(taskId, "taskId");
        p.i(state, "state");
        this.taskId = taskId;
        this.packageName = str;
        this.appName = str2;
        this.state = state;
        this.foreground = z10;
    }

    public static /* synthetic */ TaskSnapshot copy$default(TaskSnapshot taskSnapshot, String str, String str2, String str3, String str4, boolean z10, int i10, Object obj) {
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
            z10 = taskSnapshot.foreground;
        }
        boolean z11 = z10;
        String str5 = str3;
        return taskSnapshot.copy(str, str2, str5, str4, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getForeground() {
        return this.foreground;
    }

    public final TaskSnapshot copy(String taskId, String packageName, String appName, String state, boolean foreground) {
        p.i(taskId, "taskId");
        p.i(state, "state");
        return new TaskSnapshot(taskId, packageName, appName, state, foreground);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskSnapshot)) {
            return false;
        }
        TaskSnapshot taskSnapshot = (TaskSnapshot) other;
        return p.d(this.taskId, taskSnapshot.taskId) && p.d(this.packageName, taskSnapshot.packageName) && p.d(this.appName, taskSnapshot.appName) && p.d(this.state, taskSnapshot.state) && this.foreground == taskSnapshot.foreground;
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
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.state.hashCode()) * 31) + Boolean.hashCode(this.foreground);
    }

    public String toString() {
        return "TaskSnapshot(taskId=" + this.taskId + ", packageName=" + this.packageName + ", appName=" + this.appName + ", state=" + this.state + ", foreground=" + this.foreground + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.packageName);
        dest.writeString(this.appName);
        dest.writeString(this.state);
        dest.writeInt(this.foreground ? 1 : 0);
    }
}
