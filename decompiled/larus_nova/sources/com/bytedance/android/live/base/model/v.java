package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements am3.c<FlexImageModel> {
    public v() {
    }

    public static FlexImageModel a(am3.g r100) throws Exception {
        FlexImageModel r101 = new FlexImageModel();
        r101.mUrls = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.mUrls.add(am3.h.c(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.mUri = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 5) goto L11;
        r101.topBorderHeight = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final FlexImageModel decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
