package com.stepos.statsrpk;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;
import l.l;
import l.n;
import p5.u;
import t.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2852c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2853f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2854g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f2855h;
    public /* synthetic */ Object i;

    public /* synthetic */ c(int i) {
        this.f2852c = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long jInsertWithOnConflict;
        long jQueryNumEntries;
        switch (this.f2852c) {
            case 0:
                RpkUsageStats rpkUsageStats = (RpkUsageStats) this.i;
                if (rpkUsageStats.mRpkInstance != null) {
                    i iVar = rpkUsageStats.mRpkInstance;
                    String str = (String) this.f2853f;
                    String str2 = (String) this.f2854g;
                    Map map = (Map) this.f2855h;
                    iVar.getClass();
                    ua.c.a("RpkInstanceImpl", "onEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
                    p5.i iVar2 = iVar.f2871b;
                    if (iVar2 == null || TextUtils.isEmpty(str) || !((ta.a) iVar2.f9732g).f13291a.getBoolean("active", true) || iVar2.c(str) == 0) {
                        return;
                    }
                    a aVar = new a();
                    aVar.f2844c = "action_x";
                    aVar.f2845f = str;
                    aVar.f2846g = str2;
                    aVar.f2847h = map;
                    aVar.i = ((i) iVar2.f9733h).f2872c.i();
                    ((u) iVar2.f9730c).c(aVar, (b) iVar2.f9731f);
                    return;
                }
                return;
            case 1:
                com.stepos.statsrpk.service.e eVar = (com.stepos.statsrpk.service.e) this.i;
                String str3 = (String) this.f2853f;
                String str4 = (String) this.f2854g;
                TrackerPayload trackerPayload = (TrackerPayload) this.f2855h;
                if (str3 != null) {
                    ua.c.a("a", "Queuing event for sending later, appKey:" + str3 + ", payload:" + trackerPayload);
                    eVar.f2888b.g();
                    n6.a aVar2 = eVar.f2888b;
                    synchronized (aVar2) {
                        try {
                            if (aVar2.j()) {
                                try {
                                    ga.c cVarA = ga.c.a(o.j((Context) aVar2.f8777f) ? 0 : 2, trackerPayload);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("appKey", str3);
                                    contentValues.put("rpkPkgName", str4);
                                    contentValues.put("eventSessionId", cVarA.f4672c);
                                    contentValues.put("encrypt", Integer.valueOf(cVarA.f4671b));
                                    contentValues.put("eventData", cVarA.f4674e);
                                    jInsertWithOnConflict = ((SQLiteDatabase) aVar2.f8776c).insertWithOnConflict("events", null, contentValues, 5);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            } else {
                                jInsertWithOnConflict = -1;
                            }
                            ua.c.a("a", "succ add event, inserted:" + jInsertWithOnConflict);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (jInsertWithOnConflict > 0) {
                        n6.a aVar3 = eVar.f2888b;
                        synchronized (aVar3) {
                            String str5 = "appKey='" + str3 + "'";
                            synchronized (aVar3) {
                                jQueryNumEntries = DatabaseUtils.queryNumEntries((SQLiteDatabase) aVar3.f8776c, "events", str5);
                            }
                            boolean zF = ra.b.f(eVar.f2887a);
                            ua.c.a("a", "cacheCheck appKey:" + str3 + " ------------------ eventSize:" + jQueryNumEntries + ", flushCacheLimit:5, networkAvailable:" + zF);
                            if (jQueryNumEntries >= 5 || !zF) {
                                return;
                            }
                            eVar.b(str3, eVar.f2888b.c(str3));
                            return;
                        }
                        boolean zF2 = ra.b.f(eVar.f2887a);
                        ua.c.a("a", "cacheCheck appKey:" + str3 + " ------------------ eventSize:" + jQueryNumEntries + ", flushCacheLimit:5, networkAvailable:" + zF2);
                        if (jQueryNumEntries >= 5) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                l.f fVar = (l.f) ((a1.g) this.i).f19f;
                n nVar = (n) this.f2854g;
                l.e eVar2 = (l.e) this.f2853f;
                if (eVar2 != null) {
                    fVar.D = true;
                    eVar2.f7546b.c(false);
                    fVar.D = false;
                }
                if (nVar.isEnabled() && nVar.hasSubMenu()) {
                    ((l) this.f2855h).q(nVar, null, 4);
                    return;
                }
                return;
        }
    }
}
