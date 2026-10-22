package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class m0 implements am3.c<n> {
    public m0() {
    }

    public static n a(am3.g r110) throws Exception {
        n r100 = new n();
        r100.booleanArrayVal = new ArrayList();
        r100.longArrayVal = new ArrayList();
        r100.stringArrayVal = new ArrayList();
        r100.mapVal = new HashMap();
        r100.doubleArrayVal = new ArrayList();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L34;
        switch(r102) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        r100.doubleArrayVal.add(Double.valueOf(Double.longBitsToDouble(r110.h())));
        goto L3
    L8:
        r100.booleanArrayVal.add(Boolean.valueOf(am3.h.a(r110)));
        goto L3
    L9:
        r100.stringArrayVal.add(am3.h.c(r110));
        goto L3
    L10:
        r100.longArrayVal.add(Long.valueOf(r110.j()));
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
        r100.mapVal.put(r104, r105);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L29:
        r100.stringVal = am3.h.c(r110);
        goto L3
    L30:
        r100.float64Val = Double.longBitsToDouble(r110.h());
        goto L3
    L31:
        r100.boolVal = am3.h.a(r110);
        goto L3
    L32:
        r100.int64Val = r110.j();
        goto L3
    L33:
        r100.valType = r110.i();
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L34:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final n decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
