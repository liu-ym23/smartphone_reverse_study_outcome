package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.scope.o;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f90354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f90355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f90356d;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f90357a;

        public b(d r100) {
            this.f90357a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Intrinsics.checkNotNullParameter((UserEvent) r100, "it");
            if (this.f90357a.a().isLogin() == true) goto L5;
        L7:
            return false;
        L5:
            if ((!Intrinsics.areEqual(this.f90357a.a().getCurrentUserId(), this.f90357a.f90355c)) == false) goto L7;
            return true;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f90358a;

        public c(d r100) {
            this.f90358a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UserEvent r101 = (UserEvent) r100;
            d r102 = this.f90358a;
            r102.f90355c = r102.a().getCurrentUserId();
            ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().sync("user_change");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.service.d$d, reason: collision with other inner class name */
    public static final class RunnableC1389d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f90359a;

        public RunnableC1389d(d r100) {
            this.f90359a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f90359a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            ((com.bytedance.android.livesdk.revenue.service.message.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.b.class)).aj(r100.f90353a, r100.f90356d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final com.bytedance.android.livesdk.revenue.service.user.a a() {
        return (com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ReadOnlyProperty r100 = com.bytedance.android.live.recharge.utils.j.f90477n;
        KProperty<?>[] r101 = com.bytedance.android.live.recharge.utils.j.f90464a;
        if (((Boolean) r100.getValue(null, r101[12])).booleanValue() == true) goto L6;
        RxUtilKt.c(a().m().filter(new b(this)).subscribe(new c(this)), this.f90354b);
    L6:
        if (((com.bytedance.android.live.recharge.utils.b) com.bytedance.android.live.recharge.utils.j.f90476m.getValue(null, r101[11])).b() == false) goto L9;
        i0.c().postDelayed(new RunnableC1389d(this), 10000);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f90354b.clear();
        ((com.bytedance.android.livesdk.revenue.service.message.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.b.class)).bf(this.f90353a);
    }

    public d() {
        this.f90353a = MessageType.LIVE_DIAMOND_SCORE_MESSAGE.getWsMethod();
        ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter();
        this.f90354b = new CompositeDisposable();
        this.f90355c = a().getCurrentUserId();
        this.f90356d = new a();
    }
}
