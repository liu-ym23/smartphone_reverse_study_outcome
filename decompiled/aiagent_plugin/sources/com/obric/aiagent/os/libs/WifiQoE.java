package com.obric.aiagent.os.libs;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WifiQoE {

    @SerializedName("band")
    private final Integer band;

    @SerializedName("rxThroughput")
    private final Integer rxThroughput;

    @SerializedName(DBHelper.COL_TIME)
    private final Long timestamp;

    @SerializedName("txThroughput")
    private final Integer txThroughput;

    public WifiQoE() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ WifiQoE copy$default(WifiQoE r0, Integer r1, Integer r2, Integer r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.band;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.rxThroughput;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.txThroughput;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.timestamp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.band;
    }

    public final Integer component2() {
        return this.rxThroughput;
    }

    public final Integer component3() {
        return this.txThroughput;
    }

    public final Long component4() {
        return this.timestamp;
    }

    public final WifiQoE copy(Integer r1, Integer r2, Integer r3, Long r4) {
        return new WifiQoE(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, WifiQoE.class) == true) goto L8;
        return false;
    L8:
        WifiQoE r6 = (WifiQoE) ZeusTransformUtils.preCheckCast(r5, WifiQoE.class, "com.obric.aiagent.plugin");
        if (o.a(this.band, r6.band) == true) goto L12;
        return false;
    L12:
        if (o.a(this.rxThroughput, r6.rxThroughput) == true) goto L15;
        return false;
    L15:
        if (o.a(this.txThroughput, r6.txThroughput) == true) goto L18;
        return false;
    L18:
        if (o.a(this.timestamp, r6.timestamp) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.band;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.rxThroughput;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.txThroughput;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.timestamp;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "WifiQoE(band=" + this.band + ", rxThroughput=" + this.rxThroughput + ", txThroughput=" + this.txThroughput + ", timestamp=" + this.timestamp + ')';
    }

    public WifiQoE(Integer r1, Integer r2, Integer r3, Long r4) {
        this.band = r1;
        this.rxThroughput = r2;
        this.txThroughput = r3;
        this.timestamp = r4;
    }

    public /* synthetic */ WifiQoE(Integer r2, Integer r3, Integer r4, Long r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final Integer getBand() {
        return this.band;
    }

    public final Integer getRxThroughput() {
        return this.rxThroughput;
    }

    public final Integer getTxThroughput() {
        return this.txThroughput;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
