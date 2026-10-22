package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: StdKeyDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class ac extends com.fasterxml.jackson.databind.q implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f12376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<?> f12377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final o<?> f12378c;

    /* JADX INFO: compiled from: StdKeyDeserializer.java */
    static final class a extends com.fasterxml.jackson.databind.q implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Class<?> f12379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.l<?> f12380b;

        public a(Class<?> r1, com.fasterxml.jackson.databind.l<?> r2) {
            this.f12379a = r1;
            this.f12380b = r2;
        }

        @Override // com.fasterxml.jackson.databind.q
        public final Object a(String r5, com.fasterxml.jackson.databind.h r6) {
            if (r5 != null) goto L5;
            return null;
        L5:
            com.fasterxml.jackson.databind.l.y r0 = r6.m();
            r0.b(r5);
            com.fasterxml.jackson.a.k r1 = r0.o();     // Catch: Exception -> L11
            r1.g();     // Catch: Exception -> L11
            Object r2 = this.f12380b.a(r1, r6);     // Catch: Exception -> L11
            if (r2 == null) goto L9;
            return r2;
        L9:
            return r6.a(this.f12379a, r5, "not a valid representation", new Object[0]);
        L11:
            e = move-exception;
            return r6.a(this.f12379a, r5, "not a valid representation: %s", new Object[]{e.getMessage()});
        }
    }

    /* JADX INFO: compiled from: StdKeyDeserializer.java */
    @JacksonStdImpl
    static final class b extends ac {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.l.k f12381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.e.k f12382e;
        protected com.fasterxml.jackson.databind.l.k f;
        protected final Enum<?> g;

        public b(com.fasterxml.jackson.databind.l.k r3, com.fasterxml.jackson.databind.e.k r4) {
            super(-1, r3.e());
            this.f12381d = r3;
            this.f12382e = r4;
            this.g = r3.b();
        }

        @Override // com.fasterxml.jackson.databind.b.b.ac
        public Object b(String r4, com.fasterxml.jackson.databind.h r5) {
            com.fasterxml.jackson.databind.e.k r0 = this.f12382e;
            if (r0 == null) goto L9;
            return r0.a(r4);
        L6:
            e = move-exception;
            com.fasterxml.jackson.databind.l.h.g(e);
        L9:
            if (r5.a(com.fasterxml.jackson.databind.i.w) == false) goto L11;
            com.fasterxml.jackson.databind.l.k r1 = a(r5);
        L12:
            Enum<?> r2 = r1.a(r4);
            if (r2 == null) goto L15;
            return r2;
        L15:
            if (this.g == null) goto L20;
            if (r5.a(com.fasterxml.jackson.databind.i.y) == false) goto L20;
            return this.g;
        L20:
            if (r5.a(com.fasterxml.jackson.databind.i.x) == false) goto L22;
            return r2;
        L22:
            return r5.a(this.f12377b, r4, "not one of the values accepted for Enum class: %s", new Object[]{r1.d()});
        L11:
            r1 = this.f12381d;
            goto L12
        }

        private com.fasterxml.jackson.databind.l.k a(com.fasterxml.jackson.databind.h r2) {
            com.fasterxml.jackson.databind.l.k r0 = this.f;
            if (r0 != null) goto L11;
            monitor-enter(this);
            r0 = com.fasterxml.jackson.databind.l.k.b(r2.c(), this.f12381d.e());     // Catch: Throwable -> L8
            this.f = r0;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        L11:
            return r0;
        }
    }

    /* JADX INFO: compiled from: StdKeyDeserializer.java */
    static final class c extends ac {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final Constructor<?> f12383d;

        public c(Constructor<?> r3) {
            super(-1, r3.getDeclaringClass());
            this.f12383d = r3;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ac
        public Object b(String r2, com.fasterxml.jackson.databind.h r3) {
            return this.f12383d.newInstance(new Object[]{r2});
        }
    }

    /* JADX INFO: compiled from: StdKeyDeserializer.java */
    static final class d extends ac {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Method f12384d;

        public d(Method r3) {
            super(-1, r3.getDeclaringClass());
            this.f12384d = r3;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ac
        public Object b(String r2, com.fasterxml.jackson.databind.h r3) {
            return this.f12384d.invoke(null, new Object[]{r2});
        }
    }

    /* JADX INFO: compiled from: StdKeyDeserializer.java */
    @JacksonStdImpl
    static final class e extends ac {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final e f12385d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final e f12386e = null;

        @Override // com.fasterxml.jackson.databind.b.b.ac, com.fasterxml.jackson.databind.q
        public Object a(String r1, com.fasterxml.jackson.databind.h r2) {
            return r1;
        }

        static {
            f12385d = new e(String.class);
            f12386e = new e(Object.class);
        }

        private e(Class<?> r2) {
            super(-1, r2);
        }

        public static e b(Class<?> r1) {
            if (r1 != String.class) goto L7;
            return f12385d;
        L7:
            if (r1 != Object.class) goto L11;
            return f12386e;
        L11:
            return new e(r1);
        }
    }

    public ac(int r2, Class<?> r3) {
        this(r2, r3, null);
    }

    public ac(int r1, Class<?> r2, o<?> r3) {
        this.f12376a = r1;
        this.f12377b = r2;
        this.f12378c = r3;
    }

    public static ac a(Class<?> r3) {
        if (r3 == String.class) goto L69;
        if (r3 == Object.class) goto L69;
        if (r3 == CharSequence.class) goto L69;
        if (r3 == Serializable.class) goto L69;
        if (r3 != UUID.class) goto L15;
        int r0 = 12;
    L65:
        return new ac(r0, r3);
    L15:
        if (r3 != Integer.class) goto L18;
        r0 = 5;
        goto L65
    L18:
        if (r3 != Long.class) goto L21;
        r0 = 6;
        goto L65
    L21:
        if (r3 != Date.class) goto L24;
        r0 = 10;
        goto L65
    L24:
        if (r3 != Calendar.class) goto L27;
        r0 = 11;
        goto L65
    L27:
        if (r3 != Boolean.class) goto L30;
        r0 = 1;
        goto L65
    L30:
        if (r3 != Byte.class) goto L33;
        r0 = 2;
        goto L65
    L33:
        if (r3 != Character.class) goto L36;
        r0 = 4;
        goto L65
    L36:
        if (r3 != Short.class) goto L39;
        r0 = 3;
        goto L65
    L39:
        if (r3 != Float.class) goto L42;
        r0 = 7;
        goto L65
    L42:
        if (r3 != Double.class) goto L45;
        r0 = 8;
        goto L65
    L45:
        if (r3 != URI.class) goto L48;
        r0 = 13;
        goto L65
    L48:
        if (r3 != URL.class) goto L51;
        r0 = 14;
        goto L65
    L51:
        if (r3 != Class.class) goto L54;
        r0 = 15;
        goto L65
    L54:
        if (r3 != Locale.class) goto L58;
        return new ac(9, r3, o.a(Locale.class));
    L58:
        if (r3 != Currency.class) goto L62;
        return new ac(16, r3, o.a(Currency.class));
    L62:
        if (r3 != byte[].class) goto L66;
        r0 = 17;
        goto L65
    L66:
        return null;
    L69:
        return e.b(r3);
    }

    @Override // com.fasterxml.jackson.databind.q
    public Object a(String r5, com.fasterxml.jackson.databind.h r6) {
        if (r5 != null) goto L19;
        return null;
    L19:
        Object r2 = b(r5, r6);     // Catch: Exception -> L16
        if (r2 == null) goto L10;
        return r2;
    L10:
        if (com.fasterxml.jackson.databind.l.h.l(this.f12377b) == false) goto L15;
        if (r6.c().a(com.fasterxml.jackson.databind.i.x) == false) goto L15;
        return null;
    L15:
        return r6.a(this.f12377b, r5, "not a valid representation", new Object[0]);
    L16:
        e = move-exception;
        return r6.a(this.f12377b, r5, "not a valid representation, problem: (%s) %s", new Object[]{e.getClass().getName(), com.fasterxml.jackson.databind.l.h.h(e)});
    }

    public Object b(String r4, com.fasterxml.jackson.databind.h r5) {
        switch(this.f12376a) {
            case 1: goto L77;
            case 2: goto L67;
            case 3: goto L58;
            case 4: goto L53;
            case 5: goto L51;
            case 6: goto L49;
            case 7: goto L47;
            case 8: goto L45;
            case 9: goto L96;
            case 10: goto L38;
            case 11: goto L36;
            case 12: goto L86;
            case 13: goto L98;
            case 14: goto L90;
            case 15: goto L94;
            case 16: goto L92;
            case 17: goto L88;
            default: goto L5;
        };
    L58:
        int r0 = a(r4);
        if (r0 < (-32768)) goto L66;
        if (r0 > 32767) goto L66;
        return Short.valueOf((short) r0);
    L66:
        return r5.a(this.f12377b, r4, "overflow, value cannot be represented as 16-bit value", new Object[0]);
    L67:
        int r1 = a(r4);
        if (r1 < (-128)) goto L75;
        if (r1 > 255) goto L75;
        return Byte.valueOf((byte) r1);
    L75:
        return r5.a(this.f12377b, r4, "overflow, value cannot be represented as 8-bit value", new Object[0]);
    L86:
        return UUID.fromString(r4);
    L32:
        e = move-exception;
        return a(r5, r4, e);
    L88:
        return r5.c().u().a(r4);
    L8:
        e = move-exception;
        return a(r5, r4, e);
    L90:
        return new URL(r4);
    L22:
        e = move-exception;
        return a(r5, r4, e);
    L92:
        return this.f12378c.a(r4, r5);
    L13:
        e = move-exception;
        return a(r5, r4, e);
    L94:
        return r5.c(r4);
    L19:
        return r5.a(this.f12377b, r4, "unable to parse key as Class", new Object[0]);
    L96:
        return this.f12378c.a(r4, r5);
    L41:
        e = move-exception;
        return a(r5, r4, e);
    L98:
        return URI.create(r4);
    L27:
        e = move-exception;
        return a(r5, r4, e);
    L5:
        throw new IllegalStateException("Internal error: unknown key type " + this.f12377b);
    L36:
        return r5.a(r5.d(r4));
    L38:
        return r5.d(r4);
    L45:
        return Double.valueOf(c(r4));
    L47:
        return Float.valueOf((float) c(r4));
    L49:
        return Long.valueOf(b(r4));
    L51:
        return Integer.valueOf(a(r4));
    L53:
        if (r4.length() != 1) goto L57;
        return Character.valueOf(r4.charAt(0));
    L57:
        return r5.a(this.f12377b, r4, "can only convert 1-character Strings", new Object[0]);
    L77:
        if ("true".equals(r4) == false) goto L81;
        return Boolean.TRUE;
    L81:
        if ("false".equals(r4) == false) goto L85;
        return Boolean.FALSE;
    L85:
        return r5.a(this.f12377b, r4, "value not 'true' or 'false'", new Object[0]);
    }

    public int a(String r1) {
        return Integer.parseInt(r1);
    }

    public long b(String r1) {
        return Long.parseLong(r1);
    }

    public double c(String r1) {
        return com.fasterxml.jackson.a.d.i.c(r1);
    }

    public Object a(com.fasterxml.jackson.databind.h r3, String r4, Exception r5) {
        return r3.a(this.f12377b, r4, "problem: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5)});
    }
}
