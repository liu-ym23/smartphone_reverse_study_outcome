package com.bytedance.android.shopping.sameproduct.viewmodel;

import com.bytedance.jedi.arch.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rd3.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", "Lcom/bytedance/jedi/arch/State;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f182442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f182443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f182444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f182445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f182446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f182447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f182448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f182449h;

    public SameProductState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SameProductState) == false) goto L22;
        SameProductState r101 = (SameProductState) r100;
        if (Intrinsics.areEqual(this.f182442a, r101.f182442a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f182443b, r101.f182443b) == true) goto L10;
        return false;
    L10:
        if (this.f182444c == r101.f182444c) goto L12;
        return false;
    L12:
        if (this.f182445d == r101.f182445d) goto L14;
        return false;
    L14:
        if (this.f182446e == r101.f182446e) goto L16;
        return false;
    L16:
        if (this.f182447f == r101.f182447f) goto L18;
        return false;
    L18:
        if (this.f182448g == r101.f182448g) goto L20;
        return false;
    L20:
        if (this.f182449h == r101.f182449h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        List<Object> r100 = this.f182442a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<a> r104 = this.f182443b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f182444c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f182445d;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f182446e;
        ?? r114 = r113;
        if (r113 == false) goto L18;
        r114 = 1;
    L18:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f182447f;
        ?? r117 = r116;
        if (r116 == false) goto L21;
        r117 = 1;
    L21:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f182448g;
        ?? r120 = r119;
        if (r119 == false) goto L24;
        r120 = 1;
    L24:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f182449h;
        if (r122 == true) goto L29;
        r107 = r122;
    L29:
        return r121 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SameProductState(headerList=" + this.f182442a + ", sameProductList=" + this.f182443b + ", isMainProductLoading=" + this.f182444c + ", isProductListLoading=" + this.f182445d + ", hasMoreSameProduct=" + this.f182446e + ", isMainProductApiError=" + this.f182447f + ", isProductListApiError=" + this.f182448g + ", loadedProductListApi=" + this.f182449h + ")";
    }

    public /* synthetic */ SameProductState(int r110) {
        this(CollectionsKt.emptyList(), new ArrayList(), false, false, true, false, false, false);
    }

    public SameProductState(List<? extends Object> r100, List<a> r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "headerList");
        Intrinsics.checkNotNullParameter(r101, "sameProductList");
        this.f182442a = r100;
        this.f182443b = r101;
        this.f182444c = r102;
        this.f182445d = r103;
        this.f182446e = r104;
        this.f182447f = r105;
        this.f182448g = r106;
        this.f182449h = r107;
    }

    public static SameProductState a(SameProductState r100, List r110, List r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        List r101 = r100.f182442a;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = r100.f182443b;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.f182444c;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.f182445d;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.f182446e;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.f182447f;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.f182448g;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.f182449h;
    L34:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "headerList");
        Intrinsics.checkNotNullParameter(r102, "sameProductList");
        return new SameProductState(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L34
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
