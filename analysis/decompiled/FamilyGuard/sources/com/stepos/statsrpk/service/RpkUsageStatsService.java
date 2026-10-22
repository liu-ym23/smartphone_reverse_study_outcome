package com.stepos.statsrpk.service;

import U2.e;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import c3.c;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.IRpkStatsInterface;
import g3.C0742e;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class RpkUsageStatsService extends Service {
    private String TAG = RpkUsageStatsService.class.getSimpleName();
    private IInterface rpkStatsInterface;

    class RpkStatsInterface extends IRpkStatsInterface.Stub {
        private ScheduledExecutorService executorService;
        private final Context mContext;
        private com.stepos.statsrpk.service.a rpkEmitterWorker;
        private c subject;

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RpkUsageStatsService f15978a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f15979b;

            a(RpkUsageStatsService rpkUsageStatsService, Context context) {
                this.f15978a = rpkUsageStatsService;
                this.f15979b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.b bVar = new c.b();
                bVar.c(this.f15979b);
                RpkStatsInterface.this.subject = bVar.e();
                RpkStatsInterface.this.rpkEmitterWorker = new com.stepos.statsrpk.service.a(RpkStatsInterface.this.mContext, 1);
            }
        }

        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.stepos.statsrpk.a f15981a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.stepos.statsrpk.b f15982b;

            b(com.stepos.statsrpk.a aVar, com.stepos.statsrpk.b bVar) {
                this.f15981a = aVar;
                this.f15982b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                TrackerPayload trackerPayloadA;
                if (RpkStatsInterface.this.rpkEmitterWorker != null) {
                    if (this.f15981a.f15933a.equals("action_x")) {
                        Context context = RpkStatsInterface.this.mContext;
                        com.stepos.statsrpk.a aVar = this.f15981a;
                        trackerPayloadA = new U2.a(context, aVar.f15934b, aVar.f15935c, aVar.f15936d).a();
                        trackerPayloadA.a("sid", this.f15981a.f15937e);
                    } else if (this.f15981a.f15933a.equals("page")) {
                        HashMap map = new HashMap();
                        map.put("duration2", String.valueOf((String) this.f15981a.f15936d.get("duration2")));
                        Context context2 = RpkStatsInterface.this.mContext;
                        com.stepos.statsrpk.a aVar2 = this.f15981a;
                        trackerPayloadA = new e(context2, aVar2.f15934b, (String) aVar2.f15936d.get("start"), (String) this.f15981a.f15936d.get("end"), map).a();
                        trackerPayloadA.a("sid", this.f15981a.f15937e);
                    } else {
                        trackerPayloadA = null;
                    }
                    if (trackerPayloadA != null) {
                        if (RpkStatsInterface.this.subject != null) {
                            trackerPayloadA.c(RpkStatsInterface.this.subject.l());
                            trackerPayloadA.c(RpkStatsInterface.this.subject.b());
                            trackerPayloadA.c(RpkStatsInterface.this.subject.p());
                            trackerPayloadA.c(RpkStatsInterface.this.subject.c(RpkStatsInterface.this.mContext));
                        }
                        RpkStatsInterface.this.appendRpkInfo(trackerPayloadA, this.f15982b);
                        com.stepos.statsrpk.service.a aVar3 = RpkStatsInterface.this.rpkEmitterWorker;
                        com.stepos.statsrpk.b bVar = this.f15982b;
                        aVar3.g(bVar.f15942e, bVar.f15938a, trackerPayloadA);
                    }
                }
            }
        }

        RpkStatsInterface(Context context) {
            this.mContext = context;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.executorService = scheduledExecutorServiceNewScheduledThreadPool;
            scheduledExecutorServiceNewScheduledThreadPool.execute(new a(RpkUsageStatsService.this, context));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendRpkInfo(TrackerPayload trackerPayload, com.stepos.statsrpk.b bVar) {
            trackerPayload.a("pkg_name", bVar.f15941d);
            trackerPayload.a("pkg_ver", bVar.f15939b);
            trackerPayload.a("pkg_ver_code", Integer.valueOf(bVar.f15940c));
            trackerPayload.a("channel_id", "102027");
            HashMap map = new HashMap();
            map.put("rpkPkgName", bVar.f15938a);
            trackerPayload.a("event_attrib", map);
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(com.stepos.statsrpk.a aVar, com.stepos.statsrpk.b bVar) {
            this.executorService.execute(new b(aVar, bVar));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C0742e.c(this.TAG, "onBind intent: " + intent);
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
        C0742e.c(this.TAG, "onBind return binder: " + iBinderAsBinder);
        return iBinderAsBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C0742e.c(this.TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C0742e.c(this.TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i5, int i6) {
        C0742e.c(this.TAG, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i5, i6);
    }
}
