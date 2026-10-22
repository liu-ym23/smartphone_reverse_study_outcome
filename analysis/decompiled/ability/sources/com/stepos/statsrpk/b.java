package com.stepos.statsrpk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.statsrpk.IRpkStatsInterface;
import k2.C1621a;

/* loaded from: classes3.dex */
public final class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1621a f3978a;

    public b(C1621a c1621a) {
        this.f3978a = c1621a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            W5.c.a("RpkEmitter", "onServiceConnected, " + iBinder);
            this.f3978a.b = IRpkStatsInterface.Stub.asInterface(iBinder);
        } catch (Exception e) {
            W5.c.b("RpkEmitter", "Exception onServiceConnected:" + e.toString() + " -Cause:" + e.getCause());
        }
        synchronized (this) {
            notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        W5.c.a("RpkEmitter", "onServiceDisconnected, " + componentName);
        C1621a c1621a = this.f3978a;
        c1621a.b = null;
        ((Context) c1621a.f4793a).unbindService(this);
    }
}
