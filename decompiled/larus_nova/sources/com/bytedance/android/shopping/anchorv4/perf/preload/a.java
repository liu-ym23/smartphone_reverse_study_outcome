package com.bytedance.android.shopping.anchorv4.perf.preload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f167307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f167308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167309c;

    public final int hashCode() {
        int r100 = this.f167309c.hashCode();
        String r101 = this.f167308b;
        boolean r102 = true;
        int r103 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        String r105 = this.f167308b;
    L20:
        int r106 = r100 * 31;
        if (r105 == null) goto L24;
        r103 = r105.hashCode();
    L24:
        return r106 + r103;
    L11:
        String r107 = this.f167307a;
        if (r107 != null) goto L14;
    L17:
        if (r102 == true) goto L19;
        r105 = this.f167307a;
        goto L20
    L19:
        r105 = null;
        goto L20
    L14:
        if (r107.length() == 0) goto L17;
        r102 = false;
        goto L17
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public final String toString() {
        return "CacheKey(promotionId:" + this.f167307a + ", productId:" + this.f167308b + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if ((!Intrinsics.areEqual(this.f167309c, r101.f167309c)) == false) goto L11;
        return false;
    L11:
        String r102 = this.f167308b;
        if (r102 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
    L24:
        String r104 = this.f167307a;
        if (r104 != null) goto L27;
    L30:
        boolean r105 = true;
    L31:
        if (r105 == false) goto L33;
    L37:
        return false;
    L33:
        if (Intrinsics.areEqual(this.f167307a, r101.f167307a) == false) goto L35;
    L36:
        return true;
    L35:
        if (Intrinsics.areEqual(this.f167307a, r101.f167308b) == false) goto L37;
    L27:
        if (r104.length() == 0) goto L30;
        r105 = false;
        goto L31
    L20:
        if (Intrinsics.areEqual(this.f167308b, r101.f167308b) == false) goto L22;
    L23:
        return true;
    L22:
        if (Intrinsics.areEqual(this.f167308b, r101.f167307a) == false) goto L24;
    L14:
        if (r102.length() == 0) goto L17;
        r103 = false;
        goto L18
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f167307a = r100;
        this.f167308b = r101;
        this.f167309c = r102;
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L18;
        if (r101 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("promotionId 和 productId 不能都为空");
    L12:
        if (r101.length() != 0) goto L14;
    L18:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
