package com.bytedance.android.shopping.api.mall.feed;

import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f170533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f170534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f170535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f170536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleOwner f170537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f170538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.api.mall.j f170539i;

    public static final class a {
    }

    static {
    }

    public h() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L24;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f170531a, r101.f170531a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170532b, r101.f170532b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170533c, r101.f170533c) == true) goto L12;
        return false;
    L12:
        if (this.f170534d == r101.f170534d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170535e, r101.f170535e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170536f, r101.f170536f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f170537g, r101.f170537g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f170538h, r101.f170538h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f170539i, r101.f170539i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        String r100 = this.f170531a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f170532b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f170533c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f170534d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f170535e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f170536f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        LifecycleOwner r119 = this.f170537g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        f r122 = this.f170538h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        com.bytedance.android.shopping.api.mall.j r125 = this.f170539i;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
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
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallGulConfig(pageName=" + this.f170531a + ", enterFrom=" + this.f170532b + ", ecomSceneId=" + this.f170533c + ", isDarkMode=" + this.f170534d + ", queryParams=" + this.f170535e + ", title=" + this.f170536f + ", lifeCycleOwner=" + this.f170537g + ", stateListener=" + this.f170538h + ", loadMoreContainer=" + this.f170539i + ")";
    }

    public h(String r100, String r101, boolean r102, LifecycleOwner r103, com.bytedance.android.shopping.collect.custom_view.d r104) {
        Intrinsics.checkNotNullParameter("collect_list_page", "pageName");
        Intrinsics.checkNotNullParameter(r103, "lifeCycleOwner");
        this.f170531a = "collect_list_page";
        this.f170532b = r100;
        this.f170533c = r101;
        this.f170534d = r102;
        this.f170535e = null;
        this.f170536f = null;
        this.f170537g = r103;
        this.f170538h = r104;
        this.f170539i = null;
    }
}
