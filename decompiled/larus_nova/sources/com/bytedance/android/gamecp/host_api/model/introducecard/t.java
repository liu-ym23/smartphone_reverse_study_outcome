package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes44.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.im.IntroduceCardDisplayInfo")
public final class t extends s {
    public t(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.displayDuration = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.timerCardSwitchOpen = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.timerSpan = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.timerLoopCnt = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
