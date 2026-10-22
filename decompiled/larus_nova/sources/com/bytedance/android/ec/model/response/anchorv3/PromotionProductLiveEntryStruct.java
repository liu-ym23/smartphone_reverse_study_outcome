package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLiveEntryStruct;", "Ljava/io/Serializable;", "()V", "living", "", "getLiving", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "livingSellPoint", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBannerStruct;", "getLivingSellPoint", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBannerStruct;", "logExtras", "", "getLogExtras", "()Ljava/lang/String;", "navLink", "getNavLink", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductLiveEntryStruct implements Serializable {

    @SerializedName("living")
    private final Boolean living;

    @SerializedName("living_selling_point")
    private final PromotionProductBannerStruct livingSellPoint;

    @SerializedName("log_extras")
    private final String logExtras;

    @SerializedName("nav_link")
    private final String navLink;

    public PromotionProductLiveEntryStruct() {
    }

    public final Boolean getLiving() {
        return this.living;
    }

    public final PromotionProductBannerStruct getLivingSellPoint() {
        return this.livingSellPoint;
    }

    public final String getLogExtras() {
        return this.logExtras;
    }

    public final String getNavLink() {
        return this.navLink;
    }
}
