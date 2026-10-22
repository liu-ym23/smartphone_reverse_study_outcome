package com.android.server.stats.pull.netstats;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class SubInfo {
    public final int carrierId;
    public final boolean isOpportunistic;
    public final String mcc;
    public final String mnc;
    public final int subId;
    public final String subscriberId;

    public SubInfo(int subId, int carrierId, String mcc, String mnc, String subscriberId, boolean isOpportunistic) {
        this.subId = subId;
        this.carrierId = carrierId;
        this.mcc = mcc;
        this.mnc = mnc;
        this.subscriberId = subscriberId;
        this.isOpportunistic = isOpportunistic;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L25;
        SubInfo other = (SubInfo) o;
        if (this.subId != other.subId) goto L24;
        if (this.carrierId != other.carrierId) goto L24;
        if (this.isOpportunistic != other.isOpportunistic) goto L24;
        if (this.mcc.equals(other.mcc) == false) goto L24;
        if (this.mnc.equals(other.mnc) == false) goto L24;
        if (this.subscriberId.equals(other.subscriberId) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.subId), this.mcc, this.mnc, Integer.valueOf(this.carrierId), this.subscriberId, Boolean.valueOf(this.isOpportunistic)});
    }
}
