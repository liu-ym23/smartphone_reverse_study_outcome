package com.stepos.statsrpk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public class RpkUsageStatsService extends Service {
    private String TAG = "RpkUsageStatsService";
    private IInterface rpkStatsInterface;

    public class RpkStatsInterface extends IRpkStatsInterface.Stub {
        private ScheduledExecutorService executorService;
        private final Context mContext;
        private e rpkEmitterWorker;
        private S5.a subject;

        public RpkStatsInterface(Context context) {
            this.mContext = context;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.executorService = scheduledExecutorServiceNewScheduledThreadPool;
            scheduledExecutorServiceNewScheduledThreadPool.execute(new a(this, context));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendRpkInfo(TrackerPayload trackerPayload, RpkInfo rpkInfo) {
            trackerPayload.addHeader("pkg_name", rpkInfo.d);
            trackerPayload.addHeader("pkg_ver", rpkInfo.b);
            trackerPayload.addHeader("pkg_ver_code", Integer.valueOf(rpkInfo.c));
            trackerPayload.addHeader("channel_id", "102027");
            HashMap map = new HashMap();
            map.put("rpkPkgName", rpkInfo.f3976a);
            trackerPayload.addHeader("event_attrib", map);
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException {
            this.executorService.execute(new b(this, rpkEvent, rpkInfo));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        W5.c.a(this.TAG, "onBind intent: " + intent);
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
        W5.c.a(this.TAG, "onBind return binder: " + iBinderAsBinder);
        return iBinderAsBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        W5.c.a(this.TAG, AppAgent.ON_CREATE);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        W5.c.a(this.TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i6) {
        W5.c.a(this.TAG, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i, i6);
    }
}
