package com.stepos.digitalwellbeing;

import Z.g;
import Z.i;
import b0.C0552a;
import b2.AbstractC0558a;
import b2.C0559b;
import com.stepos.digitalwellbeing.server.limit.data.room.b;
import com.stepos.digitalwellbeing.server.limit.data.room.c;
import com.stepos.digitalwellbeing.server.limit.data.room.d;
import com.stepos.digitalwellbeing.server.limit.data.room.e;
import com.stepos.digitalwellbeing.server.limit.data.room.f;
import com.stepos.digitalwellbeing.server.limit.data.room.g;
import com.stepos.digitalwellbeing.server.limit.data.room.h;
import com.stepos.digitalwellbeing.server.limit.data.room.i;
import com.stepos.digitalwellbeing.server.limit.data.room.j;
import com.stepos.digitalwellbeing.server.limit.data.room.k;
import com.stepos.digitalwellbeing.server.limit.data.room.l;
import com.stepos.digitalwellbeing.server.limit.data.room.m;
import com.stepos.digitalwellbeing.server.limit.data.room.n;
import com.stepos.minor.Minor;
import d0.InterfaceC0647b;
import d0.InterfaceC0648c;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class DigitalWellbeingDataBase_Impl extends DigitalWellbeingDataBase {

    /* renamed from: i, reason: collision with root package name */
    private volatile e f14465i;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.stepos.digitalwellbeing.server.limit.data.room.a f14466j;

    /* renamed from: k, reason: collision with root package name */
    private volatile c f14467k;

    /* renamed from: l, reason: collision with root package name */
    private volatile X1.a f14468l;

    /* renamed from: m, reason: collision with root package name */
    private volatile AbstractC0558a f14469m;

    /* renamed from: n, reason: collision with root package name */
    private volatile g f14470n;

    /* renamed from: o, reason: collision with root package name */
    private volatile i f14471o;

    /* renamed from: p, reason: collision with root package name */
    private volatile k f14472p;

    /* renamed from: q, reason: collision with root package name */
    private volatile m f14473q;

    class a extends i.a {
        a(int i5) {
            super(i5);
        }

        @Override // Z.i.a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `adminId` INTEGER NOT NULL, `isChild` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageCategoryInfo` (`packageName` TEXT NOT NULL, `categoryId` INTEGER NOT NULL, PRIMARY KEY(`packageName`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `adminId` INTEGER NOT NULL, `isChild` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `WorkdayAdjustEntity` (`time` INTEGER NOT NULL, `workday` INTEGER NOT NULL, PRIMARY KEY(`time`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PeriodLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `packageName` TEXT, `categoryId` INTEGER NOT NULL, `adminId` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `isChild` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `version` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `RawPeriod` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `weekDayType` INTEGER NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `limitId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `RipePeriod` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time` INTEGER NOT NULL, `limitId` INTEGER NOT NULL, `limitType` INTEGER NOT NULL, `adminId` INTEGER NOT NULL, `limitPackageName` TEXT, `limitCategoryId` INTEGER NOT NULL, `version` INTEGER NOT NULL, `type` INTEGER NOT NULL, `mergedWeekDayType` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `GlobalLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `adminId` INTEGER NOT NULL, `isChild` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `suspended_record` (`packageName` TEXT NOT NULL, `flags` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`packageName`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC0647b.k("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"ce1d2459d64e4f84003533fb48d666cf\")");
        }

        @Override // Z.i.a
        public void b(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageLimit`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageCategoryInfo`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `CategoryLimit`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `WorkdayAdjustEntity`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PeriodLimit`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `RawPeriod`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `RipePeriod`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `GlobalLimit`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `suspended_record`");
        }

        @Override // Z.i.a
        protected void c(InterfaceC0647b interfaceC0647b) {
            if (((Z.g) DigitalWellbeingDataBase_Impl.this).f6574g != null) {
                int size = ((Z.g) DigitalWellbeingDataBase_Impl.this).f6574g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((g.b) ((Z.g) DigitalWellbeingDataBase_Impl.this).f6574g.get(i5)).a(interfaceC0647b);
                }
            }
        }

        @Override // Z.i.a
        public void d(InterfaceC0647b interfaceC0647b) {
            ((Z.g) DigitalWellbeingDataBase_Impl.this).f6568a = interfaceC0647b;
            DigitalWellbeingDataBase_Impl.this.m(interfaceC0647b);
            if (((Z.g) DigitalWellbeingDataBase_Impl.this).f6574g != null) {
                int size = ((Z.g) DigitalWellbeingDataBase_Impl.this).f6574g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((g.b) ((Z.g) DigitalWellbeingDataBase_Impl.this).f6574g.get(i5)).b(interfaceC0647b);
                }
            }
        }

        @Override // Z.i.a
        protected void e(InterfaceC0647b interfaceC0647b) {
            HashMap map = new HashMap(11);
            map.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map.put("packageName", new C0552a.C0153a("packageName", "TEXT", false, 0));
            map.put("workdayLimit", new C0552a.C0153a("workdayLimit", "INTEGER", true, 0));
            map.put("offDayLimit", new C0552a.C0153a("offDayLimit", "INTEGER", true, 0));
            map.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map.put("lastHandleTime", new C0552a.C0153a("lastHandleTime", "INTEGER", true, 0));
            map.put("adminId", new C0552a.C0153a("adminId", "INTEGER", true, 0));
            map.put("isChild", new C0552a.C0153a("isChild", "INTEGER", true, 0));
            C0552a c0552a = new C0552a("PackageLimit", map, new HashSet(0), new HashSet(0));
            C0552a c0552aA = C0552a.a(interfaceC0647b, "PackageLimit");
            if (!c0552a.equals(c0552aA)) {
                throw new IllegalStateException("Migration didn't properly handle PackageLimit(com.stepos.digitalwellbeing.server.limit.data.room.PackageLimit).\n Expected:\n" + c0552a + "\n Found:\n" + c0552aA);
            }
            HashMap map2 = new HashMap(2);
            map2.put("packageName", new C0552a.C0153a("packageName", "TEXT", true, 1));
            map2.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 0));
            C0552a c0552a2 = new C0552a("PackageCategoryInfo", map2, new HashSet(0), new HashSet(0));
            C0552a c0552aA2 = C0552a.a(interfaceC0647b, "PackageCategoryInfo");
            if (!c0552a2.equals(c0552aA2)) {
                throw new IllegalStateException("Migration didn't properly handle PackageCategoryInfo(com.stepos.digitalwellbeing.server.category.data.room.PackageCategoryInfo).\n Expected:\n" + c0552a2 + "\n Found:\n" + c0552aA2);
            }
            HashMap map3 = new HashMap(11);
            map3.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map3.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 0));
            map3.put("workdayLimit", new C0552a.C0153a("workdayLimit", "INTEGER", true, 0));
            map3.put("offDayLimit", new C0552a.C0153a("offDayLimit", "INTEGER", true, 0));
            map3.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map3.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map3.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map3.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map3.put("lastHandleTime", new C0552a.C0153a("lastHandleTime", "INTEGER", true, 0));
            map3.put("adminId", new C0552a.C0153a("adminId", "INTEGER", true, 0));
            map3.put("isChild", new C0552a.C0153a("isChild", "INTEGER", true, 0));
            C0552a c0552a3 = new C0552a("CategoryLimit", map3, new HashSet(0), new HashSet(0));
            C0552a c0552aA3 = C0552a.a(interfaceC0647b, "CategoryLimit");
            if (!c0552a3.equals(c0552aA3)) {
                throw new IllegalStateException("Migration didn't properly handle CategoryLimit(com.stepos.digitalwellbeing.server.limit.data.room.CategoryLimit).\n Expected:\n" + c0552a3 + "\n Found:\n" + c0552aA3);
            }
            HashMap map4 = new HashMap(2);
            map4.put("time", new C0552a.C0153a("time", "INTEGER", true, 1));
            map4.put("workday", new C0552a.C0153a("workday", "INTEGER", true, 0));
            C0552a c0552a4 = new C0552a("WorkdayAdjustEntity", map4, new HashSet(0), new HashSet(0));
            C0552a c0552aA4 = C0552a.a(interfaceC0647b, "WorkdayAdjustEntity");
            if (!c0552a4.equals(c0552aA4)) {
                throw new IllegalStateException("Migration didn't properly handle WorkdayAdjustEntity(com.stepos.digitalwellbeing.server.net.workday.WorkdayAdjustEntity).\n Expected:\n" + c0552a4 + "\n Found:\n" + c0552aA4);
            }
            HashMap map5 = new HashMap(9);
            map5.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map5.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map5.put("packageName", new C0552a.C0153a("packageName", "TEXT", false, 0));
            map5.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 0));
            map5.put("adminId", new C0552a.C0153a("adminId", "INTEGER", true, 0));
            map5.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map5.put("isChild", new C0552a.C0153a("isChild", "INTEGER", true, 0));
            map5.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map5.put("version", new C0552a.C0153a("version", "INTEGER", true, 0));
            C0552a c0552a5 = new C0552a("PeriodLimit", map5, new HashSet(0), new HashSet(0));
            C0552a c0552aA5 = C0552a.a(interfaceC0647b, "PeriodLimit");
            if (!c0552a5.equals(c0552aA5)) {
                throw new IllegalStateException("Migration didn't properly handle PeriodLimit(com.stepos.digitalwellbeing.server.limit.data.room.PeriodLimit).\n Expected:\n" + c0552a5 + "\n Found:\n" + c0552aA5);
            }
            HashMap map6 = new HashMap(5);
            map6.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map6.put("weekDayType", new C0552a.C0153a("weekDayType", "INTEGER", true, 0));
            map6.put("start", new C0552a.C0153a("start", "INTEGER", true, 0));
            map6.put("end", new C0552a.C0153a("end", "INTEGER", true, 0));
            map6.put("limitId", new C0552a.C0153a("limitId", "INTEGER", true, 0));
            C0552a c0552a6 = new C0552a("RawPeriod", map6, new HashSet(0), new HashSet(0));
            C0552a c0552aA6 = C0552a.a(interfaceC0647b, "RawPeriod");
            if (!c0552a6.equals(c0552aA6)) {
                throw new IllegalStateException("Migration didn't properly handle RawPeriod(com.stepos.digitalwellbeing.server.limit.data.room.RawPeriod).\n Expected:\n" + c0552a6 + "\n Found:\n" + c0552aA6);
            }
            HashMap map7 = new HashMap(10);
            map7.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map7.put("time", new C0552a.C0153a("time", "INTEGER", true, 0));
            map7.put("limitId", new C0552a.C0153a("limitId", "INTEGER", true, 0));
            map7.put("limitType", new C0552a.C0153a("limitType", "INTEGER", true, 0));
            map7.put("adminId", new C0552a.C0153a("adminId", "INTEGER", true, 0));
            map7.put("limitPackageName", new C0552a.C0153a("limitPackageName", "TEXT", false, 0));
            map7.put("limitCategoryId", new C0552a.C0153a("limitCategoryId", "INTEGER", true, 0));
            map7.put("version", new C0552a.C0153a("version", "INTEGER", true, 0));
            map7.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map7.put("mergedWeekDayType", new C0552a.C0153a("mergedWeekDayType", "INTEGER", true, 0));
            C0552a c0552a7 = new C0552a("RipePeriod", map7, new HashSet(0), new HashSet(0));
            C0552a c0552aA7 = C0552a.a(interfaceC0647b, "RipePeriod");
            if (!c0552a7.equals(c0552aA7)) {
                throw new IllegalStateException("Migration didn't properly handle RipePeriod(com.stepos.digitalwellbeing.server.limit.data.room.RipePeriod).\n Expected:\n" + c0552a7 + "\n Found:\n" + c0552aA7);
            }
            HashMap map8 = new HashMap(10);
            map8.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map8.put("workdayLimit", new C0552a.C0153a("workdayLimit", "INTEGER", true, 0));
            map8.put("offDayLimit", new C0552a.C0153a("offDayLimit", "INTEGER", true, 0));
            map8.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map8.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map8.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map8.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map8.put("lastHandleTime", new C0552a.C0153a("lastHandleTime", "INTEGER", true, 0));
            map8.put("adminId", new C0552a.C0153a("adminId", "INTEGER", true, 0));
            map8.put("isChild", new C0552a.C0153a("isChild", "INTEGER", true, 0));
            C0552a c0552a8 = new C0552a("GlobalLimit", map8, new HashSet(0), new HashSet(0));
            C0552a c0552aA8 = C0552a.a(interfaceC0647b, "GlobalLimit");
            if (!c0552a8.equals(c0552aA8)) {
                throw new IllegalStateException("Migration didn't properly handle GlobalLimit(com.stepos.digitalwellbeing.server.limit.data.room.GlobalLimit).\n Expected:\n" + c0552a8 + "\n Found:\n" + c0552aA8);
            }
            HashMap map9 = new HashMap(3);
            map9.put("packageName", new C0552a.C0153a("packageName", "TEXT", true, 1));
            map9.put("flags", new C0552a.C0153a("flags", "INTEGER", true, 0));
            map9.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            C0552a c0552a9 = new C0552a("suspended_record", map9, new HashSet(0), new HashSet(0));
            C0552a c0552aA9 = C0552a.a(interfaceC0647b, "suspended_record");
            if (c0552a9.equals(c0552aA9)) {
                return;
            }
            throw new IllegalStateException("Migration didn't properly handle suspended_record(com.stepos.digitalwellbeing.server.limit.data.room.SuspendedRecordEntity).\n Expected:\n" + c0552a9 + "\n Found:\n" + c0552aA9);
        }
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public AbstractC0558a A() {
        AbstractC0558a abstractC0558a;
        if (this.f14469m != null) {
            return this.f14469m;
        }
        synchronized (this) {
            try {
                if (this.f14469m == null) {
                    this.f14469m = new C0559b(this);
                }
                abstractC0558a = this.f14469m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC0558a;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public e B() {
        e eVar;
        if (this.f14465i != null) {
            return this.f14465i;
        }
        synchronized (this) {
            try {
                if (this.f14465i == null) {
                    this.f14465i = new f(this);
                }
                eVar = this.f14465i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // Z.g
    protected Z.e d() {
        return new Z.e(this, "PackageLimit", "PackageCategoryInfo", "CategoryLimit", "WorkdayAdjustEntity", "PeriodLimit", "RawPeriod", "RipePeriod", "GlobalLimit", "suspended_record");
    }

    @Override // Z.g
    protected InterfaceC0648c e(Z.a aVar) {
        return aVar.f6531a.a(InterfaceC0648c.b.a(aVar.f6532b).c(aVar.f6533c).b(new Z.i(aVar, new a(7), "ce1d2459d64e4f84003533fb48d666cf", "bb919c67777afd4308e9f86709777659")).a());
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public com.stepos.digitalwellbeing.server.limit.data.room.a t() {
        com.stepos.digitalwellbeing.server.limit.data.room.a aVar;
        if (this.f14466j != null) {
            return this.f14466j;
        }
        synchronized (this) {
            try {
                if (this.f14466j == null) {
                    this.f14466j = new b(this);
                }
                aVar = this.f14466j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public c u() {
        c cVar;
        if (this.f14467k != null) {
            return this.f14467k;
        }
        synchronized (this) {
            try {
                if (this.f14467k == null) {
                    this.f14467k = new d(this);
                }
                cVar = this.f14467k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public X1.a v() {
        X1.a aVar;
        if (this.f14468l != null) {
            return this.f14468l;
        }
        synchronized (this) {
            try {
                if (this.f14468l == null) {
                    this.f14468l = new X1.b(this);
                }
                aVar = this.f14468l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public com.stepos.digitalwellbeing.server.limit.data.room.g w() {
        com.stepos.digitalwellbeing.server.limit.data.room.g gVar;
        if (this.f14470n != null) {
            return this.f14470n;
        }
        synchronized (this) {
            try {
                if (this.f14470n == null) {
                    this.f14470n = new h(this);
                }
                gVar = this.f14470n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public com.stepos.digitalwellbeing.server.limit.data.room.i x() {
        com.stepos.digitalwellbeing.server.limit.data.room.i iVar;
        if (this.f14471o != null) {
            return this.f14471o;
        }
        synchronized (this) {
            try {
                if (this.f14471o == null) {
                    this.f14471o = new j(this);
                }
                iVar = this.f14471o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public k y() {
        k kVar;
        if (this.f14472p != null) {
            return this.f14472p;
        }
        synchronized (this) {
            try {
                if (this.f14472p == null) {
                    this.f14472p = new l(this);
                }
                kVar = this.f14472p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    @Override // com.stepos.digitalwellbeing.DigitalWellbeingDataBase
    public m z() {
        m mVar;
        if (this.f14473q != null) {
            return this.f14473q;
        }
        synchronized (this) {
            try {
                if (this.f14473q == null) {
                    this.f14473q = new n(this);
                }
                mVar = this.f14473q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }
}
