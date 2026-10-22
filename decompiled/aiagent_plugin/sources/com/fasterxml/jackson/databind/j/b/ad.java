package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final HashMap<String, com.fasterxml.jackson.databind.p<?>> f12869a = null;

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class a extends com.fasterxml.jackson.databind.j.b.a<boolean[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.fasterxml.jackson.databind.k f12870a = null;

        @Override // com.fasterxml.jackson.databind.j.i
        public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r1) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (boolean[]) ZeusTransformUtils.preCheckCast(r4, boolean[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.i
        public /* synthetic */ boolean a(Object r3) {
            return a((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public /* synthetic */ void b(boolean[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            b2((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        static {
            f12870a = com.fasterxml.jackson.databind.k.o.a().a(Boolean.class);
        }

        public a() {
            super(boolean[].class);
        }

        public a(a r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
            return new a(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, boolean[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(boolean[] r1) {
            if (r1.length == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final void a(boolean[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            int r0 = r3.length;
            if (r0 == 1) goto L5;
        L8:
            r4.a(r3, r0);
            b2(r3, r4, r5);
            r4.i();
            return;
        L5:
            if (a(r5) == false) goto L8;
            b2(r3, r4, r5);
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public void b2(boolean[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
            int r1 = r2.length;
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            r3.a(r2[r5]);
            r5 = r5 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class b extends aj<char[]> {
        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
            a((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.aiagent.plugin"), r4, r5, r6);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (char[]) ZeusTransformUtils.preCheckCast(r4, char[].class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(char[].class);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, char[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void a(char[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
            if (r4.a(com.fasterxml.jackson.databind.ab.o) == false) goto L5;
            r3.a(r2, r2.length);
            a(r3, r2);
            r3.i();
            return;
        L5:
            r3.a(r2, 0, r2.length);
        }

        public void a(char[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
            if (r4.a(com.fasterxml.jackson.databind.ab.o) == false) goto L5;
            com.fasterxml.jackson.a.g.b r6 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.f12154d));
            a(r3, r2);
        L6:
            r5.b(r3, r6);
            return;
        L5:
            r6 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.h));
            r3.a(r2, 0, r2.length);
            goto L6
        }

        private final void a(com.fasterxml.jackson.a.h r3, char[] r4) {
            int r2 = r4.length;
            int r0 = 0;
        L3:
            if (r0 >= r2) goto L5;
            r3.a(r4, r0, 1);
            r0 = r0 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class c extends com.fasterxml.jackson.databind.j.b.a<double[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.fasterxml.jackson.databind.k f12871a = null;

        @Override // com.fasterxml.jackson.databind.j.i
        public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r1) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (double[]) ZeusTransformUtils.preCheckCast(r4, double[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.i
        public /* synthetic */ boolean a(Object r3) {
            return a((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public /* synthetic */ void b(double[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            b2((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        static {
            f12871a = com.fasterxml.jackson.databind.k.o.a().a(Double.TYPE);
        }

        public c() {
            super(double[].class);
        }

        public c(c r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
            return new c(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, double[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(double[] r1) {
            if (r1.length == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final void a(double[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            if (r3.length == 1) goto L5;
        L8:
            r4.a(r3, 0, r3.length);
            return;
        L5:
            if (a(r5) == false) goto L8;
            b2(r3, r4, r5);
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public void b2(double[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            int r2 = r3.length;
            int r6 = 0;
        L3:
            if (r6 >= r2) goto L5;
            r4.a(r3[r6]);
            r6 = r6 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class d extends h<float[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.fasterxml.jackson.databind.k f12872a = null;

        @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (float[]) ZeusTransformUtils.preCheckCast(r4, float[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.i
        public /* synthetic */ boolean a(Object r3) {
            return a((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public /* synthetic */ void b(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            b((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        static {
            f12872a = com.fasterxml.jackson.databind.k.o.a().a(Float.TYPE);
        }

        public d() {
            super(float[].class);
        }

        public d(d r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
            return new d(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, float[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(float[] r1) {
            if (r1.length == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final void a(float[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            int r0 = r3.length;
            if (r0 == 1) goto L5;
        L8:
            r4.a(r3, r0);
            b(r3, r4, r5);
            r4.i();
            return;
        L5:
            if (a(r5) == false) goto L8;
            b(r3, r4, r5);
        }

        public void b(float[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
            int r1 = r2.length;
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            r3.a(r2[r5]);
            r5 = r5 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class e extends com.fasterxml.jackson.databind.j.b.a<int[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.fasterxml.jackson.databind.k f12873a = null;

        @Override // com.fasterxml.jackson.databind.j.i
        public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r1) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.i
        public /* synthetic */ boolean a(Object r3) {
            return a((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public /* synthetic */ void b(int[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            b2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        static {
            f12873a = com.fasterxml.jackson.databind.k.o.a().a(Integer.TYPE);
        }

        public e() {
            super(int[].class);
        }

        public e(e r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
            return new e(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, int[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(int[] r1) {
            if (r1.length == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final void a(int[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            if (r3.length == 1) goto L5;
        L8:
            r4.a(r3, 0, r3.length);
            return;
        L5:
            if (a(r5) == false) goto L8;
            b2(r3, r4, r5);
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public void b2(int[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
            int r1 = r2.length;
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            r3.d(r2[r5]);
            r5 = r5 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class f extends h<long[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.fasterxml.jackson.databind.k f12874a = null;

        @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.i
        public /* synthetic */ boolean a(Object r3) {
            return a((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public /* synthetic */ void b(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            b((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        static {
            f12874a = com.fasterxml.jackson.databind.k.o.a().a(Long.TYPE);
        }

        public f() {
            super(long[].class);
        }

        public f(f r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
            return new f(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, long[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(long[] r1) {
            if (r1.length == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final void a(long[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            if (r3.length == 1) goto L5;
        L8:
            r4.a(r3, 0, r3.length);
            return;
        L5:
            if (a(r5) == false) goto L8;
            b(r3, r4, r5);
        }

        public void b(long[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            int r2 = r3.length;
            int r6 = 0;
        L3:
            if (r6 >= r2) goto L5;
            r4.b(r3[r6]);
            r6 = r6 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class g extends h<short[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.fasterxml.jackson.databind.k f12875a = null;

        @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.p
        public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
            return a(r3, (short[]) ZeusTransformUtils.preCheckCast(r4, short[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.i
        public /* synthetic */ boolean a(Object r3) {
            return a((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public /* synthetic */ void b(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            b((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.aiagent.plugin"), r4, r5);
        }

        static {
            f12875a = com.fasterxml.jackson.databind.k.o.a().a(Short.TYPE);
        }

        public g() {
            super(short[].class);
        }

        public g(g r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.j.b.a
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
            return new g(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean a(com.fasterxml.jackson.databind.ac r1, short[] r2) {
            if (r2.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(short[] r1) {
            if (r1.length == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final void a(short[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            int r0 = r3.length;
            if (r0 == 1) goto L5;
        L8:
            r4.a(r3, r0);
            b(r3, r4, r5);
            r4.i();
            return;
        L5:
            if (a(r5) == false) goto L8;
            b(r3, r4, r5);
        }

        public void b(short[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
            int r1 = r2.length;
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            r3.d(r2[r5]);
            r5 = r5 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: StdArraySerializers.java */
    protected static abstract class h<T> extends com.fasterxml.jackson.databind.j.b.a<T> {
        @Override // com.fasterxml.jackson.databind.j.i
        public final com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r1) {
            return this;
        }

        public h(Class<T> r1) {
            super(r1);
        }

        public h(h<T> r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        }
    }

    static {
        HashMap<String, com.fasterxml.jackson.databind.p<?>> r0 = new HashMap();
        f12869a = r0;
        r0.put(boolean[].class.getName(), new a());
        r0.put(byte[].class.getName(), new com.fasterxml.jackson.databind.j.b.f());
        r0.put(char[].class.getName(), new b());
        r0.put(short[].class.getName(), new g());
        r0.put(int[].class.getName(), new e());
        r0.put(long[].class.getName(), new f());
        r0.put(float[].class.getName(), new d());
        r0.put(double[].class.getName(), new c());
    }

    public static com.fasterxml.jackson.databind.p<?> a(Class<?> r2) {
        return (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(f12869a.get(r2.getName()), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
    }
}
