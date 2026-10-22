package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements am3.c<a> {
    public d0() {
    }

    public static a a(am3.g r100) throws Exception {
        a r101 = new a();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        switch(r103) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        r101.array_node = e0.a(r100);
        goto L3
    L8:
        r101.map_node = r0.a(r100);
        goto L3
    L9:
        r101.pairNode = s0.a(r100);
        goto L3
    L10:
        r101.conditionNode = j0.a(r100);
        goto L3
    L11:
        r101.identifierNode = o0.a(r100);
        goto L3
    L12:
        r101.callNode = i0.a(r100);
        goto L3
    L13:
        r101.unaryNode = z0.a(r100);
        goto L3
    L14:
        r101.binaryNode = g0.a(r100);
        goto L3
    L15:
        r101.stringNode = y0.a(r100);
        goto L3
    L16:
        r101.doubleNode = l0.a(r100);
        goto L3
    L17:
        r101.longNode = q0.a(r100);
        goto L3
    L18:
        r101.boolNode = h0.a(r100);
        goto L3
    L19:
        r101.nodeType = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final a decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
