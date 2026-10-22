package com.bytedance.android.livesdkapi.model;

import am3.g;
import am3.h;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.UserGiftStatus")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItemIm;", "Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItem;", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameUserGiftStatusItemIm extends GameUserGiftStatusItem {
    public GameUserGiftStatusItemIm() {
        this.playId = "";
        this.gameId = "";
        this.hint = "";
        this.title = "";
    }

    public GameUserGiftStatusItemIm(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.loginDays = r100.i();
        goto L3
    L8:
        this.focusIndex = r100.i();
        goto L3
    L9:
        this.title = h.c(r100);
        goto L3
    L10:
        this.hint = h.c(r100);
        goto L3
    L11:
        this.gameId = h.c(r100);
        goto L3
    L12:
        this.playId = h.c(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.playId != null) goto L17;
        this.playId = "";
    L17:
        if (this.gameId != null) goto L20;
        this.gameId = "";
    L20:
        if (this.hint != null) goto L23;
        this.hint = "";
    L23:
        if (this.title != null) goto L42;
        this.title = "";
        return;
    }
}
