package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AttemptedOutboundTargetParcel implements Parcelable {
    public static final Parcelable.Creator<AttemptedOutboundTargetParcel> CREATOR = null;
    private final long count;
    private final OutboundTargetParcel target;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<AttemptedOutboundTargetParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AttemptedOutboundTargetParcel createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            return new AttemptedOutboundTargetParcel((OutboundTargetParcel) ZeusTransformUtils.preCheckCast(OutboundTargetParcel.CREATOR.createFromParcel(r4), OutboundTargetParcel.class, "com.obric.aiagent.plugin"), r4.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AttemptedOutboundTargetParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AttemptedOutboundTargetParcel[] newArray(int r1) {
            return new AttemptedOutboundTargetParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AttemptedOutboundTargetParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ AttemptedOutboundTargetParcel copy$default(AttemptedOutboundTargetParcel r0, OutboundTargetParcel r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.count;
    L9:
        return r0.copy(r1, r2);
    }

    public final OutboundTargetParcel component1() {
        return this.target;
    }

    public final long component2() {
        return this.count;
    }

    public final AttemptedOutboundTargetParcel copy(OutboundTargetParcel r1, long r2) {
        o.e(r1, "target");
        return new AttemptedOutboundTargetParcel(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, AttemptedOutboundTargetParcel.class) == true) goto L8;
        return false;
    L8:
        AttemptedOutboundTargetParcel r8 = (AttemptedOutboundTargetParcel) ZeusTransformUtils.preCheckCast(r7, AttemptedOutboundTargetParcel.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r8.target) == true) goto L12;
        return false;
    L12:
        if (this.count == r8.count) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.target.hashCode() * 31) + Long.hashCode(this.count);
    }

    public String toString() {
        return "AttemptedOutboundTargetParcel(target=" + this.target + ", count=" + this.count + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        this.target.writeToParcel(r3, r4);
        r3.writeLong(this.count);
    }

    public AttemptedOutboundTargetParcel(OutboundTargetParcel r2, long r3) {
        o.e(r2, "target");
        this.target = r2;
        this.count = r3;
    }

    public final OutboundTargetParcel getTarget() {
        return this.target;
    }

    public final long getCount() {
        return this.count;
    }
}
