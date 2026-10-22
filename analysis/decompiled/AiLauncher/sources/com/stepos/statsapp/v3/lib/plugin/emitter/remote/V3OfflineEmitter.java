package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import com.stepos.statsapp.v3.lib.plugin.emitter.Emitter;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.a;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.utils.ProcessUtils;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
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

/* loaded from: classes2.dex */
public class V3OfflineEmitter extends Emitter implements a.b {

    /* renamed from: f, reason: collision with root package name */
    private static final String f30750f = "V3OfflineEmitter";

    /* renamed from: g, reason: collision with root package name */
    private static final int f30751g = 300000;

    /* renamed from: h, reason: collision with root package name */
    private static final int f30752h = 500;

    /* renamed from: a, reason: collision with root package name */
    private VccOfflineStatsCallback f30753a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f30754b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferencesHelper f30755c;

    /* renamed from: d, reason: collision with root package name */
    private long f30756d;

    /* renamed from: e, reason: collision with root package name */
    private String f30757e;

    public class VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
        private VccOfflineStatsCallback() {
        }

        public static /* synthetic */ void a(VccOfflineStatsCallback vccOfflineStatsCallback, List list) {
            vccOfflineStatsCallback.getClass();
            Log.d(V3OfflineEmitter.f30750f, "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                V3OfflineEmitter.this.f30755c.edit().remove(String.valueOf((Long) it.next()));
            }
            if (list.isEmpty()) {
                return;
            }
            V3OfflineEmitter.this.f30755c.edit().commit();
        }

        public static /* synthetic */ void b(VccOfflineStatsCallback vccOfflineStatsCallback, long j10) {
            vccOfflineStatsCallback.getClass();
            Log.d(V3OfflineEmitter.f30750f, "onRealInsertEvent thread:" + Thread.currentThread().getName());
            V3OfflineEmitter.this.f30755c.commitRemove(String.valueOf(j10));
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealBulkInsertEvents(String str, final List list) throws RemoteException {
            Logger.d(V3OfflineEmitter.f30750f, "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
            V3OfflineEmitter.this.f30754b.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.g
                @Override // java.lang.Runnable
                public final void run() {
                    V3OfflineEmitter.VccOfflineStatsCallback.a(this.f30780a, list);
                }
            });
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertEvent(String str, final long j10) throws RemoteException {
            Logger.d(V3OfflineEmitter.f30750f, "onRealInsertEvent2Remote, eventId:" + j10);
            V3OfflineEmitter.this.f30754b.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.f
                @Override // java.lang.Runnable
                public final void run() {
                    V3OfflineEmitter.VccOfflineStatsCallback.b(this.f30778a, j10);
                }
            });
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertH5Event(String str, long j10) throws RemoteException {
        }

        public /* synthetic */ VccOfflineStatsCallback(V3OfflineEmitter v3OfflineEmitter, a aVar) {
            this();
        }
    }

    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f30758a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (this.f30758a.get() == Integer.MAX_VALUE) {
                this.f30758a.set(0);
            }
            return new Thread(runnable, "V3OfflineEmitterTask#" + this.f30758a.getAndIncrement());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (V3OfflineEmitter.this.f30755c.getAllSize() >= 500) {
                Logger.d(V3OfflineEmitter.f30750f, "Sp data more than 500, into the clear.");
                V3OfflineEmitter.this.f30755c.commitClear();
            }
            Log.d(V3OfflineEmitter.f30750f, "init thread:" + Thread.currentThread().getName());
            Iterator<? extends Map.Entry<String, ?>> it = V3OfflineEmitter.this.f30755c.getAllEntries().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                try {
                    long j10 = Integer.parseInt(key);
                    if (V3OfflineEmitter.this.f30756d < j10) {
                        V3OfflineEmitter.this.f30756d = j10;
                    }
                } catch (Exception e10) {
                    Logger.e(V3OfflineEmitter.f30750f, e10.getMessage());
                    V3OfflineEmitter.this.f30755c.applyRemove(key);
                }
            }
        }
    }

    public V3OfflineEmitter(Context context, String str, String str2) throws Throwable {
        super(context, str, str2);
        this.f30756d = 0L;
        this.f30754b = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new RejectedExecutionHandler() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.d
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Logger.e(V3OfflineEmitter.f30750f, "Task exceeds maximum limit");
            }
        });
        this.f30757e = context.getPackageName();
        try {
            String currentProcessName = ProcessUtils.getCurrentProcessName(context);
            if (currentProcessName == null || currentProcessName.equals(context.getPackageName())) {
                this.f30755c = new SharedPreferencesHelper(this.mContext, "com.stepos.statsapp.v3.events_cache");
            } else {
                this.f30755c = new SharedPreferencesHelper(this.mContext, "com.stepos.statsapp.v3.events_cache_" + currentProcessName);
            }
            this.f30754b.execute(new b());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f30753a = new VccOfflineStatsCallback(this, null);
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(context, this);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void add(final TrackerPayload trackerPayload) throws JSONException {
        if (this.emitterConfig.isActive()) {
            final String string = trackerPayload.toString();
            this.f30754b.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30775a.a(trackerPayload, string);
                }
            });
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void addNeartime(TrackerPayload trackerPayload) throws JSONException {
        Logger.d(f30750f, "addNeartime payload:" + trackerPayload.toString());
        add(trackerPayload);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void addRealtime(TrackerPayload trackerPayload) throws JSONException {
        Logger.d(f30750f, "addRealtime payload:" + trackerPayload.toString());
        add(trackerPayload);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    @Deprecated
    public void flush() {
        Logger.d(f30750f, "flush");
        SharedPreferencesHelper sharedPreferencesHelper = this.f30755c;
        if (sharedPreferencesHelper == null || sharedPreferencesHelper.getAllSize() <= 0) {
            return;
        }
        Logger.d(f30750f, "flush sp data");
        a(true);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public String getUMID() {
        return com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, this.f30757e);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void init() {
        Logger.d(f30750f, "remoteInit, packageName; " + this.f30757e + ", config: " + this.emitterConfig);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void setEncrypt(boolean z10) {
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void updateEventSource(final String str, final String str2) {
        this.f30754b.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f30770a.a(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z10) {
        Log.d(f30750f, "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
        Logger.d(f30750f, "addCachedEventsToRemote begin");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f30755c.getAllEntries()) {
            String key = entry.getKey();
            try {
                long j10 = Integer.parseInt(key);
                TrackerPayload trackerPayloadFromString = TrackerPayload.fromString((String) entry.getValue());
                if (trackerPayloadFromString != null) {
                    if (!z10) {
                        Object obj = trackerPayloadFromString.getHeaderMap().get("time");
                        if (obj instanceof Long) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= 300000) {
                            }
                        }
                    }
                    arrayList.add(Long.valueOf(j10));
                    arrayList2.add(trackerPayloadFromString);
                }
            } catch (Exception e10) {
                Logger.e(f30750f, e10.getMessage());
                this.f30755c.applyRemove(key);
            }
        }
        a(arrayList, arrayList2);
        Logger.d(f30750f, "addCachedEventsToRemote end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TrackerPayload trackerPayload, String str) {
        Log.d(f30750f, "add thread:" + Thread.currentThread().getName());
        this.f30756d = this.f30756d + 1;
        Logger.d(f30750f, "add rowId:" + this.f30756d);
        if (com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, this.f30757e, this.emitterConfig)) {
            com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, this.f30757e, this.emitterConfig.getAppId(), this.emitterConfig.getChannel(), this.f30756d, trackerPayload);
            if (this.f30755c.getAllSize() < 500) {
                this.f30755c.commitConfig(String.valueOf(this.f30756d), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, str, str2);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.b
    public void a() {
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, this.f30757e, this.f30753a);
        a(false);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.b
    public void a(ServiceConnection serviceConnection) {
        try {
            this.mContext.unbindService(serviceConnection);
        } catch (Throwable th) {
            Logger.e(f30750f, "onServiceDisconnected error, " + th.getMessage());
        }
    }

    private void a(final boolean z10) {
        this.f30754b.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f30773a.b(z10);
            }
        });
    }

    private void a(List<Long> list, List<TrackerPayload> list2) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (i11 != 0 && i11 % 10 == 0) {
                i10++;
                int i12 = i11 - 10;
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, this.f30757e, this.emitterConfig.getAppId(), this.emitterConfig.getChannel(), list.subList(i12, i11), list2.subList(i12, i11));
                Logger.d(f30750f, "addCachedEventToRemote 1, eventIds:" + Arrays.toString(list.subList(i12, i11).toArray()));
            }
        }
        int i13 = i10 * 10;
        if (i13 < list.size()) {
            int size = list.size();
            com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().a(this.mContext, this.f30757e, this.emitterConfig.getAppId(), this.emitterConfig.getChannel(), list.subList(i13, size), list2.subList(i13, size));
            Logger.d(f30750f, "addCachedEventToRemote 2, eventIds:" + Arrays.toString(list.subList(i13, size).toArray()));
        }
    }
}
