package com.bytedance.android.livesdk.coupon.refundcoupon.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.api.open_user_benefit.QueryUserBenefitPopupResponse.PopupWindow.Button")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/a;", "", "", "preText", "Ljava/lang/String;", "getPreText", "()Ljava/lang/String;", "setPreText", "(Ljava/lang/String;)V", "postText", "getPostText", "setPostText", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("post_text")
    protected String postText;

    @SerializedName("pre_text")
    protected String preText;

    public a() {
        this.preText = "";
        this.postText = "";
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.preText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.postText = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.preText != null) goto L16;
        this.preText = "";
    L16:
        if (this.postText != null) goto L28;
        this.postText = "";
        return;
    }
}
