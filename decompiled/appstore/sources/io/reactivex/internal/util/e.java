package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f20732e;

    public e() {
        this(16, 0.75f);
    }

    public static int c(int r10) {
        int r11 = r10 * (-1640531527);
        return r11 ^ (r11 >>> 16);
    }

    public boolean a(Object r10) {
        Object[] r11 = this.f20732e;
        int r12 = this.f20729b;
        int r13 = c(r10.hashCode()) & r12;
        Object r14 = r11[r13];
        if (r14 != null) goto L5;
    L13:
        r11[r13] = r10;
        int r15 = this.f20730c + 1;
        this.f20730c = r15;
        if (r15 < this.f20731d) goto L16;
        d();
    L16:
        return true;
    L5:
        if (r14.equals(r10) == false) goto L7;
        return false;
    L7:
        r13 = (r13 + 1) & r12;
        Object r16 = r11[r13];
        if (r16 == null) goto L13;
        if (r16.equals(r10) == false) goto L7;
        return false;
    }

    public Object[] b() {
        return this.f20732e;
    }

    public void d() {
        Object[] r10 = this.f20732e;
        int r11 = r10.length;
        int r12 = r11 << 1;
        int r13 = r12 - 1;
        Object[] r14 = new Object[r12];
        int r15 = this.f20730c;
    L3:
        int r16 = r15 - 1;
        if (r15 == 0) goto L13;
    L5:
        r11 = r11 - 1;
        Object r17 = r10[r11];
        if (r17 == null) goto L5;
        int r18 = c(r17.hashCode()) & r13;
        if (r14[r18] == null) goto L12;
    L10:
        r18 = (r18 + 1) & r13;
        if (r14[r18] != null) goto L10;
    L12:
        r14[r18] = r10[r11];
        r15 = r16;
        goto L3
    L13:
        this.f20729b = r13;
        this.f20731d = (int) (r12 * this.f20728a);
        this.f20732e = r14;
    }

    public boolean e(Object r10) {
        Object[] r11 = this.f20732e;
        int r12 = this.f20729b;
        int r13 = c(r10.hashCode()) & r12;
        Object r14 = r11[r13];
        if (r14 != null) goto L6;
        return false;
    L6:
        if (r14.equals(r10) == true) goto L8;
    L9:
        r13 = (r13 + 1) & r12;
        Object r15 = r11[r13];
        if (r15 == null) goto L11;
        if (r15.equals(r10) == false) goto L9;
        return f(r13, r11, r12);
    L11:
        return false;
    L8:
        return f(r13, r11, r12);
    }

    public boolean f(int r10, Object[] r11, int r12) {
        this.f20730c--;
    L3:
        int r13 = r10 + 1;
    L4:
        int r14 = r13 & r12;
        Object r15 = r11[r14];
        if (r15 == null) goto L6;
        int r16 = c(r15.hashCode()) & r12;
        if (r10 > r14) goto L13;
        if (r10 >= r16) goto L15;
        if (r16 > r14) goto L15;
    L16:
        r13 = r14 + 1;
    L15:
        r11[r10] = r15;
        r10 = r14;
        goto L3
    L13:
        if (r10 < r16) goto L16;
        if (r16 <= r14) goto L16;
    L6:
        r11[r10] = null;
        return true;
    }

    public int g() {
        return this.f20730c;
    }

    public e(int r10, float r11) {
        this.f20728a = r11;
        int r12 = f.a(r10);
        this.f20729b = r12 - 1;
        this.f20731d = (int) (r11 * r12);
        this.f20732e = new Object[r12];
    }
}
