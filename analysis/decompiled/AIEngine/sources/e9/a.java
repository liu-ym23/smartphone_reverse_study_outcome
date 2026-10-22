package e9;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.appcompat.app.l;
import androidx.appcompat.widget.z0;
import com.stepos.core.ota.dump.KeyAttestDumpCommand;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import la.c;
import oa.b;
import ra.a;
import ra.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8620a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8621b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8622c;

    public /* synthetic */ a(boolean z, int i10, Object obj) {
        this.f8620a = i10;
        this.f8622c = obj;
        this.f8621b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        switch (this.f8620a) {
            case 0:
                KeyAttestDumpCommand.handle$lambda$3((PrintWriter) this.f8622c, this.f8621b);
                return;
            default:
                c cVar = (c) this.f8622c;
                boolean z = this.f8621b;
                ta.c.d("SDKInstanceImpl", "realInit start");
                Application application = cVar.f10383a;
                String str = cVar.f10384b;
                String str2 = cVar.f10385c;
                if (cVar.f10386d != null) {
                    ta.c.f("SDKInstanceImpl", "initTracker fail, tracker is no null");
                } else {
                    try {
                        ta.c.d("SDKInstanceImpl", "initTracker start");
                        V3OfflineEmitter v3OfflineEmitter = new V3OfflineEmitter(application, str, str2);
                        ta.c.d("Emitter", "buildEmitter emitter is V3OfflineEmitter");
                        pa.c cVarB = pa.c.b(application, str, SdkVer.verName);
                        b.a aVar = new b.a(application, v3OfflineEmitter);
                        aVar.f10847c = cVarB;
                        aVar.f10848d = jd.b.A(application);
                        cVar.f10386d = aVar.a();
                        ta.c.d("SDKInstanceImpl", "initTracker success");
                        Application application2 = cVar.f10383a;
                        if (fa.a.f8778a.booleanValue()) {
                            ta.c.f("BootUpHelper", "onBootUpEvent mBootUpEventComplete is true");
                        } else {
                            try {
                                sa.a aVar2 = new sa.a(application2, "com.stepos.statsapp.v3.common");
                                SharedPreferences sharedPreferences = aVar2.f11898a;
                                HashMap map = new HashMap();
                                map.put("daily_actived", String.valueOf(fa.a.a(aVar2)));
                                if (sharedPreferences.getBoolean("GLOBAL_ACTIVED", true)) {
                                    sharedPreferences.edit().putBoolean("GLOBAL_ACTIVED", false).commit();
                                    i10 = 1;
                                } else {
                                    i10 = 0;
                                }
                                map.put("global_actived", String.valueOf(i10));
                                c cVar2 = c.a.f10391a;
                                cVar2.f10389g.a(cVar2.f10383a, "_bootup_", null, map, 0);
                                fa.a.f8778a = Boolean.TRUE;
                            } catch (Exception e10) {
                                ta.c.b("BootUpHelper", "onBootUpEvent error, " + e10);
                            }
                        }
                        if (cVar.h != null) {
                            ta.c.a("SDKInstanceImpl", "cancel retry core init task");
                            cVar.h.cancel(true);
                        }
                        na.b bVar = cVar.f10388f;
                        bVar.getClass();
                        if (!TextUtils.isEmpty(null)) {
                            if (TextUtils.isEmpty(null)) {
                                bVar.f10700b.post(new z0(bVar, 20));
                            } else {
                                ta.c.a("SessionController", "source already exist: null, session: " + bVar.f10699a + ", not set again");
                            }
                        }
                        ha.c cVar3 = cVar.f10389g;
                        synchronized (cVar3) {
                            if (cVar3.f9380a.isEmpty()) {
                                ta.c.a("EventController", "fail event data list is empty");
                                return;
                            }
                            b bVar2 = c.a.f10391a.f10386d;
                            for (int i11 = 0; i11 < cVar3.f9380a.size(); i11++) {
                                b.C0119b c0119b = (b.C0119b) cVar3.f9380a.get(i11);
                                bVar2.getClass();
                                a.C0133a.f11759a.f11758a.execute(new l(19, bVar2, c0119b));
                            }
                            ta.c.d("EventController", "resend fail event data success, number: " + cVar3.f9380a.size());
                            cVar3.f9380a.clear();
                            return;
                        }
                    } catch (Exception e11) {
                        ta.c.b("SDKInstanceImpl", "initTracker error, " + e11);
                        cVar.f10386d = null;
                    }
                }
                if (z) {
                    ta.c.d("SDKInstanceImpl", "schedule " + cVar.f10390i + " milliseconds retry real init");
                    ra.b bVar3 = b.C0134b.f11762a;
                    cVar.h = bVar3.f11760a.schedule(new z0(cVar, 18), cVar.f10390i, TimeUnit.MILLISECONDS);
                    cVar.f10390i *= 2;
                    return;
                }
                return;
        }
    }
}
