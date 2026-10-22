package com.amap.api.col.jmsl;

import android.content.Context;

/* loaded from: classes.dex */
public class F1 extends AbstractC1619w1 {

    /* renamed from: b, reason: collision with root package name */
    public Context f16081b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16082c;

    public F1(Context context, boolean z10) {
        this.f16081b = context;
        this.f16082c = z10;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public boolean e() {
        return S0.s(this.f16081b) == 1 || this.f16082c;
    }
}
