package com.stepos.statsrpk.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f12374a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RpkUsageStatsService.RpkStatsInterface f12375b;

    public a(RpkUsageStatsService.RpkStatsInterface rpkStatsInterface, Context context) {
        this.f12375b = rpkStatsInterface;
        this.f12374a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V2.b bVar;
        P2.b bVar2 = new P2.b();
        bVar2.f1576a = this.f12374a;
        this.f12375b.subject = new P2.c(bVar2);
        RpkUsageStatsService.RpkStatsInterface rpkStatsInterface = this.f12375b;
        Context context = rpkStatsInterface.mContext;
        d dVar = new d(context, 3);
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        dVar.f12382d = scheduledExecutorServiceNewScheduledThreadPool;
        V2.a aVar = new V2.a();
        aVar.f1934b = context;
        android.support.v4.media.session.c cVar = M2.a.f1437a;
        cVar.getClass();
        cVar.f2365c = android.support.v4.media.session.c.c(context, "salt", 32);
        cVar.f2366d = android.support.v4.media.session.c.c(context, "iv", 16);
        V2.b bVar3 = V2.b.f1935a;
        synchronized (V2.b.class) {
            try {
                if (V2.b.f1935a == null) {
                    V2.b bVar4 = new V2.b(context, "statsrpk.db", null, 1);
                    T2.d.a("com.stepos.statsrpk.storage.b", "DATABASE_VERSION 1");
                    V2.b.f1935a = bVar4;
                }
                bVar = V2.b.f1935a;
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (aVar) {
            if (!aVar.e()) {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                aVar.f1933a = writableDatabase;
                writableDatabase.enableWriteAheadLogging();
            }
        }
        T2.d.a("a", "DB Path:" + aVar.f1933a.getPath());
        dVar.f12381c = aVar;
        if (K2.c.f1044d == null) {
            synchronized (K2.c.f1045e) {
                try {
                    if (K2.c.f1044d == null) {
                        K2.c.f1044d = new K2.c(context);
                    }
                } finally {
                }
            }
        }
        ArrayList arrayList = K2.c.f1044d.f1048c;
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        scheduledExecutorServiceNewScheduledThreadPool.schedule(new c(dVar, 0), VehicleBluetoothManager.FAIL_START_TIMEOUT, TimeUnit.MILLISECONDS);
        rpkStatsInterface.rpkEmitterWorker = dVar;
    }
}
