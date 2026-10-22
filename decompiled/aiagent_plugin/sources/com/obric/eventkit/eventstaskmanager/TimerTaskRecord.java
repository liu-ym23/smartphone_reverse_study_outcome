package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class TimerTaskRecord implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;
    private final int id;
    private Long realActionTime;
    private final String sourceFrom;
    private final String taskId;
    private final int taskStatus;
    private final long triggerTime;

    public static final class CREATOR implements Parcelable.Creator<TimerTaskRecord> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimerTaskRecord createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new TimerTaskRecord(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimerTaskRecord createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimerTaskRecord[] newArray(int r1) {
            return new TimerTaskRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimerTaskRecord[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public TimerTaskRecord(int r2, String r3, long r4, Long r6, String r7, int r8) {
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r7, "sourceFrom");
        this.id = r2;
        this.taskId = r3;
        this.triggerTime = r4;
        this.realActionTime = r6;
        this.sourceFrom = r7;
        this.taskStatus = r8;
    }

    public TimerTaskRecord(Parcel r10) {
        o.e(r10, "parcel");
        this(r10.readInt(), String.valueOf(r10.readInt()), r10.readLong(), Long.valueOf(r10.readLong()), b.a(r10), r10.readInt());
        Long r11 = this.realActionTime;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.longValue() != (-1)) goto L9;
        this.realActionTime = null;
        return;
    }

    public static /* synthetic */ TimerTaskRecord copy$default(TimerTaskRecord r5, int r6, String r7, long r8, Long r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.taskId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.triggerTime;
    L11:
        long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.realActionTime;
    L14:
        Long r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.sourceFrom;
    L17:
        String r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.taskStatus;
    L20:
        int r9 = r6;
        return r5.copy(r9, r15, r0, r2, r3, r12);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final Long component4() {
        return this.realActionTime;
    }

    public final String component5() {
        return this.sourceFrom;
    }

    public final int component6() {
        return this.taskStatus;
    }

    public final TimerTaskRecord copy(int r9, String r10, long r11, Long r13, String r14, int r15) {
        o.e(r10, DBDefinition.TASK_ID);
        o.e(r14, "sourceFrom");
        return new TimerTaskRecord(r9, r10, r11, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimerTaskRecord.class) == true) goto L8;
        return false;
    L8:
        TimerTaskRecord r10 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r9, TimerTaskRecord.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (o.a(this.taskId, r10.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r10.triggerTime) goto L18;
        return false;
    L18:
        if (o.a(this.realActionTime, r10.realActionTime) == true) goto L21;
        return false;
    L21:
        if (o.a(this.sourceFrom, r10.sourceFrom) == true) goto L24;
        return false;
    L24:
        if (this.taskStatus == r10.taskStatus) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getId() {
        return this.id;
    }

    public final Long getRealActionTime() {
        return this.realActionTime;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.id) * 31) + this.taskId.hashCode()) * 31) + Long.hashCode(this.triggerTime)) * 31;
        Long r1 = this.realActionTime;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.sourceFrom.hashCode()) * 31) + Integer.hashCode(this.taskStatus);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final void setRealActionTime(Long r1) {
        this.realActionTime = r1;
    }

    public String toString() {
        return "TimerTaskRecord(id=" + this.id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", realActionTime=" + this.realActionTime + ", sourceFrom=" + this.sourceFrom + ", taskStatus=" + this.taskStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeInt(this.id);
        Integer r5 = d.o.o.d(this.taskId);
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        r3.writeInt(r6);
        r3.writeLong(this.triggerTime);
        Long r7 = this.realActionTime;
        if (r7 == null) goto L9;
        long r0 = r7.longValue();
    L10:
        r3.writeLong(r0);
        r3.writeString(this.sourceFrom);
        r3.writeInt(this.taskStatus);
        return;
    L9:
        r0 = -1;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }
}
