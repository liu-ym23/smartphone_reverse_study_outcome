package com.bytedance.android.shopping.skubuy.cache;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f183112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f183114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f183115d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.cache.a$a, reason: collision with other inner class name */
    public static final class C2722a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f183112a, r101.f183112a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f183113b, r101.f183113b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f183114c, r101.f183114c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f183115d, r101.f183115d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f183112a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f183113b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f183114c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f183115d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "StructuredCacheKey(promotionId=" + this.f183112a + ", productId=" + this.f183113b + ", sceneType=" + this.f183114c + ", firstSpecId=" + this.f183115d + ")";
    }

    public final String a() {
        return this.f183112a + '_' + this.f183113b + '_' + this.f183114c + '_' + this.f183115d;
    }

    public a(String r100, String r101, String r102, String r103) {
        this.f183112a = r100;
        this.f183113b = r101;
        this.f183114c = r102;
        this.f183115d = r103;
    }
}
