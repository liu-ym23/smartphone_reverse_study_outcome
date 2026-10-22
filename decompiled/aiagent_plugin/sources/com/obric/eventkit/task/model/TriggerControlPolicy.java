package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TriggerControlPolicy implements Parcelable {
    public static final Parcelable.Creator<TriggerControlPolicy> CREATOR = null;
    private final Boolean enable;
    private final Long minTriggerInterval;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<TriggerControlPolicy> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TriggerControlPolicy createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            Long r1 = null;
            if (r4.readInt() != 0) goto L6;
            Boolean r0 = null;
        L11:
            if (r4.readInt() == 0) goto L15;
            r1 = Long.valueOf(r4.readLong());
        L15:
            return new TriggerControlPolicy(r0, r1);
        L6:
            if (r4.readInt() == 0) goto L8;
            boolean r2 = true;
        L9:
            r0 = Boolean.valueOf(r2);
            goto L11
        L8:
            r2 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TriggerControlPolicy createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TriggerControlPolicy[] newArray(int r1) {
            return new TriggerControlPolicy[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TriggerControlPolicy[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerControlPolicy() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TriggerControlPolicy copy$default(TriggerControlPolicy r0, Boolean r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.minTriggerInterval;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final Long component2() {
        return this.minTriggerInterval;
    }

    public final TriggerControlPolicy copy(Boolean r1, Long r2) {
        return new TriggerControlPolicy(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TriggerControlPolicy.class) == true) goto L8;
        return false;
    L8:
        TriggerControlPolicy r6 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r5, TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        if (o.a(this.enable, r6.enable) == true) goto L12;
        return false;
    L12:
        if (o.a(this.minTriggerInterval, r6.minTriggerInterval) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.minTriggerInterval;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TriggerControlPolicy(enable=" + this.enable + ", minTriggerInterval=" + this.minTriggerInterval + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        Boolean r5 = this.enable;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Long r2 = this.minTriggerInterval;
        if (r2 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeLong(r2.longValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    public TriggerControlPolicy(Boolean r1, Long r2) {
        this.enable = r1;
        this.minTriggerInterval = r2;
    }

    public /* synthetic */ TriggerControlPolicy(Boolean r1, Long r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 600000L;
    L8:
        this(r1, r2);
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final Long getMinTriggerInterval() {
        return this.minTriggerInterval;
    }
}
