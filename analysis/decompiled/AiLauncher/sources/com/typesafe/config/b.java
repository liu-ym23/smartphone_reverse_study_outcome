package com.typesafe.config;

import b8.o;
import b8.p;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final o f31716d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f31717a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f31718b;

    /* renamed from: c, reason: collision with root package name */
    public final o f31719c;

    public static class a implements o {
        @Override // b8.o
        public p a(String str) {
            return null;
        }
    }

    public b(boolean z10, boolean z11, o oVar) {
        this.f31717a = z10;
        this.f31718b = z11;
        this.f31719c = oVar;
    }

    public static b a() {
        return new b(true, false, f31716d);
    }

    public boolean b() {
        return this.f31718b;
    }

    public o c() {
        return this.f31719c;
    }

    public boolean d() {
        return this.f31717a;
    }
}
