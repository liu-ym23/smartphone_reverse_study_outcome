package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.UserReserveItem")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/t;", "", "", "reserveNumByGameAndAnchor", "Ljava/lang/String;", "", "reserveStatus", "I", "reserveNumToday", "reserveNumByGame", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t implements vh7.h {

    @SerializedName("reserved_total_by_game")
    public String reserveNumByGame;

    @SerializedName("reserved_total_by_game_anchor")
    public String reserveNumByGameAndAnchor;

    @SerializedName("reserved_today_by_game_anchor")
    public String reserveNumToday;

    @SerializedName("reserved_status")
    public int reserveStatus;

    public t() {
        this.reserveNumByGameAndAnchor = "";
        this.reserveNumToday = "";
        this.reserveNumByGame = "";
    }

    public t(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.reserveNumByGameAndAnchor = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.reserveStatus = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.reserveNumToday = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.reserveNumByGame = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.reserveNumByGameAndAnchor != null) goto L22;
        this.reserveNumByGameAndAnchor = "";
    L22:
        if (this.reserveNumToday != null) goto L25;
        this.reserveNumToday = "";
    L25:
        if (this.reserveNumByGame != null) goto L43;
        this.reserveNumByGame = "";
        return;
    }
}
