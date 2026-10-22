package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class TriggerControlPolicy implements Parcelable {
    public static final Parcelable.Creator<TriggerControlPolicy> CREATOR = null;
    private final Boolean enable;
    private final Long minTriggerInterval;

    public static final class Creator implements Parcelable.Creator<TriggerControlPolicy> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TriggerControlPolicy createFromParcel(Parcel r8) {
            int r7 = r8.readInt();
            o.e(r8, "parcel");
            Long r3 = null;
            int r4 = 1;
            if (r8.readInt() != 0) goto L6;
            Boolean r1 = null;
        L11:
            if (r8.readInt() == 0) goto L14;
            r3 = Long.valueOf(r8.readLong());
        L14:
            TriggerControlPolicy r0 = new TriggerControlPolicy(r1, r3);
            int r2 = Math.min(r7, 0);
            ClassLoader r5 = Creator.class.getClassLoader();
        L15:
            if (r4 > r2) goto L17;
            r4 = r4 + 1;
        L17:
            if (r4 > r7) goto L19;
            com.obric.a.a.a(r8, r5);
            r4 = r4 + 1;
            goto L17
        L19:
            return r0;
        L6:
            if (r8.readInt() == 0) goto L8;
            boolean r6 = true;
        L9:
            r1 = Boolean.valueOf(r6);
            goto L11
        L8:
            r6 = false;
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
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerControlPolicy() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
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
        r2 = Long.valueOf(600000);
    L8:
        this(r1, r2);
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
    public int describeContents() {
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

    public final Boolean getEnable() {
        return this.enable;
    }

    public final Long getMinTriggerInterval() {
        return this.minTriggerInterval;
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
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        Boolean r0 = this.enable;
        if (r0 != null) goto L5;
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
        r3.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }
}
