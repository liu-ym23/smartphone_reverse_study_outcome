package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class bp extends m implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<bo> f31613b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<bo> f31614a = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        if (f31613b == null) {
            f31613b = new ArrayList<>();
            f31613b.add(new bo());
        }
        this.f31614a = (ArrayList) k10.i(f31613b, 0, true);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.k(this.f31614a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
    }
}
