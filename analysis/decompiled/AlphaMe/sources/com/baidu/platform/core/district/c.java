package com.baidu.platform.core.district;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.c {
    public c(String str) {
        b(str);
    }

    private void b(String str) {
        this.f8580d.a("qt", "ext");
        this.f8580d.a("num", "1000");
        this.f8580d.a("l", "10");
        this.f8580d.a("ie", "utf-8");
        this.f8580d.a("oue", "1");
        this.f8580d.a("res", "api");
        this.f8580d.a("fromproduct", "android_map_sdk");
        this.f8580d.a("uid", str);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.p();
    }
}
