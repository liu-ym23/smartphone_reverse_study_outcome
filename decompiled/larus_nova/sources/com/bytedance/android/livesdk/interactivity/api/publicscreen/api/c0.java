package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 implements am3.c<InputFunction> {
    public c0() {
    }

    public static InputFunction a(am3.g r100) throws Exception {
        InputFunction r101 = new InputFunction();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.functionId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.type = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.priority = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final InputFunction decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
