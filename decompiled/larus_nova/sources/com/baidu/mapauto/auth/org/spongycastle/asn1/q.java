package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* JADX INFO: loaded from: classes39.dex */
public final class q extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f31875a;

    public q(String r100) {
        super(r100);
    }

    public q(String r100, Exception r101) {
        super(r100);
        this.f31875a = r101;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f31875a;
    }
}
