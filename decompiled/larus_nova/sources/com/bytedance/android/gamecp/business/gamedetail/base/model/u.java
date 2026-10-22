package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameCPVideoInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/u;", "", "", "videoCoverUrl", "Ljava/lang/String;", "videoPlayUrl", "", "rotation", "Ljava/lang/Integer;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u implements vh7.h {

    @SerializedName("rotation")
    public Integer rotation;

    @SerializedName("video_cover_url")
    public String videoCoverUrl;

    @SerializedName("video_play_url")
    public String videoPlayUrl;

    public u() {
    }

    public u(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.videoCoverUrl = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.videoPlayUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.rotation = Integer.valueOf(r100.i());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
