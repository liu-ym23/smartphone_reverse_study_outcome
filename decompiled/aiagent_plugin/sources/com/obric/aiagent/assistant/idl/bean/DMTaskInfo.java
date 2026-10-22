package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DMTaskInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DMTaskInfo implements Parcelable {
    public static final Parcelable.Creator<DMTaskInfo> CREATOR = null;
    private final long createdTime;
    private final Map<String, String> ext;
    private final IMMessage message;
    private final Integer progress;
    private final String taskId;
    private final int taskType;

    /* JADX INFO: compiled from: DMTaskInfo.kt */
    public static final class Creator implements Parcelable.Creator<DMTaskInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMTaskInfo createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            String r1 = r12.readString();
            int r2 = r12.readInt();
            LinkedHashMap r0 = null;
            if (r12.readInt() != 0) goto L5;
            IMMessage r11 = null;
        L6:
            IMMessage r3 = (IMMessage) ZeusTransformUtils.preCheckCast(r11, IMMessage.class, "com.obric.aiagent.plugin");
            long r5 = r12.readLong();
            if (r12.readInt() != 0) goto L9;
            Integer r13 = null;
        L11:
            if (r12.readInt() == 0) goto L18;
            int r4 = r12.readInt();
            LinkedHashMap r7 = new LinkedHashMap(r4);
            int r8 = 0;
        L14:
            if (r8 == r4) goto L16;
            r7.put(r12.readString(), r12.readString());
            r8 = r8 + 1;
            goto L14
        L16:
            r0 = r7;
        L18:
            return new DMTaskInfo(r1, r2, r3, r5, r13, (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        L9:
            r13 = Integer.valueOf(r12.readInt());
            goto L11
        L5:
            r11 = IMMessage.CREATOR.createFromParcel(r12);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMTaskInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMTaskInfo[] newArray(int r1) {
            return new DMTaskInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMTaskInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ DMTaskInfo copy$default(DMTaskInfo r9, String r10, int r11, IMMessage r12, long r13, Integer r15, Map r16, int r17, Object r18) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        if ((r17 & 1) == 0) goto L5;
        String r2 = r9.taskId;
    L7:
        if ((r17 & 2) == 0) goto L9;
        int r3 = r9.taskType;
    L11:
        if ((r17 & 4) == 0) goto L13;
        IMMessage r4 = r9.message;
    L15:
        if ((r17 & 8) == 0) goto L17;
        long r5 = r9.createdTime;
    L19:
        if ((r17 & 16) == 0) goto L21;
        Integer r7 = r9.progress;
    L23:
        if ((r17 & 32) == 0) goto L26;
        r1 = r9.ext;
    L26:
        return r9.copy(r2, r3, r4, r5, r7, r1);
    L21:
        r7 = r15;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.taskType;
    }

    public final IMMessage component3() {
        return this.message;
    }

    public final long component4() {
        return this.createdTime;
    }

    public final Integer component5() {
        return this.progress;
    }

    public final Map<String, String> component6() {
        return this.ext;
    }

    public final DMTaskInfo copy(String r9, int r10, IMMessage r11, long r12, Integer r14, Map<String, String> r15) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, DBDefinition.TASK_ID);
        return new DMTaskInfo(r9, r10, r11, r12, r14, r7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, DMTaskInfo.class) == true) goto L8;
        return false;
    L8:
        DMTaskInfo r10 = (DMTaskInfo) ZeusTransformUtils.preCheckCast(r9, DMTaskInfo.class, "com.obric.aiagent.plugin");
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
        if (o.a(this.progress, r10.progress) == true) goto L24;
        return false;
    L24:
        if (o.a(this.ext, r10.ext) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.taskId.hashCode() * 31) + Integer.hashCode(this.taskType)) * 31;
        IMMessage r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.createdTime)) * 31;
        Integer r5 = this.progress;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.ext;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DMTaskInfo(taskId=" + this.taskId + ", taskType=" + this.taskType + ", message=" + this.message + ", createdTime=" + this.createdTime + ", progress=" + this.progress + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        o.e(r6, "dest");
        r6.writeString(this.taskId);
        r6.writeInt(this.taskType);
        IMMessage r0 = this.message;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        r6.writeLong(this.createdTime);
        Integer r8 = this.progress;
        if (r8 != null) goto L9;
        r6.writeInt(0);
    L10:
        Map<String, String> r5 = this.ext;
        if (r5 != null) goto L13;
        r6.writeInt(0);
        return;
    L13:
        r6.writeInt(1);
        r6.writeInt(r5.size());
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        Map.Entry<String, String> r10 = r9.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L15
    L19:
        return;
    L9:
        r6.writeInt(1);
        r6.writeInt(r8.intValue());
        goto L10
    L5:
        r6.writeInt(1);
        r0.writeToParcel(r6, r7);
        goto L6
    }

    public DMTaskInfo(String r3, int r4, IMMessage r5, long r6, Integer r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TASK_ID);
        this.taskId = r3;
        this.taskType = r4;
        this.message = r5;
        this.createdTime = r6;
        this.progress = r8;
        this.ext = r10;
    }

    public /* synthetic */ DMTaskInfo(String r12, int r13, IMMessage r14, long r15, Integer r17, Map r18, int r19, h r20) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        if ((r19 & 4) == 0) goto L5;
        IMMessage r6 = null;
    L7:
        if ((r19 & 16) == 0) goto L9;
        Integer r9 = null;
    L11:
        if ((r19 & 32) == 0) goto L13;
        Map r10 = null;
    L14:
        this(r12, r13, r6, r15, r9, r10);
        return;
    L13:
        r10 = r0;
        goto L14
    L9:
        r9 = r17;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final IMMessage getMessage() {
        return this.message;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }
}
