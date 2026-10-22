package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
public final class M implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f19558a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ N f19559b;

    public M(N n10, ConnectionResult connectionResult) {
        this.f19559b = n10;
        this.f19558a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        N n10 = this.f19559b;
        J j10 = (J) n10.f19565f.f19614j.get(n10.f19561b);
        if (j10 == null) {
            return;
        }
        if (!this.f19558a.isSuccess()) {
            j10.F(this.f19558a, null);
            return;
        }
        this.f19559b.f19564e = true;
        if (this.f19559b.f19560a.f()) {
            this.f19559b.i();
            return;
        }
        try {
            N n11 = this.f19559b;
            n11.f19560a.h(null, n11.f19560a.g());
        } catch (SecurityException e10) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
            this.f19559b.f19560a.a("Failed to get service from broker.");
            j10.F(new ConnectionResult(10), null);
        }
    }
}
