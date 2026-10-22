package q8;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ long f10112c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long f10113f;

    @Override // xb.l
    public final Object invoke(Object obj) throws Exception {
        long j10 = this.f10112c;
        long j11 = this.f10113f;
        x4.a aVar = (x4.a) obj;
        aVar.getClass();
        x4.c cVarK = aVar.K("\n        SELECT * FROM dashboard_days\n        WHERE day_start_millis >= ? AND day_start_millis <= ?\n        ORDER BY day_start_millis ASC\n        ");
        try {
            cVarK.c(1, j10);
            cVarK.c(2, j11);
            int iP = com.stepos.statsrpk.h.p(cVarK, "day_start_millis");
            int iP2 = com.stepos.statsrpk.h.p(cVarK, "result_json");
            int iP3 = com.stepos.statsrpk.h.p(cVarK, "ops_count");
            int iP4 = com.stepos.statsrpk.h.p(cVarK, "risks_count");
            int iP5 = com.stepos.statsrpk.h.p(cVarK, "synced_at_millis");
            ArrayList arrayList = new ArrayList();
            while (cVarK.G()) {
                arrayList.add(new i(cVarK.getLong(iP), cVarK.z(iP2), (int) cVarK.getLong(iP3), (int) cVarK.getLong(iP4), cVarK.getLong(iP5)));
            }
            return arrayList;
        } finally {
            cVarK.close();
        }
    }
}
