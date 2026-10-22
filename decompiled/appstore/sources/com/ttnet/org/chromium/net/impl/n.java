package com.ttnet.org.chromium.net.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class n extends m {
    public VersionSafeCallbacks.b H;

    public n(Context r10) {
        super(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    public VersionSafeCallbacks.b i0() {
        return this.H;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i t(com.ttnet.org.chromium.net.c.a.b r10) {
        return x0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    public CronetEngineBuilderImpl x0(com.ttnet.org.chromium.net.c.a.b r10) {
        this.H = new VersionSafeCallbacks.b(r10);
        return this;
    }
}
