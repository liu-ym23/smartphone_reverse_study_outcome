package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f53975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53978g;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f53972a, r101.f53972a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53973b, r101.f53973b) == true) goto L10;
        return false;
    L10:
        if (this.f53974c == r101.f53974c) goto L12;
        return false;
    L12:
        if (this.f53975d == r101.f53975d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53976e, r101.f53976e) == true) goto L16;
        return false;
    L16:
        if (this.f53977f == r101.f53977f) goto L18;
        return false;
    L18:
        if (this.f53978g == r101.f53978g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Context r100 = this.f53972a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53973b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f53974c) * 31;
        long r107 = this.f53975d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f53976e;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return ((((r108 + r101) * 31) + this.f53977f) * 31) + this.f53978g;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BetaDownloadClickForOpenIntent(ctx=" + this.f53972a + ", planId=" + this.f53973b + ", testPlanOpenType=" + this.f53974c + ", supportPlatform=" + this.f53975d + ", reserveSuccessOpenSchema=" + this.f53976e + ", reservedStatus=" + this.f53977f + ", gameStage=" + this.f53978g + ")";
    }

    public b(Context r100, String r101, int r102, long r103, String r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53972a = r100;
        this.f53973b = r101;
        this.f53974c = r102;
        this.f53975d = r103;
        this.f53976e = r104;
        this.f53977f = r105;
        this.f53978g = r106;
    }
}
