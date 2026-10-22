package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b implements com.stepos.digitalwellbeing.server.limit.data.room.a {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14567a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14568b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14569c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.c f14570d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14571e;

    /* renamed from: f, reason: collision with root package name */
    private final Z.l f14572f;

    class a extends Z.d<CategoryLimit> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `CategoryLimit`(`id`,`categoryId`,`workdayLimit`,`offDayLimit`,`notifyOnly`,`state`,`enable`,`interval`,`lastHandleTime`,`adminId`,`isChild`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, CategoryLimit categoryLimit) {
            interfaceC0651f.z(1, categoryLimit.getId());
            interfaceC0651f.z(2, categoryLimit.getCategoryId());
            interfaceC0651f.z(3, categoryLimit.getWorkdayLimit());
            interfaceC0651f.z(4, categoryLimit.getOffDayLimit());
            interfaceC0651f.z(5, categoryLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(6, categoryLimit.getState());
            interfaceC0651f.z(7, categoryLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(8, categoryLimit.getInterval());
            interfaceC0651f.z(9, categoryLimit.getLastHandleTime());
            interfaceC0651f.z(10, categoryLimit.getAdminId());
            interfaceC0651f.z(11, categoryLimit.isChild() ? 1L : 0L);
        }
    }

    /* renamed from: com.stepos.digitalwellbeing.server.limit.data.room.b$b, reason: collision with other inner class name */
    class C0179b extends Z.c<CategoryLimit> {
        C0179b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM `CategoryLimit` WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, CategoryLimit categoryLimit) {
            interfaceC0651f.z(1, categoryLimit.getId());
        }
    }

    class c extends Z.c<CategoryLimit> {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `CategoryLimit` SET `id` = ?,`categoryId` = ?,`workdayLimit` = ?,`offDayLimit` = ?,`notifyOnly` = ?,`state` = ?,`enable` = ?,`interval` = ?,`lastHandleTime` = ?,`adminId` = ?,`isChild` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, CategoryLimit categoryLimit) {
            interfaceC0651f.z(1, categoryLimit.getId());
            interfaceC0651f.z(2, categoryLimit.getCategoryId());
            interfaceC0651f.z(3, categoryLimit.getWorkdayLimit());
            interfaceC0651f.z(4, categoryLimit.getOffDayLimit());
            interfaceC0651f.z(5, categoryLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(6, categoryLimit.getState());
            interfaceC0651f.z(7, categoryLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(8, categoryLimit.getInterval());
            interfaceC0651f.z(9, categoryLimit.getLastHandleTime());
            interfaceC0651f.z(10, categoryLimit.getAdminId());
            interfaceC0651f.z(11, categoryLimit.isChild() ? 1L : 0L);
            interfaceC0651f.z(12, categoryLimit.getId());
        }
    }

    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM categorylimit WHERE adminId = (?)";
        }
    }

    class e extends Z.l {
        e(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM categorylimit";
        }
    }

    public b(Z.g gVar) {
        this.f14567a = gVar;
        this.f14568b = new a(gVar);
        this.f14569c = new C0179b(gVar);
        this.f14570d = new c(gVar);
        this.f14571e = new d(gVar);
        this.f14572f = new e(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public List<CategoryLimit> a(long j5) throws Throwable {
        Z.j jVar;
        Z.j jVarF = Z.j.f("SELECT * FROM categorylimit WHERE adminId = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14567a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("isChild");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                CategoryLimit categoryLimit = new CategoryLimit();
                jVar = jVarF;
                try {
                    categoryLimit.setId(cursorP.getLong(columnIndexOrThrow));
                    categoryLimit.setCategoryId(cursorP.getInt(columnIndexOrThrow2));
                    categoryLimit.setWorkdayLimit(cursorP.getLong(columnIndexOrThrow3));
                    categoryLimit.setOffDayLimit(cursorP.getLong(columnIndexOrThrow4));
                    categoryLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow5) != 0);
                    categoryLimit.setState(cursorP.getInt(columnIndexOrThrow6));
                    categoryLimit.setEnable(cursorP.getInt(columnIndexOrThrow7) != 0);
                    categoryLimit.setInterval(cursorP.getInt(columnIndexOrThrow8));
                    int i5 = columnIndexOrThrow;
                    categoryLimit.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                    categoryLimit.setAdminId(cursorP.getLong(columnIndexOrThrow10));
                    categoryLimit.setChild(cursorP.getInt(columnIndexOrThrow11) != 0);
                    arrayList.add(categoryLimit);
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

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public void b() {
        InterfaceC0651f interfaceC0651fA = this.f14572f.a();
        this.f14567a.b();
        try {
            interfaceC0651fA.n();
            this.f14567a.s();
        } finally {
            this.f14567a.f();
            this.f14572f.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public void c(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14571e.a();
        this.f14567a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14567a.s();
        } finally {
            this.f14567a.f();
            this.f14571e.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public long d(CategoryLimit categoryLimit) {
        this.f14567a.b();
        try {
            long j5 = this.f14568b.j(categoryLimit);
            this.f14567a.s();
            return j5;
        } finally {
            this.f14567a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public void e(CategoryLimit categoryLimit) {
        this.f14567a.b();
        try {
            this.f14570d.h(categoryLimit);
            this.f14567a.s();
        } finally {
            this.f14567a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public CategoryLimit f(long j5) throws Throwable {
        Z.j jVar;
        CategoryLimit categoryLimit;
        Z.j jVarF = Z.j.f("SELECT * FROM categorylimit WHERE id = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14567a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("isChild");
            if (cursorP.moveToFirst()) {
                categoryLimit = new CategoryLimit();
                jVar = jVarF;
                try {
                    categoryLimit.setId(cursorP.getLong(columnIndexOrThrow));
                    categoryLimit.setCategoryId(cursorP.getInt(columnIndexOrThrow2));
                    categoryLimit.setWorkdayLimit(cursorP.getLong(columnIndexOrThrow3));
                    categoryLimit.setOffDayLimit(cursorP.getLong(columnIndexOrThrow4));
                    categoryLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow5) != 0);
                    categoryLimit.setState(cursorP.getInt(columnIndexOrThrow6));
                    categoryLimit.setEnable(cursorP.getInt(columnIndexOrThrow7) != 0);
                    categoryLimit.setInterval(cursorP.getInt(columnIndexOrThrow8));
                    categoryLimit.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                    categoryLimit.setAdminId(cursorP.getLong(columnIndexOrThrow10));
                    categoryLimit.setChild(cursorP.getInt(columnIndexOrThrow11) != 0);
                } catch (Throwable th) {
                    th = th;
                    cursorP.close();
                    jVar.r();
                    throw th;
                }
            } else {
                jVar = jVarF;
                categoryLimit = null;
            }
            cursorP.close();
            jVar.r();
            return categoryLimit;
        } catch (Throwable th2) {
            th = th2;
            jVar = jVarF;
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.a
    public CategoryLimit g(int i5, long j5) throws Throwable {
        Z.j jVar;
        CategoryLimit categoryLimit;
        Z.j jVarF = Z.j.f("SELECT * FROM categorylimit WHERE categoryId = (?) AND adminId = (?)", 2);
        boolean z5 = true;
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        Cursor cursorP = this.f14567a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("isChild");
            if (cursorP.moveToFirst()) {
                categoryLimit = new CategoryLimit();
                jVar = jVarF;
                try {
                    categoryLimit.setId(cursorP.getLong(columnIndexOrThrow));
                    categoryLimit.setCategoryId(cursorP.getInt(columnIndexOrThrow2));
                    categoryLimit.setWorkdayLimit(cursorP.getLong(columnIndexOrThrow3));
                    categoryLimit.setOffDayLimit(cursorP.getLong(columnIndexOrThrow4));
                    categoryLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow5) != 0);
                    categoryLimit.setState(cursorP.getInt(columnIndexOrThrow6));
                    categoryLimit.setEnable(cursorP.getInt(columnIndexOrThrow7) != 0);
                    categoryLimit.setInterval(cursorP.getInt(columnIndexOrThrow8));
                    categoryLimit.setLastHandleTime(cursorP.getLong(columnIndexOrThrow9));
                    categoryLimit.setAdminId(cursorP.getLong(columnIndexOrThrow10));
                    if (cursorP.getInt(columnIndexOrThrow11) == 0) {
                        z5 = false;
                    }
                    categoryLimit.setChild(z5);
                } catch (Throwable th) {
                    th = th;
                    cursorP.close();
                    jVar.r();
                    throw th;
                }
            } else {
                jVar = jVarF;
                categoryLimit = null;
            }
            cursorP.close();
            jVar.r();
            return categoryLimit;
        } catch (Throwable th2) {
            th = th2;
            jVar = jVarF;
        }
    }
}
