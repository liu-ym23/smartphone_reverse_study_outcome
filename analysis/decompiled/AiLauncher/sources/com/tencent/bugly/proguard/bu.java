package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class bu extends m {

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, String> f31668i;

    /* renamed from: a, reason: collision with root package name */
    public long f31669a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f31670b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f31671c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f31672d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f31673e = "";

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f31674f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f31675g = "";

    /* renamed from: h, reason: collision with root package name */
    public boolean f31676h = true;

    static {
        HashMap map = new HashMap();
        f31668i = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31669a = k10.g(this.f31669a, 0, true);
        this.f31670b = k10.a(this.f31670b, 1, true);
        this.f31671c = k10.u(2, false);
        this.f31672d = k10.u(3, false);
        this.f31673e = k10.u(4, false);
        this.f31674f = (Map) k10.i(f31668i, 5, false);
        this.f31675g = k10.u(6, false);
        this.f31676h = k10.s(7, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.g(this.f31669a, 0);
        l10.b(this.f31670b, 1);
        String str = this.f31671c;
        if (str != null) {
            l10.j(str, 2);
        }
        String str2 = this.f31672d;
        if (str2 != null) {
            l10.j(str2, 3);
        }
        String str3 = this.f31673e;
        if (str3 != null) {
            l10.j(str3, 4);
        }
        Map<String, String> map = this.f31674f;
        if (map != null) {
            l10.l(map, 5);
        }
        String str4 = this.f31675g;
        if (str4 != null) {
            l10.j(str4, 6);
        }
        l10.n(this.f31676h, 7);
    }
}
