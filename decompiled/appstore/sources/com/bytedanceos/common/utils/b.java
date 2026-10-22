package com.bytedanceos.common.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10201e;

    public b() {
        this.f10197a = "";
        this.f10198b = "";
        this.f10199c = "";
        this.f10200d = "";
        this.f10201e = 0;
    }

    public static b a(b r10) {
        b r11 = new b();
        if (r10 == null) goto L5;
        r11.i(r10.c()).j(r10.d()).k(r10.e()).l(r10.f());
    L5:
        return r11;
    }

    public static boolean g(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals(r10, "source_other") == true) goto L8;
        return false;
    }

    public int b() {
        return this.f10201e;
    }

    public String c() {
        return this.f10199c;
    }

    public String d() {
        return this.f10200d;
    }

    public String e() {
        return this.f10197a;
    }

    public String f() {
        return this.f10198b;
    }

    public void h(int r10) {
        this.f10201e = r10;
    }

    public b i(String r10) {
        this.f10199c = r10;
        return this;
    }

    public b j(String r10) {
        this.f10200d = r10;
        return this;
    }

    public b k(String r10) {
        this.f10197a = r10;
        return this;
    }

    public b l(String r10) {
        this.f10198b = r10;
        return this;
    }
}
