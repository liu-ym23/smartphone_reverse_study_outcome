package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f180325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f180326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f180327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f180328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f180329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f180330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f180331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f180332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f180333k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L28;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f180323a, r101.f180323a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180324b, r101.f180324b) == true) goto L10;
        return false;
    L10:
        if (this.f180325c == r101.f180325c) goto L12;
        return false;
    L12:
        if (this.f180326d == r101.f180326d) goto L14;
        return false;
    L14:
        if (this.f180327e == r101.f180327e) goto L16;
        return false;
    L16:
        if (this.f180328f == r101.f180328f) goto L18;
        return false;
    L18:
        if (this.f180329g == r101.f180329g) goto L20;
        return false;
    L20:
        if (this.f180330h == r101.f180330h) goto L22;
        return false;
    L22:
        if (this.f180331i == r101.f180331i) goto L24;
        return false;
    L24:
        if (this.f180332j == r101.f180332j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f180333k, r101.f180333k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f180323a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f180324b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.f180325c) * 31) + this.f180326d) * 31) + this.f180327e) * 31;
        boolean r107 = this.f180328f;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f180329g;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f180330h;
        ?? r115 = r114;
        if (r114 == false) goto L19;
        r115 = 1;
    L19:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f180331i;
        ?? r118 = r117;
        if (r117 == false) goto L22;
        r118 = 1;
    L22:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.f180332j;
        if (r120 == true) goto L26;
        r108 = r120;
    L26:
        int r121 = (r119 + r108) * 31;
        Map<String, Object> r122 = this.f180333k;
        if (r122 == null) goto L30;
        r101 = r122.hashCode();
    L30:
        return r121 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderListTabItemInfo(tabName=" + this.f180323a + ", count=" + this.f180324b + ", leftTabId=" + this.f180325c + ", tabId=" + this.f180326d + ", rightTabId=" + this.f180327e + ", isSelected=" + this.f180328f + ", isFirst=" + this.f180329g + ", isLast=" + this.f180330h + ", isFixed=" + this.f180331i + ", muteTabTextHorizontalPadding=" + this.f180332j + ", originProps=" + this.f180333k + ")";
    }

    public g(String r100, String r101, int r102, int r103, int r104, boolean r105, boolean r106, boolean r107, boolean r110, boolean r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r112, "originProps");
        this.f180323a = r100;
        this.f180324b = r101;
        this.f180325c = r102;
        this.f180326d = r103;
        this.f180327e = r104;
        this.f180328f = r105;
        this.f180329g = r106;
        this.f180330h = r107;
        this.f180331i = r110;
        this.f180332j = r111;
        this.f180333k = r112;
    }
}
