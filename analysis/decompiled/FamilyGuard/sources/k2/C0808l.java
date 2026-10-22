package k2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l2.C0838g;
import x3.q;

/* renamed from: k2.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0808l implements InterfaceC0807k {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17892a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17893b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17894c;

    /* renamed from: k2.l$a */
    class a extends Z.d<C0838g> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PackageUsingTimeStatsCache`(`id`,`interval`,`startTime`,`updateTime`,`usingTime`,`packageName`,`relationId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0838g c0838g) {
            interfaceC0651f.z(1, c0838g.a());
            interfaceC0651f.z(2, c0838g.b());
            interfaceC0651f.z(3, c0838g.e());
            interfaceC0651f.z(4, c0838g.f());
            interfaceC0651f.z(5, c0838g.g());
            if (c0838g.c() == null) {
                interfaceC0651f.Z(6);
            } else {
                interfaceC0651f.l(6, c0838g.c());
            }
            interfaceC0651f.z(7, c0838g.d());
        }
    }

    /* renamed from: k2.l$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from packageusingtimestatscache where relationId =?";
        }
    }

    /* renamed from: k2.l$c */
    class c implements Callable<List<C0838g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17897a;

        c(Z.j jVar) {
            this.f17897a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<C0838g> call() {
            Cursor cursorP = C0808l.this.f17892a.p(this.f17897a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("startTime");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("updateTime");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("usingTime");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    C0838g c0838g = new C0838g(cursorP.getInt(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getString(columnIndexOrThrow6), cursorP.getLong(columnIndexOrThrow7));
                    c0838g.h(cursorP.getLong(columnIndexOrThrow));
                    arrayList.add(c0838g);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17897a.r();
        }
    }

    public C0808l(Z.g gVar) {
        this.f17892a = gVar;
        this.f17893b = new a(gVar);
        this.f17894c = new b(gVar);
    }

    @Override // k2.InterfaceC0807k
    public q<List<C0838g>> a(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM packageusingtimestatscache where interval = (?) AND relationId = (?)", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        return q.h(new c(jVarF));
    }
}
