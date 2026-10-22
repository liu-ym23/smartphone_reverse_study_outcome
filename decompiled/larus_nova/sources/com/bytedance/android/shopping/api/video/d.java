package com.bytedance.android.shopping.api.video;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f170641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f170642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f170643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f170644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f170645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f170646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f170647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f170648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bundle f170649i;

    public d() {
        this(false, false, 0, 0, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (this.f170641a == r101.f170641a) goto L8;
        return false;
    L8:
        if (this.f170642b == r101.f170642b) goto L10;
        return false;
    L10:
        if (this.f170643c == r101.f170643c) goto L12;
        return false;
    L12:
        if (this.f170644d == r101.f170644d) goto L14;
        return false;
    L14:
        if (this.f170645e == r101.f170645e) goto L16;
        return false;
    L16:
        if (this.f170646f == r101.f170646f) goto L18;
        return false;
    L18:
        if (this.f170647g == r101.f170647g) goto L20;
        return false;
    L20:
        if (this.f170648h == r101.f170648h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f170649i, r101.f170649i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f170641a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f170642b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (((((((r103 + r105) * 31) + this.f170643c) * 31) + this.f170644d) * 31) + this.f170645e) * 31;
        boolean r107 = this.f170646f;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f170647g;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f170648h;
        if (r113 == true) goto L18;
        r101 = r113;
    L18:
        int r114 = (r112 + r101) * 31;
        Bundle r115 = this.f170649i;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L23:
        return r114 + r116;
    L21:
        r116 = 0;
        goto L23
    }

    public final String toString() {
        return "ECPlayerOptions(mute=" + this.f170641a + ", loop=" + this.f170642b + ", initialStartTimeMs=" + this.f170643c + ", loopPlayStartTime=" + this.f170644d + ", loopPlayEndTime=" + this.f170645e + ", isAudioOnly=" + this.f170646f + ", needCookie=" + this.f170647g + ", isSharePlayer=" + this.f170648h + ", gaussianParams=" + this.f170649i + ")";
    }

    public d(boolean r100, boolean r101, int r102, int r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r103 = -1;
    L15:
        if ((r105 & 128) == 0) goto L17;
        r104 = false;
    L17:
        this.f170641a = r100;
        this.f170642b = r101;
        this.f170643c = 0;
        this.f170644d = r102;
        this.f170645e = r103;
        this.f170646f = false;
        this.f170647g = false;
        this.f170648h = r104;
        this.f170649i = null;
    }
}
