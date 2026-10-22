package com.bytedance.android.live.core.gl.core.shader;

import android.opengl.GLES20;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f64813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f64814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f64815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f64816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f64817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f64818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f64819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f64820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f64821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f64822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f64823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f64824m;

    public abstract void c();

    public abstract void d(f r100, d r101, n50.b r102);

    public abstract void e();

    public a() {
        this.f64812a = getClass().getName();
        this.f64822k = new float[16];
        this.f64824m = -1;
    }

    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        if (this.f64824m != r100.f501811b) goto L6;
        return;
    L6:
        if (this.f64823l == true) goto L8;
        c();
        this.f64823l = true;
    L8:
        String r101 = this.f64814c;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vertexShader");
    L11:
        this.f64817f = b(35633, r101);
        String r102 = this.f64815d;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentShader");
    L14:
        this.f64818g = b(35632, r102);
        int r103 = GLES20.glCreateProgram();
        if (r103 == 0) goto L28;
        GLES20.glAttachShader(r103, this.f64817f);
        GLES20.glAttachShader(r103, this.f64818g);
        String[] r104 = this.f64813b;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("attributes");
    L19:
        int r105 = r104.length;
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L25;
        String[] r107 = this.f64813b;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("attributes");
    L24:
        GLES20.glBindAttribLocation(r103, r106, r107[r106]);
        r106 = r106 + 1;
        goto L20
    L25:
        GLES20.glLinkProgram(r103);
        int[] r108 = new int[1];
        GLES20.glGetProgramiv(r103, 35714, r108, 0);
        if (r108[0] != 0) goto L28;
        int r109 = v50.b.f553230a;
        Intrinsics.checkNotNullParameter("Error compiling program: " + GLES20.glGetProgramInfoLog(r103), "message");
        GLES20.glDeleteProgram(r103);
        r103 = 0;
    L28:
        if (r103 == 0) goto L32;
        this.f64816e = r103;
        this.f64824m = r100.f501811b;
        return;
    L32:
        throw new RuntimeException("Error creating shader program.");
    }

    public final int b(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 == 0) goto L7;
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L7;
        String r104 = GLES20.glGetShaderInfoLog(r102);
        GLES20.glDeleteShader(r102);
        r102 = 0;
    L8:
        if (r102 == 0) goto L11;
        return r102;
    L11:
        throw new RuntimeException("Error creating shader " + this.f64812a + ": " + r104);
    L7:
        r104 = null;
        goto L8
    }
}
