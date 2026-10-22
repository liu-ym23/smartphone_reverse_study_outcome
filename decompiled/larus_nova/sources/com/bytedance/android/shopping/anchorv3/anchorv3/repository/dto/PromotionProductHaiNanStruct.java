package com.bytedance.android.shopping.anchorv3.anchorv3.repository.dto;

import com.bytedance.android.ec.model.response.anchorv3.CountryItemStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct;", "Ljava/io/Serializable;", "()V", "brandCountry", "Lcom/bytedance/android/ec/model/response/anchorv3/CountryItemStruct;", "getBrandCountry", "()Lcom/bytedance/android/ec/model/response/anchorv3/CountryItemStruct;", "purchaseQualification", "Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct$PurchaseQualificationStruct;", "getPurchaseQualification", "()Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct$PurchaseQualificationStruct;", "ProductReceiveStruct", "PurchaseQualificationStruct", "ReceiveTypeItem", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductHaiNanStruct implements Serializable {

    @SerializedName("brand_country")
    private final CountryItemStruct brandCountry;

    @SerializedName("purchase_qualification")
    private final PurchaseQualificationStruct purchaseQualification;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct$ProductReceiveStruct;", "Ljava/io/Serializable;", "()V", "receiveTypeList", "", "Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct$ReceiveTypeItem;", "getReceiveTypeList", "()Ljava/util/List;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProductReceiveStruct implements Serializable {

        @SerializedName("receive_type_list")
        private final List<ReceiveTypeItem> receiveTypeList;

        public ProductReceiveStruct() {
        }

        public final List<ReceiveTypeItem> getReceiveTypeList() {
            return this.receiveTypeList;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct$PurchaseQualificationStruct;", "Ljava/io/Serializable;", "()V", "text", "", "getText", "()Ljava/lang/String;", "url", "getUrl", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PurchaseQualificationStruct implements Serializable {

        @SerializedName("text")
        private final String text;

        @SerializedName("url")
        private final String url;

        public PurchaseQualificationStruct() {
        }

        public final String getText() {
            return this.text;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/anchorv3/repository/dto/PromotionProductHaiNanStruct$ReceiveTypeItem;", "Ljava/io/Serializable;", "()V", "name", "", "getName", "()Ljava/lang/String;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ReceiveTypeItem implements Serializable {

        @SerializedName("name")
        private final String name;

        public ReceiveTypeItem() {
        }

        public final String getName() {
            return this.name;
        }
    }

    public PromotionProductHaiNanStruct() {
    }

    public final CountryItemStruct getBrandCountry() {
        return this.brandCountry;
    }

    public final PurchaseQualificationStruct getPurchaseQualification() {
        return this.purchaseQualification;
    }
}
