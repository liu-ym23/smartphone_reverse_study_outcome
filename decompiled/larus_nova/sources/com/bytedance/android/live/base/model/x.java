package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements am3.c<ImageModel> {
    public x() {
    }

    public static ImageModel a(am3.g r100) throws Exception {
        ImageModel r101 = new ImageModel();
        r101.setThreadSafe(false);
        r101.mUrls = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        r101.isAnimated = am3.h.a(r100);
        goto L3
    L9:
        r101.content = (ImageModel.Content) vh7.f.a(r100, ImageModel.Content.class);
        goto L3
    L10:
        r101.schema = am3.h.c(r100);
        goto L3
    L11:
        r101.imageType = r100.i();
        goto L3
    L12:
        r101.avgColor = am3.h.c(r100);
        goto L3
    L13:
        r101.width = (int) r100.j();
        goto L3
    L14:
        r101.height = (int) r100.j();
        goto L3
    L15:
        r101.mUri = am3.h.c(r100);
        goto L3
    L16:
        r101.mUrls.add(am3.h.c(r100));
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L17:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final ImageModel decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
