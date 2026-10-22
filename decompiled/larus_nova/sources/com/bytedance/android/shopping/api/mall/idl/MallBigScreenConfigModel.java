package com.bytedance.android.shopping.api.mall.idl;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/idl/MallBigScreenConfigModel;", "", "enableWidescreenStylePageName", "", "", "customFavoriteColumnExcludeTabId", "", "enableSplitScreenPageName", "enableSplitScreenSupplementedVisibility", "", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Z)V", "getCustomFavoriteColumnExcludeTabId", "()Ljava/util/Set;", "getEnableSplitScreenPageName", "getEnableSplitScreenSupplementedVisibility", "()Z", "getEnableWidescreenStylePageName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallBigScreenConfigModel {

    @SerializedName("custom_favorite_column_exclude_tab_id")
    private final Set<Integer> customFavoriteColumnExcludeTabId;

    @SerializedName("enable_split_screen_page_name")
    private final Set<String> enableSplitScreenPageName;

    @SerializedName("enable_split_screen_supplemented_visibility")
    private final boolean enableSplitScreenSupplementedVisibility;

    @SerializedName("enable_widescreen_style_page_name")
    private final Set<String> enableWidescreenStylePageName;

    public MallBigScreenConfigModel() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallBigScreenConfigModel copy$default(MallBigScreenConfigModel r100, Set r101, Set r102, Set r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enableWidescreenStylePageName;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.customFavoriteColumnExcludeTabId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enableSplitScreenPageName;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.enableSplitScreenSupplementedVisibility;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Set<String> component1() {
        return this.enableWidescreenStylePageName;
    }

    public final Set<Integer> component2() {
        return this.customFavoriteColumnExcludeTabId;
    }

    public final Set<String> component3() {
        return this.enableSplitScreenPageName;
    }

    public final boolean component4() {
        return this.enableSplitScreenSupplementedVisibility;
    }

    public final MallBigScreenConfigModel copy(Set<String> r100, Set<Integer> r101, Set<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "enableWidescreenStylePageName");
        Intrinsics.checkNotNullParameter(r101, "customFavoriteColumnExcludeTabId");
        Intrinsics.checkNotNullParameter(r102, "enableSplitScreenPageName");
        return new MallBigScreenConfigModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallBigScreenConfigModel) == false) goto L14;
        MallBigScreenConfigModel r101 = (MallBigScreenConfigModel) r100;
        if (Intrinsics.areEqual(this.enableWidescreenStylePageName, r101.enableWidescreenStylePageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.customFavoriteColumnExcludeTabId, r101.customFavoriteColumnExcludeTabId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enableSplitScreenPageName, r101.enableSplitScreenPageName) == true) goto L12;
        return false;
    L12:
        if (this.enableSplitScreenSupplementedVisibility == r101.enableSplitScreenSupplementedVisibility) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Set<String> r100 = this.enableWidescreenStylePageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Set<Integer> r104 = this.customFavoriteColumnExcludeTabId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Set<String> r107 = this.enableSplitScreenPageName;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.enableSplitScreenSupplementedVisibility;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MallBigScreenConfigModel(enableWidescreenStylePageName=" + this.enableWidescreenStylePageName + ", customFavoriteColumnExcludeTabId=" + this.customFavoriteColumnExcludeTabId + ", enableSplitScreenPageName=" + this.enableSplitScreenPageName + ", enableSplitScreenSupplementedVisibility=" + this.enableSplitScreenSupplementedVisibility + ")";
    }

    public final Set<Integer> getCustomFavoriteColumnExcludeTabId() {
        return this.customFavoriteColumnExcludeTabId;
    }

    public final Set<String> getEnableSplitScreenPageName() {
        return this.enableSplitScreenPageName;
    }

    public final boolean getEnableSplitScreenSupplementedVisibility() {
        return this.enableSplitScreenSupplementedVisibility;
    }

    public final Set<String> getEnableWidescreenStylePageName() {
        return this.enableWidescreenStylePageName;
    }

    public MallBigScreenConfigModel(Set<String> r100, Set<Integer> r101, Set<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "enableWidescreenStylePageName");
        Intrinsics.checkNotNullParameter(r101, "customFavoriteColumnExcludeTabId");
        Intrinsics.checkNotNullParameter(r102, "enableSplitScreenPageName");
        this.enableWidescreenStylePageName = r100;
        this.customFavoriteColumnExcludeTabId = r101;
        this.enableSplitScreenPageName = r102;
        this.enableSplitScreenSupplementedVisibility = r103;
    }

    public /* synthetic */ MallBigScreenConfigModel(Set r100, Set r101, Set r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = SetsKt.emptySet();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = SetsKt.setOf(new Integer[]{202, 301});
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = SetsKt.emptySet();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = true;
    L14:
        this(r100, r101, r102, r103);
    }
}
