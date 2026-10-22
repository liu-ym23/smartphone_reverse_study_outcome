package a4;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.work.Worker;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import h5.d0;
import ie.o0;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f184c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f185f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f186g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f187h;

    public /* synthetic */ l(int i) {
        this.f184c = i;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        boolean zBooleanValue = true;
        switch (this.f184c) {
            case 0:
                n nVar = (n) this.f185f;
                id.k kVar = (id.k) this.f186g;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f187h;
                try {
                    v vVarK = id.c.k(nVar.f190a);
                    if (vVarK == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    u uVar = (u) ((i) vVarK.f168b);
                    synchronized (uVar.f204d) {
                        uVar.f206f = threadPoolExecutor;
                    }
                    i iVar = (i) vVarK.f168b;
                    m mVar = new m();
                    mVar.f188c = kVar;
                    mVar.f189d = threadPoolExecutor;
                    VarHandle.storeStoreFence();
                    iVar.a(mVar);
                    return;
                } catch (Throwable th) {
                    kVar.J(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.f fVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.f185f;
                TrackerPayload trackerPayload = (TrackerPayload) this.f186g;
                String str = (String) this.f187h;
                ta.a aVar = fVar.f2835f;
                Log.d("V3OfflineEmitter", "add thread:" + Thread.currentThread().getName());
                fVar.f2836g = fVar.f2836g + 1;
                ua.c.a("V3OfflineEmitter", "add rowId:" + fVar.f2836g);
                p5.i iVar2 = com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.f2838a;
                Context context = fVar.f2830a;
                String str2 = fVar.f2837h;
                EmitterConfig emitterConfig = fVar.f2831b;
                if (!p5.i.i) {
                    if (!iVar2.j(context)) {
                        return;
                    }
                    try {
                        p5.i.i = true;
                        ((IVccOfflineStatsInterface) iVar2.f9731f).emitterUpdateConfig(str2, emitterConfig);
                    } catch (Throwable th2) {
                        ua.c.b("V3RemoteServiceReq", "emitterUpdateConfig error, " + th2.getMessage());
                        return;
                    }
                }
                String str3 = fVar.f2837h;
                String str4 = emitterConfig.f2818n;
                String str5 = emitterConfig.f2819o;
                long j10 = fVar.f2836g;
                if (iVar2.j(context)) {
                    try {
                        ((IVccOfflineStatsInterface) iVar2.f9731f).emitterAddEvent(str3, str4, str5, j10, trackerPayload);
                    } catch (Throwable th3) {
                        ua.c.b("V3RemoteServiceReq", "emitterAddEvent error, " + th3.getMessage());
                    }
                }
                if (aVar.f13291a.getAll().size() < 500) {
                    aVar.a(String.valueOf(fVar.f2836g), str);
                    return;
                }
                return;
            case 2:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f185f;
                t2.j jVar = (t2.j) this.f186g;
                a1.b bVar = (a1.b) this.f187h;
                if (atomicBoolean.get()) {
                    return;
                }
                try {
                    jVar.a(bVar.invoke());
                    return;
                } catch (Throwable th4) {
                    jVar.b(th4);
                    return;
                }
            case 3:
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) this.f185f;
                t2.j jVar2 = (t2.j) this.f186g;
                ad.l lVar = (ad.l) this.f187h;
                if (atomicBoolean2.get()) {
                    return;
                }
                try {
                    jVar2.a(((Worker) lVar.f543f).b());
                    return;
                } catch (Throwable th5) {
                    jVar2.b(th5);
                    return;
                }
            case 4:
                h5.d dVar = (h5.d) this.f185f;
                t2.m mVar2 = (t2.m) this.f186g;
                d0 d0Var = (d0) this.f187h;
                dVar.getClass();
                try {
                    zBooleanValue = ((Boolean) mVar2.f13165f.get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused) {
                }
                synchronized (dVar.f5324j) {
                    try {
                        p5.j jVarR = td.h.r(d0Var.f5325a);
                        String str6 = jVarR.f9734a;
                        if (dVar.c(str6) == d0Var) {
                            dVar.b(str6);
                        }
                        g5.u.d().a(h5.d.f5315k, h5.d.class.getSimpleName() + " " + str6 + " executed; reschedule = " + zBooleanValue);
                        ArrayList arrayList = dVar.i;
                        int size = arrayList.size();
                        while (i < size) {
                            Object obj = arrayList.get(i);
                            i++;
                            ((h5.a) obj).e(jVarR, zBooleanValue);
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
                return;
            case 5:
                ((h5.d) ((p5.e) this.f185f).f9722f).h((h5.j) this.f186g, (n6.a) this.f187h);
                return;
            case 6:
                p5.u uVar2 = (p5.u) this.f185f;
                ie.f fVar2 = (ie.f) this.f186g;
                o0 o0Var = (o0) this.f187h;
                ie.m mVar3 = (ie.m) uVar2.f9808g;
                if (mVar3.f6018f.g()) {
                    fVar2.t(mVar3, new IOException("Canceled"));
                    return;
                } else {
                    fVar2.l(mVar3, o0Var);
                    return;
                }
            case 7:
                ((ie.f) this.f186g).t((ie.m) ((p5.u) this.f185f).f9808g, (Throwable) this.f187h);
                return;
            default:
                WorkDatabase workDatabase = (WorkDatabase) this.f185f;
                String str7 = (String) this.f186g;
                h5.r rVar = (h5.r) this.f187h;
                p5.s sVarC = workDatabase.C();
                sVarC.getClass();
                androidx.room.x xVarD = androidx.room.x.d(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
                xVarD.h(1, str7);
                WorkDatabase_Impl workDatabase_Impl = sVarC.f9791a;
                workDatabase_Impl.b();
                Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
                try {
                    ArrayList arrayList2 = new ArrayList(cursorD.getCount());
                    while (cursorD.moveToNext()) {
                        arrayList2.add(cursorD.getString(0));
                    }
                    cursorD.close();
                    xVarD.e();
                    int size2 = arrayList2.size();
                    while (i < size2) {
                        Object obj2 = arrayList2.get(i);
                        i++;
                        id.k.j(rVar, (String) obj2);
                    }
                    return;
                } catch (Throwable th7) {
                    cursorD.close();
                    xVarD.e();
                    throw th7;
                }
        }
    }
}
