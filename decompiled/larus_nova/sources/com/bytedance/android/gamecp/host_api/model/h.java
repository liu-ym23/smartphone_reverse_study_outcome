package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.MiniPlayMeta")
public final class h extends g {
    public h(am3.g r100) {
        this._supportLiveScene = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.extra = am3.h.c(r100);
        goto L3
    L8:
        this.developer = am3.h.c(r100);
        goto L3
    L9:
        this.gameType = r100.i();
        goto L3
    L10:
        this.version = am3.h.c(r100);
        goto L3
    L11:
        this._supportLiveScene.add(Long.valueOf(r100.j()));
        goto L3
    L12:
        this.appId = am3.h.c(r100);
        goto L3
    L13:
        this.gameId = am3.h.c(r100);
        goto L3
    L14:
        this.icon = am3.h.c(r100);
        goto L3
    L15:
        this.gameName = am3.h.c(r100);
        goto L3
    L16:
        this.schema = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
    }
}
