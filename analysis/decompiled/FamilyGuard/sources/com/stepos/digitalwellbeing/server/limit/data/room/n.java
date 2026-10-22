package com.stepos.digitalwellbeing.server.limit.data.room;

import android.database.Cursor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class n extends m {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f14635a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f14636b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f14637c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f14638d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f14639e;

    class a extends Z.d<o> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `suspended_record`(`packageName`,`flags`,`updateTime`) VALUES (?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, o oVar) {
            String str = oVar.f14644a;
            if (str == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.l(1, str);
            }
            interfaceC0651f.z(2, oVar.f14645b);
            interfaceC0651f.z(3, oVar.f14646c);
        }
    }

    class b extends Z.c<o> {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR REPLACE `suspended_record` SET `packageName` = ?,`flags` = ?,`updateTime` = ? WHERE `packageName` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, o oVar) {
            String str = oVar.f14644a;
            if (str == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.l(1, str);
            }
            interfaceC0651f.z(2, oVar.f14645b);
            interfaceC0651f.z(3, oVar.f14646c);
            String str2 = oVar.f14644a;
            if (str2 == null) {
                interfaceC0651f.Z(4);
            } else {
                interfaceC0651f.l(4, str2);
            }
        }
    }

    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM suspended_record WHERE packageName = ?";
        }
    }

    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM suspended_record";
        }
    }

    public n(Z.g gVar) {
        this.f14635a = gVar;
        this.f14636b = new a(gVar);
        this.f14637c = new b(gVar);
        this.f14638d = new c(gVar);
        this.f14639e = new d(gVar);
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.m
    public List<o> a() {
        Z.j jVarF = Z.j.f("SELECT * FROM suspended_record", 0);
        Cursor cursorP = this.f14635a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("flags");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("updateTime");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                o oVar = new o();
                oVar.f14644a = cursorP.getString(columnIndexOrThrow);
                oVar.f14645b = cursorP.getInt(columnIndexOrThrow2);
                oVar.f14646c = cursorP.getLong(columnIndexOrThrow3);
                arrayList.add(oVar);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // com.stepos.digitalwellbeing.server.limit.data.room.m
    public void b(List<o> list) {
        this.f14635a.b();
        try {
            this.f14636b.h(list);
            this.f14635a.s();
        } finally {
            this.f14635a.f();
        }
    }
}
