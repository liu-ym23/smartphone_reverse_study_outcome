package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ShadowConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0990a f36179a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f36180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f36181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f36182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36183e;
    private float f;
    private int g;

    /* JADX INFO: renamed from: com.obric.oui.shadow.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShadowConfig.kt */
    public static final class C0990a {
        public /* synthetic */ C0990a(h r1) {
            this();
        }

        private C0990a() {
        }

        public final a a(TypedArray r1, int r2, int r3, int r4, int r5, int r6) {
            o.e(r1, "typedArray");
            b r0 = b.a(r1, r2, r3, r4, r5, r6);
            o.c(r0, "result");
            return c.a(r0);
        }

        public final int[] a(a r2) {
            o.e(r2, "shadowConfig");
            b r1 = r2.f();
            int[] r0 = b.b(r1);
            r2.a(r1.f());
            o.c(r0, "result");
            return r0;
        }
    }

    static {
        f36179a = new C0990a(null);
    }

    public static final a a(TypedArray r7, int r8, int r9, int r10, int r11, int r12) {
        return f36179a.a(r7, r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(this.f36180b), Float.valueOf(r6.f36180b)) == true) goto L12;
        return false;
    L12:
        if (o.a(Float.valueOf(this.f36181c), Float.valueOf(r6.f36181c)) == true) goto L15;
        return false;
    L15:
        if (o.a(Float.valueOf(this.f36182d), Float.valueOf(r6.f36182d)) == true) goto L18;
        return false;
    L18:
        if (this.f36183e == r6.f36183e) goto L21;
        return false;
    L21:
        if (o.a(Float.valueOf(this.f), Float.valueOf(r6.f)) == true) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f36180b) * 31) + Float.hashCode(this.f36181c)) * 31) + Float.hashCode(this.f36182d)) * 31) + Integer.hashCode(this.f36183e)) * 31) + Float.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ShadowConfig(x=" + this.f36180b + ", y=" + this.f36181c + ", blurRadius=" + this.f36182d + ", color=" + this.f36183e + ", spread=" + this.f + ", blendMode=" + this.g + ')';
    }

    public a(float r1, float r2, float r3, int r4, float r5, int r6) {
        this.f36180b = r1;
        this.f36181c = r2;
        this.f36182d = r3;
        this.f36183e = r4;
        this.f = r5;
        this.g = r6;
    }

    public final float a() {
        return this.f36180b;
    }

    public final float b() {
        return this.f36181c;
    }

    public final float c() {
        return this.f36182d;
    }

    public final int d() {
        return this.f36183e;
    }

    public final float e() {
        return this.f;
    }

    public final void a(int r1) {
        this.g = r1;
    }

    public final b f() {
        return new b(this.f36180b, this.f36181c, this.f36182d, this.f36183e, this.f, this.g);
    }
}
