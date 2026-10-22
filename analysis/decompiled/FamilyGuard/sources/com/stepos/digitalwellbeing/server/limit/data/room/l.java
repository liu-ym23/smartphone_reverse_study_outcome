package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14616a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14617b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14618c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f14619d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14620e;

    /* renamed from: f, reason: collision with root package name */
    private final Z.l f14621f;

    /* renamed from: g, reason: collision with root package name */
    private final Z.l f14622g;

    /* renamed from: h, reason: collision with root package name */
    private final Z.l f14623h;

    /* renamed from: i, reason: collision with root package name */
    private final Z.l f14624i;

    /* renamed from: j, reason: collision with root package name */
    private final Z.l f14625j;

    class a extends Z.d<RipePeriod> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `RipePeriod`(`id`,`time`,`limitId`,`limitType`,`adminId`,`limitPackageName`,`limitCategoryId`,`version`,`type`,`mergedWeekDayType`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, RipePeriod ripePeriod) {
            interfaceC0651f.z(1, ripePeriod.getId());
            interfaceC0651f.z(2, ripePeriod.getTime());
            interfaceC0651f.z(3, ripePeriod.getLimitId());
            interfaceC0651f.z(4, ripePeriod.getLimitType());
            interfaceC0651f.z(5, ripePeriod.getAdminId());
            if (ripePeriod.getLimitPackageName() == null) {
                interfaceC0651f.Z(6);
            } else {
                interfaceC0651f.l(6, ripePeriod.getLimitPackageName());
            }
            interfaceC0651f.z(7, ripePeriod.getLimitCategoryId());
            interfaceC0651f.z(8, ripePeriod.getVersion());
            interfaceC0651f.z(9, ripePeriod.getType());
            interfaceC0651f.z(10, ripePeriod.getMergedWeekDayType());
        }
    }

    class b extends Z.c<RipePeriod> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `RipePeriod` SET `id` = ?,`time` = ?,`limitId` = ?,`limitType` = ?,`adminId` = ?,`limitPackageName` = ?,`limitCategoryId` = ?,`version` = ?,`type` = ?,`mergedWeekDayType` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, RipePeriod ripePeriod) {
            interfaceC0651f.z(1, ripePeriod.getId());
            interfaceC0651f.z(2, ripePeriod.getTime());
            interfaceC0651f.z(3, ripePeriod.getLimitId());
            interfaceC0651f.z(4, ripePeriod.getLimitType());
            interfaceC0651f.z(5, ripePeriod.getAdminId());
            if (ripePeriod.getLimitPackageName() == null) {
                interfaceC0651f.Z(6);
            } else {
                interfaceC0651f.l(6, ripePeriod.getLimitPackageName());
            }
            interfaceC0651f.z(7, ripePeriod.getLimitCategoryId());
            interfaceC0651f.z(8, ripePeriod.getVersion());
            interfaceC0651f.z(9, ripePeriod.getType());
            interfaceC0651f.z(10, ripePeriod.getMergedWeekDayType());
            interfaceC0651f.z(11, ripePeriod.getId());
        }
    }

    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE id = (?)";
        }
    }

    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE limitId = (?)";
        }
    }

    class e extends Z.l {
        e(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE limitId = (?) AND version = (?)";
        }
    }

    class f extends Z.l {
        f(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE adminId = (?) AND limitPackageName = (?) AND limitType = 0";
        }
    }

    class g extends Z.l {
        g(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE adminId = (?) AND limitPackageName = (?) AND limitType = 0 AND version = (?)";
        }
    }

    class h extends Z.l {
        h(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE adminId = (?) AND limitCategoryId = (?)  AND limitType = 1";
        }
    }

    class i extends Z.l {
        i(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RipePeriod WHERE adminId = (?) AND limitCategoryId = (?)  AND limitType = 1  AND version = (?)";
        }
    }

    public l(Z.g gVar) {
        this.f14616a = gVar;
        this.f14617b = new a(gVar);
        this.f14618c = new b(gVar);
        this.f14619d = new c(gVar);
        this.f14620e = new d(gVar);
        this.f14621f = new e(gVar);
        this.f14622g = new f(gVar);
        this.f14623h = new g(gVar);
        this.f14624i = new h(gVar);
        this.f14625j = new i(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public void a(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14619d.a();
        this.f14616a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14616a.s();
        } finally {
            this.f14616a.f();
            this.f14619d.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public List<RipePeriod> b(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RipePeriod WHERE limitId = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14616a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("time");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("limitId");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("limitType");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitPackageName");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("limitCategoryId");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("version");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("mergedWeekDayType");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RipePeriod ripePeriod = new RipePeriod();
                ripePeriod.setId(cursorP.getLong(columnIndexOrThrow));
                ripePeriod.setTime(cursorP.getLong(columnIndexOrThrow2));
                ripePeriod.setLimitId(cursorP.getLong(columnIndexOrThrow3));
                ripePeriod.setLimitType(cursorP.getInt(columnIndexOrThrow4));
                ripePeriod.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                ripePeriod.setLimitPackageName(cursorP.getString(columnIndexOrThrow6));
                ripePeriod.setLimitCategoryId(cursorP.getLong(columnIndexOrThrow7));
                ripePeriod.setVersion(cursorP.getLong(columnIndexOrThrow8));
                ripePeriod.setType(cursorP.getInt(columnIndexOrThrow9));
                ripePeriod.setMergedWeekDayType(cursorP.getInt(columnIndexOrThrow10));
                arrayList.add(ripePeriod);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public long c(long j5, long j6) {
        Z.j jVarF = Z.j.f("SELECT MAX(version) FROM RipePeriod WHERE adminId = (?) AND limitId = (?)", 2);
        jVarF.z(1, j5);
        jVarF.z(2, j6);
        Cursor cursorP = this.f14616a.p(jVarF);
        try {
            return cursorP.moveToFirst() ? cursorP.getLong(0) : 0L;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public List<RipePeriod> d(long j5, long j6, long j7, int i5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RipePeriod WHERE adminId = (?) AND limitCategoryId = (?)  AND limitType = 1 AND version = (?) AND mergedWeekDayType = (?)", 4);
        jVarF.z(1, j5);
        jVarF.z(2, j6);
        jVarF.z(3, j7);
        jVarF.z(4, i5);
        Cursor cursorP = this.f14616a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("time");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("limitId");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("limitType");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitPackageName");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("limitCategoryId");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("version");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("mergedWeekDayType");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RipePeriod ripePeriod = new RipePeriod();
                ripePeriod.setId(cursorP.getLong(columnIndexOrThrow));
                ripePeriod.setTime(cursorP.getLong(columnIndexOrThrow2));
                ripePeriod.setLimitId(cursorP.getLong(columnIndexOrThrow3));
                ripePeriod.setLimitType(cursorP.getInt(columnIndexOrThrow4));
                ripePeriod.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                ripePeriod.setLimitPackageName(cursorP.getString(columnIndexOrThrow6));
                ripePeriod.setLimitCategoryId(cursorP.getLong(columnIndexOrThrow7));
                ripePeriod.setVersion(cursorP.getLong(columnIndexOrThrow8));
                ripePeriod.setType(cursorP.getInt(columnIndexOrThrow9));
                ripePeriod.setMergedWeekDayType(cursorP.getInt(columnIndexOrThrow10));
                arrayList.add(ripePeriod);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public List<RipePeriod> e(long j5, long j6, int i5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RipePeriod WHERE limitId = (?) AND version = (?) AND mergedWeekDayType = (?)", 3);
        jVarF.z(1, j5);
        jVarF.z(2, j6);
        jVarF.z(3, i5);
        Cursor cursorP = this.f14616a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("time");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("limitId");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("limitType");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitPackageName");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("limitCategoryId");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("version");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("mergedWeekDayType");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RipePeriod ripePeriod = new RipePeriod();
                ripePeriod.setId(cursorP.getLong(columnIndexOrThrow));
                ripePeriod.setTime(cursorP.getLong(columnIndexOrThrow2));
                ripePeriod.setLimitId(cursorP.getLong(columnIndexOrThrow3));
                ripePeriod.setLimitType(cursorP.getInt(columnIndexOrThrow4));
                ripePeriod.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                ripePeriod.setLimitPackageName(cursorP.getString(columnIndexOrThrow6));
                ripePeriod.setLimitCategoryId(cursorP.getLong(columnIndexOrThrow7));
                ripePeriod.setVersion(cursorP.getLong(columnIndexOrThrow8));
                ripePeriod.setType(cursorP.getInt(columnIndexOrThrow9));
                ripePeriod.setMergedWeekDayType(cursorP.getInt(columnIndexOrThrow10));
                arrayList.add(ripePeriod);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public long f(RipePeriod ripePeriod) {
        this.f14616a.b();
        try {
            long j5 = this.f14617b.j(ripePeriod);
            this.f14616a.s();
            return j5;
        } finally {
            this.f14616a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public void g(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14620e.a();
        this.f14616a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14616a.s();
        } finally {
            this.f14616a.f();
            this.f14620e.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.k
    public List<RipePeriod> h(long j5, String str, long j6, int i5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RipePeriod WHERE adminId = (?) AND limitPackageName = (?)  AND mergedWeekDayType = (?) AND version = (?)", 4);
        jVarF.z(1, j5);
        if (str == null) {
            jVarF.Z(2);
        } else {
            jVarF.l(2, str);
        }
        jVarF.z(3, i5);
        jVarF.z(4, j6);
        Cursor cursorP = this.f14616a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("time");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("limitId");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("limitType");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("limitPackageName");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("limitCategoryId");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("version");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("mergedWeekDayType");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RipePeriod ripePeriod = new RipePeriod();
                ripePeriod.setId(cursorP.getLong(columnIndexOrThrow));
                ripePeriod.setTime(cursorP.getLong(columnIndexOrThrow2));
                ripePeriod.setLimitId(cursorP.getLong(columnIndexOrThrow3));
                ripePeriod.setLimitType(cursorP.getInt(columnIndexOrThrow4));
                ripePeriod.setAdminId(cursorP.getLong(columnIndexOrThrow5));
                ripePeriod.setLimitPackageName(cursorP.getString(columnIndexOrThrow6));
                ripePeriod.setLimitCategoryId(cursorP.getLong(columnIndexOrThrow7));
                ripePeriod.setVersion(cursorP.getLong(columnIndexOrThrow8));
                ripePeriod.setType(cursorP.getInt(columnIndexOrThrow9));
                ripePeriod.setMergedWeekDayType(cursorP.getInt(columnIndexOrThrow10));
                arrayList.add(ripePeriod);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
