package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: TaskInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskInfo implements Parcelable {
    public static final Parcelable.Creator<TaskInfo> CREATOR = null;
    private final long createdTime;
    private final Map<String, String> ext;
    private int index;
    private final IMMessage message;
    private Integer progress;
    private final String queryId;
    private final TaskId taskId;
    private final TaskType taskType;

    /* JADX INFO: compiled from: TaskInfo.kt */
    public static final class Creator implements Parcelable.Creator<TaskInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfo createFromParcel(Parcel r13) {
            o.e(r13, "parcel");
            TaskId r3 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r13), TaskId.class, "com.obric.aiagent.plugin");
            TaskType r4 = (TaskType) ZeusTransformUtils.preCheckCast(TaskType.CREATOR.createFromParcel(r13), TaskType.class, "com.obric.aiagent.plugin");
            IMMessage r5 = (IMMessage) ZeusTransformUtils.preCheckCast(r13.readParcelable(TaskInfo.class.getClassLoader()), IMMessage.class, "com.obric.aiagent.plugin");
            long r6 = r13.readLong();
            String r8 = r13.readString();
            LinkedHashMap r0 = null;
            if (r13.readInt() != 0) goto L5;
            Integer r9 = null;
        L7:
            if (r13.readInt() == 0) goto L13;
            int r12 = r13.readInt();
            r0 = new LinkedHashMap(r12);
            int r2 = 0;
        L10:
            if (r2 == r12) goto L13;
            r0.put(r13.readString(), r13.readString());
            r2 = r2 + 1;
        L13:
            return new TaskInfo(r3, r4, r5, r6, r8, r9, (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"), r13.readInt());
        L5:
            r9 = Integer.valueOf(r13.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfo[] newArray(int r1) {
            return new TaskInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ TaskInfo copy$default(TaskInfo r11, TaskId r12, TaskType r13, IMMessage r14, long r15, String r17, Integer r18, Map r19, int r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        TaskId r3 = r11.taskId;
    L7:
        if ((r21 & 2) == 0) goto L9;
        TaskType r4 = r11.taskType;
    L11:
        if ((r21 & 4) == 0) goto L13;
        IMMessage r5 = r11.message;
    L15:
        if ((r21 & 8) == 0) goto L17;
        long r6 = r11.createdTime;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r8 = r11.queryId;
    L23:
        if ((r21 & 32) == 0) goto L25;
        Integer r9 = r11.progress;
    L27:
        if ((r21 & 64) == 0) goto L30;
        r2 = r11.ext;
    L30:
        if ((r21 & 128) == 0) goto L32;
        int r1 = r11.index;
    L34:
        return r11.copy(r3, r4, r5, r6, r8, r9, r2, r1);
    L32:
        r1 = r20;
        goto L34
    L25:
        r9 = r18;
        goto L27
    L21:
        r8 = r17;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public final TaskId component1() {
        return this.taskId;
    }

    public final TaskType component2() {
        return this.taskType;
    }

    public final IMMessage component3() {
        return this.message;
    }

    public final long component4() {
        return this.createdTime;
    }

    public final String component5() {
        return this.queryId;
    }

    public final Integer component6() {
        return this.progress;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final int component8() {
        return this.index;
    }

    public final TaskInfo copy(TaskId r12, TaskType r13, IMMessage r14, long r15, String r17, Integer r18, Map<String, String> r19, int r20) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        o.e(r12, DBDefinition.TASK_ID);
        o.e(r13, "taskType");
        return new TaskInfo(r12, r13, r14, r15, r17, r18, r9, r20);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TaskInfo.class) == true) goto L8;
        return false;
    L8:
        TaskInfo r10 = (TaskInfo) ZeusTransformUtils.preCheckCast(r9, TaskInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r10.taskId) == true) goto L12;
        return false;
    L12:
        if (this.taskType == r10.taskType) goto L15;
        return false;
    L15:
        if (o.a(this.message, r10.message) == true) goto L18;
        return false;
    L18:
        if (this.createdTime == r10.createdTime) goto L21;
        return false;
    L21:
        if (o.a(this.queryId, r10.queryId) == true) goto L24;
        return false;
    L24:
        if (o.a(this.progress, r10.progress) == true) goto L27;
        return false;
    L27:
        if (o.a(this.ext, r10.ext) == true) goto L30;
        return false;
    L30:
        if (this.index == r10.index) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.taskId.hashCode() * 31) + this.taskType.hashCode()) * 31;
        IMMessage r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.createdTime)) * 31;
        String r5 = this.queryId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.progress;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.ext;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + Integer.hashCode(this.index);
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TaskInfo(taskId=" + this.taskId + ", taskType=" + this.taskType + ", message=" + this.message + ", createdTime=" + this.createdTime + ", queryId=" + this.queryId + ", progress=" + this.progress + ", ext=" + this.ext + ", index=" + this.index + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        this.taskId.writeToParcel(r5, r6);
        this.taskType.writeToParcel(r5, r6);
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.message, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        r5.writeLong(this.createdTime);
        r5.writeString(this.queryId);
        Integer r7 = this.progress;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Map<String, String> r8 = this.ext;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L13:
        r5.writeInt(this.index);
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.size());
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        Map.Entry<String, String> r0 = r9.next();
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L11
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
        goto L6
    }

    public TaskInfo(TaskId r3, TaskType r4, IMMessage r5, long r6, String r8, Integer r9, Map<String, String> r10, int r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r4, "taskType");
        this.taskId = r3;
        this.taskType = r4;
        this.message = r5;
        this.createdTime = r6;
        this.queryId = r8;
        this.progress = r9;
        this.ext = r12;
        this.index = r11;
    }

    public final TaskId getTaskId() {
        return this.taskId;
    }

    public final TaskType getTaskType() {
        return this.taskType;
    }

    public final IMMessage getMessage() {
        return this.message;
    }

    public /* synthetic */ TaskInfo(TaskId r16, TaskType r17, IMMessage r18, long r19, String r21, Integer r22, Map r23, int r24, int r25, h r26) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        if ((r25 & 4) == 0) goto L5;
        IMMessage r8 = null;
    L7:
        if ((r25 & 8) == 0) goto L9;
        long r9 = System.currentTimeMillis();
    L11:
        if ((r25 & 16) == 0) goto L13;
        String r11 = null;
    L15:
        if ((r25 & 32) == 0) goto L17;
        Integer r12 = null;
    L19:
        if ((r25 & 64) == 0) goto L21;
        r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L21:
        Map r13 = r1;
        if ((r25 & 128) == 0) goto L24;
        int r14 = 0;
    L25:
        this(r16, r17, r8, r9, r11, r12, r13, r14);
        return;
    L24:
        r14 = r24;
        goto L25
    L17:
        r12 = r22;
        goto L19
    L13:
        r11 = r21;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final void setProgress(Integer r1) {
        this.progress = r1;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int r1) {
        this.index = r1;
    }
}
