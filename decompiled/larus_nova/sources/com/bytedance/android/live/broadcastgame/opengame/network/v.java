package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.open.api.StartAppResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/v;", "", "", "startId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setStartId", "(Ljava/lang/String;)V", "", "pushStreamType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setPushStreamType", "(I)V", "streamId", "getStreamId", "setStreamId", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v implements vh7.h {

    @SerializedName("push_stream_type")
    protected int pushStreamType;

    @SerializedName("start_id")
    protected String startId;

    @SerializedName("stream_id")
    protected String streamId;

    public v() {
        this.startId = "";
    }

    public final int a() {
        return this.pushStreamType;
    }

    public final String b() {
        return this.startId;
    }

    public v(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.startId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.pushStreamType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.streamId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.startId != null) goto L31;
        this.startId = "";
        return;
    }
}
