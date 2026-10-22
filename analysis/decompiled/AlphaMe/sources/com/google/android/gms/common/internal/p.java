package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.InterfaceC0406d;

/* loaded from: classes.dex */
public final class p extends l {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f9829g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f9830h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c cVar, int i4, IBinder iBinder, Bundle bundle) {
        super(cVar, i4, bundle);
        this.f9830h = cVar;
        this.f9829g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.l
    public final void b(ConnectionResult connectionResult) {
        b bVar = this.f9830h.f9787o;
        if (bVar != null) {
            ((com.google.android.gms.common.api.internal.j) bVar.f9771a).onConnectionFailed(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.l
    public final boolean c() throws RemoteException {
        IBinder iBinder = this.f9829g;
        try {
            com.stepos.statsrpk.c.l(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            c cVar = this.f9830h;
            if (!cVar.m().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + cVar.m() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceI = cVar.i(iBinder);
            if (iInterfaceI == null || !(c.r(cVar, 2, 4, iInterfaceI) || c.r(cVar, 3, 4, iInterfaceI))) {
                return false;
            }
            cVar.f9791s = null;
            b bVar = cVar.f9786n;
            if (bVar == null) {
                return true;
            }
            ((InterfaceC0406d) bVar.f9771a).onConnected(null);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
