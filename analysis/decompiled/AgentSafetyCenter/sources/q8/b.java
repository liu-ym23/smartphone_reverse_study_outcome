package q8;

import com.stepos.agentsafetycenter.data.local.AppDatabase_Impl;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends a4.f {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppDatabase_Impl f10108d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AppDatabase_Impl appDatabase_Impl) {
        super(2, "fb2ae25360a7ecf0e93e7697a39efb40", "cf5d89eab9a2e3133358b34f3654063a");
        this.f10108d = appDatabase_Impl;
    }

    @Override // a4.f
    public final void a(x4.a aVar) {
        aVar.getClass();
        t0.a.d(aVar, "CREATE TABLE IF NOT EXISTS `dashboard_days` (`day_start_millis` INTEGER NOT NULL, `result_json` TEXT NOT NULL, `ops_count` INTEGER NOT NULL, `risks_count` INTEGER NOT NULL, `synced_at_millis` INTEGER NOT NULL, PRIMARY KEY(`day_start_millis`))");
        t0.a.d(aVar, "CREATE TABLE IF NOT EXISTS `intercept_reads` (`row_key` TEXT NOT NULL, `viewed_at_millis` INTEGER NOT NULL, PRIMARY KEY(`row_key`))");
        t0.a.d(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        t0.a.d(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fb2ae25360a7ecf0e93e7697a39efb40')");
    }

    @Override // a4.f
    public final void b(x4.a aVar) {
        aVar.getClass();
        t0.a.d(aVar, "DROP TABLE IF EXISTS `dashboard_days`");
        t0.a.d(aVar, "DROP TABLE IF EXISTS `intercept_reads`");
    }

    @Override // a4.f
    public final void c(x4.a aVar) {
        aVar.getClass();
    }

    @Override // a4.f
    public final void d(x4.a aVar) {
        aVar.getClass();
        this.f10108d.r(aVar);
    }

    @Override // a4.f
    public final void e(x4.a aVar) {
        aVar.getClass();
    }

    @Override // a4.f
    public final void f(x4.a aVar) {
        aVar.getClass();
        td.h.o(aVar);
    }

    @Override // a4.f
    public final androidx.room.v g(x4.a aVar) {
        aVar.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("day_start_millis", new s4.e("day_start_millis", "INTEGER", true, 1, null, 1));
        linkedHashMap.put("result_json", new s4.e("result_json", "TEXT", true, 0, null, 1));
        linkedHashMap.put("ops_count", new s4.e("ops_count", "INTEGER", true, 0, null, 1));
        linkedHashMap.put("risks_count", new s4.e("risks_count", "INTEGER", true, 0, null, 1));
        linkedHashMap.put("synced_at_millis", new s4.e("synced_at_millis", "INTEGER", true, 0, null, 1));
        s4.h hVar = new s4.h("dashboard_days", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
        s4.h hVarE = id.c.E(aVar, "dashboard_days");
        if (!hVar.equals(hVarE)) {
            return new androidx.room.v("dashboard_days(com.stepos.agentsafetycenter.data.local.DashboardDayEntity).\n Expected:\n" + hVar + "\n Found:\n" + hVarE, false);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("row_key", new s4.e("row_key", "TEXT", true, 1, null, 1));
        linkedHashMap2.put("viewed_at_millis", new s4.e("viewed_at_millis", "INTEGER", true, 0, null, 1));
        s4.h hVar2 = new s4.h("intercept_reads", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
        s4.h hVarE2 = id.c.E(aVar, "intercept_reads");
        if (hVar2.equals(hVarE2)) {
            return new androidx.room.v(null, true);
        }
        return new androidx.room.v("intercept_reads(com.stepos.agentsafetycenter.data.local.InterceptReadEntity).\n Expected:\n" + hVar2 + "\n Found:\n" + hVarE2, false);
    }
}
