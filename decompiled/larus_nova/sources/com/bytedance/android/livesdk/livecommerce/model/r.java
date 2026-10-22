package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class r implements am3.c<ECV2InteractionData.InteractionContent> {
    public r() {
    }

    public static ECV2InteractionData.InteractionContent a(am3.g r110) throws Exception {
        ECV2InteractionData.InteractionContent r100 = new ECV2InteractionData.InteractionContent();
        r100.bgColors = new ArrayList();
        r100.eventParam = new HashMap();
        r100.rows = new ArrayList();
        r100.content = new ArrayList();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L33;
        switch(r102) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        r100.action = u.a(r110);
        goto L3
    L8:
        r100.product = w.a(r110);
        goto L3
    L9:
        r100.bgColors.add(am3.h.c(r110));
        goto L3
    L10:
        r100.rows.add(v.a(r110));
        goto L3
    L11:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L12:
        int r106 = r110.f();
        if (r106 == (-1)) goto L21;
        if (r106 != 1) goto L17;
        r104 = am3.h.c(r110);
        goto L12
    L17:
        if (r106 != 2) goto L12;
        r105 = am3.h.c(r110);
        goto L12
    L21:
        r110.d(r103);
        if (r104 == null) goto L28;
        if (r105 == null) goto L26;
        r100.eventParam.put(r104, r105);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L29:
        r100.content.add(s.a(r110));
        goto L3
    L30:
        r100.loopCount = r110.i();
        goto L3
    L31:
        r100.priority = r110.i();
        goto L3
    L32:
        r100.check = q.a(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final ECV2InteractionData.InteractionContent decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
