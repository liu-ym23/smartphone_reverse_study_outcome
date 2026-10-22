package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StorageCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<StorageCondition> CREATOR = null;
    private final float percent;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<StorageCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StorageCondition createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new StorageCondition(r1.readFloat());
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
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
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
    public final int describeContents() {
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

    public int hashCode() {
        return Float.hashCode(this.percent);
    }

    public String toString() {
        return "StorageCondition(percent=" + this.percent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeFloat(this.percent);
    }

    public StorageCondition(float r1) {
        this.percent = r1;
    }

    public final float getPercent() {
        return this.percent;
    }
}
