package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class ConditionTaskRecord implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final int RESULT_NO_LOCATION_PERMISSION = 2;
    public static final int RESULT_SKIPPED = 3;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNKNOWN_ERROR = 1;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static final class CREATOR implements Parcelable.Creator<ConditionTaskRecord> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConditionTaskRecord createFromParcel(Parcel r5) {
            int r4 = r5.readInt();
            o.e(r5, "parcel");
            ConditionTaskRecord r0 = new ConditionTaskRecord(r5);
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = CREATOR.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.a.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionTaskRecord createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConditionTaskRecord[] newArray(int r1) {
            return new ConditionTaskRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionTaskRecord[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ConditionTaskRecord(long r1, String r3, long r4, String r6, int r7) {
        this.id = r1;
        this.taskId = r3;
        this.triggerTime = r4;
        this.sourceFrom = r6;
        this.result = r7;
    }

    public ConditionTaskRecord(Parcel r10) {
        o.e(r10, "parcel");
        this(r10.readLong(), b.a(r10), r10.readLong(), b.a(r10), r10.readInt());
    }

    public static /* synthetic */ ConditionTaskRecord copy$default(ConditionTaskRecord r8, long r9, String r11, long r12, String r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.id;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.taskId;
    L11:
        if ((r16 & 4) == 0) goto L13;
        long r4 = r8.triggerTime;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r6 = r8.sourceFrom;
    L19:
        if ((r16 & 16) == 0) goto L21;
        int r7 = r8.result;
    L23:
        return r8.copy(r1, r3, r4, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final int component5() {
        return this.result;
    }

    public final ConditionTaskRecord copy(long r9, String r11, long r12, String r14, int r15) {
        return new ConditionTaskRecord(r9, r11, r12, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ConditionTaskRecord.class) == true) goto L8;
        return false;
    L8:
        ConditionTaskRecord r10 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecord.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (o.a(this.taskId, r10.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r10.triggerTime) goto L18;
        return false;
    L18:
        if (o.a(this.sourceFrom, r10.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (this.result == r10.result) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getId() {
        return this.id;
    }

    public final int getResult() {
        return this.result;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.id) * 31;
        String r1 = this.taskId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.triggerTime)) * 31;
        String r5 = this.sourceFrom;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Integer.hashCode(this.result);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskRecord(id=" + this.id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", sourceFrom=" + this.sourceFrom + ", result=" + this.result + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "parcel");
        r3.writeLong(this.id);
        r3.writeString(this.taskId);
        r3.writeLong(this.triggerTime);
        r3.writeString(this.sourceFrom);
        r3.writeInt(this.result);
    }
}
