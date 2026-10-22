package com.bytedance.android.shopping.api.mall.idl;

import com.bytedance.android.ec.hybrid.list.entity.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f170548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f170549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f170550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f170551d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f170548a, r101.f170548a) == true) goto L8;
        return false;
    L8:
        if (this.f170549b == r101.f170549b) goto L10;
        return false;
    L10:
        if (this.f170550c == r101.f170550c) goto L12;
        return false;
    L12:
        if (this.f170551d == r101.f170551d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        k r100 = this.f170548a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f170549b) * 31;
        boolean r103 = this.f170550c;
        ?? r104 = r103;
        if (r103 == false) goto L9;
        r104 = 1;
    L9:
        int r105 = (r102 + r104) * 31;
        long r106 = this.f170551d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSaasStraightOutCache(listVo=" + this.f170548a + ", cursor=" + this.f170549b + ", hasMore=" + this.f170550c + ", createTime=" + this.f170551d + ")";
    }

    public b(k r100, int r101, boolean r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "listVo");
        this.f170548a = r100;
        this.f170549b = r101;
        this.f170550c = r102;
        this.f170551d = r103;
    }
}
