package l2;

import android.database.Cursor;
import com.stepos.familyguard.db.entity.PeriodLimitCache;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x3.q;

/* renamed from: l2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0840i implements InterfaceC0839h {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f18196a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f18197b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f18198c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f18199d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f18200e;

    /* renamed from: f, reason: collision with root package name */
    private final Z.l f18201f;

    /* renamed from: l2.i$a */
    class a implements Callable<List<PeriodLimitCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f18202a;

        a(Z.j jVar) {
            this.f18202a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PeriodLimitCache> call() {
            Cursor cursorP = C0840i.this.f18196a.p(this.f18202a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("periodLimitId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("type");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("categoryId");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("remoteVersion");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    PeriodLimitCache periodLimitCache = new PeriodLimitCache();
                    periodLimitCache.setId(cursorP.getLong(columnIndexOrThrow));
                    periodLimitCache.setPeriodLimitId(cursorP.getLong(columnIndexOrThrow2));
                    periodLimitCache.setType(cursorP.getInt(columnIndexOrThrow3));
                    periodLimitCache.setPackageName(cursorP.getString(columnIndexOrThrow4));
                    periodLimitCache.setCategoryId(cursorP.getLong(columnIndexOrThrow5));
                    boolean z5 = false;
                    periodLimitCache.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                    if (cursorP.getInt(columnIndexOrThrow7) != 0) {
                        z5 = true;
                    }
                    periodLimitCache.setEnable(z5);
                    periodLimitCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow8));
                    periodLimitCache.setRelationId(cursorP.getLong(columnIndexOrThrow9));
                    arrayList.add(periodLimitCache);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f18202a.r();
        }
    }

    /* renamed from: l2.i$b */
    class b extends Z.d<PeriodLimitCache> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PeriodLimitCache`(`id`,`periodLimitId`,`type`,`packageName`,`categoryId`,`notifyOnly`,`enable`,`remoteVersion`,`relationId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PeriodLimitCache periodLimitCache) {
            interfaceC0651f.z(1, periodLimitCache.getId());
            interfaceC0651f.z(2, periodLimitCache.getPeriodLimitId());
            interfaceC0651f.z(3, periodLimitCache.getType());
            if (periodLimitCache.getPackageName() == null) {
                interfaceC0651f.Z(4);
            } else {
                interfaceC0651f.l(4, periodLimitCache.getPackageName());
            }
            interfaceC0651f.z(5, periodLimitCache.getCategoryId());
            interfaceC0651f.z(6, periodLimitCache.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(7, periodLimitCache.isEnable() ? 1L : 0L);
            interfaceC0651f.z(8, periodLimitCache.getRemoteVersion());
            interfaceC0651f.z(9, periodLimitCache.getRelationId());
        }
    }

    /* renamed from: l2.i$c */
    class c extends Z.c<PeriodLimitCache> {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `PeriodLimitCache` SET `id` = ?,`periodLimitId` = ?,`type` = ?,`packageName` = ?,`categoryId` = ?,`notifyOnly` = ?,`enable` = ?,`remoteVersion` = ?,`relationId` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PeriodLimitCache periodLimitCache) {
            interfaceC0651f.z(1, periodLimitCache.getId());
            interfaceC0651f.z(2, periodLimitCache.getPeriodLimitId());
            interfaceC0651f.z(3, periodLimitCache.getType());
            if (periodLimitCache.getPackageName() == null) {
                interfaceC0651f.Z(4);
            } else {
                interfaceC0651f.l(4, periodLimitCache.getPackageName());
            }
            interfaceC0651f.z(5, periodLimitCache.getCategoryId());
            interfaceC0651f.z(6, periodLimitCache.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(7, periodLimitCache.isEnable() ? 1L : 0L);
            interfaceC0651f.z(8, periodLimitCache.getRemoteVersion());
            interfaceC0651f.z(9, periodLimitCache.getRelationId());
            interfaceC0651f.z(10, periodLimitCache.getId());
        }
    }

    /* renamed from: l2.i$d */
    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM PeriodLimitCache WHERE packageName = (?) AND type = 0 AND relationId = (?)";
        }
    }

    /* renamed from: l2.i$e */
    class e extends Z.l {
        e(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM PeriodLimitCache WHERE categoryId = (?) AND type = 1 AND relationId = (?)";
        }
    }

    /* renamed from: l2.i$f */
    class f extends Z.l {
        f(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM PeriodLimitCache WHERE relationId = (?)";
        }
    }

    /* renamed from: l2.i$g */
    class g implements Callable<List<PeriodLimitCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f18209a;

        g(Z.j jVar) {
            this.f18209a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PeriodLimitCache> call() {
            Cursor cursorP = C0840i.this.f18196a.p(this.f18209a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("periodLimitId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("type");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("categoryId");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("remoteVersion");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    PeriodLimitCache periodLimitCache = new PeriodLimitCache();
                    periodLimitCache.setId(cursorP.getLong(columnIndexOrThrow));
                    periodLimitCache.setPeriodLimitId(cursorP.getLong(columnIndexOrThrow2));
                    periodLimitCache.setType(cursorP.getInt(columnIndexOrThrow3));
                    periodLimitCache.setPackageName(cursorP.getString(columnIndexOrThrow4));
                    periodLimitCache.setCategoryId(cursorP.getLong(columnIndexOrThrow5));
                    boolean z5 = false;
                    periodLimitCache.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                    if (cursorP.getInt(columnIndexOrThrow7) != 0) {
                        z5 = true;
                    }
                    periodLimitCache.setEnable(z5);
                    periodLimitCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow8));
                    periodLimitCache.setRelationId(cursorP.getLong(columnIndexOrThrow9));
                    arrayList.add(periodLimitCache);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f18209a.r();
        }
    }

    /* renamed from: l2.i$h */
    class h implements Callable<List<PeriodLimitCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f18211a;

        h(Z.j jVar) {
            this.f18211a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PeriodLimitCache> call() {
            Cursor cursorP = C0840i.this.f18196a.p(this.f18211a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("periodLimitId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("type");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("categoryId");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("remoteVersion");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    PeriodLimitCache periodLimitCache = new PeriodLimitCache();
                    periodLimitCache.setId(cursorP.getLong(columnIndexOrThrow));
                    periodLimitCache.setPeriodLimitId(cursorP.getLong(columnIndexOrThrow2));
                    periodLimitCache.setType(cursorP.getInt(columnIndexOrThrow3));
                    periodLimitCache.setPackageName(cursorP.getString(columnIndexOrThrow4));
                    periodLimitCache.setCategoryId(cursorP.getLong(columnIndexOrThrow5));
                    boolean z5 = false;
                    periodLimitCache.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                    if (cursorP.getInt(columnIndexOrThrow7) != 0) {
                        z5 = true;
                    }
                    periodLimitCache.setEnable(z5);
                    periodLimitCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow8));
                    periodLimitCache.setRelationId(cursorP.getLong(columnIndexOrThrow9));
                    arrayList.add(periodLimitCache);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f18211a.r();
        }
    }

    public C0840i(Z.g gVar) {
        this.f18196a = gVar;
        this.f18197b = new b(gVar);
        this.f18198c = new c(gVar);
        this.f18199d = new d(gVar);
        this.f18200e = new e(gVar);
        this.f18201f = new f(gVar);
    }

    @Override // l2.InterfaceC0839h
    public PeriodLimitCache a(long j5, long j6) {
        PeriodLimitCache periodLimitCache;
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimitCache WHERE relationId = (?) AND categoryId = (?) AND type = 1", 2);
        boolean z5 = true;
        jVarF.z(1, j6);
        jVarF.z(2, j5);
        Cursor cursorP = this.f18196a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("periodLimitId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("remoteVersion");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("relationId");
            if (cursorP.moveToFirst()) {
                periodLimitCache = new PeriodLimitCache();
                periodLimitCache.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimitCache.setPeriodLimitId(cursorP.getLong(columnIndexOrThrow2));
                periodLimitCache.setType(cursorP.getInt(columnIndexOrThrow3));
                periodLimitCache.setPackageName(cursorP.getString(columnIndexOrThrow4));
                periodLimitCache.setCategoryId(cursorP.getLong(columnIndexOrThrow5));
                periodLimitCache.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                if (cursorP.getInt(columnIndexOrThrow7) == 0) {
                    z5 = false;
                }
                periodLimitCache.setEnable(z5);
                periodLimitCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow8));
                periodLimitCache.setRelationId(cursorP.getLong(columnIndexOrThrow9));
            } else {
                periodLimitCache = null;
            }
            return periodLimitCache;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // l2.InterfaceC0839h
    public q<List<PeriodLimitCache>> b(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimitCache WHERE relationId = (?)", 1);
        jVarF.z(1, j5);
        return q.h(new g(jVarF));
    }

    @Override // l2.InterfaceC0839h
    public long c(PeriodLimitCache periodLimitCache) {
        this.f18196a.b();
        try {
            long j5 = this.f18197b.j(periodLimitCache);
            this.f18196a.s();
            return j5;
        } finally {
            this.f18196a.f();
        }
    }

    @Override // l2.InterfaceC0839h
    public PeriodLimitCache d(String str, long j5) {
        PeriodLimitCache periodLimitCache;
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimitCache WHERE relationId = (?) AND packageName = (?) AND type = 0", 2);
        boolean z5 = true;
        jVarF.z(1, j5);
        if (str == null) {
            jVarF.Z(2);
        } else {
            jVarF.l(2, str);
        }
        Cursor cursorP = this.f18196a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("periodLimitId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("remoteVersion");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("relationId");
            if (cursorP.moveToFirst()) {
                periodLimitCache = new PeriodLimitCache();
                periodLimitCache.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimitCache.setPeriodLimitId(cursorP.getLong(columnIndexOrThrow2));
                periodLimitCache.setType(cursorP.getInt(columnIndexOrThrow3));
                periodLimitCache.setPackageName(cursorP.getString(columnIndexOrThrow4));
                periodLimitCache.setCategoryId(cursorP.getLong(columnIndexOrThrow5));
                periodLimitCache.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                if (cursorP.getInt(columnIndexOrThrow7) == 0) {
                    z5 = false;
                }
                periodLimitCache.setEnable(z5);
                periodLimitCache.setRemoteVersion(cursorP.getLong(columnIndexOrThrow8));
                periodLimitCache.setRelationId(cursorP.getLong(columnIndexOrThrow9));
            } else {
                periodLimitCache = null;
            }
            return periodLimitCache;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // l2.InterfaceC0839h
    public void e(long j5, long j6) {
        InterfaceC0651f interfaceC0651fA = this.f18200e.a();
        this.f18196a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.z(2, j6);
            interfaceC0651fA.n();
            this.f18196a.s();
        } finally {
            this.f18196a.f();
            this.f18200e.f(interfaceC0651fA);
        }
    }

    @Override // l2.InterfaceC0839h
    public q<List<PeriodLimitCache>> f(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimitCache WHERE type = (?) AND relationId = (?)", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        return q.h(new h(jVarF));
    }

    @Override // l2.InterfaceC0839h
    public void g(String str, long j5) {
        InterfaceC0651f interfaceC0651fA = this.f18199d.a();
        this.f18196a.b();
        try {
            if (str == null) {
                interfaceC0651fA.Z(1);
            } else {
                interfaceC0651fA.l(1, str);
            }
            interfaceC0651fA.z(2, j5);
            interfaceC0651fA.n();
            this.f18196a.s();
            this.f18196a.f();
            this.f18199d.f(interfaceC0651fA);
        } catch (Throwable th) {
            this.f18196a.f();
            this.f18199d.f(interfaceC0651fA);
            throw th;
        }
    }

    @Override // l2.InterfaceC0839h
    public q<List<PeriodLimitCache>> h(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimitCache WHERE relationId = (?)", 1);
        jVarF.z(1, j5);
        return q.h(new a(jVarF));
    }
}
