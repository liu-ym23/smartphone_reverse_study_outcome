package com.bytedance.android.shopping.api.mall.common.tools;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f170423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f170424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f170425c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f170423a, r101.f170423a) == true) goto L8;
        return false;
    L8:
        if (this.f170424b == r101.f170424b) goto L10;
        return false;
    L10:
        if (this.f170425c == r101.f170425c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        Map<String, Object> r100 = this.f170423a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f170424b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f170425c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "CategoryTabClickInfo(tabInfo=" + this.f170423a + ", isGuideIconShowing=" + this.f170424b + ", forceRefresh=" + this.f170425c + ")";
    }

    public c(Map<String, ? extends Object> r100, boolean r101, boolean r102) {
        this.f170423a = r100;
        this.f170424b = r101;
        this.f170425c = r102;
    }
}
