package com.bytedance.android.livesdk.message.model;

import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class ro implements am3.c<RoomNotifyMessageExtra> {
    public ro() {
    }

    public static RoomNotifyMessageExtra a(am3.g r110) throws Exception {
        RoomNotifyMessageExtra r100 = new RoomNotifyMessageExtra();
        r100.params = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L36;
        if (r102 != 1) goto L8;
        r100.duration = r110.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        r100.background = qo.a(r110);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        r100.highlightInfo = new qg(r110);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L18:
        int r111 = r110.f();
        if (r111 == (-1)) goto L25;
        if (r111 != 1) goto L21;
        r104 = am3.h.c(r110);
        goto L18
    L21:
        if (r111 != 2) goto L18;
        r105 = am3.h.c(r110);
        goto L18
    L25:
        r110.d(r103);
        if (r104 == null) goto L32;
        if (r105 == null) goto L30;
        r100.params.put(r104, r105);
        goto L3
    L30:
        throw new IllegalStateException("Map value must not be null!");
    L32:
        throw new IllegalStateException("Map key must not be null!");
    L14:
        if (r102 != 6) goto L15;
        r100.needGiftCarnivalFrequency = am3.h.a(r110);
        goto L3
    L15:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final RoomNotifyMessageExtra decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
