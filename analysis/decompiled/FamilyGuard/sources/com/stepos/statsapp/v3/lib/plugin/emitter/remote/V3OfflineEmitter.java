package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.Context;
import android.content.ServiceConnection;
import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.g;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d3.C0669e;
import f3.C0720b;
import g3.C0742e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* loaded from: classes.dex */
public class V3OfflineEmitter extends com.stepos.statsapp.v3.lib.plugin.emitter.a implements g.b {

    /* renamed from: d, reason: collision with root package name */
    private VccOfflineStatsCallback f15892d;

    /* renamed from: e, reason: collision with root package name */
    private ExecutorService f15893e;

    /* renamed from: f, reason: collision with root package name */
    private C0720b f15894f;

    /* renamed from: g, reason: collision with root package name */
    private long f15895g;

    /* renamed from: h, reason: collision with root package name */
    private String f15896h;

    /* JADX INFO: Access modifiers changed from: private */
    class VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
        private VccOfflineStatsCallback() {
        }

        public static /* synthetic */ void a(VccOfflineStatsCallback vccOfflineStatsCallback, List list) {
            vccOfflineStatsCallback.getClass();
            Log.d("V3OfflineEmitter", "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                V3OfflineEmitter.this.f15894f.h().remove(String.valueOf((Long) it.next()));
            }
            if (list.isEmpty()) {
                return;
            }
            V3OfflineEmitter.this.f15894f.h().commit();
        }

        public static /* synthetic */ void b(VccOfflineStatsCallback vccOfflineStatsCallback, long j5) {
            vccOfflineStatsCallback.getClass();
            Log.d("V3OfflineEmitter", "onRealInsertEvent thread:" + Thread.currentThread().getName());
            V3OfflineEmitter.this.f15894f.g(String.valueOf(j5));
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealBulkInsertEvents(String str, final List list) {
            C0742e.c("V3OfflineEmitter", "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
            V3OfflineEmitter.this.f15893e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.f
                @Override // java.lang.Runnable
                public final void run() {
                    V3OfflineEmitter.VccOfflineStatsCallback.a(this.f15910a, list);
                }
            });
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertEvent(String str, final long j5) {
            C0742e.c("V3OfflineEmitter", "onRealInsertEvent2Remote, eventId:" + j5);
            V3OfflineEmitter.this.f15893e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.e
                @Override // java.lang.Runnable
                public final void run() {
                    V3OfflineEmitter.VccOfflineStatsCallback.b(this.f15908a, j5);
                }
            });
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertH5Event(String str, long j5) {
        }

        /* synthetic */ VccOfflineStatsCallback(V3OfflineEmitter v3OfflineEmitter, a aVar) {
            this();
        }
    }

    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f15897a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (this.f15897a.get() == Integer.MAX_VALUE) {
                this.f15897a.set(0);
            }
            return new Thread(runnable, "V3OfflineEmitterTask#" + this.f15897a.getAndIncrement());
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (V3OfflineEmitter.this.f15894f.j() >= 500) {
                C0742e.c("V3OfflineEmitter", "Sp data more than 500, into the clear.");
                V3OfflineEmitter.this.f15894f.c();
            }
            Log.d("V3OfflineEmitter", "init thread:" + Thread.currentThread().getName());
            Iterator<? extends Map.Entry<String, ?>> it = V3OfflineEmitter.this.f15894f.i().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                try {
                    long j5 = Integer.parseInt(key);
                    if (V3OfflineEmitter.this.f15895g < j5) {
                        V3OfflineEmitter.this.f15895g = j5;
                    }
                } catch (Exception e6) {
                    C0742e.d("V3OfflineEmitter", e6.getMessage());
                    V3OfflineEmitter.this.f15894f.b(key);
                }
            }
        }
    }

    public V3OfflineEmitter(Context context, String str, String str2) throws Throwable {
        super(context, str, str2);
        this.f15895g = 0L;
        this.f15893e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new RejectedExecutionHandler() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.b
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                C0742e.d("V3OfflineEmitter", "Task exceeds maximum limit");
            }
        });
        this.f15896h = context.getPackageName();
        try {
            String strA = C0669e.a(context);
            if (strA == null || strA.equals(context.getPackageName())) {
                this.f15894f = new C0720b(this.f15889a, "com.stepos.statsapp.v3.events_cache");
            } else {
                this.f15894f = new C0720b(this.f15889a, "com.stepos.statsapp.v3.events_cache_" + strA);
            }
            this.f15893e.execute(new b());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f15892d = new VccOfflineStatsCallback(this, null);
        g.c().e(context, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str, TrackerPayload trackerPayload) {
        Log.d("V3OfflineEmitter", "add thread:" + Thread.currentThread().getName());
        this.f15895g = this.f15895g + 1;
        C0742e.c("V3OfflineEmitter", "add rowId:" + this.f15895g + ",payload:" + str);
        if (g.c().g(this.f15889a, this.f15896h, this.f15890b)) {
            g.c().i(this.f15889a, this.f15896h, this.f15890b.a(), this.f15890b.c(), this.f15895g, trackerPayload);
            if (this.f15894f.j() < 500) {
                this.f15894f.e(String.valueOf(this.f15895g), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(String str, String str2) {
        g.c().h(this.f15889a, str, str2);
    }

    private void t(List<Long> list, List<TrackerPayload> list2) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (i6 != 0 && i6 % 10 == 0) {
                i5++;
                int i7 = i6 - 10;
                g.c().j(this.f15889a, this.f15896h, this.f15890b.a(), this.f15890b.c(), list.subList(i7, i6), list2.subList(i7, i6));
                C0742e.c("V3OfflineEmitter", "addCachedEventToRemote 1, eventIds:" + Arrays.toString(list.subList(i7, i6).toArray()));
            }
        }
        int i8 = i5 * 10;
        if (i8 < list.size()) {
            int size = list.size();
            g.c().j(this.f15889a, this.f15896h, this.f15890b.a(), this.f15890b.c(), list.subList(i8, size), list2.subList(i8, size));
            C0742e.c("V3OfflineEmitter", "addCachedEventToRemote 2, eventIds:" + Arrays.toString(list.subList(i8, size).toArray()));
        }
    }

    private void u(final boolean z5) {
        this.f15893e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f15900a.w(z5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(boolean z5) {
        Log.d("V3OfflineEmitter", "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
        C0742e.c("V3OfflineEmitter", "addCachedEventsToRemote begin");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f15894f.i()) {
            String key = entry.getKey();
            try {
                long j5 = Integer.parseInt(key);
                TrackerPayload trackerPayloadB = TrackerPayload.B((String) entry.getValue());
                if (trackerPayloadB != null) {
                    if (!z5) {
                        Object obj = trackerPayloadB.D().get("time");
                        if (obj instanceof Long) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= 300000) {
                            }
                        }
                    }
                    arrayList.add(Long.valueOf(j5));
                    arrayList2.add(trackerPayloadB);
                }
            } catch (Exception e6) {
                C0742e.d("V3OfflineEmitter", e6.getMessage());
                this.f15894f.b(key);
            }
        }
        t(arrayList, arrayList2);
        C0742e.c("V3OfflineEmitter", "addCachedEventsToRemote end");
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.b
    public void a() {
        g.c().f(this.f15889a, this.f15896h, this.f15892d);
        u(false);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.b
    public void b(ServiceConnection serviceConnection) {
        try {
            this.f15889a.unbindService(serviceConnection);
        } catch (Throwable th) {
            C0742e.d("V3OfflineEmitter", "onServiceDisconnected error, " + th.getMessage());
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.a
    public void c(final TrackerPayload trackerPayload) throws JSONException {
        if (this.f15890b.f()) {
            final String string = trackerPayload.toString();
            this.f15893e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15905a.r(string, trackerPayload);
                }
            });
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.a
    public void d(TrackerPayload trackerPayload) throws JSONException {
        C0742e.c("V3OfflineEmitter", "addNeartime payload:" + trackerPayload.toString());
        c(trackerPayload);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.a
    public void e(TrackerPayload trackerPayload) throws JSONException {
        C0742e.c("V3OfflineEmitter", "addRealtime payload:" + trackerPayload.toString());
        c(trackerPayload);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.a
    @Deprecated
    public void g() {
        C0742e.c("V3OfflineEmitter", "flush");
        C0720b c0720b = this.f15894f;
        if (c0720b == null || c0720b.j() <= 0) {
            return;
        }
        C0742e.c("V3OfflineEmitter", "flush sp data");
        u(true);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.a
    public void j(final String str, final String str2) {
        this.f15893e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f15902a.s(str, str2);
            }
        });
    }
}
