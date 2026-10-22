package l2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: l2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0837f implements InterfaceC0836e {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f18182a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f18183b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f18184c;

    /* renamed from: l2.f$a */
    class a extends Z.d<C0835d> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PackageCategoryCache`(`id`,`packageName`,`categoryId`,`relationId`) VALUES (nullif(?, 0),?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0835d c0835d) {
            interfaceC0651f.z(1, c0835d.f18178a);
            String str = c0835d.f18179b;
            if (str == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, str);
            }
            interfaceC0651f.z(3, c0835d.f18180c);
            interfaceC0651f.z(4, c0835d.f18181d);
        }
    }

    /* renamed from: l2.f$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM packagecategorycache WHERE relationId = (?)";
        }
    }

    /* renamed from: l2.f$c */
    class c implements Callable<List<C0835d>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f18187a;

        c(Z.j jVar) {
            this.f18187a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<C0835d> call() {
            Cursor cursorP = C0837f.this.f18182a.p(this.f18187a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("categoryId");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("relationId");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    C0835d c0835d = new C0835d();
                    c0835d.f18178a = cursorP.getLong(columnIndexOrThrow);
                    c0835d.f18179b = cursorP.getString(columnIndexOrThrow2);
                    c0835d.f18180c = cursorP.getInt(columnIndexOrThrow3);
                    c0835d.f18181d = cursorP.getLong(columnIndexOrThrow4);
                    arrayList.add(c0835d);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f18187a.r();
        }
    }

    public C0837f(Z.g gVar) {
        this.f18182a = gVar;
        this.f18183b = new a(gVar);
        this.f18184c = new b(gVar);
    }

    @Override // l2.InterfaceC0836e
    public x3.f<List<C0835d>> a(long j5, int i5) {
        Z.j jVarF = Z.j.f("SELECT * FROM packagecategorycache WHERE relationId = (?) AND categoryId = (?)", 2);
        jVarF.z(1, j5);
        jVarF.z(2, i5);
        return Z.k.b(this.f18182a, new String[]{"packagecategorycache"}, new c(jVarF));
    }
}
