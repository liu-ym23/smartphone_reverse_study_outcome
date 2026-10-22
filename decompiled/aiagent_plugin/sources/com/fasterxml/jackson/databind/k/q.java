package com.fasterxml.jackson.databind.k;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: TypeParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final o f12990a;

    /* JADX INFO: compiled from: TypeParser.java */
    static final class a extends StringTokenizer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final String f12991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected int f12992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected String f12993c;

        public a(String r3) {
            super(r3, "<,>", true);
            this.f12991a = r3;
        }

        @Override // java.util.StringTokenizer
        public boolean hasMoreTokens() {
            if (this.f12993c == null) goto L5;
        L8:
            return true;
        L5:
            if (super.hasMoreTokens() == true) goto L8;
            return false;
        }

        @Override // java.util.StringTokenizer
        public String nextToken() {
            String r0 = this.f12993c;
            if (r0 == null) goto L5;
            this.f12993c = null;
            return r0;
        L5:
            String r1 = super.nextToken();
            this.f12992b += r1.length();
            return r1.trim();
        }

        public void a(String r1) {
            this.f12993c = r1;
        }

        public String a() {
            return this.f12991a;
        }

        public String b() {
            return this.f12991a.substring(this.f12992b);
        }
    }

    public q(o r1) {
        this.f12990a = r1;
    }

    public com.fasterxml.jackson.databind.k a(String r3) {
        a r0 = new a(r3.trim());
        com.fasterxml.jackson.databind.k r4 = a(r0);
        if (r0.hasMoreTokens() == true) goto L6;
        return r4;
    L6:
        throw a(r0, "Unexpected tokens after complete type");
    }

    public com.fasterxml.jackson.databind.k a(a r5) {
        if (r5.hasMoreTokens() == false) goto L14;
        Class<?> r0 = a(r5.nextToken(), r5);
        if (r5.hasMoreTokens() == false) goto L12;
        String r1 = r5.nextToken();
        if ("<".equals(r1) == false) goto L10;
        n r6 = n.a(r0, b(r5));
        return this.f12990a.a(null, r0, r6);
    L10:
        r5.a(r1);
    L12:
        return this.f12990a.a(null, r0, n.a());
    L14:
        throw a(r5, "Unexpected end-of-string");
    }

    public List<com.fasterxml.jackson.databind.k> b(a r4) {
        ArrayList r0 = new ArrayList();
    L4:
        if (r4.hasMoreTokens() == false) goto L16;
        r0.add(a(r4));
        if (r4.hasMoreTokens() == false) goto L16;
        String r1 = r4.nextToken();
        if (">".equals(r1) == true) goto L9;
        if (",".equals(r1) == true) goto L4;
        throw a(r4, "Unexpected token '" + r1 + "', expected ',' or '>')");
    L9:
        return r0;
    L16:
        throw a(r4, "Unexpected end-of-string");
    }

    public Class<?> a(String r4, a r5) {
        return this.f12990a.a(r4);
    L4:
        e = move-exception;
        com.fasterxml.jackson.databind.l.h.b(e);
        throw a(r5, "Cannot locate class '" + r4 + "', problem: " + e.getMessage());
    }

    public IllegalArgumentException a(a r4, String r5) {
        return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", new Object[]{r4.a(), r4.b(), r5}));
    }
}
