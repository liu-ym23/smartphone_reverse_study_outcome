package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class v implements am3.c<ECV2InteractionData.ListTopInteractionRow> {
    public v() {
    }

    public static ECV2InteractionData.ListTopInteractionRow a(am3.g r100) throws Exception {
        ECV2InteractionData.ListTopInteractionRow r101 = new ECV2InteractionData.ListTopInteractionRow();
        r101.content = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.content.add(s.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.ListTopInteractionRow decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
