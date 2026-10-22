package com.fasterxml.jackson.a;

/* JADX INFO: compiled from: Base64Variants.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11978b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11979c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11980d = null;

    static {
        a r6 = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        f11977a = r6;
        f11978b = new a(r6, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        f11979c = new a(r6, "PEM", true, '=', 64);
        StringBuilder r0 = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        r0.setCharAt(r0.indexOf("+"), '-');
        r0.setCharAt(r0.indexOf("/"), '_');
        f11980d = new a("MODIFIED-FOR-URL", r0.toString(), false, 0, Integer.MAX_VALUE);
    }

    public static a a() {
        return f11978b;
    }
}
