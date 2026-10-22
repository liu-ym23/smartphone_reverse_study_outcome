package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InfoBoxMessageBackGround")
public final class lc extends InfoBoxBackGround {
    public lc(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.backgroundAlpha = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.backgroundColor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.backgroundImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.backgroundAlpha != null) goto L19;
        this.backgroundAlpha = 1L;
    L19:
        if (this.backgroundColor != null) goto L34;
        this.backgroundColor = "";
        return;
    }
}
