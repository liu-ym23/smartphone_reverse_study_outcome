package com.bytedance.android.livesdk.message.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class qo implements am3.c<RoomNotifyMessageExtra.Background> {
    public qo() {
    }

    public static RoomNotifyMessageExtra.Background a(am3.g r100) throws Exception {
        RoomNotifyMessageExtra.Background r101 = new RoomNotifyMessageExtra.Background();
        r101.mUrls = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.width = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.height = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.mUrls.add(am3.h.c(r100));
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.mUri = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final RoomNotifyMessageExtra.Background decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
