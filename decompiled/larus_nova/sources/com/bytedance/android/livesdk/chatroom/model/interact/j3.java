package com.bytedance.android.livesdk.chatroom.model.interact;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class j3 implements am3.c<y2> {
    public j3() {
    }

    @Override // am3.c
    public final y2 decode(am3.g r100) throws Exception {
        y2 r101 = new y2();
        r101.durationList = new ArrayList();
        r101.scoreListInfo = new ArrayList();
        r101.scoreList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.durationList.add(Long.valueOf(r100.j()));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.fallbackDelay = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.scoreList.add(Integer.valueOf(r100.i()));
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.scoreListInfo.add(k3.a(r100));
        goto L3
    L14:
        if (r103 != 6) goto L15;
        r101.customTeamConfig = (w1) vh7.f.a(r100, w1.class);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }
}
