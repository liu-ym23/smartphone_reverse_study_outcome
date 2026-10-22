package com.bytedance.android.shopping.api.mall.feed;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f170507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f170508c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f170506a, r101.f170506a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170507b, r101.f170507b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170508c, r101.f170508c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170506a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f170507b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f170508c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallFeedApiCacheConfig(subKey=" + this.f170506a + ", capacity=" + this.f170507b + ", validPeriod=" + this.f170508c + ")";
    }

    public a(String r100, Integer r101, Long r102) {
        this.f170506a = r100;
        this.f170507b = r101;
        this.f170508c = r102;
    }
}
