package w2;

import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import com.stepos.familyguard.db.entity.CategoryLimitCache;
import com.stepos.familyguard.db.entity.PackageLimitCache;
import com.stepos.familyguard.db.entity.PeriodLimitCache;
import com.stepos.familyguard.db.entity.StatsDataSetCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k2.AbstractC0809m;
import k2.InterfaceC0799c;
import k2.InterfaceC0801e;
import k2.InterfaceC0805i;
import l0.AbstractC0822a;
import l2.C0833b;
import l2.InterfaceC0839h;

/* loaded from: classes.dex */
public class n1 extends X0 {

    /* renamed from: g, reason: collision with root package name */
    private final v2.d f23635g;

    /* renamed from: h, reason: collision with root package name */
    private final A3.b f23636h;

    public n1(v2.e eVar) {
        super(eVar);
        this.f23636h = new A3.b();
        this.f23635g = (v2.d) eVar;
    }

    public static /* synthetic */ PeriodLimitInfo[] O(List list) {
        int size = list.size();
        PeriodLimitInfo[] periodLimitInfoArr = new PeriodLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            periodLimitInfoArr[i5] = new PeriodLimitInfo((PeriodLimitCache) list.get(i5));
        }
        return periodLimitInfoArr;
    }

    public static /* synthetic */ CategoryLimitInfo[] P(List list) {
        int size = list.size();
        CategoryLimitInfo[] categoryLimitInfoArr = new CategoryLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            categoryLimitInfoArr[i5] = new CategoryLimitInfo((CategoryLimitCache) list.get(i5));
        }
        return categoryLimitInfoArr;
    }

    public static /* synthetic */ PackageLimitInfo[] R(List list) {
        int size = list.size();
        PackageLimitInfo[] packageLimitInfoArr = new PackageLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            packageLimitInfoArr[i5] = new PackageLimitInfo((PackageLimitCache) list.get(i5));
        }
        return packageLimitInfoArr;
    }

    public static /* synthetic */ PackageLimitInfo[] S(List list) {
        int size = list.size();
        PackageLimitInfo[] packageLimitInfoArr = new PackageLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            packageLimitInfoArr[i5] = new PackageLimitInfo((PackageLimitCache) list.get(i5));
        }
        return packageLimitInfoArr;
    }

    public static /* synthetic */ StatsDataSet[] T(List list) {
        List listV = AbstractC0822a.v(((StatsDataSetCache) list.get(0)).getData(), StatsDataSet.class);
        return (StatsDataSet[]) listV.toArray(new StatsDataSet[listV.size()]);
    }

    public static /* synthetic */ PeriodLimitInfo[] U(List list) {
        int size = list.size();
        PeriodLimitInfo[] periodLimitInfoArr = new PeriodLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            periodLimitInfoArr[i5] = new PeriodLimitInfo((PeriodLimitCache) list.get(i5));
        }
        return periodLimitInfoArr;
    }

    public static /* synthetic */ PeriodLimitInfo[] V(List list) {
        int size = list.size();
        PeriodLimitInfo[] periodLimitInfoArr = new PeriodLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            periodLimitInfoArr[i5] = new PeriodLimitInfo((PeriodLimitCache) list.get(i5));
        }
        return periodLimitInfoArr;
    }

    public static /* synthetic */ List X(List list) {
        list.size();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0833b c0833b = (C0833b) it.next();
            PackageUtils.AppInfo appInfo = new PackageUtils.AppInfo();
            appInfo.packageName = c0833b.f18167c;
            appInfo.label = c0833b.f18168d;
            appInfo.iconUrl = c0833b.f18169e;
            appInfo.iconUrlF8 = c0833b.f18170f;
            arrayList.add(appInfo);
        }
        return arrayList;
    }

    public static /* synthetic */ CategoryLimitInfo[] Y(List list) {
        int size = list.size();
        CategoryLimitInfo[] categoryLimitInfoArr = new CategoryLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            categoryLimitInfoArr[i5] = new CategoryLimitInfo((CategoryLimitCache) list.get(i5));
        }
        return categoryLimitInfoArr;
    }

    public static /* synthetic */ PeriodLimitInfo[] Z(List list) {
        int size = list.size();
        PeriodLimitInfo[] periodLimitInfoArr = new PeriodLimitInfo[size];
        for (int i5 = 0; i5 < size; i5++) {
            periodLimitInfoArr[i5] = new PeriodLimitInfo((PeriodLimitCache) list.get(i5));
        }
        return periodLimitInfoArr;
    }

    public static /* synthetic */ List a0(List list) {
        list.size();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0833b c0833b = (C0833b) it.next();
            PackageUtils.AppInfo appInfo = new PackageUtils.AppInfo();
            appInfo.packageName = c0833b.f18167c;
            appInfo.label = c0833b.f18168d;
            appInfo.iconUrl = c0833b.f18169e;
            appInfo.iconUrlF8 = c0833b.f18170f;
            arrayList.add(appInfo);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(C1229h0 c1229h0) {
        this.f23593d.k(c1229h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(C1226g0 c1226g0) {
        this.f23594e.k(c1226g0);
    }

    @Override // w2.V0
    public void C() {
        FamilyGuardDatabase familyGuardDatabaseX = FamilyGuardDatabase.x();
        long jE = this.f23635g.e();
        AbstractC0809m abstractC0809mD = familyGuardDatabaseX.D();
        InterfaceC0799c interfaceC0799cU = familyGuardDatabaseX.u();
        InterfaceC0805i interfaceC0805iZ = familyGuardDatabaseX.z();
        InterfaceC0801e interfaceC0801eV = familyGuardDatabaseX.v();
        InterfaceC0839h interfaceC0839hB = familyGuardDatabaseX.B();
        com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
        this.f23636h.c(x3.q.q(interfaceC0805iZ.a(aVar.ordinal(), jE).j(new D3.h() { // from class: w2.l1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.S((List) obj);
            }
        }), interfaceC0801eV.a(aVar.ordinal(), jE).j(new D3.h() { // from class: w2.m1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.Y((List) obj);
            }
        }), interfaceC0839hB.f(0, jE).j(new D3.h() { // from class: w2.Z0
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.Z((List) obj);
            }
        }), interfaceC0839hB.f(1, jE).j(new D3.h() { // from class: w2.a1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.O((List) obj);
            }
        }), interfaceC0799cU.c(jE).j(new D3.h() { // from class: w2.b1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.a0((List) obj);
            }
        }), abstractC0809mD.b(jE), new D3.f() { // from class: w2.c1
            @Override // D3.f
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return this.f23602a.d0((PackageLimitInfo[]) obj, (CategoryLimitInfo[]) obj2, (PeriodLimitInfo[]) obj3, (PeriodLimitInfo[]) obj4, (List) obj5, (l2.m) obj6);
            }
        }).n(T3.a.c()).l(new D3.c() { // from class: w2.d1
            @Override // D3.c
            public final void accept(Object obj) {
                this.f23609a.c0((C1226g0) obj);
            }
        }, S1.a.b()));
    }

    @Override // w2.V0
    public void a() {
    }

    protected C1226g0 d0(PackageLimitInfo[] packageLimitInfoArr, CategoryLimitInfo[] categoryLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr2, List<PackageUtils.AppInfo> list, l2.m mVar) {
        return new C1226g0(packageLimitInfoArr, categoryLimitInfoArr, periodLimitInfoArr, periodLimitInfoArr2, list, mVar);
    }

    protected C1229h0 e0(StatsDataSet[] statsDataSetArr, PackageLimitInfo[] packageLimitInfoArr, CategoryLimitInfo[] categoryLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr2, List<PackageUtils.AppInfo> list, l2.m mVar) {
        return new C1229h0(statsDataSetArr, packageLimitInfoArr, categoryLimitInfoArr, periodLimitInfoArr, periodLimitInfoArr2, list, mVar);
    }

    @Override // w2.V0
    public void g() {
    }

    @Override // w2.V0
    public void q(DataToken dataToken) {
    }

    @Override // w2.V0
    public void r() {
        FamilyGuardDatabase familyGuardDatabaseX = FamilyGuardDatabase.x();
        long jE = this.f23635g.e();
        AbstractC0809m abstractC0809mD = familyGuardDatabaseX.D();
        InterfaceC0799c interfaceC0799cU = familyGuardDatabaseX.u();
        l2.n nVarE = familyGuardDatabaseX.E();
        InterfaceC0805i interfaceC0805iZ = familyGuardDatabaseX.z();
        InterfaceC0801e interfaceC0801eV = familyGuardDatabaseX.v();
        InterfaceC0839h interfaceC0839hB = familyGuardDatabaseX.B();
        x3.u uVarJ = nVarE.b(jE).j(new D3.h() { // from class: w2.Y0
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.T((List) obj);
            }
        });
        com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
        this.f23636h.c(x3.q.r(uVarJ, interfaceC0805iZ.a(aVar.ordinal(), jE).j(new D3.h() { // from class: w2.e1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.R((List) obj);
            }
        }), interfaceC0801eV.a(aVar.ordinal(), jE).j(new D3.h() { // from class: w2.f1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.P((List) obj);
            }
        }), interfaceC0839hB.f(0, jE).j(new D3.h() { // from class: w2.g1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.V((List) obj);
            }
        }), interfaceC0839hB.f(1, jE).j(new D3.h() { // from class: w2.h1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.U((List) obj);
            }
        }), interfaceC0799cU.c(jE).j(new D3.h() { // from class: w2.i1
            @Override // D3.h
            public final Object apply(Object obj) {
                return n1.X((List) obj);
            }
        }), abstractC0809mD.b(jE), new D3.g() { // from class: w2.j1
            @Override // D3.g
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                return this.f23625a.e0((StatsDataSet[]) obj, (PackageLimitInfo[]) obj2, (CategoryLimitInfo[]) obj3, (PeriodLimitInfo[]) obj4, (PeriodLimitInfo[]) obj5, (List) obj6, (l2.m) obj7);
            }
        }).n(T3.a.c()).l(new D3.c() { // from class: w2.k1
            @Override // D3.c
            public final void accept(Object obj) {
                this.f23628a.b0((C1229h0) obj);
            }
        }, S1.a.b()));
    }

    @Override // w2.V0
    public void setEnable(boolean z5) {
    }

    @Override // w2.V0
    public void x() {
    }
}
