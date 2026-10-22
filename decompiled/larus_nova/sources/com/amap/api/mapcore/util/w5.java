package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;

/* JADX INFO: loaded from: classes28.dex */
@c7(tableName = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY)
public class w5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d7(fieldName = "a1", fieldType = 6)
    private String f28290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d7(fieldName = "a2", fieldType = 6)
    private String f28291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d7(fieldName = "a6", fieldType = 2)
    private int f28292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d7(fieldName = "a3", fieldType = 6)
    private String f28293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d7(fieldName = "a4", fieldType = 6)
    private String f28294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d7(fieldName = "a5", fieldType = 6)
    private String f28295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f28298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f28299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f28300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String[] f28301l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f28303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f28304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f28305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String[] f28306e;

        public w5 a() throws k5 {
            if (this.f28306e == null) goto L7;
            return new w5(this, 0);
        L7:
            throw new k5("sdk packages is null");
        }

        public static /* synthetic */ String b(a r100) {
            return r100.f28303b;
        }

        public static /* synthetic */ String c(a r100) {
            return r100.f28304c;
        }

        public static /* synthetic */ String d(a r100) {
            return r100.f28305d;
        }

        public static /* synthetic */ boolean e(a r100) {
            r100.getClass();
            return true;
        }

        public static /* synthetic */ String f(a r100) {
            r100.getClass();
            return "standard";
        }

        public static /* synthetic */ String[] g(a r100) {
            return r100.f28306e;
        }

        public a a(String[] r100) {
            if (r100 == null) goto L4;
            this.f28306e = (String[]) r100.clone();
        L4:
            return this;
        }

        public a a(String r100) {
            this.f28303b = r100;
            return this;
        }

        public static /* synthetic */ String a(a r100) {
            return r100.f28302a;
        }

        public a(String r100, String r101, String r102) {
            this.f28306e = null;
            this.f28302a = r101;
            this.f28303b = r101;
            this.f28305d = r102;
            this.f28304c = r100;
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f28300k) == false) goto L8;
        if (TextUtils.isEmpty(this.f28295f) == true) goto L8;
        this.f28300k = x5.b(this.f28295f);
    L8:
        if (TextUtils.isEmpty(this.f28300k) == false) goto L11;
        this.f28300k = "standard";
    L11:
        return this.f28300k;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f28297h) == false) goto L8;
        if (TextUtils.isEmpty(this.f28291b) == true) goto L8;
        this.f28297h = x5.b(this.f28291b);
    L8:
        return this.f28297h;
    }

    public String[] c() {
        String[] r100 = this.f28301l;
        if (r100 == null) goto L7;
        if (r100.length == 0) goto L7;
    L15:
        return (String[]) this.f28301l.clone();
    L7:
        if (TextUtils.isEmpty(this.f28294e) == true) goto L15;
        String[] r101 = x5.b(this.f28294e).split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L11
    L13:
        this.f28301l = r101;
    L11:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L13
    }

    public String d() {
        if (TextUtils.isEmpty(this.f28299j) == false) goto L8;
        if (TextUtils.isEmpty(this.f28290a) == true) goto L8;
        this.f28299j = x5.b(this.f28290a);
    L8:
        return this.f28299j;
    }

    public boolean f() {
        if (this.f28292c != 1) goto L5;
        return true;
    L5:
        return false;
    }

    private w5() {
        this.f28292c = 1;
        this.f28301l = null;
    }

    public String e() {
        return this.f28296g;
    }

    private w5(a r100) {
        this.f28292c = 1;
        this.f28301l = null;
        this.f28296g = a.a(r100);
        this.f28297h = a.b(r100);
        this.f28299j = a.c(r100);
        this.f28298i = a.d(r100);
        a.e(r100);
        this.f28292c = 1;
        a.f(r100);
        this.f28300k = "standard";
        this.f28301l = a.g(r100);
        this.f28291b = x5.f(this.f28297h);
        this.f28290a = x5.f(this.f28299j);
        this.f28293d = x5.f(this.f28298i);
        this.f28294e = x5.f(a(this.f28301l));
        this.f28295f = x5.f(this.f28300k);
    }

    private static String a(String[] r100) {
        if (r100 != null) goto L13;
        return null;
    L13:
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L10
        int r102 = r100.length;     // Catch: Throwable -> L10
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101.append(r100[r103]);     // Catch: Throwable -> L10
        r101.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L10
        r103 = r103 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r101.toString();
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if (getClass() == r100.getClass()) goto L20;
        return false;
    L20:
        if (this.f28299j.equals(((w5) r100).f28299j) == false) goto L18;
        if (this.f28296g.equals(((w5) r100).f28296g) == false) goto L18;
        if (this.f28297h.equals(((w5) r100).f28297h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public void a(boolean r100) {
        this.f28292c = r100 ? 1 : 0;
    }

    public /* synthetic */ w5(a r100, byte r101) {
        this(r100);
    }
}
