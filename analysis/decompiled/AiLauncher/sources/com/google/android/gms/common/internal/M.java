package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
public final class M extends E {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f19745g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AbstractC1662c f19746h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(AbstractC1662c abstractC1662c, int i10, IBinder iBinder, Bundle bundle) {
        super(abstractC1662c, i10, bundle);
        this.f19746h = abstractC1662c;
        this.f19745g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.E
    public final void f(ConnectionResult connectionResult) {
        if (this.f19746h.f19799v != null) {
            this.f19746h.f19799v.onConnectionFailed(connectionResult);
        }
        this.f19746h.I(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.E
    public final boolean g() throws RemoteException {
        try {
            IBinder iBinder = this.f19745g;
            C1669j.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f19746h.B().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f19746h.B() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceP = this.f19746h.p(this.f19745g);
            if (iInterfaceP == null || !(AbstractC1662c.c0(this.f19746h, 2, 4, iInterfaceP) || AbstractC1662c.c0(this.f19746h, 3, 4, iInterfaceP))) {
                return false;
            }
            this.f19746h.f19803z = null;
            AbstractC1662c abstractC1662c = this.f19746h;
            Bundle bundleU = abstractC1662c.u();
            if (abstractC1662c.f19798u == null) {
                return true;
            }
            this.f19746h.f19798u.onConnected(bundleU);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
