package com.bytedance.android.shopping.mall.preload;

import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/mall/preload/DistributionData;", "", "()V", "redirectUrl", "", "getRedirectUrl", "()Ljava/lang/String;", "setRedirectUrl", "(Ljava/lang/String;)V", "urlType", "", "getUrlType", "()Ljava/lang/Integer;", "setUrlType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DistributionData {

    @SerializedName(ITiktokService.ResponseConstants.REDIRECT_URL)
    private String redirectUrl;

    @SerializedName("url_type")
    private Integer urlType;

    public DistributionData() {
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final Integer getUrlType() {
        return this.urlType;
    }

    public final void setRedirectUrl(String r100) {
        this.redirectUrl = r100;
    }

    public final void setUrlType(Integer r100) {
        this.urlType = r100;
    }
}
