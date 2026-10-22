package kotlin.jvm.internal;

import kotlin.collections.g0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f21188c;

    public t(int r10) {
        this.f21186a = r10;
        this.f21188c = new Object[r10];
    }

    public final void a(Object r10) {
        q.g(r10, "spreadArgument");
        Object[] r11 = this.f21188c;
        int r12 = this.f21187b;
        this.f21187b = r12 + 1;
        r11[r12] = r10;
    }

    public final int b() {
        return this.f21187b;
    }

    public abstract int c(Object r10);

    public final void d(int r10) {
        this.f21187b = r10;
    }

    public final int e() {
        int r10 = 0;
        g0 r11 = new bg.c(0, this.f21186a - 1).d();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = this.f21188c[r11.nextInt()];
        if (r12 == null) goto L8;
        int r13 = c(r12);
    L9:
        r10 = r10 + r13;
        goto L4
    L8:
        r13 = 1;
        goto L9
    L10:
        return r10;
    }

    public final Object f(Object r10, Object r11) {
        q.g(r10, "values");
        q.g(r11, "result");
        g0 r12 = new bg.c(0, this.f21186a - 1).d();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L10;
        int r15 = r12.nextInt();
        Object r16 = this.f21188c[r15];
        if (r16 == null) goto L4;
        if (r13 >= r15) goto L9;
        int r17 = r15 - r13;
        System.arraycopy(r10, r13, r11, r14, r17);
        r14 = r14 + r17;
    L9:
        int r18 = c(r16);
        System.arraycopy(r16, 0, r11, r14, r18);
        r14 = r14 + r18;
        r13 = r15 + 1;
        goto L4
    L10:
        int r19 = this.f21186a;
        if (r13 >= r19) goto L13;
        System.arraycopy(r10, r13, r11, r14, r19 - r13);
    L13:
        return r11;
    }
}
