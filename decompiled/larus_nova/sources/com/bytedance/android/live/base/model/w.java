package com.bytedance.android.live.base.model;

/* JADX INFO: loaded from: classes45.dex */
public final class w implements am3.c<ImageModel.Content> {
    public w() {
    }

    @Override // am3.c
    public final ImageModel.Content decode(am3.g r100) throws Exception {
        ImageModel.Content r101 = new ImageModel.Content();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.name = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.fontColor = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.level = r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.accessibilityText = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
