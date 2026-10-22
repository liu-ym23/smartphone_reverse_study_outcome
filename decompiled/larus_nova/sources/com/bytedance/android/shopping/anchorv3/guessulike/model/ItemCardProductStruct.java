package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001EB\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\fR\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u0016\u00100\u001a\u0002018\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0018\u00106\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0018\u00108\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u0018\u0010C\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006¨\u0006F"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct;", "Ljava/io/Serializable;", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "commodityType", "getCommodityType", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "coverRecommend", "getCoverRecommend", "discountLabels", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "getDiscountLabels", "()Ljava/util/List;", "extra", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct$ProductExtra;", "getExtra", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct$ProductExtra;", "hasSecKill", "", "getHasSecKill", "()Z", "hideSales", "getHideSales", "()Ljava/lang/Boolean;", "setHideSales", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "platformTextActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;", "getPlatformTextActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;", "price", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "getPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "productIcon", "getProductIcon", "productIconName", "getProductIconName", "productId", "getProductId", "productKind", "", "getProductKind", "()I", "promotionId", "getPromotionId", "recommendInfo", "getRecommendInfo", "recommendReason", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardRecommendReasonStruct;", "getRecommendReason", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardRecommendReasonStruct;", SalesInfoStruct.SALES, "", "getSales", "()Ljava/lang/Long;", "Ljava/lang/Long;", "secAuthorId", "getSecAuthorId", "title", "getTitle", "ProductExtra", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemCardProductStruct implements Serializable {

    @SerializedName(a.KEY_KOL_ID)
    private final String authorId;

    @SerializedName(a.KEY_COMMODITY_TYPE)
    private final String commodityType;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("cover_recommend")
    private final ECUrlModel coverRecommend;

    @SerializedName("coupons")
    private final List<PromotionDiscountLabel> discountLabels;

    @SerializedName("extra")
    private final ProductExtra extra;

    @SerializedName("has_sec_kill")
    private final boolean hasSecKill;

    @SerializedName("is_hide_sales")
    private Boolean hideSales;

    @SerializedName("platform_text_activity")
    private final PromotionMarketFloor platformTextActivity;

    @SerializedName("price")
    private final PromotionProductPrice price;

    @SerializedName("product_icon")
    private final ECUrlModel productIcon;

    @SerializedName("icon_name")
    private final String productIconName;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("biz_kind")
    private final int productKind;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName("rec_reason")
    private final ItemCardRecommendReasonStruct recommendReason;

    @SerializedName(SalesInfoStruct.SALES)
    private final Long sales;

    @SerializedName("sec_kol_id")
    private final String secAuthorId;

    @SerializedName("title")
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct$ProductExtra;", "Ljava/io/Serializable;", "insurance_commodity_flag", "", "isWhiteBase", "similarLink", "", "(ILjava/lang/Integer;Ljava/lang/String;)V", "getInsurance_commodity_flag", "()I", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSimilarLink", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardProductStruct$ProductExtra;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProductExtra implements Serializable {
        private final int insurance_commodity_flag;

        @SerializedName("cover_is_white_bg")
        private final Integer isWhiteBase;

        @SerializedName("similar_link")
        private final String similarLink;

        public static /* synthetic */ ProductExtra copy$default(ProductExtra r100, int r101, Integer r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.insurance_commodity_flag;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.isWhiteBase;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.similarLink;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final int component1() {
            return this.insurance_commodity_flag;
        }

        public final Integer component2() {
            return this.isWhiteBase;
        }

        public final String component3() {
            return this.similarLink;
        }

        public final ProductExtra copy(int r100, Integer r101, String r102) {
            return new ProductExtra(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ProductExtra) == false) goto L12;
            ProductExtra r101 = (ProductExtra) r100;
            if (this.insurance_commodity_flag == r101.insurance_commodity_flag) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.isWhiteBase, r101.isWhiteBase) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.similarLink, r101.similarLink) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r100 = this.insurance_commodity_flag * 31;
            Integer r101 = this.isWhiteBase;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.similarLink;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "ProductExtra(insurance_commodity_flag=" + this.insurance_commodity_flag + ", isWhiteBase=" + this.isWhiteBase + ", similarLink=" + this.similarLink + ")";
        }

        public final int getInsurance_commodity_flag() {
            return this.insurance_commodity_flag;
        }

        public final String getSimilarLink() {
            return this.similarLink;
        }

        public final Integer isWhiteBase() {
            return this.isWhiteBase;
        }

        public ProductExtra(int r100, Integer r101, String r102) {
            this.insurance_commodity_flag = r100;
            this.isWhiteBase = r101;
            this.similarLink = r102;
        }

        public /* synthetic */ ProductExtra(int r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this(r100, r101, r102);
        }
    }

    public ItemCardProductStruct() {
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getCommodityType() {
        return this.commodityType;
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final ECUrlModel getCoverRecommend() {
        return this.coverRecommend;
    }

    public final List<PromotionDiscountLabel> getDiscountLabels() {
        return this.discountLabels;
    }

    public final ProductExtra getExtra() {
        return this.extra;
    }

    public final boolean getHasSecKill() {
        return this.hasSecKill;
    }

    public final Boolean getHideSales() {
        return this.hideSales;
    }

    public final PromotionMarketFloor getPlatformTextActivity() {
        return this.platformTextActivity;
    }

    public final PromotionProductPrice getPrice() {
        return this.price;
    }

    public final ECUrlModel getProductIcon() {
        return this.productIcon;
    }

    public final String getProductIconName() {
        return this.productIconName;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int getProductKind() {
        return this.productKind;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final ItemCardRecommendReasonStruct getRecommendReason() {
        return this.recommendReason;
    }

    public final Long getSales() {
        return this.sales;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setHideSales(Boolean r100) {
        this.hideSales = r100;
    }
}
