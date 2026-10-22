package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.exchange.repo.ExchangeStatusRepository;
import com.bytedance.android.live.recharge.platform.business.IExchangeStatusService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes47.dex */
public final class ExchangeStatusService implements com.bytedance.android.scope.o, IExchangeStatusService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f89894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f89895b;

    public final ExchangeStatusRepository a() {
        return (ExchangeStatusRepository) this.f89895b.getValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(hw0.d.f487402a), this.f89894a);
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).B0("auto_exchange_switch_changed").observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this)), this.f89894a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f89894a.clear();
        a().release();
    }

    public ExchangeStatusService() {
        this.f89894a = new CompositeDisposable();
        this.f89895b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ExchangeStatusService$mExchangeStatusRepo$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final int getAutoExchangeStatus() {
        return a().curVal();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final boolean isExchangeStatusUnsync() {
        return a().isAlreadySync();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final Observable<Integer> fetchExchangeStatus(int r100) {
        ExchangeStatusRepository r101 = a();
        if ((!r101.isAlreadySync()) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return a().fetchExchangeStatus(r100);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final void syncExchangeStatus(int r100, boolean r101) {
        a().syncExchangeStatus(r100, r101);
    }
}
