package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements am3.c<ECV2InteractionData.ElementImageBubble> {
    public l() {
    }

    public static ECV2InteractionData.ElementImageBubble a(am3.g r100) throws Exception {
        ECV2InteractionData.ElementImageBubble r101 = new ECV2InteractionData.ElementImageBubble();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        r101.horizontalPadding = r100.j();
        goto L3
    L8:
        r101.color = am3.h.c(r100);
        goto L3
    L9:
        r101.fontSize = r100.j();
        goto L3
    L10:
        r101.text = am3.h.c(r100);
        goto L3
    L11:
        r101.borderColor = am3.h.c(r100);
        goto L3
    L12:
        r101.backgroundColor = am3.h.c(r100);
        goto L3
    L13:
        r101.borderRadius = r100.j();
        goto L3
    L14:
        r101.height = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.ElementImageBubble decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
