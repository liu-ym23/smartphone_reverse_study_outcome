package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g0 implements com.bytedance.android.scope.o, x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f131558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f131559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f131560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i12.e f131561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final yz0.k f131562e;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f131563a;

        public a(g0 r100) {
            this.f131563a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
        L8:
            if (r101 != null) goto L11;
        L13:
            if (r101 != null) goto L16;
        L18:
            if (r101 != null) goto L21;
            return;
        L21:
            if (r101.intValue() != 0) goto L27;
            this.f131563a.f131559b.setValue(Boolean.FALSE);
            return;
        L27:
            return;
        L16:
            if (r101.intValue() != 11) goto L18;
            this.f131563a.f131559b.setValue(Boolean.TRUE);
            return;
        L11:
            if (r101.intValue() != 2) goto L13;
            this.f131563a.f131559b.setValue(Boolean.TRUE);
            return;
        L6:
            if (r101.intValue() != 1) goto L8;
            this.f131563a.f131559b.setValue(Boolean.TRUE);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.x2
    public final void g0() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(new o02.a(this.f131561d, this.f131562e.getDataCenter())), this.f131558a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131558a.dispose();
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().a() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.a() == false) goto L9;
        LiveData r100 = ((tr2.a) vh6.c.b(tr2.a.class)).Ki("degrade_level", -1);
        if (r100 == null) goto L12;
        r100.removeObserver(this.f131560c);
        return;
    L12:
        return;
    L9:
        ((com.bytedance.android.livesdk.revenue.service.performance.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class)).unregisterPerformanceStrategyTask(530);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().a() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.a() == false) goto L9;
        LiveData r100 = ((tr2.a) vh6.c.b(tr2.a.class)).Ki("degrade_level", -1);
        if (r100 == null) goto L12;
        r100.observeForever(this.f131560c);
        return;
    L12:
        return;
    L9:
        ((com.bytedance.android.livesdk.revenue.service.performance.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class)).e6(530, new h0(this));
    }

    public g0(i12.e r100, yz0.k r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        this.f131561d = r100;
        this.f131562e = r101;
        this.f131558a = new CompositeDisposable();
        this.f131559b = new MutableLiveData();
        this.f131560c = new a(this);
    }
}
