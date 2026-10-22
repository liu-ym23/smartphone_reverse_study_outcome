package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PersistentAwarenessModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PersistentAwarenessRegisterRequest implements Parcelable {
    public static final Parcelable.Creator<PersistentAwarenessRegisterRequest> CREATOR = null;
    private final AwarenessConditionConfig condition;
    private final String subscriptionId;
    private final AwarenessTarget target;

    /* JADX INFO: compiled from: PersistentAwarenessModels.kt */
    public static final class Creator implements Parcelable.Creator<PersistentAwarenessRegisterRequest> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PersistentAwarenessRegisterRequest createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            return new PersistentAwarenessRegisterRequest(r5.readString(), (AwarenessTarget) ZeusTransformUtils.preCheckCast(AwarenessTarget.CREATOR.createFromParcel(r5), AwarenessTarget.class, "com.obric.aiagent.plugin"), (AwarenessConditionConfig) ZeusTransformUtils.preCheckCast(AwarenessConditionConfig.CREATOR.createFromParcel(r5), AwarenessConditionConfig.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PersistentAwarenessRegisterRequest createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PersistentAwarenessRegisterRequest[] newArray(int r1) {
            return new PersistentAwarenessRegisterRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PersistentAwarenessRegisterRequest[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ PersistentAwarenessRegisterRequest copy$default(PersistentAwarenessRegisterRequest r0, String r1, AwarenessTarget r2, AwarenessConditionConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.subscriptionId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.target;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.condition;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.subscriptionId;
    }

    public final AwarenessTarget component2() {
        return this.target;
    }

    public final AwarenessConditionConfig component3() {
        return this.condition;
    }

    public final PersistentAwarenessRegisterRequest copy(String r1, AwarenessTarget r2, AwarenessConditionConfig r3) {
        o.e(r1, "subscriptionId");
        o.e(r2, "target");
        o.e(r3, "condition");
        return new PersistentAwarenessRegisterRequest(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PersistentAwarenessRegisterRequest.class) == true) goto L8;
        return false;
    L8:
        PersistentAwarenessRegisterRequest r6 = (PersistentAwarenessRegisterRequest) ZeusTransformUtils.preCheckCast(r5, PersistentAwarenessRegisterRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.subscriptionId, r6.subscriptionId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.target, r6.target) == true) goto L15;
        return false;
    L15:
        if (o.a(this.condition, r6.condition) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.subscriptionId.hashCode() * 31) + this.target.hashCode()) * 31) + this.condition.hashCode();
    }

    public String toString() {
        return "PersistentAwarenessRegisterRequest(subscriptionId=" + this.subscriptionId + ", target=" + this.target + ", condition=" + this.condition + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "dest");
        r2.writeString(this.subscriptionId);
        this.target.writeToParcel(r2, r3);
        this.condition.writeToParcel(r2, r3);
    }

    public PersistentAwarenessRegisterRequest(String r2, AwarenessTarget r3, AwarenessConditionConfig r4) {
        o.e(r2, "subscriptionId");
        o.e(r3, "target");
        o.e(r4, "condition");
        this.subscriptionId = r2;
        this.target = r3;
        this.condition = r4;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final AwarenessTarget getTarget() {
        return this.target;
    }

    public /* synthetic */ PersistentAwarenessRegisterRequest(String r1, AwarenessTarget r2, AwarenessConditionConfig r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AwarenessConditionConfig.Companion.a();
    L5:
        this(r1, r2, r3);
    }

    public final AwarenessConditionConfig getCondition() {
        return this.condition;
    }
}
