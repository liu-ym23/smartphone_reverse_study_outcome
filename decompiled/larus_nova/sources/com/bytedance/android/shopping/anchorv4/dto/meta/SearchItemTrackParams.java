package com.bytedance.android.shopping.anchorv4.dto.meta;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J=\u0010\r\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/meta/SearchItemTrackParams;", "Ljava/io/Serializable;", "clickSearchBar", "", "", "", "showSearch", "(Ljava/util/Map;Ljava/util/Map;)V", "getClickSearchBar", "()Ljava/util/Map;", "getShowSearch", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchItemTrackParams implements Serializable {

    @SerializedName("click_search_bar")
    private final Map<String, Object> clickSearchBar;

    @SerializedName("show_search")
    private final Map<String, Object> showSearch;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchItemTrackParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchItemTrackParams copy$default(SearchItemTrackParams r100, Map r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.clickSearchBar;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.showSearch;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, Object> component1() {
        return this.clickSearchBar;
    }

    public final Map<String, Object> component2() {
        return this.showSearch;
    }

    public final SearchItemTrackParams copy(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
        return new SearchItemTrackParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchItemTrackParams) == false) goto L10;
        SearchItemTrackParams r101 = (SearchItemTrackParams) r100;
        if (Intrinsics.areEqual(this.clickSearchBar, r101.clickSearchBar) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showSearch, r101.showSearch) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Map<String, Object> r100 = this.clickSearchBar;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.showSearch;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SearchItemTrackParams(clickSearchBar=" + this.clickSearchBar + ", showSearch=" + this.showSearch + ")";
    }

    public final Map<String, Object> getClickSearchBar() {
        return this.clickSearchBar;
    }

    public final Map<String, Object> getShowSearch() {
        return this.showSearch;
    }

    public SearchItemTrackParams(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
        this.clickSearchBar = r100;
        this.showSearch = r101;
    }

    public /* synthetic */ SearchItemTrackParams(Map r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
