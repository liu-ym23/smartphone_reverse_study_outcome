package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* JADX INFO: compiled from: StdDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ab<T> extends com.fasterxml.jackson.databind.l<T> implements Serializable {

    @Deprecated
    protected static final int A = 0;
    protected static final int z = 0;
    protected final Class<?> B;
    protected final com.fasterxml.jackson.databind.k C;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.b.ab$1, reason: invalid class name */
    /* JADX INFO: compiled from: StdDeserializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12375a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.b.values().length];
            f12375a = r0;
            r0[com.fasterxml.jackson.databind.a.b.f12188d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f12375a[com.fasterxml.jackson.databind.a.b.f12187c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f12375a[com.fasterxml.jackson.databind.a.b.f12186b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f12375a[com.fasterxml.jackson.databind.a.b.f12185a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final boolean b(Object r0, Object r1) {
        if (r0 == null) goto L5;
        if (r1 == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(int r1) {
        if (r1 >= (-128)) goto L5;
    L8:
        return true;
    L5:
        if (r1 > 255) goto L8;
        return false;
    }

    public final boolean a(long r3) {
        if (r3 >= (-2147483648L)) goto L5;
    L8:
        return true;
    L5:
        if (r3 > 2147483647L) goto L8;
        return false;
    }

    public final boolean b(int r1) {
        if (r1 >= (-32768)) goto L5;
    L8:
        return true;
    L5:
        if (r1 > 32767) goto L8;
        return false;
    }

    public com.fasterxml.jackson.databind.b.y k() {
        return null;
    }

    static {
        z = com.fasterxml.jackson.databind.i.f12755b.b() | com.fasterxml.jackson.databind.i.f12756c.b();
        A = com.fasterxml.jackson.databind.i.r.b() | com.fasterxml.jackson.databind.i.u.b();
    }

    public ab(Class<?> r1) {
        this.B = r1;
        this.C = null;
    }

    public ab(com.fasterxml.jackson.databind.k r2) {
        if (r2 != null) goto L5;
        Class<?> r0 = Object.class;
    L6:
        this.B = r0;
        this.C = r2;
        return;
    L5:
        r0 = r2.e();
        goto L6
    }

    public ab(ab<?> r2) {
        this.B = r2.B;
        this.C = r2.C;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Class<?> a() {
        return this.B;
    }

    public com.fasterxml.jackson.databind.k j() {
        return this.C;
    }

    public com.fasterxml.jackson.databind.k f(com.fasterxml.jackson.databind.h r2) {
        com.fasterxml.jackson.databind.k r0 = this.C;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return r2.b(this.B);
    }

    public boolean a(com.fasterxml.jackson.databind.l<?> r1) {
        return com.fasterxml.jackson.databind.l.h.e(r1);
    }

    public boolean a(com.fasterxml.jackson.databind.q r1) {
        return com.fasterxml.jackson.databind.l.h.e(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.d(r1, r2);
    }

    public T e(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.a.b r0 = i(r11);
        boolean r1 = r11.a(com.fasterxml.jackson.databind.i.r);
        if (r1 == true) goto L7;
        if (r0 != com.fasterxml.jackson.databind.a.b.f12185a) goto L7;
    L25:
        return (T) r11.a(f(r11), com.fasterxml.jackson.a.n.f12154d, r10, null, new Object[0]);
    L7:
        if (r10.g() != com.fasterxml.jackson.a.n.f12155e) goto L19;
        int r2 = AnonymousClass1.f12375a[r0.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L25;
    L16:
        return a(r11);
    L18:
        return (T) c(r11);
    L19:
        if (r1 == false) goto L25;
        T r3 = s(r10, r11);
        if (r10.g() == com.fasterxml.jackson.a.n.f12155e) goto L23;
        D(r10, r11);
    L23:
        return r3;
    }

    public T r(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.b.y r2 = k();
        Class<?> r7 = a();
        String r0 = r10.R();
        if (r2 == null) goto L9;
        if (r2.d() == false) goto L9;
        return (T) r2.a(r11, r0);
    L9:
        if (r0.isEmpty() == false) goto L13;
        return (T) a(r10, r11, r11.a(b(), r7, com.fasterxml.jackson.databind.a.e.j), r7, "empty String (\"\")");
    L13:
        if (l(r0) == false) goto L17;
        return (T) a(r10, r11, r11.a(b(), r7, com.fasterxml.jackson.databind.a.b.f12185a), r7, "blank String (all whitespace)");
    L17:
        if (r2 == null) goto L43;
        r0 = r0.trim();
        if (r2.e() == false) goto L25;
        if (r11.a(com.fasterxml.jackson.databind.k.f.f, Integer.class, com.fasterxml.jackson.databind.a.e.f) != com.fasterxml.jackson.databind.a.b.f12186b) goto L25;
        return (T) r2.a(r11, a(r11, r0));
    L25:
        if (r2.f() == false) goto L31;
        if (r11.a(com.fasterxml.jackson.databind.k.f.f, Long.class, com.fasterxml.jackson.databind.a.e.f) != com.fasterxml.jackson.databind.a.b.f12186b) goto L31;
        return (T) r2.a(r11, c(r11, r0));
    L31:
        if (r2.j() == false) goto L43;
        if (r11.a(com.fasterxml.jackson.databind.k.f.h, Boolean.class, com.fasterxml.jackson.databind.a.e.f) != com.fasterxml.jackson.databind.a.b.f12186b) goto L43;
        String r9 = r0.trim();
        if ("true".equals(r9) == false) goto L39;
        return (T) r2.a(r11, true);
    L39:
        if ("false".equals(r9) == false) goto L43;
        return (T) r2.a(r11, false);
    L43:
        return (T) r11.a(r7, r2, r11.j(), "no String-argument constructor/factory method to deserialize from String value ('%s')", new Object[]{r0});
    }

    public Object a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, com.fasterxml.jackson.databind.a.b r9, Class<?> r10, String r11) {
        int r12 = AnonymousClass1.f12375a[r9.ordinal()];
        if (r12 == 1) goto L11;
        if (r12 != 4) goto L12;
        a(r8, r9, r10, "", "empty String (\"\")");
        return null;
    L12:
        return null;
    L11:
        return c(r8);
    }

    public T s(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.a(com.fasterxml.jackson.a.n.f12154d) == false) goto L7;
        return (T) E(r2, r3);
    L7:
        return a(r2, r3);
    }

    public final boolean t(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        int r0 = r6.m();
        if (r0 != 1) goto L5;
        String r8 = r7.a(r6, this, Boolean.TYPE);
    L29:
        com.fasterxml.jackson.databind.a.b r1 = a(r7, r8, com.fasterxml.jackson.databind.k.f.h, Boolean.TYPE);
        if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L34;
        g(r7);
        return false;
    L34:
        if (r1 != com.fasterxml.jackson.databind.a.b.f12188d) goto L36;
        return false;
    L36:
        String r9 = r8.trim();
        int r2 = r9.length();
        if (r2 != 4) goto L42;
        if (c(r9) == false) goto L47;
        return true;
    L47:
        if (h(r9) == false) goto L50;
        i(r7, r9);
        return false;
    L50:
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(r7.b(Boolean.TYPE, r9, "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized", new Object[0]), Boolean.class, "com.obric.aiagent.plugin");
        return Boolean.TRUE.equals(r5);
    L42:
        if (r2 != 5) goto L47;
        if (d(r9) == false) goto L47;
        return false;
    L5:
        if (r0 == 3) goto L19;
        if (r0 != 6) goto L9;
        r8 = r6.x();
        goto L29
    L9:
        if (r0 == 7) goto L16;
        switch(r0) {
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L27;
        };
    L12:
        g(r7);
    L13:
        return false;
    L14:
        return true;
    L27:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7.a(Boolean.TYPE, r6), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L16:
        return Boolean.TRUE.equals(e(r6, r7, Boolean.TYPE));
    L19:
        if (r7.a(com.fasterxml.jackson.databind.i.r) == false) goto L27;
        if (r6.g() == com.fasterxml.jackson.a.n.f12154d) goto L23;
        boolean r3 = t(r6, r7);
        F(r6, r7);
        return r3;
    L23:
        return ((Boolean) ZeusTransformUtils.preCheckCast(E(r6, r7), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public boolean c(String r3) {
        char r0 = r3.charAt(0);
        if (r0 != 't') goto L7;
        return "true".equals(r3);
    L7:
        if (r0 == 'T') goto L9;
        return false;
    L9:
        if ("TRUE".equals(r3) == false) goto L11;
    L12:
        return true;
    L11:
        if ("True".equals(r3) == true) goto L12;
        return false;
    }

    public boolean d(String r3) {
        char r0 = r3.charAt(0);
        if (r0 != 'f') goto L7;
        return "false".equals(r3);
    L7:
        if (r0 == 'F') goto L9;
        return false;
    L9:
        if ("FALSE".equals(r3) == false) goto L11;
    L12:
        return true;
    L11:
        if ("False".equals(r3) == true) goto L12;
        return false;
    }

    public final Boolean a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, Class<?> r9) {
        int r0 = r7.m();
        if (r0 != 1) goto L5;
        String r10 = r8.a(r7, this, r9);
    L24:
        com.fasterxml.jackson.databind.a.b r1 = a(r8, r10, com.fasterxml.jackson.databind.k.f.h, r9);
        if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L28;
        return null;
    L28:
        if (r1 == com.fasterxml.jackson.databind.a.b.f12188d) goto L30;
        String r11 = r10.trim();
        int r2 = r11.length();
        if (r2 != 4) goto L38;
        if (c(r11) == false) goto L44;
        return true;
    L44:
        if (h(r8, r11) == false) goto L47;
        return null;
    L47:
        return (Boolean) ZeusTransformUtils.preCheckCast(r8.b(r9, r11, "only \"true\" or \"false\" recognized", new Object[0]), Boolean.class, "com.obric.aiagent.plugin");
    L38:
        if (r2 != 5) goto L44;
        if (d(r11) == false) goto L44;
        return false;
    L30:
        return false;
    L5:
        if (r0 == 3) goto L22;
        if (r0 != 6) goto L9;
        r10 = r7.x();
        goto L24
    L9:
        if (r0 == 7) goto L19;
        switch(r0) {
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            default: goto L12;
        };
    L13:
        return null;
    L12:
        return (Boolean) ZeusTransformUtils.preCheckCast(r8.a(r9, r7), Boolean.class, "com.obric.aiagent.plugin");
    L15:
        return false;
    L17:
        return true;
    L19:
        return e(r7, r8, r9);
    L22:
        return (Boolean) ZeusTransformUtils.preCheckCast(e(r7, r8), Boolean.class, "com.obric.aiagent.plugin");
    }

    public final byte u(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        int r0 = r5.m();
        if (r0 != 1) goto L5;
        String r7 = r6.a(r5, this, Byte.TYPE);
    L39:
        com.fasterxml.jackson.databind.a.b r1 = a(r6, r7, com.fasterxml.jackson.databind.k.f.f, Byte.TYPE);
        if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L44;
        g(r6);
        return 0;
    L44:
        if (r1 != com.fasterxml.jackson.databind.a.b.f12188d) goto L46;
        return 0;
    L46:
        String r8 = r7.trim();
        if (h(r8) == false) goto L59;
        i(r6, r8);
        return 0;
    L59:
        int r2 = com.fasterxml.jackson.a.d.i.a(r8);     // Catch: IllegalArgumentException -> L57
        if (a(r2) == false) goto L56;
        return ((Byte) ZeusTransformUtils.preCheckCast(r6.b(this.B, r8, "overflow, value cannot be represented as 8-bit value", new Object[0]), Byte.class, "com.obric.aiagent.plugin")).byteValue();
    L56:
        return (byte) r2;
    L58:
        return ((Byte) ZeusTransformUtils.preCheckCast(r6.b(this.B, r8, "not a valid `byte` value", new Object[0]), Byte.class, "com.obric.aiagent.plugin")).byteValue();
    L5:
        if (r0 == 3) goto L29;
        if (r0 != 11) goto L9;
        g(r6);
        return 0;
    L9:
        if (r0 != 6) goto L11;
        r7 = r5.x();
        goto L39
    L11:
        if (r0 == 7) goto L24;
        if (r0 != 8) goto L37;
        com.fasterxml.jackson.databind.a.b r4 = d(r5, r6, Byte.TYPE);
        if (r4 != com.fasterxml.jackson.databind.a.b.f12187c) goto L19;
        return 0;
    L19:
        if (r4 != com.fasterxml.jackson.databind.a.b.f12188d) goto L22;
        return 0;
    L22:
        return r5.F();
    L37:
        return ((Byte) ZeusTransformUtils.preCheckCast(r6.a(r6.b(Byte.TYPE), r5), Byte.class, "com.obric.aiagent.plugin")).byteValue();
    L24:
        return r5.F();
    L29:
        if (r6.a(com.fasterxml.jackson.databind.i.r) == false) goto L37;
        if (r5.g() == com.fasterxml.jackson.a.n.f12154d) goto L33;
        byte r3 = u(r5, r6);
        F(r5, r6);
        return r3;
    L33:
        return ((Byte) ZeusTransformUtils.preCheckCast(E(r5, r6), Byte.class, "com.obric.aiagent.plugin")).byteValue();
    }

    public final short v(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        int r0 = r5.m();
        if (r0 != 1) goto L5;
        String r7 = r6.a(r5, this, Short.TYPE);
    L39:
        com.fasterxml.jackson.databind.a.b r1 = a(r6, r7, com.fasterxml.jackson.databind.k.f.f, Short.TYPE);
        if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L44;
        g(r6);
        return 0;
    L44:
        if (r1 != com.fasterxml.jackson.databind.a.b.f12188d) goto L46;
        return 0;
    L46:
        String r8 = r7.trim();
        if (h(r8) == false) goto L59;
        i(r6, r8);
        return 0;
    L59:
        int r2 = com.fasterxml.jackson.a.d.i.a(r8);     // Catch: IllegalArgumentException -> L57
        if (b(r2) == false) goto L56;
        return ((Short) ZeusTransformUtils.preCheckCast(r6.b(Short.TYPE, r8, "overflow, value cannot be represented as 16-bit value", new Object[0]), Short.class, "com.obric.aiagent.plugin")).shortValue();
    L56:
        return (short) r2;
    L58:
        return ((Short) ZeusTransformUtils.preCheckCast(r6.b(Short.TYPE, r8, "not a valid `short` value", new Object[0]), Short.class, "com.obric.aiagent.plugin")).shortValue();
    L5:
        if (r0 == 3) goto L29;
        if (r0 != 11) goto L9;
        g(r6);
        return 0;
    L9:
        if (r0 != 6) goto L11;
        r7 = r5.x();
        goto L39
    L11:
        if (r0 == 7) goto L24;
        if (r0 != 8) goto L37;
        com.fasterxml.jackson.databind.a.b r4 = d(r5, r6, Short.TYPE);
        if (r4 != com.fasterxml.jackson.databind.a.b.f12187c) goto L19;
        return 0;
    L19:
        if (r4 != com.fasterxml.jackson.databind.a.b.f12188d) goto L22;
        return 0;
    L22:
        return r5.G();
    L37:
        return ((Short) ZeusTransformUtils.preCheckCast(r6.a(r6.b(Short.TYPE), r5), Short.class, "com.obric.aiagent.plugin")).shortValue();
    L24:
        return r5.G();
    L29:
        if (r6.a(com.fasterxml.jackson.databind.i.r) == false) goto L37;
        if (r5.g() == com.fasterxml.jackson.a.n.f12154d) goto L33;
        short r3 = v(r5, r6);
        F(r5, r6);
        return r3;
    L33:
        return ((Short) ZeusTransformUtils.preCheckCast(E(r5, r6), Short.class, "com.obric.aiagent.plugin")).shortValue();
    }

    public final int w(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        int r0 = r5.m();
        if (r0 != 1) goto L5;
        String r7 = r6.a(r5, this, Integer.TYPE);
    L39:
        com.fasterxml.jackson.databind.a.b r1 = a(r6, r7, com.fasterxml.jackson.databind.k.f.f, Integer.TYPE);
        if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L44;
        g(r6);
        return 0;
    L44:
        if (r1 != com.fasterxml.jackson.databind.a.b.f12188d) goto L46;
        return 0;
    L46:
        String r8 = r7.trim();
        if (h(r8) == false) goto L51;
        i(r6, r8);
        return 0;
    L51:
        return a(r6, r8);
    L5:
        if (r0 == 3) goto L29;
        if (r0 != 11) goto L9;
        g(r6);
        return 0;
    L9:
        if (r0 != 6) goto L11;
        r7 = r5.x();
        goto L39
    L11:
        if (r0 == 7) goto L24;
        if (r0 != 8) goto L37;
        com.fasterxml.jackson.databind.a.b r4 = d(r5, r6, Integer.TYPE);
        if (r4 != com.fasterxml.jackson.databind.a.b.f12187c) goto L19;
        return 0;
    L19:
        if (r4 != com.fasterxml.jackson.databind.a.b.f12188d) goto L22;
        return 0;
    L22:
        return r5.P();
    L37:
        return ((Number) ZeusTransformUtils.preCheckCast(r6.a(Integer.TYPE, r5), Number.class, "com.obric.aiagent.plugin")).intValue();
    L24:
        return r5.H();
    L29:
        if (r6.a(com.fasterxml.jackson.databind.i.r) == false) goto L37;
        if (r5.g() == com.fasterxml.jackson.a.n.f12154d) goto L33;
        int r2 = w(r5, r6);
        F(r5, r6);
        return r2;
    L33:
        return ((Integer) ZeusTransformUtils.preCheckCast(E(r5, r6), Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    public final int a(com.fasterxml.jackson.databind.h r8, String r9) {
        if (r9.length() <= 9) goto L12;
        long r2 = com.fasterxml.jackson.a.d.i.b(r9);     // Catch: IllegalArgumentException -> L13
        if (a(r2) == false) goto L10;
        return a((Number) ZeusTransformUtils.preCheckCast(r8.b(Integer.TYPE, r9, "Overflow: numeric value (%s) out of range of int (%d -%d)", new Object[]{r9, Integer.MIN_VALUE, Integer.MAX_VALUE}), Number.class, "com.obric.aiagent.plugin")).intValue();
    L10:
        return (int) r2;
    L12:
        return com.fasterxml.jackson.a.d.i.a(r9);
    L14:
        return a((Number) ZeusTransformUtils.preCheckCast(r8.b(Integer.TYPE, r9, "not a valid `int` value", new Object[0]), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    public final Integer b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Class<?> r6) {
        int r0 = r4.m();
        if (r0 != 1) goto L5;
        String r7 = r5.a(r4, this, r6);
    L34:
        com.fasterxml.jackson.databind.a.b r8 = g(r5, r7);
        if (r8 != com.fasterxml.jackson.databind.a.b.f12187c) goto L39;
        return (Integer) ZeusTransformUtils.preCheckCast(a(r5), Integer.class, "com.obric.aiagent.plugin");
    L39:
        if (r8 == com.fasterxml.jackson.databind.a.b.f12188d) goto L41;
        String r9 = r7.trim();
        if (h(r5, r9) == false) goto L47;
        return (Integer) ZeusTransformUtils.preCheckCast(a(r5), Integer.class, "com.obric.aiagent.plugin");
    L47:
        return b(r5, r9);
    L41:
        return (Integer) ZeusTransformUtils.preCheckCast(c(r5), Integer.class, "com.obric.aiagent.plugin");
    L5:
        if (r0 == 3) goto L32;
        if (r0 == 11) goto L30;
        if (r0 != 6) goto L11;
        r7 = r4.x();
        goto L34
    L11:
        if (r0 == 7) goto L27;
        if (r0 != 8) goto L15;
        com.fasterxml.jackson.databind.a.b r10 = d(r4, r5, r6);
        if (r10 != com.fasterxml.jackson.databind.a.b.f12187c) goto L21;
        return (Integer) ZeusTransformUtils.preCheckCast(a(r5), Integer.class, "com.obric.aiagent.plugin");
    L21:
        if (r10 != com.fasterxml.jackson.databind.a.b.f12188d) goto L25;
        return (Integer) ZeusTransformUtils.preCheckCast(c(r5), Integer.class, "com.obric.aiagent.plugin");
    L25:
        return Integer.valueOf(r4.P());
    L15:
        return (Integer) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), Integer.class, "com.obric.aiagent.plugin");
    L27:
        return Integer.valueOf(r4.H());
    L30:
        return (Integer) ZeusTransformUtils.preCheckCast(a(r5), Integer.class, "com.obric.aiagent.plugin");
    L32:
        return (Integer) ZeusTransformUtils.preCheckCast(e(r4, r5), Integer.class, "com.obric.aiagent.plugin");
    }

    public final Integer b(com.fasterxml.jackson.databind.h r7, String r8) {
        if (r8.length() <= 9) goto L12;
        long r2 = com.fasterxml.jackson.a.d.i.b(r8);     // Catch: IllegalArgumentException -> L13
        if (a(r2) == false) goto L10;
        return (Integer) ZeusTransformUtils.preCheckCast(r7.b(Integer.class, r8, "Overflow: numeric value (%s) out of range of `java.lang.Integer` (%d -%d)", new Object[]{r8, Integer.MIN_VALUE, Integer.MAX_VALUE}), Integer.class, "com.obric.aiagent.plugin");
    L10:
        return Integer.valueOf((int) r2);
    L12:
        return Integer.valueOf(com.fasterxml.jackson.a.d.i.a(r8));
    L14:
        return (Integer) ZeusTransformUtils.preCheckCast(r7.b(Integer.class, r8, "not a valid `java.lang.Integer` value", new Object[0]), Integer.class, "com.obric.aiagent.plugin");
    }

    public final long x(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        int r0 = r6.m();
        if (r0 != 1) goto L5;
        String r8 = r7.a(r6, this, Long.TYPE);
    L39:
        com.fasterxml.jackson.databind.a.b r1 = a(r7, r8, com.fasterxml.jackson.databind.k.f.f, Long.TYPE);
        if (r1 != com.fasterxml.jackson.databind.a.b.f12187c) goto L44;
        g(r7);
        return 0;
    L44:
        if (r1 != com.fasterxml.jackson.databind.a.b.f12188d) goto L46;
        return 0;
    L46:
        String r9 = r8.trim();
        if (h(r9) == false) goto L51;
        i(r7, r9);
        return 0;
    L51:
        return c(r7, r9);
    L5:
        if (r0 == 3) goto L29;
        if (r0 != 11) goto L9;
        g(r7);
        return 0;
    L9:
        if (r0 != 6) goto L11;
        r8 = r6.x();
        goto L39
    L11:
        if (r0 == 7) goto L24;
        if (r0 != 8) goto L37;
        com.fasterxml.jackson.databind.a.b r5 = d(r6, r7, Long.TYPE);
        if (r5 != com.fasterxml.jackson.databind.a.b.f12187c) goto L19;
        return 0;
    L19:
        if (r5 != com.fasterxml.jackson.databind.a.b.f12188d) goto L22;
        return 0;
    L22:
        return r6.Q();
    L37:
        return ((Number) ZeusTransformUtils.preCheckCast(r7.a(Long.TYPE, r6), Number.class, "com.obric.aiagent.plugin")).longValue();
    L24:
        return r6.I();
    L29:
        if (r7.a(com.fasterxml.jackson.databind.i.r) == false) goto L37;
        if (r6.g() == com.fasterxml.jackson.a.n.f12154d) goto L33;
        long r2 = x(r6, r7);
        F(r6, r7);
        return r2;
    L33:
        return ((Long) ZeusTransformUtils.preCheckCast(E(r6, r7), Long.class, "com.obric.aiagent.plugin")).longValue();
    }

    public final long c(com.fasterxml.jackson.databind.h r4, String r5) {
        return com.fasterxml.jackson.a.d.i.b(r5);
    L5:
        return a((Number) ZeusTransformUtils.preCheckCast(r4.b(Long.TYPE, r5, "not a valid `long` value", new Object[0]), Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    public final Long c(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Class<?> r6) {
        int r0 = r4.m();
        if (r0 != 1) goto L5;
        String r7 = r5.a(r4, this, r6);
    L34:
        com.fasterxml.jackson.databind.a.b r8 = g(r5, r7);
        if (r8 != com.fasterxml.jackson.databind.a.b.f12187c) goto L39;
        return (Long) ZeusTransformUtils.preCheckCast(a(r5), Long.class, "com.obric.aiagent.plugin");
    L39:
        if (r8 == com.fasterxml.jackson.databind.a.b.f12188d) goto L41;
        String r9 = r7.trim();
        if (h(r5, r9) == false) goto L47;
        return (Long) ZeusTransformUtils.preCheckCast(a(r5), Long.class, "com.obric.aiagent.plugin");
    L47:
        return d(r5, r9);
    L41:
        return (Long) ZeusTransformUtils.preCheckCast(c(r5), Long.class, "com.obric.aiagent.plugin");
    L5:
        if (r0 == 3) goto L32;
        if (r0 == 11) goto L30;
        if (r0 != 6) goto L11;
        r7 = r4.x();
        goto L34
    L11:
        if (r0 == 7) goto L27;
        if (r0 != 8) goto L15;
        com.fasterxml.jackson.databind.a.b r10 = d(r4, r5, r6);
        if (r10 != com.fasterxml.jackson.databind.a.b.f12187c) goto L21;
        return (Long) ZeusTransformUtils.preCheckCast(a(r5), Long.class, "com.obric.aiagent.plugin");
    L21:
        if (r10 != com.fasterxml.jackson.databind.a.b.f12188d) goto L25;
        return (Long) ZeusTransformUtils.preCheckCast(c(r5), Long.class, "com.obric.aiagent.plugin");
    L25:
        return Long.valueOf(r4.Q());
    L15:
        return (Long) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), Long.class, "com.obric.aiagent.plugin");
    L27:
        return Long.valueOf(r4.I());
    L30:
        return (Long) ZeusTransformUtils.preCheckCast(a(r5), Long.class, "com.obric.aiagent.plugin");
    L32:
        return (Long) ZeusTransformUtils.preCheckCast(e(r4, r5), Long.class, "com.obric.aiagent.plugin");
    }

    public final Long d(com.fasterxml.jackson.databind.h r3, String r4) {
        return Long.valueOf(com.fasterxml.jackson.a.d.i.b(r4));
    L5:
        return (Long) ZeusTransformUtils.preCheckCast(r3.b(Long.class, r4, "not a valid `java.lang.Long` value", new Object[0]), Long.class, "com.obric.aiagent.plugin");
    }

    public final float y(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        int r0 = r5.m();
        if (r0 != 1) goto L5;
        String r7 = r6.a(r5, this, Float.TYPE);
    L31:
        Float r1 = e(r7);
        if (r1 != null) goto L34;
        com.fasterxml.jackson.databind.a.b r2 = a(r6, r7, com.fasterxml.jackson.databind.k.f.f, Float.TYPE);
        if (r2 != com.fasterxml.jackson.databind.a.b.f12187c) goto L40;
        g(r6);
        return 0.0f;
    L40:
        if (r2 != com.fasterxml.jackson.databind.a.b.f12188d) goto L42;
        return 0.0f;
    L42:
        String r8 = r7.trim();
        if (h(r8) == false) goto L47;
        i(r6, r8);
        return 0.0f;
    L47:
        return e(r6, r8);
    L34:
        return r1.floatValue();
    L5:
        if (r0 == 3) goto L21;
        if (r0 != 11) goto L9;
        g(r6);
        return 0.0f;
    L9:
        if (r0 != 6) goto L11;
        r7 = r5.x();
        goto L31
    L11:
        if (r0 == 7) goto L16;
        if (r0 == 8) goto L16;
    L29:
        return ((Number) ZeusTransformUtils.preCheckCast(r6.a(Float.TYPE, r5), Number.class, "com.obric.aiagent.plugin")).floatValue();
    L16:
        return r5.K();
    L21:
        if (r6.a(com.fasterxml.jackson.databind.i.r) == false) goto L29;
        if (r5.g() == com.fasterxml.jackson.a.n.f12154d) goto L25;
        float r3 = y(r5, r6);
        F(r5, r6);
        return r3;
    L25:
        return ((Float) ZeusTransformUtils.preCheckCast(E(r5, r6), Float.class, "com.obric.aiagent.plugin")).floatValue();
    }

    public final float e(com.fasterxml.jackson.databind.h r4, String r5) {
        return Float.parseFloat(r5);
    L5:
        return a((Number) ZeusTransformUtils.preCheckCast(r4.b(Float.TYPE, r5, "not a valid `float` value", new Object[0]), Number.class, "com.obric.aiagent.plugin")).floatValue();
    }

    public Float e(String r3) {
        if (r3.isEmpty() == true) goto L23;
        char r0 = r3.charAt(0);
        if (r0 == '-') goto L20;
        if (r0 == 'I') goto L16;
        if (r0 == 'N') goto L12;
        return null;
    L12:
        if (k(r3) == true) goto L14;
        return null;
    L14:
        return Float.valueOf(Float.NaN);
    L16:
        if (j(r3) == true) goto L18;
        return null;
    L18:
        return Float.valueOf(Float.POSITIVE_INFINITY);
    L20:
        if (i(r3) == true) goto L22;
        return null;
    L22:
        return Float.valueOf(Float.NEGATIVE_INFINITY);
    L23:
        return null;
    }

    public final double z(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        int r0 = r6.m();
        if (r0 != 1) goto L5;
        String r8 = r7.a(r6, this, Double.TYPE);
    L31:
        Double r1 = g(r8);
        if (r1 != null) goto L34;
        com.fasterxml.jackson.databind.a.b r2 = a(r7, r8, com.fasterxml.jackson.databind.k.f.f, Double.TYPE);
        if (r2 != com.fasterxml.jackson.databind.a.b.f12187c) goto L40;
        g(r7);
        return 0.0d;
    L40:
        if (r2 != com.fasterxml.jackson.databind.a.b.f12188d) goto L42;
        return 0.0d;
    L42:
        String r9 = r8.trim();
        if (h(r9) == false) goto L47;
        i(r7, r9);
        return 0.0d;
    L47:
        return f(r7, r9);
    L34:
        return r1.doubleValue();
    L5:
        if (r0 == 3) goto L21;
        if (r0 != 11) goto L9;
        g(r7);
        return 0.0d;
    L9:
        if (r0 != 6) goto L11;
        r8 = r6.x();
        goto L31
    L11:
        if (r0 == 7) goto L16;
        if (r0 == 8) goto L16;
    L29:
        return ((Number) ZeusTransformUtils.preCheckCast(r7.a(Double.TYPE, r6), Number.class, "com.obric.aiagent.plugin")).doubleValue();
    L16:
        return r6.L();
    L21:
        if (r7.a(com.fasterxml.jackson.databind.i.r) == false) goto L29;
        if (r6.g() == com.fasterxml.jackson.a.n.f12154d) goto L25;
        double r3 = z(r6, r7);
        F(r6, r7);
        return r3;
    L25:
        return ((Double) ZeusTransformUtils.preCheckCast(E(r6, r7), Double.class, "com.obric.aiagent.plugin")).doubleValue();
    }

    public final double f(com.fasterxml.jackson.databind.h r4, String r5) {
        return f(r5);
    L5:
        return a((Number) ZeusTransformUtils.preCheckCast(r4.b(Double.TYPE, r5, "not a valid `double` value (as String to convert)", new Object[0]), Number.class, "com.obric.aiagent.plugin")).doubleValue();
    }

    public static final double f(String r2) {
        if ("2.2250738585072012e-308".equals(r2) == false) goto L7;
        return Double.MIN_NORMAL;
    L7:
        return Double.parseDouble(r2);
    }

    public Double g(String r3) {
        if (r3.isEmpty() == true) goto L23;
        char r0 = r3.charAt(0);
        if (r0 == '-') goto L20;
        if (r0 == 'I') goto L16;
        if (r0 == 'N') goto L12;
        return null;
    L12:
        if (k(r3) == true) goto L14;
        return null;
    L14:
        return Double.valueOf(Double.NaN);
    L16:
        if (j(r3) == true) goto L18;
        return null;
    L18:
        return Double.valueOf(Double.POSITIVE_INFINITY);
    L20:
        if (i(r3) == true) goto L22;
        return null;
    L22:
        return Double.valueOf(Double.NEGATIVE_INFINITY);
    L23:
        return null;
    }

    public Date a_(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        int r0 = r4.m();
        if (r0 != 1) goto L5;
        String r6 = r5.a(r4, this, this.B);
    L26:
        return b(r6.trim(), r5);
    L5:
        if (r0 == 3) goto L23;
        if (r0 == 11) goto L21;
        if (r0 != 6) goto L11;
        r6 = r4.x();
        goto L26
    L11:
        if (r0 != 7) goto L13;
        long r3 = r4.I();     // Catch: com.fasterxml.jackson.a.b.b -> L16
    L18:
        return new Date(r3);
    L16:
        r3 = ((Number) ZeusTransformUtils.preCheckCast(r5.a(this.B, r4.C(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0]), Number.class, "com.obric.aiagent.plugin")).longValue();
        goto L18
    L13:
        return (Date) ZeusTransformUtils.preCheckCast(r5.a(this.B, r4), Date.class, "com.obric.aiagent.plugin");
    L21:
        return (Date) ZeusTransformUtils.preCheckCast(a(r5), Date.class, "com.obric.aiagent.plugin");
    L23:
        return A(r4, r5);
    }

    public Date A(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.a.b r0 = i(r11);
        boolean r1 = r11.a(com.fasterxml.jackson.databind.i.r);
        if (r1 == false) goto L5;
    L6:
        com.fasterxml.jackson.a.n r3 = r10.g();
        if (r3 != com.fasterxml.jackson.a.n.f12155e) goto L19;
        int r2 = AnonymousClass1.f12375a[r0.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L16;
    L27:
        return (Date) ZeusTransformUtils.preCheckCast(r11.a(this.B, com.fasterxml.jackson.a.n.f12154d, r10, null, new Object[0]), Date.class, "com.obric.aiagent.plugin");
    L16:
        return (Date) ZeusTransformUtils.preCheckCast(a(r11), Date.class, "com.obric.aiagent.plugin");
    L18:
        return (Date) ZeusTransformUtils.preCheckCast(c(r11), Date.class, "com.obric.aiagent.plugin");
    L19:
        if (r1 == false) goto L27;
        if (r3 == com.fasterxml.jackson.a.n.f12154d) goto L23;
        Date r4 = a_(r10, r11);
        F(r10, r11);
        return r4;
    L23:
        return (Date) ZeusTransformUtils.preCheckCast(E(r10, r11), Date.class, "com.obric.aiagent.plugin");
    L5:
        if (r0 == com.fasterxml.jackson.databind.a.b.f12185a) goto L27;
        goto L6
    }

    public Date b(String r5, com.fasterxml.jackson.databind.h r6) {
    L15:
        e = move-exception;
        return (Date) ZeusTransformUtils.preCheckCast(r6.b(this.B, r5, "not a valid representation (error: %s)", new Object[]{com.fasterxml.jackson.databind.l.h.h(e)}), Date.class, "com.obric.aiagent.plugin");
    L4:
        if (r5.isEmpty() == false) goto L11;
        if (AnonymousClass1.f12375a[g(r6, r5).ordinal()] == 1) goto L9;
        return null;
    L9:
        return new Date(0);
    L11:
        if (h(r5) == false) goto L14;
        return null;
    L14:
        return r6.d(r5);
    }

    public final String B(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        if (r4.a(com.fasterxml.jackson.a.n.h) == false) goto L7;
        return r4.x();
    L7:
        if (r4.a(com.fasterxml.jackson.a.n.g) == false) goto L18;
        Object r3 = r4.N();
        if ((r3 instanceof byte[]) == true) goto L11;
        if (r3 != null) goto L16;
        return null;
    L16:
        return r3.toString();
    L11:
        return r5.k().a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"), false);
    L18:
        if (r4.a(com.fasterxml.jackson.a.n.f12152b) == true) goto L20;
        String r6 = r4.R();
        if (r6 == null) goto L25;
        return r6;
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r5.a(String.class, r4), String.class, "com.obric.aiagent.plugin");
    L20:
        return r5.a(r4, this, this.B);
    }

    public boolean h(String r1) {
        return "null".equals(r1);
    }

    public final boolean i(String r1) {
        if ("-Infinity".equals(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if ("-INF".equals(r1) == true) goto L8;
        return false;
    }

    public final boolean j(String r1) {
        if ("Infinity".equals(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if ("INF".equals(r1) == true) goto L8;
        return false;
    }

    public final boolean k(String r1) {
        return "NaN".equals(r1);
    }

    public static final boolean l(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r5.charAt(r2) > ' ') goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public com.fasterxml.jackson.databind.a.b g(com.fasterxml.jackson.databind.h r3, String r4) {
        return a(r3, r4, b(), a());
    }

    public com.fasterxml.jackson.databind.a.b a(com.fasterxml.jackson.databind.h r8, String r9, com.fasterxml.jackson.databind.k.f r10, Class<?> r11) {
        if (r9.isEmpty() == false) goto L7;
        return a(r8, r8.a(r10, r11, com.fasterxml.jackson.databind.a.e.j), r11, r9, "empty String (\"\")");
    L7:
        if (l(r9) == false) goto L11;
        return a(r8, r8.a(r10, r11, com.fasterxml.jackson.databind.a.b.f12185a), r11, r9, "blank String (all whitespace)");
    L11:
        if (r8.a(com.fasterxml.jackson.a.r.f12160c) == true) goto L13;
        com.fasterxml.jackson.databind.a.b r12 = r8.a(r10, r11, com.fasterxml.jackson.databind.a.e.f);
        if (r12 != com.fasterxml.jackson.databind.a.b.f12185a) goto L17;
        r8.a(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", new Object[]{r9, m()});
    L17:
        return r12;
    L13:
        return com.fasterxml.jackson.databind.a.b.f12186b;
    }

    public com.fasterxml.jackson.databind.a.b d(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, Class<?> r11) {
        com.fasterxml.jackson.databind.a.b r4 = r10.a(com.fasterxml.jackson.databind.k.f.f, r11, com.fasterxml.jackson.databind.a.e.f12202d);
        if (r4 == com.fasterxml.jackson.databind.a.b.f12185a) goto L5;
        return r4;
    L5:
        return a(r10, r4, r11, r9.C(), "Floating-point value (" + r9.x() + ")");
    }

    public Boolean e(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, Class<?> r11) {
        com.fasterxml.jackson.databind.a.b r4 = r10.a(com.fasterxml.jackson.databind.k.f.h, r11, com.fasterxml.jackson.databind.a.e.f12201c);
        int r0 = AnonymousClass1.f12375a[r4.ordinal()];
        boolean r1 = true;
        if (r0 == 1) goto L23;
        if (r0 != 2) goto L7;
        return null;
    L7:
        if (r0 != 4) goto L9;
        a(r10, r4, r11, r9.C(), "Integer value (" + r9.x() + ")");
        return Boolean.FALSE;
    L9:
        if (r9.E() != com.fasterxml.jackson.a.k.b.f12143a) goto L17;
        if (r9.H() != 0) goto L15;
        r1 = false;
    L15:
        return Boolean.valueOf(r1);
    L17:
        return Boolean.valueOf(!"0".equals(r9.x()));
    L23:
        return Boolean.FALSE;
    }

    public com.fasterxml.jackson.databind.a.b a(com.fasterxml.jackson.databind.h r8, com.fasterxml.jackson.databind.a.b r9, Class<?> r10, Object r11, String r12) {
        if (r9 != com.fasterxml.jackson.databind.a.b.f12185a) goto L5;
        r8.a(this, r10, r11, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", new Object[]{r12, m()});
    L5:
        return r9;
    }

    public boolean h(com.fasterxml.jackson.databind.h r3, String r4) {
        if (h(r4) == true) goto L5;
        return false;
    L5:
        if (r3.a(com.fasterxml.jackson.databind.r.B) == true) goto L7;
        a(r3, true, com.fasterxml.jackson.databind.r.B, "String \"null\"");
    L7:
        return true;
    }

    public Object C(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        if (r2.a(com.fasterxml.jackson.databind.i.f12755b) == false) goto L7;
        return r1.J();
    L7:
        if (r2.a(com.fasterxml.jackson.databind.i.f12756c) == false) goto L11;
        return Long.valueOf(r1.I());
    L11:
        return r1.C();
    }

    public final void g(com.fasterxml.jackson.databind.h r4) {
        if (r4.a(com.fasterxml.jackson.databind.i.f) == false) goto L6;
        r4.a(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", new Object[]{m()});
        return;
    }

    public final void i(com.fasterxml.jackson.databind.h r6, String r7) {
        if (r6.a(com.fasterxml.jackson.databind.r.B) == true) goto L6;
        Enum<?> r0 = com.fasterxml.jackson.databind.r.B;
        boolean r3 = true;
    L9:
        if (r7.isEmpty() == false) goto L11;
        String r8 = "empty String (\"\")";
    L12:
        a(r6, r3, r0, r8);
        return;
    L11:
        r8 = String.format("String \"%s\"", new Object[]{r7});
        goto L12
    L6:
        if (r6.a(com.fasterxml.jackson.databind.i.f) == false) goto L14;
        r0 = com.fasterxml.jackson.databind.i.f;
        r3 = false;
        goto L9
    }

    public void a(com.fasterxml.jackson.databind.h r3, boolean r4, Enum<?> r5, String r6) {
        if (r4 == false) goto L4;
        String r7 = "enable";
    L5:
        r3.a(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", new Object[]{r6, m(), r7, r5.getDeclaringClass().getSimpleName(), r5.name()});
        return;
    L4:
        r7 = "disable";
        goto L5
    }

    public String m() {
        com.fasterxml.jackson.databind.k r0 = j();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L12:
        Class<?> r4 = a();
        if (r4.isArray() == false) goto L15;
    L18:
        r1 = true;
    L19:
        String r5 = com.fasterxml.jackson.databind.l.h.c(r4);
    L20:
        if (r1 == false) goto L24;
        return "element of " + r5;
    L24:
        return r5 + " value";
    L15:
        if (Collection.class.isAssignableFrom(r4) == true) goto L18;
        if (Map.class.isAssignableFrom(r4) == false) goto L19;
    L5:
        if (r0.o() == true) goto L12;
        if (r0.q() == false) goto L9;
    L10:
        r1 = true;
    L11:
        r5 = com.fasterxml.jackson.databind.l.h.b(r0);
        goto L20
    L9:
        if (r0.a() == false) goto L11;
        goto L10
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.d r4) {
        return r2.a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    public final boolean m(String r6) {
        int r5 = r6.length();
        if (r5 <= 0) goto L22;
        char r1 = r6.charAt(0);
        if (r1 != '-') goto L7;
    L10:
        if (r5 != 1) goto L12;
        return false;
    L12:
        int r2 = 1;
    L13:
        if (r2 >= r5) goto L21;
        char r3 = r6.charAt(r2);
        if (r3 > '9') goto L20;
        if (r3 < '0') goto L20;
        r2 = r2 + 1;
    L20:
        return false;
    L21:
        return true;
    L7:
        if (r1 == '+') goto L10;
        r2 = 0;
        goto L13
    L22:
        return false;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.l<?> r4) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r5 = r2.f();
        if (b(r5, r1) == false) goto L13;
        com.fasterxml.jackson.databind.e.j r0 = r1.d();
        if (r0 == null) goto L13;
        Object r6 = r5.j(r0);
        if (r6 == null) goto L13;
        com.fasterxml.jackson.databind.l.j<Object, Object> r7 = r2.a(r1.d(), r6);
        com.fasterxml.jackson.databind.k r8 = r7.a(r2.b());
        if (r4 != null) goto L12;
        r4 = r2.a(r8, r1);
    L12:
        return new aa(r7, r8, r4);
    L13:
        return r4;
    }

    public JsonFormat.Value a(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.d r3, Class<?> r4) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1.a(r2.c(), r4);
    L7:
        return r2.a(r4);
    }

    public Boolean a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4, Class<?> r5, JsonFormat.Feature r6) {
        JsonFormat.Value r2 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.getFeature(r6);
    }

    public final com.fasterxml.jackson.databind.b.s b(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.b.v r3, com.fasterxml.jackson.databind.w r4) {
        if (r3 != null) goto L4;
        return null;
    L4:
        return a(r2, r3, r4.e(), r3.o());
    }

    public com.fasterxml.jackson.databind.b.s b(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.l<?> r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        Nulls r0 = c(r3, r6);
        if (r0 != Nulls.SKIP) goto L7;
        return com.fasterxml.jackson.databind.b.a.q.a();
    L7:
        if (r0 != Nulls.FAIL) goto L16;
        if (r6 != null) goto L15;
        com.fasterxml.jackson.databind.k r2 = r3.b(r5.a());
        if (r2.q() == false) goto L13;
        r2 = r2.x();
    L13:
        return com.fasterxml.jackson.databind.b.a.r.a(r2);
    L15:
        return com.fasterxml.jackson.databind.b.a.r.a(r6, r6.getType().x());
    L16:
        com.fasterxml.jackson.databind.b.s r7 = a(r3, r6, r0, r5);
        if (r7 == null) goto L19;
        return r7;
    L19:
        return r5;
    }

    public Nulls c(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1.c().f();
    L7:
        return r2.c().p().getContentNulls();
    }

    public final com.fasterxml.jackson.databind.b.s a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4, Nulls r5, com.fasterxml.jackson.databind.l<?> r6) {
        com.fasterxml.jackson.databind.d r2 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r5 != Nulls.FAIL) goto L13;
        if (r2 != null) goto L11;
        if (r6 != null) goto L7;
        Class<?> r7 = Object.class;
    L9:
        return com.fasterxml.jackson.databind.b.a.r.a(r3.b(r7));
    L7:
        r7 = r6.a();
        goto L9
    L11:
        return com.fasterxml.jackson.databind.b.a.r.a(r2);
    L13:
        if (r5 != Nulls.AS_EMPTY) goto L36;
        if (r6 != null) goto L17;
        return null;
    L17:
        if (ZeusTransformUtils.instanceOf(r6, com.fasterxml.jackson.databind.b.d.class) == false) goto L25;
        com.fasterxml.jackson.databind.b.d r8 = (com.fasterxml.jackson.databind.b.d) ZeusTransformUtils.preCheckCast(r6, com.fasterxml.jackson.databind.b.d.class, "com.obric.aiagent.plugin");
        if (r8.k().k() == true) goto L25;
        if (r2 != null) goto L22;
        com.fasterxml.jackson.databind.k r9 = r8.j();
    L24:
        return (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.preCheckCast(r3.b(r9, String.format("Cannot create empty instance of %s, no default Creator", new Object[]{r9})), com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
    L22:
        r9 = r2.getType();
    L25:
        com.fasterxml.jackson.databind.l.a r10 = r6.e();
        if (r10 != com.fasterxml.jackson.databind.l.a.f12994a) goto L30;
        return com.fasterxml.jackson.databind.b.a.q.b();
    L30:
        if (r10 != com.fasterxml.jackson.databind.l.a.f12995b) goto L34;
        return com.fasterxml.jackson.databind.b.a.q.a(r6.c(r3));
    L34:
        return new com.fasterxml.jackson.databind.b.a.p(r6);
    L36:
        if (r5 == Nulls.SKIP) goto L38;
        return null;
    L38:
        return com.fasterxml.jackson.databind.b.a.q.a();
    }

    public com.fasterxml.jackson.databind.a.b h(com.fasterxml.jackson.databind.h r3) {
        return r3.a(b(), a(), com.fasterxml.jackson.databind.a.e.j);
    }

    public com.fasterxml.jackson.databind.a.b i(com.fasterxml.jackson.databind.h r3) {
        return r3.a(b(), a(), com.fasterxml.jackson.databind.a.e.h);
    }

    public com.fasterxml.jackson.databind.a.b j(com.fasterxml.jackson.databind.h r3) {
        return r3.a(b(), a(), com.fasterxml.jackson.databind.a.b.f12185a);
    }

    public void b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3, String r4) {
        if (r3 != null) goto L5;
        r3 = a();
    L5:
        if (r2.a(r1, this, r3, r4) == false) goto L7;
        return;
    L7:
        r1.k();
    }

    public void D(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        r5.a(this, com.fasterxml.jackson.a.n.f12155e, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", new Object[]{a().getName()});
    }

    public Object E(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        return r11.a(f(r11), r10.l(), r10, String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(this.B), com.fasterxml.jackson.a.n.f12154d, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"}), new Object[0]);
    }

    public void F(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        if (r3.g() == com.fasterxml.jackson.a.n.f12155e) goto L6;
        D(r3, r4);
        return;
    }

    public Number a(Number r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return 0;
    }
}
