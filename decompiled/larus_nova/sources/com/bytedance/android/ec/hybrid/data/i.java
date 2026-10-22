package com.bytedance.android.ec.hybrid.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f46720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f46721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f46724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f46725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f46726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f46727i;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L22;
        i r101 = (i) r100;
        if (this.f46720b == r101.f46720b) goto L8;
        return false;
    L8:
        if (this.f46721c == r101.f46721c) goto L10;
        return false;
    L10:
        if (this.f46722d == r101.f46722d) goto L12;
        return false;
    L12:
        if (this.f46723e == r101.f46723e) goto L14;
        return false;
    L14:
        if (this.f46724f == r101.f46724f) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f46725g, r101.f46725g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f46726h, r101.f46726h) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f46727i, r101.f46727i) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f46720b;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f46721c;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (((((r103 + r105) * 31) + this.f46722d) * 31) + this.f46723e) * 31;
        boolean r107 = this.f46724f;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        Integer r109 = this.f46725g;
        int r110 = 0;
        if (r109 == null) goto L15;
        int r111 = r109.hashCode();
    L16:
        int r112 = (r108 + r111) * 31;
        Integer r113 = this.f46726h;
        if (r113 == null) goto L19;
        int r114 = r113.hashCode();
    L20:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f46727i;
        if (r116 == null) goto L24;
        r110 = r116.hashCode();
    L24:
        return r115 + r110;
    L19:
        r114 = 0;
        goto L20
    L15:
        r111 = 0;
        goto L16
    }

    public final String toString() {
        return "NAImagePreloadConfig(homePagePreload=" + this.f46720b + ", loadMorePreload=" + this.f46721c + ", slidePreloadNum=" + this.f46722d + ", slideFastPreloadNum=" + this.f46723e + ", promotionImagePreload=" + this.f46724f + ", loadMoreImmPreloadNum=" + this.f46725g + ", loadMoreRadicalizationNum=" + this.f46726h + ", loadMoreRadicalizationScope=" + this.f46727i + ")";
    }

    public final int a() {
        if (this.f46719a != 1) goto L8;
        int r100 = this.f46723e;
        if (r100 <= 0) goto L8;
        return r100;
    L8:
        return this.f46722d;
    }

    public i(int r100) {
        this.f46720b = false;
        this.f46721c = false;
        this.f46722d = 0;
        this.f46723e = 0;
        this.f46724f = false;
        this.f46725g = null;
        this.f46726h = null;
        this.f46727i = null;
        this.f46719a = -1;
    }
}
