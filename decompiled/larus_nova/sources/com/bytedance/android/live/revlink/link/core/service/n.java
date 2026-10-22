package com.bytedance.android.live.revlink.link.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f98356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t51.e f98357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t51.b f98358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t51.b f98359d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f98356a, r101.f98356a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98357b, r101.f98357b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98358c, r101.f98358c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98359d, r101.f98359d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        q r100 = this.f98356a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t51.e r104 = this.f98357b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        t51.b r107 = this.f98358c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        t51.b r110 = this.f98359d;
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
        return "LayoutConfigFrame(state=" + this.f98356a + ", displayRegion=" + this.f98357b + ", mixStreamRegion=" + this.f98358c + ", seiRegion=" + this.f98359d + ")";
    }

    public n(q r100, t51.e r101, t51.b r102, t51.b r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "displayRegion");
        Intrinsics.checkNotNullParameter(r102, "mixStreamRegion");
        Intrinsics.checkNotNullParameter(r103, "seiRegion");
        this.f98356a = r100;
        this.f98357b = r101;
        this.f98358c = r102;
        this.f98359d = r103;
    }
}
