package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001eJ\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u001eJ\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u001eJ\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\u001eJ\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001eJ\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001eJ\u0010\u0010-\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b-\u0010 J\u0010\u0010.\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b.\u0010 J\u0010\u0010/\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b/\u0010 J\u0010\u00100\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b0\u0010 J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\u001eJ\u0010\u00102\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b4\u00103J\u0010\u00105\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b5\u00103J\u0012\u00106\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b6\u00107J\u0012\u00108\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b8\u00109J\u0012\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b:\u0010\u001eJ\u0012\u0010;\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b=\u0010 Jà\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b@\u0010 J\u001a\u0010D\u001a\u00020C2\b\u0010B\u001a\u0004\u0018\u00010AHÖ\u0003¢\u0006\u0004\bD\u0010ER\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010F\u001a\u0004\bG\u0010\u001eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010F\u001a\u0004\bH\u0010\u001eR$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010F\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010KR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010F\u001a\u0004\bL\u0010\u001e\"\u0004\bM\u0010KR$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010F\u001a\u0004\bN\u0010\u001e\"\u0004\bO\u0010KR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010F\u001a\u0004\bP\u0010\u001e\"\u0004\bQ\u0010KR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010R\u001a\u0004\bS\u0010 \"\u0004\bT\u0010UR\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010R\u001a\u0004\bV\u0010 \"\u0004\bW\u0010UR\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010R\u001a\u0004\bX\u0010 \"\u0004\bY\u0010UR\"\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010R\u001a\u0004\bZ\u0010 \"\u0004\b[\u0010UR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010F\u001a\u0004\b\\\u0010\u001e\"\u0004\b]\u0010KR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010^\u001a\u0004\b_\u00103\"\u0004\b`\u0010aR\"\u0010\u0011\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010^\u001a\u0004\bb\u00103\"\u0004\bc\u0010aR\"\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010^\u001a\u0004\bd\u00103\"\u0004\be\u0010aR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010f\u001a\u0004\bg\u00107\"\u0004\bh\u0010iR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010j\u001a\u0004\bk\u00109\"\u0004\bl\u0010mR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010F\u001a\u0004\bn\u0010\u001e\"\u0004\bo\u0010KR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010p\u001a\u0004\bq\u0010<\"\u0004\br\u0010sR\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010R\u001a\u0004\bt\u0010 ¨\u0006u"}, d2 = {"Lcom/stepos/ability/bean/Task;", "Landroid/os/Parcelable;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "conversationId", HintConstants.AUTOFILL_HINT_NAME, "coverUri", "description", "sourcePackageName", "", "triggerType", "taskType", "status", "priority", "parentTaskId", "", "createTime", "startTime", "updateTime", "Lcom/stepos/ability/bean/AppUI;", "appUI", "Lcom/stepos/ability/bean/TaskError;", "error", "params", "Landroid/os/Bundle;", "bundle", "version", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;JJJLcom/stepos/ability/bean/AppUI;Lcom/stepos/ability/bean/TaskError;Ljava/lang/String;Landroid/os/Bundle;I)V", "toString", "()Ljava/lang/String;", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "()J", "component13", "component14", "component15", "()Lcom/stepos/ability/bean/AppUI;", "component16", "()Lcom/stepos/ability/bean/TaskError;", "component17", "component18", "()Landroid/os/Bundle;", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;JJJLcom/stepos/ability/bean/AppUI;Lcom/stepos/ability/bean/TaskError;Ljava/lang/String;Landroid/os/Bundle;I)Lcom/stepos/ability/bean/Task;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getConversationId", "getName", "setName", "(Ljava/lang/String;)V", "getCoverUri", "setCoverUri", "getDescription", "setDescription", "getSourcePackageName", "setSourcePackageName", "I", "getTriggerType", "setTriggerType", "(I)V", "getTaskType", "setTaskType", "getStatus", "setStatus", "getPriority", "setPriority", "getParentTaskId", "setParentTaskId", "J", "getCreateTime", "setCreateTime", "(J)V", "getStartTime", "setStartTime", "getUpdateTime", "setUpdateTime", "Lcom/stepos/ability/bean/AppUI;", "getAppUI", "setAppUI", "(Lcom/stepos/ability/bean/AppUI;)V", "Lcom/stepos/ability/bean/TaskError;", "getError", "setError", "(Lcom/stepos/ability/bean/TaskError;)V", "getParams", "setParams", "Landroid/os/Bundle;", "getBundle", "setBundle", "(Landroid/os/Bundle;)V", "getVersion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Task implements Parcelable {
    public static final Parcelable.Creator<Task> CREATOR = new Creator();
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Task> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Task createFromParcel(Parcel parcel) {
            AppUI appUI;
            TaskError taskErrorCreateFromParcel;
            k.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            int i = parcel.readInt();
            int i6 = parcel.readInt();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            String string7 = parcel.readString();
            long j5 = parcel.readLong();
            long j6 = parcel.readLong();
            long j10 = parcel.readLong();
            AppUI appUICreateFromParcel = parcel.readInt() == 0 ? null : AppUI.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                appUI = appUICreateFromParcel;
                taskErrorCreateFromParcel = null;
            } else {
                appUI = appUICreateFromParcel;
                taskErrorCreateFromParcel = TaskError.CREATOR.createFromParcel(parcel);
            }
            return new Task(string, string2, string3, string4, string5, string6, i, i6, i10, i11, string7, j5, j6, j10, appUI, taskErrorCreateFromParcel, parcel.readString(), parcel.readBundle(Task.class.getClassLoader()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Task[] newArray(int i) {
            return new Task[i];
        }
    }

    public Task(String taskId, String str, String str2, String str3, String str4, String sourcePackageName, int i, int i6, int i10, int i11, String str5, long j5, long j6, long j10, AppUI appUI, TaskError taskError, String str6, Bundle bundle, int i12) {
        k.f(taskId, "taskId");
        k.f(sourcePackageName, "sourcePackageName");
        this.taskId = taskId;
        this.conversationId = str;
        this.name = str2;
        this.coverUri = str3;
        this.description = str4;
        this.sourcePackageName = sourcePackageName;
        this.triggerType = i;
        this.taskType = i6;
        this.status = i10;
        this.priority = i11;
        this.parentTaskId = str5;
        this.createTime = j5;
        this.startTime = j6;
        this.updateTime = j10;
        this.appUI = appUI;
        this.error = taskError;
        this.params = str6;
        this.bundle = bundle;
        this.version = i12;
    }

    public static /* synthetic */ Task copy$default(Task task, String str, String str2, String str3, String str4, String str5, String str6, int i, int i6, int i10, int i11, String str7, long j5, long j6, long j10, AppUI appUI, TaskError taskError, String str8, Bundle bundle, int i12, int i13, Object obj) {
        int i14;
        Bundle bundle2;
        String str9 = (i13 & 1) != 0 ? task.taskId : str;
        String str10 = (i13 & 2) != 0 ? task.conversationId : str2;
        String str11 = (i13 & 4) != 0 ? task.name : str3;
        String str12 = (i13 & 8) != 0 ? task.coverUri : str4;
        String str13 = (i13 & 16) != 0 ? task.description : str5;
        String str14 = (i13 & 32) != 0 ? task.sourcePackageName : str6;
        int i15 = (i13 & 64) != 0 ? task.triggerType : i;
        int i16 = (i13 & 128) != 0 ? task.taskType : i6;
        int i17 = (i13 & 256) != 0 ? task.status : i10;
        int i18 = (i13 & 512) != 0 ? task.priority : i11;
        String str15 = (i13 & 1024) != 0 ? task.parentTaskId : str7;
        long j11 = (i13 & 2048) != 0 ? task.createTime : j5;
        String str16 = str9;
        String str17 = str10;
        long j12 = (i13 & 4096) != 0 ? task.startTime : j6;
        long j13 = (i13 & 8192) != 0 ? task.updateTime : j10;
        AppUI appUI2 = (i13 & 16384) != 0 ? task.appUI : appUI;
        TaskError taskError2 = (i13 & 32768) != 0 ? task.error : taskError;
        String str18 = (i13 & 65536) != 0 ? task.params : str8;
        Bundle bundle3 = (i13 & 131072) != 0 ? task.bundle : bundle;
        if ((i13 & 262144) != 0) {
            bundle2 = bundle3;
            i14 = task.version;
        } else {
            i14 = i12;
            bundle2 = bundle3;
        }
        return task.copy(str16, str17, str11, str12, str13, str14, i15, i16, i17, i18, str15, j11, j12, j13, appUI2, taskError2, str18, bundle2, i14);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component11, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    /* renamed from: component12, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component13, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component14, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: component15, reason: from getter */
    public final AppUI getAppUI() {
        return this.appUI;
    }

    /* renamed from: component16, reason: from getter */
    public final TaskError getError() {
        return this.error;
    }

    /* renamed from: component17, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component18, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    /* renamed from: component19, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCoverUri() {
        return this.coverUri;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTriggerType() {
        return this.triggerType;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: component9, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final Task copy(String taskId, String conversationId, String name, String coverUri, String description, String sourcePackageName, int triggerType, int taskType, int status, int priority, String parentTaskId, long createTime, long startTime, long updateTime, AppUI appUI, TaskError error, String params, Bundle bundle, int version) {
        k.f(taskId, "taskId");
        k.f(sourcePackageName, "sourcePackageName");
        return new Task(taskId, conversationId, name, coverUri, description, sourcePackageName, triggerType, taskType, status, priority, parentTaskId, createTime, startTime, updateTime, appUI, error, params, bundle, version);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Task)) {
            return false;
        }
        Task task = (Task) other;
        return k.b(this.taskId, task.taskId) && k.b(this.conversationId, task.conversationId) && k.b(this.name, task.name) && k.b(this.coverUri, task.coverUri) && k.b(this.description, task.description) && k.b(this.sourcePackageName, task.sourcePackageName) && this.triggerType == task.triggerType && this.taskType == task.taskType && this.status == task.status && this.priority == task.priority && k.b(this.parentTaskId, task.parentTaskId) && this.createTime == task.createTime && this.startTime == task.startTime && this.updateTime == task.updateTime && k.b(this.appUI, task.appUI) && k.b(this.error, task.error) && k.b(this.params, task.params) && k.b(this.bundle, task.bundle) && this.version == task.version;
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
        int iA = a.a(this.priority, a.a(this.status, a.a(this.taskType, a.a(this.triggerType, B7.a.c((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.sourcePackageName), 31), 31), 31), 31);
        String str5 = this.parentTaskId;
        int iC = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((iA + (str5 == null ? 0 : str5.hashCode())) * 31, 31, this.createTime), 31, this.startTime), 31, this.updateTime);
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

    public final void setCreateTime(long j5) {
        this.createTime = j5;
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

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final void setSourcePackageName(String str) {
        k.f(str, "<set-?>");
        this.sourcePackageName = str;
    }

    public final void setStartTime(long j5) {
        this.startTime = j5;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTaskType(int i) {
        this.taskType = i;
    }

    public final void setTriggerType(int i) {
        this.triggerType = i;
    }

    public final void setUpdateTime(long j5) {
        this.updateTime = j5;
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.conversationId;
        String str3 = this.sourcePackageName;
        int i = this.triggerType;
        int i6 = this.taskType;
        int i10 = this.status;
        int i11 = this.priority;
        String str4 = this.parentTaskId;
        long j5 = this.createTime;
        long j6 = this.startTime;
        long j10 = this.updateTime;
        AppUI appUI = this.appUI;
        boolean z10 = appUI != null;
        Integer numValueOf = appUI != null ? Integer.valueOf(appUI.getUiType()) : null;
        boolean z11 = z10;
        AppUI appUI2 = this.appUI;
        String packageName = appUI2 != null ? appUI2.getPackageName() : null;
        TaskError taskError = this.error;
        String str5 = this.params;
        boolean z12 = !(str5 == null || str5.length() == 0);
        boolean z13 = this.bundle != null;
        int i12 = this.version;
        StringBuilder sbW = B7.a.w("Task(taskId=", str, ", conversationId=", str2, ", sourcePackageName=");
        b.B(sbW, str3, ", triggerType=", i, ", taskType=");
        a.y(sbW, i6, ", status=", i10, ", priority=");
        sbW.append(i11);
        sbW.append(", parentTaskId=");
        sbW.append(str4);
        sbW.append(", createTime=");
        sbW.append(j5);
        b.y(j6, ", startTime=", ", updateTime=", sbW);
        sbW.append(j10);
        sbW.append(", hasAppUI=");
        sbW.append(z11);
        sbW.append(", appUiType=");
        sbW.append(numValueOf);
        sbW.append(", appUiPkg=");
        sbW.append(packageName);
        sbW.append(", error=");
        sbW.append(taskError);
        sbW.append(", params=<redacted>, hasParams=");
        sbW.append(z12);
        sbW.append(", hasBundle=");
        sbW.append(z13);
        sbW.append(", version=");
        sbW.append(i12);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
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
            appUI.writeToParcel(dest, flags);
        }
        TaskError taskError = this.error;
        if (taskError == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            taskError.writeToParcel(dest, flags);
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
