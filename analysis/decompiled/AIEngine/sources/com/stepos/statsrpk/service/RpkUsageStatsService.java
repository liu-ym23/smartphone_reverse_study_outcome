package com.stepos.statsrpk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.os.IInterface;
import com.stepos.core.ota.process.OtaIdleExitPolicy;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.tonyodev.fetch2core.server.FileResponse;
import ha.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import ma.a;
import pa.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RpkUsageStatsService extends Service {
    private String TAG = "RpkUsageStatsService";
    private IInterface rpkStatsInterface;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class RpkStatsInterface extends IRpkStatsInterface.Stub {
        private ScheduledExecutorService executorService;
        private final Context mContext;
        private c rpkEmitterWorker;
        private pa.c subject;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f8091a;

            public a(Context context) {
                this.f8091a = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                va.a aVar;
                c.a aVar2 = new c.a();
                aVar2.f11476a = this.f8091a;
                RpkStatsInterface.this.subject = new pa.c(aVar2);
                RpkStatsInterface rpkStatsInterface = RpkStatsInterface.this;
                Context context = rpkStatsInterface.mContext;
                c cVar = new c();
                cVar.f8010a = context;
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
                cVar.f8103c = scheduledExecutorServiceNewScheduledThreadPool;
                androidx.preference.c cVar2 = new androidx.preference.c();
                cVar2.f2401b = context;
                ma.a aVar3 = a.C0109a.f10535a;
                aVar3.f10533a = ma.a.b(context, "salt", 32);
                aVar3.f10534b = ma.a.b(context, "iv", 16);
                va.a aVar4 = va.a.f13490a;
                synchronized (va.a.class) {
                    try {
                        if (va.a.f13490a == null) {
                            va.a aVar5 = new va.a(context, "statsrpk.db", null, 1);
                            ta.c.a("com.stepos.statsrpk.storage.b", "DATABASE_VERSION 1");
                            va.a.f13490a = aVar5;
                        }
                        aVar = va.a.f13490a;
                    } finally {
                    }
                }
                synchronized (cVar2) {
                    if (!cVar2.i()) {
                        SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                        cVar2.f2400a = writableDatabase;
                        writableDatabase.enableWriteAheadLogging();
                    }
                }
                ta.c.a("a", "DB Path:" + ((SQLiteDatabase) cVar2.f2400a).getPath());
                cVar.f8102b = cVar2;
                if (ka.a.f9952d == null) {
                    synchronized (ka.a.f9953e) {
                        try {
                            if (ka.a.f9952d == null) {
                                ka.a.f9952d = new ka.a(context);
                            }
                        } finally {
                        }
                    }
                }
                ArrayList arrayList = ka.a.f9952d.f9956c;
                if (arrayList != null) {
                    arrayList.add(cVar);
                }
                scheduledExecutorServiceNewScheduledThreadPool.schedule(new com.stepos.statsrpk.service.a(cVar, 0), OtaIdleExitPolicy.TERMINAL_IDLE_MS, TimeUnit.MILLISECONDS);
                rpkStatsInterface.rpkEmitterWorker = cVar;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RpkEvent f8093a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RpkInfo f8094b;

            public b(RpkEvent rpkEvent, RpkInfo rpkInfo) {
                this.f8093a = rpkEvent;
                this.f8094b = rpkInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TrackerPayload trackerPayload;
                RpkStatsInterface rpkStatsInterface = RpkStatsInterface.this;
                if (rpkStatsInterface.rpkEmitterWorker != null) {
                    RpkEvent rpkEvent = this.f8093a;
                    if (rpkEvent.f8045a.equals("action_x")) {
                        trackerPayload = new ha.a(rpkStatsInterface.mContext, rpkEvent.f8046b, rpkEvent.f8047c, rpkEvent.f8048d).a();
                        trackerPayload.addHeader("sid", rpkEvent.f8049e);
                    } else if (rpkEvent.f8045a.equals("page")) {
                        HashMap map = new HashMap();
                        map.put("duration2", String.valueOf((String) rpkEvent.f8048d.get("duration2")));
                        d dVar = new d(rpkStatsInterface.mContext, rpkEvent.f8046b, (String) rpkEvent.f8048d.get("start"), (String) rpkEvent.f8048d.get("end"), map);
                        trackerPayload = new TrackerPayload();
                        trackerPayload.addHeader("name", dVar.f9377a);
                        trackerPayload.addHeader("network", dVar.f9378b);
                        trackerPayload.addHeader(FileResponse.FIELD_TYPE, "page");
                        trackerPayload.addHeader("launch", dVar.f9381d);
                        trackerPayload.addHeader("terminate", dVar.f9382e);
                        trackerPayload.addValueMap(dVar.f9379c);
                        trackerPayload.addHeader("sid", rpkEvent.f8049e);
                    } else {
                        trackerPayload = null;
                    }
                    if (trackerPayload != null) {
                        if (rpkStatsInterface.subject != null) {
                            trackerPayload.addHeaderMap(rpkStatsInterface.subject.f11472a.f11471a);
                            trackerPayload.addHeaderMap(rpkStatsInterface.subject.f11473b.f11470a);
                            trackerPayload.addHeaderMap(rpkStatsInterface.subject.f11475d);
                            pa.c cVar = rpkStatsInterface.subject;
                            Context context = rpkStatsInterface.mContext;
                            cVar.getClass();
                            trackerPayload.addHeaderMap(pa.c.a(context));
                        }
                        RpkInfo rpkInfo = this.f8094b;
                        rpkStatsInterface.appendRpkInfo(trackerPayload, rpkInfo);
                        c cVar2 = rpkStatsInterface.rpkEmitterWorker;
                        cVar2.f8103c.execute(new com.stepos.statsrpk.service.b(cVar2, rpkInfo.f8054e, rpkInfo.f8050a, trackerPayload));
                    }
                }
            }
        }

        public RpkStatsInterface(Context context) {
            this.mContext = context;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.executorService = scheduledExecutorServiceNewScheduledThreadPool;
            scheduledExecutorServiceNewScheduledThreadPool.execute(new a(context));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendRpkInfo(TrackerPayload trackerPayload, RpkInfo rpkInfo) {
            trackerPayload.addHeader("pkg_name", rpkInfo.f8053d);
            trackerPayload.addHeader("pkg_ver", rpkInfo.f8051b);
            trackerPayload.addHeader("pkg_ver_code", Integer.valueOf(rpkInfo.f8052c));
            trackerPayload.addHeader("channel_id", "102027");
            HashMap map = new HashMap();
            map.put("rpkPkgName", rpkInfo.f8050a);
            trackerPayload.addHeader("event_attrib", map);
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(RpkEvent rpkEvent, RpkInfo rpkInfo) {
            this.executorService.execute(new b(rpkEvent, rpkInfo));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ta.c.a(this.TAG, "onBind intent: " + intent);
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
        ta.c.a(this.TAG, "onBind return binder: " + iBinderAsBinder);
        return iBinderAsBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ta.c.a(this.TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ta.c.a(this.TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        ta.c.a(this.TAG, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i10, i11);
    }
}
