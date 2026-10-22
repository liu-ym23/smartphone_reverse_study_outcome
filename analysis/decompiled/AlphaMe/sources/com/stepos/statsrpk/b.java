package com.stepos.statsrpk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.statsrpk.IRpkStatsInterface;

/* loaded from: classes.dex */
public final class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.session.c f12357a;

    public b(android.support.v4.media.session.c cVar) {
        this.f12357a = cVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            T2.d.a("RpkEmitter", "onServiceConnected, " + iBinder);
            this.f12357a.f2366d = IRpkStatsInterface.Stub.asInterface(iBinder);
        } catch (Exception e4) {
            T2.d.b("RpkEmitter", "Exception onServiceConnected:" + e4.toString() + " -Cause:" + e4.getCause());
        }
        synchronized (this) {
            notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        T2.d.a("RpkEmitter", "onServiceDisconnected, " + componentName);
        android.support.v4.media.session.c cVar = this.f12357a;
        cVar.f2366d = null;
        ((Context) cVar.f2364b).unbindService(this);
    }
}
