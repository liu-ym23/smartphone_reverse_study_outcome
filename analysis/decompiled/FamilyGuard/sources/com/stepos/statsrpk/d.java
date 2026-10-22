package com.stepos.statsrpk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import g3.C0742e;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f15949a;

    /* renamed from: b, reason: collision with root package name */
    private com.stepos.statsrpk.b f15950b;

    /* renamed from: c, reason: collision with root package name */
    private IRpkStatsInterface f15951c;

    private class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C0742e.c("RpkEmitter", "onServiceConnected, " + iBinder);
                d.this.f15951c = IRpkStatsInterface.Stub.asInterface(iBinder);
            } catch (Exception e6) {
                C0742e.d("RpkEmitter", "Exception onServiceConnected:" + e6.toString() + " -Cause:" + e6.getCause());
            }
            synchronized (this) {
                notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C0742e.c("RpkEmitter", "onServiceDisconnected, " + componentName);
            d.this.f15951c = null;
            d.this.f15949a.unbindService(this);
        }
    }

    public d(Context context, com.stepos.statsrpk.b bVar) {
        this.f15949a = context;
        this.f15950b = bVar;
        c();
    }

    private void c() {
        Intent intent = new Intent(this.f15949a, (Class<?>) RpkUsageStatsService.class);
        b bVar = new b();
        boolean zBindService = this.f15949a.bindService(intent, bVar, 1);
        C0742e.c("RpkEmitter", "bindService, " + bVar + " result: " + zBindService);
        if (zBindService) {
            synchronized (bVar) {
                try {
                    bVar.wait();
                } catch (InterruptedException e6) {
                    C0742e.l("RpkEmitter", "Exception:" + e6.toString() + " -Cause:" + e6.getCause());
                }
            }
        }
    }

    public void d(com.stepos.statsrpk.a aVar, com.stepos.statsrpk.b bVar) {
        C0742e.c("RpkEmitter", "rpk track: " + aVar + "," + bVar);
        IRpkStatsInterface iRpkStatsInterface = this.f15951c;
        if (iRpkStatsInterface != null) {
            try {
                iRpkStatsInterface.track(aVar, bVar);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }
}
