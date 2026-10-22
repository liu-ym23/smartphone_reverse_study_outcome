package com.stepos.statsrpk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.events.e;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.tracker.subject.c;
import com.stepos.statsapp.v3.utils.log.Logger;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class RpkUsageStatsService extends Service {
    private String TAG = RpkUsageStatsService.class.getSimpleName();
    private IInterface rpkStatsInterface;

    public class RpkStatsInterface extends IRpkStatsInterface.Stub {
        private ScheduledExecutorService executorService;
        private final Context mContext;
        private com.stepos.statsrpk.service.a rpkEmitterWorker;
        private c subject;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RpkUsageStatsService f31061a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f31062b;

            public a(RpkUsageStatsService rpkUsageStatsService, Context context) {
                this.f31061a = rpkUsageStatsService;
                this.f31062b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.b bVar = new c.b();
                bVar.a(this.f31062b);
                RpkStatsInterface.this.subject = bVar.a();
                RpkStatsInterface.this.rpkEmitterWorker = new com.stepos.statsrpk.service.a(RpkStatsInterface.this.mContext, 1);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RpkEvent f31064a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RpkInfo f31065b;

            public b(RpkEvent rpkEvent, RpkInfo rpkInfo) {
                this.f31064a = rpkEvent;
                this.f31065b = rpkInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                TrackerPayload trackerPayloadA;
                if (RpkStatsInterface.this.rpkEmitterWorker != null) {
                    if (this.f31064a.f31006a.equals(com.stepos.statsapp.v3.lib.plugin.events.b.f30787g)) {
                        Context context = RpkStatsInterface.this.mContext;
                        RpkEvent rpkEvent = this.f31064a;
                        trackerPayloadA = new com.stepos.statsapp.v3.lib.plugin.events.a(context, rpkEvent.f31007b, rpkEvent.f31008c, rpkEvent.f31009d).a();
                        trackerPayloadA.addHeader(Parameters.SESSION_ID, this.f31064a.f31010e);
                    } else if (this.f31064a.f31006a.equals("page")) {
                        HashMap map = new HashMap();
                        map.put(e.f30796j, String.valueOf((String) this.f31064a.f31009d.get(e.f30796j)));
                        Context context2 = RpkStatsInterface.this.mContext;
                        RpkEvent rpkEvent2 = this.f31064a;
                        trackerPayloadA = new e(context2, rpkEvent2.f31007b, (String) rpkEvent2.f31009d.get("start"), (String) this.f31064a.f31009d.get(com.stepos.ailauncher.container.wallpaper.a.PHASE_END), map).a();
                        trackerPayloadA.addHeader(Parameters.SESSION_ID, this.f31064a.f31010e);
                    } else {
                        trackerPayloadA = null;
                    }
                    if (trackerPayloadA != null) {
                        if (RpkStatsInterface.this.subject != null) {
                            trackerPayloadA.addHeaderMap(RpkStatsInterface.this.subject.b());
                            trackerPayloadA.addHeaderMap(RpkStatsInterface.this.subject.a());
                            trackerPayloadA.addHeaderMap(RpkStatsInterface.this.subject.d());
                            trackerPayloadA.addHeaderMap(RpkStatsInterface.this.subject.a(RpkStatsInterface.this.mContext));
                        }
                        RpkStatsInterface.this.appendRpkInfo(trackerPayloadA, this.f31065b);
                        com.stepos.statsrpk.service.a aVar = RpkStatsInterface.this.rpkEmitterWorker;
                        RpkInfo rpkInfo = this.f31065b;
                        aVar.i(rpkInfo.f31015e, rpkInfo.f31011a, trackerPayloadA);
                    }
                }
            }
        }

        public RpkStatsInterface(Context context) {
            this.mContext = context;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.executorService = scheduledExecutorServiceNewScheduledThreadPool;
            scheduledExecutorServiceNewScheduledThreadPool.execute(new a(RpkUsageStatsService.this, context));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendRpkInfo(TrackerPayload trackerPayload, RpkInfo rpkInfo) {
            trackerPayload.addHeader(Parameters.PKG_NAME, rpkInfo.f31014d);
            trackerPayload.addHeader(Parameters.PKG_VER, rpkInfo.f31012b);
            trackerPayload.addHeader(Parameters.PKG_VER_CODE, Integer.valueOf(rpkInfo.f31013c));
            trackerPayload.addHeader(Parameters.CHANNEL_ID, "102027");
            HashMap map = new HashMap();
            map.put("rpkPkgName", rpkInfo.f31011a);
            trackerPayload.addHeader(Parameters.EVENT_ATTRIB, map);
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException {
            this.executorService.execute(new b(rpkEvent, rpkInfo));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.d(this.TAG, "onBind intent: " + intent);
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
        Logger.d(this.TAG, "onBind return binder: " + iBinderAsBinder);
        return iBinderAsBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.d(this.TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.d(this.TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        Logger.d(this.TAG, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i10, i11);
    }
}
