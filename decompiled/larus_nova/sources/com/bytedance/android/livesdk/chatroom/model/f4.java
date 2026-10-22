package com.bytedance.android.livesdk.chatroom.model;

/* JADX INFO: loaded from: classes7.dex */
public final class f4 implements am3.c<f3> {
    public f4() {
    }

    public static f3 a(am3.g r100) throws Exception {
        f3 r101 = new f3();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.interactType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.title = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.desc = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.icon = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final f3 decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
