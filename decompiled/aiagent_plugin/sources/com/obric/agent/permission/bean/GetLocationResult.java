package com.obric.agent.permission.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GetLocationResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GetLocationResult {
    private final Double latitude;
    private final Double longitude;

    /* JADX WARN: Multi-variable type inference failed */
    public GetLocationResult() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GetLocationResult copy$default(GetLocationResult r0, Double r1, Double r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.longitude;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.latitude;
    L9:
        return r0.copy(r1, r2);
    }

    public final Double component1() {
        return this.longitude;
    }

    public final Double component2() {
        return this.latitude;
    }

    public final GetLocationResult copy(Double r1, Double r2) {
        return new GetLocationResult(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GetLocationResult.class) == true) goto L8;
        return false;
    L8:
        GetLocationResult r6 = (GetLocationResult) ZeusTransformUtils.preCheckCast(r5, GetLocationResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.longitude, r6.longitude) == true) goto L12;
        return false;
    L12:
        if (o.a(this.latitude, r6.latitude) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Double r0 = this.longitude;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.latitude;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetLocationResult(longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    public GetLocationResult(Double r1, Double r2) {
        this.longitude = r1;
        this.latitude = r2;
    }

    public /* synthetic */ GetLocationResult(Double r2, Double r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Double getLatitude() {
        return this.latitude;
    }
}
