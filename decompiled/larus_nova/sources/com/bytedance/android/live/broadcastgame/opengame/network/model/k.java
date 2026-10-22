package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.stamp.GetGameCardStatusResponse.Data")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/model/k;", "", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName("display_status")
    protected Integer _$$displayStatus;

    public k() {
        this._$$displayStatus = 0;
    }

    public final Integer a() {
        return this._$$displayStatus;
    }

    public k(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this._$$displayStatus = Integer.valueOf(r100.i());
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this._$$displayStatus != null) goto L19;
        this._$$displayStatus = 0;
        return;
    }
}
