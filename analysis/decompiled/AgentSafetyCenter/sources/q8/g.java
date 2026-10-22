package q8;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10118a;

    public static final androidx.room.r b(Context context, Class cls, String str) {
        if (hc.h.g0(str)) {
            g5.f.s("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
            return null;
        }
        if (!str.equals(":memory:")) {
            return new androidx.room.r(context, cls, str);
        }
        g5.f.s("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        return null;
    }

    public static final Object c(androidx.room.m mVar, String str, pb.c cVar) {
        Object objD = mVar.d(str, new a9.d(12), cVar);
        return objD == ob.a.f9351c ? objD : jb.v.f6774a;
    }

    public final void a(x4.c cVar, Object obj) {
        switch (this.f10118a) {
            case 0:
                i iVar = (i) obj;
                cVar.getClass();
                cVar.c(1, iVar.f10121a);
                cVar.p(2, iVar.f10122b);
                cVar.c(3, iVar.f10123c);
                cVar.c(4, iVar.f10124d);
                cVar.c(5, iVar.f10125e);
                break;
            default:
                w wVar = (w) obj;
                cVar.getClass();
                cVar.p(1, wVar.f10192a);
                cVar.c(2, wVar.f10193b);
                break;
        }
    }

    public void d(x4.a aVar, Object obj) {
        String str;
        aVar.getClass();
        switch (this.f10118a) {
            case 0:
                str = "INSERT OR REPLACE INTO `dashboard_days` (`day_start_millis`,`result_json`,`ops_count`,`risks_count`,`synced_at_millis`) VALUES (?,?,?,?,?)";
                break;
            default:
                str = "INSERT OR REPLACE INTO `intercept_reads` (`row_key`,`viewed_at_millis`) VALUES (?,?)";
                break;
        }
        x4.c cVarK = aVar.K(str);
        try {
            a(cVarK, obj);
            cVarK.G();
            t2.a.h(cVarK, null);
        } finally {
        }
    }
}
