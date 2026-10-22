package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.stamp.RightButton")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/k0;", "", "", "text", "Ljava/lang/String;", "schemeUrl", "extra", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 implements vh7.h {

    @SerializedName("extra")
    public String extra;

    @SerializedName("scheme_url")
    public String schemeUrl;

    @SerializedName("text")
    public String text;

    public k0() {
        this.text = "";
        this.schemeUrl = "";
        this.extra = "";
    }

    public k0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.text = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.schemeUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 100) goto L11;
        this.extra = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.text != null) goto L19;
        this.text = "";
    L19:
        if (this.schemeUrl != null) goto L22;
        this.schemeUrl = "";
    L22:
        if (this.extra != null) goto L37;
        this.extra = "";
        return;
    }
}
