package com.bytedance.android.live.recharge.panel.context;

import android.content.Context;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.order.Order;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    com.bytedance.android.live.recharge.model.d a();

    a b();

    PublishSubject<Unit> c();

    com.bytedance.android.live.revenue.common.reactive.c d();

    String e();

    com.bytedance.android.live.revenue.common.reactive.b<Order> f();

    com.bytedance.android.live.revenue.common.reactive.e<i> g();

    CompositeDisposable getCd();

    com.bytedance.android.live.recharge.trace.session.a getSession();

    void h();

    Context i();
}
