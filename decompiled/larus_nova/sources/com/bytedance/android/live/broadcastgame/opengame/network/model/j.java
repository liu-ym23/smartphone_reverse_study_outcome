package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.bytedance.android.livesdk.message.model.w4;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.stamp.GetGameCardInfoResponse.Data")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/model/j;", "", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j implements vh7.h {

    @SerializedName(BrowserDependency.UrlClickType.CARD)
    protected w4 _$$gameCardInfo;

    public j() {
        this._$$gameCardInfo = null;
    }

    public j(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this._$$gameCardInfo = new w4(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this._$$gameCardInfo != null) goto L19;
        this._$$gameCardInfo = null;
        return;
    }
}
