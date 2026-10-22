package l2;

import android.database.Cursor;
import com.stepos.familyguard.db.entity.StatsDataSetCache;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x3.q;

/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f18263a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f18264b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f18265c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f18266d;

    class a extends Z.d<StatsDataSetCache> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `StatsDataSetCache`(`id`,`relationId`,`data`) VALUES (nullif(?, 0),?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, StatsDataSetCache statsDataSetCache) {
            interfaceC0651f.z(1, statsDataSetCache.getId());
            interfaceC0651f.z(2, statsDataSetCache.getRelationId());
            if (statsDataSetCache.getData() == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.l(3, statsDataSetCache.getData());
            }
        }
    }

    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM StatsDataSetCache WHERE relationId = (?)";
        }
    }

    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM StatsDataSetCache WHERE id = (?)";
        }
    }

    class d implements Callable<List<StatsDataSetCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f18270a;

        d(Z.j jVar) {
            this.f18270a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<StatsDataSetCache> call() {
            Cursor cursorP = o.this.f18263a.p(this.f18270a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("data");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    StatsDataSetCache statsDataSetCache = new StatsDataSetCache(cursorP.getLong(columnIndexOrThrow2), cursorP.getString(columnIndexOrThrow3));
                    statsDataSetCache.setId(cursorP.getLong(columnIndexOrThrow));
                    arrayList.add(statsDataSetCache);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f18270a.r();
        }
    }

    public o(Z.g gVar) {
        this.f18263a = gVar;
        this.f18264b = new a(gVar);
        this.f18265c = new b(gVar);
        this.f18266d = new c(gVar);
    }

    @Override // l2.n
    public q<List<StatsDataSetCache>> b(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM StatsDataSetCache WHERE relationId = (?)", 1);
        jVarF.z(1, j5);
        return q.h(new d(jVarF));
    }
}
