package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gameplay.api.TeamPlayConfigResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/n;", "", "Lcom/bytedance/android/gamecp/business/api/response/m;", "config", "Lcom/bytedance/android/gamecp/business/api/response/m;", "Lcom/bytedance/android/gamecp/business/api/response/p;", "game", "Lcom/bytedance/android/gamecp/business/api/response/p;", "", "roomId", "Ljava/lang/String;", "anchorId", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n implements vh7.h {

    @SerializedName("anchor_id")
    public String anchorId;

    @SerializedName("config")
    public m config;

    @SerializedName("game")
    public p game;

    @SerializedName("room_id")
    public String roomId;

    public n() {
    }

    public n(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.config = new m(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.game = new p(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.roomId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.anchorId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
