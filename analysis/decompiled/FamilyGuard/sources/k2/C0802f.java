package k2;

import android.database.Cursor;
import com.stepos.familyguard.db.entity.CategoryLimitCache;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x3.q;

/* renamed from: k2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0802f implements InterfaceC0801e {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17861a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17862b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17863c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f17864d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f17865e;

    /* renamed from: k2.f$a */
    class a extends Z.d<CategoryLimitCache> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `CategoryLimitCache`(`categoryLimitId`,`categoryId`,`workdayLimit`,`offDayLimit`,`enable`,`notifyOnly`,`state`,`interval`,`lastHandleTime`,`relationId`,`version`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, CategoryLimitCache categoryLimitCache) {
            interfaceC0651f.z(1, categoryLimitCache.getCategoryLimitId());
            interfaceC0651f.z(2, categoryLimitCache.getCategoryId());
            interfaceC0651f.z(3, categoryLimitCache.getWorkdayLimit());
            interfaceC0651f.z(4, categoryLimitCache.getOffDayLimit());
            interfaceC0651f.z(5, categoryLimitCache.isEnable() ? 1L : 0L);
            interfaceC0651f.z(6, categoryLimitCache.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(7, categoryLimitCache.getState());
            interfaceC0651f.z(8, categoryLimitCache.getInterval());
            interfaceC0651f.z(9, categoryLimitCache.getLastHandleTime());
            interfaceC0651f.z(10, categoryLimitCache.getRelationId());
            interfaceC0651f.z(11, categoryLimitCache.getVersion());
        }
    }

    /* renamed from: k2.f$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM categorylimitcache WHERE relationId =?";
        }
    }

    /* renamed from: k2.f$c */
    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM categorylimitcache WHERE relationId =? AND categoryId = (?)";
        }
    }

    /* renamed from: k2.f$d */
    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM categorylimitcache";
        }
    }

    /* renamed from: k2.f$e */
    class e implements Callable<List<CategoryLimitCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17870a;

        e(Z.j jVar) {
            this.f17870a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<CategoryLimitCache> call() {
            Cursor cursorP = C0802f.this.f17861a.p(this.f17870a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("categoryLimitId");
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("version");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    long j5 = cursorP.getLong(columnIndexOrThrow);
                    arrayList.add(new CategoryLimitCache(cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getInt(columnIndexOrThrow5) != 0, cursorP.getInt(columnIndexOrThrow6) != 0, cursorP.getInt(columnIndexOrThrow7), cursorP.getLong(columnIndexOrThrow9), j5, cursorP.getLong(columnIndexOrThrow10), cursorP.getLong(columnIndexOrThrow11)));
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17870a.r();
        }
    }

    /* renamed from: k2.f$f, reason: collision with other inner class name */
    class CallableC0220f implements Callable<CategoryLimitCache> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17872a;

        CallableC0220f(Z.j jVar) {
            this.f17872a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CategoryLimitCache call() {
            CategoryLimitCache categoryLimitCache;
            Cursor cursorP = C0802f.this.f17861a.p(this.f17872a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("categoryLimitId");
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("version");
                if (cursorP.moveToFirst()) {
                    categoryLimitCache = new CategoryLimitCache(cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getInt(columnIndexOrThrow5) != 0, cursorP.getInt(columnIndexOrThrow6) != 0, cursorP.getInt(columnIndexOrThrow7), cursorP.getLong(columnIndexOrThrow9), cursorP.getLong(columnIndexOrThrow), cursorP.getLong(columnIndexOrThrow10), cursorP.getLong(columnIndexOrThrow11));
                } else {
                    categoryLimitCache = null;
                }
                if (categoryLimitCache != null) {
                    return categoryLimitCache;
                }
                throw new Z.b("Query returned empty result set: " + this.f17872a.c());
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17872a.r();
        }
    }

    public C0802f(Z.g gVar) {
        this.f17861a = gVar;
        this.f17862b = new a(gVar);
        this.f17863c = new b(gVar);
        this.f17864d = new c(gVar);
        this.f17865e = new d(gVar);
    }

    @Override // k2.InterfaceC0801e
    public q<List<CategoryLimitCache>> a(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM categorylimitcache where interval = (?) AND relationId = (?)", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        return q.h(new e(jVarF));
    }

    @Override // k2.InterfaceC0801e
    public int b() {
        InterfaceC0651f interfaceC0651fA = this.f17865e.a();
        this.f17861a.b();
        try {
            int iN = interfaceC0651fA.n();
            this.f17861a.s();
            return iN;
        } finally {
            this.f17861a.f();
            this.f17865e.f(interfaceC0651fA);
        }
    }

    @Override // k2.InterfaceC0801e
    public int c(long j5, int i5) {
        InterfaceC0651f interfaceC0651fA = this.f17864d.a();
        this.f17861a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.z(2, i5);
            int iN = interfaceC0651fA.n();
            this.f17861a.s();
            return iN;
        } finally {
            this.f17861a.f();
            this.f17864d.f(interfaceC0651fA);
        }
    }

    @Override // k2.InterfaceC0801e
    public q<CategoryLimitCache> d(int i5, long j5, long j6) {
        Z.j jVarF = Z.j.f("SELECT * FROM categorylimitcache WHERE interval = (?) AND categoryId = (?) AND relationId = (?)", 3);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        jVarF.z(3, j6);
        return q.h(new CallableC0220f(jVarF));
    }

    @Override // k2.InterfaceC0801e
    public long e(CategoryLimitCache categoryLimitCache) {
        this.f17861a.b();
        try {
            long j5 = this.f17862b.j(categoryLimitCache);
            this.f17861a.s();
            return j5;
        } finally {
            this.f17861a.f();
        }
    }

    @Override // k2.InterfaceC0801e
    public CategoryLimitCache f(int i5, long j5, long j6) {
        CategoryLimitCache categoryLimitCache;
        Z.j jVarF = Z.j.f("SELECT * FROM categorylimitcache WHERE interval = (?) AND categoryId = (?) AND relationId = (?)", 3);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        jVarF.z(3, j6);
        Cursor cursorP = this.f17861a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("categoryLimitId");
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("relationId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("version");
            if (cursorP.moveToFirst()) {
                categoryLimitCache = new CategoryLimitCache(cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getInt(columnIndexOrThrow5) != 0, cursorP.getInt(columnIndexOrThrow6) != 0, cursorP.getInt(columnIndexOrThrow7), cursorP.getLong(columnIndexOrThrow9), cursorP.getLong(columnIndexOrThrow), cursorP.getLong(columnIndexOrThrow10), cursorP.getLong(columnIndexOrThrow11));
            } else {
                categoryLimitCache = null;
            }
            return categoryLimitCache;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
