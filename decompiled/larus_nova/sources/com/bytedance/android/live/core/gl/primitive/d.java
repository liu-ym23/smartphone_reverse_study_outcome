package com.bytedance.android.live.core.gl.primitive;

import android.opengl.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f64835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f64836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f64837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RotationOrder f64838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f64839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f64840f;

    public final void a() {
        Matrix.rotateM(this.f64839e, 0, this.f64836b.f64841a, 1.0f, 0.0f, 0.0f);
    }

    public final void b() {
        Matrix.rotateM(this.f64839e, 0, this.f64836b.f64842b, 0.0f, 1.0f, 0.0f);
    }

    public final void c() {
        Matrix.rotateM(this.f64839e, 0, this.f64836b.f64843c, 0.0f, 0.0f, 1.0f);
    }

    public d() {
        this.f64835a = new e();
        this.f64836b = new e();
        this.f64837c = new e(1.0f, 1.0f, 1.0f);
        this.f64838d = RotationOrder.XYZ;
        float[] r100 = new float[16];
        this.f64839e = r100;
        Matrix.setIdentityM(r100, 0);
    }

    public final void e(Axis r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "axis");
        int r102 = c.f64833a[r100.ordinal()];
        if (r102 != 1) goto L5;
        e r103 = this.f64835a;
        r103.f64841a = r101;
        r103.f64844d = true;
        return;
    L5:
        if (r102 != 2) goto L7;
        e r104 = this.f64835a;
        r104.f64842b = r101;
        r104.f64844d = true;
        return;
    L7:
        if (r102 != 3) goto L15;
        e r105 = this.f64835a;
        r105.f64843c = r101;
        r105.f64844d = true;
        return;
    }

    public final void d(float r100, float r101, float r102) {
        b r103 = this.f64840f;
        if (r103 == null) goto L5;
        float[] r104 = r103.a(new float[]{r100, r101});
    L6:
        if (r104 != null) goto L8;
        e r105 = this.f64835a;
        r105.f64841a = r100;
        r105.f64842b = r101;
        r105.f64843c = r102;
        r105.f64844d = true;
        return;
    L8:
        e r106 = this.f64835a;
        float r107 = r104[0];
        float r108 = r104[1];
        b r109 = this.f64840f;
        if (r109 == null) goto L11;
        r102 = r109.b(r102);
    L11:
        r106.f64841a = r107;
        r106.f64842b = r108;
        r106.f64843c = r102;
        r106.f64844d = true;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
