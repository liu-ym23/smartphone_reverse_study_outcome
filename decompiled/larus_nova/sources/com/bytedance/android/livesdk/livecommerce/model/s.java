package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements am3.c<ECV2InteractionData.InteractionElement> {
    public s() {
    }

    public static ECV2InteractionData.InteractionElement a(am3.g r100) throws Exception {
        ECV2InteractionData.InteractionElement r101 = new ECV2InteractionData.InteractionElement();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L28;
        if (r103 != 20) goto L8;
        r101.elementTextV2 = o.a(r100);
        goto L3
    L8:
        if (r103 != 21) goto L10;
        r101.elementBlank = k.a(r100);
        goto L3
    L10:
        if (r103 != 23) goto L12;
        r101.elementAvatar = j.a(r100);
        goto L3
    L12:
        if (r103 != 24) goto L14;
        r101.elementImage = m.a(r100);
        goto L3
    L14:
        if (r103 != 29) goto L15;
        r101.elementLoopText = n.a(r100);
        goto L3
    L15:
        switch(r103) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L16;
        };
    L17:
        r101.textSize = Integer.valueOf(r100.i());
        goto L3
    L18:
        r101.blankWidth = r100.i();
        goto L3
    L19:
        r101.avatars = p.a(r100);
        goto L3
    L20:
        r101.textColor = am3.h.c(r100);
        goto L3
    L21:
        r101.text = am3.h.c(r100);
        goto L3
    L22:
        r101.elementType = r100.i();
        goto L3
    L16:
        am3.h.e(r100);
        goto L3
    L28:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.InteractionElement decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
