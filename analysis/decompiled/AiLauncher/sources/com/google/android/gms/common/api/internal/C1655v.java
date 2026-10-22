package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.res.Resources;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1669j;

/* renamed from: com.google.android.gms.common.api.internal.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1655v extends u0 {

    /* renamed from: f, reason: collision with root package name */
    public final androidx.collection.b f19689f;

    /* renamed from: g, reason: collision with root package name */
    public final C1640f f19690g;

    public C1655v(InterfaceC1642h interfaceC1642h, C1640f c1640f, com.google.android.gms.common.b bVar) {
        super(interfaceC1642h, bVar);
        this.f19689f = new androidx.collection.b();
        this.f19690g = c1640f;
        this.f19557a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, C1640f c1640f, C1635b c1635b) {
        InterfaceC1642h interfaceC1642hC = LifecycleCallback.c(activity);
        C1655v c1655v = (C1655v) interfaceC1642hC.b("ConnectionlessLifecycleHelper", C1655v.class);
        if (c1655v == null) {
            c1655v = new C1655v(interfaceC1642hC, c1640f, com.google.android.gms.common.b.m());
        }
        C1669j.l(c1635b, "ApiKey cannot be null");
        c1655v.f19689f.add(c1635b);
        c1640f.a(c1655v);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.u0, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.u0, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        this.f19690g.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.u0
    public final void m(ConnectionResult connectionResult, int i10) throws Resources.NotFoundException {
        this.f19690g.D(connectionResult, i10);
    }

    @Override // com.google.android.gms.common.api.internal.u0
    public final void n() {
        this.f19690g.E();
    }

    public final androidx.collection.b t() {
        return this.f19689f;
    }

    public final void v() {
        if (this.f19689f.isEmpty()) {
            return;
        }
        this.f19690g.a(this);
    }
}
