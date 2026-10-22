package com.bytedance.android.ec.adapter.impl.messagev2;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements c<a> {
    public b() {
    }

    @Override // am3.c
    public final a decode(g r100) throws Exception {
        a r101 = new a();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r101.content = h.b(r100);
        goto L3
    L8:
        r101.traceTimeMetric = com.bytedance.android.ec.adapter.api.messagev2.model.a.a(r100);
        goto L3
    L9:
        r101.logicClock = r100.j();
        goto L3
    L10:
        r101.contentFormat = h.c(r100);
        goto L3
    L11:
        r101.contentType = h.c(r100);
        goto L3
    L12:
        r101.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L13:
        r100.d(r102);
        return r101;
    }
}
