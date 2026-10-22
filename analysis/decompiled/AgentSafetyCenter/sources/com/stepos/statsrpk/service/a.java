package com.stepos.statsrpk.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p5.i;
import p5.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Context f2877c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ RpkUsageStatsService.RpkStatsInterface f2878f;

    @Override // java.lang.Runnable
    public final void run() {
        wa.a aVar;
        i iVar = new i();
        iVar.f9730c = this.f2877c;
        this.f2878f.subject = iVar.d();
        RpkUsageStatsService.RpkStatsInterface rpkStatsInterface = this.f2878f;
        Context context = rpkStatsInterface.mContext;
        e eVar = new e();
        eVar.f2887a = context;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        eVar.f2889c = scheduledExecutorServiceNewScheduledThreadPool;
        n6.a aVar2 = new n6.a();
        aVar2.f8777f = context;
        l lVar = na.a.f8798a;
        lVar.f9738c = l.f(context, "salt", 32);
        lVar.f9739f = l.f(context, "iv", 16);
        wa.a aVar3 = wa.a.f15387c;
        synchronized (wa.a.class) {
            try {
                if (wa.a.f15387c == null) {
                    wa.a aVar4 = new wa.a(context, "statsrpk.db", null, 1);
                    ua.c.a("com.stepos.statsrpk.storage.b", "DATABASE_VERSION 1");
                    wa.a.f15387c = aVar4;
                }
                aVar = wa.a.f15387c;
            } finally {
            }
        }
        synchronized (aVar2) {
            if (!aVar2.j()) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar2.f8776c = writableDatabase;
                writableDatabase.enableWriteAheadLogging();
            }
        }
        ua.c.a("a", "DB Path:" + ((SQLiteDatabase) aVar2.f8776c).getPath());
        eVar.f2888b = aVar2;
        if (la.b.f7817d == null) {
            synchronized (la.b.f7818e) {
                try {
                    if (la.b.f7817d == null) {
                        la.b.f7817d = new la.b(context);
                    }
                } finally {
                }
            }
        }
        ArrayList arrayList = la.b.f7817d.f7821c;
        if (arrayList != null) {
            arrayList.add(eVar);
        }
        c cVar = new c(0);
        cVar.f2883f = eVar;
        VarHandle.storeStoreFence();
        scheduledExecutorServiceNewScheduledThreadPool.schedule(cVar, 1800000L, TimeUnit.MILLISECONDS);
        rpkStatsInterface.rpkEmitterWorker = eVar;
    }
}
