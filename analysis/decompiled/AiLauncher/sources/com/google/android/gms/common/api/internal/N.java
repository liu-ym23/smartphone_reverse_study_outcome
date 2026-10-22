package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1662c;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* loaded from: classes2.dex */
public final class N implements AbstractC1662c.InterfaceC0227c, h0 {

    /* renamed from: a, reason: collision with root package name */
    public final a.f f19560a;

    /* renamed from: b, reason: collision with root package name */
    public final C1635b f19561b;

    /* renamed from: c, reason: collision with root package name */
    public IAccountAccessor f19562c = null;

    /* renamed from: d, reason: collision with root package name */
    public Set f19563d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19564e = false;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C1640f f19565f;

    public N(C1640f c1640f, a.f fVar, C1635b c1635b) {
        this.f19565f = c1640f;
        this.f19560a = fVar;
        this.f19561b = c1635b;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c.InterfaceC0227c
    public final void a(ConnectionResult connectionResult) {
        this.f19565f.f19618n.post(new M(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.h0
    public final void b(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            c(new ConnectionResult(4));
        } else {
            this.f19562c = iAccountAccessor;
            this.f19563d = set;
            i();
        }
    }

    @Override // com.google.android.gms.common.api.internal.h0
    public final void c(ConnectionResult connectionResult) {
        J j10 = (J) this.f19565f.f19614j.get(this.f19561b);
        if (j10 != null) {
            j10.G(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h0
    public final void d(int i10) {
        J j10 = (J) this.f19565f.f19614j.get(this.f19561b);
        if (j10 != null) {
            if (j10.f19550i) {
                j10.G(new ConnectionResult(17));
            } else {
                j10.onConnectionSuspended(i10);
            }
        }
    }

    public final void i() {
        IAccountAccessor iAccountAccessor;
        if (!this.f19564e || (iAccountAccessor = this.f19562c) == null) {
            return;
        }
        this.f19560a.h(iAccountAccessor, this.f19563d);
    }
}
