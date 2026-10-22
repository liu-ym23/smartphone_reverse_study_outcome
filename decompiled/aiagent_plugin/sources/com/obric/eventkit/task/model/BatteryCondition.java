package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BatteryCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<BatteryCondition> CREATOR = null;
    private final boolean isCharging;
    private final double percent;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<BatteryCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatteryCondition createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            double r0 = r3.readDouble();
            if (r3.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            return new BatteryCondition(r0, r4);
        L5:
            r4 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BatteryCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatteryCondition[] newArray(int r1) {
            return new BatteryCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BatteryCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ BatteryCondition copy$default(BatteryCondition r0, double r1, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.percent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.isCharging;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.percent;
    }

    public final boolean component2() {
        return this.isCharging;
    }

    public final BatteryCondition copy(double r1, boolean r3) {
        return new BatteryCondition(r1, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, BatteryCondition.class) == true) goto L8;
        return false;
    L8:
        BatteryCondition r10 = (BatteryCondition) ZeusTransformUtils.preCheckCast(r9, BatteryCondition.class, "com.obric.aiagent.plugin");
        if (Double.compare(this.percent, r10.percent) == 0) goto L12;
        return false;
    L12:
        if (this.isCharging == r10.isCharging) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Double.hashCode(this.percent) * 31) + Boolean.hashCode(this.isCharging);
    }

    public String toString() {
        return "BatteryCondition(percent=" + this.percent + ", isCharging=" + this.isCharging + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeDouble(this.percent);
        r3.writeInt(this.isCharging ? 1 : 0);
    }

    public BatteryCondition(double r1, boolean r3) {
        this.percent = r1;
        this.isCharging = r3;
    }

    public /* synthetic */ BatteryCondition(double r1, boolean r3, int r4, h r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r3);
    }

    public final double getPercent() {
        return this.percent;
    }

    public final boolean isCharging() {
        return this.isCharging;
    }
}
