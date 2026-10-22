package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements am3.c<ECV2InteractionData.ElementLoopText> {
    public n() {
    }

    public static ECV2InteractionData.ElementLoopText a(am3.g r100) throws Exception {
        ECV2InteractionData.ElementLoopText r101 = new ECV2InteractionData.ElementLoopText();
        r101.loopText = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.loopText.add(am3.h.c(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.textColor = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.textSize = (int) r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.bold = am3.h.a(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.animGap = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.ElementLoopText decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
