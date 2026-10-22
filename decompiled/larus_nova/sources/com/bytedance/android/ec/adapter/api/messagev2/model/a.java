package com.bytedance.android.ec.adapter.api.messagev2.model;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements c<TraceTimeMetricV2> {
    public a() {
    }

    public static TraceTimeMetricV2 a(g r100) throws Exception {
        TraceTimeMetricV2 r101 = new TraceTimeMetricV2();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.opTimestamp = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.producerDuration = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.consumerDuration = r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.msgSendTimestamp = r100.j();
        goto L3
    L13:
        h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final TraceTimeMetricV2 decode(g r100) throws Exception {
        return a(r100);
    }
}
