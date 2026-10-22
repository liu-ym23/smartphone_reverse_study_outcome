package com.zyql.intenttaskmanager.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\t¢\u0006\u0004\b \u0010!J\u001d\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010)J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010)J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010)J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010)J\u0010\u0010/\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b/\u0010!J\u0010\u00100\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b0\u0010!J\u0010\u00101\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b1\u0010!J\u0010\u00102\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b2\u0010!J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010)J\u0018\u00104\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b8\u00107J\u0010\u00109\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b9\u00107J\u0012\u0010:\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b:\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b<\u0010=J\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u0010)J\u0012\u0010?\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\tHÆ\u0003¢\u0006\u0004\bA\u0010!Jò\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\tHÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bD\u0010)J\u0010\u0010E\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bE\u0010!J\u001a\u0010I\u001a\u00020H2\b\u0010G\u001a\u0004\u0018\u00010FHÖ\u0003¢\u0006\u0004\bI\u0010JR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010K\u001a\u0004\bL\u0010)R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010K\u001a\u0004\bM\u0010)R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010K\u001a\u0004\bN\u0010)\"\u0004\bO\u0010PR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010K\u001a\u0004\bQ\u0010)\"\u0004\bR\u0010PR$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010K\u001a\u0004\bS\u0010)\"\u0004\bT\u0010PR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010K\u001a\u0004\bU\u0010)\"\u0004\bV\u0010PR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010W\u001a\u0004\bX\u0010!\"\u0004\bY\u0010ZR\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010W\u001a\u0004\b[\u0010!\"\u0004\b\\\u0010ZR\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010W\u001a\u0004\b]\u0010!\"\u0004\b^\u0010ZR\"\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010W\u001a\u0004\b_\u0010!\"\u0004\b`\u0010ZR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010K\u001a\u0004\ba\u0010)\"\u0004\bb\u0010PR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010c\u001a\u0004\bd\u00105\"\u0004\be\u0010fR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010g\u001a\u0004\bh\u00107\"\u0004\bi\u0010jR\"\u0010\u0014\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010g\u001a\u0004\bk\u00107\"\u0004\bl\u0010jR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010g\u001a\u0004\bm\u00107\"\u0004\bn\u0010jR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010o\u001a\u0004\bp\u0010;\"\u0004\bq\u0010rR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010s\u001a\u0004\bt\u0010=\"\u0004\bu\u0010vR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010K\u001a\u0004\bw\u0010)\"\u0004\bx\u0010PR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010y\u001a\u0004\bz\u0010@\"\u0004\b{\u0010|R\u0017\u0010\u001d\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010W\u001a\u0004\b}\u0010!¨\u0006~"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/Task;", "Landroid/os/Parcelable;", "", "taskId", "conversationId", "name", "coverUri", "description", "sourcePackageName", "", "taskType", "triggerType", "status", "priority", "parentTaskId", "", "Lcom/zyql/intenttaskmanager/bean/TaskAction;", "actions", "", "createTime", "startTime", "updateTime", "Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "appUI", "Lcom/zyql/intenttaskmanager/bean/TaskError;", "error", "params", "Landroid/os/Bundle;", "bundle", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/util/List;JJJLcom/zyql/intenttaskmanager/bean/TaskUIData;Lcom/zyql/intenttaskmanager/bean/TaskError;Ljava/lang/String;Landroid/os/Bundle;I)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "()Ljava/util/List;", "component13", "()J", "component14", "component15", "component16", "()Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "component17", "()Lcom/zyql/intenttaskmanager/bean/TaskError;", "component18", "component19", "()Landroid/os/Bundle;", "component20", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/util/List;JJJLcom/zyql/intenttaskmanager/bean/TaskUIData;Lcom/zyql/intenttaskmanager/bean/TaskError;Ljava/lang/String;Landroid/os/Bundle;I)Lcom/zyql/intenttaskmanager/bean/Task;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getConversationId", "getName", "setName", "(Ljava/lang/String;)V", "getCoverUri", "setCoverUri", "getDescription", "setDescription", "getSourcePackageName", "setSourcePackageName", "I", "getTaskType", "setTaskType", "(I)V", "getTriggerType", "setTriggerType", "getStatus", "setStatus", "getPriority", "setPriority", "getParentTaskId", "setParentTaskId", "Ljava/util/List;", "getActions", "setActions", "(Ljava/util/List;)V", "J", "getCreateTime", "setCreateTime", "(J)V", "getStartTime", "setStartTime", "getUpdateTime", "setUpdateTime", "Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "getAppUI", "setAppUI", "(Lcom/zyql/intenttaskmanager/bean/TaskUIData;)V", "Lcom/zyql/intenttaskmanager/bean/TaskError;", "getError", "setError", "(Lcom/zyql/intenttaskmanager/bean/TaskError;)V", "getParams", "setParams", "Landroid/os/Bundle;", "getBundle", "setBundle", "(Landroid/os/Bundle;)V", "getVersion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Task implements Parcelable {
    public static final Parcelable.Creator<Task> CREATOR = new a();
    private List<TaskAction> actions;
    private TaskUIData appUI;
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
    public static final class a implements Parcelable.Creator<Task> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Task createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            p.i(parcel, "parcel");
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
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i14 = parcel.readInt();
                arrayList = new ArrayList(i14);
                for (int i15 = 0; i15 != i14; i15++) {
                    arrayList.add(TaskAction.CREATOR.createFromParcel(parcel));
                }
            }
            return new Task(string, string2, string3, string4, string5, string6, i10, i11, i12, i13, string7, arrayList, parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? null : TaskUIData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TaskError.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readBundle(Task.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Task[] newArray(int i10) {
            return new Task[i10];
        }
    }

    public Task(String taskId, String str, String str2, String str3, String str4, String sourcePackageName, int i10, int i11, int i12, int i13, String str5, List<TaskAction> list, long j10, long j11, long j12, TaskUIData taskUIData, TaskError taskError, String str6, Bundle bundle, int i14) {
        p.i(taskId, "taskId");
        p.i(sourcePackageName, "sourcePackageName");
        this.taskId = taskId;
        this.conversationId = str;
        this.name = str2;
        this.coverUri = str3;
        this.description = str4;
        this.sourcePackageName = sourcePackageName;
        this.taskType = i10;
        this.triggerType = i11;
        this.status = i12;
        this.priority = i13;
        this.parentTaskId = str5;
        this.actions = list;
        this.createTime = j10;
        this.startTime = j11;
        this.updateTime = j12;
        this.appUI = taskUIData;
        this.error = taskError;
        this.params = str6;
        this.bundle = bundle;
        this.version = i14;
    }

    public static /* synthetic */ Task copy$default(Task task, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, int i13, String str7, List list, long j10, long j11, long j12, TaskUIData taskUIData, TaskError taskError, String str8, Bundle bundle, int i14, int i15, Object obj) {
        int i16;
        Bundle bundle2;
        String str9 = (i15 & 1) != 0 ? task.taskId : str;
        String str10 = (i15 & 2) != 0 ? task.conversationId : str2;
        String str11 = (i15 & 4) != 0 ? task.name : str3;
        String str12 = (i15 & 8) != 0 ? task.coverUri : str4;
        String str13 = (i15 & 16) != 0 ? task.description : str5;
        String str14 = (i15 & 32) != 0 ? task.sourcePackageName : str6;
        int i17 = (i15 & 64) != 0 ? task.taskType : i10;
        int i18 = (i15 & 128) != 0 ? task.triggerType : i11;
        int i19 = (i15 & 256) != 0 ? task.status : i12;
        int i20 = (i15 & 512) != 0 ? task.priority : i13;
        String str15 = (i15 & 1024) != 0 ? task.parentTaskId : str7;
        List list2 = (i15 & 2048) != 0 ? task.actions : list;
        long j13 = (i15 & 4096) != 0 ? task.createTime : j10;
        String str16 = str9;
        String str17 = str10;
        long j14 = (i15 & b.THRESHOLD) != 0 ? task.startTime : j11;
        long j15 = (i15 & 16384) != 0 ? task.updateTime : j12;
        TaskUIData taskUIData2 = (i15 & 32768) != 0 ? task.appUI : taskUIData;
        TaskError taskError2 = (i15 & 65536) != 0 ? task.error : taskError;
        String str18 = (i15 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? task.params : str8;
        Bundle bundle3 = (i15 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? task.bundle : bundle;
        if ((i15 & 524288) != 0) {
            bundle2 = bundle3;
            i16 = task.version;
        } else {
            i16 = i14;
            bundle2 = bundle3;
        }
        return task.copy(str16, str17, str11, str12, str13, str14, i17, i18, i19, i20, str15, list2, j13, j14, j15, taskUIData2, taskError2, str18, bundle2, i16);
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

    public final List<TaskAction> component12() {
        return this.actions;
    }

    /* renamed from: component13, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component14, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component15, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: component16, reason: from getter */
    public final TaskUIData getAppUI() {
        return this.appUI;
    }

    /* renamed from: component17, reason: from getter */
    public final TaskError getError() {
        return this.error;
    }

    /* renamed from: component18, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component19, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component20, reason: from getter */
    public final int getVersion() {
        return this.version;
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
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTriggerType() {
        return this.triggerType;
    }

    /* renamed from: component9, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final Task copy(String taskId, String conversationId, String name, String coverUri, String description, String sourcePackageName, int taskType, int triggerType, int status, int priority, String parentTaskId, List<TaskAction> actions, long createTime, long startTime, long updateTime, TaskUIData appUI, TaskError error, String params, Bundle bundle, int version) {
        p.i(taskId, "taskId");
        p.i(sourcePackageName, "sourcePackageName");
        return new Task(taskId, conversationId, name, coverUri, description, sourcePackageName, taskType, triggerType, status, priority, parentTaskId, actions, createTime, startTime, updateTime, appUI, error, params, bundle, version);
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
        return p.d(this.taskId, task.taskId) && p.d(this.conversationId, task.conversationId) && p.d(this.name, task.name) && p.d(this.coverUri, task.coverUri) && p.d(this.description, task.description) && p.d(this.sourcePackageName, task.sourcePackageName) && this.taskType == task.taskType && this.triggerType == task.triggerType && this.status == task.status && this.priority == task.priority && p.d(this.parentTaskId, task.parentTaskId) && p.d(this.actions, task.actions) && this.createTime == task.createTime && this.startTime == task.startTime && this.updateTime == task.updateTime && p.d(this.appUI, task.appUI) && p.d(this.error, task.error) && p.d(this.params, task.params) && p.d(this.bundle, task.bundle) && this.version == task.version;
    }

    public final List<TaskAction> getActions() {
        return this.actions;
    }

    public final TaskUIData getAppUI() {
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
        int iHashCode5 = (((((((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.sourcePackageName.hashCode()) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.triggerType)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.priority)) * 31;
        String str5 = this.parentTaskId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<TaskAction> list = this.actions;
        int iHashCode7 = (((((((iHashCode6 + (list == null ? 0 : list.hashCode())) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.updateTime)) * 31;
        TaskUIData taskUIData = this.appUI;
        int iHashCode8 = (iHashCode7 + (taskUIData == null ? 0 : taskUIData.hashCode())) * 31;
        TaskError taskError = this.error;
        int iHashCode9 = (iHashCode8 + (taskError == null ? 0 : taskError.hashCode())) * 31;
        String str6 = this.params;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Bundle bundle = this.bundle;
        return ((iHashCode10 + (bundle != null ? bundle.hashCode() : 0)) * 31) + Integer.hashCode(this.version);
    }

    public final void setActions(List<TaskAction> list) {
        this.actions = list;
    }

    public final void setAppUI(TaskUIData taskUIData) {
        this.appUI = taskUIData;
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
        p.i(str, "<set-?>");
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
        return "Task(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", name=" + this.name + ", coverUri=" + this.coverUri + ", description=" + this.description + ", sourcePackageName=" + this.sourcePackageName + ", taskType=" + this.taskType + ", triggerType=" + this.triggerType + ", status=" + this.status + ", priority=" + this.priority + ", parentTaskId=" + this.parentTaskId + ", actions=" + this.actions + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", updateTime=" + this.updateTime + ", appUI=" + this.appUI + ", error=" + this.error + ", params=" + this.params + ", bundle=" + this.bundle + ", version=" + this.version + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.conversationId);
        dest.writeString(this.name);
        dest.writeString(this.coverUri);
        dest.writeString(this.description);
        dest.writeString(this.sourcePackageName);
        dest.writeInt(this.taskType);
        dest.writeInt(this.triggerType);
        dest.writeInt(this.status);
        dest.writeInt(this.priority);
        dest.writeString(this.parentTaskId);
        List<TaskAction> list = this.actions;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<TaskAction> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeLong(this.createTime);
        dest.writeLong(this.startTime);
        dest.writeLong(this.updateTime);
        TaskUIData taskUIData = this.appUI;
        if (taskUIData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            taskUIData.writeToParcel(dest, flags);
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
        java.lang.NullPointerException
        */
    public /* synthetic */ Task(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, int r35, int r36, int r37, java.lang.String r38, java.util.List r39, long r40, long r42, long r44, com.zyql.intenttaskmanager.bean.TaskUIData r46, com.zyql.intenttaskmanager.bean.TaskError r47, java.lang.String r48, android.os.Bundle r49, int r50, int r51, kotlin.jvm.internal.i r52) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.intenttaskmanager.bean.Task.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, java.lang.String, java.util.List, long, long, long, com.zyql.intenttaskmanager.bean.TaskUIData, com.zyql.intenttaskmanager.bean.TaskError, java.lang.String, android.os.Bundle, int, int, kotlin.jvm.internal.i):void");
    }
}
