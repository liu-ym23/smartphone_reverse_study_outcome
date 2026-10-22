package com.bytedance.android.livesdk.chatroom.model.interact;

/* JADX INFO: loaded from: classes7.dex */
public final class k3 implements am3.c<y2.a> {
    public k3() {
    }

    public static y2.a a(am3.g r100) throws Exception {
        y2.a r101 = new y2.a();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.type = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.title = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.intro = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final y2.a decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
