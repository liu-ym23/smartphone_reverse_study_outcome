package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public final class L implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f19743a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC1662c f19744b;

    public L(AbstractC1662c abstractC1662c, int i10) {
        this.f19744b = abstractC1662c;
        this.f19743a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            AbstractC1662c.Z(this.f19744b, 16);
            return;
        }
        synchronized (this.f19744b.f19791n) {
            try {
                AbstractC1662c abstractC1662c = this.f19744b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC1662c.f19792o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new zzad(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f19744b.a0(0, null, this.f19743a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f19744b.f19791n) {
            this.f19744b.f19792o = null;
        }
        AbstractC1662c abstractC1662c = this.f19744b;
        int i10 = this.f19743a;
        Handler handler = abstractC1662c.f19789l;
        handler.sendMessage(handler.obtainMessage(6, i10, 1));
    }
}
