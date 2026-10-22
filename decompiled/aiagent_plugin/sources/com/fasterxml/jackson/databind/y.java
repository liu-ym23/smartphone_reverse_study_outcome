package com.fasterxml.jackson.databind;

import java.io.Serializable;

/* JADX INFO: compiled from: PropertyNamingStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public class y implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final y f13137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final y f13138b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final y f13139c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final y f13140d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final y f13141e = null;

    @Deprecated
    public static final y f = null;

    @Deprecated
    public static final y g = null;

    @Deprecated
    public static final y h = null;

    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class a extends d {
        public a() {
        }

        @Override // com.fasterxml.jackson.databind.y.d
        public String a(String r1) {
            return a(r1, '-');
        }
    }

    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class b extends d {
        public b() {
        }

        @Override // com.fasterxml.jackson.databind.y.d
        public String a(String r1) {
            return r1.toLowerCase();
        }
    }

    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class c extends d {
        public c() {
        }

        @Override // com.fasterxml.jackson.databind.y.d
        public String a(String r1) {
            return a(r1, '.');
        }
    }

    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static abstract class d extends y {
        public abstract String a(String r1);

        public d() {
        }

        @Override // com.fasterxml.jackson.databind.y
        public String a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.h r2, String r3) {
            return a(r3);
        }

        @Override // com.fasterxml.jackson.databind.y
        public String a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.k r2, String r3) {
            return a(r3);
        }

        @Override // com.fasterxml.jackson.databind.y
        public String b(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.k r2, String r3) {
            return a(r3);
        }

        @Override // com.fasterxml.jackson.databind.y
        public String a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.n r2, String r3) {
            return a(r3);
        }

        public static String a(String r7, char r8) {
            if (r7 != null) goto L4;
            return r7;
        L4:
            int r0 = r7.length();
            if (r0 != 0) goto L7;
            return r7;
        L7:
            StringBuilder r1 = new StringBuilder((r0 >> 1) + r0);
            int r3 = 0;
            int r4 = 0;
        L8:
            if (r3 >= r0) goto L21;
            char r5 = r7.charAt(r3);
            char r6 = Character.toLowerCase(r5);
            if (r6 == r5) goto L12;
            if (r4 != 0) goto L18;
            if (r3 <= 0) goto L18;
            r1.append(r8);
        L18:
            r4 = r4 + 1;
        L19:
            r1.append(r6);
            r3 = r3 + 1;
            goto L8
        L12:
            if (r4 <= 1) goto L14;
            r1.insert(r1.length() - 1, r8);
        L14:
            r4 = 0;
            goto L19
        L21:
            return r1.toString();
        }
    }

    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class e extends d {
        public e() {
        }

        @Override // com.fasterxml.jackson.databind.y.d
        public String a(String r10) {
            if (r10 != null) goto L4;
            return r10;
        L4:
            int r9 = r10.length();
            StringBuilder r0 = new StringBuilder(r9 * 2);
            int r2 = 0;
            int r3 = 0;
            boolean r4 = false;
        L5:
            if (r2 >= r9) goto L20;
            char r5 = r10.charAt(r2);
            if (r2 > 0) goto L10;
            if (r5 != '_') goto L10;
        L19:
            r2 = r2 + 1;
        L10:
            if (Character.isUpperCase(r5) == false) goto L17;
            if (r4 == true) goto L16;
            if (r3 <= 0) goto L16;
            if (r0.charAt(r3 - 1) == '_') goto L16;
            r0.append('_');
            r3 = r3 + 1;
        L16:
            r5 = Character.toLowerCase(r5);
            r4 = true;
        L18:
            r0.append(r5);
            r3 = r3 + 1;
            goto L19
        L17:
            r4 = false;
            goto L18
        L20:
            if (r3 > 0) goto L22;
            return r10;
        L22:
            return r0.toString();
        }
    }

    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class f extends d {
        public f() {
        }

        @Override // com.fasterxml.jackson.databind.y.d
        public String a(String r3) {
            if (r3 != null) goto L4;
        L11:
            return r3;
        L4:
            if (r3.isEmpty() == true) goto L11;
            char r0 = r3.charAt(0);
            char r1 = Character.toUpperCase(r0);
            if (r0 != r1) goto L9;
            return r3;
        L9:
            StringBuilder r2 = new StringBuilder(r3);
            r2.setCharAt(0, r1);
            return r2.toString();
        }
    }

    public String a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.h r2, String r3) {
        return r3;
    }

    public String a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.k r2, String r3) {
        return r3;
    }

    public String a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.n r2, String r3) {
        return r3;
    }

    public String b(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.k r2, String r3) {
        return r3;
    }

    public y() {
    }

    static {
        f13137a = new y();
        f r0 = new f();
        f13138b = r0;
        e r1 = new e();
        f13139c = r1;
        f13140d = new b();
        f13141e = new a();
        f = new c();
        g = r1;
        h = r0;
    }
}
