package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;

/* loaded from: classes.dex */
public final class h implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f12335a;

    public h(i iVar) {
        this.f12335a = iVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            T2.d.a("V3RemoteServiceReq", "onServiceConnected, " + iBinder);
            this.f12335a.f12338b = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
            f fVar = this.f12335a.f12340d;
            if (fVar != null) {
                ((e) fVar).a();
            }
        } catch (Exception e4) {
            T2.d.b("V3RemoteServiceReq", "Exception onServiceConnected:" + e4.toString() + " - Cause:" + e4.getCause());
        }
        synchronized (this.f12335a.f12339c) {
            this.f12335a.f12339c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        T2.d.a("V3RemoteServiceReq", "onServiceDisconnected, " + componentName);
        i iVar = this.f12335a;
        iVar.f12338b = null;
        f fVar = iVar.f12340d;
        if (fVar != null) {
            e eVar = (e) fVar;
            eVar.getClass();
            try {
                eVar.f12326a.unbindService(this);
            } catch (Throwable th) {
                T2.d.b("V3OfflineEmitter", "onServiceDisconnected error, " + th.getMessage());
            }
        }
    }
}
