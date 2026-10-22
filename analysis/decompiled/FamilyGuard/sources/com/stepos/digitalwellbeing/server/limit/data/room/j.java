package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14607a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14608b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14609c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f14610d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14611e;

    class a extends Z.d<RawPeriod> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `RawPeriod`(`id`,`weekDayType`,`start`,`end`,`limitId`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, RawPeriod rawPeriod) {
            interfaceC0651f.z(1, rawPeriod.getId());
            interfaceC0651f.z(2, rawPeriod.getWeekDayType());
            interfaceC0651f.z(3, rawPeriod.getStart());
            interfaceC0651f.z(4, rawPeriod.getEnd());
            interfaceC0651f.z(5, rawPeriod.getLimitId());
        }
    }

    class b extends Z.c<RawPeriod> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `RawPeriod` SET `id` = ?,`weekDayType` = ?,`start` = ?,`end` = ?,`limitId` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, RawPeriod rawPeriod) {
            interfaceC0651f.z(1, rawPeriod.getId());
            interfaceC0651f.z(2, rawPeriod.getWeekDayType());
            interfaceC0651f.z(3, rawPeriod.getStart());
            interfaceC0651f.z(4, rawPeriod.getEnd());
            interfaceC0651f.z(5, rawPeriod.getLimitId());
            interfaceC0651f.z(6, rawPeriod.getId());
        }
    }

    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RawPeriod WHERE id = (?)";
        }
    }

    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM RawPeriod WHERE limitId = (?)";
        }
    }

    public j(Z.g gVar) {
        this.f14607a = gVar;
        this.f14608b = new a(gVar);
        this.f14609c = new b(gVar);
        this.f14610d = new c(gVar);
        this.f14611e = new d(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.i
    public void a(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14610d.a();
        this.f14607a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14607a.s();
        } finally {
            this.f14607a.f();
            this.f14610d.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.i
    public List<RawPeriod> b(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RawPeriod WHERE limitId = (?)", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14607a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("weekDayType");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("start");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("end");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("limitId");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RawPeriod rawPeriod = new RawPeriod();
                rawPeriod.setId(cursorP.getLong(columnIndexOrThrow));
                rawPeriod.setWeekDayType(cursorP.getInt(columnIndexOrThrow2));
                rawPeriod.setStart(cursorP.getLong(columnIndexOrThrow3));
                rawPeriod.setEnd(cursorP.getLong(columnIndexOrThrow4));
                rawPeriod.setLimitId(cursorP.getLong(columnIndexOrThrow5));
                arrayList.add(rawPeriod);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.i
    public void c(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14611e.a();
        this.f14607a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14607a.s();
        } finally {
            this.f14607a.f();
            this.f14611e.f(interfaceC0651fA);
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.i
    public long d(RawPeriod rawPeriod) {
        this.f14607a.b();
        try {
            long j5 = this.f14608b.j(rawPeriod);
            this.f14607a.s();
            return j5;
        } finally {
            this.f14607a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.i
    public void e(RawPeriod rawPeriod) {
        this.f14607a.b();
        try {
            this.f14609c.h(rawPeriod);
            this.f14607a.s();
        } finally {
            this.f14607a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.i
    public List<RawPeriod> f(long j5, int i5) {
        Z.j jVarF = Z.j.f("SELECT * FROM RawPeriod WHERE limitId = (?) AND weekDayType = (?)", 2);
        jVarF.z(1, j5);
        jVarF.z(2, i5);
        Cursor cursorP = this.f14607a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("weekDayType");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("start");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("end");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("limitId");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                RawPeriod rawPeriod = new RawPeriod();
                rawPeriod.setId(cursorP.getLong(columnIndexOrThrow));
                rawPeriod.setWeekDayType(cursorP.getInt(columnIndexOrThrow2));
                rawPeriod.setStart(cursorP.getLong(columnIndexOrThrow3));
                rawPeriod.setEnd(cursorP.getLong(columnIndexOrThrow4));
                rawPeriod.setLimitId(cursorP.getLong(columnIndexOrThrow5));
                arrayList.add(rawPeriod);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
