package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.UserGiftStatus")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItem;", "", "()V", "focusIndex", "", "gameId", "", "hint", "loginDays", "playId", "title", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GameUserGiftStatusItem implements h {

    @SerializedName("focus_index")
    public long focusIndex;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("hint")
    public String hint;

    @SerializedName("login_days")
    public long loginDays;

    @SerializedName(InstantPlayContext.PLAY_ID)
    public String playId;

    @SerializedName("title")
    public String title;

    public GameUserGiftStatusItem() {
        this.playId = "";
        this.gameId = "";
        this.hint = "";
        this.title = "";
    }

    public GameUserGiftStatusItem(g r100) {
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
        this.title = am3.h.c(r100);
        goto L3
    L10:
        this.hint = am3.h.c(r100);
        goto L3
    L11:
        this.gameId = am3.h.c(r100);
        goto L3
    L12:
        this.playId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
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
