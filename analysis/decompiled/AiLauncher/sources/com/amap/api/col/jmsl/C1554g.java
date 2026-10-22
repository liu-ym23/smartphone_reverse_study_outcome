package com.amap.api.col.jmsl;

/* renamed from: com.amap.api.col.jmsl.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1554g {

    /* renamed from: a, reason: collision with root package name */
    public String f16628a = "";

    /* renamed from: c, reason: collision with root package name */
    public int f16630c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f16631d = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f16629b = 0;

    public final synchronized String a() {
        return this.f16628a;
    }

    public final synchronized void b(int i10) {
        this.f16629b = i10;
        this.f16631d = 2;
    }

    public final synchronized void c(String str, int i10) {
        try {
            if (this.f16630c == 0) {
                if (str == null) {
                    str = "";
                }
                this.f16628a = str;
                this.f16630c = 1;
            }
            if (this.f16631d == 0) {
                this.f16629b = i10;
                this.f16631d = 1;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int d() {
        return this.f16629b;
    }
}
