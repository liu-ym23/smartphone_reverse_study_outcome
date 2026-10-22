package com.typesafe.config.impl;

import b8.InterfaceC1456b;

/* loaded from: classes4.dex */
public class N implements InterfaceC1456b {

    /* renamed from: a, reason: collision with root package name */
    public final C f31776a;

    /* renamed from: b, reason: collision with root package name */
    public final b8.l f31777b;

    public N(C c10) {
        this.f31776a = c10;
        this.f31777b = O.f(c10.c());
    }

    @Override // b8.InterfaceC1456b
    public b8.m a(String str) {
        if (C3903i.B()) {
            C3903i.A("Looking for '" + str + "' relative to " + this.f31776a);
        }
        C c10 = this.f31776a;
        if (c10 != null) {
            return c10.a(str);
        }
        return null;
    }

    @Override // b8.InterfaceC1456b
    public b8.l b() {
        return this.f31777b;
    }

    @Override // b8.InterfaceC1456b
    public InterfaceC1456b c(b8.l lVar) {
        return new N(this.f31776a, lVar.l(null).k(null));
    }

    public N(C c10, b8.l lVar) {
        this.f31776a = c10;
        this.f31777b = lVar;
    }
}
