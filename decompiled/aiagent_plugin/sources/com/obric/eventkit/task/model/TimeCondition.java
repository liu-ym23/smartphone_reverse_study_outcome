package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<TimeCondition> CREATOR = null;
    private final String end;
    private int interval;
    private final String start;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<TimeCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeCondition createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            return new TimeCondition(r3.readString(), r3.readString(), r3.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimeCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeCondition[] newArray(int r1) {
            return new TimeCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimeCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ TimeCondition copy$default(TimeCondition r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.start;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.end;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.interval;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.start;
    }

    public final String component2() {
        return this.end;
    }

    public final int component3() {
        return this.interval;
    }

    public final TimeCondition copy(String r1, String r2, int r3) {
        o.e(r1, "start");
        return new TimeCondition(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimeCondition.class) == true) goto L8;
        return false;
    L8:
        TimeCondition r6 = (TimeCondition) ZeusTransformUtils.preCheckCast(r5, TimeCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.start, r6.start) == true) goto L12;
        return false;
    L12:
        if (o.a(this.end, r6.end) == true) goto L15;
        return false;
    L15:
        if (this.interval == r6.interval) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.start.hashCode() * 31;
        String r1 = this.end;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.interval);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TimeCondition(start=" + this.start + ", end=" + this.end + ", interval=" + this.interval + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.start);
        r1.writeString(this.end);
        r1.writeInt(this.interval);
    }

    public TimeCondition(String r2, String r3, int r4) {
        o.e(r2, "start");
        this.start = r2;
        this.end = r3;
        this.interval = r4;
    }

    public /* synthetic */ TimeCondition(String r1, String r2, int r3, int r4, h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final String getStart() {
        return this.start;
    }

    public final String getEnd() {
        return this.end;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final void setInterval(int r1) {
        this.interval = r1;
    }
}
