package com.bytedance.android.livehostapi.foundation.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/TTNetNetworkQuality;", "", "httpRtt", "", "transportRtt", "downstreamThroughput", "(III)V", "getDownstreamThroughput", "()I", "getHttpRtt", "getTransportRtt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TTNetNetworkQuality {
    private final int downstreamThroughput;
    private final int httpRtt;
    private final int transportRtt;

    public TTNetNetworkQuality() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ TTNetNetworkQuality copy$default(TTNetNetworkQuality r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.httpRtt;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.transportRtt;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.downstreamThroughput;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.httpRtt;
    }

    public final int component2() {
        return this.transportRtt;
    }

    public final int component3() {
        return this.downstreamThroughput;
    }

    public final TTNetNetworkQuality copy(int r100, int r101, int r102) {
        return new TTNetNetworkQuality(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TTNetNetworkQuality) == false) goto L12;
        TTNetNetworkQuality r101 = (TTNetNetworkQuality) r100;
        if (this.httpRtt == r101.httpRtt) goto L8;
        return false;
    L8:
        if (this.transportRtt == r101.transportRtt) goto L10;
        return false;
    L10:
        if (this.downstreamThroughput == r101.downstreamThroughput) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (((this.httpRtt * 31) + this.transportRtt) * 31) + this.downstreamThroughput;
    }

    public String toString() {
        return "TTNetNetworkQuality(httpRtt=" + this.httpRtt + ", transportRtt=" + this.transportRtt + ", downstreamThroughput=" + this.downstreamThroughput + ")";
    }

    public final int getDownstreamThroughput() {
        return this.downstreamThroughput;
    }

    public final int getHttpRtt() {
        return this.httpRtt;
    }

    public final int getTransportRtt() {
        return this.transportRtt;
    }

    public TTNetNetworkQuality(int r100, int r101, int r102) {
        this.httpRtt = r100;
        this.transportRtt = r101;
        this.downstreamThroughput = r102;
    }

    public /* synthetic */ TTNetNetworkQuality(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = -1;
    L11:
        this(r100, r101, r102);
    }
}
