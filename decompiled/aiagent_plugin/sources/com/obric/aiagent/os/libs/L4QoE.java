package com.obric.aiagent.os.libs;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class L4QoE {

    @SerializedName("l4NetStats")
    private final String l4NetStats;

    @SerializedName(DBHelper.COL_TIME)
    private final Long timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public L4QoE() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ L4QoE copy$default(L4QoE r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.l4NetStats;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.timestamp;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.l4NetStats;
    }

    public final Long component2() {
        return this.timestamp;
    }

    public final L4QoE copy(String r1, Long r2) {
        return new L4QoE(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, L4QoE.class) == true) goto L8;
        return false;
    L8:
        L4QoE r6 = (L4QoE) ZeusTransformUtils.preCheckCast(r5, L4QoE.class, "com.obric.aiagent.plugin");
        if (o.a(this.l4NetStats, r6.l4NetStats) == true) goto L12;
        return false;
    L12:
        if (o.a(this.timestamp, r6.timestamp) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.l4NetStats;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.timestamp;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "L4QoE(l4NetStats=" + this.l4NetStats + ", timestamp=" + this.timestamp + ')';
    }

    public L4QoE(String r1, Long r2) {
        this.l4NetStats = r1;
        this.timestamp = r2;
    }

    public /* synthetic */ L4QoE(String r2, Long r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getL4NetStats() {
        return this.l4NetStats;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
