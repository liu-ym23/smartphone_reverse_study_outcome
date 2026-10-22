package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DMTaskState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DMTaskState implements Parcelable {
    public static final Parcelable.Creator<DMTaskState> CREATOR = null;
    private final Map<String, String> extra;
    private final int state;
    private final String taskId;
    private final DMTaskInfo taskInfo;

    /* JADX INFO: compiled from: DMTaskState.kt */
    public static final class Creator implements Parcelable.Creator<DMTaskState> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMTaskState createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            String r8 = r9.readString();
            if (r9.readInt() != 0) goto L5;
            DMTaskInfo r0 = null;
        L6:
            DMTaskInfo r1 = (DMTaskInfo) ZeusTransformUtils.preCheckCast(r0, DMTaskInfo.class, "com.obric.aiagent.plugin");
            int r2 = r9.readInt();
            int r3 = r9.readInt();
            LinkedHashMap r4 = new LinkedHashMap(r3);
            int r5 = 0;
        L7:
            if (r5 == r3) goto L10;
            r4.put(r9.readString(), r9.readString());
            r5 = r5 + 1;
            goto L7
        L10:
            return new DMTaskState(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        L5:
            r0 = DMTaskInfo.CREATOR.createFromParcel(r9);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMTaskState createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMTaskState[] newArray(int r1) {
            return new DMTaskState[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMTaskState[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ DMTaskState copy$default(DMTaskState r1, String r2, DMTaskInfo r3, int r4, Map r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.taskId;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.taskInfo;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.state;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.extra;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.taskId;
    }

    public final DMTaskInfo component2() {
        return this.taskInfo;
    }

    public final int component3() {
        return this.state;
    }

    public final Map<String, String> component4() {
        return this.extra;
    }

    public final DMTaskState copy(String r2, DMTaskInfo r3, int r4, Map<String, String> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, DBDefinition.TASK_ID);
        o.e(r1, "extra");
        return new DMTaskState(r2, r3, r4, r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DMTaskState.class) == true) goto L8;
        return false;
    L8:
        DMTaskState r6 = (DMTaskState) ZeusTransformUtils.preCheckCast(r5, DMTaskState.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.taskInfo, r6.taskInfo) == true) goto L15;
        return false;
    L15:
        if (this.state == r6.state) goto L18;
        return false;
    L18:
        if (o.a(this.extra, r6.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.taskId.hashCode() * 31;
        DMTaskInfo r1 = this.taskInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Integer.hashCode(this.state)) * 31) + this.extra.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DMTaskState(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeString(this.taskId);
        DMTaskInfo r0 = this.taskInfo;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeInt(this.state);
        Map<String, String> r3 = this.extra;
        r4.writeInt(r3.size());
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, String> r7 = r6.next();
        r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public DMTaskState(String r3, DMTaskInfo r4, int r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r7, "extra");
        this.taskId = r3;
        this.taskInfo = r4;
        this.state = r5;
        this.extra = r7;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final DMTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final int getState() {
        return this.state;
    }

    public /* synthetic */ DMTaskState(String r2, DMTaskInfo r3, int r4, Map r5, int r6, h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = ao.b();
    L8:
        this(r2, r3, r4, r8);
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }
}
