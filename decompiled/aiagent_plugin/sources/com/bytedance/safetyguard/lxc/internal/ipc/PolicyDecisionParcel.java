package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PolicyDecisionParcel implements Parcelable {
    public static final Parcelable.Creator<PolicyDecisionParcel> CREATOR = null;
    private final int decision;
    private final int protocolVersion;
    private final String reason;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<PolicyDecisionParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PolicyDecisionParcel createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            return new PolicyDecisionParcel(r3.readInt(), r3.readInt(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PolicyDecisionParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PolicyDecisionParcel[] newArray(int r1) {
            return new PolicyDecisionParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PolicyDecisionParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ PolicyDecisionParcel copy$default(PolicyDecisionParcel r0, int r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.protocolVersion;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.decision;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.reason;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final int component2() {
        return this.decision;
    }

    public final String component3() {
        return this.reason;
    }

    public final PolicyDecisionParcel copy(int r1, int r2, String r3) {
        return new PolicyDecisionParcel(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PolicyDecisionParcel.class) == true) goto L8;
        return false;
    L8:
        PolicyDecisionParcel r6 = (PolicyDecisionParcel) ZeusTransformUtils.preCheckCast(r5, PolicyDecisionParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r6.protocolVersion) goto L12;
        return false;
    L12:
        if (this.decision == r6.decision) goto L15;
        return false;
    L15:
        if (o.a(this.reason, r6.reason) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.protocolVersion) * 31) + Integer.hashCode(this.decision)) * 31;
        String r2 = this.reason;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "PolicyDecisionParcel(protocolVersion=" + this.protocolVersion + ", decision=" + this.decision + ", reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "out");
        r1.writeInt(this.protocolVersion);
        r1.writeInt(this.decision);
        r1.writeString(this.reason);
    }

    public PolicyDecisionParcel(int r1, int r2, String r3) {
        this.protocolVersion = r1;
        this.decision = r2;
        this.reason = r3;
    }

    public /* synthetic */ PolicyDecisionParcel(int r1, int r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 3;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final int getDecision() {
        return this.decision;
    }

    public final String getReason() {
        return this.reason;
    }
}
