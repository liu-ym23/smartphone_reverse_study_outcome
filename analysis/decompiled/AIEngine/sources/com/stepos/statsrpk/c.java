package com.stepos.statsrpk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.statsrpk.IRpkStatsInterface;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f8071a;

    /* renamed from: b, reason: collision with root package name */
    public IRpkStatsInterface f8072b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ta.c.a("RpkEmitter", "onServiceConnected, " + iBinder);
                c.this.f8072b = IRpkStatsInterface.Stub.asInterface(iBinder);
            } catch (Exception e10) {
                ta.c.b("RpkEmitter", "Exception onServiceConnected:" + e10.toString() + " -Cause:" + e10.getCause());
            }
            synchronized (this) {
                notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            ta.c.a("RpkEmitter", "onServiceDisconnected, " + componentName);
            c cVar = c.this;
            cVar.f8072b = null;
            cVar.f8071a.unbindService(this);
        }
    }

    public final void a(RpkEvent rpkEvent, RpkInfo rpkInfo) {
        ta.c.a("RpkEmitter", "rpk track: " + rpkEvent + "," + rpkInfo);
        IRpkStatsInterface iRpkStatsInterface = this.f8072b;
        if (iRpkStatsInterface != null) {
            try {
                iRpkStatsInterface.track(rpkEvent, rpkInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }
}
