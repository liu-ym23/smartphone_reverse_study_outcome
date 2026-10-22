package com.obric.oui.shadow;

import android.content.res.TypedArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0207a f16761g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f16763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16767f;

    /* JADX INFO: renamed from: com.obric.oui.shadow.a$a, reason: collision with other inner class name */
    public static final class C0207a {
        public /* synthetic */ C0207a(DefaultConstructorMarker r10) {
            this();
        }

        public final a a(TypedArray r10, int r11, int r12, int r13, int r14, int r15) {
            q.g(r10, "typedArray");
            b r16 = b.c(r10, r11, r12, r13, r14, r15);
            q.f(r16, "result");
            return c.a(r16);
        }

        public final int[] b(a r10) {
            q.g(r10, "shadowConfig");
            b r11 = r10.h();
            int[] r12 = b.g(r11);
            r10.g(r11.d());
            q.f(r12, "result");
            return r12;
        }

        public C0207a() {
        }
    }

    static {
        f16761g = new C0207a(null);
    }

    public a(float r10, float r11, float r12, int r13, float r14, int r15) {
        this.f16762a = r10;
        this.f16763b = r11;
        this.f16764c = r12;
        this.f16765d = r13;
        this.f16766e = r14;
        this.f16767f = r15;
    }

    public static final a a(TypedArray r10, int r11, int r12, int r13, int r14, int r15) {
        return f16761g.a(r10, r11, r12, r13, r14, r15);
    }

    public final float b() {
        return this.f16764c;
    }

    public final int c() {
        return this.f16765d;
    }

    public final float d() {
        return this.f16766e;
    }

    public final float e() {
        return this.f16762a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (q.b(Float.valueOf(this.f16762a), Float.valueOf(r11.f16762a)) == true) goto L12;
        return false;
    L12:
        if (q.b(Float.valueOf(this.f16763b), Float.valueOf(r11.f16763b)) == true) goto L15;
        return false;
    L15:
        if (q.b(Float.valueOf(this.f16764c), Float.valueOf(r11.f16764c)) == true) goto L18;
        return false;
    L18:
        if (this.f16765d == r11.f16765d) goto L21;
        return false;
    L21:
        if (q.b(Float.valueOf(this.f16766e), Float.valueOf(r11.f16766e)) == true) goto L24;
        return false;
    L24:
        if (this.f16767f == r11.f16767f) goto L26;
        return false;
    L26:
        return true;
    }

    public final float f() {
        return this.f16763b;
    }

    public final void g(int r10) {
        this.f16767f = r10;
    }

    public final b h() {
        return new b(this.f16762a, this.f16763b, this.f16764c, this.f16765d, this.f16766e, this.f16767f);
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f16762a) * 31) + Float.hashCode(this.f16763b)) * 31) + Float.hashCode(this.f16764c)) * 31) + Integer.hashCode(this.f16765d)) * 31) + Float.hashCode(this.f16766e)) * 31) + Integer.hashCode(this.f16767f);
    }

    public String toString() {
        return "ShadowConfig(x=" + this.f16762a + ", y=" + this.f16763b + ", blurRadius=" + this.f16764c + ", color=" + this.f16765d + ", spread=" + this.f16766e + ", blendMode=" + this.f16767f + ')';
    }
}
