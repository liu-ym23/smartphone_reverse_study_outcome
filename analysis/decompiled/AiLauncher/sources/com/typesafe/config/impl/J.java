package com.typesafe.config.impl;

/* loaded from: classes4.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    public final C3898d<A, AbstractConfigValue> f31757a;

    public J(C3898d<A, AbstractConfigValue> c3898d) {
        this.f31757a = c3898d;
    }

    public AbstractConfigValue a(A a10) {
        return this.f31757a.b(a10);
    }

    public J b(A a10, AbstractConfigValue abstractConfigValue) {
        return new J(this.f31757a.a(a10, abstractConfigValue));
    }

    public J() {
        this(new C3898d());
    }
}
