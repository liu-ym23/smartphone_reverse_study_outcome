package com.bytedance.android.shopping.deepfeed.slice.view.list;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f173590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f173591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f173592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pair<String, Map<String, Object>> f173593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pair<String, Map<String, Object>> f173594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f173595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f173596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f173597h;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L22;
        c r101 = (c) r100;
        if (this.f173590a == r101.f173590a) goto L8;
        return false;
    L8:
        if (this.f173591b == r101.f173591b) goto L10;
        return false;
    L10:
        if (this.f173592c == r101.f173592c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f173593d, r101.f173593d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f173594e, r101.f173594e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f173595f, r101.f173595f) == true) goto L18;
        return false;
    L18:
        if (this.f173596g == r101.f173596g) goto L20;
        return false;
    L20:
        if (this.f173597h == r101.f173597h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f173590a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f173591b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f173592c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        Pair<String, Map<String, Object>> r110 = this.f173593d;
        int r111 = 0;
        if (r110 == null) goto L14;
        int r112 = r110.hashCode();
    L15:
        int r113 = (r109 + r112) * 31;
        Pair<String, Map<String, Object>> r114 = this.f173594e;
        if (r114 == null) goto L18;
        int r115 = r114.hashCode();
    L19:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f173595f;
        if (r117 == null) goto L22;
        r111 = r117.hashCode();
    L22:
        int r118 = (r116 + r111) * 31;
        boolean r119 = this.f173596g;
        ?? r120 = r119;
        if (r119 == false) goto L25;
        r120 = 1;
    L25:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f173597h;
        if (r122 == true) goto L30;
        r101 = r122;
    L30:
        return r121 + r101;
    L18:
        r115 = 0;
        goto L19
    L14:
        r112 = 0;
        goto L15
    }

    public final String toString() {
        return "DeepFeedSlcListData(visible=" + this.f173590a + ", loopScroll=" + this.f173591b + ", footer=" + this.f173592c + ", action=" + this.f173593d + ", slideAction=" + this.f173594e + ", scrollToIndex=" + this.f173595f + ", syncSelectedToState=" + this.f173596g + ", keepPositionOnStop=" + this.f173597h + ")";
    }

    public /* synthetic */ c(int r110) {
        this(false, false, false, null, null, null, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(boolean r100, boolean r101, boolean r102, Pair<String, ? extends Map<String, ? extends Object>> r103, Pair<String, ? extends Map<String, ? extends Object>> r104, Integer r105, boolean r106, boolean r107) {
        this.f173590a = r100;
        this.f173591b = r101;
        this.f173592c = r102;
        this.f173593d = r103;
        this.f173594e = r104;
        this.f173595f = r105;
        this.f173596g = r106;
        this.f173597h = r107;
    }
}
