package com.stepos.statsrpk.service;

import M0.k;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import com.zyql.common.utils.upload.TOSUploader;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3983a;
    public final /* synthetic */ RpkUsageStatsService.RpkStatsInterface b;

    public a(RpkUsageStatsService.RpkStatsInterface rpkStatsInterface, Context context) {
        this.b = rpkStatsInterface;
        this.f3983a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y5.b bVar;
        u1.d dVar = new u1.d(3);
        dVar.b = this.f3983a;
        this.b.subject = new S5.a(dVar);
        RpkUsageStatsService.RpkStatsInterface rpkStatsInterface = this.b;
        Context context = rpkStatsInterface.mContext;
        e eVar = new e();
        eVar.f3986a = context;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        eVar.c = scheduledExecutorServiceNewScheduledThreadPool;
        Y5.a aVar = new Y5.a();
        aVar.b = context;
        k kVar = P5.a.f1089a;
        kVar.b = k.m(context, "salt", 32);
        kVar.c = k.m(context, "iv", 16);
        int i = Y5.b.c;
        synchronized (Y5.b.class) {
            try {
                if (Y5.b.b == null) {
                    Y5.b bVar2 = new Y5.b(context, "statsrpk.db", null, 1, 0);
                    W5.c.a("com.stepos.statsrpk.storage.b", "DATABASE_VERSION 1");
                    Y5.b.b = bVar2;
                }
                bVar = Y5.b.b;
            } finally {
            }
        }
        synchronized (aVar) {
            if (!aVar.e()) {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                aVar.f1563a = writableDatabase;
                writableDatabase.enableWriteAheadLogging();
            }
        }
        W5.c.a("a", "DB Path:" + aVar.f1563a.getPath());
        eVar.b = aVar;
        if (N5.c.d == null) {
            synchronized (N5.c.e) {
                try {
                    if (N5.c.d == null) {
                        N5.c.d = new N5.c(context);
                    }
                } finally {
                }
            }
        }
        ArrayList arrayList = N5.c.d.c;
        if (arrayList != null) {
            arrayList.add(eVar);
        }
        scheduledExecutorServiceNewScheduledThreadPool.schedule(new d(eVar, 0), TOSUploader.EXPIRED_TIMES, TimeUnit.MILLISECONDS);
        rpkStatsInterface.rpkEmitterWorker = eVar;
    }
}
