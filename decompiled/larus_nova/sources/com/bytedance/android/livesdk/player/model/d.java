package com.bytedance.android.livesdk.player.model;

import android.view.Surface;
import android.view.SurfaceHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f155636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f155637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f155638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f155639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Surface f155640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SurfaceHolder f155641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f155642g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Float.compare(this.f155636a, r101.f155636a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f155637b, r101.f155637b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f155638c, r101.f155638c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f155639d, r101.f155639d) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f155640e, r101.f155640e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f155641f, r101.f155641f) == true) goto L18;
        return false;
    L18:
        if (this.f155642g == r101.f155642g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((Float.floatToIntBits(this.f155636a) * 31) + Float.floatToIntBits(this.f155637b)) * 31) + Float.floatToIntBits(this.f155638c)) * 31) + Float.floatToIntBits(this.f155639d)) * 31;
        Surface r101 = this.f155640e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        SurfaceHolder r105 = this.f155641f;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((r104 + r102) * 31) + this.f155642g;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ExtraSurfaceParams(x=" + this.f155636a + ", y=" + this.f155637b + ", width=" + this.f155638c + ", hight=" + this.f155639d + ", surface=" + this.f155640e + ", surfaceHolder=" + this.f155641f + ", cropType=" + this.f155642g + ")";
    }

    public d(float r100, float r101, float r102, float r103, Surface r104, int r105, int r106) {
        if ((r106 & 16) == 0) goto L6;
        r104 = null;
    L6:
        if ((r106 & 64) == 0) goto L8;
        r105 = 0;
    L8:
        this.f155636a = r100;
        this.f155637b = r101;
        this.f155638c = r102;
        this.f155639d = r103;
        this.f155640e = r104;
        this.f155641f = null;
        this.f155642g = r105;
    }
}
