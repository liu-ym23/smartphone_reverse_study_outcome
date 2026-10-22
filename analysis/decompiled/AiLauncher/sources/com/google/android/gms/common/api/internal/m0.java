package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.C1643i;

/* loaded from: classes2.dex */
public final class m0 extends k0 {

    /* renamed from: c, reason: collision with root package name */
    public final Z f19646c;

    public m0(Z z10, D2.j jVar) {
        super(3, jVar);
        this.f19646c = z10;
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final /* bridge */ /* synthetic */ void d(C1654u c1654u, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.S
    public final boolean f(J j10) {
        return this.f19646c.f19586a.f();
    }

    @Override // com.google.android.gms.common.api.internal.S
    public final Feature[] g(J j10) {
        return this.f19646c.f19586a.c();
    }

    @Override // com.google.android.gms.common.api.internal.k0
    public final void h(J j10) throws RemoteException {
        this.f19646c.f19586a.d(j10.t(), this.f19641b);
        C1643i.a aVarB = this.f19646c.f19586a.b();
        if (aVarB != null) {
            j10.v().put(aVarB, this.f19646c);
        }
    }
}
