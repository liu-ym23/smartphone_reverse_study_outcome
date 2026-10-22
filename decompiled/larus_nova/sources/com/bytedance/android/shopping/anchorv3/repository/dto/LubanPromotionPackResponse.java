package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/LubanPromotionPackResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "pageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;", "getPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;", "setPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;)V", "promotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setPromotion", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "isValid", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LubanPromotionPackResponse extends CommerceBaseResponse {

    @SerializedName("page_style")
    private PromotionPageStyleDTO pageStyle;

    @SerializedName("promotion")
    private PromotionProductStruct promotion;

    public final boolean isValid() {
        if (getStatusCode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.promotion == null) goto L7;
        return true;
    }

    public LubanPromotionPackResponse() {
    }

    public final PromotionPageStyleDTO getPageStyle() {
        return this.pageStyle;
    }

    public final PromotionProductStruct getPromotion() {
        return this.promotion;
    }

    public final void setPageStyle(PromotionPageStyleDTO r100) {
        this.pageStyle = r100;
    }

    public final void setPromotion(PromotionProductStruct r100) {
        this.promotion = r100;
    }
}
