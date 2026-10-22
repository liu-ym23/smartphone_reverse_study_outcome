package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class o implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f9827a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f9828b;

    public o(c cVar, int i4) {
        this.f9828b = cVar;
        this.f9827a = i4;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i4;
        int i5;
        if (iBinder == null) {
            c cVar = this.f9828b;
            synchronized (cVar.f9778f) {
                i4 = cVar.f9785m;
            }
            if (i4 == 3) {
                cVar.f9792t = true;
                i5 = 5;
            } else {
                i5 = 4;
            }
            n nVar = cVar.f9777e;
            nVar.sendMessage(nVar.obtainMessage(i5, cVar.f9794v.get(), 16));
            return;
        }
        synchronized (this.f9828b.f9779g) {
            try {
                c cVar2 = this.f9828b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                cVar2.f9780h = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new zzac(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        c cVar3 = this.f9828b;
        int i6 = this.f9827a;
        cVar3.getClass();
        q qVar = new q(cVar3, 0);
        n nVar2 = cVar3.f9777e;
        nVar2.sendMessage(nVar2.obtainMessage(7, i6, -1, qVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        c cVar;
        synchronized (this.f9828b.f9779g) {
            cVar = this.f9828b;
            cVar.f9780h = null;
        }
        n nVar = cVar.f9777e;
        nVar.sendMessage(nVar.obtainMessage(6, this.f9827a, 1));
    }
}
