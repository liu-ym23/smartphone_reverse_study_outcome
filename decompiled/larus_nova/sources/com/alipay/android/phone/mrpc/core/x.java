package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes28.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f25073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f25074b;

    public x(g r100) {
        this.f25073a = r100;
        this.f25074b = new z(this);
    }

    public final g a() {
        return this.f25073a;
    }

    public final <T> T a(Class<T> r100) {
        return (T) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new y(this.f25073a, r100, this.f25074b));
    }
}
