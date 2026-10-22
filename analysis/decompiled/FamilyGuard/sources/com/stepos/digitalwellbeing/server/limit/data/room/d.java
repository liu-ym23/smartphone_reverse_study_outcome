package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;

/* loaded from: classes.dex */
public final class d implements com.stepos.digitalwellbeing.server.limit.data.room.c {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14578a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14579b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14580c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.c f14581d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14582e;

    /* renamed from: f, reason: collision with root package name */
    private final Z.l f14583f;

    class a extends Z.d<GlobalLimit> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `GlobalLimit`(`id`,`workdayLimit`,`offDayLimit`,`notifyOnly`,`state`,`enable`,`interval`,`lastHandleTime`,`adminId`,`isChild`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, GlobalLimit globalLimit) {
            interfaceC0651f.z(1, globalLimit.getId());
            interfaceC0651f.z(2, globalLimit.getWorkdayLimit());
            interfaceC0651f.z(3, globalLimit.getOffDayLimit());
            interfaceC0651f.z(4, globalLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(5, globalLimit.getState());
            interfaceC0651f.z(6, globalLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(7, globalLimit.getInterval());
            interfaceC0651f.z(8, globalLimit.getLastHandleTime());
            interfaceC0651f.z(9, globalLimit.getAdminId());
            interfaceC0651f.z(10, globalLimit.isChild() ? 1L : 0L);
        }
    }

    class b extends Z.c<GlobalLimit> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM `GlobalLimit` WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, GlobalLimit globalLimit) {
            interfaceC0651f.z(1, globalLimit.getId());
        }
    }

    class c extends Z.c<GlobalLimit> {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR REPLACE `GlobalLimit` SET `id` = ?,`workdayLimit` = ?,`offDayLimit` = ?,`notifyOnly` = ?,`state` = ?,`enable` = ?,`interval` = ?,`lastHandleTime` = ?,`adminId` = ?,`isChild` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, GlobalLimit globalLimit) {
            interfaceC0651f.z(1, globalLimit.getId());
            interfaceC0651f.z(2, globalLimit.getWorkdayLimit());
            interfaceC0651f.z(3, globalLimit.getOffDayLimit());
            interfaceC0651f.z(4, globalLimit.isNotifyOnly() ? 1L : 0L);
            interfaceC0651f.z(5, globalLimit.getState());
            interfaceC0651f.z(6, globalLimit.isEnable() ? 1L : 0L);
            interfaceC0651f.z(7, globalLimit.getInterval());
            interfaceC0651f.z(8, globalLimit.getLastHandleTime());
            interfaceC0651f.z(9, globalLimit.getAdminId());
            interfaceC0651f.z(10, globalLimit.isChild() ? 1L : 0L);
            interfaceC0651f.z(11, globalLimit.getId());
        }
    }

    /* renamed from: com.stepos.digitalwellbeing.server.limit.data.room.d$d, reason: collision with other inner class name */
    class C0180d extends Z.l {
        C0180d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM globallimit WHERE id = ?";
        }
    }

    class e extends Z.l {
        e(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM globallimit WHERE adminId = ?";
        }
    }

    public d(Z.g gVar) {
        this.f14578a = gVar;
        this.f14579b = new a(gVar);
        this.f14580c = new b(gVar);
        this.f14581d = new c(gVar);
        this.f14582e = new C0180d(gVar);
        this.f14583f = new e(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.c
    public long a(GlobalLimit globalLimit) {
        this.f14578a.b();
        try {
            long j5 = this.f14579b.j(globalLimit);
            this.f14578a.s();
            return j5;
        } finally {
            this.f14578a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.c
    public void b(GlobalLimit globalLimit) {
        this.f14578a.b();
        try {
            this.f14581d.h(globalLimit);
            this.f14578a.s();
        } finally {
            this.f14578a.f();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.c
    public GlobalLimit c(long j5) {
        GlobalLimit globalLimit;
        boolean z5 = true;
        Z.j jVarF = Z.j.f("SELECT * FROM globallimit WHERE adminId = ?", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f14578a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("workdayLimit");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("offDayLimit");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("notifyOnly");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("enable");
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("interval");
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("lastHandleTime");
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("adminId");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("isChild");
            if (cursorP.moveToFirst()) {
                globalLimit = new GlobalLimit();
                globalLimit.setId(cursorP.getLong(columnIndexOrThrow));
                globalLimit.setWorkdayLimit(cursorP.getLong(columnIndexOrThrow2));
                globalLimit.setOffDayLimit(cursorP.getLong(columnIndexOrThrow3));
                globalLimit.setNotifyOnly(cursorP.getInt(columnIndexOrThrow4) != 0);
                globalLimit.setState(cursorP.getInt(columnIndexOrThrow5));
                globalLimit.setEnable(cursorP.getInt(columnIndexOrThrow6) != 0);
                globalLimit.setInterval(cursorP.getInt(columnIndexOrThrow7));
                globalLimit.setLastHandleTime(cursorP.getLong(columnIndexOrThrow8));
                globalLimit.setAdminId(cursorP.getLong(columnIndexOrThrow9));
                if (cursorP.getInt(columnIndexOrThrow10) == 0) {
                    z5 = false;
                }
                globalLimit.setChild(z5);
            } else {
                globalLimit = null;
            }
            return globalLimit;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.c
    public void d(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f14583f.a();
        this.f14578a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.n();
            this.f14578a.s();
        } finally {
            this.f14578a.f();
            this.f14583f.f(interfaceC0651fA);
        }
    }
}
