package com.stepos.statsrpk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class RpkUsageStatsService extends Service {
    private String TAG = "RpkUsageStatsService";
    private IInterface rpkStatsInterface;

    public class RpkStatsInterface extends IRpkStatsInterface.Stub {
        private ScheduledExecutorService executorService;
        private final Context mContext;
        private d rpkEmitterWorker;
        private P2.c subject;

        public RpkStatsInterface(Context context) {
            this.mContext = context;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.executorService = scheduledExecutorServiceNewScheduledThreadPool;
            scheduledExecutorServiceNewScheduledThreadPool.execute(new a(this, context));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendRpkInfo(TrackerPayload trackerPayload, RpkInfo rpkInfo) {
            trackerPayload.c(rpkInfo.f12352d, AppSuggestStorable.COLUMN_PKG_NAME);
            trackerPayload.c(rpkInfo.f12350b, "pkg_ver");
            trackerPayload.c(Integer.valueOf(rpkInfo.f12351c), "pkg_ver_code");
            trackerPayload.c("102027", "channel_id");
            HashMap map = new HashMap();
            map.put("rpkPkgName", rpkInfo.f12349a);
            trackerPayload.c(map, "event_attrib");
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException {
            this.executorService.execute(new b(this, rpkEvent, rpkInfo));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        T2.d.a(this.TAG, "onBind intent: " + intent);
        synchronized (RpkUsageStatsService.class) {
            try {
                if (this.rpkStatsInterface == null) {
                    this.rpkStatsInterface = new RpkStatsInterface(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        IBinder iBinderAsBinder = this.rpkStatsInterface.asBinder();
        T2.d.a(this.TAG, "onBind return binder: " + iBinderAsBinder);
        return iBinderAsBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        T2.d.a(this.TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        T2.d.a(this.TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        T2.d.a(this.TAG, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i4, i5);
    }
}
