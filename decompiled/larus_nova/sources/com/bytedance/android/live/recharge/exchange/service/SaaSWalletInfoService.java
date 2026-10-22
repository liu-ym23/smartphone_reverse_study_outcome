package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.exchange.repo.SaaSDiamondExchangeRepo;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class SaaSWalletInfoService implements com.bytedance.android.scope.o, zv0.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f89896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f89897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.recharge.exchange.model.h f89898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yz0.k f89899d;

    public static final class a {
    }

    static {
    }

    @Override // zv0.i
    public final boolean h1() {
        if (((wh6.a) vh6.c.b(wh6.a.class)).getAppId() != 247160) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L14;
        com.bytedance.android.live.recharge.exchange.model.h r101 = this.f89898c;
        if (r101 != null) goto L10;
    L12:
        return false;
    L10:
        if (r101.f89866a != true) goto L12;
        return true;
    L14:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (((Boolean) lw0.b.f510992f.getValue(null, lw0.b.f510987a[4])).booleanValue() == true) goto L5;
        return;
    L5:
        if (((wh6.a) vh6.c.b(wh6.a.class)).getAppId() != 247160) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L10;
        return;
    L10:
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L12;
        ALogger.w("XiguaWalletInfoService", "user not login, skip xigua wallet info.");
        return;
    L12:
        String r101 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        RxUtilKt.c(((SaaSDiamondExchangeRepo) this.f89897b.getValue()).fetchXiguaExchangeInfo(r101).subscribe(new p(this), q.f89966a), this.f89896a);
        return;
    L7:
        r100 = false;
        goto L8
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f89896a.clear();
    }

    public SaaSWalletInfoService(yz0.k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f89899d = r100;
        this.f89896a = new CompositeDisposable();
        this.f89897b = LazyKt.lazy(SaaSWalletInfoService$saaSWalletInfoRepo$2.INSTANCE);
    }
}
