package k2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l2.C0833b;
import x3.q;

/* renamed from: k2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0800d implements InterfaceC0799c {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17854a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17855b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17856c;

    /* renamed from: k2.d$a */
    class a extends Z.d<C0833b> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `AppPackage`(`id`,`relationId`,`packageName`,`label`,`iconUrl`,`iconUrlF8`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0833b c0833b) {
            interfaceC0651f.z(1, c0833b.f18165a);
            interfaceC0651f.z(2, c0833b.f18166b);
            String str = c0833b.f18167c;
            if (str == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.l(3, str);
            }
            String str2 = c0833b.f18168d;
            if (str2 == null) {
                interfaceC0651f.Z(4);
            } else {
                interfaceC0651f.l(4, str2);
            }
            String str3 = c0833b.f18169e;
            if (str3 == null) {
                interfaceC0651f.Z(5);
            } else {
                interfaceC0651f.l(5, str3);
            }
            String str4 = c0833b.f18170f;
            if (str4 == null) {
                interfaceC0651f.Z(6);
            } else {
                interfaceC0651f.l(6, str4);
            }
        }
    }

    /* renamed from: k2.d$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM apppackage WHERE relationId =?";
        }
    }

    /* renamed from: k2.d$c */
    class c implements Callable<List<C0833b>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17859a;

        c(Z.j jVar) {
            this.f17859a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<C0833b> call() {
            Cursor cursorP = C0800d.this.f17854a.p(this.f17859a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("relationId");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("label");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("iconUrl");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("iconUrlF8");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    C0833b c0833b = new C0833b();
                    c0833b.f18165a = cursorP.getLong(columnIndexOrThrow);
                    c0833b.f18166b = cursorP.getLong(columnIndexOrThrow2);
                    c0833b.f18167c = cursorP.getString(columnIndexOrThrow3);
                    c0833b.f18168d = cursorP.getString(columnIndexOrThrow4);
                    c0833b.f18169e = cursorP.getString(columnIndexOrThrow5);
                    c0833b.f18170f = cursorP.getString(columnIndexOrThrow6);
                    arrayList.add(c0833b);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17859a.r();
        }
    }

    public C0800d(Z.g gVar) {
        this.f17854a = gVar;
        this.f17855b = new a(gVar);
        this.f17856c = new b(gVar);
    }

    @Override // k2.InterfaceC0799c
    public C0833b a(String str) {
        C0833b c0833b;
        Z.j jVarF = Z.j.f("SELECT * FROM apppackage WHERE packageName = (?)", 1);
        if (str == null) {
            jVarF.Z(1);
        } else {
            jVarF.l(1, str);
        }
        Cursor cursorP = this.f17854a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("relationId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("label");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("iconUrl");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("iconUrlF8");
            if (cursorP.moveToFirst()) {
                c0833b = new C0833b();
                c0833b.f18165a = cursorP.getLong(columnIndexOrThrow);
                c0833b.f18166b = cursorP.getLong(columnIndexOrThrow2);
                c0833b.f18167c = cursorP.getString(columnIndexOrThrow3);
                c0833b.f18168d = cursorP.getString(columnIndexOrThrow4);
                c0833b.f18169e = cursorP.getString(columnIndexOrThrow5);
                c0833b.f18170f = cursorP.getString(columnIndexOrThrow6);
            } else {
                c0833b = null;
            }
            return c0833b;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // k2.InterfaceC0799c
    public C0833b b(long j5, String str) {
        C0833b c0833b;
        Z.j jVarF = Z.j.f("SELECT * FROM apppackage WHERE relationId = (?) AND packageName = (?)", 2);
        jVarF.z(1, j5);
        if (str == null) {
            jVarF.Z(2);
        } else {
            jVarF.l(2, str);
        }
        Cursor cursorP = this.f17854a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("relationId");
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("label");
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("iconUrl");
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("iconUrlF8");
            if (cursorP.moveToFirst()) {
                c0833b = new C0833b();
                c0833b.f18165a = cursorP.getLong(columnIndexOrThrow);
                c0833b.f18166b = cursorP.getLong(columnIndexOrThrow2);
                c0833b.f18167c = cursorP.getString(columnIndexOrThrow3);
                c0833b.f18168d = cursorP.getString(columnIndexOrThrow4);
                c0833b.f18169e = cursorP.getString(columnIndexOrThrow5);
                c0833b.f18170f = cursorP.getString(columnIndexOrThrow6);
            } else {
                c0833b = null;
            }
            return c0833b;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // k2.InterfaceC0799c
    public q<List<C0833b>> c(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM apppackage WHERE relationId = (?)", 1);
        jVarF.z(1, j5);
        return q.h(new c(jVarF));
    }
}
