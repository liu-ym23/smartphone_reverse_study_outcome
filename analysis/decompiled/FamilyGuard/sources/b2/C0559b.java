package b2;

import Z.g;
import Z.j;
import android.database.Cursor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0559b extends AbstractC0558a {

    /* renamed from: a, reason: collision with root package name */
    private final g f11805a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f11806b;

    /* renamed from: b2.b$a */
    class a extends Z.d<C0560c> {
        a(g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `WorkdayAdjustEntity`(`time`,`workday`) VALUES (?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0560c c0560c) {
            interfaceC0651f.z(1, c0560c.f11808a);
            interfaceC0651f.z(2, c0560c.f11809b ? 1L : 0L);
        }
    }

    public C0559b(g gVar) {
        this.f11805a = gVar;
        this.f11806b = new a(gVar);
    }

    @Override // b2.AbstractC0558a
    public long a(C0560c c0560c) {
        this.f11805a.b();
        try {
            long j5 = this.f11806b.j(c0560c);
            this.f11805a.s();
            return j5;
        } finally {
            this.f11805a.f();
        }
    }

    @Override // b2.AbstractC0558a
    public List<C0560c> b() {
        j jVarF = j.f("SELECT * FROM workdayadjustentity ORDER BY time DESC", 0);
        Cursor cursorP = this.f11805a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("time");
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("workday");
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                C0560c c0560c = new C0560c();
                c0560c.f11808a = cursorP.getLong(columnIndexOrThrow);
                c0560c.f11809b = cursorP.getInt(columnIndexOrThrow2) != 0;
                arrayList.add(c0560c);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }
}
