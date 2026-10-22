package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class b0 implements am3.c<InputFunctionList> {
    public b0() {
    }

    public static InputFunctionList a(am3.g r100) throws Exception {
        InputFunctionList r101 = new InputFunctionList();
        r101.list = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.list.add(c0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final InputFunctionList decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
