package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
@c7(tableName = "update_item")
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d7(fieldName = "title", fieldType = 6)
    protected String f27875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d7(fieldName = "url", fieldType = 6)
    protected String f27876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d7(fieldName = "mAdcode", fieldType = 6)
    protected String f27877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d7(fieldName = "fileName", fieldType = 6)
    protected String f27878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d7(fieldName = "version", fieldType = 6)
    protected String f27879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d7(fieldName = "lLocalLength", fieldType = 5)
    protected long f27880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @d7(fieldName = "lRemoteLength", fieldType = 5)
    protected long f27881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @d7(fieldName = "localPath", fieldType = 6)
    protected String f27882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @d7(fieldName = "mIndex", fieldType = 2)
    protected int f27883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @d7(fieldName = "isProvince", fieldType = 2)
    protected int f27884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @d7(fieldName = "mCompleteCode", fieldType = 2)
    protected int f27885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @d7(fieldName = "mCityCode", fieldType = 6)
    protected String f27886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @d7(fieldName = "mState", fieldType = 2)
    public int f27887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @d7(fieldName = "mPinyin", fieldType = 6)
    public String f27888n;

    public q1() {
        this.f27875a = null;
        this.f27876b = null;
        this.f27877c = null;
        this.f27878d = null;
        this.f27879e = "";
        this.f27880f = 0;
        this.f27881g = 0;
        this.f27884j = 0;
        this.f27886l = "";
        this.f27888n = "";
    }

    public String a() {
        return this.f27877c;
    }

    public int b() {
        return this.f27885k;
    }

    public String c() {
        return this.f27875a;
    }

    public String d() {
        return this.f27876b;
    }

    public String e() {
        return this.f27879e;
    }

    public static String a(String r100) {
        return "mAdcode='" + r100 + "'";
    }

    public void b(String r100) {
        this.f27877c = r100;
    }

    public void c(String r100) {
        this.f27886l = r100;
    }
}
