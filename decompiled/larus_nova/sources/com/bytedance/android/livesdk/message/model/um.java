package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.gamecp.api.UserIntroduceCardStatus")
public final class um extends tm {
    public um() {
        this.introDuration = 60;
        this.timerSpan = 100;
        this.timerLoopCnt = -1;
    }

    public um(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L8;
        this.enableTimerCard = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.introDuration = r100.j();
        r102 = r102 | 1;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this.timerSpan = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.timerLoopCnt = r100.j();
        r102 = r102 | 4;
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L21;
        this.introDuration = 60;
    L21:
        if ((r102 & 2) != 0) goto L24;
        this.timerSpan = 100;
    L24:
        if ((r102 & 4) != 0) goto L42;
        this.timerLoopCnt = -1;
        return;
    }
}
