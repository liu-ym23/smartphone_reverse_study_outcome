package com.stepos.statsrpk.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.core.ota.d;
import com.stepos.statsapp.v3.lib.plugin.emitter.e;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8098a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8099b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TrackerPayload f8100c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f8101d;

    public b(c cVar, String str, String str2, TrackerPayload trackerPayload) {
        this.f8101d = cVar;
        this.f8098a = str;
        this.f8099b = str2;
        this.f8100c = trackerPayload;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long jInsertWithOnConflict;
        long jQueryNumEntries;
        c cVar = this.f8101d;
        String str = this.f8098a;
        String str2 = this.f8099b;
        TrackerPayload trackerPayload = this.f8100c;
        if (str != null) {
            ta.c.a("a", "Queuing event for sending later, appKey:" + str + ", payload:" + trackerPayload);
            cVar.f8102b.f();
            androidx.preference.c cVar2 = cVar.f8102b;
            synchronized (cVar2) {
                try {
                    if (cVar2.i()) {
                        try {
                            e eVarA = e.a(jd.b.A((Context) cVar2.f2401b) ? 0 : 2, trackerPayload);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", str);
                            contentValues.put("rpkPkgName", str2);
                            contentValues.put("eventSessionId", eVarA.f8013c);
                            contentValues.put("encrypt", Integer.valueOf(eVarA.f8012b));
                            contentValues.put("eventData", eVarA.f8015e);
                            jInsertWithOnConflict = ((SQLiteDatabase) cVar2.f2400a).insertWithOnConflict("events", null, contentValues, 5);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        jInsertWithOnConflict = -1;
                    }
                    ta.c.a("a", "succ add event, inserted:" + jInsertWithOnConflict);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (jInsertWithOnConflict > 0) {
                androidx.preference.c cVar3 = cVar.f8102b;
                synchronized (cVar3) {
                    String str3 = "appKey='" + str + "'";
                    synchronized (cVar3) {
                        jQueryNumEntries = DatabaseUtils.queryNumEntries((SQLiteDatabase) cVar3.f2400a, "events", str3);
                    }
                    boolean zA = qa.c.a(cVar.f8010a);
                    StringBuilder sbL = d.l("cacheCheck appKey:", jQueryNumEntries, str, " ------------------ eventSize:");
                    sbL.append(", flushCacheLimit:5, networkAvailable:");
                    sbL.append(zA);
                    ta.c.a("a", sbL.toString());
                    if (jQueryNumEntries >= 5 || !zA) {
                    }
                    cVar.c(str, cVar.f8102b.d(str));
                    return;
                }
                boolean zA2 = qa.c.a(cVar.f8010a);
                StringBuilder sbL2 = d.l("cacheCheck appKey:", jQueryNumEntries, str, " ------------------ eventSize:");
                sbL2.append(", flushCacheLimit:5, networkAvailable:");
                sbL2.append(zA2);
                ta.c.a("a", sbL2.toString());
                if (jQueryNumEntries >= 5) {
                }
            }
        }
    }
}
