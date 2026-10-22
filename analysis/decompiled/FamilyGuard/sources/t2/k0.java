package t2;

import android.app.Application;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.familyguard.R;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import com.stepos.familyguard.db.entity.CategoryLimitCache;
import com.stepos.familyguard.db.entity.PackageLimitCache;
import com.stepos.familyguard.db.entity.PeriodLimitCache;
import com.stepos.familyguard.db.entity.RawPeriodCache;
import com.stepos.familyguard.net.entity.BaseEntity;
import com.stepos.familyguard.net.entity.RawLimitInfoEntity;
import f2.C0702g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import k2.InterfaceC0801e;
import k2.InterfaceC0805i;
import l0.AbstractC0822a;
import l2.InterfaceC0839h;
import l2.InterfaceC0841j;
import m2.C0861d;

/* loaded from: classes.dex */
public class k0 extends b0 {

    /* renamed from: z, reason: collision with root package name */
    private static final boolean f22589z = R1.a.f("PackageLimitRemoteProxy", R1.a.f4966b);

    /* renamed from: r, reason: collision with root package name */
    private final v2.d f22590r;

    /* renamed from: s, reason: collision with root package name */
    private final long f22591s;

    /* renamed from: t, reason: collision with root package name */
    private final A3.b f22592t;

    /* renamed from: u, reason: collision with root package name */
    private PeriodLimitCache f22593u;

    /* renamed from: v, reason: collision with root package name */
    private final InterfaceC0805i f22594v;

    /* renamed from: w, reason: collision with root package name */
    private final InterfaceC0839h f22595w;

    /* renamed from: x, reason: collision with root package name */
    private final InterfaceC0841j f22596x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f22597y;

    public k0(String str, v2.e eVar, long j5) {
        super(str, eVar, j5);
        this.f22592t = new A3.b();
        this.f22597y = false;
        v2.d dVar = (v2.d) eVar;
        this.f22590r = dVar;
        this.f22591s = dVar.e();
        j().k(Boolean.valueOf(Y1.l.T0(K())));
        this.f22594v = FamilyGuardDatabase.x().z();
        this.f22595w = FamilyGuardDatabase.x().B();
        this.f22596x = FamilyGuardDatabase.x().C();
    }

    public static /* synthetic */ void S(BaseEntity baseEntity) {
    }

    private RawPeriodInfo T() {
        RawPeriodInfo rawPeriodInfo = RawPeriodInfo.getDefault();
        rawPeriodInfo.setLimitId(this.f22593u.getId());
        RawPeriodCache rawPeriodCache = new RawPeriodCache(rawPeriodInfo, this.f22591s);
        rawPeriodCache.setLimitCacheId(this.f22593u.getId());
        rawPeriodInfo.setId(this.f22596x.c(rawPeriodCache));
        return rawPeriodInfo;
    }

    private PackageLimitCache U() {
        PackageLimitCache packageLimitCacheD = this.f22594v.d(this.f22591s, K());
        return new PackageLimitCache(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), K(), s().e().longValue(), v().e().longValue(), 0, D().e().booleanValue(), E().e().booleanValue(), 0L, this.f22591s, packageLimitCacheD != null ? 1 + packageLimitCacheD.getVersion() : 1L);
    }

    private PeriodLimitCache V() {
        PeriodLimitCache periodLimitCache = this.f22593u;
        boolean z5 = E() != null && E().e().booleanValue();
        boolean z6 = p() != null && p().e().booleanValue();
        if (periodLimitCache == null) {
            return new PeriodLimitCache(0, K(), -1L, E().e().booleanValue(), p().e().booleanValue(), 1L, this.f22591s);
        }
        if (z6 == periodLimitCache.isEnable() && z5 == periodLimitCache.isNotifyOnly() && !this.f22597y) {
            return null;
        }
        return new PeriodLimitCache(periodLimitCache.getId(), periodLimitCache.getPeriodLimitId(), periodLimitCache.getType(), periodLimitCache.getPackageName(), periodLimitCache.getCategoryId(), z5, z6, periodLimitCache.getRemoteVersion() + 1, periodLimitCache.getRelationId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List W(PeriodLimitCache periodLimitCache) {
        List<RawPeriodInfo> listB0;
        p().k(Boolean.valueOf(periodLimitCache.isEnable()));
        this.f22593u = periodLimitCache;
        synchronized (this.f22596x) {
            try {
                listB0 = b0(periodLimitCache.getId());
                if (listB0 == null || listB0.isEmpty()) {
                    PeriodLimitCache periodLimitCache2 = this.f22593u;
                    if (periodLimitCache2 != null && !periodLimitCache2.isEnable() && this.f22593u.getRemoteVersion() == 1) {
                        listB0.add(T());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listB0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(List list) {
        F().k(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(PackageLimitCache packageLimitCache, PeriodLimitCache periodLimitCache) {
        this.f22594v.b(this.f22591s, K());
        this.f22594v.c(packageLimitCache);
        if (periodLimitCache != null) {
            this.f22595w.g(K(), this.f22591s);
            this.f22595w.c(periodLimitCache);
            List<RawPeriodCache> listF = this.f22596x.f(periodLimitCache.getId(), this.f22591s);
            long remoteVersion = periodLimitCache.getRemoteVersion();
            if (listF != null) {
                for (RawPeriodCache rawPeriodCache : listF) {
                    rawPeriodCache.setRemoteVersion(remoteVersion);
                    this.f22596x.d(rawPeriodCache);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Q4.a Z(String str) {
        return C0861d.a().e(this.f22591s, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(PackageLimitCache packageLimitCache) {
        if (packageLimitCache == null) {
            return;
        }
        long workdayLimit = packageLimitCache.getWorkdayLimit();
        long offDayLimit = packageLimitCache.getOffDayLimit();
        boolean zIsEnable = packageLimitCache.isEnable();
        boolean zIsNotifyOnly = packageLimitCache.isNotifyOnly();
        s().k(Long.valueOf(workdayLimit));
        v().k(Long.valueOf(offDayLimit));
        D().k(Boolean.valueOf(zIsEnable));
        E().k(Boolean.valueOf(zIsNotifyOnly));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e0(List<PackageLimitCache> list, List<CategoryLimitCache> list2, List<PeriodLimitCache> list3, List<RawPeriodCache> list4) {
        RawLimitInfoEntity rawLimitInfoEntity = new RawLimitInfoEntity();
        rawLimitInfoEntity.packageLimitList = list;
        rawLimitInfoEntity.categoryLimitList = list2;
        rawLimitInfoEntity.periodLimitList = list3;
        rawLimitInfoEntity.rawPeriodList = list4;
        rawLimitInfoEntity.updateTime = System.currentTimeMillis();
        return AbstractC0822a.F(rawLimitInfoEntity);
    }

    private void f0() {
        InterfaceC0801e interfaceC0801eV = FamilyGuardDatabase.x().v();
        InterfaceC0805i interfaceC0805i = this.f22594v;
        com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
        x3.q.p(interfaceC0805i.a(aVar.ordinal(), this.f22591s), interfaceC0801eV.a(aVar.ordinal(), this.f22591s), this.f22595w.h(this.f22591s), this.f22596x.b(this.f22591s), new D3.e() { // from class: t2.c0
            @Override // D3.e
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
                return this.f22572a.e0((List) obj, (List) obj2, (List) obj3, (List) obj4);
            }
        }).g(new D3.h() { // from class: t2.d0
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f22574a.Z((String) obj);
            }
        }).X(T3.a.c()).T(new D3.c() { // from class: t2.e0
            @Override // D3.c
            public final void accept(Object obj) {
                k0.S((BaseEntity) obj);
            }
        }, S1.a.b());
    }

    @Override // t2.Y
    public void A(RawPeriodInfo rawPeriodInfo) {
        RawPeriodCache rawPeriodCache = new RawPeriodCache(rawPeriodInfo, this.f22591s);
        rawPeriodCache.setLimitCacheId(this.f22593u.getId());
        rawPeriodInfo.setId(this.f22596x.c(rawPeriodCache));
        F().k(b0(this.f22593u.getId()));
        this.f22597y = true;
    }

    @Override // t2.Y
    public void B(RawPeriodInfo rawPeriodInfo) {
        C0702g.b("PackageLimitRemoteProxy", "updatePeriod() called with: rawPeriodInfo = [" + rawPeriodInfo + "]");
        long id = rawPeriodInfo.getId();
        if (this.f22596x.e(id, this.f22591s) == null) {
            id = this.f22596x.c(new RawPeriodCache(rawPeriodInfo, this.f22591s));
        } else {
            C0702g.b("PackageLimitRemoteProxy", "update rawPeriodInfo = " + rawPeriodInfo);
            this.f22596x.d(new RawPeriodCache(rawPeriodInfo, this.f22591s));
        }
        rawPeriodInfo.setId(id);
        F().k(b0(this.f22593u.getId()));
        this.f22597y = true;
    }

    @Override // v2.AbstractC1182a
    public void I() {
        super.I();
        this.f22592t.dispose();
        this.f22592t.d();
        this.f22597y = false;
    }

    PeriodLimitCache a0() {
        PeriodLimitCache periodLimitCacheD = FamilyGuardDatabase.x().B().d(K(), this.f22591s);
        if (periodLimitCacheD != null) {
            return periodLimitCacheD;
        }
        PeriodLimitCache periodLimitCache = new PeriodLimitCache(0, K(), -1L, E().e().booleanValue(), false, 1L, this.f22591s);
        periodLimitCache.setId(this.f22595w.c(periodLimitCache));
        return periodLimitCache;
    }

    List<RawPeriodInfo> b0(long j5) {
        List<RawPeriodCache> listF = this.f22596x.f(j5, this.f22591s);
        ArrayList arrayList = new ArrayList();
        if (listF != null && !listF.isEmpty()) {
            Iterator<RawPeriodCache> it = listF.iterator();
            while (it.hasNext()) {
                arrayList.add(new RawPeriodInfo(it.next()));
            }
        }
        Collections.sort(arrayList, new RawPeriodInfo.b());
        C0702g.b("PackageLimitRemoteProxy", "loadRawPeriodInfo() called with: id = [" + j5 + "] infos = " + C0702g.k(arrayList));
        return arrayList;
    }

    public void d0(final PackageLimitCache packageLimitCache, final PeriodLimitCache periodLimitCache) {
        FamilyGuardDatabase.x().r(new Runnable() { // from class: t2.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22577a.Y(packageLimitCache, periodLimitCache);
            }
        });
    }

    @Override // t2.Y
    public void e(long j5) {
        this.f22596x.a(j5);
        F().k(b0(this.f22593u.getId()));
        this.f22597y = true;
    }

    @Override // t2.b0, t2.Y
    public void i() {
        PackageLimitCache packageLimitCacheU = U();
        d0(packageLimitCacheU, V());
        f0();
        B2.a.d(packageLimitCacheU.isEnable(), packageLimitCacheU.getWorkdayLimit(), packageLimitCacheU.getOffDayLimit(), packageLimitCacheU.getPackageName(), packageLimitCacheU.isNotifyOnly(), L().e() == null ? -1 : L().e().intValue());
    }

    @Override // t2.b0, t2.Y
    public void m() {
        this.f22592t.c(this.f22594v.e(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), this.f22590r.e(), K()).l(new D3.c() { // from class: t2.g0
            @Override // D3.c
            public final void accept(Object obj) {
                this.f22581a.c0((PackageLimitCache) obj);
            }
        }, S1.a.b()));
        int i5 = FamilyGuardDatabase.x().D().a(this.f22591s).f18256n;
        L().k(Integer.valueOf(i5));
        o().k(Boolean.valueOf(q2.l.b(i5)));
        this.f22592t.c(x3.f.x(new Callable() { // from class: t2.h0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f22583a.a0();
            }
        }).E(new D3.h() { // from class: t2.i0
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f22585a.W((PeriodLimitCache) obj);
            }
        }).X(T3.a.c()).T(new D3.c() { // from class: t2.j0
            @Override // D3.c
            public final void accept(Object obj) {
                this.f22587a.X((List) obj);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public boolean t() {
        l2.m mVarF = this.f22590r.f();
        return mVarF != null && mVarF.f18258p >= 6006000;
    }

    @Override // t2.Y
    public String w() {
        l2.m mVarF = this.f22590r.f();
        if (mVarF == null) {
            return null;
        }
        q2.l lVarA = q2.l.a(mVarF.f18256n);
        Application applicationA = P1.a.a();
        return applicationA.getString(R.string.us_salve_unlimitable_des, applicationA.getString(lVarA.f19927c[1]));
    }
}
