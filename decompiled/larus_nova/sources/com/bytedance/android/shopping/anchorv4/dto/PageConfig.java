package com.bytedance.android.shopping.anchorv4.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/PageConfig;", "Ljava/io/Serializable;", "collapseDetail", "", "collapseIgnoreList", "", "", "backgroundColor", "(ZLjava/util/List;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getCollapseDetail", "()Z", "getCollapseIgnoreList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageConfig implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("collapse_detail")
    private final boolean collapseDetail;

    @SerializedName("forbid_fold_slice_ids")
    private final List<String> collapseIgnoreList;

    public PageConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageConfig copy$default(PageConfig r100, boolean r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.collapseDetail;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.collapseIgnoreList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.backgroundColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.collapseDetail;
    }

    public final List<String> component2() {
        return this.collapseIgnoreList;
    }

    public final String component3() {
        return this.backgroundColor;
    }

    public final PageConfig copy(boolean r100, List<String> r101, String r102) {
        return new PageConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PageConfig) == false) goto L12;
        PageConfig r101 = (PageConfig) r100;
        if (this.collapseDetail == r101.collapseDetail) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.collapseIgnoreList, r101.collapseIgnoreList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.collapseDetail;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.collapseIgnoreList;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.backgroundColor;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "PageConfig(collapseDetail=" + this.collapseDetail + ", collapseIgnoreList=" + this.collapseIgnoreList + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final boolean getCollapseDetail() {
        return this.collapseDetail;
    }

    public final List<String> getCollapseIgnoreList() {
        return this.collapseIgnoreList;
    }

    public PageConfig(boolean r100, List<String> r101, String r102) {
        this.collapseDetail = r100;
        this.collapseIgnoreList = r101;
        this.backgroundColor = r102;
    }

    public /* synthetic */ PageConfig(boolean r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
