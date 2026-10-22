package com.bytedance.android.gamecp.base.gamedetail;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f51664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f51665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s0 f51666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s0 f51667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s0 f51668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s0 f51669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s0 f51670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s0 f51671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s0 f51672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f51673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f51674k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v0) == false) goto L28;
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.f51664a, r101.f51664a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51665b, r101.f51665b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f51666c, r101.f51666c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f51667d, r101.f51667d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f51668e, r101.f51668e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f51669f, r101.f51669f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f51670g, r101.f51670g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f51671h, r101.f51671h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f51672i, r101.f51672i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f51673j, r101.f51673j) == true) goto L26;
        return false;
    L26:
        if (this.f51674k == r101.f51674k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Drawable r100 = this.f51664a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        s0 r104 = this.f51665b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        s0 r107 = this.f51666c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        s0 r110 = this.f51667d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        s0 r113 = this.f51668e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        s0 r116 = this.f51669f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        s0 r119 = this.f51670g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        s0 r122 = this.f51671h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        s0 r125 = this.f51672i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        s0 r128 = this.f51673j;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        int r129 = (r127 + r101) * 31;
        boolean r130 = this.f51674k;
        ?? r131 = r130;
        if (r130 == false) goto L45;
        r131 = 1;
    L45:
        return r129 + r131;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "NewBottomDetailDownloadViewStyle(progressDrawable=" + this.f51664a + ", supportStyle=" + this.f51665b + ", downloadingStyle=" + this.f51666c + ", pauseStyle=" + this.f51667d + ", installStyle=" + this.f51668e + ", openStyle=" + this.f51669f + ", updateStyle=" + this.f51670g + ", retryStyle=" + this.f51671h + ", waitWifiStyle=" + this.f51672i + ", unSupportStyle=" + this.f51673j + ", isBetaDownload=" + this.f51674k + ")";
    }

    public v0(Drawable r100, b1 r101, b1 r102, b1 r103, b1 r104, b1 r105, b1 r106, b1 r110, b1 r111, b1 r112, boolean r113, int r114) {
        if ((r114 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r114 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r114 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r114 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r114 & 64) == 0) goto L18;
        r106 = null;
    L18:
        if ((r114 & 128) == 0) goto L21;
        r110 = null;
    L21:
        if ((r114 & 256) == 0) goto L24;
        r111 = null;
    L24:
        if ((r114 & 1024) == 0) goto L26;
        r113 = false;
    L26:
        Intrinsics.checkNotNullParameter(r100, "progressDrawable");
        Intrinsics.checkNotNullParameter(r101, "supportStyle");
        Intrinsics.checkNotNullParameter(r112, "unSupportStyle");
        this.f51664a = r100;
        this.f51665b = r101;
        this.f51666c = r102;
        this.f51667d = r103;
        this.f51668e = r104;
        this.f51669f = r105;
        this.f51670g = r106;
        this.f51671h = r110;
        this.f51672i = r111;
        this.f51673j = r112;
        this.f51674k = r113;
    }
}
