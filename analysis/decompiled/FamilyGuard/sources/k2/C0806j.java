package k2;

import android.database.Cursor;
import com.stepos.familyguard.db.entity.PackageLimitCache;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x3.q;

/* renamed from: k2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0806j implements InterfaceC0805i {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17881a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17882b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17883c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f17884d;

    /* renamed from: k2.j$a */
    class a extends Z.d<PackageLimitCache> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PackageLimitCache`(`packageLimitId`,`packageName`,`workdayLimit`,`offDayLimit`,`notifyOnly`,`state`,`enable`,`interval`,`lastHandleTime`,`relationId`,`version`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageLimitCache packageLimitCache) {
            interfaceC0651f.z(1, packageLimitCache.getPackageLimitId());
            if (packageLimitCache.getPackageName() == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, packageLimitCache.getPackageName());
            }
            interfaceC0651f.z(3, packageLimitCache.getWorkdayLimit());
            interfaceC0651f.z(4, packageLimitCache.getOffDayLimit());
            interfaceC0651f.z(5, packageLimitCache.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(6, packageLimitCache.getState());
            interfaceC0651f.z(7, packageLimitCache.isEnable() ? 1L : 0L);
            interfaceC0651f.z(8, packageLimitCache.getInterval());
            interfaceC0651f.z(9, packageLimitCache.getLastHandleTime());
            interfaceC0651f.z(10, packageLimitCache.getRelationId());
            interfaceC0651f.z(11, packageLimitCache.getVersion());
        }
    }

    /* renamed from: k2.j$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from packagelimitcache where relationId =?";
        }
    }

    /* renamed from: k2.j$c */
    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from packagelimitcache where relationId =? AND packageName = (?)";
        }
    }

    /* renamed from: k2.j$d */
    class d implements Callable<List<PackageLimitCache>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17888a;

        d(Z.j jVar) {
            this.f17888a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PackageLimitCache> call() {
            Cursor cursorP = C0806j.this.f17881a.p(this.f17888a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("packageLimitId");
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("version");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    long j5 = cursorP.getLong(columnIndexOrThrow);
                    PackageLimitCache packageLimitCache = new PackageLimitCache(cursorP.getInt(columnIndexOrThrow8), cursorP.getString(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7) != 0, cursorP.getInt(columnIndexOrThrow5) != 0, j5, cursorP.getLong(columnIndexOrThrow10), cursorP.getLong(columnIndexOrThrow11));
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    packageLimitCache.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                    arrayList.add(packageLimitCache);
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow3 = i6;
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17888a.r();
        }
    }

    /* renamed from: k2.j$e */
    class e implements Callable<PackageLimitCache> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17890a;

        e(Z.j jVar) {
            this.f17890a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PackageLimitCache call() {
            PackageLimitCache packageLimitCache;
            Cursor cursorP = C0806j.this.f17881a.p(this.f17890a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("packageLimitId");
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("version");
                if (cursorP.moveToFirst()) {
                    packageLimitCache = new PackageLimitCache(cursorP.getInt(columnIndexOrThrow8), cursorP.getString(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7) != 0, cursorP.getInt(columnIndexOrThrow5) != 0, cursorP.getLong(columnIndexOrThrow), cursorP.getLong(columnIndexOrThrow10), cursorP.getLong(columnIndexOrThrow11));
                    packageLimitCache.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                } else {
                    packageLimitCache = null;
                }
                if (packageLimitCache != null) {
                    return packageLimitCache;
                }
                throw new Z.b("Query returned empty result set: " + this.f17890a.c());
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17890a.r();
        }
    }

    public C0806j(Z.g gVar) {
        this.f17881a = gVar;
        this.f17882b = new a(gVar);
        this.f17883c = new b(gVar);
        this.f17884d = new c(gVar);
    }

    @Override // k2.InterfaceC0805i
    public q<List<PackageLimitCache>> a(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM packagelimitcache where interval = (?) AND relationId = (?)", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        return q.h(new d(jVarF));
    }

    @Override // k2.InterfaceC0805i
    public int b(long j5, String str) {
        InterfaceC0651f interfaceC0651fA = this.f17884d.a();
        this.f17881a.b();
        try {
            interfaceC0651fA.z(1, j5);
            if (str == null) {
                interfaceC0651fA.Z(2);
            } else {
                interfaceC0651fA.l(2, str);
            }
            int iN = interfaceC0651fA.n();
            this.f17881a.s();
            this.f17881a.f();
            this.f17884d.f(interfaceC0651fA);
            return iN;
        } catch (Throwable th) {
            this.f17881a.f();
            this.f17884d.f(interfaceC0651fA);
            throw th;
        }
    }

    @Override // k2.InterfaceC0805i
    public long c(PackageLimitCache packageLimitCache) {
        this.f17881a.b();
        try {
            long j5 = this.f17882b.j(packageLimitCache);
            this.f17881a.s();
            return j5;
        } finally {
            this.f17881a.f();
        }
    }

    @Override // k2.InterfaceC0805i
    public PackageLimitCache d(long j5, String str) {
        PackageLimitCache packageLimitCache;
        Z.j jVarF = Z.j.f("SELECT * FROM packagelimitcache WHERE packageName = (?) AND relationId = (?)", 2);
        if (str == null) {
            jVarF.Z(1);
        } else {
            jVarF.l(1, str);
        }
        jVarF.z(2, j5);
        Cursor cursorP = this.f17881a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("packageLimitId");
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("relationId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("version");
            if (cursorP.moveToFirst()) {
                long j6 = cursorP.getLong(columnIndexOrThrow);
                packageLimitCache = new PackageLimitCache(cursorP.getInt(columnIndexOrThrow8), cursorP.getString(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7) != 0, cursorP.getInt(columnIndexOrThrow5) != 0, j6, cursorP.getLong(columnIndexOrThrow10), cursorP.getLong(columnIndexOrThrow11));
                packageLimitCache.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
            } else {
                packageLimitCache = null;
            }
            return packageLimitCache;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // k2.InterfaceC0805i
    public q<PackageLimitCache> e(int i5, long j5, String str) {
        Z.j jVarF = Z.j.f("SELECT * FROM packagelimitcache WHERE interval = (?) AND packageName = (?) AND relationId = (?)", 3);
        jVarF.z(1, i5);
        if (str == null) {
            jVarF.Z(2);
        } else {
            jVarF.l(2, str);
        }
        jVarF.z(3, j5);
        return q.h(new e(jVarF));
    }
}
