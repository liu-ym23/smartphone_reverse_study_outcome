package X;

import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import e2.AbstractC0552a;
import g2.AbstractC0576a;
import j.C0622a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import t0.InterfaceC0918d;
import t0.P;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2066a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2067b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2068c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2069d;

    public /* synthetic */ l(int i4, Object obj, Object obj2, Object obj3) {
        this.f2066a = i4;
        this.f2067b = obj;
        this.f2068c = obj2;
        this.f2069d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue = true;
        switch (this.f2066a) {
            case 0:
                C0622a c0622a = (C0622a) this.f2067b;
                B0.f fVar = (B0.f) this.f2068c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f2069d;
                c0622a.getClass();
                try {
                    x xVarI = com.airbnb.lottie.h.i(c0622a.f13046b);
                    if (xVarI == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    w wVar = (w) xVarI.f2050a;
                    synchronized (wVar.f2096d) {
                        wVar.f2098f = threadPoolExecutor;
                    }
                    xVarI.f2050a.a(new m(fVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    fVar.U(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
            default:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.e eVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) this.f2067b;
                String str = (String) this.f2068c;
                TrackerPayload trackerPayload = (TrackerPayload) this.f2069d;
                eVar.getClass();
                Log.d("V3OfflineEmitter", "add thread:" + Thread.currentThread().getName());
                eVar.f12332g = eVar.f12332g + 1;
                T2.d.a("V3OfflineEmitter", "add rowId:" + eVar.f12332g + ",payload:" + str);
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.i iVar = com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.f12334a;
                Context context = eVar.f12326a;
                String str2 = eVar.f12333h;
                EmitterConfig emitterConfig = eVar.f12327b;
                if (com.stepos.statsapp.v3.lib.plugin.emitter.remote.i.f12336e) {
                    iVar.getClass();
                } else {
                    if (!iVar.c(context)) {
                        return;
                    }
                    try {
                        com.stepos.statsapp.v3.lib.plugin.emitter.remote.i.f12336e = true;
                        iVar.f12338b.emitterUpdateConfig(str2, emitterConfig);
                    } catch (Throwable th2) {
                        T2.d.b("V3RemoteServiceReq", "emitterUpdateConfig error, " + th2.getMessage());
                        return;
                    }
                }
                Context context2 = eVar.f12326a;
                String str3 = eVar.f12333h;
                EmitterConfig emitterConfig2 = eVar.f12327b;
                String str4 = emitterConfig2.f12318j;
                String str5 = emitterConfig2.f12319k;
                long j4 = eVar.f12332g;
                if (iVar.c(context2)) {
                    try {
                        iVar.f12338b.emitterAddEvent(str3, str4, str5, j4, trackerPayload);
                    } catch (Throwable th3) {
                        T2.d.b("V3RemoteServiceReq", "emitterAddEvent error, " + th3.getMessage());
                    }
                }
                S2.a aVar = eVar.f12331f;
                if (aVar.f1791a.getAll().size() < 500) {
                    aVar.a(String.valueOf(eVar.f12332g), str);
                    return;
                }
                return;
            case 2:
                t0.r rVar = (t0.r) this.f2067b;
                D1.a aVar2 = (D1.a) this.f2068c;
                P p4 = (P) this.f2069d;
                String str6 = t0.r.f15402l;
                rVar.getClass();
                try {
                    zBooleanValue = ((Boolean) aVar2.get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused) {
                }
                synchronized (rVar.f15413k) {
                    try {
                        B0.k kVarV = B0.f.v(p4.f15366d);
                        String str7 = kVarV.f150a;
                        if (rVar.c(str7) == p4) {
                            rVar.b(str7);
                        }
                        s0.t.d().a(t0.r.f15402l, t0.r.class.getSimpleName() + AwarenessDataItem.PERMISSION_SPLITTER + str7 + " executed; reschedule = " + zBooleanValue);
                        Iterator it = rVar.f15412j.iterator();
                        while (it.hasNext()) {
                            ((InterfaceC0918d) it.next()).c(kVarV, zBooleanValue);
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                return;
            case 3:
                U1.a aVar3 = (U1.a) this.f2067b;
                Context context3 = (Context) this.f2068c;
                Intent intent = (Intent) this.f2069d;
                int i4 = U1.a.f1910a;
                aVar3.getClass();
                Context applicationContext = context3.getApplicationContext();
                B0.c cVar = AbstractC0552a.f12506a;
                AbstractC0155a.b((String) cVar.f136a, "processMessage start");
                try {
                    for (Map.Entry entry : ((HashMap) cVar.f137b).entrySet()) {
                        String str8 = (String) entry.getKey();
                        AbstractC0155a.a((String) cVar.f136a, "processMessage, method: " + str8);
                        if (((AbstractC0576a) entry.getValue()).b(applicationContext, intent, aVar3)) {
                            return;
                        }
                    }
                    return;
                } catch (Exception e4) {
                    AbstractC0155a.c((String) cVar.f136a, "processMessage error " + e4.getMessage());
                    return;
                }
            case 4:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.e eVar2 = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) this.f2067b;
                String str9 = (String) this.f2068c;
                String str10 = (String) this.f2069d;
                eVar2.getClass();
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.i iVar2 = com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.f12334a;
                if (iVar2.c(eVar2.f12326a)) {
                    try {
                        iVar2.f12338b.emitterUpdateEventSource(str9, str10);
                        return;
                    } catch (Throwable th5) {
                        T2.d.b("V3RemoteServiceReq", "emitterUpdateEventSource error, " + th5.getMessage());
                        return;
                    }
                }
                return;
        }
    }
}
