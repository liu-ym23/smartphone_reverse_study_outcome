package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.message.a5;

/* JADX INFO: loaded from: classes7.dex */
public final class c4 implements am3.c<m> {
    public c4() {
    }

    public static m a(am3.g r100) throws Exception {
        m r101 = new m();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.title = (a5) vh7.f.a(r100, a5.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.image = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.enabled = am3.h.a(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.backgroundColor = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final m decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
