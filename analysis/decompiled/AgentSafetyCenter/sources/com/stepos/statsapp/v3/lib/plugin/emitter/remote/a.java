package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import a4.t;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.a0;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p5.m;
import t.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2820c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f2821f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2822g;

    public /* synthetic */ a(int i) {
        this.f2820c = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i;
        int i3 = 0;
        switch (this.f2820c) {
            case 0:
                f fVar = (f) this.f2822g;
                boolean z10 = this.f2821f;
                Log.d("V3OfflineEmitter", "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
                ua.c.a("V3OfflineEmitter", "addCachedEventsToRemote begin");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ta.a aVar = fVar.f2835f;
                for (Map.Entry<String, ?> entry : aVar.f13291a.getAll().entrySet()) {
                    String key = entry.getKey();
                    try {
                        long j10 = Integer.parseInt(key);
                        TrackerPayload trackerPayloadC = TrackerPayload.c((String) entry.getValue());
                        if (trackerPayloadC != null) {
                            if (!z10) {
                                Object obj = trackerPayloadC.f2842c.get("time");
                                if (obj instanceof Long) {
                                    long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= 300000) {
                                    }
                                }
                            }
                            arrayList.add(Long.valueOf(j10));
                            arrayList2.add(trackerPayloadC);
                        }
                    } catch (Exception e10) {
                        ua.c.b("V3OfflineEmitter", e10.getMessage());
                        aVar.f13291a.edit().remove(key).apply();
                    }
                }
                EmitterConfig emitterConfig = fVar.f2831b;
                int i10 = 0;
                while (i3 < arrayList.size()) {
                    if (i3 != 0 && i3 % 10 == 0) {
                        i10++;
                        int i11 = i3 - 10;
                        g.f2838a.f(fVar.f2830a, fVar.f2837h, emitterConfig.f2818n, emitterConfig.f2819o, arrayList.subList(i11, i3), arrayList2.subList(i11, i3));
                        ua.c.a("V3OfflineEmitter", "addCachedEventToRemote 1, eventIds:" + Arrays.toString(arrayList.subList(i11, i3).toArray()));
                    }
                    i3++;
                }
                int i12 = i10 * 10;
                if (i12 < arrayList.size()) {
                    int size = arrayList.size();
                    g.f2838a.f(fVar.f2830a, fVar.f2837h, emitterConfig.f2818n, emitterConfig.f2819o, arrayList.subList(i12, size), arrayList2.subList(i12, size));
                    ua.c.a("V3OfflineEmitter", "addCachedEventToRemote 2, eventIds:" + Arrays.toString(arrayList.subList(i12, size).toArray()));
                }
                ua.c.a("V3OfflineEmitter", "addCachedEventsToRemote end");
                return;
            default:
                ma.e eVar = (ma.e) this.f2822g;
                boolean z11 = this.f2821f;
                ua.c.d("SDKInstanceImpl", "realInit start");
                AgentSafetyApplication agentSafetyApplication = eVar.f8539a;
                String str = eVar.f8540b;
                String str2 = eVar.f8541c;
                int i13 = 1;
                if (eVar.f8542d != null) {
                    ua.c.f("SDKInstanceImpl", "initTracker fail, tracker is no null");
                } else {
                    try {
                        ua.c.d("SDKInstanceImpl", "initTracker start");
                        f fVarC = f.c(agentSafetyApplication, str, str2);
                        qa.c cVarB = qa.c.b(agentSafetyApplication, str, SdkVer.verName);
                        ab.c cVar = new ab.c();
                        cVar.f384c = agentSafetyApplication;
                        cVar.f383b = fVarC;
                        VarHandle.storeStoreFence();
                        cVar.f385d = cVarB;
                        cVar.f382a = o.j(agentSafetyApplication);
                        eVar.f8542d = cVar.a();
                        ua.c.d("SDKInstanceImpl", "initTracker success");
                        AgentSafetyApplication agentSafetyApplication2 = eVar.f8539a;
                        if (ea.a.f3744a.booleanValue()) {
                            ua.c.f("BootUpHelper", "onBootUpEvent mBootUpEventComplete is true");
                        } else {
                            try {
                                ta.a aVar2 = new ta.a(agentSafetyApplication2, "com.stepos.statsapp.v3.common");
                                SharedPreferences sharedPreferences = aVar2.f13291a;
                                HashMap map = new HashMap();
                                map.put("daily_actived", String.valueOf(ea.a.a(aVar2)));
                                if (sharedPreferences.getBoolean("GLOBAL_ACTIVED", true)) {
                                    sharedPreferences.edit().putBoolean("GLOBAL_ACTIVED", false).commit();
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                map.put("global_actived", String.valueOf(i));
                                ma.e eVar2 = ma.d.f8538a;
                                eVar2.f8545g.a(eVar2.f8539a, "_bootup_", null, map, 0);
                                ea.a.f3744a = Boolean.TRUE;
                            } catch (Exception e11) {
                                ua.c.b("BootUpHelper", "onBootUpEvent error, " + e11);
                            }
                        }
                        if (eVar.f8546h != null) {
                            ua.c.a("SDKInstanceImpl", "cancel retry core init task");
                            eVar.f8546h.cancel(true);
                        }
                        m mVar = eVar.f8544f;
                        mVar.getClass();
                        if (!TextUtils.isEmpty(null)) {
                            if (TextUtils.isEmpty(null)) {
                                com.stepos.statsrpk.e eVar3 = (com.stepos.statsrpk.e) mVar.f9742g;
                                t tVar = new t(20);
                                tVar.f200f = mVar;
                                VarHandle.storeStoreFence();
                                eVar3.post(tVar);
                            } else {
                                ua.c.a("SessionController", "source already exist: null, session: " + ((String) mVar.f9741f) + ", not set again");
                            }
                        }
                        ha.c cVar2 = eVar.f8545g;
                        synchronized (cVar2) {
                            if (cVar2.f5430a.isEmpty()) {
                                ua.c.a("EventController", "fail event data list is empty");
                                return;
                            }
                            pa.c cVar3 = ma.d.f8538a.f8542d;
                            while (i3 < cVar2.f5430a.size()) {
                                pa.b bVar = (pa.b) cVar2.f5430a.get(i3);
                                cVar3.getClass();
                                a0 a0Var = new a0(7);
                                a0Var.f1506f = cVar3;
                                a0Var.f1507g = bVar;
                                VarHandle.storeStoreFence();
                                sa.c.f(a0Var);
                                i3++;
                            }
                            ua.c.d("EventController", "resend fail event data success, number: " + cVar2.f5430a.size());
                            cVar2.f5430a.clear();
                            return;
                        }
                    } catch (Exception e12) {
                        ua.c.b("SDKInstanceImpl", "initTracker error, " + e12);
                        eVar.f8542d = null;
                    }
                }
                if (z11) {
                    ua.c.d("SDKInstanceImpl", "schedule " + eVar.i + " milliseconds retry real init");
                    r5.a aVar3 = sa.d.f12171a;
                    long j11 = eVar.i;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    ma.c cVar4 = new ma.c(i13);
                    cVar4.f8537f = eVar;
                    VarHandle.storeStoreFence();
                    eVar.f8546h = ((ScheduledThreadPoolExecutor) aVar3.f10462f).schedule(cVar4, j11, timeUnit);
                    eVar.i *= 2;
                    return;
                }
                return;
        }
    }
}
