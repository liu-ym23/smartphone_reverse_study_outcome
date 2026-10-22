package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class g extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f7714a;

    public g(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f7714a;
    }

    public g(String str, IllegalArgumentException illegalArgumentException) {
        super(str);
        this.f7714a = illegalArgumentException;
    }
}
