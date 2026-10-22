package com.fasterxml.jackson.databind.b.b;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.IllformedLocaleException;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FromStringDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o<T> extends ae<T> {

    /* JADX INFO: compiled from: FromStringDeserializer.java */
    public static class a extends o<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final int f12449a;

        public a(Class<?> r1, int r2) {
            super(r1);
            this.f12449a = r2;
        }

        @Override // com.fasterxml.jackson.databind.b.b.o
        public Object a(String r4, com.fasterxml.jackson.databind.h r5) {
            switch(this.f12449a) {
                case 1: goto L50;
                case 2: goto L48;
                case 3: goto L46;
                case 4: goto L51;
                case 5: goto L39;
                case 6: goto L37;
                case 7: goto L35;
                case 8: goto L33;
                case 9: goto L31;
                case 10: goto L29;
                case 11: goto L27;
                case 12: goto L7;
                default: goto L4;
            };
        L4:
            com.fasterxml.jackson.a.h.q.a();
            return null;
        L51:
            return r5.c(r4);
        L42:
            e = move-exception;
            return r5.a(this.B, r4, com.fasterxml.jackson.databind.l.h.d(e));
        L7:
            if (r4.startsWith("[") == false) goto L18;
            int r3 = r4.lastIndexOf(93);
            if (r3 == (-1)) goto L17;
            int r6 = r4.indexOf(58, r3);
            if (r6 <= (-1)) goto L13;
            int r7 = Integer.parseInt(r4.substring(r6 + 1));
        L15:
            return new InetSocketAddress(r4.substring(0, r3 + 1), r7);
        L13:
            r7 = 0;
            goto L15
        L17:
            throw new com.fasterxml.jackson.databind.c.c(r5.j(), "Bracketed IPv6 address must contain closing bracket", r4, InetSocketAddress.class);
        L18:
            int r8 = r4.indexOf(58);
            if (r8 < 0) goto L25;
            int r9 = r8 + 1;
            if (r4.indexOf(58, r9) >= 0) goto L25;
            return new InetSocketAddress(r4.substring(0, r8), Integer.parseInt(r4.substring(r9)));
        L25:
            return new InetSocketAddress(r4, 0);
        L27:
            return InetAddress.getByName(r4);
        L29:
            return TimeZone.getTimeZone(r4);
        L31:
            return Charset.forName(r4);
        L33:
            return c(r4, r5);
        L35:
            return Pattern.compile(r4);
        L37:
            return Currency.getInstance(r4);
        L39:
            return r5.b().d(r4);
        L46:
            return URI.create(r4);
        L48:
            return new URL(r4);
        L50:
            return new File(r4);
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r3) {
            int r0 = this.f12449a;
            if (r0 == 3) goto L11;
            if (r0 == 8) goto L9;
            return super.c(r3);
        L9:
            return Locale.ROOT;
        L11:
            return URI.create("");
        }

        @Override // com.fasterxml.jackson.databind.b.b.o
        public Object e(com.fasterxml.jackson.databind.h r1) {
            return c(r1);
        }

        @Override // com.fasterxml.jackson.databind.b.b.o
        public boolean i() {
            if (this.f12449a == 7) goto L5;
            return true;
        L5:
            return false;
        }

        public int b(String r4) {
            int r3 = r4.length();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L11;
            char r1 = r4.charAt(r0);
            if (r1 == '_') goto L10;
            if (r1 == '-') goto L10;
            r0 = r0 + 1;
        L10:
            return r0;
        L11:
            return -1;
        }

        private Locale c(String r8, com.fasterxml.jackson.databind.h r9) {
            int r10 = b(r8);
            if (r10 < 0) goto L5;
            String r4 = r8.substring(0, r10);
            String r2 = r8.substring(r10 + 1);
            int r3 = b(r2);
            if (r3 < 0) goto L9;
            String r5 = r2.substring(0, r3);
            int r6 = r2.indexOf("_#");
            if (r6 >= 0) goto L15;
            return new Locale(r4, r5, r2.substring(r3 + 1));
        L15:
            return a(r2, r3, r4, r5, r6);
        L9:
            return new Locale(r4, r2);
        L5:
            return new Locale(r8);
        }

        private Locale a(String r3, int r4, String r5, String r6, int r7) {
            String r2 = "";
            if (r7 <= 0) goto L7;
            if (r7 <= r4) goto L7;
            r2 = r3.substring(r4 + 1, r7);     // Catch: IllformedLocaleException -> L19
            goto L7
        L20:
            return new Locale(r5, r6, "");
        L7:
            String r8 = r3.substring(r7 + 2);     // Catch: IllformedLocaleException -> L19
            if (r8.indexOf(95) >= 0) goto L14;
            if (r8.indexOf(45) >= 0) goto L14;
            return new Locale.Builder().setLanguage(r5).setRegion(r6).setVariant(r2).setScript(r8).build();
        L14:
            if (r8.indexOf(95) >= 0) goto L17;
            int r9 = r8.indexOf(45);     // Catch: IllformedLocaleException -> L19
            return new Locale.Builder().setLanguage(r5).setRegion(r6).setVariant(r2).setExtension(r8.charAt(0), r8.substring(r9 + 1)).build();
        L17:
            int r10 = r8.indexOf(95);     // Catch: IllformedLocaleException -> L19
            return new Locale.Builder().setLanguage(r5).setRegion(r6).setVariant(r2).setScript(r8.substring(0, r10)).setExtension(r8.charAt(r10 + 1), r8.substring(r10 + 3)).build();
        }
    }

    /* JADX INFO: compiled from: FromStringDeserializer.java */
    static class b extends o<Object> {
        public b() {
            super(StringBuffer.class);
        }

        @Override // com.fasterxml.jackson.databind.b.b.o, com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.j;
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r1) {
            return new StringBuffer();
        }

        @Override // com.fasterxml.jackson.databind.b.b.o, com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            String r0 = r2.R();
            if (r0 == null) goto L7;
            return a(r0, r3);
        L7:
            return super.a(r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.b.o
        public Object a(String r1, com.fasterxml.jackson.databind.h r2) {
            return new StringBuffer(r1);
        }
    }

    /* JADX INFO: compiled from: FromStringDeserializer.java */
    static class c extends o<Object> {
        public c() {
            super(StringBuilder.class);
        }

        @Override // com.fasterxml.jackson.databind.b.b.o, com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.j;
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r1) {
            return new StringBuilder();
        }

        @Override // com.fasterxml.jackson.databind.b.b.o, com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            String r0 = r2.R();
            if (r0 == null) goto L7;
            return a(r0, r3);
        L7:
            return super.a(r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.b.o
        public Object a(String r1, com.fasterxml.jackson.databind.h r2) {
            return new StringBuilder(r1);
        }
    }

    public abstract T a(String r1, com.fasterxml.jackson.databind.h r2);

    public boolean i() {
        return true;
    }

    public static Class<?>[] h() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, com.fasterxml.jackson.databind.k.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class, StringBuffer.class};
    }

    public o(Class<?> r1) {
        super(r1);
    }

    public static o<?> a(Class<?> r2) {
        if (r2 != File.class) goto L6;
        int r0 = 1;
    L39:
        return new a(r2, r0);
    L6:
        if (r2 != URL.class) goto L9;
        r0 = 2;
        goto L39
    L9:
        if (r2 != URI.class) goto L12;
        r0 = 3;
        goto L39
    L12:
        if (r2 != Class.class) goto L15;
        r0 = 4;
        goto L39
    L15:
        if (r2 != com.fasterxml.jackson.databind.k.class) goto L18;
        r0 = 5;
        goto L39
    L18:
        if (r2 != Currency.class) goto L21;
        r0 = 6;
        goto L39
    L21:
        if (r2 != Pattern.class) goto L24;
        r0 = 7;
        goto L39
    L24:
        if (r2 != Locale.class) goto L27;
        r0 = 8;
        goto L39
    L27:
        if (r2 != Charset.class) goto L30;
        r0 = 9;
        goto L39
    L30:
        if (r2 != TimeZone.class) goto L33;
        r0 = 10;
        goto L39
    L33:
        if (r2 != InetAddress.class) goto L36;
        r0 = 11;
        goto L39
    L36:
        if (r2 != InetSocketAddress.class) goto L41;
        r0 = 12;
        goto L39
    L41:
        if (r2 != StringBuilder.class) goto L45;
        return new c();
    L45:
        if (r2 == StringBuffer.class) goto L47;
        return null;
    L47:
        return new b();
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.m;
    }

    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        String r0 = r5.R();
        if (r0 != null) goto L10;
        com.fasterxml.jackson.a.n r1 = r5.l();
        if (r1 != com.fasterxml.jackson.a.n.f12152b) goto L7;
        r0 = r6.a(r5, this, this.B);
        goto L10
    L7:
        return (T) a(r5, r6, r1);
    L10:
        if (r0.isEmpty() == false) goto L14;
        return (T) d(r6);
    L14:
        if (i() == false) goto L30;
        String r7 = r0.trim();
        if (r7 != r0) goto L18;
    L21:
        r0 = r7;
        goto L30
    L18:
        if (r7.isEmpty() == false) goto L21;
        return (T) d(r6);
    L30:
        return a(r0, r6);
    L24:
        e = move-exception;
        String r2 = "not a valid textual representation";
        String r3 = e.getMessage();
        if (r3 == null) goto L29;
        r2 = "not a valid textual representation, problem: " + r3;
    L29:
        throw r6.a(r0, this.B, r2).a(e);
    }

    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.a.n r4) {
        if (r4 != com.fasterxml.jackson.a.n.f12154d) goto L7;
        return e(r2, r3);
    L7:
        if (r4 != com.fasterxml.jackson.a.n.g) goto L18;
        Object r5 = r2.N();
        if (r5 != null) goto L13;
        return null;
    L13:
        if (this.B.isAssignableFrom(r5.getClass()) == false) goto L16;
        return r5;
    L16:
        return a(r5, r3);
    L18:
        return r3.a(this.B, r2);
    }

    public T a(Object r3, com.fasterxml.jackson.databind.h r4) {
        r4.a(this, "Don't know how to convert embedded Object of type %s into %s", new Object[]{r3.getClass().getName(), this.B.getName()});
        return null;
    }

    public Object d(com.fasterxml.jackson.databind.h r5) {
        com.fasterxml.jackson.databind.a.b r0 = r5.a(b(), this.B, com.fasterxml.jackson.databind.a.e.j);
        if (r0 != com.fasterxml.jackson.databind.a.b.f12185a) goto L6;
        r5.a(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", new Object[]{m()});
    L6:
        if (r0 != com.fasterxml.jackson.databind.a.b.f12187c) goto L10;
        return a(r5);
    L10:
        if (r0 != com.fasterxml.jackson.databind.a.b.f12188d) goto L14;
        return c(r5);
    L14:
        return e(r5);
    }

    public Object e(com.fasterxml.jackson.databind.h r1) {
        return a(r1);
    }
}
