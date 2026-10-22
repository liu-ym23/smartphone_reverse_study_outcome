package com.fasterxml.jackson.databind.l;

import java.io.Serializable;

/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f13048a = null;

    /* JADX INFO: compiled from: NameTransformer.java */
    public static class a extends q implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final q f13053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final q f13054c;

        public a(q r1, q r2) {
            this.f13053b = r1;
            this.f13054c = r2;
        }

        @Override // com.fasterxml.jackson.databind.l.q
        public String a(String r2) {
            return this.f13053b.a(this.f13054c.a(r2));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.f13053b + ", " + this.f13054c + ")]";
        }
    }

    /* JADX INFO: compiled from: NameTransformer.java */
    protected static final class b extends q implements Serializable {
        @Override // com.fasterxml.jackson.databind.l.q
        public String a(String r1) {
            return r1;
        }

        public b() {
        }
    }

    public abstract String a(String r1);

    static {
        f13048a = new b();
    }

    public q() {
    }

    public static q a(final String r4, final String r5) {
        boolean r0 = true;
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r5 != null) goto L10;
    L12:
        r0 = false;
    L13:
        if (r2 == false) goto L19;
        if (r0 == false) goto L18;
        return new AnonymousClass1(r4, r5);
    L18:
        return new AnonymousClass2(r4);
    L19:
        if (r0 == false) goto L23;
        return new AnonymousClass3(r5);
    L23:
        return f13048a;
    L10:
        if (r5.isEmpty() == true) goto L12;
    L5:
        if (r4.isEmpty() == true) goto L7;
        r2 = true;
        goto L8
    }

    public static q a(q r1, q r2) {
        return new a(r1, r2);
    }
}
