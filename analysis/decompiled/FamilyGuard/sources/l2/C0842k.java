package l2;

import android.database.Cursor;
import com.stepos.familyguard.db.entity.RawPeriodCache;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x3.q;

/* renamed from: l2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0842k implements InterfaceC0841j {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f18213a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f18214b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f18215c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f18216d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f18217e;

    /* renamed from: l2.k$a */
    class a extends Z.d<RawPeriodCache> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `RawPeriodCache`(`id`,`rawPeriodId`,`weekDayType`,`start`,`end`,`limitCacheId`,`remoteVersion`,`relationId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, RawPeriodCache rawPeriodCache) {
            interfaceC0651f.z(1, rawPeriodCache.getId());
            interfaceC0651f.z(2, rawPeriodCache.getRawPeriodId());
            interfaceC0651f.z(3, rawPeriodCache.getWeekDayType());
            interfaceC0651f.z(4, rawPeriodCache.getStart());
            interfaceC0651f.z(5, rawPeriodCache.getEnd());
            interfaceC0651f.z(6, rawPeriodCache.getLimitCacheId());
            interfaceC0651f.z(7, rawPeriodCache.getRemoteVersion());
            interfaceC0651f.z(8, rawPeriodCache.getRelationId());
        }
    }

    /* renamed from: l2.k$b */
    class b extends Z.c<RawPeriodCache> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `RawPeriodCache` SET `id` = ?,`rawPeriodId` = ?,`weekDayType` = ?,`start` = ?,`end` = ?,`limitCacheId` = ?,`remoteVersion` = ?,`relationId` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, RawPeriodCache rawPeriodCache) {
            interfaceC0651f.z(1, rawPeriodCache.getId());
            interfaceC0651f.z(2, rawPeriodCache.getRawPeriodId());
            interfaceC0651f.z(3, rawPeriodCache.getWeekDayType());
            interfaceC0651f.z(4, rawPeriodCache.getStart());
            interfaceC0651f.z(5, rawPeriodCache.getEnd());
            interfaceC0651f.z(6, rawPeriodCache.getLimitCacheId());
            interfaceC0651f.z(7, rawPeriodCache.getRemoteVersion());
            interfaceC0651f.z(8, rawPeriodCache.getRelationId());
            interfaceC0651f.z(9, rawPeriodCache.getId());
        }
    }

    /* renamed from: l2.k$c */
    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RawPeriodCache WHERE relationId = (?)";
        }
    }

    /* renamed from: l2.k$d */
    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RawPeriodCache WHERE id = (?)";
        }
    }

    /* renamed from: l2.k$e */
    class e implements Callable<List<RawPeriodCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f18222a;

        e(Z.j jVar) {
            this.f18222a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<RawPeriodCache> call() {
            Cursor cursorP = C0842k.this.f18213a.p(this.f18222a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("rawPeriodId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("weekDayType");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("start");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("end");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitCacheId");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("remoteVersion");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    RawPeriodCache rawPeriodCache = new RawPeriodCache();
                    rawPeriodCache.setId(cursorP.getLong(columnIndexOrThrow));
                    rawPeriodCache.setRawPeriodId(cursorP.getLong(columnIndexOrThrow2));
                    rawPeriodCache.setWeekDayType(cursorP.getInt(columnIndexOrThrow3));
                    rawPeriodCache.setStart(cursorP.getLong(columnIndexOrThrow4));
                    rawPeriodCache.setEnd(cursorP.getLong(columnIndexOrThrow5));
                    rawPeriodCache.setLimitCacheId(cursorP.getLong(columnIndexOrThrow6));
                    rawPeriodCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow7));
                    rawPeriodCache.setRelationId(cursorP.getLong(columnIndexOrThrow8));
                    arrayList.add(rawPeriodCache);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f18222a.r();
        }
    }

    public C0842k(Z.g gVar) {
        this.f18213a = gVar;
        this.f18214b = new a(gVar);
        this.f18215c = new b(gVar);
        this.f18216d = new c(gVar);
        this.f18217e = new d(gVar);
    }

    @Override // l2.InterfaceC0841j
    public void a(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f18217e.a();
        this.f18213a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f18213a.s();
        } finally {
            this.f18213a.f();
            this.f18217e.f(interfaceC0651fA);
        }
    }

    @Override // l2.InterfaceC0841j
    public q<List<RawPeriodCache>> b(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RawPeriodCache WHERE relationId = (?)", 1);
        jVarF.z(1, j5);
        return q.h(new e(jVarF));
    }

    @Override // l2.InterfaceC0841j
    public long c(RawPeriodCache rawPeriodCache) {
        this.f18213a.b();
        try {
            long j5 = this.f18214b.j(rawPeriodCache);
            this.f18213a.s();
            return j5;
        } finally {
            this.f18213a.f();
        }
    }

    @Override // l2.InterfaceC0841j
    public void d(RawPeriodCache rawPeriodCache) {
        this.f18213a.b();
        try {
            this.f18215c.h(rawPeriodCache);
            this.f18213a.s();
        } finally {
            this.f18213a.f();
        }
    }

    @Override // l2.InterfaceC0841j
    public RawPeriodCache e(long j5, long j6) {
        RawPeriodCache rawPeriodCache;
        Z.j jVarF = Z.j.f("SELECT * FROM RawPeriodCache WHERE id = (?) AND relationId = (?)", 2);
        jVarF.z(1, j5);
        jVarF.z(2, j6);
        Cursor cursorP = this.f18213a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("rawPeriodId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("weekDayType");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("start");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("end");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitCacheId");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("remoteVersion");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("relationId");
            if (cursorP.moveToFirst()) {
                rawPeriodCache = new RawPeriodCache();
                rawPeriodCache.setId(cursorP.getLong(columnIndexOrThrow));
                rawPeriodCache.setRawPeriodId(cursorP.getLong(columnIndexOrThrow2));
                rawPeriodCache.setWeekDayType(cursorP.getInt(columnIndexOrThrow3));
                rawPeriodCache.setStart(cursorP.getLong(columnIndexOrThrow4));
                rawPeriodCache.setEnd(cursorP.getLong(columnIndexOrThrow5));
                rawPeriodCache.setLimitCacheId(cursorP.getLong(columnIndexOrThrow6));
                rawPeriodCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow7));
                rawPeriodCache.setRelationId(cursorP.getLong(columnIndexOrThrow8));
            } else {
                rawPeriodCache = null;
            }
            return rawPeriodCache;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // l2.InterfaceC0841j
    public List<RawPeriodCache> f(long j5, long j6) {
        Z.j jVarF = Z.j.f("SELECT * FROM RawPeriodCache WHERE limitCacheId = (?) AND relationId = (?)", 2);
        jVarF.z(1, j5);
        jVarF.z(2, j6);
        Cursor cursorP = this.f18213a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("rawPeriodId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("weekDayType");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("start");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("end");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitCacheId");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("remoteVersion");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("relationId");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RawPeriodCache rawPeriodCache = new RawPeriodCache();
                rawPeriodCache.setId(cursorP.getLong(columnIndexOrThrow));
                rawPeriodCache.setRawPeriodId(cursorP.getLong(columnIndexOrThrow2));
                rawPeriodCache.setWeekDayType(cursorP.getInt(columnIndexOrThrow3));
                rawPeriodCache.setStart(cursorP.getLong(columnIndexOrThrow4));
                rawPeriodCache.setEnd(cursorP.getLong(columnIndexOrThrow5));
                rawPeriodCache.setLimitCacheId(cursorP.getLong(columnIndexOrThrow6));
                rawPeriodCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow7));
                rawPeriodCache.setRelationId(cursorP.getLong(columnIndexOrThrow8));
                arrayList.add(rawPeriodCache);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
