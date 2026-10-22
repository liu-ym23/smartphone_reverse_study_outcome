package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.Context;
import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.f;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class V3OfflineEmitter extends com.stepos.statsapp.v3.lib.plugin.emitter.b implements f.a {

    /* renamed from: d, reason: collision with root package name */
    public final VccOfflineStatsCallback f8016d;

    /* renamed from: e, reason: collision with root package name */
    public final ThreadPoolExecutor f8017e;

    /* renamed from: f, reason: collision with root package name */
    public final sa.a f8018f;

    /* renamed from: g, reason: collision with root package name */
    public long f8019g;
    public final String h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
        private VccOfflineStatsCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$onRealBulkInsertEvents$1(List list) {
            Log.d("V3OfflineEmitter", "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                V3OfflineEmitter.this.f8018f.f11898a.edit().remove(String.valueOf((Long) it.next()));
            }
            if (list.isEmpty()) {
                return;
            }
            V3OfflineEmitter.this.f8018f.f11898a.edit().commit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$onRealInsertEvent$0(long j10) {
            Log.d("V3OfflineEmitter", "onRealInsertEvent thread:" + Thread.currentThread().getName());
            V3OfflineEmitter.this.f8018f.f11898a.edit().remove(String.valueOf(j10)).commit();
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealBulkInsertEvents(String str, final List list) {
            ta.c.a("V3OfflineEmitter", "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
            V3OfflineEmitter.this.f8017e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8031a.lambda$onRealBulkInsertEvents$1(list);
                }
            });
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertEvent(String str, final long j10) {
            ta.c.a("V3OfflineEmitter", "onRealInsertEvent2Remote, eventId:" + j10);
            V3OfflineEmitter.this.f8017e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8029a.lambda$onRealInsertEvent$0(j10);
                }
            });
        }

        public /* synthetic */ VccOfflineStatsCallback(V3OfflineEmitter v3OfflineEmitter, a aVar) {
            this();
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertH5Event(String str, long j10) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public AtomicInteger f8020a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            AtomicInteger atomicInteger = this.f8020a;
            if (atomicInteger.get() == Integer.MAX_VALUE) {
                atomicInteger.set(0);
            }
            return new Thread(runnable, "V3OfflineEmitterTask#" + atomicInteger.getAndIncrement());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            V3OfflineEmitter v3OfflineEmitter = V3OfflineEmitter.this;
            sa.a aVar = v3OfflineEmitter.f8018f;
            if (aVar.f11898a.getAll().size() >= 500) {
                ta.c.a("V3OfflineEmitter", "Sp data more than 500, into the clear.");
                aVar.f11898a.edit().clear().commit();
            }
            Log.d("V3OfflineEmitter", "init thread:" + Thread.currentThread().getName());
            Iterator<Map.Entry<String, ?>> it = aVar.f11898a.getAll().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                try {
                    long j10 = Integer.parseInt(key);
                    if (v3OfflineEmitter.f8019g < j10) {
                        v3OfflineEmitter.f8019g = j10;
                    }
                } catch (Exception e10) {
                    ta.c.b("V3OfflineEmitter", e10.getMessage());
                    aVar.f11898a.edit().remove(key).apply();
                }
            }
        }
    }

    public V3OfflineEmitter(Context context, String str, String str2) throws Throwable {
        super(context, str, str2);
        this.f8019g = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        a aVar = new a();
        aVar.f8020a = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, aVar, new com.stepos.statsapp.v3.lib.plugin.emitter.remote.b(0));
        this.f8017e = threadPoolExecutor;
        this.h = context.getPackageName();
        try {
            String strA = qa.e.a(context);
            if (strA == null || strA.equals(context.getPackageName())) {
                this.f8018f = new sa.a(context, "com.stepos.statsapp.v3.events_cache");
            } else {
                this.f8018f = new sa.a(context, "com.stepos.statsapp.v3.events_cache_".concat(strA));
            }
            threadPoolExecutor.execute(new b());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f8016d = new VccOfflineStatsCallback(this, null);
        f.b.f8038a.a(context, this);
    }

    public final void c() {
        f fVar = f.b.f8038a;
        String str = this.h;
        VccOfflineStatsCallback vccOfflineStatsCallback = this.f8016d;
        if (fVar.c(this.f8003a)) {
            try {
                fVar.f8035b.setCallback(str, vccOfflineStatsCallback);
            } catch (Throwable th) {
                ta.c.b("V3RemoteServiceReq", "setCallback error, " + th.getMessage());
            }
        }
        this.f8017e.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(this, false));
    }

    public final void d(TrackerPayload trackerPayload) {
        if (this.f8004b.isActive()) {
            this.f8017e.execute(new c(this, trackerPayload.toString(), trackerPayload, 0));
        }
    }
}
