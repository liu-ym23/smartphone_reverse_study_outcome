package com.bytedance.android.live.revenue;

import com.bytedance.android.live.revenue.service.gift.di.GiftServiceModule_ProvideRegistrarFactory;
import com.bytedance.android.live.revenue.service.link.di.LinkServiceModule_ProvideRegistrarFactory;
import com.bytedance.android.live.revenue.service.profit.di.ProfitServiceModule_ProvideRegistrarFactory;
import com.bytedance.android.live.revenue.service.recharge.di.RechargeServiceModule_ProvideRegistrarFactory;
import dagger.internal.SetBuilder;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements q01.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<q01.a> f91043a;

    @Override // q01.a
    public final void a() {
        Iterator<T> r100 = this.f91043a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((q01.a) r100.next()).a();
        goto L4
    }

    @Override // q01.a
    public final void b() {
        Iterator<T> r100 = this.f91043a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((q01.a) r100.next()).b();
        goto L4
    }

    @Override // q01.a
    public final void c() {
        Iterator<T> r100 = this.f91043a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((q01.a) r100.next()).c();
        goto L4
    }

    @Override // q01.a
    public final void d() {
        Iterator<T> r100 = this.f91043a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((q01.a) r100.next()).d();
        goto L4
    }

    public e() {
        r01.a r100 = r01.b.f535419a.f535418e;
        this.f91043a = SetBuilder.newSetBuilder(4).add(GiftServiceModule_ProvideRegistrarFactory.provideRegistrar(r100.f535414a)).add(LinkServiceModule_ProvideRegistrarFactory.provideRegistrar(r100.f535415b)).add(ProfitServiceModule_ProvideRegistrarFactory.provideRegistrar(r100.f535416c)).add(RechargeServiceModule_ProvideRegistrarFactory.provideRegistrar(r100.f535417d)).build();
    }
}
