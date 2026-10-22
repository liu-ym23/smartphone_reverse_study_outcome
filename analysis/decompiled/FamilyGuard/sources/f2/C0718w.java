package f2;

import b2.AbstractC0558a;
import b2.C0560c;
import b2.C0562e;
import com.stepos.digitalwellbeing.DigitalWellbeingDataBase;
import com.stepos.digitalwellbeing.server.net.BaseEntity;
import com.stepos.digitalwellbeing.server.net.workday.WorkdayEntity;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: f2.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0718w {

    /* renamed from: b, reason: collision with root package name */
    private static C0718w f16801b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Long, Boolean> f16802a = new HashMap();

    private C0718w() {
    }

    private void f(final List<WorkdayEntity> list) {
        this.f16802a.clear();
        DigitalWellbeingDataBase digitalWellbeingDataBaseB = U1.a.c(P1.a.a()).b();
        final AbstractC0558a abstractC0558aA = digitalWellbeingDataBaseB.A();
        digitalWellbeingDataBaseB.r(new Runnable() { // from class: f2.v
            @Override // java.lang.Runnable
            public final void run() throws ParseException {
                this.f16798a.k(list, abstractC0558aA);
            }
        });
        C0702g.b("WorkdayUtil", "apply = " + this + " mAdjustMap = " + C0702g.m(this.f16802a));
    }

    public static synchronized C0718w g() {
        try {
            if (f16801b == null) {
                f16801b = new C0718w();
            }
            C0702g.b("WorkdayUtil", "getInstance instance = " + f16801b);
        } catch (Throwable th) {
            throw th;
        }
        return f16801b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(List list, AbstractC0558a abstractC0558a) throws ParseException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WorkdayEntity workdayEntity = (WorkdayEntity) it.next();
            long jB = C0711p.b(workdayEntity.date);
            boolean z5 = workdayEntity.status == 2;
            this.f16802a.put(Long.valueOf(jB), Boolean.valueOf(z5));
            C0560c c0560c = new C0560c();
            c0560c.f11808a = jB;
            c0560c.f11809b = z5;
            abstractC0558a.a(c0560c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map l(Boolean bool) {
        return bool.booleanValue() ? o() : this.f16802a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(BaseEntity baseEntity) {
        f((List) baseEntity.value);
    }

    private Map<Long, Boolean> o() {
        this.f16802a.clear();
        for (C0560c c0560c : U1.a.c(P1.a.a()).b().A().b()) {
            this.f16802a.put(Long.valueOf(c0560c.f11808a), Boolean.valueOf(c0560c.f11809b));
        }
        C0702g.b("WorkdayUtil", "loadFromDatabase = " + this + " mAdjustMap = " + C0702g.m(this.f16802a));
        return this.f16802a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean m(long j5, Map<Long, Boolean> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        long jLongValue = ((Long) Collections.max(map.keySet())).longValue();
        return j5 > jLongValue && C0711p.D(j5) > C0711p.D(jLongValue);
    }

    private void q(final long j5) {
        C0702g.b("WorkdayUtil", "update instance = " + this);
        x3.f.D(Boolean.valueOf(this.f16802a.isEmpty())).E(new D3.h() { // from class: f2.r
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f16794a.l((Boolean) obj);
            }
        }).q(new D3.j() { // from class: f2.s
            @Override // D3.j
            public final boolean test(Object obj) {
                return this.f16795a.m(j5, (Map) obj);
            }
        }).r(new D3.h() { // from class: f2.t
            @Override // D3.h
            public final Object apply(Object obj) {
                return C0562e.b().a();
            }
        }).X(T3.a.c()).T(new D3.c() { // from class: f2.u
            @Override // D3.c
            public final void accept(Object obj) {
                this.f16797a.n((BaseEntity) obj);
            }
        }, S1.a.b());
    }

    public void h() {
        q(System.currentTimeMillis());
    }

    public boolean i() {
        return j(System.currentTimeMillis());
    }

    public boolean j(long j5) {
        long jK = C0711p.k(j5);
        C0702g.b("WorkdayUtil", "isWorkDay instance = " + this + " mAdjustMap = " + C0702g.m(this.f16802a));
        if (this.f16802a.containsKey(Long.valueOf(jK)) && this.f16802a.get(Long.valueOf(jK)) != null) {
            return this.f16802a.get(Long.valueOf(jK)).booleanValue();
        }
        int iA = C0711p.A(P1.a.a(), j5);
        return (iA == 7 || iA == 1) ? false : true;
    }
}
