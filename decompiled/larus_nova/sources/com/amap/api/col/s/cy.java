package com.amap.api.col.s;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class cy {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f26521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f26522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Proxy f26523i;

    public String c() {
        return "";
    }

    public abstract Map<String, String> e();

    public abstract Map<String, String> f();

    public byte[] g() {
        return null;
    }

    public abstract String h();

    public String j() {
        return "";
    }

    public boolean k() {
        return false;
    }

    public cy() {
        this.f26521g = 20000;
        this.f26522h = 20000;
        this.f26523i = null;
    }

    public String a_() {
        return h();
    }

    public final String m() {
        return a(h());
    }

    public final String n() {
        return a(a_());
    }

    public final boolean o() {
        if (TextUtils.isEmpty(j()) == true) goto L6;
        return true;
    L6:
        return false;
    }

    private String a(String r100) {
        byte[] r101 = g();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.length == 0) goto L13;
        Map<String, String> r102 = e();
        if (r102 != null) goto L10;
        return r100;
    L10:
        String r103 = cv.a(r102);
        StringBuffer r104 = new StringBuffer();
        r104.append(r100);
        r104.append("?");
        r104.append(r103);
        return r104.toString();
    L13:
        return r100;
    }

    public final void b(int r100) {
        this.f26522h = r100;
    }

    public final void a(int r100) {
        this.f26521g = r100;
    }
}
