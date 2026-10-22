package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14598a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14599b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14600c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f14601d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14602e;

    class a extends Z.d<PeriodLimit> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PeriodLimit`(`id`,`type`,`packageName`,`categoryId`,`adminId`,`notifyOnly`,`isChild`,`enable`,`version`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PeriodLimit periodLimit) {
            interfaceC0651f.z(1, periodLimit.getId());
            interfaceC0651f.z(2, periodLimit.getType());
            if (periodLimit.getPackageName() == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.l(3, periodLimit.getPackageName());
            }
            interfaceC0651f.z(4, periodLimit.getCategoryId());
            interfaceC0651f.z(5, periodLimit.getAdminId());
            interfaceC0651f.z(6, periodLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(7, periodLimit.isChild() ? 1L : 0L);
            interfaceC0651f.z(8, periodLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(9, periodLimit.getVersion());
        }
    }

    class b extends Z.c<PeriodLimit> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `PeriodLimit` SET `id` = ?,`type` = ?,`packageName` = ?,`categoryId` = ?,`adminId` = ?,`notifyOnly` = ?,`isChild` = ?,`enable` = ?,`version` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PeriodLimit periodLimit) {
            interfaceC0651f.z(1, periodLimit.getId());
            interfaceC0651f.z(2, periodLimit.getType());
            if (periodLimit.getPackageName() == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.l(3, periodLimit.getPackageName());
            }
            interfaceC0651f.z(4, periodLimit.getCategoryId());
            interfaceC0651f.z(5, periodLimit.getAdminId());
            interfaceC0651f.z(6, periodLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(7, periodLimit.isChild() ? 1L : 0L);
            interfaceC0651f.z(8, periodLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(9, periodLimit.getVersion());
            interfaceC0651f.z(10, periodLimit.getId());
        }
    }

    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM PeriodLimit WHERE id = (?)";
        }
    }

    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM PeriodLimit WHERE adminId = (?)";
        }
    }

    public h(Z.g gVar) {
        this.f14598a = gVar;
        this.f14599b = new a(gVar);
        this.f14600c = new b(gVar);
        this.f14601d = new c(gVar);
        this.f14602e = new d(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public PeriodLimit a(long j5, long j6) {
        PeriodLimit periodLimit;
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimit WHERE adminId = (?) AND categoryId = (?) AND type = 1", 2);
        boolean z5 = true;
        jVarF.z(1, j6);
        jVarF.z(2, j5);
        Cursor cursorP = this.f14598a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("isChild");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("version");
            if (cursorP.moveToFirst()) {
                periodLimit = new PeriodLimit();
                periodLimit.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimit.setType(cursorP.getInt(columnIndexOrThrow2));
                periodLimit.setPackageName(cursorP.getString(columnIndexOrThrow3));
                periodLimit.setCategoryId(cursorP.getLong(columnIndexOrThrow4));
                periodLimit.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                periodLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                periodLimit.setChild(cursorP.getInt(columnIndexOrThrow7) != 0);
                if (cursorP.getInt(columnIndexOrThrow8) == 0) {
                    z5 = false;
                }
                periodLimit.setEnable(z5);
                periodLimit.setVersion(cursorP.getLong(columnIndexOrThrow9));
            } else {
                periodLimit = null;
            }
            return periodLimit;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public void c(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14602e.a();
        this.f14598a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14598a.s();
        } finally {
            this.f14598a.f();
            this.f14602e.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public PeriodLimit d(String str, long j5) {
        PeriodLimit periodLimit;
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimit WHERE adminId = (?) AND packageName = (?) AND type = 0", 2);
        boolean z5 = true;
        jVarF.z(1, j5);
        if (str == null) {
            jVarF.Z(2);
        } else {
            jVarF.l(2, str);
        }
        Cursor cursorP = this.f14598a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("isChild");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("version");
            if (cursorP.moveToFirst()) {
                periodLimit = new PeriodLimit();
                periodLimit.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimit.setType(cursorP.getInt(columnIndexOrThrow2));
                periodLimit.setPackageName(cursorP.getString(columnIndexOrThrow3));
                periodLimit.setCategoryId(cursorP.getLong(columnIndexOrThrow4));
                periodLimit.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                periodLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                periodLimit.setChild(cursorP.getInt(columnIndexOrThrow7) != 0);
                if (cursorP.getInt(columnIndexOrThrow8) == 0) {
                    z5 = false;
                }
                periodLimit.setEnable(z5);
                periodLimit.setVersion(cursorP.getLong(columnIndexOrThrow9));
            } else {
                periodLimit = null;
            }
            return periodLimit;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public PeriodLimit e(long j5) {
        PeriodLimit periodLimit;
        boolean z5 = true;
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimit WHERE type = 2 AND adminId = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14598a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("isChild");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("version");
            if (cursorP.moveToFirst()) {
                periodLimit = new PeriodLimit();
                periodLimit.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimit.setType(cursorP.getInt(columnIndexOrThrow2));
                periodLimit.setPackageName(cursorP.getString(columnIndexOrThrow3));
                periodLimit.setCategoryId(cursorP.getLong(columnIndexOrThrow4));
                periodLimit.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                periodLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                periodLimit.setChild(cursorP.getInt(columnIndexOrThrow7) != 0);
                if (cursorP.getInt(columnIndexOrThrow8) == 0) {
                    z5 = false;
                }
                periodLimit.setEnable(z5);
                periodLimit.setVersion(cursorP.getLong(columnIndexOrThrow9));
            } else {
                periodLimit = null;
            }
            return periodLimit;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public void f(PeriodLimit periodLimit) {
        this.f14598a.b();
        try {
            this.f14600c.h(periodLimit);
            this.f14598a.s();
        } finally {
            this.f14598a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public long g(PeriodLimit periodLimit) {
        this.f14598a.b();
        try {
            long j5 = this.f14599b.j(periodLimit);
            this.f14598a.s();
            return j5;
        } finally {
            this.f14598a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public List<PeriodLimit> h(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimit WHERE type = (?) AND adminId = (?)", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        Cursor cursorP = this.f14598a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("isChild");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("version");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                PeriodLimit periodLimit = new PeriodLimit();
                periodLimit.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimit.setType(cursorP.getInt(columnIndexOrThrow2));
                periodLimit.setPackageName(cursorP.getString(columnIndexOrThrow3));
                periodLimit.setCategoryId(cursorP.getLong(columnIndexOrThrow4));
                periodLimit.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                boolean z5 = false;
                periodLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                periodLimit.setChild(cursorP.getInt(columnIndexOrThrow7) != 0);
                if (cursorP.getInt(columnIndexOrThrow8) != 0) {
                    z5 = true;
                }
                periodLimit.setEnable(z5);
                periodLimit.setVersion(cursorP.getLong(columnIndexOrThrow9));
                arrayList.add(periodLimit);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.g
    public PeriodLimit i(long j5) {
        PeriodLimit periodLimit;
        boolean z5 = true;
        Z.j jVarF = Z.j.f("SELECT * FROM PeriodLimit WHERE id = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14598a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("categoryId");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("isChild");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("version");
            if (cursorP.moveToFirst()) {
                periodLimit = new PeriodLimit();
                periodLimit.setId(cursorP.getLong(columnIndexOrThrow));
                periodLimit.setType(cursorP.getInt(columnIndexOrThrow2));
                periodLimit.setPackageName(cursorP.getString(columnIndexOrThrow3));
                periodLimit.setCategoryId(cursorP.getLong(columnIndexOrThrow4));
                periodLimit.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                periodLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow6) != 0);
                periodLimit.setChild(cursorP.getInt(columnIndexOrThrow7) != 0);
                if (cursorP.getInt(columnIndexOrThrow8) == 0) {
                    z5 = false;
                }
                periodLimit.setEnable(z5);
                periodLimit.setVersion(cursorP.getLong(columnIndexOrThrow9));
            } else {
                periodLimit = null;
            }
            return periodLimit;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
