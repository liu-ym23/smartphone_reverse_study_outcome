package com.bytedance.android.shopping.searchsimilar.viewmodel;

import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.model.SortRuleInfo;
import com.bytedance.jedi.arch.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rd3.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/viewmodel/SimilarProductState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f182575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f182576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f182577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f182578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ProductFrame> f182579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<SortRuleInfo> f182580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f182581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f182582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f182583i;

    public SimilarProductState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SimilarProductState) == false) goto L24;
        SimilarProductState r101 = (SimilarProductState) r100;
        if (this.f182575a == r101.f182575a) goto L8;
        return false;
    L8:
        if (this.f182576b == r101.f182576b) goto L10;
        return false;
    L10:
        if (this.f182577c == r101.f182577c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f182578d, r101.f182578d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f182579e, r101.f182579e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f182580f, r101.f182580f) == true) goto L18;
        return false;
    L18:
        if (this.f182581g == r101.f182581g) goto L20;
        return false;
    L20:
        if (this.f182582h == r101.f182582h) goto L22;
        return false;
    L22:
        if (this.f182583i == r101.f182583i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f182575a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f182576b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f182577c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        List<a> r110 = this.f182578d;
        int r111 = 0;
        if (r110 == null) goto L14;
        int r112 = r110.hashCode();
    L15:
        int r113 = (r109 + r112) * 31;
        List<ProductFrame> r114 = this.f182579e;
        if (r114 == null) goto L18;
        int r115 = r114.hashCode();
    L19:
        int r116 = (r113 + r115) * 31;
        List<SortRuleInfo> r117 = this.f182580f;
        if (r117 == null) goto L22;
        r111 = r117.hashCode();
    L22:
        int r118 = (r116 + r111) * 31;
        boolean r119 = this.f182581g;
        ?? r120 = r119;
        if (r119 == false) goto L25;
        r120 = 1;
    L25:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f182582h;
        ?? r123 = r122;
        if (r122 == false) goto L28;
        r123 = 1;
    L28:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.f182583i;
        if (r125 == true) goto L33;
        r101 = r125;
    L33:
        return r124 + r101;
    L18:
        r115 = 0;
        goto L19
    L14:
        r112 = 0;
        goto L15
    }

    public final String toString() {
        return "SimilarProductState(isLoadingMore=" + this.f182575a + ", hasMore=" + this.f182576b + ", isInitializeLoadingSuccess=" + this.f182577c + ", similarProductList=" + this.f182578d + ", productFrameList=" + this.f182579e + ", sortRuleList=" + this.f182580f + ", isLoadingError=" + this.f182581g + ", isNoData=" + this.f182582h + ", isRefreshLoad=" + this.f182583i + ")";
    }

    public /* synthetic */ SimilarProductState(int r110) {
        this(false, true, false, new ArrayList(), null, null, false, false, true);
    }

    public SimilarProductState(boolean r100, boolean r101, boolean r102, List<a> r103, List<ProductFrame> r104, List<SortRuleInfo> r105, boolean r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r103, "similarProductList");
        this.f182575a = r100;
        this.f182576b = r101;
        this.f182577c = r102;
        this.f182578d = r103;
        this.f182579e = r104;
        this.f182580f = r105;
        this.f182581g = r106;
        this.f182582h = r107;
        this.f182583i = r110;
    }

    public static SimilarProductState a(SimilarProductState r110, boolean r111, boolean r112, boolean r113, List r114, List r115, List r116, boolean r117, boolean r118, boolean r119, int r210) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = r110.f182575a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = r110.f182576b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.f182577c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r103 = r110.f182578d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.f182579e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r105 = r110.f182580f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.f182581g;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.f182582h;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.f182583i;
    L38:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, "similarProductList");
        return new SimilarProductState(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L38
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
