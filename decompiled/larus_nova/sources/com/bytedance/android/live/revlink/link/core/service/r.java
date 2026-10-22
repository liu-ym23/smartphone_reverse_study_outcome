package com.bytedance.android.live.revlink.link.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f98381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f98382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f98383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f98384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f98385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f98386f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L18;
        r r101 = (r) r100;
        if (this.f98381a == r101.f98381a) goto L8;
        return false;
    L8:
        if (this.f98382b == r101.f98382b) goto L10;
        return false;
    L10:
        if (this.f98383c == r101.f98383c) goto L12;
        return false;
    L12:
        if (this.f98384d == r101.f98384d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f98385e, r101.f98385e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f98386f, r101.f98386f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = ((((this.f98381a * 31) + this.f98382b) * 31) + this.f98383c) * 31;
        boolean r101 = this.f98384d;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f98385e;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        o r108 = this.f98386f;
        if (r108 == null) goto L13;
        r105 = r108.hashCode();
    L13:
        return r107 + r105;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "LocalLayoutInfo(uiLayout=" + this.f98381a + ", range=" + this.f98382b + ", updateType=" + this.f98383c + ", isOrientation=" + this.f98384d + ", bigAnchorId=" + this.f98385e + ", layoutDetails=" + this.f98386f + ")";
    }

    public r(int r100, int r101, int r102, boolean r103, String r104, o r105) {
        Intrinsics.checkNotNullParameter(r105, "layoutDetails");
        this.f98381a = r100;
        this.f98382b = r101;
        this.f98383c = r102;
        this.f98384d = r103;
        this.f98385e = r104;
        this.f98386f = r105;
    }
}
