package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements am3.c<ECV2AuthorOrderLimitInfo> {
    public f() {
    }

    public static ECV2AuthorOrderLimitInfo a(am3.g r100) throws Exception {
        ECV2AuthorOrderLimitInfo r101 = new ECV2AuthorOrderLimitInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.icon = e.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.title = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.content = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.button = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2AuthorOrderLimitInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
