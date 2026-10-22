package com.obric.aiagent.os.libs;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkInfo {

    @SerializedName("capability")
    private final NetworkCapability capability;

    @SerializedName("capabilityType")
    private final String capabilityType;

    @SerializedName("netId")
    private final String netId;

    public NetworkInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NetworkInfo copy$default(NetworkInfo r0, String r1, String r2, NetworkCapability r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.netId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.capabilityType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.capability;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.netId;
    }

    public final String component2() {
        return this.capabilityType;
    }

    public final NetworkCapability component3() {
        return this.capability;
    }

    public final NetworkInfo copy(String r1, String r2, NetworkCapability r3) {
        return new NetworkInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetworkInfo.class) == true) goto L8;
        return false;
    L8:
        NetworkInfo r6 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r5, NetworkInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.netId, r6.netId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.capabilityType, r6.capabilityType) == true) goto L15;
        return false;
    L15:
        if (o.a(this.capability, r6.capability) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.netId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.capabilityType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NetworkCapability r7 = this.capability;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkInfo(netId=" + this.netId + ", capabilityType=" + this.capabilityType + ", capability=" + this.capability + ')';
    }

    public NetworkInfo(String r1, String r2, NetworkCapability r3) {
        this.netId = r1;
        this.capabilityType = r2;
        this.capability = r3;
    }

    public /* synthetic */ NetworkInfo(String r2, String r3, NetworkCapability r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getNetId() {
        return this.netId;
    }

    public final String getCapabilityType() {
        return this.capabilityType;
    }

    public final NetworkCapability getCapability() {
        return this.capability;
    }
}
