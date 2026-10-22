package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class BatteryCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<BatteryCondition> CREATOR = null;
    private final boolean isCharging;
    private final double percent;

    public static final class Creator implements Parcelable.Creator<BatteryCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatteryCondition createFromParcel(Parcel r7) {
            int r6 = r7.readInt();
            o.e(r7, "parcel");
            double r1 = r7.readDouble();
            int r5 = 1;
            if (r7.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            BatteryCondition r0 = new BatteryCondition(r1, r3);
            int r2 = Math.min(r6, 0);
            ClassLoader r4 = Creator.class.getClassLoader();
        L7:
            if (r5 > r2) goto L9;
            r5 = r5 + 1;
        L9:
            if (r5 > r6) goto L11;
            com.obric.a.a.a(r7, r4);
            r5 = r5 + 1;
            goto L9
        L11:
            return r0;
        L5:
            r3 = false;
            goto L6
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
        CREATOR = new Creator();
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
    public int describeContents() {
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

    public final double getPercent() {
        return this.percent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = Double.hashCode(this.percent) * 31;
        boolean r2 = this.isCharging;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public String toString() {
        return "BatteryCondition(percent=" + this.percent + ", isCharging=" + this.isCharging + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        r3.writeDouble(this.percent);
        r3.writeInt(this.isCharging ? 1 : 0);
    }
}
