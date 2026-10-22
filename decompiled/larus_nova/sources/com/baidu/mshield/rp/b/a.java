package com.baidu.mshield.rp.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f32392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f32396e;

    public int hashCode() {
        int r100 = 0;
        String r101 = this.f32395d;     // Catch: Throwable -> L17
        if (r101 != null) goto L6;
        int r102 = 0;
    L7:
        int r103 = (r102 + 31) * 31;     // Catch: Throwable -> L17
        String r104 = this.f32396e;     // Catch: Throwable -> L17
        if (r104 != null) goto L10;
        int r105 = 0;
    L11:
        int r106 = (r103 + r105) * 31;     // Catch: Throwable -> L17
        String r107 = this.f32393b;     // Catch: Throwable -> L17
        if (r107 == null) goto L16;
        r100 = r107.hashCode();     // Catch: Throwable -> L17
    L16:
        return r106 + r100;
    L10:
        r105 = r104.hashCode();     // Catch: Throwable -> L17
        goto L11
    L6:
        r102 = r101.hashCode();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return 0;
    }

    public a() {
    }

    public static a a(String r100) {
        a r101 = new a();
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L5
        r101.f32392a = r102.optString("0");     // Catch: Throwable -> L5
        r101.f32394c = r102.optString("1");     // Catch: Throwable -> L5
        r101.f32395d = r102.optString("2");     // Catch: Throwable -> L5
        r101.f32396e = r102.optString("3");     // Catch: Throwable -> L5
        r101.f32393b = r102.optString("4");     // Catch: Throwable -> L5
        return r101;
    L5:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return null;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L38;
        return false;
    L38:
    L35:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L37:
        return true;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        a r101 = (a) r100;     // Catch: Throwable -> L35
        String r102 = this.f32395d;     // Catch: Throwable -> L35
        if (r102 != null) goto L17;
        if (r101.f32395d == null) goto L19;
        return false;
    L19:
        String r103 = this.f32396e;     // Catch: Throwable -> L35
        if (r103 != null) goto L25;
        if (r101.f32396e == null) goto L27;
        return false;
    L27:
        String r104 = this.f32393b;     // Catch: Throwable -> L35
        if (r104 != null) goto L33;
        if (r101.f32393b == null) goto L37;
        return false;
    L33:
        if (r104.equals(r101.f32393b) == true) goto L37;
        return false;
    L25:
        if (r103.equals(r101.f32396e) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f32395d) == true) goto L19;
        return false;
    }

    public static String a(a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("0", r100.f32392a);     // Catch: Throwable -> L13
        r101.put("1", r100.f32394c);     // Catch: Throwable -> L13
        r101.put("2", r100.f32395d);     // Catch: Throwable -> L13
        r101.put("3", r100.f32396e);     // Catch: Throwable -> L13
        r101.put("4", r100.f32393b);     // Catch: Throwable -> L13
    L16:
        return r101.toString();
    L13:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L16
    }
}
