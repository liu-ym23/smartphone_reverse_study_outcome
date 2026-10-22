package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
public abstract class E extends K {

    /* renamed from: d, reason: collision with root package name */
    public final int f19732d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f19733e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC1662c f19734f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(AbstractC1662c abstractC1662c, int i10, Bundle bundle) {
        super(abstractC1662c, Boolean.TRUE);
        this.f19734f = abstractC1662c;
        this.f19732d = i10;
        this.f19733e = bundle;
    }

    @Override // com.google.android.gms.common.internal.K
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f19732d != 0) {
            this.f19734f.e0(1, null);
            Bundle bundle = this.f19733e;
            f(new ConnectionResult(this.f19732d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (g()) {
                return;
            }
            this.f19734f.e0(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.K
    public final void b() {
    }

    public abstract void f(ConnectionResult connectionResult);

    public abstract boolean g();
}
