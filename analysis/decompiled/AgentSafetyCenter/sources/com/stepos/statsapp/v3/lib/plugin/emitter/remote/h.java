package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ i f2839a;

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            ua.c.a("V3RemoteServiceReq", "onServiceConnected, " + iBinder);
            this.f2839a.f9731f = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
            f fVar = (f) this.f2839a.f9733h;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Exception e10) {
            ua.c.b("V3RemoteServiceReq", "Exception onServiceConnected:" + e10.toString() + " - Cause:" + e10.getCause());
        }
        synchronized (((h) this.f2839a.f9732g)) {
            ((h) this.f2839a.f9732g).notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ua.c.a("V3RemoteServiceReq", "onServiceDisconnected, " + componentName);
        i iVar = this.f2839a;
        iVar.f9731f = null;
        f fVar = (f) iVar.f9733h;
        if (fVar != null) {
            try {
                fVar.f2830a.unbindService(this);
            } catch (Throwable th) {
                ua.c.b("V3OfflineEmitter", "onServiceDisconnected error, " + th.getMessage());
            }
        }
    }
}
