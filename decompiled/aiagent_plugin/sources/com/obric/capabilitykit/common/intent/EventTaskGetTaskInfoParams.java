package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: EventTaskGetTaskInfoParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EventTaskGetTaskInfoParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<EventTaskGetTaskInfoParams> CREATOR = null;
    private String taskId;
    private Integer taskType;

    /* JADX INFO: compiled from: EventTaskGetTaskInfoParams.kt */
    public static final class Creator implements Parcelable.Creator<EventTaskGetTaskInfoParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskGetTaskInfoParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            String r2 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            EventTaskGetTaskInfoParams r1 = new EventTaskGetTaskInfoParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            a.a(r5, r6);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskGetTaskInfoParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskGetTaskInfoParams[] newArray(int r1) {
            return new EventTaskGetTaskInfoParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskGetTaskInfoParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventTaskGetTaskInfoParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EventTaskGetTaskInfoParams copy$default(EventTaskGetTaskInfoParams r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.taskId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.taskType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.taskId;
    }

    public final Integer component2() {
        return this.taskType;
    }

    public final EventTaskGetTaskInfoParams copy(String r1, Integer r2) {
        return new EventTaskGetTaskInfoParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EventTaskGetTaskInfoParams.class) == true) goto L8;
        return false;
    L8:
        EventTaskGetTaskInfoParams r6 = (EventTaskGetTaskInfoParams) ZeusTransformUtils.preCheckCast(r5, EventTaskGetTaskInfoParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.taskType, r6.taskType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.taskType;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskGetTaskInfoParams(taskId=" + this.taskId + ", taskType=" + this.taskType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        o.e(r2, "out");
        r2.writeString(this.taskId);
        Integer r1 = this.taskType;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }

    public EventTaskGetTaskInfoParams(String r1, Integer r2) {
        this.taskId = r1;
        this.taskType = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ EventTaskGetTaskInfoParams(String r2, Integer r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final void setTaskType(Integer r1) {
        this.taskType = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.taskId != null) goto L5;
    L7:
        return false;
    L5:
        if (this.taskType == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, EventTaskGetTaskInfoParams.class) == false) goto L5;
        String r1 = this.taskId;
        if (r1 != null) goto L9;
        r1 = ((EventTaskGetTaskInfoParams) ZeusTransformUtils.preCheckCast(r4, EventTaskGetTaskInfoParams.class, "com.obric.aiagent.plugin")).taskId;
    L9:
        Integer r3 = this.taskType;
        if (r3 != null) goto L13;
        r3 = ((EventTaskGetTaskInfoParams) ZeusTransformUtils.preCheckCast(r4, EventTaskGetTaskInfoParams.class, "com.obric.aiagent.plugin")).taskType;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new EventTaskGetTaskInfoParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
