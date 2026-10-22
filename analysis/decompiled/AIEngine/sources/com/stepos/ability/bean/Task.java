package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Task implements Parcelable {
    public static final Parcelable.Creator<Task> CREATOR = new a();
    private AppUI appUI;
    private Bundle bundle;
    private final String conversationId;
    private String coverUri;
    private long createTime;
    private String description;
    private TaskError error;
    private String name;
    private String params;
    private String parentTaskId;
    private int priority;
    private String sourcePackageName;
    private long startTime;
    private int status;
    private final String taskId;
    private int taskType;
    private int triggerType;
    private long updateTime;
    private final int version;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<Task> {
        @Override // android.os.Parcelable.Creator
        public final Task createFromParcel(Parcel parcel) {
            AppUI appUI;
            TaskError taskErrorCreateFromParcel;
            g.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            String string7 = parcel.readString();
            long j10 = parcel.readLong();
            long j11 = parcel.readLong();
            long j12 = parcel.readLong();
            AppUI appUICreateFromParcel = parcel.readInt() == 0 ? null : AppUI.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                appUI = appUICreateFromParcel;
                taskErrorCreateFromParcel = null;
            } else {
                appUI = appUICreateFromParcel;
                taskErrorCreateFromParcel = TaskError.CREATOR.createFromParcel(parcel);
            }
            return new Task(string, string2, string3, string4, string5, string6, i10, i11, i12, i13, string7, j10, j11, j12, appUI, taskErrorCreateFromParcel, parcel.readString(), parcel.readBundle(Task.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Task[] newArray(int i10) {
            return new Task[i10];
        }
    }

    public Task(String taskId, String str, String str2, String str3, String str4, String sourcePackageName, int i10, int i11, int i12, int i13, String str5, long j10, long j11, long j12, AppUI appUI, TaskError taskError, String str6, Bundle bundle, int i14) {
        g.f(taskId, "taskId");
        g.f(sourcePackageName, "sourcePackageName");
        this.taskId = taskId;
        this.conversationId = str;
        this.name = str2;
        this.coverUri = str3;
        this.description = str4;
        this.sourcePackageName = sourcePackageName;
        this.triggerType = i10;
        this.taskType = i11;
        this.status = i12;
        this.priority = i13;
        this.parentTaskId = str5;
        this.createTime = j10;
        this.startTime = j11;
        this.updateTime = j12;
        this.appUI = appUI;
        this.error = taskError;
        this.params = str6;
        this.bundle = bundle;
        this.version = i14;
    }

    public static /* synthetic */ Task copy$default(Task task, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, int i13, String str7, long j10, long j11, long j12, AppUI appUI, TaskError taskError, String str8, Bundle bundle, int i14, int i15, Object obj) {
        int i16;
        Bundle bundle2;
        String str9 = (i15 & 1) != 0 ? task.taskId : str;
        String str10 = (i15 & 2) != 0 ? task.conversationId : str2;
        String str11 = (i15 & 4) != 0 ? task.name : str3;
        String str12 = (i15 & 8) != 0 ? task.coverUri : str4;
        String str13 = (i15 & 16) != 0 ? task.description : str5;
        String str14 = (i15 & 32) != 0 ? task.sourcePackageName : str6;
        int i17 = (i15 & 64) != 0 ? task.triggerType : i10;
        int i18 = (i15 & TraceIdKeys.MAX_LENGTH) != 0 ? task.taskType : i11;
        int i19 = (i15 & 256) != 0 ? task.status : i12;
        int i20 = (i15 & VadSessionManager.FRAME_BYTES) != 0 ? task.priority : i13;
        String str15 = (i15 & 1024) != 0 ? task.parentTaskId : str7;
        long j13 = (i15 & 2048) != 0 ? task.createTime : j10;
        String str16 = str9;
        String str17 = str10;
        long j14 = (i15 & 4096) != 0 ? task.startTime : j11;
        long j15 = (i15 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? task.updateTime : j12;
        AppUI appUI2 = (i15 & 16384) != 0 ? task.appUI : appUI;
        TaskError taskError2 = (i15 & 32768) != 0 ? task.error : taskError;
        String str18 = (i15 & 65536) != 0 ? task.params : str8;
        Bundle bundle3 = (i15 & 131072) != 0 ? task.bundle : bundle;
        if ((i15 & 262144) != 0) {
            bundle2 = bundle3;
            i16 = task.version;
        } else {
            i16 = i14;
            bundle2 = bundle3;
        }
        return task.copy(str16, str17, str11, str12, str13, str14, i17, i18, i19, i20, str15, j13, j14, j15, appUI2, taskError2, str18, bundle2, i16);
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component10() {
        return this.priority;
    }

    public final String component11() {
        return this.parentTaskId;
    }

    public final long component12() {
        return this.createTime;
    }

    public final long component13() {
        return this.startTime;
    }

    public final long component14() {
        return this.updateTime;
    }

    public final AppUI component15() {
        return this.appUI;
    }

    public final TaskError component16() {
        return this.error;
    }

    public final String component17() {
        return this.params;
    }

    public final Bundle component18() {
        return this.bundle;
    }

    public final int component19() {
        return this.version;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.coverUri;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.sourcePackageName;
    }

    public final int component7() {
        return this.triggerType;
    }

    public final int component8() {
        return this.taskType;
    }

    public final int component9() {
        return this.status;
    }

    public final Task copy(String taskId, String str, String str2, String str3, String str4, String sourcePackageName, int i10, int i11, int i12, int i13, String str5, long j10, long j11, long j12, AppUI appUI, TaskError taskError, String str6, Bundle bundle, int i14) {
        g.f(taskId, "taskId");
        g.f(sourcePackageName, "sourcePackageName");
        return new Task(taskId, str, str2, str3, str4, sourcePackageName, i10, i11, i12, i13, str5, j10, j11, j12, appUI, taskError, str6, bundle, i14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Task)) {
            return false;
        }
        Task task = (Task) obj;
        return g.b(this.taskId, task.taskId) && g.b(this.conversationId, task.conversationId) && g.b(this.name, task.name) && g.b(this.coverUri, task.coverUri) && g.b(this.description, task.description) && g.b(this.sourcePackageName, task.sourcePackageName) && this.triggerType == task.triggerType && this.taskType == task.taskType && this.status == task.status && this.priority == task.priority && g.b(this.parentTaskId, task.parentTaskId) && this.createTime == task.createTime && this.startTime == task.startTime && this.updateTime == task.updateTime && g.b(this.appUI, task.appUI) && g.b(this.error, task.error) && g.b(this.params, task.params) && g.b(this.bundle, task.bundle) && this.version == task.version;
    }

    public final AppUI getAppUI() {
        return this.appUI;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCoverUri() {
        return this.coverUri;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final TaskError getError() {
        return this.error;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final int getTriggerType() {
        return this.triggerType;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.conversationId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coverUri;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iD = ai.onnxruntime.a.d(this.priority, ai.onnxruntime.a.d(this.status, ai.onnxruntime.a.d(this.taskType, ai.onnxruntime.a.d(this.triggerType, d.a((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.sourcePackageName), 31), 31), 31), 31);
        String str5 = this.parentTaskId;
        int iC = a0.a.c(a0.a.c(a0.a.c((iD + (str5 == null ? 0 : str5.hashCode())) * 31, this.createTime, 31), this.startTime, 31), this.updateTime, 31);
        AppUI appUI = this.appUI;
        int iHashCode5 = (iC + (appUI == null ? 0 : appUI.hashCode())) * 31;
        TaskError taskError = this.error;
        int iHashCode6 = (iHashCode5 + (taskError == null ? 0 : taskError.hashCode())) * 31;
        String str6 = this.params;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Bundle bundle = this.bundle;
        return Integer.hashCode(this.version) + ((iHashCode7 + (bundle != null ? bundle.hashCode() : 0)) * 31);
    }

    public final void setAppUI(AppUI appUI) {
        this.appUI = appUI;
    }

    public final void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public final void setCoverUri(String str) {
        this.coverUri = str;
    }

    public final void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setError(TaskError taskError) {
        this.error = taskError;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setParams(String str) {
        this.params = str;
    }

    public final void setParentTaskId(String str) {
        this.parentTaskId = str;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setSourcePackageName(String str) {
        g.f(str, "<set-?>");
        this.sourcePackageName = str;
    }

    public final void setStartTime(long j10) {
        this.startTime = j10;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    public final void setTaskType(int i10) {
        this.taskType = i10;
    }

    public final void setTriggerType(int i10) {
        this.triggerType = i10;
    }

    public final void setUpdateTime(long j10) {
        this.updateTime = j10;
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.conversationId;
        String str3 = this.name;
        String str4 = this.coverUri;
        String str5 = this.description;
        String str6 = this.sourcePackageName;
        int i10 = this.triggerType;
        int i11 = this.taskType;
        int i12 = this.status;
        int i13 = this.priority;
        String str7 = this.parentTaskId;
        long j10 = this.createTime;
        long j11 = this.startTime;
        long j12 = this.updateTime;
        AppUI appUI = this.appUI;
        TaskError taskError = this.error;
        String str8 = this.params;
        Bundle bundle = this.bundle;
        int i14 = this.version;
        StringBuilder sbS = ai.onnxruntime.a.s("Task(taskId=", str, ", conversationId=", str2, ", name=");
        ai.onnxruntime.a.z(sbS, str3, ", coverUri=", str4, ", description=");
        ai.onnxruntime.a.z(sbS, str5, ", sourcePackageName=", str6, ", triggerType=");
        e.l(sbS, i10, ", taskType=", i11, ", status=");
        e.l(sbS, i12, ", priority=", i13, ", parentTaskId=");
        com.stepos.core.ota.d.p(j10, str7, ", createTime=", sbS);
        a0.a.s(j11, ", startTime=", ", updateTime=", sbS);
        sbS.append(j12);
        sbS.append(", appUI=");
        sbS.append(appUI);
        sbS.append(", error=");
        sbS.append(taskError);
        sbS.append(", params=");
        sbS.append(str8);
        sbS.append(", bundle=");
        sbS.append(bundle);
        sbS.append(", version=");
        sbS.append(i14);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.conversationId);
        dest.writeString(this.name);
        dest.writeString(this.coverUri);
        dest.writeString(this.description);
        dest.writeString(this.sourcePackageName);
        dest.writeInt(this.triggerType);
        dest.writeInt(this.taskType);
        dest.writeInt(this.status);
        dest.writeInt(this.priority);
        dest.writeString(this.parentTaskId);
        dest.writeLong(this.createTime);
        dest.writeLong(this.startTime);
        dest.writeLong(this.updateTime);
        AppUI appUI = this.appUI;
        if (appUI == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            appUI.writeToParcel(dest, i10);
        }
        TaskError taskError = this.error;
        if (taskError == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            taskError.writeToParcel(dest, i10);
        }
        dest.writeString(this.params);
        dest.writeBundle(this.bundle);
        dest.writeInt(this.version);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public Task(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, int r34, int r35, int r36, java.lang.String r37, long r38, long r40, long r42, com.stepos.ability.bean.AppUI r44, com.stepos.ability.bean.TaskError r45, java.lang.String r46, android.os.Bundle r47, int r48, int r49, kotlin.jvm.internal.e r50) {
        /*
            Method dump skipped, instructions count: 178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.bean.Task.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, java.lang.String, long, long, long, com.stepos.ability.bean.AppUI, com.stepos.ability.bean.TaskError, java.lang.String, android.os.Bundle, int, int, kotlin.jvm.internal.e):void");
    }
}
