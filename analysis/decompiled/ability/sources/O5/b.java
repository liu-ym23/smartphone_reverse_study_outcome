package O5;

import F9.v;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.ability.App;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.e;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import z2.l;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1036a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(Object obj, boolean z10, int i) {
        this.f1036a = i;
        this.c = obj;
        this.b = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        switch (this.f1036a) {
            case 0:
                d dVar = (d) this.c;
                boolean z10 = this.b;
                W5.c.d("SDKInstanceImpl", "realInit start");
                App app = dVar.f1038a;
                String str = dVar.b;
                String str2 = dVar.c;
                if (dVar.d != null) {
                    W5.c.f("SDKInstanceImpl", "initTracker fail, tracker is no null");
                } else {
                    try {
                        W5.c.d("SDKInstanceImpl", "initTracker start");
                        com.stepos.statsapp.v3.lib.plugin.emitter.remote.d dVar2 = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.d(app, str, str2);
                        W5.c.d("Emitter", "buildEmitter emitter is V3OfflineEmitter");
                        S5.a aVarA = S5.a.a(app, str, SdkVer.verName);
                        R5.b bVar = new R5.b();
                        bVar.d = null;
                        bVar.c = app;
                        bVar.b = dVar2;
                        bVar.d = aVarA;
                        bVar.f1153a = l.A(app);
                        dVar.d = bVar.a();
                        W5.c.d("SDKInstanceImpl", "initTracker success");
                        App app2 = dVar.f1038a;
                        if (H5.a.f754a.booleanValue()) {
                            W5.c.f("BootUpHelper", "onBootUpEvent mBootUpEventComplete is true");
                        } else {
                            try {
                                V5.a aVar = new V5.a(app2, "com.stepos.statsapp.v3.common");
                                SharedPreferences sharedPreferences = aVar.f1385a;
                                HashMap map = new HashMap();
                                map.put("daily_actived", String.valueOf(H5.a.a(aVar)));
                                if (sharedPreferences.getBoolean("GLOBAL_ACTIVED", true)) {
                                    sharedPreferences.edit().putBoolean("GLOBAL_ACTIVED", false).commit();
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                map.put("global_actived", String.valueOf(i));
                                d dVar3 = c.f1037a;
                                dVar3.g.f(dVar3.f1038a, "_bootup_", null, map, 0);
                                H5.a.f754a = Boolean.TRUE;
                            } catch (Exception e) {
                                W5.c.b("BootUpHelper", "onBootUpEvent error, " + e);
                            }
                        }
                        if (dVar.h != null) {
                            W5.c.a("SDKInstanceImpl", "cancel retry core init task");
                            dVar.h.cancel(true);
                        }
                        A5.c cVar = dVar.f;
                        cVar.getClass();
                        if (!TextUtils.isEmpty(null)) {
                            if (TextUtils.isEmpty(null)) {
                                ((Q5.a) cVar.c).post(new D6.b(cVar, 7));
                            } else {
                                W5.c.a("SessionController", "source already exist: null, session: " + ((String) cVar.b) + ", not set again");
                            }
                        }
                        v vVar = dVar.g;
                        synchronized (vVar) {
                            if (vVar.f656a.isEmpty()) {
                                W5.c.a("EventController", "fail event data list is empty");
                                return;
                            }
                            R5.d dVar4 = c.f1037a.d;
                            for (int i6 = 0; i6 < vVar.f656a.size(); i6++) {
                                R5.c cVar2 = (R5.c) vVar.f656a.get(i6);
                                dVar4.getClass();
                                I9.d.a(new I4.l(2, dVar4, cVar2));
                            }
                            W5.c.d("EventController", "resend fail event data success, number: " + vVar.f656a.size());
                            vVar.f656a.clear();
                            return;
                        }
                    } catch (Exception e6) {
                        W5.c.b("SDKInstanceImpl", "initTracker error, " + e6);
                        dVar.d = null;
                    }
                }
                if (z10) {
                    W5.c.d("SDKInstanceImpl", "schedule " + dVar.i + " milliseconds retry real init");
                    U5.d dVar5 = U5.c.f1275a;
                    dVar.h = ((ScheduledThreadPoolExecutor) dVar5.b).schedule(new D6.b(dVar, 6), dVar.i, TimeUnit.MILLISECONDS);
                    dVar.i *= 2;
                    return;
                }
                return;
            default:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.d dVar6 = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.d) this.c;
                boolean z11 = this.b;
                Log.d("V3OfflineEmitter", "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
                W5.c.a("V3OfflineEmitter", "addCachedEventsToRemote begin");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                V5.a aVar2 = dVar6.f;
                for (Map.Entry<String, ?> entry : aVar2.f1385a.getAll().entrySet()) {
                    String key = entry.getKey();
                    try {
                        long j5 = Integer.parseInt(key);
                        TrackerPayload trackerPayloadFromString = TrackerPayload.fromString((String) entry.getValue());
                        if (trackerPayloadFromString != null) {
                            if (!z11) {
                                Object obj = trackerPayloadFromString.getHeaderMap().get("time");
                                if (obj instanceof Long) {
                                    long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= TaskTimeouts.TAKEOVER_IDLE_MS) {
                                    }
                                }
                            }
                            arrayList.add(Long.valueOf(j5));
                            arrayList2.add(trackerPayloadFromString);
                        }
                    } catch (Exception e9) {
                        W5.c.b("V3OfflineEmitter", e9.getMessage());
                        aVar2.f1385a.edit().remove(key).apply();
                    }
                }
                EmitterConfig emitterConfig = dVar6.b;
                int i10 = 0;
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    if (i11 != 0 && i11 % 10 == 0) {
                        i10++;
                        int i12 = i11 - 10;
                        e.f3972a.w(dVar6.f3966a, dVar6.h, emitterConfig.getAppId(), emitterConfig.getChannel(), arrayList.subList(i12, i11), arrayList2.subList(i12, i11));
                        W5.c.a("V3OfflineEmitter", "addCachedEventToRemote 1, eventIds:" + Arrays.toString(arrayList.subList(i12, i11).toArray()));
                    }
                }
                int i13 = i10 * 10;
                if (i13 < arrayList.size()) {
                    int size = arrayList.size();
                    e.f3972a.w(dVar6.f3966a, dVar6.h, emitterConfig.getAppId(), emitterConfig.getChannel(), arrayList.subList(i13, size), arrayList2.subList(i13, size));
                    W5.c.a("V3OfflineEmitter", "addCachedEventToRemote 2, eventIds:" + Arrays.toString(arrayList.subList(i13, size).toArray()));
                }
                W5.c.a("V3OfflineEmitter", "addCachedEventsToRemote end");
                return;
        }
    }
}
