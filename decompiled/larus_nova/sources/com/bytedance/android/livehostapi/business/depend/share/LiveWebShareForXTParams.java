package com.bytedance.android.livehostapi.business.depend.share;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/LiveWebShareForXTParams;", "", "()V", SocialConstants.PARAM_APP_DESC, "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "qrcode", "", "getQrcode", "()Ljava/lang/Integer;", "setQrcode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "title", "getTitle", d.f25925o, "url", "getUrl", "setUrl", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWebShareForXTParams {

    @SerializedName("content")
    private String desc;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("qrcode")
    private Integer qrcode;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public LiveWebShareForXTParams() {
        this.qrcode = 0;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Integer getQrcode() {
        return this.qrcode;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setQrcode(Integer r100) {
        this.qrcode = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
