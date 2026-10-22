package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.C1643i;

/* loaded from: classes2.dex */
public final class o0 extends k0 {

    /* renamed from: c, reason: collision with root package name */
    public final C1643i.a f19660c;

    public o0(C1643i.a aVar, D2.j jVar) {
        super(4, jVar);
        this.f19660c = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final /* bridge */ /* synthetic */ void d(C1654u c1654u, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.S
    public final boolean f(J j10) {
        Z z10 = (Z) j10.v().get(this.f19660c);
        return z10 != null && z10.f19586a.f();
    }

    @Override // com.google.android.gms.common.api.internal.S
    public final Feature[] g(J j10) {
        Z z10 = (Z) j10.v().get(this.f19660c);
        if (z10 == null) {
            return null;
        }
        return z10.f19586a.c();
    }

    @Override // com.google.android.gms.common.api.internal.k0
    public final void h(J j10) throws RemoteException {
        Z z10 = (Z) j10.v().remove(this.f19660c);
        if (z10 == null) {
            this.f19641b.e(Boolean.FALSE);
            return;
        }
        z10.f19587b.b(j10.t(), this.f19641b);
        z10.f19586a.a();
    }
}
