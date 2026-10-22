package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;

/* loaded from: classes3.dex */
public final class f implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1.d f3973a;

    public f(u1.d dVar) {
        this.f3973a = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            W5.c.a("V3RemoteServiceReq", "onServiceConnected, " + iBinder);
            this.f3973a.c = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
            d dVar = (d) this.f3973a.e;
            if (dVar != null) {
                dVar.c();
            }
        } catch (Exception e) {
            W5.c.b("V3RemoteServiceReq", "Exception onServiceConnected:" + e.toString() + " - Cause:" + e.getCause());
        }
        synchronized (((f) this.f3973a.d)) {
            ((f) this.f3973a.d).notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        W5.c.a("V3RemoteServiceReq", "onServiceDisconnected, " + componentName);
        u1.d dVar = this.f3973a;
        dVar.c = null;
        d dVar2 = (d) dVar.e;
        if (dVar2 != null) {
            dVar2.getClass();
            try {
                dVar2.f3966a.unbindService(this);
            } catch (Throwable th) {
                W5.c.b("V3OfflineEmitter", "onServiceDisconnected error, " + th.getMessage());
            }
        }
    }
}
