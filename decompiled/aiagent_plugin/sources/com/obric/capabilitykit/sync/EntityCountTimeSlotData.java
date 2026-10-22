package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityCountTimeSlotData implements Parcelable {
    public static final a CREATOR = null;
    private int count;
    private long endTimeLong;
    private int leftIndex;
    private int leftTimeArrayIndex;
    private int rightIndex;
    private int rightTimeArrayIndex;
    private long startTime;

    public static final class a implements Parcelable.Creator<EntityCountTimeSlotData> {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public EntityCountTimeSlotData a(Parcel r1) {
            o.e(r1, "parcel");
            return new EntityCountTimeSlotData(r1);
        }

        public EntityCountTimeSlotData[] a(int r1) {
            return new EntityCountTimeSlotData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCountTimeSlotData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCountTimeSlotData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityCountTimeSlotData(long r1, long r3, int r5, int r6, int r7) {
        this.startTime = r1;
        this.endTimeLong = r3;
        this.count = r5;
        this.leftTimeArrayIndex = r6;
        this.rightTimeArrayIndex = r7;
        this.leftIndex = -1;
        this.rightIndex = -1;
    }

    public EntityCountTimeSlotData(Parcel r14) {
        o.e(r14, "parcel");
        Class r0 = Long.TYPE;
        Object r1 = r14.readValue(r0.getClassLoader());
        o.a(r1, "null cannot be cast to non-null type kotlin.Long");
        long r6 = ((Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.aiagent.plugin")).longValue();
        Object r2 = r14.readValue(r0.getClassLoader());
        o.a(r2, "null cannot be cast to non-null type kotlin.Long");
        this(r6, ((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin")).longValue(), r14.readInt(), r14.readInt(), r14.readInt());
        Class r3 = Integer.TYPE;
        Object r4 = r14.readValue(r3.getClassLoader());
        o.a(r4, "null cannot be cast to non-null type kotlin.Int");
        this.leftIndex = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue();
        Object r15 = r14.readValue(r3.getClassLoader());
        o.a(r15, "null cannot be cast to non-null type kotlin.Int");
        this.rightIndex = ((Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    public static /* synthetic */ EntityCountTimeSlotData copy$default(EntityCountTimeSlotData r8, long r9, long r11, int r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.startTime;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r3 = r8.endTimeLong;
    L11:
        if ((r16 & 4) == 0) goto L13;
        int r5 = r8.count;
    L15:
        if ((r16 & 8) == 0) goto L17;
        int r6 = r8.leftTimeArrayIndex;
    L19:
        if ((r16 & 16) == 0) goto L21;
        int r7 = r8.rightTimeArrayIndex;
    L23:
        return r8.copy(r1, r3, r5, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTimeLong;
    }

    public final int component3() {
        return this.count;
    }

    public final int component4() {
        return this.leftTimeArrayIndex;
    }

    public final int component5() {
        return this.rightTimeArrayIndex;
    }

    public final EntityCountTimeSlotData copy(long r9, long r11, int r13, int r14, int r15) {
        return new EntityCountTimeSlotData(r9, r11, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EntityCountTimeSlotData.class) == true) goto L8;
        return false;
    L8:
        EntityCountTimeSlotData r10 = (EntityCountTimeSlotData) ZeusTransformUtils.preCheckCast(r9, EntityCountTimeSlotData.class, "com.obric.aiagent.plugin");
        if (this.startTime == r10.startTime) goto L12;
        return false;
    L12:
        if (this.endTimeLong == r10.endTimeLong) goto L15;
        return false;
    L15:
        if (this.count == r10.count) goto L18;
        return false;
    L18:
        if (this.leftTimeArrayIndex == r10.leftTimeArrayIndex) goto L21;
        return false;
    L21:
        if (this.rightTimeArrayIndex == r10.rightTimeArrayIndex) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getEndTimeLong() {
        return this.endTimeLong;
    }

    public final int getLeftIndex() {
        return this.leftIndex;
    }

    public final int getLeftTimeArrayIndex() {
        return this.leftTimeArrayIndex;
    }

    public final int getRightIndex() {
        return this.rightIndex;
    }

    public final int getRightTimeArrayIndex() {
        return this.rightTimeArrayIndex;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTimeLong)) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.leftTimeArrayIndex)) * 31) + Integer.hashCode(this.rightTimeArrayIndex);
    }

    public final void setCount(int r1) {
        this.count = r1;
    }

    public final void setEndTimeLong(long r1) {
        this.endTimeLong = r1;
    }

    public final void setLeftIndex(int r1) {
        this.leftIndex = r1;
    }

    public final void setLeftTimeArrayIndex(int r1) {
        this.leftTimeArrayIndex = r1;
    }

    public final void setRightIndex(int r1) {
        this.rightIndex = r1;
    }

    public final void setRightTimeArrayIndex(int r1) {
        this.rightTimeArrayIndex = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public String toString() {
        return "EntityCountTimeSlotData(startTime=" + this.startTime + ", endTimeLong=" + this.endTimeLong + ", count=" + this.count + ", leftTimeArrayIndex=" + this.leftTimeArrayIndex + ", rightTimeArrayIndex=" + this.rightTimeArrayIndex + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeValue(Long.valueOf(this.startTime));
        r3.writeValue(Long.valueOf(this.endTimeLong));
        r3.writeInt(this.count);
        r3.writeInt(this.leftTimeArrayIndex);
        r3.writeInt(this.rightTimeArrayIndex);
        r3.writeValue(Integer.valueOf(this.leftIndex));
        r3.writeValue(Integer.valueOf(this.rightIndex));
    }
}
