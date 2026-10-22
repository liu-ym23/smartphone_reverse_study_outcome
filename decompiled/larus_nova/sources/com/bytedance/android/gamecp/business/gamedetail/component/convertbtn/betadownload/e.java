package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f53990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f53994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f53995i;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f53987a, r101.f53987a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53988b, r101.f53988b) == true) goto L10;
        return false;
    L10:
        if (this.f53989c == r101.f53989c) goto L12;
        return false;
    L12:
        if (this.f53990d == r101.f53990d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53991e, r101.f53991e) == true) goto L16;
        return false;
    L16:
        if (this.f53992f == r101.f53992f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53993g, r101.f53993g) == true) goto L20;
        return false;
    L20:
        if (this.f53994h == r101.f53994h) goto L22;
        return false;
    L22:
        if (this.f53995i == r101.f53995i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Context r100 = this.f53987a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53988b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f53989c) * 31;
        long r107 = this.f53990d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f53991e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.f53992f) * 31;
        String r112 = this.f53993g;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return ((((r111 + r101) * 31) + this.f53994h) * 31) + this.f53995i;
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
        return "BetaDownloadClickForQuestionnaireIntent(ctx=" + this.f53987a + ", planId=" + this.f53988b + ", testPlanOpenType=" + this.f53989c + ", supportPlatform=" + this.f53990d + ", reserveSuccessOpenSchema=" + this.f53991e + ", testQualificationType=" + this.f53992f + ", activationCode=" + this.f53993g + ", reservedStatus=" + this.f53994h + ", gameStage=" + this.f53995i + ")";
    }

    public e(Context r100, String r101, int r102, long r103, String r104, int r105, String r106, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53987a = r100;
        this.f53988b = r101;
        this.f53989c = r102;
        this.f53990d = r103;
        this.f53991e = r104;
        this.f53992f = r105;
        this.f53993g = r106;
        this.f53994h = r110;
        this.f53995i = r111;
    }
}
