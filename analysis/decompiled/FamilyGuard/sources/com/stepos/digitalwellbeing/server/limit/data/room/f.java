package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14589a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14590b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14591c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.c f14592d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14593e;

    class a extends Z.d<PackageLimit> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PackageLimit`(`id`,`packageName`,`workdayLimit`,`offDayLimit`,`notifyOnly`,`state`,`interval`,`enable`,`lastHandleTime`,`adminId`,`isChild`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageLimit packageLimit) {
            interfaceC0651f.z(1, packageLimit.getId());
            if (packageLimit.getPackageName() == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, packageLimit.getPackageName());
            }
            interfaceC0651f.z(3, packageLimit.getWorkdayLimit());
            interfaceC0651f.z(4, packageLimit.getOffDayLimit());
            interfaceC0651f.z(5, packageLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(6, packageLimit.getState());
            interfaceC0651f.z(7, packageLimit.getInterval());
            interfaceC0651f.z(8, packageLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(9, packageLimit.getLastHandleTime());
            interfaceC0651f.z(10, packageLimit.getAdminId());
            interfaceC0651f.z(11, packageLimit.isChild() ? 1L : 0L);
        }
    }

    class b extends Z.c<PackageLimit> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM `PackageLimit` WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageLimit packageLimit) {
            interfaceC0651f.z(1, packageLimit.getId());
        }
    }

    class c extends Z.c<PackageLimit> {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `PackageLimit` SET `id` = ?,`packageName` = ?,`workdayLimit` = ?,`offDayLimit` = ?,`notifyOnly` = ?,`state` = ?,`interval` = ?,`enable` = ?,`lastHandleTime` = ?,`adminId` = ?,`isChild` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageLimit packageLimit) {
            interfaceC0651f.z(1, packageLimit.getId());
            if (packageLimit.getPackageName() == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, packageLimit.getPackageName());
            }
            interfaceC0651f.z(3, packageLimit.getWorkdayLimit());
            interfaceC0651f.z(4, packageLimit.getOffDayLimit());
            interfaceC0651f.z(5, packageLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(6, packageLimit.getState());
            interfaceC0651f.z(7, packageLimit.getInterval());
            interfaceC0651f.z(8, packageLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(9, packageLimit.getLastHandleTime());
            interfaceC0651f.z(10, packageLimit.getAdminId());
            interfaceC0651f.z(11, packageLimit.isChild() ? 1L : 0L);
            interfaceC0651f.z(12, packageLimit.getId());
        }
    }

    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM packagelimit WHERE adminId = (?)";
        }
    }

    public f(Z.g gVar) {
        this.f14589a = gVar;
        this.f14590b = new a(gVar);
        this.f14591c = new b(gVar);
        this.f14592d = new c(gVar);
        this.f14593e = new d(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.e
    public List<PackageLimit> a(long j5) throws Throwable {
        Z.j jVar;
        Z.j jVarF = Z.j.f("SELECT * FROM packagelimit WHERE adminId = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14589a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("isChild");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                PackageLimit packageLimit = new PackageLimit();
                jVar = jVarF;
                try {
                    packageLimit.setId(cursorP.getLong(columnIndexOrThrow));
                    packageLimit.setPackageName(cursorP.getString(columnIndexOrThrow2));
                    packageLimit.setWorkdayLimit(cursorP.getLong(columnIndexOrThrow3));
                    packageLimit.setOffDayLimit(cursorP.getLong(columnIndexOrThrow4));
                    packageLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow5) != 0);
                    packageLimit.setState(cursorP.getInt(columnIndexOrThrow6));
                    packageLimit.setInterval(cursorP.getInt(columnIndexOrThrow7));
                    packageLimit.setEnable(cursorP.getInt(columnIndexOrThrow8) != 0);
                    int i5 = columnIndexOrThrow;
                    packageLimit.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                    packageLimit.setAdminId(cursorP.getLong(columnIndexOrThrow10));
                    packageLimit.setChild(cursorP.getInt(columnIndexOrThrow11) != 0);
                    arrayList.add(packageLimit);
                    columnIndexOrThrow = i5;
                    jVarF = jVar;
                } catch (Throwable th) {
                    th = th;
                    cursorP.close();
                    jVar.r();
                    throw th;
                }
            }
            cursorP.close();
            jVarF.r();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            jVar = jVarF;
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.e
    public long b(PackageLimit packageLimit) {
        this.f14589a.b();
        try {
            long j5 = this.f14590b.j(packageLimit);
            this.f14589a.s();
            return j5;
        } finally {
            this.f14589a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.e
    public void c(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14593e.a();
        this.f14589a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14589a.s();
        } finally {
            this.f14589a.f();
            this.f14593e.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.e
    public void d(PackageLimit packageLimit) {
        this.f14589a.b();
        try {
            this.f14592d.h(packageLimit);
            this.f14589a.s();
        } finally {
            this.f14589a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.e
    public PackageLimit e(String str, long j5) {
        PackageLimit packageLimit;
        Z.j jVarF = Z.j.f("SELECT * FROM packagelimit WHERE packageName = (?) AND adminId = (?)", 2);
        if (str == null) {
            jVarF.Z(1);
        } else {
            jVarF.l(1, str);
        }
        jVarF.z(2, j5);
        Cursor cursorP = this.f14589a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("isChild");
            if (cursorP.moveToFirst()) {
                packageLimit = new PackageLimit();
                packageLimit.setId(cursorP.getLong(columnIndexOrThrow));
                packageLimit.setPackageName(cursorP.getString(columnIndexOrThrow2));
                packageLimit.setWorkdayLimit(cursorP.getLong(columnIndexOrThrow3));
                packageLimit.setOffDayLimit(cursorP.getLong(columnIndexOrThrow4));
                packageLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow5) != 0);
                packageLimit.setState(cursorP.getInt(columnIndexOrThrow6));
                packageLimit.setInterval(cursorP.getInt(columnIndexOrThrow7));
                packageLimit.setEnable(cursorP.getInt(columnIndexOrThrow8) != 0);
                packageLimit.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                packageLimit.setAdminId(cursorP.getLong(columnIndexOrThrow10));
                packageLimit.setChild(cursorP.getInt(columnIndexOrThrow11) != 0);
            } else {
                packageLimit = null;
            }
            return packageLimit;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
