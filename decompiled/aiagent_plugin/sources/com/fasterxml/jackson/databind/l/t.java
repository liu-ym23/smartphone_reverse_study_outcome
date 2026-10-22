package com.fasterxml.jackson.databind.l;

/* JADX INFO: compiled from: PrimitiveArrayBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f13059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected a<T> f13060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a<T> f13061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f13062d;

    /* JADX INFO: compiled from: PrimitiveArrayBuilder.java */
    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T f13063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f13064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<T> f13065c;

        public a(T r1, int r2) {
            this.f13063a = r1;
            this.f13064b = r2;
        }

        public T a() {
            return this.f13063a;
        }

        public int a(T r4, int r5) {
            System.arraycopy(this.f13063a, 0, r4, r5, this.f13064b);
            return r5 + this.f13064b;
        }

        public a<T> b() {
            return this.f13065c;
        }

        public void a(a<T> r2) {
            if (this.f13065c != null) goto L7;
            this.f13065c = r2;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public abstract T b(int r1);

    public t() {
    }

    public int a() {
        return this.f13062d;
    }

    public T b() {
        c();
        T r0 = this.f13059a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b(12);
    }

    public final T a(T r2, int r3) {
        a<T> r0 = new a(r2, r3);
        if (this.f13060b != null) goto L5;
        this.f13061c = r0;
        this.f13060b = r0;
    L6:
        this.f13062d += r3;
        if (r3 >= 16384) goto L9;
        int r4 = r3 + r3;
    L11:
        return b(r4);
    L9:
        r4 = r3 + (r3 >> 2);
        goto L11
    L5:
        this.f13061c.a(r0);
        this.f13061c = r0;
        goto L6
    }

    public T b(T r5, int r6) {
        int r0 = this.f13062d + r6;
        T r1 = b(r0);
        a<T> r4 = this.f13060b;
        int r3 = 0;
    L3:
        if (r4 == null) goto L5;
        r3 = r4.a(r1, r3);
        r4 = r4.b();
        goto L3
    L5:
        System.arraycopy(r5, 0, r1, r3, r6);
        int r7 = r3 + r6;
        if (r7 != r0) goto L9;
        return r1;
    L9:
        throw new IllegalStateException("Should have gotten " + r0 + " entries, got " + r7);
    }

    public void c() {
        a<T> r0 = this.f13061c;
        if (r0 == null) goto L5;
        this.f13059a = r0.a();
    L5:
        this.f13061c = null;
        this.f13060b = null;
        this.f13062d = 0;
    }
}
