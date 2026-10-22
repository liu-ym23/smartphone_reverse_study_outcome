package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import com.bytedance.android.live.network.response.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorCouponContextService f84337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f84338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f84339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f84340d;

    public b(AnchorCouponContextService r100, int r101, Function1 r102, Function1 r103) {
        this.f84337a = r100;
        this.f84338b = r101;
        this.f84339c = r102;
        this.f84340d = r103;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        e r101 = (e) r100;
        if (((com.bytedance.android.live.openplatform.api.model.coupon.a) r101.data).c() != 0) goto L5;
        int r102 = qo0.a.f534145a;
        qo0.a.c("AnchorCouponContextService", "get coupon entrance info success, data: " + ((com.bytedance.android.live.openplatform.api.model.coupon.a) r101.data));
        this.f84337a.f84333a.put(Integer.valueOf(this.f84338b), (com.bytedance.android.live.openplatform.api.model.coupon.a) r101.data);
        this.f84339c.invoke(r101.data);
        return;
    L5:
        qo0.a.b("AnchorCouponContextService", "get coupon entrance info fail, data is null", null);
        this.f84340d.invoke(new Throwable("entrance info is null"));
    }
}
