package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.o;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.store.repository.dto.l;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/ShopCardDTO;", "Ljava/io/Serializable;", "", "shopName", "Ljava/lang/String;", "getShopName", "()Ljava/lang/String;", "", "living", "Ljava/lang/Boolean;", "getLiving", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "tagList", "Ljava/util/List;", "getTagList", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "getReputation", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "storeUrl", "getStoreUrl", "Lcom/bytedance/android/ec/store/repository/dto/l;", "products", "getProducts", "Lcom/bytedance/android/ec/model/o;", "shopXzgInfo", "Lcom/bytedance/android/ec/model/o;", "getShopXzgInfo", "()Lcom/bytedance/android/ec/model/o;", "brandTag", "getBrandTag", "", "logExtra", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopCardDTO implements Serializable {

    @SerializedName("brand_tag")
    private final ECUrlModel brandTag;

    @SerializedName("living")
    private final Boolean living;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    @SerializedName("products")
    private final List<l> products;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    @SerializedName("shop_logo")
    private final ECUrlModel shopLogo;

    @SerializedName("shop_name")
    private final String shopName;

    @SerializedName("shop_xzg_info")
    private final o shopXzgInfo;

    @SerializedName("store_url")
    private final String storeUrl;

    @SerializedName("tag_list")
    private final List<ECUrlModel> tagList;

    public ShopCardDTO() {
    }

    public final ECUrlModel getBrandTag() {
        return this.brandTag;
    }

    public final Boolean getLiving() {
        return this.living;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final List<l> getProducts() {
        return this.products;
    }

    public final AuthorReputationDTO getReputation() {
        return this.reputation;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final o getShopXzgInfo() {
        return this.shopXzgInfo;
    }

    public final String getStoreUrl() {
        return this.storeUrl;
    }

    public final List<ECUrlModel> getTagList() {
        return this.tagList;
    }
}
