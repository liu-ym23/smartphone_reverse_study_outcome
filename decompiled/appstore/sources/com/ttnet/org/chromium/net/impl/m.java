package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.v;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m extends CronetEngineBuilderImpl {
    public m(Context r10) {
        super(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i a(String r10, int r11, int r12) {
        return super.B(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.i
    public com.ttnet.org.chromium.net.f b() {
        if (d0() != null) goto L5;
        D0(W());
    L5:
        CronetUrlRequestContext r10 = new CronetUrlRequestContext(this);
        this.f18534n = 0;
        return r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i c(boolean r10) {
        return super.F(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i d(boolean r10) {
        return super.G(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i e(boolean r10) {
        return super.H(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i f(int r10, long r11) {
        return super.I(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i g(boolean r10) {
        return super.J(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i h(boolean r10) {
        return super.K(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i i(boolean r10) {
        return super.M(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i j() {
        return super.N();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i k(boolean r10) {
        return super.j0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i l(long r10) {
        return super.q0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i m(TTAppInfoProvider r10) {
        return super.r0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i n(v r10) {
        return super.s0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i o(String r10) {
        return super.t0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i p(Map r10) {
        return super.u0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i r(com.ttnet.org.chromium.net.u r10) {
        return super.v0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i s(String r10) {
        return super.w0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i u(ArrayList r10) {
        return super.y0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i v(String r10) {
        return super.z0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i w(String r10) {
        return super.A0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i x(String r10) {
        return super.B0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i y(int r10) {
        return super.C0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i z(String r10) {
        return super.D0(r10);
    }
}
