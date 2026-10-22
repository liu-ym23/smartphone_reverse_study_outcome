package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.ReceivePlatformGiftResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/j;", "", "", "gameCode", "Ljava/lang/String;", "", "giftId", "Ljava/lang/Long;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j implements vh7.h {

    @SerializedName("game_code")
    public String gameCode;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    public Long giftId;

    public j() {
        this.giftId = 0L;
    }

    public j(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.gameCode = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.giftId = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.giftId != null) goto L25;
        this.giftId = 0L;
        return;
    }
}
