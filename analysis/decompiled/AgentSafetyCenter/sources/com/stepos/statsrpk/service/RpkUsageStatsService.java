package com.stepos.statsrpk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.IRpkStatsInterface;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RpkUsageStatsService extends Service {
    private String TAG = "RpkUsageStatsService";
    private IInterface rpkStatsInterface;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class RpkStatsInterface extends IRpkStatsInterface.Stub {
        private ScheduledExecutorService executorService;
        private final Context mContext;
        private e rpkEmitterWorker;
        private qa.c subject;

        public RpkStatsInterface(Context context) {
            this.mContext = context;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.executorService = scheduledExecutorServiceNewScheduledThreadPool;
            a aVar = new a();
            aVar.f2878f = this;
            aVar.f2877c = context;
            VarHandle.storeStoreFence();
            scheduledExecutorServiceNewScheduledThreadPool.execute(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendRpkInfo(TrackerPayload trackerPayload, com.stepos.statsrpk.b bVar) {
            trackerPayload.a(bVar.f2851h, "pkg_name");
            trackerPayload.a(bVar.f2849f, "pkg_ver");
            trackerPayload.a(Integer.valueOf(bVar.f2850g), "pkg_ver_code");
            trackerPayload.a("102027", "channel_id");
            HashMap map = new HashMap();
            map.put("rpkPkgName", bVar.f2848c);
            trackerPayload.a(map, "event_attrib");
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(com.stepos.statsrpk.a aVar, com.stepos.statsrpk.b bVar) {
            ScheduledExecutorService scheduledExecutorService = this.executorService;
            b bVar2 = new b();
            bVar2.f2881g = this;
            bVar2.f2879c = aVar;
            bVar2.f2880f = bVar;
            VarHandle.storeStoreFence();
            scheduledExecutorService.execute(bVar2);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ua.c.a(this.TAG, "onBind intent: " + intent);
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
        ua.c.a(this.TAG, "onBind return binder: " + iBinderAsBinder);
        return iBinderAsBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ua.c.a(this.TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ua.c.a(this.TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        ua.c.a(this.TAG, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i, i3);
    }
}
