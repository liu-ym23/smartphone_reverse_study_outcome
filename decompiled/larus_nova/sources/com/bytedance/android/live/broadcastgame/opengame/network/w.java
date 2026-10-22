package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.open.api.AudienceStartAppletResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/w;", "", "", "startId", "J", "b", "()J", "setStartId", "(J)V", "needVerify", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setNeedVerify", "isAdult", "c", "setAdult", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w implements vh7.h {

    @SerializedName("is_adult")
    protected long isAdult;

    @SerializedName("need_verify")
    protected long needVerify;

    @SerializedName("start_id")
    protected long startId;

    public w() {
    }

    public final long a() {
        return this.needVerify;
    }

    public final long b() {
        return this.startId;
    }

    public final long c() {
        return this.isAdult;
    }

    public w(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.startId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.needVerify = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.isAdult = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
