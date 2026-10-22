package com.baidu.mshield.x0.l;

import com.baidu.mshield.x0.d.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f32540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f32544e;

    public int hashCode() {
        int r100 = 1;
        String r101 = this.f32543d;     // Catch: Throwable -> L16
        int r102 = 0;
        if (r101 != null) goto L6;
        int r103 = 0;
    L7:
        int r104 = (r103 + 31) * 31;     // Catch: Throwable -> L16
        String r105 = this.f32544e;     // Catch: Throwable -> L16
        if (r105 != null) goto L10;
        int r106 = 0;
    L11:
        r100 = r106 + r104;     // Catch: Throwable -> L16
        int r107 = r100 * 31;     // Catch: Throwable -> L16
        String r108 = this.f32541b;     // Catch: Throwable -> L16
        if (r108 == null) goto L21;
        r102 = r108.hashCode();     // Catch: Throwable -> L16
    L21:
        return r107 + r102;
    L10:
        r106 = r105.hashCode();     // Catch: Throwable -> L16
        goto L11
    L6:
        r103 = r101.hashCode();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.a(th);
        return r100;
    }

    public b() {
    }

    public static b a(String r100) {
        b r101 = new b();
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L5
        r101.f32540a = r102.optString("0");     // Catch: Throwable -> L5
        r101.f32542c = r102.optString("1");     // Catch: Throwable -> L5
        r101.f32543d = r102.optString("2");     // Catch: Throwable -> L5
        r101.f32544e = r102.optString("3");     // Catch: Throwable -> L5
        r101.f32541b = r102.optString("4");     // Catch: Throwable -> L5
        return r101;
    L5:
        th = move-exception;
        d.a(th);
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
        d.a(th);
    L37:
        return true;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        b r101 = (b) r100;     // Catch: Throwable -> L35
        String r102 = this.f32543d;     // Catch: Throwable -> L35
        if (r102 != null) goto L17;
        if (r101.f32543d == null) goto L19;
        return false;
    L19:
        String r103 = this.f32544e;     // Catch: Throwable -> L35
        if (r103 != null) goto L25;
        if (r101.f32544e == null) goto L27;
        return false;
    L27:
        String r104 = this.f32541b;     // Catch: Throwable -> L35
        if (r104 != null) goto L33;
        if (r101.f32541b == null) goto L37;
        return false;
    L33:
        if (r104.equals(r101.f32541b) == true) goto L37;
        return false;
    L25:
        if (r103.equals(r101.f32544e) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f32543d) == true) goto L19;
        return false;
    }
}
