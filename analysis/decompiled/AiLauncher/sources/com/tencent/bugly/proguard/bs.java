package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public final class bs extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f31651a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f31652b = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31651a = k10.u(0, true);
        this.f31652b = k10.u(1, true);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.j(this.f31651a, 0);
        l10.j(this.f31652b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
    }
}
