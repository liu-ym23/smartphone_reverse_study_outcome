package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.ReplaySetting")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/d1;", "", "", "replayEnabled", "Z", "replayAutoPost", "replaySyncXitou", "replaySyncProduct", "replayProductExposit", "realTimePlaybackEnable", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 implements vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("realtime_replay_enabled")
    public boolean realTimePlaybackEnable;

    @SerializedName("replay_auto_post")
    public boolean replayAutoPost;

    @SerializedName("replay_enabled")
    public boolean replayEnabled;

    @IgnoreProtoFieldCheck
    @SerializedName("replay_product_exposit")
    public boolean replayProductExposit;

    @IgnoreProtoFieldCheck
    @SerializedName("replay_sync_product")
    public boolean replaySyncProduct;

    @SerializedName("replay_sync_xitou")
    public boolean replaySyncXitou;

    public d1() {
    }

    public d1(am3.g r100) {
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
        this.realTimePlaybackEnable = am3.h.a(r100);
        goto L3
    L8:
        this.replayProductExposit = am3.h.a(r100);
        goto L3
    L9:
        this.replaySyncProduct = am3.h.a(r100);
        goto L3
    L10:
        this.replaySyncXitou = am3.h.a(r100);
        goto L3
    L11:
        this.replayAutoPost = am3.h.a(r100);
        goto L3
    L12:
        this.replayEnabled = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
