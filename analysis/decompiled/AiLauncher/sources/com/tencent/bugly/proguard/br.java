package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class br extends m {

    /* renamed from: i, reason: collision with root package name */
    public static byte[] f31641i = {0};

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f31642j;

    /* renamed from: a, reason: collision with root package name */
    public byte f31643a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f31644b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f31645c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f31646d = "";

    /* renamed from: e, reason: collision with root package name */
    public long f31647e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f31648f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f31649g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f31650h = null;

    static {
        HashMap map = new HashMap();
        f31642j = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31643a = k10.a(this.f31643a, 0, true);
        this.f31644b = k10.d(this.f31644b, 1, true);
        this.f31645c = k10.y(2, false);
        this.f31646d = k10.u(3, false);
        this.f31647e = k10.g(this.f31647e, 4, false);
        this.f31648f = k10.u(5, false);
        this.f31649g = k10.u(6, false);
        this.f31650h = (Map) k10.i(f31642j, 7, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.b(this.f31643a, 0);
        l10.f(this.f31644b, 1);
        byte[] bArr = this.f31645c;
        if (bArr != null) {
            l10.o(bArr, 2);
        }
        String str = this.f31646d;
        if (str != null) {
            l10.j(str, 3);
        }
        l10.g(this.f31647e, 4);
        String str2 = this.f31648f;
        if (str2 != null) {
            l10.j(str2, 5);
        }
        String str3 = this.f31649g;
        if (str3 != null) {
            l10.j(str3, 6);
        }
        Map<String, String> map = this.f31650h;
        if (map != null) {
            l10.l(map, 7);
        }
    }
}
