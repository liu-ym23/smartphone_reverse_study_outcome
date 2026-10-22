package com.bytedance.android.live.browser;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f64148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f64149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f64150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f64151d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (this.f64148a == r101.f64148a) goto L8;
        return false;
    L8:
        if (this.f64149b == r101.f64149b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f64150c, r101.f64150c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f64151d, r101.f64151d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r100 = this.f64148a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f64149b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        List<String> r106 = this.f64150c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        List<String> r110 = this.f64151d;
        if (r110 == null) goto L17;
        r107 = r110.hashCode();
    L17:
        return r109 + r107;
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "CacheConfigItem(disablePrefetchInject=" + this.f64148a + ", disableStorageInject=" + this.f64149b + ", apiStorageKeys=" + this.f64150c + ", localStorageKeys=" + this.f64151d + ")";
    }

    public m(boolean r100, boolean r101, List<String> r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r102, "apiStorageKeys");
        Intrinsics.checkNotNullParameter(r103, "localStorageKeys");
        this.f64148a = r100;
        this.f64149b = r101;
        this.f64150c = r102;
        this.f64151d = r103;
    }
}
