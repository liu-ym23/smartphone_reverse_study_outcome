package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* JADX INFO: loaded from: classes39.dex */
public final class c extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f31919a;

    public c(String r100, Exception r101) {
        super(r100);
        this.f31919a = r101;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f31919a;
    }
}
