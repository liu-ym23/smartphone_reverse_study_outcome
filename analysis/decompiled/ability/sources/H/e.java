package H;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.statsrpk.RpkUsageStats;
import java.util.Map;
import k2.C1621a;
import org.json.JSONObject;
import z2.l;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f709a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e(Object obj, String str, String str2, Object obj2, int i) {
        this.f709a = i;
        this.e = obj;
        this.b = str;
        this.c = str2;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jInsertWithOnConflict;
        long jQueryNumEntries;
        switch (this.f709a) {
            case 0:
                O.a.g().c(new P.c(this.b, 0, null, (JSONObject) this.c, (JSONObject) this.d, (JSONObject) this.e));
                return;
            case 1:
                RpkUsageStats rpkUsageStats = (RpkUsageStats) this.e;
                if (rpkUsageStats.mRpkInstance != null) {
                    com.stepos.statsrpk.e eVar = rpkUsageStats.mRpkInstance;
                    String str = this.b;
                    String str2 = (String) this.c;
                    Map map = (Map) this.d;
                    eVar.getClass();
                    W5.c.a("RpkInstanceImpl", "onEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
                    u1.d dVar = eVar.b;
                    if (dVar == null || TextUtils.isEmpty(str) || !((V5.a) dVar.d).f1385a.getBoolean("active", true) || dVar.g(str) == 0) {
                        return;
                    }
                    RpkEvent rpkEvent = new RpkEvent();
                    rpkEvent.f3975a = "action_x";
                    rpkEvent.b = str;
                    rpkEvent.c = str2;
                    rpkEvent.d = map;
                    rpkEvent.e = ((com.stepos.statsrpk.e) dVar.e).c.E();
                    ((C1621a) dVar.b).c(rpkEvent, (RpkInfo) dVar.c);
                    return;
                }
                return;
            default:
                com.stepos.statsrpk.service.e eVar2 = (com.stepos.statsrpk.service.e) this.e;
                String str3 = this.b;
                String str4 = (String) this.c;
                TrackerPayload trackerPayload = (TrackerPayload) this.d;
                if (str3 != null) {
                    W5.c.a("a", "Queuing event for sending later, appKey:" + str3 + ", payload:" + trackerPayload);
                    eVar2.b.c();
                    Y5.a aVar = eVar2.b;
                    synchronized (aVar) {
                        try {
                            if (aVar.e()) {
                                try {
                                    com.stepos.statsapp.v3.lib.plugin.emitter.d dVarA = com.stepos.statsapp.v3.lib.plugin.emitter.d.a(l.A(aVar.b) ? 0 : 2, trackerPayload);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("appKey", str3);
                                    contentValues.put("rpkPkgName", str4);
                                    contentValues.put("eventSessionId", dVarA.c);
                                    contentValues.put("encrypt", Integer.valueOf(dVarA.b));
                                    contentValues.put("eventData", dVarA.e);
                                    jInsertWithOnConflict = aVar.f1563a.insertWithOnConflict("events", null, contentValues, 5);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            } else {
                                jInsertWithOnConflict = -1;
                            }
                            W5.c.a("a", "succ add event, inserted:" + jInsertWithOnConflict);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (jInsertWithOnConflict > 0) {
                        Y5.a aVar2 = eVar2.b;
                        synchronized (aVar2) {
                            String str5 = "appKey='" + str3 + "'";
                            synchronized (aVar2) {
                                jQueryNumEntries = DatabaseUtils.queryNumEntries(aVar2.f1563a, "events", str5);
                            }
                            boolean zF = T5.b.f(eVar2.f3986a);
                            W5.c.a("a", "cacheCheck appKey:" + str3 + " ------------------ eventSize:" + jQueryNumEntries + ", flushCacheLimit:5, networkAvailable:" + zF);
                            if (jQueryNumEntries >= 5 || !zF) {
                                return;
                            }
                            eVar2.b(str3, eVar2.b.a(str3));
                            return;
                        }
                        boolean zF2 = T5.b.f(eVar2.f3986a);
                        W5.c.a("a", "cacheCheck appKey:" + str3 + " ------------------ eventSize:" + jQueryNumEntries + ", flushCacheLimit:5, networkAvailable:" + zF2);
                        if (jQueryNumEntries >= 5) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
        }
    }

    public e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.f709a = 0;
        this.b = str;
        this.c = jSONObject;
        this.d = jSONObject2;
        this.e = jSONObject3;
    }
}
