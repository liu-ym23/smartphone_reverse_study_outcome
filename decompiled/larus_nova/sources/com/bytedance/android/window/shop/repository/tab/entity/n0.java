package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f189607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.window.shop.c f189608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.list.entity.k f189609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.list.entity.k f189610d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L14;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f189607a, r101.f189607a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f189608b, r101.f189608b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f189609c, r101.f189609c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f189610d, r101.f189610d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<f> r100 = this.f189607a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.window.shop.c r104 = this.f189608b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.android.ec.hybrid.list.entity.k r107 = this.f189609c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.ec.hybrid.list.entity.k r110 = this.f189610d;
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
        return "WindowVOWrapper(list=" + this.f189607a + ", type=" + this.f189608b + ", hybridList=" + this.f189609c + ", topHybridList=" + this.f189610d + ")";
    }

    public final com.bytedance.android.window.shop.c getType() {
        return this.f189608b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(List<? extends f> r100, com.bytedance.android.window.shop.c r101, com.bytedance.android.ec.hybrid.list.entity.k r102, com.bytedance.android.ec.hybrid.list.entity.k r103) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f189607a = r100;
        this.f189608b = r101;
        this.f189609c = r102;
        this.f189610d = r103;
    }

    public /* synthetic */ n0(List r100, com.bytedance.android.window.shop.c r101, com.bytedance.android.ec.hybrid.list.entity.k r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102, null);
    }
}
