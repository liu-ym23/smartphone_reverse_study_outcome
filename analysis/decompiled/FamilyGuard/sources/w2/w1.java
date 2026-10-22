package w2;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.server.limit.data.room.CategoryLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.PackageLimit;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import com.stepos.familyguard.db.entity.CategoryLimitCache;
import com.stepos.familyguard.db.entity.PackageLimitCache;
import com.stepos.familyguard.db.entity.PeriodLimitCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k2.InterfaceC0799c;
import k2.InterfaceC0801e;
import k2.InterfaceC0803g;
import k2.InterfaceC0805i;
import k2.InterfaceC0807k;
import k2.InterfaceC0811o;
import l2.C0833b;
import l2.C0834c;
import l2.C0838g;
import l2.InterfaceC0839h;

/* loaded from: classes.dex */
public class w1 extends q1 {

    /* renamed from: p, reason: collision with root package name */
    private final v2.d f23680p;

    /* renamed from: q, reason: collision with root package name */
    private final A3.b f23681q;

    public w1(v2.e eVar) {
        super(eVar);
        this.f23681q = new A3.b();
        this.f23680p = (v2.d) eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(List list) {
        this.f23654n.k(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(List list) {
        this.f23655o.k(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(List<l2.p> list) {
        int size = list.size();
        UsingTimeStats[] usingTimeStatsArr = new UsingTimeStats[size];
        for (int i5 = 0; i5 < size; i5++) {
            usingTimeStatsArr[i5] = list.get(i5).h();
        }
        this.f23643c.k(usingTimeStatsArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<C1216d> Y(List<C0833b> list, List<C0838g> list2, List<PackageLimitCache> list3, List<PeriodLimitCache> list4) {
        C1216d c1216d;
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        l2.m mVarA = FamilyGuardDatabase.x().D().a(this.f23680p.e());
        for (C0833b c0833b : list) {
            C1216d c1216d2 = new C1216d(c0833b.f18167c, c0833b.f18168d);
            arrayList.add(c1216d2);
            map.put(c0833b.f18167c, c1216d2);
        }
        Iterator<C0838g> it = list2.iterator();
        while (it.hasNext()) {
            PackageUsingTimeStats packageUsingTimeStatsI = it.next().i();
            C1216d c1216d3 = (C1216d) map.get(packageUsingTimeStatsI.getPackageName());
            if (c1216d3 != null) {
                c1216d3.F(packageUsingTimeStatsI);
            }
        }
        Iterator<PackageLimitCache> it2 = list3.iterator();
        while (it2.hasNext()) {
            PackageLimit packageLimit = it2.next().toPackageLimit();
            packageLimit.setChild(q2.l.b(mVarA.f18256n));
            C1216d c1216d4 = (C1216d) map.get(packageLimit.getPackageName());
            if (c1216d4 != null) {
                c1216d4.D(new PackageLimitInfo(packageLimit, 0L));
            }
        }
        Iterator<PeriodLimitCache> it3 = list4.iterator();
        while (it3.hasNext()) {
            PeriodLimitInfo periodLimitInfo = new PeriodLimitInfo(it3.next());
            String packageName = periodLimitInfo.getPackageName();
            if (!TextUtils.isEmpty(packageName) && periodLimitInfo.getType() == 0 && (c1216d = (C1216d) map.get(packageName)) != null) {
                c1216d.G(periodLimitInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<C0833b> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList2.add(it4.next().f18167c);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<C1257w> Z(List<C0834c> list, List<CategoryLimitCache> list2, List<PeriodLimitCache> list3) {
        C1257w c1257w;
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<C0834c> it = list.iterator();
        while (it.hasNext()) {
            CategoryUsingTimeStats categoryUsingTimeStatsI = it.next().i();
            int categoryId = categoryUsingTimeStatsI.getCategoryId();
            C1257w c1257w2 = new C1257w(categoryId, categoryUsingTimeStatsI);
            map.put(Integer.valueOf(categoryId), c1257w2);
            arrayList.add(c1257w2);
        }
        Iterator<CategoryLimitCache> it2 = list2.iterator();
        while (it2.hasNext()) {
            CategoryLimit categoryLimit = it2.next().toCategoryLimit();
            C1257w c1257w3 = (C1257w) map.get(Integer.valueOf(categoryLimit.getCategoryId()));
            if (c1257w3 != null) {
                c1257w3.B(new CategoryLimitInfo(categoryLimit, 0L));
            }
        }
        for (PeriodLimitCache periodLimitCache : list3) {
            PeriodLimitInfo periodLimitInfo = new PeriodLimitInfo(periodLimitCache);
            if (periodLimitCache.getType() == 1 && periodLimitCache.getCategoryId() >= 0 && (c1257w = (C1257w) map.get(Integer.valueOf((int) periodLimitCache.getCategoryId()))) != null) {
                c1257w.D(periodLimitInfo);
            }
        }
        return arrayList;
    }

    @Override // v2.AbstractC1182a
    public void I() {
        super.I();
        this.f23681q.dispose();
        this.f23681q.d();
    }

    @Override // w2.U0
    public void a() {
    }

    @Override // w2.U0
    public void c(com.stepos.digitalwellbeing.server.data.a aVar) {
        FamilyGuardDatabase familyGuardDatabaseX = FamilyGuardDatabase.x();
        long jE = this.f23680p.e();
        int iOrdinal = aVar.ordinal();
        InterfaceC0799c interfaceC0799cU = familyGuardDatabaseX.u();
        InterfaceC0811o interfaceC0811oF = familyGuardDatabaseX.F();
        InterfaceC0807k interfaceC0807kA = familyGuardDatabaseX.A();
        InterfaceC0805i interfaceC0805iZ = familyGuardDatabaseX.z();
        InterfaceC0803g interfaceC0803gW = familyGuardDatabaseX.w();
        InterfaceC0801e interfaceC0801eV = familyGuardDatabaseX.v();
        InterfaceC0839h interfaceC0839hB = familyGuardDatabaseX.B();
        x3.q<List<C0833b>> qVarC = interfaceC0799cU.c(jE);
        this.f23681q.c(interfaceC0811oF.a(iOrdinal - 1, jE).l(new D3.c() { // from class: w2.r1
            @Override // D3.c
            public final void accept(Object obj) {
                this.f23660a.X((List) obj);
            }
        }, S1.a.b()));
        x3.q<List<C0838g>> qVarA = interfaceC0807kA.a(iOrdinal, jE);
        com.stepos.digitalwellbeing.server.data.a aVar2 = com.stepos.digitalwellbeing.server.data.a.DAY;
        x3.q<List<PackageLimitCache>> qVarA2 = interfaceC0805iZ.a(aVar2.ordinal(), jE);
        x3.q<List<C0834c>> qVarA3 = interfaceC0803gW.a(iOrdinal, jE);
        x3.q<List<CategoryLimitCache>> qVarA4 = interfaceC0801eV.a(aVar2.ordinal(), jE);
        x3.q<List<PeriodLimitCache>> qVarB = interfaceC0839hB.b(jE);
        this.f23681q.c(x3.q.p(qVarC, qVarA, qVarA2, qVarB, new D3.e() { // from class: w2.s1
            @Override // D3.e
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
                return this.f23663a.Y((List) obj, (List) obj2, (List) obj3, (List) obj4);
            }
        }).n(T3.a.c()).l(new D3.c() { // from class: w2.t1
            @Override // D3.c
            public final void accept(Object obj) {
                this.f23669a.V((List) obj);
            }
        }, S1.a.b()));
        this.f23681q.c(x3.q.o(qVarA3, qVarA4, qVarB, new D3.d() { // from class: w2.u1
            @Override // D3.d
            public final Object a(Object obj, Object obj2, Object obj3) {
                return this.f23671a.Z((List) obj, (List) obj2, (List) obj3);
            }
        }).n(T3.a.c()).l(new D3.c() { // from class: w2.v1
            @Override // D3.c
            public final void accept(Object obj) {
                this.f23675a.W((List) obj);
            }
        }, S1.a.b()));
    }

    @Override // w2.U0
    public void d(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
    }

    @Override // w2.U0
    public void f(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
    }

    @Override // w2.U0
    public void h(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
    }

    @Override // w2.U0
    public void l(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
    }

    @Override // w2.U0
    public void n(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
    }

    @Override // w2.U0
    public void z(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
    }
}
