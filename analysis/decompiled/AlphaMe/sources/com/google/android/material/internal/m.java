package com.google.android.material.internal;

import K.B0;
import K.P;
import K.S;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.C0284f;
import com.google.android.gms.common.api.internal.s;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import h2.C0589a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import t0.J;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10862a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10863b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10864c;

    public /* synthetic */ m(int i4, Object obj, boolean z4) {
        this.f10862a = i4;
        this.f10864c = obj;
        this.f10863b = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4;
        int i5 = 0;
        switch (this.f10862a) {
            case 0:
                View view = (View) this.f10864c;
                if (this.f10863b) {
                    WeakHashMap weakHashMap = S.f939a;
                    B0 b0C = P.c(view);
                    if (b0C != null) {
                        b0C.f925a.t();
                        return;
                    }
                }
                ((InputMethodManager) androidx.core.content.b.b(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
                return;
            case 1:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.e eVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) this.f10864c;
                eVar.getClass();
                Log.d("V3OfflineEmitter", "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
                T2.d.a("V3OfflineEmitter", "addCachedEventsToRemote begin");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                S2.a aVar = eVar.f12331f;
                for (Map.Entry<String, ?> entry : aVar.f1791a.getAll().entrySet()) {
                    String key = entry.getKey();
                    try {
                        long j4 = Integer.parseInt(key);
                        TrackerPayload trackerPayloadG = TrackerPayload.g((String) entry.getValue());
                        if (trackerPayloadG != null) {
                            if (!this.f10863b) {
                                Object obj = trackerPayloadG.f12343a.get(AppSuggestStorable.COLUMN_TIME);
                                if (obj instanceof Long) {
                                    long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= VehicleBluetoothManager.FAIL_RETRY_TIMEOUT) {
                                    }
                                }
                            }
                            arrayList.add(Long.valueOf(j4));
                            arrayList2.add(trackerPayloadG);
                        }
                    } catch (Exception e4) {
                        T2.d.b("V3OfflineEmitter", e4.getMessage());
                        aVar.f1791a.edit().remove(key).apply();
                    }
                }
                int i6 = 0;
                while (i5 < arrayList.size()) {
                    if (i5 != 0 && i5 % 10 == 0) {
                        i6++;
                        int i7 = i5 - 10;
                        com.stepos.statsapp.v3.lib.plugin.emitter.remote.i iVar = com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.f12334a;
                        Context context = eVar.f12326a;
                        EmitterConfig emitterConfig = eVar.f12327b;
                        iVar.b(context, eVar.f12333h, emitterConfig.f12318j, emitterConfig.f12319k, arrayList.subList(i7, i5), arrayList2.subList(i7, i5));
                        T2.d.a("V3OfflineEmitter", "addCachedEventToRemote 1, eventIds:" + Arrays.toString(arrayList.subList(i7, i5).toArray()));
                    }
                    i5++;
                }
                int i8 = i6 * 10;
                if (i8 < arrayList.size()) {
                    int size = arrayList.size();
                    com.stepos.statsapp.v3.lib.plugin.emitter.remote.i iVar2 = com.stepos.statsapp.v3.lib.plugin.emitter.remote.g.f12334a;
                    Context context2 = eVar.f12326a;
                    EmitterConfig emitterConfig2 = eVar.f12327b;
                    iVar2.b(context2, eVar.f12333h, emitterConfig2.f12318j, emitterConfig2.f12319k, arrayList.subList(i8, size), arrayList2.subList(i8, size));
                    T2.d.a("V3OfflineEmitter", "addCachedEventToRemote 2, eventIds:" + Arrays.toString(arrayList.subList(i8, size).toArray()));
                }
                T2.d.a("V3OfflineEmitter", "addCachedEventsToRemote end");
                return;
            default:
                L2.c cVar = (L2.c) this.f10864c;
                boolean z4 = this.f10863b;
                cVar.getClass();
                T2.d.d("SDKInstanceImpl", "realInit start");
                Application application = cVar.f1232a;
                int i9 = cVar.f1233b;
                String str = cVar.f1234c;
                String str2 = cVar.f1235d;
                if (cVar.f1236e != null) {
                    T2.d.f("SDKInstanceImpl", "initTracker fail, tracker is no null");
                } else {
                    try {
                        T2.d.d("SDKInstanceImpl", "initTracker start");
                        com.stepos.statsapp.v3.lib.plugin.emitter.remote.e eVar2 = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.e(application, str, str2);
                        T2.d.d("Emitter", "buildEmitter emitter is V3OfflineEmitter");
                        P2.c cVarA = P2.c.a(application, str, i9, SdkVer.verName);
                        C0589a c0589a = new C0589a(application, eVar2);
                        c0589a.f12694d = cVarA;
                        c0589a.f12691a = J.x(application);
                        cVar.f1236e = c0589a.a();
                        T2.d.d("SDKInstanceImpl", "initTracker success");
                        Application application2 = cVar.f1232a;
                        if (E2.a.f409a.booleanValue()) {
                            T2.d.f("BootUpHelper", "onBootUpEvent mBootUpEventComplete is true");
                        } else {
                            try {
                                S2.a aVar2 = new S2.a(application2, "com.stepos.statsapp.v3.common");
                                SharedPreferences sharedPreferences = aVar2.f1791a;
                                HashMap map = new HashMap();
                                map.put("daily_actived", String.valueOf(E2.a.a(aVar2)));
                                if (sharedPreferences.getBoolean("GLOBAL_ACTIVED", true)) {
                                    sharedPreferences.edit().putBoolean("GLOBAL_ACTIVED", false).commit();
                                    i4 = 1;
                                } else {
                                    i4 = 0;
                                }
                                map.put("global_actived", String.valueOf(i4));
                                L2.c cVar2 = L2.b.f1231a;
                                cVar2.f1239h.a(cVar2.f1232a, "_bootup_", null, map, 0);
                                E2.a.f409a = Boolean.TRUE;
                            } catch (Exception e5) {
                                T2.d.b("BootUpHelper", "onBootUpEvent error, " + e5);
                            }
                        }
                        if (cVar.f1240i != null) {
                            T2.d.a("SDKInstanceImpl", "cancel retry core init task");
                            cVar.f1240i.cancel(true);
                        }
                        Map map2 = cVar.f1242k;
                        if (map2 != null) {
                            T2.d.a("SDKInstanceImpl", "setEventAttributes attributes: " + map2);
                            ((ThreadPoolExecutor) R2.a.f1659a.f9664b).execute(new androidx.appcompat.app.o(16, cVar, map2));
                        }
                        C0284f c0284f = cVar.f1238g;
                        if (!TextUtils.isEmpty((String) c0284f.f3748e)) {
                            String str3 = (String) c0284f.f3748e;
                            if (TextUtils.isEmpty((String) c0284f.f3745b)) {
                                ((Handler) c0284f.f3746c).post(new androidx.appcompat.app.o(17, c0284f, str3));
                            } else {
                                T2.d.a("SessionController", "source already exist: " + ((String) c0284f.f3745b) + ", session: " + ((String) c0284f.f3744a) + ", not set again");
                            }
                        }
                        stepos.support.v7.app.palette.b bVar = cVar.f1239h;
                        synchronized (bVar) {
                            if (bVar.f14577a.isEmpty()) {
                                T2.d.a("EventController", "fail event data list is empty");
                                return;
                            }
                            s sVar = L2.b.f1231a.f1236e;
                            while (i5 < bVar.f14577a.size()) {
                                O2.b bVar2 = (O2.b) bVar.f14577a.get(i5);
                                sVar.getClass();
                                ((ThreadPoolExecutor) R2.a.f1659a.f9664b).execute(new androidx.appcompat.app.o(18, sVar, bVar2));
                                i5++;
                            }
                            T2.d.d("EventController", "resend fail event data success, number: " + bVar.f14577a.size());
                            bVar.f14577a.clear();
                            return;
                        }
                    } catch (Exception e6) {
                        T2.d.b("SDKInstanceImpl", "initTracker error, " + e6);
                        cVar.f1236e = null;
                    }
                }
                if (z4) {
                    T2.d.d("SDKInstanceImpl", "schedule " + cVar.f1241j + " milliseconds retry real init");
                    E0.b bVar3 = R2.b.f1660a;
                    cVar.f1240i = ((ScheduledThreadPoolExecutor) bVar3.f399b).schedule(new androidx.activity.d(24, cVar), cVar.f1241j, TimeUnit.MILLISECONDS);
                    cVar.f1241j *= 2;
                    return;
                }
                return;
        }
    }
}
