package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.PanelBanner")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/g0;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "bgImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBgImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setBgImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "schemeUrl", "Ljava/lang/String;", "getSchemeUrl", "()Ljava/lang/String;", "setSchemeUrl", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 implements vh7.h {

    @SerializedName("bg_image")
    protected ImageModel bgImage;

    @SerializedName("scheme_url")
    protected String schemeUrl;

    public g0() {
    }

    public g0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.bgImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.schemeUrl = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
