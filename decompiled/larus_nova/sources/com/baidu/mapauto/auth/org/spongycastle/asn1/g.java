package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class g extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f31834a;

    public g(String r100) {
        super(r100);
    }

    public g(String r100, IllegalArgumentException r101) {
        super(r100);
        this.f31834a = r101;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f31834a;
    }
}
