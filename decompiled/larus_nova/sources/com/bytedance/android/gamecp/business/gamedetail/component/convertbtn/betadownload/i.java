package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f54007e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f54011d;

    public static final class a {
        public static com.bytedance.ies.sve_core.u a() {
            return new com.bytedance.ies.sve_core.u("pc_game_qualification_state");
        }
    }

    static {
    }

    public i() {
        this(false, "", 0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (this.f54008a == r101.f54008a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54009b, r101.f54009b) == true) goto L10;
        return false;
    L10:
        if (this.f54010c == r101.f54010c) goto L12;
        return false;
    L12:
        if (this.f54011d == r101.f54011d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f54008a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f54009b;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (((r103 + r105) * 31) + this.f54010c) * 31;
        boolean r107 = this.f54011d;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "BetaDownloadQualificationPcState(showLoading=" + this.f54008a + ", planId=" + this.f54009b + ", reservedStatus=" + this.f54010c + ", isQualified=" + this.f54011d + ")";
    }

    public i(boolean r100, String r101, int r102, boolean r103) {
        this.f54008a = r100;
        this.f54009b = r101;
        this.f54010c = r102;
        this.f54011d = r103;
    }

    public static i c(i r100, String r101, int r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        boolean r105 = r100.f54008a;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r101 = r100.f54009b;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = r100.f54010c;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = r100.f54011d;
    L15:
        r100.getClass();
        return new i(r105, r101, r102, r103);
    L5:
        r105 = false;
        goto L7
    }
}
