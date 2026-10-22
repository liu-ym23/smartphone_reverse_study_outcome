package com.amap.api.col.jmsl;

import android.os.Build;

/* loaded from: classes.dex */
public enum l6 {
    MIUI(C1604s2.m("IeGlhb21p")),
    Flyme(C1604s2.m("IbWVpenU")),
    RH(C1604s2.m("IaHVhd2Vp")),
    ColorOS(C1604s2.m("Ib3Bwbw")),
    FuntouchOS(C1604s2.m("Idml2bw")),
    SmartisanOS(C1604s2.m("Mc21hcnRpc2Fu")),
    AmigoOS(C1604s2.m("IYW1pZ28")),
    EUI(C1604s2.m("IbGV0dg")),
    Sense(C1604s2.m("EaHRj")),
    LG(C1604s2.m("EbGdl")),
    Google(C1604s2.m("IZ29vZ2xl")),
    NubiaUI(C1604s2.m("IbnViaWE")),
    Other("");


    /* renamed from: a, reason: collision with root package name */
    private String f16738a;

    /* renamed from: b, reason: collision with root package name */
    private int f16739b;

    /* renamed from: c, reason: collision with root package name */
    private String f16740c;

    /* renamed from: d, reason: collision with root package name */
    private String f16741d;

    /* renamed from: e, reason: collision with root package name */
    private String f16742e = Build.MANUFACTURER;

    l6(String str) {
        this.f16738a = str;
    }

    public final void a(int i10) {
        this.f16739b = i10;
    }

    public final void b(String str) {
        this.f16741d = str;
    }

    public final String f() {
        return this.f16738a;
    }

    public final String g() {
        return this.f16740c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f16739b + ", versionName='" + this.f16741d + "',ma=" + this.f16738a + "',manufacturer=" + this.f16742e + "'}";
    }

    public final void a(String str) {
        this.f16740c = str;
    }
}
