package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* loaded from: classes.dex */
public final class q extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f7755a;

    public q(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f7755a;
    }

    public q(String str, Exception exc) {
        super(str);
        this.f7755a = exc;
    }
}
