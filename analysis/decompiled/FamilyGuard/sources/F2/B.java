package F2;

import Z.e;
import android.database.Cursor;
import androidx.lifecycle.AbstractC0526f;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.minor.WhitelistApp;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class B extends A {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f1634a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f1635b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f1636c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f1637d;

    class a extends Z.d<WhitelistApp> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `whitelist_app`(`minor_id`,`package_name`,`removable`) VALUES (?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, WhitelistApp whitelistApp) {
            interfaceC0651f.z(1, whitelistApp.minorId);
            String str = whitelistApp.packageName;
            if (str == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, str);
            }
            interfaceC0651f.z(3, whitelistApp.removable ? 1L : 0L);
        }
    }

    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM whitelist_app WHERE minor_id = ? AND package_name = ?";
        }
    }

    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM whitelist_app WHERE minor_id = ?";
        }
    }

    class d extends AbstractC0526f<List<WhitelistApp>> {

        /* renamed from: h, reason: collision with root package name */
        private e.c f1641h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Z.j f1642i;

        class a extends e.c {
            a(String str, String... strArr) {
                super(str, strArr);
            }

            @Override // Z.e.c
            public void a(Set<String> set) {
                d.this.f();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Executor executor, Z.j jVar) {
            super(executor);
            this.f1642i = jVar;
        }

        protected void finalize() {
            this.f1642i.r();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.AbstractC0526f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public List<WhitelistApp> c() {
            if (this.f1641h == null) {
                this.f1641h = new a(WhitelistApp.TABLE_NAME, new String[0]);
                B.this.f1634a.h().b(this.f1641h);
            }
            Cursor cursorP = B.this.f1634a.p(this.f1642i);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_MINOR_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_PACKAGE_NAME);
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_REMOVABLE);
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    WhitelistApp whitelistApp = new WhitelistApp();
                    whitelistApp.minorId = cursorP.getLong(columnIndexOrThrow);
                    whitelistApp.packageName = cursorP.getString(columnIndexOrThrow2);
                    whitelistApp.removable = cursorP.getInt(columnIndexOrThrow3) != 0;
                    arrayList.add(whitelistApp);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }
    }

    class e implements Callable<List<WhitelistApp>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f1645a;

        e(Z.j jVar) {
            this.f1645a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<WhitelistApp> call() {
            Cursor cursorP = B.this.f1634a.p(this.f1645a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_MINOR_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_PACKAGE_NAME);
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_REMOVABLE);
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    WhitelistApp whitelistApp = new WhitelistApp();
                    whitelistApp.minorId = cursorP.getLong(columnIndexOrThrow);
                    whitelistApp.packageName = cursorP.getString(columnIndexOrThrow2);
                    whitelistApp.removable = cursorP.getInt(columnIndexOrThrow3) != 0;
                    arrayList.add(whitelistApp);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f1645a.r();
        }
    }

    public B(Z.g gVar) {
        this.f1634a = gVar;
        this.f1635b = new a(gVar);
        this.f1636c = new b(gVar);
        this.f1637d = new c(gVar);
    }

    @Override // F2.A
    public int a(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f1637d.a();
        this.f1634a.b();
        try {
            interfaceC0651fA.z(1, j5);
            int iN = interfaceC0651fA.n();
            this.f1634a.s();
            return iN;
        } finally {
            this.f1634a.f();
            this.f1637d.f(interfaceC0651fA);
        }
    }

    @Override // F2.A
    protected int b(long j5, String str) {
        InterfaceC0651f interfaceC0651fA = this.f1636c.a();
        this.f1634a.b();
        try {
            interfaceC0651fA.z(1, j5);
            if (str == null) {
                interfaceC0651fA.Z(2);
            } else {
                interfaceC0651fA.l(2, str);
            }
            int iN = interfaceC0651fA.n();
            this.f1634a.s();
            this.f1634a.f();
            this.f1636c.f(interfaceC0651fA);
            return iN;
        } catch (Throwable th) {
            this.f1634a.f();
            this.f1636c.f(interfaceC0651fA);
            throw th;
        }
    }

    @Override // F2.A
    public WhitelistApp c(long j5, String str) {
        WhitelistApp whitelistApp;
        Z.j jVarF = Z.j.f("SELECT * FROM whitelist_app WHERE minor_id = ? AND package_name = ?", 2);
        boolean z5 = true;
        jVarF.z(1, j5);
        if (str == null) {
            jVarF.Z(2);
        } else {
            jVarF.l(2, str);
        }
        Cursor cursorP = this.f1634a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_MINOR_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_PACKAGE_NAME);
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_REMOVABLE);
            if (cursorP.moveToFirst()) {
                whitelistApp = new WhitelistApp();
                whitelistApp.minorId = cursorP.getLong(columnIndexOrThrow);
                whitelistApp.packageName = cursorP.getString(columnIndexOrThrow2);
                if (cursorP.getInt(columnIndexOrThrow3) == 0) {
                    z5 = false;
                }
                whitelistApp.removable = z5;
            } else {
                whitelistApp = null;
            }
            return whitelistApp;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // F2.A
    public Cursor d(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM whitelist_app WHERE minor_id = ?", 1);
        jVarF.z(1, j5);
        return this.f1634a.p(jVarF);
    }

    @Override // F2.A
    public List<WhitelistApp> e(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM whitelist_app WHERE minor_id = ?", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f1634a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_MINOR_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_PACKAGE_NAME);
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(WhitelistApp.COLUMN_REMOVABLE);
            ArrayList arrayList = new ArrayList(cursorP.getCount());
            while (cursorP.moveToNext()) {
                WhitelistApp whitelistApp = new WhitelistApp();
                whitelistApp.minorId = cursorP.getLong(columnIndexOrThrow);
                whitelistApp.packageName = cursorP.getString(columnIndexOrThrow2);
                whitelistApp.removable = cursorP.getInt(columnIndexOrThrow3) != 0;
                arrayList.add(whitelistApp);
            }
            return arrayList;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // F2.A
    public x3.f<List<WhitelistApp>> f(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM whitelist_app WHERE minor_id = ?", 1);
        jVarF.z(1, j5);
        return Z.k.b(this.f1634a, new String[]{WhitelistApp.TABLE_NAME}, new e(jVarF));
    }

    @Override // F2.A
    public AbstractC0545z<List<WhitelistApp>> g(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM whitelist_app WHERE minor_id = ?", 1);
        jVarF.z(1, j5);
        return new d(this.f1634a.j(), jVarF).e();
    }

    @Override // F2.A
    public void h(WhitelistApp whitelistApp) {
        this.f1634a.b();
        try {
            this.f1635b.i(whitelistApp);
            this.f1634a.s();
        } finally {
            this.f1634a.f();
        }
    }

    @Override // F2.A
    public int i(long j5, String str) {
        this.f1634a.b();
        try {
            int i5 = super.i(j5, str);
            this.f1634a.s();
            return i5;
        } finally {
            this.f1634a.f();
        }
    }
}
