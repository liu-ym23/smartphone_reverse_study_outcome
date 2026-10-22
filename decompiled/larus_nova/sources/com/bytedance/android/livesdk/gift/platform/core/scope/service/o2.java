package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePropExpireTime;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class o2 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f131664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends Map<Integer, ? extends List<vz1.e>>> f131665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i12.d f131666c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f131664a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public o2(i12.d r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f131666c = r100;
    }

    public final void c(List<? extends Map<Integer, ? extends List<vz1.e>>> r110) {
        long r100 = com.bytedance.android.live.revenue.common.u0.f91004k.f91006a;
        if (r110 == null) goto L27;
        Iterator<T> r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L27;
        Map.Entry r101 = com.bytedance.android.live.core.utils.z0.a((Map) r111.next());
        if (r101 == null) goto L6;
        List r102 = (List) r101.getValue();
        if (r102 == null) goto L6;
        Iterator r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L6;
        vz1.e r104 = (vz1.e) r103.next();
        if (r104.f557654e == true) goto L16;
        long r105 = r104.f557650a.getGiftEndingTime() - ((System.currentTimeMillis() / 1000) + r104.f557650a.getNowTimeDiffSeconds());
        if (r105 <= 0) goto L13;
        if (r105 >= r100) goto L13;
    L25:
        r100 = r105;
        goto L13
    L16:
        r105 = r104.f557656g.f557681d - ((System.currentTimeMillis() / 1000) + r104.f557656g.f557682e);
        if (r105 <= 0) goto L13;
        if (r105 >= r100) goto L13;
    L27:
        if (r100 <= 0) goto L65;
        Disposable r112 = this.f131664a;
        if (r112 == null) goto L32;
        r112.dispose();
    L32:
        Ref.LongRef r113 = new Ref.LongRef();
        r113.element = r100;
        Ref.LongRef r106 = new Ref.LongRef();
        r106.element = 1;
        long r107 = 1000;
        long r108 = r113.element * r107;
        long r109 = com.bytedance.android.live.revenue.common.u0.f91003j.f91006a;
        if (r108 <= r109) goto L35;
        r106.element = r109 / r107;
    L42:
        if (r113.element <= 0) goto L64;
        com.bytedance.android.live.core.utils.rxutils.j.a r114 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        this.f131664a = RxUtilKt.h(com.bytedance.android.live.core.utils.rxutils.j.c(r106.element, TimeUnit.SECONDS).takeWhile(new m2(r113)).subscribeOn(Schedulers.io())).subscribe(new n2(this, r113, r106));
        return;
    L64:
        return;
    L35:
        long r115 = com.bytedance.android.live.revenue.common.u0.f91002i.f91006a;
        if (r108 <= r115) goto L38;
        r106.element = r115 / r107;
        goto L42
    L38:
        long r116 = com.bytedance.android.live.revenue.common.u0.f91001h.f91006a;
        if (r108 <= r116) goto L42;
        r106.element = r116 / r107;
        goto L42
    }

    public static final void a(o2 r100, long r101, boolean r102) {
        if (r102 == false) goto L7;
        Disposable r103 = r100.f131664a;
        if (r103 == null) goto L6;
        r103.dispose();
    L6:
        r100.c(r100.f131665b);
    L7:
        i12.d r104 = r100.f131666c;
        uz1.a r105 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r105 == null) goto L11;
        r105.a(new UpdatePropExpireTime(r101));
        return;
    }
}
