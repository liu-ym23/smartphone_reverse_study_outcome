package com.bytedance.android.live.incentive.exchange.strategy;

import com.bytedance.android.live.incentive.exchange.l;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.incentive.balance.d f69367a;

        public a(com.bytedance.android.live.incentive.balance.d r100, PublishSubject r101) {
            Intrinsics.checkNotNullParameter(r100, "balanceRepository");
            Intrinsics.checkNotNullParameter(r101, "incomeExchangeResult");
            this.f69367a = r100;
        }
    }

    boolean a();

    void b(a r100);

    boolean d(long r100);

    boolean f();

    void g(l r100);
}
