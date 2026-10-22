package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import X.l;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.material.internal.m;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import h.RunnableC0583a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12326a;

    /* renamed from: b, reason: collision with root package name */
    public final EmitterConfig f12327b;

    /* renamed from: c, reason: collision with root package name */
    public final S2.a f12328c;

    /* renamed from: d, reason: collision with root package name */
    public final V3OfflineEmitter$VccOfflineStatsCallback f12329d;

    /* renamed from: e, reason: collision with root package name */
    public final ThreadPoolExecutor f12330e;

    /* renamed from: f, reason: collision with root package name */
    public final S2.a f12331f;

    /* renamed from: g, reason: collision with root package name */
    public long f12332g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12333h;

    public e(Application application, String str, String str2) throws Throwable {
        this.f12326a = application;
        this.f12328c = new S2.a(application, "com.stepos.statsapp.v3.emitterconfig");
        EmitterConfig emitterConfig = new EmitterConfig();
        emitterConfig.f12309a = true;
        emitterConfig.f12311c = true;
        emitterConfig.f12312d = true;
        emitterConfig.f12313e = true;
        emitterConfig.f12314f = VehicleBluetoothManager.FAIL_START_TIMEOUT;
        emitterConfig.f12315g = 50;
        emitterConfig.f12316h = 2097152L;
        emitterConfig.f12317i = 10;
        emitterConfig.f12318j = str;
        emitterConfig.f12319k = str2;
        this.f12327b = emitterConfig;
        c();
        this.f12332g = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        d dVar = new d();
        dVar.f12325a = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, dVar, new a(0));
        this.f12330e = threadPoolExecutor;
        this.f12333h = application.getPackageName();
        try {
            String strV = com.stepos.statsrpk.c.v(application);
            if (strV == null || strV.equals(application.getPackageName())) {
                this.f12331f = new S2.a(this.f12326a, "com.stepos.statsapp.v3.events_cache");
            } else {
                this.f12331f = new S2.a(this.f12326a, "com.stepos.statsapp.v3.events_cache_".concat(strV));
            }
            threadPoolExecutor.execute(new RunnableC0583a(24, this));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f12329d = new V3OfflineEmitter$VccOfflineStatsCallback(this, null);
        g.f12334a.a(application, this);
    }

    public final void a() {
        i iVar = g.f12334a;
        Context context = this.f12326a;
        String str = this.f12333h;
        V3OfflineEmitter$VccOfflineStatsCallback v3OfflineEmitter$VccOfflineStatsCallback = this.f12329d;
        if (iVar.c(context)) {
            try {
                iVar.f12338b.setCallback(str, v3OfflineEmitter$VccOfflineStatsCallback);
            } catch (Throwable th) {
                T2.d.b("V3RemoteServiceReq", "setCallback error, " + th.getMessage());
            }
        }
        this.f12330e.execute(new m(1, this, false));
    }

    public final void b(TrackerPayload trackerPayload) {
        if (this.f12327b.f12309a) {
            this.f12330e.execute(new l(5, this, trackerPayload.toString(), trackerPayload));
        }
    }

    public final void c() {
        EmitterConfig emitterConfig = this.f12327b;
        S2.a aVar = this.f12328c;
        emitterConfig.f12309a = aVar.f1791a.getBoolean("active", true);
        EmitterConfig emitterConfig2 = this.f12327b;
        SharedPreferences sharedPreferences = aVar.f1791a;
        emitterConfig2.f12311c = sharedPreferences.getBoolean("flushOnStart", true);
        this.f12327b.f12313e = sharedPreferences.getBoolean("flushOnReconnect", true);
        this.f12327b.f12312d = sharedPreferences.getBoolean("flushOnCharge", true);
        this.f12327b.f12314f = sharedPreferences.getLong("flushDelayInterval", VehicleBluetoothManager.FAIL_START_TIMEOUT);
        this.f12327b.f12315g = sharedPreferences.getInt("flushCacheLimit", 50);
        this.f12327b.f12316h = sharedPreferences.getLong("flushMobileTrafficLimit", 2097152L);
        this.f12327b.f12317i = sharedPreferences.getInt("neartimeInterval", 5);
    }

    public final void d(boolean z4, boolean z5, boolean z6, boolean z7, long j4, int i4, long j5, int i5) {
        SharedPreferences.Editor editorEdit = this.f12328c.f1791a.edit();
        editorEdit.putBoolean("active", z4);
        editorEdit.putBoolean("flushOnStart", z5);
        editorEdit.putBoolean("flushOnReconnect", z6);
        editorEdit.putBoolean("flushOnCharge", z7);
        editorEdit.putLong("flushDelayInterval", j4);
        editorEdit.putLong("flushMobileTrafficLimit", j5);
        editorEdit.putInt("flushCacheLimit", i4);
        editorEdit.putInt("neartimeInterval", i5);
        editorEdit.apply();
        c();
    }
}
