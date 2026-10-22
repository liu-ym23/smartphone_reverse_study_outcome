package androidx.room;

import b8.w0;
import b8.x0;
import com.fasterxml.jackson.databind.JsonNode;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1598a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1599b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1600c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1601d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1602e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1603f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1604g;

    public q(y7.a aVar, w7.o oVar, ConcurrentMap concurrentMap, ConcurrentMap concurrentMap2, ConcurrentMap concurrentMap3) {
        if (aVar == null) {
            g5.f.s("Dialect must not be null");
            throw null;
        }
        HashMap map = aVar.f15931c;
        if (oVar == null) {
            g5.f.s("SchemaRegistry must not be null");
            throw null;
        }
        this.f1600c = aVar;
        this.f1601d = oVar;
        this.f1602e = concurrentMap;
        this.f1603f = concurrentMap2;
        this.f1604g = concurrentMap3;
        if (map.containsKey("discriminator")) {
            this.f1598a = true;
        } else {
            this.f1598a = false;
        }
        if (map.containsKey("nullable")) {
            this.f1599b = true;
        } else {
            this.f1599b = false;
        }
    }

    public static final void a(q qVar, x4.a aVar) throws Throwable {
        Object objL;
        a4.f fVar = (a4.f) qVar.f1601d;
        a aVar2 = (a) qVar.f1600c;
        s sVar = aVar2.f1490g;
        s sVar2 = s.f1624g;
        if (sVar == sVar2) {
            t0.a.d(aVar, "PRAGMA journal_mode = WAL");
        } else {
            t0.a.d(aVar, "PRAGMA journal_mode = TRUNCATE");
        }
        if (aVar2.f1490g == sVar2) {
            t0.a.d(aVar, "PRAGMA synchronous = NORMAL");
        } else {
            t0.a.d(aVar, "PRAGMA synchronous = FULL");
        }
        b(aVar);
        x4.c cVarK = aVar.K("PRAGMA user_version");
        try {
            cVarK.G();
            int i = (int) cVarK.getLong(0);
            t2.a.h(cVarK, null);
            int i3 = fVar.f167a;
            if (i != i3) {
                t0.a.d(aVar, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        qVar.f(aVar);
                    } else {
                        qVar.g(aVar, i, i3);
                    }
                    t0.a.d(aVar, "PRAGMA user_version = " + i3);
                    objL = jb.v.f6774a;
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                if (!(objL instanceof jb.h)) {
                    t0.a.d(aVar, "END TRANSACTION");
                }
                Throwable thB = jb.i.b(objL);
                if (thB != null) {
                    t0.a.d(aVar, "ROLLBACK TRANSACTION");
                    throw thB;
                }
            }
            qVar.h(aVar);
        } finally {
        }
    }

    public static void b(x4.a aVar) {
        x4.c cVarK = aVar.K("PRAGMA busy_timeout");
        try {
            cVarK.G();
            long j10 = cVarK.getLong(0);
            t2.a.h(cVarK, null);
            if (j10 < 3000) {
                t0.a.d(aVar, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                t2.a.h(cVarK, th);
                throw th2;
            }
        }
    }

    public y4.c c() {
        o4.b bVar = (o4.b) this.f1603f;
        p4.b bVar2 = bVar instanceof p4.b ? (p4.b) bVar : null;
        if (bVar2 != null) {
            return (y4.c) bVar2.f9698c.f19f;
        }
        return null;
    }

    public w7.l d(w7.n nVar, JsonNode jsonNode, w7.l lVar) {
        return ((w7.o) this.f1601d).a(this, nVar, jsonNode, lVar, false);
    }

    public b8.a e(w7.n nVar, String str, JsonNode jsonNode, w7.l lVar) {
        y7.a aVar = (y7.a) this.f1600c;
        aVar.getClass();
        rd.b bVar = y7.a.f15928g;
        try {
            b8.x xVar = (b8.x) aVar.f15931c.get(str);
            if (xVar == null) {
                ((w7.o) this.f1601d).f15349g.getClass();
                if (!str.equals(null) && (!this.f1599b || !"nullable".equals(str))) {
                    b8.b0 b0Var = b8.b0.f1929r;
                    if (b0Var.f1938c.equals(str) && this.f1598a) {
                        return b0Var.a(nVar, jsonNode, lVar, this);
                    }
                    aVar.f15934f.getClass();
                    rd.b bVar2 = x0.f2037b;
                    b8.x xVar2 = (b8.x) w0.f2036a.f2038a.computeIfAbsent(str, new a8.b(6));
                    if (xVar2 != null) {
                        xVar = xVar2;
                    }
                }
                return null;
            }
            return xVar.a(nVar, jsonNode, lVar, this);
        } catch (InvocationTargetException e10) {
            if (e10.getTargetException() instanceof w7.m) {
                bVar.error("Error:", e10);
                throw ((w7.m) e10.getTargetException());
            }
            bVar.b(str, "Could not load validator {}");
            throw new w7.m(e10.getTargetException());
        } catch (w7.m e11) {
            throw e11;
        } catch (Exception e12) {
            bVar.b(str, "Could not load validator {}");
            throw new w7.m(e12);
        }
    }

    public void f(x4.a aVar) {
        a4.f fVar = (a4.f) this.f1601d;
        aVar.getClass();
        x4.c cVarK = aVar.K("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (cVarK.G()) {
                if (cVarK.getLong(0) == 0) {
                    z10 = true;
                }
            }
            t2.a.h(cVarK, null);
            fVar.a(aVar);
            if (!z10) {
                v vVarG = fVar.g(aVar);
                if (!vVarG.f1638a) {
                    ad.o.m(vVarG.f1639b, "Pre-packaged database has an invalid schema: ");
                    return;
                }
            }
            t0.a.d(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            t0.a.d(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) fVar.f168b) + "')");
            fVar.c(aVar);
            Iterator it = ((List) this.f1602e).iterator();
            while (it.hasNext()) {
                ((p) it.next()).getClass();
                if (aVar instanceof p4.a) {
                    ((p4.a) aVar).f9697c.getClass();
                }
            }
        } finally {
        }
    }

    public void g(x4.a aVar, int i, int i3) {
        a4.f fVar = (a4.f) this.f1601d;
        aVar.getClass();
        a aVar2 = (a) this.f1600c;
        List<q4.a> listQ = a.a.q(aVar2.f1487d, i, i3);
        if (listQ != null) {
            fVar.f(aVar);
            for (q4.a aVar3 : listQ) {
                aVar3.getClass();
                if (!(aVar instanceof p4.a)) {
                    throw new jb.f("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
                }
                aVar3.a(((p4.a) aVar).f9697c);
            }
            v vVarG = fVar.g(aVar);
            if (!vVarG.f1638a) {
                ad.o.m(vVarG.f1639b, "Migration didn't properly handle: ");
                return;
            }
            fVar.e(aVar);
            t0.a.d(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            t0.a.d(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) fVar.f168b) + "')");
            return;
        }
        if (a.a.M(aVar2, i, i3)) {
            throw new IllegalStateException(("A migration from " + i + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
        if (aVar2.f1501s) {
            x4.c cVarK = aVar.K("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                lb.c cVarO = ac.a.o();
                while (cVarK.G()) {
                    String strZ = cVarK.z(0);
                    if (!hc.o.U(strZ, "sqlite_", false) && !strZ.equals("android_metadata")) {
                        cVarO.add(new jb.g(strZ, Boolean.valueOf(yb.k.a(cVarK.z(1), "view"))));
                    }
                }
                lb.c cVarK2 = ac.a.k(cVarO);
                t2.a.h(cVarK, null);
                ListIterator listIterator = cVarK2.listIterator(0);
                while (true) {
                    lb.a aVar4 = (lb.a) listIterator;
                    if (!aVar4.hasNext()) {
                        break;
                    }
                    jb.g gVar = (jb.g) aVar4.next();
                    String str = (String) gVar.f6759c;
                    if (((Boolean) gVar.f6760f).booleanValue()) {
                        t0.a.d(aVar, "DROP VIEW IF EXISTS " + str);
                    } else {
                        t0.a.d(aVar, "DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            fVar.b(aVar);
        }
        Iterator it = ((List) this.f1602e).iterator();
        while (it.hasNext()) {
            ((p) it.next()).getClass();
            if (aVar instanceof p4.a) {
                ((p4.a) aVar).f9697c.getClass();
            }
        }
        fVar.a(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(x4.a r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.q.h(x4.a):void");
    }

    public q(y7.a aVar, w7.o oVar) {
        this(aVar, oVar, new ConcurrentHashMap(), new ConcurrentHashMap(), new ConcurrentHashMap());
    }
}
