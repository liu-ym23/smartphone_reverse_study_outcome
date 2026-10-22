package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AccessibilityCondition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VisibleNodeCountCondition implements Parcelable {
    public static final Parcelable.Creator<VisibleNodeCountCondition> CREATOR = null;
    private final Integer max;
    private final Integer min;

    /* JADX INFO: compiled from: AccessibilityCondition.kt */
    public static final class Creator implements Parcelable.Creator<VisibleNodeCountCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisibleNodeCountCondition createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            Integer r1 = null;
            if (r4.readInt() != 0) goto L5;
            Integer r0 = null;
        L7:
            if (r4.readInt() == 0) goto L11;
            r1 = Integer.valueOf(r4.readInt());
        L11:
            return new VisibleNodeCountCondition(r0, r1);
        L5:
            r0 = Integer.valueOf(r4.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VisibleNodeCountCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisibleNodeCountCondition[] newArray(int r1) {
            return new VisibleNodeCountCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VisibleNodeCountCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VisibleNodeCountCondition() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VisibleNodeCountCondition copy$default(VisibleNodeCountCondition r0, Integer r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.min;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.max;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.min;
    }

    public final Integer component2() {
        return this.max;
    }

    public final VisibleNodeCountCondition copy(Integer r1, Integer r2) {
        return new VisibleNodeCountCondition(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, VisibleNodeCountCondition.class) == true) goto L8;
        return false;
    L8:
        VisibleNodeCountCondition r6 = (VisibleNodeCountCondition) ZeusTransformUtils.preCheckCast(r5, VisibleNodeCountCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.min, r6.min) == true) goto L12;
        return false;
    L12:
        if (o.a(this.max, r6.max) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.min;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.max;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "VisibleNodeCountCondition(min=" + this.min + ", max=" + this.max + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        Integer r5 = this.min;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r2 = this.max;
        if (r2 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r2.intValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public VisibleNodeCountCondition(Integer r1, Integer r2) {
        this.min = r1;
        this.max = r2;
    }

    public /* synthetic */ VisibleNodeCountCondition(Integer r2, Integer r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Integer getMin() {
        return this.min;
    }

    public final Integer getMax() {
        return this.max;
    }
}
