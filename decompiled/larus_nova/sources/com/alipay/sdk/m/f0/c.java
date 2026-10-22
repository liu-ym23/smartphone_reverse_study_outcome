package com.alipay.sdk.m.f0;

/* JADX INFO: loaded from: classes28.dex */
public class c extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25282l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25283m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25284n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25285o = "APPKEY_ERROR";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25286p = "SUCCESS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f25291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f25292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f25293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f25294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f25295k;

    public c() {
        this.f25295k = "";
    }

    public String a() {
        String r100 = this.f25290f;
        if (r100 != null) goto L6;
        return "0";
    L6:
        return r100;
    }

    public boolean b() {
        return "1".equals(this.f25289e);
    }

    public int c() {
        if (this.f25280a == false) goto L10;
        if (com.alipay.sdk.m.z.a.a(this.f25287c) == false) goto L7;
        return 2;
    L7:
        return 1;
    L10:
        if (f25285o.equals(this.f25281b) == false) goto L13;
        return 3;
    L13:
        return 2;
    }
}
