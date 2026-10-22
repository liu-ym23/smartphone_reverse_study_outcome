package com.amap.api.col.s;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public final class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f26317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f26318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f26319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f26320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f26321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f26322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String[] f26323l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f26325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f26326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f26327d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f26328e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f26329f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String[] f26330g;

        public final br a() throws bh {
            if (this.f26330g == null) goto L7;
            return new br(this, 0);
        L7:
            throw new bh("sdk packages is null");
        }

        public static /* synthetic */ String b(a r100) {
            return r100.f26325b;
        }

        public static /* synthetic */ String c(a r100) {
            return r100.f26326c;
        }

        public static /* synthetic */ String d(a r100) {
            return r100.f26327d;
        }

        public static /* synthetic */ boolean e(a r100) {
            return r100.f26328e;
        }

        public static /* synthetic */ String f(a r100) {
            return r100.f26329f;
        }

        public static /* synthetic */ String[] g(a r100) {
            return r100.f26330g;
        }

        public final a a(String[] r100) {
            if (r100 == null) goto L4;
            this.f26330g = (String[]) r100.clone();
        L4:
            return this;
        }

        public final a a(String r100) {
            this.f26325b = r100;
            return this;
        }

        public final a a(boolean r100) {
            this.f26328e = r100;
            return this;
        }

        public static /* synthetic */ String a(a r100) {
            return r100.f26324a;
        }

        public a(String r100, String r101, String r102) {
            this.f26328e = true;
            this.f26329f = "standard";
            this.f26330g = null;
            this.f26324a = r101;
            this.f26325b = r101;
            this.f26327d = r102;
            this.f26326c = r100;
        }
    }

    public final void a() {
        this.f26314c = 1;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f26321j) == false) goto L8;
        if (TextUtils.isEmpty(this.f26312a) == true) goto L8;
        this.f26321j = bs.c(this.f26312a);
    L8:
        return this.f26321j;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f26319h) == false) goto L8;
        if (TextUtils.isEmpty(this.f26313b) == true) goto L8;
        this.f26319h = bs.c(this.f26313b);
    L8:
        return this.f26319h;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f26322k) == false) goto L8;
        if (TextUtils.isEmpty(this.f26317f) == true) goto L8;
        this.f26322k = bs.c(this.f26317f);
    L8:
        if (TextUtils.isEmpty(this.f26322k) == false) goto L11;
        this.f26322k = "standard";
    L11:
        return this.f26322k;
    }

    public final boolean f() {
        if (this.f26314c != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final String[] g() {
        String[] r100 = this.f26323l;
        if (r100 == null) goto L7;
        if (r100.length == 0) goto L7;
    L10:
        return (String[]) this.f26323l.clone();
    L7:
        if (TextUtils.isEmpty(this.f26316e) == true) goto L10;
        this.f26323l = a(bs.c(this.f26316e));
        goto L10
    }

    private br() {
        this.f26314c = 1;
        this.f26323l = null;
    }

    public final String c() {
        return this.f26318g;
    }

    private br(a r100) {
        this.f26314c = 1;
        this.f26323l = null;
        this.f26318g = a.a(r100);
        this.f26319h = a.b(r100);
        this.f26321j = a.c(r100);
        this.f26320i = a.d(r100);
        this.f26314c = a.e(r100) ? 1 : 0;
        this.f26322k = a.f(r100);
        this.f26323l = a.g(r100);
        this.f26313b = bs.b(this.f26319h);
        this.f26312a = bs.b(this.f26321j);
        this.f26315d = bs.b(this.f26320i);
        this.f26316e = bs.b(a(this.f26323l));
        this.f26317f = bs.b(this.f26322k);
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

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if (br.class == r100.getClass()) goto L20;
        return false;
    L20:
        if (this.f26321j.equals(((br) r100).f26321j) == false) goto L18;
        if (this.f26318g.equals(((br) r100).f26318g) == false) goto L18;
        if (this.f26319h.equals(((br) r100).f26319h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private static String[] a(String r100) {
        return r100.split(com.alipay.sdk.m.u.i.f25853b);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public /* synthetic */ br(a r100, byte r101) {
        this(r100);
    }
}
