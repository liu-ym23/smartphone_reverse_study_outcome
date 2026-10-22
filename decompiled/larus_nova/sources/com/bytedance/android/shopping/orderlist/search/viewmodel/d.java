package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f180595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f180596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f180597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f180598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f180599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f180600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OrderSearchResultParams f180601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f180602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, j> f180603i;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (this.f180595a == r101.f180595a) goto L8;
        return false;
    L8:
        if (this.f180596b == r101.f180596b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180597c, r101.f180597c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180598d, r101.f180598d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180599e, r101.f180599e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f180600f, r101.f180600f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f180601g, r101.f180601g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f180602h, r101.f180602h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f180603i, r101.f180603i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    public final int hashCode() {
        boolean r100 = this.f180595a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f180596b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        String r106 = this.f180597c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        Boolean r110 = this.f180598d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f180599e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f180600f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        OrderSearchResultParams r119 = this.f180601g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        j0 r122 = this.f180602h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        Map<String, j> r125 = this.f180603i;
        if (r125 == null) goto L37;
        r107 = r125.hashCode();
    L37:
        return r124 + r107;
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "OrderSearchResultStaticState(isActivityReload=" + this.f180595a + ", isFirstEnter=" + this.f180596b + ", sessionId=" + this.f180597c + ", isInApplet=" + this.f180598d + ", isInFirstAppletPage=" + this.f180599e + ", logId=" + this.f180600f + ", orderSearchParams=" + this.f180601g + ", queryCacheInfo=" + this.f180602h + ", selfRegisterJsSubscriber=" + this.f180603i + ")";
    }

    public d(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "selfRegisterJsSubscriber");
        this.f180595a = false;
        this.f180596b = true;
        this.f180597c = null;
        this.f180598d = null;
        this.f180599e = null;
        this.f180600f = null;
        this.f180601g = null;
        this.f180602h = null;
        this.f180603i = r101;
    }
}
