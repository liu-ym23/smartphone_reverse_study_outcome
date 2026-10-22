package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class StorageCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<StorageCondition> CREATOR = null;
    private final float percent;

    public static final class Creator implements Parcelable.Creator<StorageCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StorageCondition createFromParcel(Parcel r5) {
            int r4 = r5.readInt();
            o.e(r5, "parcel");
            StorageCondition r0 = new StorageCondition(r5.readFloat());
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = Creator.class.getClassLoader();
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
        public /* bridge */ /* synthetic */ StorageCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StorageCondition[] newArray(int r1) {
            return new StorageCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StorageCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public StorageCondition(float r1) {
        this.percent = r1;
    }

    public static /* synthetic */ StorageCondition copy$default(StorageCondition r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.percent;
    L6:
        return r0.copy(r1);
    }

    public final float component1() {
        return this.percent;
    }

    public final StorageCondition copy(float r1) {
        return new StorageCondition(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, StorageCondition.class) == true) goto L8;
        return false;
    L8:
        StorageCondition r6 = (StorageCondition) ZeusTransformUtils.preCheckCast(r5, StorageCondition.class, "com.obric.aiagent.plugin");
        if (Float.compare(this.percent, r6.percent) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return Float.hashCode(this.percent);
    }

    public String toString() {
        return "StorageCondition(percent=" + this.percent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeFloat(this.percent);
    }
}
