package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class bm extends m implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f31577c;

    /* renamed from: a, reason: collision with root package name */
    public String f31578a = "";

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f31579b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31578a = k10.u(0, true);
        if (f31577c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f31577c = arrayList;
            arrayList.add("");
        }
        this.f31579b = (ArrayList) k10.i(f31577c, 1, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.j(this.f31578a, 0);
        ArrayList<String> arrayList = this.f31579b;
        if (arrayList != null) {
            l10.k(arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
    }
}
