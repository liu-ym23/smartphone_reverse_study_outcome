package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class p implements am3.c<ECV2InteractionData.InteractionAvatar> {
    public p() {
    }

    public static ECV2InteractionData.InteractionAvatar a(am3.g r100) throws Exception {
        ECV2InteractionData.InteractionAvatar r101 = new ECV2InteractionData.InteractionAvatar();
        r101.urlList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.urlList.add(am3.h.c(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.width = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.height = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.InteractionAvatar decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
