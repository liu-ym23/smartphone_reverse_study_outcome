package com.google.android.gms.auth.api.signin.internal;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f19479a = 1;

    public a a(Object obj) {
        this.f19479a = (this.f19479a * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f19479a;
    }

    public final a c(boolean z10) {
        this.f19479a = (this.f19479a * 31) + (z10 ? 1 : 0);
        return this;
    }
}
