package com.stepos.statsrpk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.utils.log.Logger;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.service.RpkUsageStatsService;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f31032a;

    /* renamed from: b, reason: collision with root package name */
    public RpkInfo f31033b;

    /* renamed from: c, reason: collision with root package name */
    public IRpkStatsInterface f31034c;

    /* renamed from: com.stepos.statsrpk.b$b, reason: collision with other inner class name */
    public class ServiceConnectionC0374b implements ServiceConnection {
        public ServiceConnectionC0374b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Logger.d("RpkEmitter", "onServiceConnected, " + iBinder);
                b.this.f31034c = IRpkStatsInterface.Stub.asInterface(iBinder);
            } catch (Exception e10) {
                Logger.e("RpkEmitter", "Exception onServiceConnected:" + e10.toString() + " -Cause:" + e10.getCause());
            }
            synchronized (this) {
                notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.d("RpkEmitter", "onServiceDisconnected, " + componentName);
            b.this.f31034c = null;
            b.this.f31032a.unbindService(this);
        }
    }

    public b(Context context, RpkInfo rpkInfo) {
        this.f31032a = context;
        this.f31033b = rpkInfo;
        c();
    }

    public final void c() {
        Intent intent = new Intent(this.f31032a, (Class<?>) RpkUsageStatsService.class);
        ServiceConnectionC0374b serviceConnectionC0374b = new ServiceConnectionC0374b();
        boolean zBindService = this.f31032a.bindService(intent, serviceConnectionC0374b, 1);
        Logger.d("RpkEmitter", "bindService, " + serviceConnectionC0374b + " result: " + zBindService);
        if (zBindService) {
            synchronized (serviceConnectionC0374b) {
                try {
                    serviceConnectionC0374b.wait();
                } catch (InterruptedException e10) {
                    Logger.w("RpkEmitter", "Exception:" + e10.toString() + " -Cause:" + e10.getCause());
                }
            }
        }
    }

    public void d(RpkEvent rpkEvent, RpkInfo rpkInfo) {
        Logger.d("RpkEmitter", "rpk track: " + rpkEvent + Const.STR_MART_COMMA + rpkInfo);
        IRpkStatsInterface iRpkStatsInterface = this.f31034c;
        if (iRpkStatsInterface != null) {
            try {
                iRpkStatsInterface.track(rpkEvent, rpkInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }
}
