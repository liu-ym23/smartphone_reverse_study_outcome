package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;

/* JADX INFO: loaded from: classes9.dex */
@IgnoreProtoFieldCheck
public final class i0 extends GiftMsgBoard {
    public i0() {
        this.promptText = "";
    }

    public i0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.forMsgBoard = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.promptText = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.promptText != null) goto L25;
        this.promptText = "";
        return;
    }
}
