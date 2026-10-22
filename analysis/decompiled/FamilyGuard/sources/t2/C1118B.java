package t2;

import android.app.Application;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.familyguard.R;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import com.stepos.familyguard.db.entity.CategoryLimitCache;
import com.stepos.familyguard.db.entity.PackageLimitCache;
import com.stepos.familyguard.db.entity.PeriodLimitCache;
import com.stepos.familyguard.db.entity.RawPeriodCache;
import com.stepos.familyguard.net.entity.BaseEntity;
import com.stepos.familyguard.net.entity.RawLimitInfoEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import k2.InterfaceC0801e;
import k2.InterfaceC0805i;
import l0.AbstractC0822a;
import l2.C0835d;
import l2.InterfaceC0839h;
import l2.InterfaceC0841j;
import m2.C0861d;

/* renamed from: t2.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1118B extends r {

    /* renamed from: A, reason: collision with root package name */
    private static final boolean f22487A = R1.a.f("CLRP", R1.a.f4966b);

    /* renamed from: s, reason: collision with root package name */
    private final v2.d f22488s;

    /* renamed from: t, reason: collision with root package name */
    private final long f22489t;

    /* renamed from: u, reason: collision with root package name */
    private final A3.b f22490u;

    /* renamed from: v, reason: collision with root package name */
    private PeriodLimitCache f22491v;

    /* renamed from: w, reason: collision with root package name */
    private final InterfaceC0805i f22492w;

    /* renamed from: x, reason: collision with root package name */
    private final InterfaceC0839h f22493x;

    /* renamed from: y, reason: collision with root package name */
    private final InterfaceC0841j f22494y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f22495z;

    public C1118B(int i5, v2.e eVar, long j5) {
        super(i5, eVar, j5);
        this.f22490u = new A3.b();
        this.f22495z = false;
        v2.d dVar = (v2.d) eVar;
        this.f22488s = dVar;
        this.f22489t = dVar.e();
        this.f22492w = FamilyGuardDatabase.x().z();
        this.f22493x = FamilyGuardDatabase.x().B();
        this.f22494y = FamilyGuardDatabase.x().C();
    }

    public static /* synthetic */ void U(BaseEntity baseEntity) {
    }

    private RawPeriodInfo V() {
        RawPeriodInfo rawPeriodInfo = RawPeriodInfo.getDefault();
        rawPeriodInfo.setLimitId(this.f22491v.getId());
        RawPeriodCache rawPeriodCache = new RawPeriodCache(rawPeriodInfo, this.f22489t);
        rawPeriodCache.setLimitCacheId(this.f22491v.getId());
        rawPeriodInfo.setId(this.f22494y.c(rawPeriodCache));
        return rawPeriodInfo;
    }

    private CategoryLimitCache W() {
        InterfaceC0801e interfaceC0801eV = FamilyGuardDatabase.x().v();
        com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
        CategoryLimitCache categoryLimitCacheF = interfaceC0801eV.f(aVar.ordinal(), K(), this.f22489t);
        return new CategoryLimitCache(aVar.ordinal(), K(), s().e().longValue(), v().e().longValue(), D().e().booleanValue(), E().e().booleanValue(), 0, 0L, 0L, this.f22489t, categoryLimitCacheF != null ? 1 + categoryLimitCacheF.getVersion() : 1L);
    }

    private PeriodLimitCache X() {
        PeriodLimitCache periodLimitCache = this.f22491v;
        boolean z5 = E() != null && E().e().booleanValue();
        boolean z6 = p() != null && p().e().booleanValue();
        if (periodLimitCache == null) {
            return new PeriodLimitCache(1, null, K(), E().e().booleanValue(), p().e().booleanValue(), 1L, this.f22489t);
        }
        if (z6 == periodLimitCache.isEnable() && z5 == periodLimitCache.isNotifyOnly() && !this.f22495z) {
            return null;
        }
        return new PeriodLimitCache(periodLimitCache.getId(), periodLimitCache.getPeriodLimitId(), periodLimitCache.getType(), periodLimitCache.getPackageName(), periodLimitCache.getCategoryId(), z5, z6, periodLimitCache.getRemoteVersion() + 1, periodLimitCache.getRelationId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List Y(PeriodLimitCache periodLimitCache) {
        List<RawPeriodInfo> listD0;
        p().k(Boolean.valueOf(periodLimitCache.isEnable()));
        this.f22491v = periodLimitCache;
        synchronized (this.f22494y) {
            try {
                listD0 = d0(periodLimitCache.getId());
                if (listD0 == null || listD0.isEmpty()) {
                    PeriodLimitCache periodLimitCache2 = this.f22491v;
                    if (periodLimitCache2 != null && !periodLimitCache2.isEnable() && this.f22491v.getRemoteVersion() == 1) {
                        listD0.add(V());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listD0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(List list) {
        F().k(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(InterfaceC0801e interfaceC0801e, CategoryLimitCache categoryLimitCache, PeriodLimitCache periodLimitCache) {
        interfaceC0801e.c(this.f22489t, K());
        interfaceC0801e.e(categoryLimitCache);
        if (periodLimitCache != null) {
            this.f22493x.e(K(), this.f22489t);
            this.f22493x.c(periodLimitCache);
            List<RawPeriodCache> listF = this.f22494y.f(periodLimitCache.getId(), this.f22489t);
            long remoteVersion = periodLimitCache.getRemoteVersion();
            if (listF != null) {
                for (RawPeriodCache rawPeriodCache : listF) {
                    rawPeriodCache.setRemoteVersion(remoteVersion);
                    this.f22494y.d(rawPeriodCache);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Q4.a b0(String str) {
        return C0861d.a().e(this.f22489t, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(CategoryLimitCache categoryLimitCache) {
        if (f22487A) {
            R1.a.a("CLRP", "onCategoryLimitLoaded categoryLimitCache = " + categoryLimitCache);
        }
        if (categoryLimitCache == null) {
            return;
        }
        long workdayLimit = categoryLimitCache.getWorkdayLimit();
        long offDayLimit = categoryLimitCache.getOffDayLimit();
        boolean zIsEnable = categoryLimitCache.isEnable();
        boolean zIsNotifyOnly = categoryLimitCache.isNotifyOnly();
        s().k(Long.valueOf(workdayLimit));
        v().k(Long.valueOf(offDayLimit));
        D().k(Boolean.valueOf(zIsEnable));
        E().k(Boolean.valueOf(zIsNotifyOnly));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(List<C0835d> list) {
        Category category = new Category(K(), W1.c.m(K()), System.currentTimeMillis());
        Iterator<C0835d> it = list.iterator();
        while (it.hasNext()) {
            category.add(it.next().f18179b);
        }
        J().k(category);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h0(List<PackageLimitCache> list, List<CategoryLimitCache> list2, List<PeriodLimitCache> list3, List<RawPeriodCache> list4) {
        RawLimitInfoEntity rawLimitInfoEntity = new RawLimitInfoEntity();
        rawLimitInfoEntity.packageLimitList = list;
        rawLimitInfoEntity.categoryLimitList = list2;
        rawLimitInfoEntity.periodLimitList = list3;
        rawLimitInfoEntity.rawPeriodList = list4;
        rawLimitInfoEntity.updateTime = System.currentTimeMillis();
        return AbstractC0822a.F(rawLimitInfoEntity);
    }

    private void i0() {
        InterfaceC0805i interfaceC0805iZ = FamilyGuardDatabase.x().z();
        InterfaceC0801e interfaceC0801eV = FamilyGuardDatabase.x().v();
        com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
        x3.q.p(interfaceC0805iZ.a(aVar.ordinal(), this.f22489t), interfaceC0801eV.a(aVar.ordinal(), this.f22489t), this.f22493x.h(this.f22489t), this.f22494y.b(this.f22489t), new D3.e() { // from class: t2.s
            @Override // D3.e
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
                return this.f22631a.h0((List) obj, (List) obj2, (List) obj3, (List) obj4);
            }
        }).g(new D3.h() { // from class: t2.t
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f22632a.b0((String) obj);
            }
        }).X(T3.a.c()).T(new D3.c() { // from class: t2.u
            @Override // D3.c
            public final void accept(Object obj) {
                C1118B.U((BaseEntity) obj);
            }
        }, S1.a.b());
    }

    @Override // t2.Y
    public void A(RawPeriodInfo rawPeriodInfo) {
        RawPeriodCache rawPeriodCache = new RawPeriodCache(rawPeriodInfo, this.f22489t);
        rawPeriodCache.setLimitCacheId(this.f22491v.getId());
        rawPeriodInfo.setId(this.f22494y.c(rawPeriodCache));
        F().k(d0(this.f22491v.getId()));
        this.f22495z = true;
    }

    @Override // t2.Y
    public void B(RawPeriodInfo rawPeriodInfo) {
        long id = rawPeriodInfo.getId();
        if (this.f22494y.e(id, this.f22489t) == null) {
            id = this.f22494y.c(new RawPeriodCache(rawPeriodInfo, this.f22489t));
        } else {
            this.f22494y.d(new RawPeriodCache(rawPeriodInfo, this.f22489t));
        }
        rawPeriodInfo.setId(id);
        d0(this.f22491v.getId());
        F().k(d0(this.f22491v.getId()));
        this.f22495z = true;
    }

    @Override // v2.AbstractC1182a
    public void I() {
        super.I();
        this.f22490u.dispose();
        this.f22490u.d();
        this.f22495z = false;
    }

    PeriodLimitCache c0() {
        PeriodLimitCache periodLimitCacheA = FamilyGuardDatabase.x().B().a(K(), this.f22489t);
        if (periodLimitCacheA != null) {
            return periodLimitCacheA;
        }
        PeriodLimitCache periodLimitCache = new PeriodLimitCache(1, null, K(), E().e().booleanValue(), false, 1L, this.f22489t);
        periodLimitCache.setId(this.f22493x.c(periodLimitCache));
        return periodLimitCache;
    }

    List<RawPeriodInfo> d0(long j5) {
        List<RawPeriodCache> listF = this.f22494y.f(j5, this.f22489t);
        ArrayList arrayList = new ArrayList();
        if (listF != null && !listF.isEmpty()) {
            Iterator<RawPeriodCache> it = listF.iterator();
            while (it.hasNext()) {
                arrayList.add(new RawPeriodInfo(it.next()));
            }
        }
        Collections.sort(arrayList, new RawPeriodInfo.b());
        return arrayList;
    }

    @Override // t2.Y
    public void e(long j5) {
        this.f22494y.a(j5);
        F().k(d0(this.f22491v.getId()));
        this.f22495z = true;
    }

    public void g0(final CategoryLimitCache categoryLimitCache, final PeriodLimitCache periodLimitCache) {
        final InterfaceC0801e interfaceC0801eV = FamilyGuardDatabase.x().v();
        FamilyGuardDatabase.x().r(new Runnable() { // from class: t2.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f22637a.a0(interfaceC0801eV, categoryLimitCache, periodLimitCache);
            }
        });
    }

    @Override // t2.Y
    public void i() {
        CategoryLimitCache categoryLimitCacheW = W();
        g0(categoryLimitCacheW, X());
        i0();
        B2.a.e(categoryLimitCacheW.isEnable(), categoryLimitCacheW.getWorkdayLimit(), categoryLimitCacheW.getOffDayLimit(), categoryLimitCacheW.getCategoryId(), categoryLimitCacheW.isNotifyOnly(), M().e() == null ? -1 : M().e().intValue());
    }

    @Override // t2.Y
    public void m() {
        R1.a.a("CLRP", "queryLimit");
        this.f22490u.c(FamilyGuardDatabase.x().v().d(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), K(), this.f22488s.e()).n(T3.a.c()).l(new D3.c() { // from class: t2.v
            @Override // D3.c
            public final void accept(Object obj) {
                this.f22633a.e0((CategoryLimitCache) obj);
            }
        }, S1.a.b()));
        this.f22490u.c(x3.f.x(new Callable() { // from class: t2.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f22634a.c0();
            }
        }).E(new D3.h() { // from class: t2.x
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f22635a.Y((PeriodLimitCache) obj);
            }
        }).X(T3.a.c()).T(new D3.c() { // from class: t2.y
            @Override // D3.c
            public final void accept(Object obj) {
                this.f22636a.Z((List) obj);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public boolean t() {
        l2.m mVarF = this.f22488s.f();
        return mVarF != null && mVarF.f18258p >= 6006000;
    }

    @Override // t2.Y
    public String w() {
        l2.m mVarF = this.f22488s.f();
        if (mVarF == null) {
            return null;
        }
        q2.l lVarA = q2.l.a(mVarF.f18256n);
        Application applicationA = P1.a.a();
        return applicationA.getString(R.string.us_salve_unlimitable_des, applicationA.getString(lVarA.f19927c[1]));
    }

    @Override // t2.InterfaceC1136p
    public void y(int i5) {
        this.f22490u.c(FamilyGuardDatabase.x().y().a(this.f22488s.e(), i5).T(new D3.c() { // from class: t2.A
            @Override // D3.c
            public final void accept(Object obj) {
                this.f22486a.f0((List) obj);
            }
        }, S1.a.b()));
        int i6 = FamilyGuardDatabase.x().D().a(this.f22489t).f18256n;
        M().k(Integer.valueOf(i6));
        o().k(Boolean.valueOf(q2.l.b(i6)));
    }
}
