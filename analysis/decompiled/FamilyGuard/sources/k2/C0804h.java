package k2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l2.C0834c;
import x3.q;

/* renamed from: k2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0804h implements InterfaceC0803g {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17874a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17875b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17876c;

    /* renamed from: k2.h$a */
    class a extends Z.d<C0834c> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `CategoryUsingTimeStatsCache`(`id`,`interval`,`startTime`,`updateTime`,`usingTime`,`relationId`,`categoryId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0834c c0834c) {
            interfaceC0651f.z(1, c0834c.b());
            interfaceC0651f.z(2, c0834c.c());
            interfaceC0651f.z(3, c0834c.e());
            interfaceC0651f.z(4, c0834c.f());
            interfaceC0651f.z(5, c0834c.g());
            interfaceC0651f.z(6, c0834c.d());
            interfaceC0651f.z(7, c0834c.a());
        }
    }

    /* renamed from: k2.h$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from categoryusingtimestatscache where relationId =?";
        }
    }

    /* renamed from: k2.h$c */
    class c implements Callable<List<C0834c>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17879a;

        c(Z.j jVar) {
            this.f17879a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<C0834c> call() {
            Cursor cursorP = C0804h.this.f17874a.p(this.f17879a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("interval");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("startTime");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("updateTime");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("usingTime");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("categoryId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    C0834c c0834c = new C0834c(cursorP.getInt(columnIndexOrThrow2), cursorP.getLong(columnIndexOrThrow3), cursorP.getLong(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow7), cursorP.getLong(columnIndexOrThrow6));
                    c0834c.h(cursorP.getLong(columnIndexOrThrow));
                    arrayList.add(c0834c);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17879a.r();
        }
    }

    public C0804h(Z.g gVar) {
        this.f17874a = gVar;
        this.f17875b = new a(gVar);
        this.f17876c = new b(gVar);
    }

    @Override // k2.InterfaceC0803g
    public q<List<C0834c>> a(int i5, long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM categoryusingtimestatscache where interval = (?) AND relationId = (?) order by usingTime DESC", 2);
        jVarF.z(1, i5);
        jVarF.z(2, j5);
        return q.h(new c(jVarF));
    }
}
