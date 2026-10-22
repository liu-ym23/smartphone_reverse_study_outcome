package X1;

import Z.g;
import Z.j;
import Z.l;
import android.database.Cursor;
import com.stepos.digitalwellbeing.server.category.data.room.PackageCategoryInfo;
import d0.InterfaceC0651f;

/* loaded from: classes.dex */
public final class b implements X1.a {

    /* renamed from: a, reason: collision with root package name */
    private final g f5802a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f5803b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f5804c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.c f5805d;

    /* renamed from: e, reason: collision with root package name */
    private final l f5806e;

    /* renamed from: f, reason: collision with root package name */
    private final l f5807f;

    class a extends Z.d<PackageCategoryInfo> {
        a(g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `PackageCategoryInfo`(`packageName`,`categoryId`) VALUES (?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageCategoryInfo packageCategoryInfo) {
            if (packageCategoryInfo.getPackageName() == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.l(1, packageCategoryInfo.getPackageName());
            }
            interfaceC0651f.z(2, packageCategoryInfo.getCategoryId());
        }
    }

    /* renamed from: X1.b$b, reason: collision with other inner class name */
    class C0088b extends Z.c<PackageCategoryInfo> {
        C0088b(g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM `PackageCategoryInfo` WHERE `packageName` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageCategoryInfo packageCategoryInfo) {
            if (packageCategoryInfo.getPackageName() == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.l(1, packageCategoryInfo.getPackageName());
            }
        }
    }

    class c extends Z.c<PackageCategoryInfo> {
        c(g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `PackageCategoryInfo` SET `packageName` = ?,`categoryId` = ? WHERE `packageName` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, PackageCategoryInfo packageCategoryInfo) {
            if (packageCategoryInfo.getPackageName() == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.l(1, packageCategoryInfo.getPackageName());
            }
            interfaceC0651f.z(2, packageCategoryInfo.getCategoryId());
            if (packageCategoryInfo.getPackageName() == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.l(3, packageCategoryInfo.getPackageName());
            }
        }
    }

    class d extends l {
        d(g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM packagecategoryinfo WHERE packageName=(?)";
        }
    }

    class e extends l {
        e(g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM packagecategoryinfo";
        }
    }

    public b(g gVar) {
        this.f5802a = gVar;
        this.f5803b = new a(gVar);
        this.f5804c = new C0088b(gVar);
        this.f5805d = new c(gVar);
        this.f5806e = new d(gVar);
        this.f5807f = new e(gVar);
    }

    @Override // X1.a
    public void b() {
        InterfaceC0651f interfaceC0651fA = this.f5807f.a();
        this.f5802a.b();
        try {
            interfaceC0651fA.n();
            this.f5802a.s();
        } finally {
            this.f5802a.f();
            this.f5807f.f(interfaceC0651fA);
        }
    }

    @Override // X1.a
    public PackageCategoryInfo d(String str) {
        PackageCategoryInfo packageCategoryInfo;
        j jVarF = j.f("SELECT * FROM packagecategoryinfo WHERE packageName=(?)", 1);
        if (str == null) {
            jVarF.Z(1);
        } else {
            jVarF.l(1, str);
        }
        Cursor cursorP = this.f5802a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("packageName");
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("categoryId");
            if (cursorP.moveToFirst()) {
                packageCategoryInfo = new PackageCategoryInfo();
                packageCategoryInfo.setPackageName(cursorP.getString(columnIndexOrThrow));
                packageCategoryInfo.setCategoryId(cursorP.getInt(columnIndexOrThrow2));
            } else {
                packageCategoryInfo = null;
            }
            return packageCategoryInfo;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // X1.a
    public long e(PackageCategoryInfo packageCategoryInfo) {
        this.f5802a.b();
        try {
            long j5 = this.f5803b.j(packageCategoryInfo);
            this.f5802a.s();
            return j5;
        } finally {
            this.f5802a.f();
        }
    }
}
