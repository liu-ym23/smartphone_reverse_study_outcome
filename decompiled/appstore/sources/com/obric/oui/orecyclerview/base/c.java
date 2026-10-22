package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f15354e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f15356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f15357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f15358d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f15359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f15360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f15361c;

        public b(float r10, float r11, boolean r12) {
            this.f15359a = r10;
            this.f15360b = r11;
            this.f15361c = r12;
        }

        public final float a() {
            return this.f15359a;
        }

        public final float b() {
            return this.f15360b;
        }

        public final boolean c() {
            return this.f15361c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(Float.valueOf(this.f15359a), Float.valueOf(r11.f15359a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f15360b), Float.valueOf(r11.f15360b)) == true) goto L15;
            return false;
        L15:
            if (this.f15361c == r11.f15361c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r10 = ((Float.hashCode(this.f15359a) * 31) + Float.hashCode(this.f15360b)) * 31;
            boolean r11 = this.f15361c;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return r10 + r12;
        }

        public String toString() {
            return "ScrollValue(value=" + this.f15359a + ", velocity=" + this.f15360b + ", isFinished=" + this.f15361c + ')';
        }
    }

    static {
        f15354e = new a(null);
    }

    public c(float r10) {
        this.f15355a = r10;
        this.f15358d = 0.099999994f;
    }

    public final float a() {
        float r10 = Math.abs(this.f15357c);
        float r11 = this.f15358d;
        if (r10 >= r11) goto L7;
        return 0.0f;
    L7:
        return c(((float) Math.log(r11 / Math.abs(this.f15357c))) / ((float) Math.log(this.f15355a)));
    }

    public final void b(float r10, float r11) {
        this.f15356b = r10;
        this.f15357c = r11;
    }

    public final float c(float r10) {
        return this.f15356b + (((this.f15357c * (1.0f / ((float) Math.log(this.f15355a)))) * (((float) Math.pow(this.f15355a, r10)) - 1.0f)) * 1.1111112f);
    }

    public final b d(float r10) {
        float r11 = e(r10);
        float r12 = c(r10);
        if (Math.abs(r11) >= this.f15358d) goto L5;
        boolean r13 = true;
    L7:
        return new b(r12, r11, r13);
    L5:
        r13 = false;
        goto L7
    }

    public final float e(float r10) {
        return this.f15357c * ((float) Math.pow(this.f15355a, r10));
    }

    public /* synthetic */ c(float r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 0.998f;
    L5:
        this(r10);
    }
}
