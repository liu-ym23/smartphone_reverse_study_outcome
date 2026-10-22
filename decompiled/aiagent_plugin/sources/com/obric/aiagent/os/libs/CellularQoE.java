package com.obric.aiagent.os.libs;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CellularQoE {

    @SerializedName("errBitMap")
    private final Long errBitMap;

    @SerializedName("slotId")
    private final Integer slotId;

    @SerializedName(DBHelper.COL_TIME)
    private final Long timestamp;

    public CellularQoE() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CellularQoE copy$default(CellularQoE r0, Integer r1, Long r2, Long r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.slotId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.errBitMap;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.timestamp;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.slotId;
    }

    public final Long component2() {
        return this.errBitMap;
    }

    public final Long component3() {
        return this.timestamp;
    }

    public final CellularQoE copy(Integer r1, Long r2, Long r3) {
        return new CellularQoE(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CellularQoE.class) == true) goto L8;
        return false;
    L8:
        CellularQoE r6 = (CellularQoE) ZeusTransformUtils.preCheckCast(r5, CellularQoE.class, "com.obric.aiagent.plugin");
        if (o.a(this.slotId, r6.slotId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.errBitMap, r6.errBitMap) == true) goto L15;
        return false;
    L15:
        if (o.a(this.timestamp, r6.timestamp) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.slotId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.errBitMap;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.timestamp;
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
        return "CellularQoE(slotId=" + this.slotId + ", errBitMap=" + this.errBitMap + ", timestamp=" + this.timestamp + ')';
    }

    public CellularQoE(Integer r1, Long r2, Long r3) {
        this.slotId = r1;
        this.errBitMap = r2;
        this.timestamp = r3;
    }

    public /* synthetic */ CellularQoE(Integer r2, Long r3, Long r4, int r5, h r6) {
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

    public final Integer getSlotId() {
        return this.slotId;
    }

    public final Long getErrBitMap() {
        return this.errBitMap;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
