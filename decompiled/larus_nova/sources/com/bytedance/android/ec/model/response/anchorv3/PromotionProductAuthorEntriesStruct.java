package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R \u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAuthorEntriesStruct;", "Ljava/io/Serializable;", "()V", "authorAvatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAuthorAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "authorName", "", "getAuthorName", "()Ljava/lang/String;", "authorReputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "getAuthorReputation", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "displayDiscount", "", "getDisplayDiscount", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "leaderBoardEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductLeaderBoardEntryStruct;", "getLeaderBoardEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductLeaderBoardEntryStruct;", "liveEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLiveEntryStruct;", "getLiveEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLiveEntryStruct;", "setLiveEntry", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLiveEntryStruct;)V", "product3dEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/Product3DEntryStruct;", "getProduct3dEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/Product3DEntryStruct;", "productArEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductArEntryStruct;", "getProductArEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductArEntryStruct;", "referrer", "Lcom/bytedance/android/ec/model/response/anchorv3/DouyinAccountDTO;", "getReferrer", "()Lcom/bytedance/android/ec/model/response/anchorv3/DouyinAccountDTO;", "setReferrer", "(Lcom/bytedance/android/ec/model/response/anchorv3/DouyinAccountDTO;)V", "shopBindAuthor", "Lcom/bytedance/android/ec/model/response/anchorv3/ShopBindAuthorDTO;", "getShopBindAuthor", "()Lcom/bytedance/android/ec/model/response/anchorv3/ShopBindAuthorDTO;", "shopEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductShopEntryStruct;", "getShopEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductShopEntryStruct;", "storeEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStoreEntryStruct;", "getStoreEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStoreEntryStruct;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductAuthorEntriesStruct implements Serializable {

    @SerializedName("author_avatar")
    private final ECUrlModel authorAvatar;

    @SerializedName("author_name")
    private final String authorName;

    @SerializedName("author_reputation")
    private final AuthorReputationDTO authorReputation;

    @SerializedName("display_discount")
    private final Boolean displayDiscount;

    @SerializedName("leaderboard_entry")
    private final ProductLeaderBoardEntryStruct leaderBoardEntry;

    @SerializedName("live_entry")
    private PromotionProductLiveEntryStruct liveEntry;

    @SerializedName("product_3d_entry")
    private final Product3DEntryStruct product3dEntry;

    @SerializedName("product_ar_entry")
    private final ProductArEntryStruct productArEntry;

    @SerializedName("referrer")
    private DouyinAccountDTO referrer;

    @SerializedName("shop_bind_author")
    private final ShopBindAuthorDTO shopBindAuthor;

    @SerializedName("shop_entry")
    private final PromotionProductShopEntryStruct shopEntry;

    @SerializedName("store_entry")
    private final PromotionProductStoreEntryStruct storeEntry;

    public PromotionProductAuthorEntriesStruct() {
    }

    public final ECUrlModel getAuthorAvatar() {
        return this.authorAvatar;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final AuthorReputationDTO getAuthorReputation() {
        return this.authorReputation;
    }

    public final Boolean getDisplayDiscount() {
        return this.displayDiscount;
    }

    public final ProductLeaderBoardEntryStruct getLeaderBoardEntry() {
        return this.leaderBoardEntry;
    }

    public final PromotionProductLiveEntryStruct getLiveEntry() {
        return this.liveEntry;
    }

    public final Product3DEntryStruct getProduct3dEntry() {
        return this.product3dEntry;
    }

    public final ProductArEntryStruct getProductArEntry() {
        return this.productArEntry;
    }

    public final DouyinAccountDTO getReferrer() {
        return this.referrer;
    }

    public final ShopBindAuthorDTO getShopBindAuthor() {
        return this.shopBindAuthor;
    }

    public final PromotionProductShopEntryStruct getShopEntry() {
        return this.shopEntry;
    }

    public final PromotionProductStoreEntryStruct getStoreEntry() {
        return this.storeEntry;
    }

    public final void setLiveEntry(PromotionProductLiveEntryStruct r100) {
        this.liveEntry = r100;
    }

    public final void setReferrer(DouyinAccountDTO r100) {
        this.referrer = r100;
    }
}
