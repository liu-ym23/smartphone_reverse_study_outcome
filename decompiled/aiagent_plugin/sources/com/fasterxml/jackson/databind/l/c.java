package com.fasterxml.jackson.databind.l;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: ArrayBuilders.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f13005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f13006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f13007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f13008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f13009e;
    private d f;
    private C0274c g;

    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class a extends t<boolean[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ boolean[] b(int r1) {
            return a(r1);
        }

        public a() {
        }

        public final boolean[] a(int r1) {
            return new boolean[r1];
        }
    }

    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class b extends t<byte[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ byte[] b(int r1) {
            return a(r1);
        }

        public b() {
        }

        public final byte[] a(int r1) {
            return new byte[r1];
        }
    }

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.l.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class C0274c extends t<double[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ double[] b(int r1) {
            return a(r1);
        }

        public C0274c() {
        }

        public final double[] a(int r1) {
            return new double[r1];
        }
    }

    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class d extends t<float[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ float[] b(int r1) {
            return a(r1);
        }

        public d() {
        }

        public final float[] a(int r1) {
            return new float[r1];
        }
    }

    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class e extends t<int[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ int[] b(int r1) {
            return a(r1);
        }

        public e() {
        }

        public final int[] a(int r1) {
            return new int[r1];
        }
    }

    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class f extends t<long[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ long[] b(int r1) {
            return a(r1);
        }

        public f() {
        }

        public final long[] a(int r1) {
            return new long[r1];
        }
    }

    /* JADX INFO: compiled from: ArrayBuilders.java */
    public static final class g extends t<short[]> {
        @Override // com.fasterxml.jackson.databind.l.t
        public /* synthetic */ short[] b(int r1) {
            return a(r1);
        }

        public g() {
        }

        public final short[] a(int r1) {
            return new short[r1];
        }
    }

    public c() {
        this.f13005a = null;
        this.f13006b = null;
        this.f13007c = null;
        this.f13008d = null;
        this.f13009e = null;
        this.f = null;
        this.g = null;
    }

    public a a() {
        if (this.f13005a != null) goto L6;
        this.f13005a = new a();
    L6:
        return this.f13005a;
    }

    public b b() {
        if (this.f13006b != null) goto L6;
        this.f13006b = new b();
    L6:
        return this.f13006b;
    }

    public g c() {
        if (this.f13007c != null) goto L6;
        this.f13007c = new g();
    L6:
        return this.f13007c;
    }

    public e d() {
        if (this.f13008d != null) goto L6;
        this.f13008d = new e();
    L6:
        return this.f13008d;
    }

    public f e() {
        if (this.f13009e != null) goto L6;
        this.f13009e = new f();
    L6:
        return this.f13009e;
    }

    public d f() {
        if (this.f != null) goto L6;
        this.f = new d();
    L6:
        return this.f;
    }

    public C0274c g() {
        if (this.g != null) goto L6;
        this.g = new C0274c();
    L6:
        return this.g;
    }

    public static Object a(final Object r3) {
        final int r0 = Array.getLength(r3);
        final Class<?> r1 = r3.getClass();
        return new AnonymousClass1(r1, r0, r3);
    }
}
