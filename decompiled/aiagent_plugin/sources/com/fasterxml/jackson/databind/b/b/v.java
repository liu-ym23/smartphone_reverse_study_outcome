package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

/* JADX INFO: compiled from: NumberDeserializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f12468a = null;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.b.v$1, reason: invalid class name */
    /* JADX INFO: compiled from: NumberDeserializers.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12469a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.b.values().length];
            f12469a = r0;
            r0[com.fasterxml.jackson.databind.a.b.f12185a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12469a[com.fasterxml.jackson.databind.a.b.f12187c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12469a[com.fasterxml.jackson.databind.a.b.f12188d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class a extends ae<BigDecimal> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12470a = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        static {
            f12470a = new a();
        }

        public a() {
            super(BigDecimal.class);
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r1) {
            return BigDecimal.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public final com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.g;
        }

        public BigDecimal b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
            int r0 = r4.m();
            if (r0 != 1) goto L5;
            String r6 = r5.a(r4, this, this.B);
        L20:
            com.fasterxml.jackson.databind.a.b r1 = g(r5, r6);
            if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L25;
            return (BigDecimal) ZeusTransformUtils.preCheckCast(a(r5), BigDecimal.class, "com.obric.aiagent.plugin");
        L25:
            if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L27;
            String r7 = r6.trim();
            if (h(r7) == true) goto L31;
            return new BigDecimal(r7);
        L35:
            return (BigDecimal) ZeusTransformUtils.preCheckCast(r5.b(this.B, r7, "not a valid representation", new Object[0]), BigDecimal.class, "com.obric.aiagent.plugin");
        L31:
            return (BigDecimal) ZeusTransformUtils.preCheckCast(a(r5), BigDecimal.class, "com.obric.aiagent.plugin");
        L27:
            return (BigDecimal) ZeusTransformUtils.preCheckCast(c(r5), BigDecimal.class, "com.obric.aiagent.plugin");
        L5:
            if (r0 == 3) goto L18;
            if (r0 != 6) goto L9;
            r6 = r4.x();
            goto L20
        L9:
            if (r0 == 7) goto L15;
            if (r0 == 8) goto L15;
            return (BigDecimal) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), BigDecimal.class, "com.obric.aiagent.plugin");
        L15:
            return r4.M();
        L18:
            return (BigDecimal) ZeusTransformUtils.preCheckCast(e(r4, r5), BigDecimal.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class b extends ae<BigInteger> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12471a = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        static {
            f12471a = new b();
        }

        public b() {
            super(BigInteger.class);
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r1) {
            return BigInteger.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public final com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.f;
        }

        public BigInteger b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
            if (r4.s() == true) goto L5;
            int r0 = r4.m();
            if (r0 != 1) goto L9;
            String r6 = r5.a(r4, this, this.B);
        L30:
            com.fasterxml.jackson.databind.a.b r1 = g(r5, r6);
            if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L35;
            return (BigInteger) ZeusTransformUtils.preCheckCast(a(r5), BigInteger.class, "com.obric.aiagent.plugin");
        L35:
            if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L37;
            String r7 = r6.trim();
            if (h(r7) == true) goto L41;
            return new BigInteger(r7);
        L45:
            return (BigInteger) ZeusTransformUtils.preCheckCast(r5.b(this.B, r7, "not a valid representation", new Object[0]), BigInteger.class, "com.obric.aiagent.plugin");
        L41:
            return (BigInteger) ZeusTransformUtils.preCheckCast(a(r5), BigInteger.class, "com.obric.aiagent.plugin");
        L37:
            return (BigInteger) ZeusTransformUtils.preCheckCast(c(r5), BigInteger.class, "com.obric.aiagent.plugin");
        L9:
            if (r0 == 3) goto L28;
            if (r0 != 6) goto L13;
            r6 = r4.x();
            goto L30
        L13:
            if (r0 != 8) goto L15;
            com.fasterxml.jackson.databind.a.b r2 = d(r4, r5, this.B);
            if (r2 != com.fasterxml.jackson.databind.a.b.f12187c) goto L21;
            return (BigInteger) ZeusTransformUtils.preCheckCast(a(r5), BigInteger.class, "com.obric.aiagent.plugin");
        L21:
            if (r2 != com.fasterxml.jackson.databind.a.b.f12188d) goto L25;
            return (BigInteger) ZeusTransformUtils.preCheckCast(c(r5), BigInteger.class, "com.obric.aiagent.plugin");
        L25:
            return r4.M().toBigInteger();
        L15:
            return (BigInteger) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), BigInteger.class, "com.obric.aiagent.plugin");
        L28:
            return (BigInteger) ZeusTransformUtils.preCheckCast(e(r4, r5), BigInteger.class, "com.obric.aiagent.plugin");
        L5:
            return r4.J();
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static final class c extends k<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f12472a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final c f12473b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
            return b(r1, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12472a = new c(Boolean.TYPE, Boolean.FALSE);
            f12473b = new c(Boolean.class, null);
        }

        public c(Class<Boolean> r3, Boolean r4) {
            super(r3, com.fasterxml.jackson.databind.k.f.h, r4, Boolean.FALSE);
        }

        public Boolean b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
            com.fasterxml.jackson.a.n r0 = r3.l();
            if (r0 != com.fasterxml.jackson.a.n.k) goto L7;
            return Boolean.TRUE;
        L7:
            if (r0 != com.fasterxml.jackson.a.n.l) goto L11;
            return Boolean.FALSE;
        L11:
            if (this.f == false) goto L15;
            return Boolean.valueOf(t(r3, r4));
        L15:
            return a(r3, r4, this.B);
        }

        public Boolean b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.h.e r4) {
            com.fasterxml.jackson.a.n r5 = r2.l();
            if (r5 != com.fasterxml.jackson.a.n.k) goto L7;
            return Boolean.TRUE;
        L7:
            if (r5 != com.fasterxml.jackson.a.n.l) goto L11;
            return Boolean.FALSE;
        L11:
            if (this.f == false) goto L15;
            return Boolean.valueOf(t(r2, r3));
        L15:
            return a(r2, r3, this.B);
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class d extends k<Byte> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f12474a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final d f12475b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12474a = new d(Byte.TYPE, (byte) 0);
            f12475b = new d(Byte.class, null);
        }

        public d(Class<Byte> r3, Byte r4) {
            super(r3, com.fasterxml.jackson.databind.k.f.f, r4, (byte) 0);
        }

        public Byte b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            if (r2.s() == false) goto L7;
            return Byte.valueOf(r2.F());
        L7:
            if (this.f == false) goto L11;
            return Byte.valueOf(u(r2, r3));
        L11:
            return d(r2, r3);
        }

        public Byte d(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
            int r0 = r5.m();
            if (r0 != 1) goto L5;
            String r7 = r6.a(r5, this, this.B);
        L34:
            com.fasterxml.jackson.databind.a.b r1 = g(r6, r7);
            if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L39;
            return (Byte) ZeusTransformUtils.preCheckCast(a(r6), Byte.class, "com.obric.aiagent.plugin");
        L39:
            if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L41;
            String r8 = r7.trim();
            if (h(r6, r8) == false) goto L56;
            return (Byte) ZeusTransformUtils.preCheckCast(a(r6), Byte.class, "com.obric.aiagent.plugin");
        L56:
            int r2 = com.fasterxml.jackson.a.d.i.a(r8);     // Catch: IllegalArgumentException -> L54
            if (a(r2) == false) goto L53;
            return (Byte) ZeusTransformUtils.preCheckCast(r6.b(this.B, r8, "overflow, value cannot be represented as 8-bit value", new Object[0]), Byte.class, "com.obric.aiagent.plugin");
        L53:
            return Byte.valueOf((byte) r2);
        L55:
            return (Byte) ZeusTransformUtils.preCheckCast(r6.b(this.B, r8, "not a valid Byte value", new Object[0]), Byte.class, "com.obric.aiagent.plugin");
        L41:
            return (Byte) ZeusTransformUtils.preCheckCast(c(r6), Byte.class, "com.obric.aiagent.plugin");
        L5:
            if (r0 == 3) goto L32;
            if (r0 == 11) goto L30;
            if (r0 != 6) goto L11;
            r7 = r5.x();
            goto L34
        L11:
            if (r0 == 7) goto L27;
            if (r0 != 8) goto L15;
            com.fasterxml.jackson.databind.a.b r3 = d(r5, r6, this.B);
            if (r3 != com.fasterxml.jackson.databind.a.b.f12187c) goto L21;
            return (Byte) ZeusTransformUtils.preCheckCast(a(r6), Byte.class, "com.obric.aiagent.plugin");
        L21:
            if (r3 != com.fasterxml.jackson.databind.a.b.f12188d) goto L25;
            return (Byte) ZeusTransformUtils.preCheckCast(c(r6), Byte.class, "com.obric.aiagent.plugin");
        L25:
            return Byte.valueOf(r5.F());
        L15:
            return (Byte) ZeusTransformUtils.preCheckCast(r6.a(f(r6), r5), Byte.class, "com.obric.aiagent.plugin");
        L27:
            return Byte.valueOf(r5.F());
        L30:
            return (Byte) ZeusTransformUtils.preCheckCast(a(r6), Byte.class, "com.obric.aiagent.plugin");
        L32:
            return (Byte) ZeusTransformUtils.preCheckCast(e(r5, r6), Byte.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class e extends k<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f12476a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final e f12477b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12476a = new e(Character.TYPE, 0);
            f12477b = new e(Character.class, null);
        }

        public e(Class<Character> r3, Character r4) {
            super(r3, com.fasterxml.jackson.databind.k.f.f, r4, (char) 0);
        }

        public Character b(com.fasterxml.jackson.a.k r14, com.fasterxml.jackson.databind.h r15) {
            int r0 = r14.m();
            if (r0 != 1) goto L5;
            String r16 = r15.a(r14, this, this.B);
        L42:
            if (r16.length() == 1) goto L44;
            com.fasterxml.jackson.databind.a.b r1 = g(r15, r16);
            if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L50;
            return (Character) ZeusTransformUtils.preCheckCast(a(r15), Character.class, "com.obric.aiagent.plugin");
        L50:
            if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L52;
            String r17 = r16.trim();
            if (h(r15, r17) == false) goto L58;
            return (Character) ZeusTransformUtils.preCheckCast(a(r15), Character.class, "com.obric.aiagent.plugin");
        L58:
            return (Character) ZeusTransformUtils.preCheckCast(r15.b(a(), r17, "Expected either Integer value code or 1-character String", new Object[0]), Character.class, "com.obric.aiagent.plugin");
        L52:
            return (Character) ZeusTransformUtils.preCheckCast(c(r15), Character.class, "com.obric.aiagent.plugin");
        L44:
            return Character.valueOf(r16.charAt(0));
        L5:
            if (r0 == 3) goto L39;
            if (r0 == 11) goto L34;
            if (r0 != 6) goto L11;
            r16 = r14.x();
            goto L42
        L11:
            if (r0 != 7) goto L13;
            com.fasterxml.jackson.databind.a.b r9 = r15.a(b(), this.B, com.fasterxml.jackson.databind.a.e.f12201c);
            int r2 = AnonymousClass1.f12469a[r9.ordinal()];
            if (r2 != 1) goto L17;
            a(r15, r9, this.B, r14.C(), "Integer value (" + r14.x() + ")");
        L31:
            return (Character) ZeusTransformUtils.preCheckCast(a(r15), Character.class, "com.obric.aiagent.plugin");
        L17:
            if (r2 == 2) goto L31;
            if (r2 == 3) goto L28;
            int r18 = r14.H();
            if (r18 < 0) goto L26;
            if (r18 > 65535) goto L26;
            return Character.valueOf((char) r18);
        L26:
            return (Character) ZeusTransformUtils.preCheckCast(r15.a(a(), Integer.valueOf(r18), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]), Character.class, "com.obric.aiagent.plugin");
        L28:
            return (Character) ZeusTransformUtils.preCheckCast(c(r15), Character.class, "com.obric.aiagent.plugin");
        L13:
            return (Character) ZeusTransformUtils.preCheckCast(r15.a(f(r15), r14), Character.class, "com.obric.aiagent.plugin");
        L34:
            if (this.f == false) goto L37;
            g(r15);
        L37:
            return (Character) ZeusTransformUtils.preCheckCast(a(r15), Character.class, "com.obric.aiagent.plugin");
        L39:
            return (Character) ZeusTransformUtils.preCheckCast(e(r14, r15), Character.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class f extends k<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f12478a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final f f12479b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
            return b(r1, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12478a = new f(Double.TYPE, Double.valueOf(0.0d));
            f12479b = new f(Double.class, null);
        }

        public f(Class<Double> r4, Double r5) {
            super(r4, com.fasterxml.jackson.databind.k.f.g, r5, Double.valueOf(0.0d));
        }

        public Double b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            if (r2.a(com.fasterxml.jackson.a.n.j) == false) goto L7;
            return Double.valueOf(r2.L());
        L7:
            if (this.f == false) goto L11;
            return Double.valueOf(z(r2, r3));
        L11:
            return d(r2, r3);
        }

        public Double b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
            if (r1.a(com.fasterxml.jackson.a.n.j) == false) goto L7;
            return Double.valueOf(r1.L());
        L7:
            if (this.f == false) goto L11;
            return Double.valueOf(z(r1, r2));
        L11:
            return d(r1, r2);
        }

        public final Double d(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
            int r0 = r4.m();
            if (r0 != 1) goto L5;
            String r6 = r5.a(r4, this, this.B);
        L24:
            Double r1 = g(r6);
            if (r1 == null) goto L27;
            return r1;
        L27:
            com.fasterxml.jackson.databind.a.b r2 = g(r5, r6);
            if (r2 != com.fasterxml.jackson.databind.a.b.f12187c) goto L32;
            return (Double) ZeusTransformUtils.preCheckCast(a(r5), Double.class, "com.obric.aiagent.plugin");
        L32:
            if (r2 == com.fasterxml.jackson.databind.a.b.f12188d) goto L34;
            String r7 = r6.trim();
            if (h(r5, r7) == true) goto L38;
            return Double.valueOf(f(r7));
        L42:
            return (Double) ZeusTransformUtils.preCheckCast(r5.b(this.B, r7, "not a valid `Double` value", new Object[0]), Double.class, "com.obric.aiagent.plugin");
        L38:
            return (Double) ZeusTransformUtils.preCheckCast(a(r5), Double.class, "com.obric.aiagent.plugin");
        L34:
            return (Double) ZeusTransformUtils.preCheckCast(c(r5), Double.class, "com.obric.aiagent.plugin");
        L5:
            if (r0 == 3) goto L22;
            if (r0 == 11) goto L20;
            if (r0 != 6) goto L11;
            r6 = r4.x();
            goto L24
        L11:
            if (r0 == 7) goto L17;
            if (r0 == 8) goto L17;
            return (Double) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), Double.class, "com.obric.aiagent.plugin");
        L17:
            return Double.valueOf(r4.L());
        L20:
            return (Double) ZeusTransformUtils.preCheckCast(a(r5), Double.class, "com.obric.aiagent.plugin");
        L22:
            return (Double) ZeusTransformUtils.preCheckCast(e(r4, r5), Double.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class g extends k<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final g f12480a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final g f12481b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12480a = new g(Float.TYPE, Float.valueOf(0.0f));
            f12481b = new g(Float.class, null);
        }

        public g(Class<Float> r3, Float r4) {
            super(r3, com.fasterxml.jackson.databind.k.f.g, r4, Float.valueOf(0.0f));
        }

        public Float b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            if (r2.a(com.fasterxml.jackson.a.n.j) == false) goto L7;
            return Float.valueOf(r2.K());
        L7:
            if (this.f == false) goto L11;
            return Float.valueOf(y(r2, r3));
        L11:
            return d(r2, r3);
        }

        public final Float d(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
            int r0 = r4.m();
            if (r0 != 1) goto L5;
            String r6 = r5.a(r4, this, this.B);
        L24:
            Float r1 = e(r6);
            if (r1 == null) goto L27;
            return r1;
        L27:
            com.fasterxml.jackson.databind.a.b r2 = g(r5, r6);
            if (r2 != com.fasterxml.jackson.databind.a.b.f12187c) goto L32;
            return (Float) ZeusTransformUtils.preCheckCast(a(r5), Float.class, "com.obric.aiagent.plugin");
        L32:
            if (r2 == com.fasterxml.jackson.databind.a.b.f12188d) goto L34;
            String r7 = r6.trim();
            if (h(r5, r7) == true) goto L38;
            return Float.valueOf(Float.parseFloat(r7));
        L42:
            return (Float) ZeusTransformUtils.preCheckCast(r5.b(this.B, r7, "not a valid `Float` value", new Object[0]), Float.class, "com.obric.aiagent.plugin");
        L38:
            return (Float) ZeusTransformUtils.preCheckCast(a(r5), Float.class, "com.obric.aiagent.plugin");
        L34:
            return (Float) ZeusTransformUtils.preCheckCast(c(r5), Float.class, "com.obric.aiagent.plugin");
        L5:
            if (r0 == 3) goto L22;
            if (r0 == 11) goto L20;
            if (r0 != 6) goto L11;
            r6 = r4.x();
            goto L24
        L11:
            if (r0 == 7) goto L17;
            if (r0 == 8) goto L17;
            return (Float) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), Float.class, "com.obric.aiagent.plugin");
        L17:
            return Float.valueOf(r4.K());
        L20:
            return (Float) ZeusTransformUtils.preCheckCast(a(r5), Float.class, "com.obric.aiagent.plugin");
        L22:
            return (Float) ZeusTransformUtils.preCheckCast(e(r4, r5), Float.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static final class h extends k<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f12482a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final h f12483b = null;

        @Override // com.fasterxml.jackson.databind.l
        public boolean c() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
            return b(r1, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12482a = new h(Integer.TYPE, 0);
            f12483b = new h(Integer.class, null);
        }

        public h(Class<Integer> r3, Integer r4) {
            super(r3, com.fasterxml.jackson.databind.k.f.f, r4, 0);
        }

        public Integer b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            if (r2.s() == false) goto L7;
            return Integer.valueOf(r2.H());
        L7:
            if (this.f == false) goto L11;
            return Integer.valueOf(w(r2, r3));
        L11:
            return b(r2, r3, Integer.class);
        }

        public Integer b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
            if (r1.s() == false) goto L7;
            return Integer.valueOf(r1.H());
        L7:
            if (this.f == false) goto L11;
            return Integer.valueOf(w(r1, r2));
        L11:
            return b(r1, r2, Integer.class);
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static final class i extends k<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final i f12484a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final i f12485b = null;

        @Override // com.fasterxml.jackson.databind.l
        public boolean c() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12484a = new i(Long.TYPE, 0L);
            f12485b = new i(Long.class, null);
        }

        public i(Class<Long> r4, Long r5) {
            super(r4, com.fasterxml.jackson.databind.k.f.f, r5, 0L);
        }

        public Long b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            if (r2.s() == false) goto L7;
            return Long.valueOf(r2.I());
        L7:
            if (this.f == false) goto L11;
            return Long.valueOf(x(r2, r3));
        L11:
            return c(r2, r3, Long.class);
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class j extends ae<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f12486a = null;

        static {
            f12486a = new j();
        }

        public j() {
            super(Number.class);
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public final com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.f;
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
            int r0 = r5.m();
            if (r0 != 1) goto L5;
            String r7 = r6.a(r5, this, this.B);
        L32:
            com.fasterxml.jackson.databind.a.b r1 = g(r6, r7);
            if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L37;
            return a(r6);
        L37:
            if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L39;
            String r8 = r7.trim();
            if (h(r8) == false) goto L45;
            return a(r6);
        L45:
            if (j(r8) == false) goto L49;
            return Double.valueOf(Double.POSITIVE_INFINITY);
        L49:
            if (i(r8) == false) goto L53;
            return Double.valueOf(Double.NEGATIVE_INFINITY);
        L53:
            if (k(r8) == true) goto L55;
            if (m(r8) == true) goto L65;
            if (r6.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L63;
            return new BigDecimal(r8);
        L63:
            return Double.valueOf(r8);
        L65:
            if (r6.a(com.fasterxml.jackson.databind.i.f12755b) == true) goto L67;
            long r2 = Long.parseLong(r8);     // Catch: IllegalArgumentException -> L78
            if (r6.a(com.fasterxml.jackson.databind.i.f12756c) == true) goto L77;
            if (r2 > 2147483647L) goto L77;
            if (r2 < (-2147483648L)) goto L77;
            return Integer.valueOf((int) r2);
        L77:
            return Long.valueOf(r2);
        L67:
            return new BigInteger(r8);
        L79:
            return r6.b(this.B, r8, "not a valid number", new Object[0]);
        L55:
            return Double.valueOf(Double.NaN);
        L39:
            return c(r6);
        L5:
            if (r0 == 3) goto L30;
            if (r0 != 6) goto L9;
            r7 = r5.x();
            goto L32
        L9:
            if (r0 == 7) goto L23;
            if (r0 == 8) goto L15;
            return r6.a(f(r6), r5);
        L15:
            if (r6.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L21;
            if (r5.t() == true) goto L21;
            return r5.M();
        L21:
            return r5.C();
        L23:
            if (r6.a(z) == false) goto L27;
            return C(r5, r6);
        L27:
            return r5.C();
        L30:
            return e(r5, r6);
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.h.e r5) {
            int r0 = r3.m();
            if (r0 == 6) goto L11;
            if (r0 == 7) goto L11;
            if (r0 == 8) goto L11;
            return r5.c(r3, r4);
        L11:
            return a(r3, r4);
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    protected static abstract class k<T> extends ae<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.k.f f12487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final T f12488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final T f12489e;
        protected final boolean f;

        public k(Class<T> r1, com.fasterxml.jackson.databind.k.f r2, T r3, T r4) {
            super(r1);
            this.f12487c = r2;
            this.f12488d = r3;
            this.f12489e = r4;
            this.f = r1.isPrimitive();
        }

        @Override // com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
        public final T a(com.fasterxml.jackson.databind.h r4) {
            if (this.f == false) goto L8;
            if (r4.a(com.fasterxml.jackson.databind.i.f) == false) goto L8;
            r4.a(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", new Object[]{com.fasterxml.jackson.databind.l.h.d(a())});
        L8:
            return this.f12488d;
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r1) {
            return this.f12489e;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public final com.fasterxml.jackson.databind.k.f b() {
            return this.f12487c;
        }
    }

    /* JADX INFO: compiled from: NumberDeserializers.java */
    @JacksonStdImpl
    public static class l extends k<Short> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final l f12490a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final l f12491b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.v.k, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ Object c(com.fasterxml.jackson.databind.h r1) {
            return super.c(r1);
        }

        static {
            f12490a = new l(Short.TYPE, 0);
            f12491b = new l(Short.class, null);
        }

        public l(Class<Short> r3, Short r4) {
            super(r3, com.fasterxml.jackson.databind.k.f.f, r4, (short) 0);
        }

        public Short b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            if (r2.s() == false) goto L7;
            return Short.valueOf(r2.G());
        L7:
            if (this.f == false) goto L11;
            return Short.valueOf(v(r2, r3));
        L11:
            return d(r2, r3);
        }

        public Short d(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
            int r0 = r5.m();
            if (r0 != 1) goto L5;
            String r7 = r6.a(r5, this, this.B);
        L34:
            com.fasterxml.jackson.databind.a.b r1 = g(r6, r7);
            if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L39;
            return (Short) ZeusTransformUtils.preCheckCast(a(r6), Short.class, "com.obric.aiagent.plugin");
        L39:
            if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L41;
            String r8 = r7.trim();
            if (h(r6, r8) == false) goto L56;
            return (Short) ZeusTransformUtils.preCheckCast(a(r6), Short.class, "com.obric.aiagent.plugin");
        L56:
            int r2 = com.fasterxml.jackson.a.d.i.a(r8);     // Catch: IllegalArgumentException -> L54
            if (b(r2) == false) goto L53;
            return (Short) ZeusTransformUtils.preCheckCast(r6.b(this.B, r8, "overflow, value cannot be represented as 16-bit value", new Object[0]), Short.class, "com.obric.aiagent.plugin");
        L53:
            return Short.valueOf((short) r2);
        L55:
            return (Short) ZeusTransformUtils.preCheckCast(r6.b(this.B, r8, "not a valid Short value", new Object[0]), Short.class, "com.obric.aiagent.plugin");
        L41:
            return (Short) ZeusTransformUtils.preCheckCast(c(r6), Short.class, "com.obric.aiagent.plugin");
        L5:
            if (r0 == 3) goto L32;
            if (r0 == 11) goto L30;
            if (r0 != 6) goto L11;
            r7 = r5.x();
            goto L34
        L11:
            if (r0 == 7) goto L27;
            if (r0 != 8) goto L15;
            com.fasterxml.jackson.databind.a.b r3 = d(r5, r6, this.B);
            if (r3 != com.fasterxml.jackson.databind.a.b.f12187c) goto L21;
            return (Short) ZeusTransformUtils.preCheckCast(a(r6), Short.class, "com.obric.aiagent.plugin");
        L21:
            if (r3 != com.fasterxml.jackson.databind.a.b.f12188d) goto L25;
            return (Short) ZeusTransformUtils.preCheckCast(c(r6), Short.class, "com.obric.aiagent.plugin");
        L25:
            return Short.valueOf(r5.G());
        L15:
            return (Short) ZeusTransformUtils.preCheckCast(r6.a(f(r6), r5), Short.class, "com.obric.aiagent.plugin");
        L27:
            return Short.valueOf(r5.G());
        L30:
            return (Short) ZeusTransformUtils.preCheckCast(a(r6), Short.class, "com.obric.aiagent.plugin");
        L32:
            return (Short) ZeusTransformUtils.preCheckCast(e(r5, r6), Short.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f12468a = new HashSet();
        int r3 = 0;
        Class[] r1 = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
    L3:
        if (r3 >= 11) goto L5;
        f12468a.add(r1[r3].getName());
        r3 = r3 + 1;
        goto L3
    }

    public static com.fasterxml.jackson.databind.l<?> a(Class<?> r2, String r3) {
        if (r2.isPrimitive() == false) goto L41;
        if (r2 != Integer.TYPE) goto L9;
        return h.f12482a;
    L9:
        if (r2 != Boolean.TYPE) goto L13;
        return c.f12472a;
    L13:
        if (r2 != Long.TYPE) goto L17;
        return i.f12484a;
    L17:
        if (r2 != Double.TYPE) goto L21;
        return f.f12478a;
    L21:
        if (r2 != Character.TYPE) goto L25;
        return e.f12476a;
    L25:
        if (r2 != Byte.TYPE) goto L29;
        return d.f12474a;
    L29:
        if (r2 != Short.TYPE) goto L33;
        return l.f12490a;
    L33:
        if (r2 != Float.TYPE) goto L37;
        return g.f12480a;
    L37:
        if (r2 != Void.TYPE) goto L87;
        return u.f12467a;
    L87:
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + r2.getName());
    L41:
        if (f12468a.contains(r3) == true) goto L43;
        return null;
    L43:
        if (r2 != Integer.class) goto L47;
        return h.f12483b;
    L47:
        if (r2 != Boolean.class) goto L51;
        return c.f12473b;
    L51:
        if (r2 != Long.class) goto L55;
        return i.f12485b;
    L55:
        if (r2 != Double.class) goto L59;
        return f.f12479b;
    L59:
        if (r2 != Character.class) goto L63;
        return e.f12477b;
    L63:
        if (r2 != Byte.class) goto L67;
        return d.f12475b;
    L67:
        if (r2 != Short.class) goto L71;
        return l.f12491b;
    L71:
        if (r2 != Float.class) goto L75;
        return g.f12481b;
    L75:
        if (r2 != Number.class) goto L79;
        return j.f12486a;
    L79:
        if (r2 != BigDecimal.class) goto L83;
        return a.f12470a;
    L83:
        if (r2 != BigInteger.class) goto L87;
        return b.f12471a;
    }
}
