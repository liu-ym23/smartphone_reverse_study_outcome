package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x<T> extends ab<T> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Boolean f12496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.s f12497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Object f12498c;

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class a extends x<boolean[]> {
        public boolean[] i() {
            return new boolean[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ boolean[] a(boolean[] r3, boolean[] r4) {
            return a2((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.aiagent.plugin"), (boolean[]) ZeusTransformUtils.preCheckCast(r4, boolean[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ boolean[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ boolean[] h() {
            return i();
        }

        public a() {
            super(boolean[].class);
        }

        public a(a r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new a(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean[] f(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
            if (r9.q() == false) goto L5;
            com.fasterxml.jackson.databind.l.c.a r1 = r10.o().a();
            boolean[] r3 = (boolean[]) ZeusTransformUtils.preCheckCast(r1.b(), boolean[].class, "com.obric.aiagent.plugin");
            int r5 = 0;
        L38:
            com.fasterxml.jackson.a.n r6 = r9.g();     // Catch: Exception -> L33
            if (r6 == com.fasterxml.jackson.a.n.f12155e) goto L32;
            if (r6 == com.fasterxml.jackson.a.n.k) goto L11;
            if (r6 == com.fasterxml.jackson.a.n.l) goto L14;
            if (r6 != com.fasterxml.jackson.a.n.m) goto L21;
            if (this.f12497b == null) goto L20;
            this.f12497b.a(r10);     // Catch: Exception -> L33
            goto L38
        L20:
            g(r10);     // Catch: Exception -> L33
            goto L14
        L21:
            boolean r7 = t(r9, r10);     // Catch: Exception -> L33
        L23:
            if (r5 < r3.length) goto L26;
            boolean[] r8 = (boolean[]) ZeusTransformUtils.preCheckCast(r1.a(r3, r5), boolean[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
            r5 = 0;
            r3 = r8;
        L26:
            int r11 = r5 + 1;
            r3[r5] = r7;     // Catch: Exception -> L29
            r5 = r11;
        L29:
            e = e;
            r5 = r11;
        L35:
            throw com.fasterxml.jackson.databind.m.a(e, r3, r1.a() + r5);
        L14:
            r7 = false;
            goto L23
        L11:
            r7 = true;
            goto L23
        L32:
            return (boolean[]) ZeusTransformUtils.preCheckCast(r1.b(r3, r5), boolean[].class, "com.obric.aiagent.plugin");
        L33:
            e = e;
            goto L35
        L5:
            return (boolean[]) ZeusTransformUtils.preCheckCast(d(r9, r10), boolean[].class, "com.obric.aiagent.plugin");
        }

        public boolean[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return new boolean[]{t(r2, r3)};
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean[] a2(boolean[] r3, boolean[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            boolean[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class b extends x<byte[]> {
        public byte[] i() {
            return new byte[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ byte[] a(byte[] r3, byte[] r4) {
            return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ byte[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ byte[] h() {
            return i();
        }

        public b() {
            super(byte[].class);
        }

        public b(b r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new b(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x, com.fasterxml.jackson.databind.l
        public com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.k;
        }

        public byte[] f(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
            com.fasterxml.jackson.a.n r1 = r9.l();
            if (r1 != com.fasterxml.jackson.a.n.h) goto L12;
            return r9.a(r10.k());
        L6:
            e = move-exception;
            String r2 = e.b();
            if (r2.contains("base64") == false) goto L12;
            return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10.b(byte[].class, r9.x(), r2, new Object[0]), byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin");
        L12:
            if (r1 != com.fasterxml.jackson.a.n.g) goto L22;
            Object r3 = r9.N();
            if (r3 != null) goto L18;
            return null;
        L18:
            if ((r3 instanceof byte[]) == false) goto L22;
            return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin");
        L22:
            if (r9.q() == false) goto L24;
            com.fasterxml.jackson.databind.l.c.b r4 = r10.o().b();
            byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(r4.b(), byte[].class, "com.obric.aiagent.plugin");
            int r6 = 0;
        L54:
            com.fasterxml.jackson.a.n r7 = r9.g();     // Catch: Exception -> L49
            if (r7 == com.fasterxml.jackson.a.n.f12155e) goto L48;
            if (r7 == com.fasterxml.jackson.a.n.i) goto L30;
            if (r7 != com.fasterxml.jackson.a.n.m) goto L37;
            if (this.f12497b == null) goto L36;
            this.f12497b.a(r10);     // Catch: Exception -> L49
            goto L54
        L36:
            g(r10);     // Catch: Exception -> L49
            byte r8 = 0;
        L39:
            if (r6 < r5.length) goto L42;
            byte[] r11 = (byte[]) ZeusTransformUtils.preCheckCast(r4.a(r5, r6), byte[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
            r6 = 0;
            r5 = r11;
        L42:
            int r12 = r6 + 1;
            r5[r6] = r8;     // Catch: Exception -> L45
            r6 = r12;
        L45:
            e = e;
            r6 = r12;
        L51:
            throw com.fasterxml.jackson.databind.m.a(e, r5, r4.a() + r6);
        L37:
            r8 = u(r9, r10);     // Catch: Exception -> L49
            goto L39
        L30:
            r8 = r9.F();     // Catch: Exception -> L49
            goto L39
        L48:
            return (byte[]) ZeusTransformUtils.preCheckCast(r4.b(r5, r6), byte[].class, "com.obric.aiagent.plugin");
        L49:
            e = e;
            goto L51
        L24:
            return (byte[]) ZeusTransformUtils.preCheckCast(d(r9, r10), byte[].class, "com.obric.aiagent.plugin");
        }

        public byte[] g(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
            com.fasterxml.jackson.a.n r1 = r5.l();
            if (r1 != com.fasterxml.jackson.a.n.i) goto L6;
            byte r4 = r5.F();
        L15:
            return new byte[]{r4};
        L6:
            if (r1 == com.fasterxml.jackson.a.n.m) goto L8;
            r4 = ((Number) ZeusTransformUtils.preCheckCast(r6.a(this.B.getComponentType(), r5), Number.class, "com.obric.aiagent.plugin")).byteValue();
            goto L15
        L8:
            if (this.f12497b == null) goto L11;
            this.f12497b.a(r6);
            return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(c(r6), byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin");
        L11:
            g(r6);
            return null;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public byte[] a2(byte[] r3, byte[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            byte[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class c extends x<char[]> {
        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r2, Boolean r3) {
            com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
            return this;
        }

        public char[] i() {
            return new char[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ char[] a(char[] r3, char[] r4) {
            return a2((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.aiagent.plugin"), (char[]) ZeusTransformUtils.preCheckCast(r4, char[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ char[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ char[] h() {
            return i();
        }

        public c() {
            super(char[].class);
        }

        public char[] f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
            if (r7.a(com.fasterxml.jackson.a.n.h) == false) goto L7;
            char[] r6 = r7.y();
            int r9 = r7.A();
            int r10 = r7.z();
            char[] r0 = new char[r10];
            System.arraycopy(r6, r9, r0, 0, r10);
            return r0;
        L7:
            if (r7.q() == false) goto L28;
            StringBuilder r1 = new StringBuilder(64);
        L9:
            com.fasterxml.jackson.a.n r2 = r7.g();
            if (r2 == com.fasterxml.jackson.a.n.f12155e) goto L26;
            if (r2 == com.fasterxml.jackson.a.n.h) goto L13;
            if (r2 != com.fasterxml.jackson.a.n.m) goto L20;
            if (this.f12497b == null) goto L19;
            this.f12497b.a(r8);
            goto L9
        L19:
            g(r8);
            String r3 = "\u0000";
        L22:
            if (r3.length() == 1) goto L24;
            r8.a(this, "Cannot convert a JSON String of length %d into a char element of char array", new Object[]{Integer.valueOf(r3.length())});
        L24:
            r1.append(r3.charAt(0));
            goto L9
        L20:
            r3 = ((CharSequence) ZeusTransformUtils.preCheckCast(r8.a(Character.TYPE, r7), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            goto L22
        L13:
            r3 = r7.x();
            goto L22
        L26:
            return r1.toString().toCharArray();
        L28:
            if (r7.a(com.fasterxml.jackson.a.n.g) == false) goto L46;
            Object r4 = r7.N();
            if (r4 != null) goto L34;
            return null;
        L34:
            if ((r4 instanceof char[]) == false) goto L38;
            return (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r4, char[].class, "com.obric.aiagent.plugin"), char[].class, "com.obric.aiagent.plugin");
        L38:
            if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L42;
            return ((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).toCharArray();
        L42:
            if ((r4 instanceof byte[]) == false) goto L46;
            return com.fasterxml.jackson.a.b.a().a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"), false).toCharArray();
        L46:
            return (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r8.a(this.B, r7), char[].class, "com.obric.aiagent.plugin"), char[].class, "com.obric.aiagent.plugin");
        }

        public char[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r3.a(this.B, r2), char[].class, "com.obric.aiagent.plugin"), char[].class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public char[] a2(char[] r3, char[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            char[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class d extends x<double[]> {
        public double[] i() {
            return new double[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ double[] a(double[] r3, double[] r4) {
            return a2((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.aiagent.plugin"), (double[]) ZeusTransformUtils.preCheckCast(r4, double[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ double[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ double[] h() {
            return i();
        }

        public d() {
            super(double[].class);
        }

        public d(d r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new d(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        public double[] f(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
            if (r10.q() == false) goto L5;
            com.fasterxml.jackson.databind.l.c.C0274c r1 = r11.o().g();
            double[] r3 = (double[]) ZeusTransformUtils.preCheckCast(r1.b(), double[].class, "com.obric.aiagent.plugin");
            int r5 = 0;
        L30:
            com.fasterxml.jackson.a.n r6 = r10.g();     // Catch: Exception -> L25
            if (r6 == com.fasterxml.jackson.a.n.f12155e) goto L24;
            if (r6 != com.fasterxml.jackson.a.n.m) goto L14;
            if (this.f12497b == null) goto L14;
            this.f12497b.a(r11);     // Catch: Exception -> L25
        L14:
            double r7 = z(r10, r11);     // Catch: Exception -> L25
            if (r5 < r3.length) goto L18;
            double[] r8 = (double[]) ZeusTransformUtils.preCheckCast(r1.a(r3, r5), double[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
            r5 = 0;
            r3 = r8;
        L18:
            int r9 = r5 + 1;
            r3[r5] = r7;     // Catch: Exception -> L21
            r5 = r9;
        L21:
            e = e;
            r5 = r9;
        L27:
            throw com.fasterxml.jackson.databind.m.a(e, r3, r1.a() + r5);
        L24:
            return (double[]) ZeusTransformUtils.preCheckCast(r1.b(r3, r5), double[].class, "com.obric.aiagent.plugin");
        L25:
            e = e;
            goto L27
        L5:
            return (double[]) ZeusTransformUtils.preCheckCast(d(r10, r11), double[].class, "com.obric.aiagent.plugin");
        }

        public double[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return new double[]{z(r2, r3)};
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public double[] a2(double[] r3, double[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            double[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class e extends x<float[]> {
        public float[] i() {
            return new float[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ float[] a(float[] r3, float[] r4) {
            return a2((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.aiagent.plugin"), (float[]) ZeusTransformUtils.preCheckCast(r4, float[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ float[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ float[] h() {
            return i();
        }

        public e() {
            super(float[].class);
        }

        public e(e r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new e(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        public float[] f(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
            if (r9.q() == false) goto L5;
            com.fasterxml.jackson.databind.l.c.d r1 = r10.o().f();
            float[] r3 = (float[]) ZeusTransformUtils.preCheckCast(r1.b(), float[].class, "com.obric.aiagent.plugin");
            int r5 = 0;
        L30:
            com.fasterxml.jackson.a.n r6 = r9.g();     // Catch: Exception -> L25
            if (r6 == com.fasterxml.jackson.a.n.f12155e) goto L24;
            if (r6 != com.fasterxml.jackson.a.n.m) goto L14;
            if (this.f12497b == null) goto L14;
            this.f12497b.a(r10);     // Catch: Exception -> L25
        L14:
            float r7 = y(r9, r10);     // Catch: Exception -> L25
            if (r5 < r3.length) goto L18;
            float[] r8 = (float[]) ZeusTransformUtils.preCheckCast(r1.a(r3, r5), float[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
            r5 = 0;
            r3 = r8;
        L18:
            int r11 = r5 + 1;
            r3[r5] = r7;     // Catch: Exception -> L21
            r5 = r11;
        L21:
            e = e;
            r5 = r11;
        L27:
            throw com.fasterxml.jackson.databind.m.a(e, r3, r1.a() + r5);
        L24:
            return (float[]) ZeusTransformUtils.preCheckCast(r1.b(r3, r5), float[].class, "com.obric.aiagent.plugin");
        L25:
            e = e;
            goto L27
        L5:
            return (float[]) ZeusTransformUtils.preCheckCast(d(r9, r10), float[].class, "com.obric.aiagent.plugin");
        }

        public float[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return new float[]{y(r2, r3)};
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float[] a2(float[] r3, float[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            float[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class f extends x<int[]> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f12499c = null;

        public int[] i() {
            return new int[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ int[] a(int[] r3, int[] r4) {
            return a2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"), (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ int[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ int[] h() {
            return i();
        }

        static {
            f12499c = new f();
        }

        public f() {
            super(int[].class);
        }

        public f(f r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new f(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        public int[] f(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
            if (r9.q() == false) goto L5;
            com.fasterxml.jackson.databind.l.c.e r1 = r10.o().d();
            int[] r3 = (int[]) ZeusTransformUtils.preCheckCast(r1.b(), int[].class, "com.obric.aiagent.plugin");
            int r5 = 0;
        L35:
            com.fasterxml.jackson.a.n r6 = r9.g();     // Catch: Exception -> L30
            if (r6 == com.fasterxml.jackson.a.n.f12155e) goto L29;
            if (r6 == com.fasterxml.jackson.a.n.i) goto L11;
            if (r6 != com.fasterxml.jackson.a.n.m) goto L18;
            if (this.f12497b == null) goto L17;
            this.f12497b.a(r10);     // Catch: Exception -> L30
            goto L35
        L17:
            g(r10);     // Catch: Exception -> L30
            int r7 = 0;
        L20:
            if (r5 < r3.length) goto L23;
            int[] r8 = (int[]) ZeusTransformUtils.preCheckCast(r1.a(r3, r5), int[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
            r5 = 0;
            r3 = r8;
        L23:
            int r11 = r5 + 1;
            r3[r5] = r7;     // Catch: Exception -> L26
            r5 = r11;
        L26:
            e = e;
            r5 = r11;
        L32:
            throw com.fasterxml.jackson.databind.m.a(e, r3, r1.a() + r5);
        L18:
            r7 = w(r9, r10);     // Catch: Exception -> L30
            goto L20
        L11:
            r7 = r9.H();     // Catch: Exception -> L30
            goto L20
        L29:
            return (int[]) ZeusTransformUtils.preCheckCast(r1.b(r3, r5), int[].class, "com.obric.aiagent.plugin");
        L30:
            e = e;
            goto L32
        L5:
            return (int[]) ZeusTransformUtils.preCheckCast(d(r9, r10), int[].class, "com.obric.aiagent.plugin");
        }

        public int[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return new int[]{w(r2, r3)};
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public int[] a2(int[] r3, int[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            int[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class g extends x<long[]> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f12500c = null;

        public long[] i() {
            return new long[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ long[] a(long[] r3, long[] r4) {
            return a2((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.aiagent.plugin"), (long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ long[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ long[] h() {
            return i();
        }

        static {
            f12500c = new g();
        }

        public g() {
            super(long[].class);
        }

        public g(g r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new g(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        public long[] f(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
            if (r10.q() == false) goto L5;
            com.fasterxml.jackson.databind.l.c.f r1 = r11.o().e();
            long[] r3 = (long[]) ZeusTransformUtils.preCheckCast(r1.b(), long[].class, "com.obric.aiagent.plugin");
            int r5 = 0;
        L35:
            com.fasterxml.jackson.a.n r6 = r10.g();     // Catch: Exception -> L30
            if (r6 == com.fasterxml.jackson.a.n.f12155e) goto L29;
            if (r6 == com.fasterxml.jackson.a.n.i) goto L11;
            if (r6 != com.fasterxml.jackson.a.n.m) goto L18;
            if (this.f12497b == null) goto L17;
            this.f12497b.a(r11);     // Catch: Exception -> L30
            goto L35
        L17:
            g(r11);     // Catch: Exception -> L30
            long r7 = 0;
        L20:
            if (r5 < r3.length) goto L23;
            long[] r8 = (long[]) ZeusTransformUtils.preCheckCast(r1.a(r3, r5), long[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
            r5 = 0;
            r3 = r8;
        L23:
            int r9 = r5 + 1;
            r3[r5] = r7;     // Catch: Exception -> L26
            r5 = r9;
        L26:
            e = e;
            r5 = r9;
        L32:
            throw com.fasterxml.jackson.databind.m.a(e, r3, r1.a() + r5);
        L18:
            r7 = x(r10, r11);     // Catch: Exception -> L30
            goto L20
        L11:
            r7 = r10.I();     // Catch: Exception -> L30
            goto L20
        L29:
            return (long[]) ZeusTransformUtils.preCheckCast(r1.b(r3, r5), long[].class, "com.obric.aiagent.plugin");
        L30:
            e = e;
            goto L32
        L5:
            return (long[]) ZeusTransformUtils.preCheckCast(d(r10, r11), long[].class, "com.obric.aiagent.plugin");
        }

        public long[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return new long[]{x(r2, r3)};
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public long[] a2(long[] r3, long[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            long[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    /* JADX INFO: compiled from: PrimitiveArrayDeserializers.java */
    @JacksonStdImpl
    static final class h extends x<short[]> {
        public short[] i() {
            return new short[0];
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ short[] a(short[] r3, short[] r4) {
            return a2((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.aiagent.plugin"), (short[]) ZeusTransformUtils.preCheckCast(r4, short[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ short[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return g(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public /* synthetic */ short[] h() {
            return i();
        }

        public h() {
            super(short[].class);
        }

        public h(h r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
            super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.fasterxml.jackson.databind.b.b.x
        public x<?> a(com.fasterxml.jackson.databind.b.s r3, Boolean r4) {
            return new h(this, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r4);
        }

        public short[] f(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
            if (r9.q() == false) goto L5;
            com.fasterxml.jackson.databind.l.c.g r1 = r10.o().c();
            short[] r3 = (short[]) ZeusTransformUtils.preCheckCast(r1.b(), short[].class, "com.obric.aiagent.plugin");
            int r5 = 0;
        L32:
            com.fasterxml.jackson.a.n r6 = r9.g();     // Catch: Exception -> L27
            if (r6 == com.fasterxml.jackson.a.n.f12155e) goto L26;
            if (r6 != com.fasterxml.jackson.a.n.m) goto L15;
            if (this.f12497b != null) goto L13;
            g(r10);     // Catch: Exception -> L27
            short r7 = 0;
        L17:
            if (r5 < r3.length) goto L20;
            short[] r8 = (short[]) ZeusTransformUtils.preCheckCast(r1.a(r3, r5), short[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
            r5 = 0;
            r3 = r8;
        L20:
            int r11 = r5 + 1;
            r3[r5] = r7;     // Catch: Exception -> L23
            r5 = r11;
        L23:
            e = e;
            r5 = r11;
        L29:
            throw com.fasterxml.jackson.databind.m.a(e, r3, r1.a() + r5);
        L13:
            this.f12497b.a(r10);     // Catch: Exception -> L27
            goto L32
        L15:
            r7 = v(r9, r10);     // Catch: Exception -> L27
            goto L17
        L26:
            return (short[]) ZeusTransformUtils.preCheckCast(r1.b(r3, r5), short[].class, "com.obric.aiagent.plugin");
        L27:
            e = e;
            goto L29
        L5:
            return (short[]) ZeusTransformUtils.preCheckCast(d(r9, r10), short[].class, "com.obric.aiagent.plugin");
        }

        public short[] g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return new short[]{v(r2, r3)};
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public short[] a2(short[] r3, short[] r4) {
            int r2 = r3.length;
            int r0 = r4.length;
            short[] r5 = Arrays.copyOf(r3, r2 + r0);
            System.arraycopy(r4, 0, r5, r2, r0);
            return r5;
        }
    }

    public abstract x<?> a(com.fasterxml.jackson.databind.b.s r1, Boolean r2);

    public abstract T a(T r1, T r2);

    public abstract T b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2);

    public abstract T h();

    public x(Class<T> r1) {
        super(r1);
        this.f12496a = null;
        this.f12497b = null;
    }

    public x(x<?> r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(r3.B);
        this.f12496a = r5;
        this.f12497b = r6;
    }

    public static com.fasterxml.jackson.databind.l<?> a(Class<?> r1) {
        if (r1 != Integer.TYPE) goto L7;
        return f.f12499c;
    L7:
        if (r1 != Long.TYPE) goto L11;
        return g.f12500c;
    L11:
        if (r1 != Byte.TYPE) goto L15;
        return new b();
    L15:
        if (r1 != Short.TYPE) goto L19;
        return new h();
    L19:
        if (r1 != Float.TYPE) goto L23;
        return new e();
    L23:
        if (r1 != Double.TYPE) goto L27;
        return new d();
    L27:
        if (r1 != Boolean.TYPE) goto L31;
        return new a();
    L31:
        if (r1 != Character.TYPE) goto L35;
        return new c();
    L35:
        throw new IllegalStateException();
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        Boolean r0 = a(r4, r6, this.B, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Nulls r1 = c(r4, r6);
        if (r1 != Nulls.SKIP) goto L6;
        com.fasterxml.jackson.databind.b.s r7 = com.fasterxml.jackson.databind.b.a.q.a();
    L12:
        if (Objects.equals(r0, this.f12496a) == false) goto L17;
        if (r7 != this.f12497b) goto L17;
        return this;
    L17:
        return a(r7, r0);
    L6:
        if (r1 != Nulls.FAIL) goto L10;
        if (r6 != null) goto L9;
        r7 = com.fasterxml.jackson.databind.b.a.r.a(r4.b(this.B.getComponentType()));
        goto L12
    L9:
        r7 = com.fasterxml.jackson.databind.b.a.r.a(r6, r6.getType().x());
        goto L12
    L10:
        r7 = null;
        goto L12
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12967a;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12995b;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        Object r2 = this.f12498c;
        if (r2 != null) goto L6;
        T r3 = h();
        this.f12498c = r3;
        return r3;
    L6:
        return r2;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, T r3) {
        T r4 = a(r1, r2);
        if (r3 != null) goto L6;
        return r4;
    L6:
        if (Array.getLength(r3) != 0) goto L9;
        return r4;
    L9:
        return a(r3, r4);
    }

    public T d(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        if (r3.a(com.fasterxml.jackson.a.n.h) == false) goto L7;
        return r(r3, r4);
    L7:
        if (this.f12496a != Boolean.TRUE) goto L9;
    L14:
        boolean r0 = true;
    L15:
        if (r0 == false) goto L19;
        return b(r3, r4);
    L19:
        return (T) r4.a(this.B, r3);
    L9:
        if (this.f12496a == null) goto L11;
    L13:
        r0 = false;
        goto L15
    L11:
        if (r4.a(com.fasterxml.jackson.databind.i.q) == false) goto L13;
        goto L13
    }
}
