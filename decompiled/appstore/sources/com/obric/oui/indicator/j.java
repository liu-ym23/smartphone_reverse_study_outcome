package com.obric.oui.indicator;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15066a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f15069c;

        public a(int r10, int r11, float r12) {
            this.f15067a = r10;
            this.f15068b = r11;
            this.f15069c = r12;
        }

        public final int a() {
            return this.f15068b;
        }

        public final float b() {
            return this.f15069c;
        }

        public final int c() {
            return this.f15067a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f15067a == r11.f15067a) goto L12;
            return false;
        L12:
            if (this.f15068b == r11.f15068b) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f15069c), Float.valueOf(r11.f15069c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f15067a) * 31) + Integer.hashCode(this.f15068b)) * 31) + Float.hashCode(this.f15069c);
        }

        public String toString() {
            return "ScrollState(selectedPosition=" + this.f15067a + ", nextPosition=" + this.f15068b + ", positionOffset=" + this.f15069c + ')';
        }
    }

    public j() {
        this.f15066a = "OnPageChangeHelper";
    }

    public abstract int a();

    public final void b(int r10, float r11) {
        a r12 = d(r10, r11);
        if (r12 != null) goto L13;
        return;
    L13:
        c(r12.c(), r12.a(), r12.b());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == false) goto L11;
        tc.d.f24779a.d(this.f15066a, q.p("OIndicator: ", e.getMessage()));
        return;
    L11:
        tc.d.f24779a.b(this.f15066a, "抓住了一个Exception并ignore", e);
    }

    public abstract void c(int r10, int r11, float r12);

    public final a d(int r10, float r11) {
        int r12 = a();
        if (r12 > 0) goto L7;
        tc.d.f24779a.d(this.f15066a, q.p("Ignore onPageScrolled because pageCount=", Integer.valueOf(r12)));
        return null;
    L7:
        if (r12 == 1) goto L9;
        int r13 = r12 - 1;
        if (r10 < 0) goto L21;
        if (r10 > r13) goto L21;
        if (r10 == r13) goto L15;
    L17:
        if (r10 != r13) goto L20;
        return new a(r13, r13, 0.0f);
    L20:
        return new a(r10, r10 + 1, r11);
    L15:
        if (r11 <= 0.0f) goto L17;
        return new a(r13, 0, r11);
    L21:
        tc.d.f24779a.d(this.f15066a, "Ignore onPageScrolled because position=" + r10 + ", pageCount=" + r12);
        return null;
    L9:
        return new a(0, 0, 0.0f);
    }
}
