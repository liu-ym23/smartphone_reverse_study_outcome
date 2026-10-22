package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f53965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f53968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f53969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f53970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f53971j;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L26;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f53962a, r101.f53962a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53963b, r101.f53963b) == true) goto L10;
        return false;
    L10:
        if (this.f53964c == r101.f53964c) goto L12;
        return false;
    L12:
        if (this.f53965d == r101.f53965d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53966e, r101.f53966e) == true) goto L16;
        return false;
    L16:
        if (this.f53967f == r101.f53967f) goto L18;
        return false;
    L18:
        if (this.f53968g == r101.f53968g) goto L20;
        return false;
    L20:
        if (this.f53969h == r101.f53969h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53970i, r101.f53970i) == true) goto L24;
        return false;
    L24:
        if (this.f53971j == r101.f53971j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    public final int hashCode() {
        Context r100 = this.f53962a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53963b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f53964c) * 31;
        long r107 = this.f53965d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f53966e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.f53967f) * 31;
        boolean r112 = this.f53968g;
        ?? r113 = r112;
        if (r112 == false) goto L17;
        r113 = 1;
    L17:
        int r114 = (((r111 + r113) * 31) + this.f53969h) * 31;
        String r115 = this.f53970i;
        if (r115 == null) goto L21;
        r101 = r115.hashCode();
    L21:
        return ((r114 + r101) * 31) + this.f53971j;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BetaDownloadClickForFCFGIntent(ctx=" + this.f53962a + ", planId=" + this.f53963b + ", testPlanOpenType=" + this.f53964c + ", supportPlatform=" + this.f53965d + ", reserveSuccessOpenSchema=" + this.f53966e + ", reservedStatus=" + this.f53967f + ", isQualified=" + this.f53968g + ", testQualificationType=" + this.f53969h + ", activationCode=" + this.f53970i + ", gameStage=" + this.f53971j + ")";
    }

    public a(Context r100, String r101, int r102, long r103, String r104, int r105, boolean r106, int r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53962a = r100;
        this.f53963b = r101;
        this.f53964c = r102;
        this.f53965d = r103;
        this.f53966e = r104;
        this.f53967f = r105;
        this.f53968g = r106;
        this.f53969h = r110;
        this.f53970i = r111;
        this.f53971j = r112;
    }
}
