package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.obric.oui.graphic.BlendMode;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f16769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16773f;

    public b(float r10, float r11, float r12, int r13, float r14) {
        this(r10, r11, r12, r13, r14, -1);
    }

    public static b a(b r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new b(r10.f16768a, r10.f16769b, r10.f16770c, r10.f16771d, r10.f16772e, r10.f16773f);
    }

    public static b[] b(b[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        b[] r11 = new b[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L9;
        r11[r12] = a(r10[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public static b c(TypedArray r10, int r11, int r12, int r13, int r14, int r15) {
        return new b(r10.getDimension(r13, 0.0f), r10.getDimension(r14, 0.0f), r10.getDimension(r12, 0.0f), r10.getColor(r11, 0), r10.getDimension(r15, 0.0f));
    }

    public static int[] g(b r10) {
        if (r10.f16773f != (-1)) goto L6;
        r10.f16773f = BlendMode.SRC_OVER.getPorterDuffMode();
    L6:
        return new int[]{r10.f16771d, r10.f16773f};
    }

    public int d() {
        return this.f16773f;
    }

    public float e() {
        return this.f16770c;
    }

    public int f() {
        return this.f16771d;
    }

    public float h() {
        return this.f16772e;
    }

    public float i() {
        return this.f16768a;
    }

    public float j() {
        return this.f16769b;
    }

    public b(float r10, float r11, float r12, int r13, float r14, int r15) {
        this.f16768a = r10;
        this.f16769b = r11;
        this.f16770c = r12;
        this.f16771d = r13;
        this.f16772e = r14;
        this.f16773f = r15;
    }
}
