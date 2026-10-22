package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public final class bl extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f31572a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f31573b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f31574c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f31575d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f31576e = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31572a = k10.u(0, true);
        this.f31573b = k10.u(1, false);
        this.f31574c = k10.u(2, false);
        this.f31575d = k10.u(3, false);
        this.f31576e = k10.u(4, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.j(this.f31572a, 0);
        String str = this.f31573b;
        if (str != null) {
            l10.j(str, 1);
        }
        String str2 = this.f31574c;
        if (str2 != null) {
            l10.j(str2, 2);
        }
        String str3 = this.f31575d;
        if (str3 != null) {
            l10.j(str3, 3);
        }
        String str4 = this.f31576e;
        if (str4 != null) {
            l10.j(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
    }
}
