package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.UserGiftStatus")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/n;", "", "", "playId", "Ljava/lang/String;", "gameId", "hint", "title", "", "loginDays", "I", "focusIndex", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class n implements vh7.h {

    @SerializedName("focus_index")
    public int focusIndex;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("hint")
    public String hint;

    @SerializedName("login_days")
    public int loginDays;

    @SerializedName(InstantPlayContext.PLAY_ID)
    public String playId;

    @SerializedName("title")
    public String title;

    public n() {
        this.playId = "";
        this.gameId = "";
        this.hint = "";
        this.title = "";
    }

    public n(am3.g r100) {
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
