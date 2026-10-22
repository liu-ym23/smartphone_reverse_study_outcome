package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes28.dex */
public final class y implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f25075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f25076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f25077c;

    public y(g r100, Class<?> r101, z r102) {
        this.f25075a = r100;
        this.f25076b = r101;
        this.f25077c = r102;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        return this.f25077c.a(r101, r102);
    }
}
