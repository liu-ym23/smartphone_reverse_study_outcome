package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class bv extends m implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList<bu> f31677f;

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, String> f31678g;

    /* renamed from: a, reason: collision with root package name */
    public byte f31679a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f31680b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f31681c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<bu> f31682d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f31683e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31679a = k10.a(this.f31679a, 0, true);
        this.f31680b = k10.u(1, false);
        this.f31681c = k10.u(2, false);
        if (f31677f == null) {
            f31677f = new ArrayList<>();
            f31677f.add(new bu());
        }
        this.f31682d = (ArrayList) k10.i(f31677f, 3, false);
        if (f31678g == null) {
            HashMap map = new HashMap();
            f31678g = map;
            map.put("", "");
        }
        this.f31683e = (Map) k10.i(f31678g, 4, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.b(this.f31679a, 0);
        String str = this.f31680b;
        if (str != null) {
            l10.j(str, 1);
        }
        String str2 = this.f31681c;
        if (str2 != null) {
            l10.j(str2, 2);
        }
        ArrayList<bu> arrayList = this.f31682d;
        if (arrayList != null) {
            l10.k(arrayList, 3);
        }
        Map<String, String> map = this.f31683e;
        if (map != null) {
            l10.l(map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
    }
}
