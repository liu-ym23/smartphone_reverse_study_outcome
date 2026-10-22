package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements am3.c<ECV2InteractionData.ElementText> {
    public o() {
    }

    public static ECV2InteractionData.ElementText a(am3.g r100) throws Exception {
        ECV2InteractionData.ElementText r101 = new ECV2InteractionData.ElementText();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r101.ellipsis = am3.h.a(r100);
        goto L3
    L8:
        r101.maxWidth = r100.j();
        goto L3
    L9:
        r101.image = z.a(r100);
        goto L3
    L10:
        r101.bold = am3.h.a(r100);
        goto L3
    L11:
        r101.size = Long.valueOf(r100.j());
        goto L3
    L12:
        r101.color = am3.h.c(r100);
        goto L3
    L13:
        r101.text = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.ElementText decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
