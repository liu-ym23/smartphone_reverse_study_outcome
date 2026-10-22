package b2;

import R4.u;
import S4.h;
import com.stepos.digitalwellbeing.server.net.BaseEntity;
import com.stepos.digitalwellbeing.server.net.workday.WorkdayEntity;
import java.util.List;
import m2.C0863f;
import n2.C0874a;
import n2.C0878e;
import n2.C0879f;
import n2.C0880g;
import o2.InterfaceC0901b;

/* renamed from: b2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0562e implements InterfaceC0561d {

    /* renamed from: b, reason: collision with root package name */
    private static C0562e f11810b;

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0561d f11811a = new a();

    /* renamed from: b2.e$a */
    static class a implements InterfaceC0561d {

        /* renamed from: a, reason: collision with root package name */
        private final f f11812a;

        public a() {
            InterfaceC0901b interfaceC0901bA;
            try {
                interfaceC0901bA = o2.c.a();
            } catch (Exception e6) {
                e6.printStackTrace();
                interfaceC0901bA = null;
            }
            this.f11812a = (f) new u.b().d(C0863f.e()).g(C0878e.b(interfaceC0901bA, new C0879f("FamilyGuardServer"))).b(C0874a.f("FamilyGuardServer")).a(h.d()).e().c(f.class);
        }

        @Override // b2.InterfaceC0561d
        public x3.f<BaseEntity<List<WorkdayEntity>>> a() {
            return this.f11812a.a(C0880g.k().b());
        }
    }

    private C0562e() {
    }

    public static C0562e b() {
        if (f11810b == null) {
            f11810b = new C0562e();
        }
        return f11810b;
    }

    @Override // b2.InterfaceC0561d
    public x3.f<BaseEntity<List<WorkdayEntity>>> a() {
        return this.f11811a.a();
    }
}
