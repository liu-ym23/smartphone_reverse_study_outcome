package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f173507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f173508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f173509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f173510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f173511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f173512f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L18;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f173507a, r101.f173507a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173508b, r101.f173508b) == true) goto L10;
        return false;
    L10:
        if (this.f173509c == r101.f173509c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f173510d, r101.f173510d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f173511e, r101.f173511e) == true) goto L16;
        return false;
    L16:
        if (this.f173512f == r101.f173512f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        j r100 = this.f173507a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        j r104 = this.f173508b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f173509c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f173510d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f173511e;
        if (r113 == null) goto L20;
        r101 = r113.hashCode();
    L20:
        int r114 = (r112 + r101) * 31;
        long r115 = this.f173512f;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedScrollNumberConfig(integer=" + this.f173507a + ", decimal=" + this.f173508b + ", animate=" + this.f173509c + ", textColor=" + this.f173510d + ", textAlign=" + this.f173511e + ", delayMs=" + this.f173512f + ")";
    }

    public g(j r100, j r101, boolean r102, String r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "integer");
        Intrinsics.checkNotNullParameter(r101, "decimal");
        this.f173507a = r100;
        this.f173508b = r101;
        this.f173509c = r102;
        this.f173510d = r103;
        this.f173511e = r104;
        this.f173512f = r105;
    }
}
