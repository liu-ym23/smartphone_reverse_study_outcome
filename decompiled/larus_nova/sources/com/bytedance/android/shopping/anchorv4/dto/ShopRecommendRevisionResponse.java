package com.bytedance.android.shopping.anchorv4.dto;

import com.bytedance.android.ecom.arch.slice.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\bHÆ\u0003JJ\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\nHÖ\u0003R$\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/ShopRecommendRevisionResponse;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ecom/arch/slice/g;", "component1", "", "component2", "()Ljava/lang/Boolean;", "", "", "", "component3", "sliceGroups", "hasMore", "feedsOtherReqParams", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/bytedance/android/shopping/anchorv4/dto/ShopRecommendRevisionResponse;", "toString", "", "hashCode", "other", "equals", "Ljava/util/List;", "getSliceGroups", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getHasMore", "Ljava/util/Map;", "getFeedsOtherReqParams", "()Ljava/util/Map;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopRecommendRevisionResponse implements Serializable {

    @SerializedName("feeds_other_req_params")
    private final Map<String, Object> feedsOtherReqParams;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("slice_groups")
    private final List<g> sliceGroups;

    public ShopRecommendRevisionResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopRecommendRevisionResponse copy$default(ShopRecommendRevisionResponse r100, List r101, Boolean r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.sliceGroups;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.hasMore;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.feedsOtherReqParams;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<g> component1() {
        return this.sliceGroups;
    }

    public final Boolean component2() {
        return this.hasMore;
    }

    public final Map<String, Object> component3() {
        return this.feedsOtherReqParams;
    }

    public final ShopRecommendRevisionResponse copy(List<? extends g> r100, Boolean r101, Map<String, ? extends Object> r102) {
        return new ShopRecommendRevisionResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShopRecommendRevisionResponse) == false) goto L12;
        ShopRecommendRevisionResponse r101 = (ShopRecommendRevisionResponse) r100;
        if (Intrinsics.areEqual(this.sliceGroups, r101.sliceGroups) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feedsOtherReqParams, r101.feedsOtherReqParams) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        List<g> r100 = this.sliceGroups;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasMore;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.feedsOtherReqParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ShopRecommendRevisionResponse(sliceGroups=" + this.sliceGroups + ", hasMore=" + this.hasMore + ", feedsOtherReqParams=" + this.feedsOtherReqParams + ")";
    }

    public final Map<String, Object> getFeedsOtherReqParams() {
        return this.feedsOtherReqParams;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<g> getSliceGroups() {
        return this.sliceGroups;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopRecommendRevisionResponse(List<? extends g> r100, Boolean r101, Map<String, ? extends Object> r102) {
        this.sliceGroups = r100;
        this.hasMore = r101;
        this.feedsOtherReqParams = r102;
    }

    public /* synthetic */ ShopRecommendRevisionResponse(List r100, Boolean r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
