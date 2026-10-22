package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.store.repository.dto.l;
import com.bytedance.android.ec.store.repository.dto.m;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/StoreV3SearchResponseExpDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/store/repository/dto/l;", "products", "Ljava/util/List;", "getProducts", "()Ljava/util/List;", "recommendProducts", "getRecommendProducts", "Lcom/bytedance/android/ec/store/repository/dto/m;", "sortTypes", "getSortTypes", "", "count", "Ljava/lang/Integer;", "getCount", "()Ljava/lang/Integer;", EffectConfiguration.KEY_CURSOR, "getCursor", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "searchHint", "Ljava/lang/String;", "getSearchHint", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/store/repository/dto/ShopRowDTO;", "rows", "getRows", "Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "logPb", "Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "getLogPb", "()Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV3SearchResponseExpDTO extends CommerceBaseResponse {

    @SerializedName("count")
    private final Integer count;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final Integer cursor;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("log_pb")
    private final LogPbDTO logPb;

    @SerializedName("products")
    private final List<l> products;

    @SerializedName("recommend_products")
    private final List<l> recommendProducts;

    @SerializedName("rows")
    private final List<ShopRowDTO> rows;

    @SerializedName("search_hint")
    private final String searchHint;

    @SerializedName("sort_types")
    private final List<m> sortTypes;

    public StoreV3SearchResponseExpDTO() {
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getCursor() {
        return this.cursor;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final LogPbDTO getLogPb() {
        return this.logPb;
    }

    public final List<l> getProducts() {
        return this.products;
    }

    public final List<l> getRecommendProducts() {
        return this.recommendProducts;
    }

    public final List<ShopRowDTO> getRows() {
        return this.rows;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final List<m> getSortTypes() {
        return this.sortTypes;
    }
}
