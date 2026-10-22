package com.bytedance.android.ec.core.widget;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f46063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f46064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f46068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f46069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f46070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f46071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Float f46072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f46073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f46074l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L30;
        b r101 = (b) r100;
        if (Float.compare(this.f46063a, r101.f46063a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f46064b, r101.f46064b) == 0) goto L10;
        return false;
    L10:
        if (this.f46065c == r101.f46065c) goto L12;
        return false;
    L12:
        if (this.f46066d == r101.f46066d) goto L14;
        return false;
    L14:
        if (this.f46067e == r101.f46067e) goto L16;
        return false;
    L16:
        if (this.f46068f == r101.f46068f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f46069g, r101.f46069g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f46070h, r101.f46070h) == true) goto L22;
        return false;
    L22:
        if (Float.compare(this.f46071i, r101.f46071i) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f46072j, r101.f46072j) == true) goto L26;
        return false;
    L26:
        if (this.f46073k == r101.f46073k) goto L28;
        return false;
    L28:
        if (this.f46074l == r101.f46074l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((((((((Float.floatToIntBits(this.f46063a) * 31) + Float.floatToIntBits(this.f46064b)) * 31) + this.f46065c) * 31) + this.f46066d) * 31) + this.f46067e) * 31;
        boolean r101 = this.f46068f;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        float[] r105 = this.f46069g;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = Arrays.hashCode(r105);
    L9:
        int r108 = (r104 + r107) * 31;
        float[] r109 = this.f46070h;
        if (r109 == null) goto L12;
        int r110 = Arrays.hashCode(r109);
    L13:
        int r111 = (((r108 + r110) * 31) + Float.floatToIntBits(this.f46071i)) * 31;
        Float r112 = this.f46072j;
        if (r112 == null) goto L16;
        r106 = r112.hashCode();
    L16:
        int r113 = (r111 + r106) * 31;
        boolean r114 = this.f46073k;
        ?? r115 = r114;
        if (r114 == false) goto L19;
        r115 = 1;
    L19:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f46074l;
        if (r117 == true) goto L24;
        r102 = r117;
    L24:
        return r116 + r102;
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "ECHotAtmosphereUIConfig(topImageHeight=" + this.f46063a + ", bgHeight=" + this.f46064b + ", xFontSize=" + this.f46065c + ", numFontSize=" + this.f46066d + ", appendFontSize=" + this.f46067e + ", useColors=" + this.f46068f + ", linearColorPosition=" + Arrays.toString(this.f46069g) + ", radius=" + Arrays.toString(this.f46070h) + ", hotIconMarginRightDp=" + this.f46071i + ", paddingRightDp=" + this.f46072j + ", disableBackground=" + this.f46073k + ", disableBorder=" + this.f46074l + ")";
    }

    public b(float r100, int r101, int r102, float[] r103, float r104, Float r105, boolean r106, boolean r107) {
        this.f46063a = 14.0f;
        this.f46064b = r100;
        this.f46065c = r101;
        this.f46066d = r102;
        this.f46067e = 13;
        this.f46068f = false;
        this.f46069g = null;
        this.f46070h = r103;
        this.f46071i = r104;
        this.f46072j = r105;
        this.f46073k = r106;
        this.f46074l = r107;
    }
}
