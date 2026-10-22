package com.stepos.statsapp.v3.lib.plugin.net.multipart;

/* loaded from: classes2.dex */
public abstract class h extends g {

    /* renamed from: s, reason: collision with root package name */
    private String f30886s;

    /* renamed from: t, reason: collision with root package name */
    private String f30887t;

    /* renamed from: u, reason: collision with root package name */
    private String f30888u;

    /* renamed from: v, reason: collision with root package name */
    private String f30889v;

    public h(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        this.f30886s = str;
        this.f30887t = str2;
        this.f30888u = str3;
        this.f30889v = str4;
    }

    public void a(String str) {
        this.f30888u = str;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public String b() {
        return this.f30888u;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public String c() {
        return this.f30887t;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public String d() {
        return this.f30886s;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public String f() {
        return this.f30889v;
    }

    public void b(String str) {
        this.f30887t = str;
    }

    public void c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        this.f30886s = str;
    }

    public void d(String str) {
        this.f30889v = str;
    }
}
