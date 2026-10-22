package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.WorkerParameters;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.f;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.Reason;
import h2.j;
import h6.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import lb.n;
import mb.y;
import q2.k;
import xd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8025a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8026b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8027c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8028d;

    public /* synthetic */ c(eb.a aVar, List list, Reason reason, Download download) {
        this.f8025a = 1;
        this.f8026b = aVar;
        this.f8027c = list;
        this.f8028d = download;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue = true;
        int i10 = 0;
        switch (this.f8025a) {
            case 0:
                V3OfflineEmitter v3OfflineEmitter = (V3OfflineEmitter) this.f8026b;
                String str = (String) this.f8027c;
                TrackerPayload trackerPayload = (TrackerPayload) this.f8028d;
                sa.a aVar = v3OfflineEmitter.f8018f;
                Log.d("V3OfflineEmitter", "add thread:" + Thread.currentThread().getName());
                v3OfflineEmitter.f8019g = v3OfflineEmitter.f8019g + 1;
                ta.c.a("V3OfflineEmitter", "add rowId:" + v3OfflineEmitter.f8019g + ",payload:" + str);
                f fVar = f.b.f8038a;
                Context context = v3OfflineEmitter.f8003a;
                String str2 = v3OfflineEmitter.h;
                EmitterConfig emitterConfig = v3OfflineEmitter.f8004b;
                if (f.f8033e) {
                    fVar.getClass();
                } else {
                    if (!fVar.c(context)) {
                        return;
                    }
                    try {
                        f.f8033e = true;
                        fVar.f8035b.emitterUpdateConfig(str2, emitterConfig);
                    } catch (Throwable th) {
                        ta.c.b("V3RemoteServiceReq", "emitterUpdateConfig error, " + th.getMessage());
                        return;
                    }
                }
                String str3 = v3OfflineEmitter.h;
                String appId = emitterConfig.getAppId();
                String channel = emitterConfig.getChannel();
                long j10 = v3OfflineEmitter.f8019g;
                if (fVar.c(context)) {
                    try {
                        fVar.f8035b.emitterAddEvent(str3, appId, channel, j10, trackerPayload);
                    } catch (Throwable th2) {
                        ta.c.b("V3RemoteServiceReq", "emitterAddEvent error, " + th2.getMessage());
                    }
                }
                if (aVar.f11898a.getAll().size() < 500) {
                    aVar.a(String.valueOf(v3OfflineEmitter.f8019g), str);
                    return;
                }
                return;
            case 1:
                eb.a aVar2 = (eb.a) this.f8026b;
                Download download = (Download) this.f8028d;
                synchronized (aVar2.f8627a) {
                    try {
                        for (ya.e eVar : aVar2.f8627a) {
                            eVar.a();
                            if (download != null) {
                                eVar.onChanged();
                            }
                        }
                        n nVar = n.f10413a;
                    } finally {
                    }
                }
                return;
            case 2:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f8026b;
                CallbackToFutureAdapter.a aVar3 = (CallbackToFutureAdapter.a) this.f8027c;
                zb.a aVar4 = (zb.a) this.f8028d;
                if (atomicBoolean.get()) {
                    return;
                }
                try {
                    aVar3.a(aVar4.invoke());
                    return;
                } catch (Throwable th3) {
                    aVar3.b(th3);
                    return;
                }
            case 3:
                ModelManagerFragment.doRetry$lambda$48((s) this.f8026b, (ModelManagerFragment) this.f8027c, (Context) this.f8028d);
                return;
            case 4:
                ModelManagerFragment.persistRowsCache$lambda$69((ModelManagerFragment) this.f8026b, (Context) this.f8027c, (ArrayList) this.f8028d);
                return;
            case 5:
                androidx.work.impl.a aVar5 = (androidx.work.impl.a) this.f8026b;
                CallbackToFutureAdapter.c cVar = (CallbackToFutureAdapter.c) this.f8027c;
                androidx.work.impl.d dVar = (androidx.work.impl.d) this.f8028d;
                try {
                    zBooleanValue = ((Boolean) cVar.f1027b.get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused) {
                }
                synchronized (aVar5.f2873k) {
                    try {
                        k kVarT = y.t(dVar.f2941a);
                        String str4 = kVarT.f11498a;
                        if (aVar5.c(str4) == dVar) {
                            aVar5.b(str4);
                        }
                        j.d().a(androidx.work.impl.a.f2863l, androidx.work.impl.a.class.getSimpleName() + " " + str4 + " executed; reschedule = " + zBooleanValue);
                        ArrayList arrayList = aVar5.f2872j;
                        int size = arrayList.size();
                        while (i10 < size) {
                            Object obj = arrayList.get(i10);
                            i10++;
                            ((i2.b) obj).a(kVarT, zBooleanValue);
                        }
                    } finally {
                    }
                }
                return;
            case 6:
                ((i2.s) this.f8026b).f9486a.g((i2.k) this.f8027c, (WorkerParameters.a) this.f8028d);
                return;
            case 7:
                try {
                    ((com.stepos.deepbinder.client.channel.remote.b) this.f8026b).b((Bundle) this.f8028d, (String) this.f8027c);
                    return;
                } catch (Throwable th4) {
                    IPCLog.INSTANCE.w("DefaultRemoteChannel", "[call] exception: " + th4, new Object[0]);
                    return;
                }
            default:
                ((xd.d) this.f8027c).a(h.a.this, (Throwable) this.f8028d);
                return;
        }
    }

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i10) {
        this.f8025a = i10;
        this.f8026b = obj;
        this.f8027c = obj2;
        this.f8028d = obj3;
    }
}
