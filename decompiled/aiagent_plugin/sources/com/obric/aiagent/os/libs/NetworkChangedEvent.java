package com.obric.aiagent.os.libs;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkChangedEvent {

    @SerializedName("networkInfo")
    private final NetworkInfo networkInfo;

    @SerializedName(DBHelper.COL_TIME)
    private final Long timestamp;

    @SerializedName("type")
    private final Integer type;

    public NetworkChangedEvent() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NetworkChangedEvent copy$default(NetworkChangedEvent r0, Integer r1, Long r2, NetworkInfo r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.timestamp;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.networkInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.type;
    }

    public final Long component2() {
        return this.timestamp;
    }

    public final NetworkInfo component3() {
        return this.networkInfo;
    }

    public final NetworkChangedEvent copy(Integer r1, Long r2, NetworkInfo r3) {
        return new NetworkChangedEvent(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetworkChangedEvent.class) == true) goto L8;
        return false;
    L8:
        NetworkChangedEvent r6 = (NetworkChangedEvent) ZeusTransformUtils.preCheckCast(r5, NetworkChangedEvent.class, "com.obric.aiagent.plugin");
        if (o.a(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (o.a(this.timestamp, r6.timestamp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.networkInfo, r6.networkInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.timestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NetworkInfo r7 = this.networkInfo;
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
        return "NetworkChangedEvent(type=" + this.type + ", timestamp=" + this.timestamp + ", networkInfo=" + this.networkInfo + ')';
    }

    public NetworkChangedEvent(Integer r1, Long r2, NetworkInfo r3) {
        this.type = r1;
        this.timestamp = r2;
        this.networkInfo = r3;
    }

    public /* synthetic */ NetworkChangedEvent(Integer r2, Long r3, NetworkInfo r4, int r5, h r6) {
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

    public final Integer getType() {
        return this.type;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }
}
