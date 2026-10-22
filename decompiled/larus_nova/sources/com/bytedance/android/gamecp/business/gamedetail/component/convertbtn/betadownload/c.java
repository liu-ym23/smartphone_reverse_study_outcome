package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f53981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f53984f;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f53979a, r101.f53979a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53980b, r101.f53980b) == true) goto L10;
        return false;
    L10:
        if (this.f53981c == r101.f53981c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53982d, r101.f53982d) == true) goto L14;
        return false;
    L14:
        if (this.f53983e == r101.f53983e) goto L16;
        return false;
    L16:
        if (this.f53984f == r101.f53984f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        Context r100 = this.f53979a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53980b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f53981c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f53982d;
        if (r109 == null) goto L13;
        r101 = r109.hashCode();
    L13:
        int r110 = (((r108 + r101) * 31) + this.f53983e) * 31;
        boolean r111 = this.f53984f;
        ?? r112 = r111;
        if (r111 == false) goto L17;
        r112 = 1;
    L17:
        return r110 + r112;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BetaDownloadClickForPcFCFGIntent(ctx=" + this.f53979a + ", planId=" + this.f53980b + ", supportPlatform=" + this.f53981c + ", openSchema=" + this.f53982d + ", reservedStatus=" + this.f53983e + ", isQualified=" + this.f53984f + ")";
    }

    public c(Context r100, String r101, long r102, String r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53979a = r100;
        this.f53980b = r101;
        this.f53981c = r102;
        this.f53982d = r103;
        this.f53983e = r104;
        this.f53984f = r105;
    }
}
