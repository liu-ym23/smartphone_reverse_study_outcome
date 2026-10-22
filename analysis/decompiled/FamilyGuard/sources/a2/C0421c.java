package a2;

import R4.u;
import S4.h;
import android.content.Context;
import android.util.Log;
import com.stepos.digitalwellbeing.server.net.BaseEntity;
import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import com.stepos.digitalwellbeing.server.net.category.PackageCategoryParam;
import java.util.List;
import m2.C0863f;
import n2.C0874a;
import n2.C0878e;
import n2.C0879f;
import n2.C0880g;
import o2.InterfaceC0901b;
import x3.f;

/* renamed from: a2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0421c implements InterfaceC0419a {

    /* renamed from: b, reason: collision with root package name */
    private static C0421c f7252b;

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0419a f7253a = new a();

    /* renamed from: a2.c$a */
    static class a implements InterfaceC0419a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0422d f7254a;

        a() {
            InterfaceC0901b interfaceC0901bA;
            C0878e.d();
            try {
                interfaceC0901bA = o2.c.a();
            } catch (Exception e6) {
                e6.printStackTrace();
                interfaceC0901bA = null;
            }
            this.f7254a = (InterfaceC0422d) new u.b().d(C0863f.b()).g(C0878e.c(interfaceC0901bA, new C0879f("FamilyGuardServer"), 5L, 5L, 5L)).b(C0874a.f("FamilyGuardServer")).a(h.d()).e().c(InterfaceC0422d.class);
        }

        @Override // a2.InterfaceC0419a
        public f<BaseEntity<List<CategoryEntity>>> a(List<PackageCategoryParam> list) {
            Log.d("CategoryNetService", "Request URL: " + C0863f.b() + "digitalhealth/appcategories.do");
            StringBuilder sb = new StringBuilder();
            sb.append("Params: ");
            sb.append(list);
            Log.d("CategoryNetService", sb.toString());
            return this.f7254a.a(C0880g.k().a("pkgList", list).a("timeStamp", Long.valueOf(System.currentTimeMillis())).a("sn", "sn").b()).o(new D3.c() { // from class: a2.b
                @Override // D3.c
                public final void accept(Object obj) {
                    Log.d("CategoryNetService", "Result: " + ((BaseEntity) obj));
                }
            });
        }
    }

    private C0421c() {
    }

    public static C0421c b(Context context) {
        if (f7252b == null) {
            f7252b = new C0421c();
        }
        return f7252b;
    }

    @Override // a2.InterfaceC0419a
    public f<BaseEntity<List<CategoryEntity>>> a(List<PackageCategoryParam> list) {
        return this.f7253a.a(list);
    }
}
