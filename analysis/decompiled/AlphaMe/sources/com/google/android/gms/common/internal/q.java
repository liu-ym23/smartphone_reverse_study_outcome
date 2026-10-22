package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class q extends l {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f9831g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c cVar, int i4) {
        super(cVar, i4, null);
        this.f9831g = cVar;
    }

    @Override // com.google.android.gms.common.internal.l
    public final void b(ConnectionResult connectionResult) {
        c cVar = this.f9831g;
        cVar.getClass();
        cVar.f9781i.a(connectionResult);
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.l
    public final boolean c() {
        this.f9831g.f9781i.a(ConnectionResult.f9596e);
        return true;
    }
}
