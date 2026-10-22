package k2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x3.q;

/* renamed from: k2.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0812p implements InterfaceC0811o {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17932a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17933b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17934c;

    /* renamed from: k2.p$a */
    class a extends Z.d<l2.p> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `UsingTimeStatsCache`(`id`,`interval`,`startTime`,`updateTime`,`usingTime`,`relationId`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, l2.p pVar) {
            interfaceC0651f.z(1, pVar.a());
            interfaceC0651f.z(2, pVar.b());
            interfaceC0651f.z(3, pVar.d());
            interfaceC0651f.z(4, pVar.e());
            interfaceC0651f.z(5, pVar.f());
            interfaceC0651f.z(6, pVar.c());
        }
    }

    /* renamed from: k2.p$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from usingtimestatscache where relationId =?";
        }
    }

    /* renamed from: k2.p$c */
    class c implements Callable<List<l2.p>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17937a;

        c(Z.j jVar) {
            this.f17937a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<l2.p> call() {
            Cursor cursorP = C0812p.this.f17932a.p(this.f17937a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("startTime");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("updateTime");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("usingTime");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    l2.p pVar = new l2.p(cursorP.getInt(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getLong(columnIndexOrThrow6));
                    pVar.g(cursorP.getLong(columnIndexOrThrow));
                    arrayList.add(pVar);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17937a.r();
        }
    }

    public C0812p(Z.g gVar) {
        this.f17932a = gVar;
        this.f17933b = new a(gVar);
        this.f17934c = new b(gVar);
    }

    @Override // k2.InterfaceC0811o
    public q<List<l2.p>> a(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM usingtimestatscache where interval = (?) AND relationId = (?)", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        return q.h(new c(jVarF));
    }
}
