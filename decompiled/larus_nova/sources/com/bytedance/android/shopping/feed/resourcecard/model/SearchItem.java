package com.bytedance.android.shopping.feed.resourcecard.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/model/SearchItem;", "Ljava/io/Serializable;", "()V", "img", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "jumpUrl", "getJumpUrl", "keyword", "", "getKeyword", "()Ljava/lang/String;", "productId", "", "getProductId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "queryId", "getQueryId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchItem implements Serializable {

    @SerializedName("img")
    private final ECUrlModel img;

    @SerializedName("jump_url")
    private final ECUrlModel jumpUrl;

    @SerializedName("keyword")
    private final String keyword;

    @SerializedName("product_id")
    private final Long productId;

    @SerializedName("query_id")
    private final String queryId;

    public SearchItem() {
    }

    public final ECUrlModel getImg() {
        return this.img;
    }

    public final ECUrlModel getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final Long getProductId() {
        return this.productId;
    }

    public final String getQueryId() {
        return this.queryId;
    }
}
