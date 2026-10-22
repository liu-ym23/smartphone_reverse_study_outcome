package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/jsbridge/a;", "", "", "propDefId", "J", "c", "()J", "", "giftCount", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "giftSource", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("giftCount")
    private final int giftCount;

    @SerializedName("giftSource")
    private final String giftSource;

    @SerializedName("propDefId")
    private final long propDefId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.propDefId == r101.propDefId) goto L8;
        return false;
    L8:
        if (this.giftCount == r101.giftCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.giftSource, r101.giftSource) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.propDefId;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.giftCount) * 31;
        String r102 = this.giftSource;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "PropFromRedPacketLynx(propDefId=" + this.propDefId + ", giftCount=" + this.giftCount + ", giftSource=" + this.giftSource + ")";
    }

    public final int a() {
        return this.giftCount;
    }

    public final String b() {
        return this.giftSource;
    }

    public final long c() {
        return this.propDefId;
    }
}
