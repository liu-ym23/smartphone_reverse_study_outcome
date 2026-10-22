package com.bytedance.android.livesdk.livecommerce.saascoupon;

import com.bytedance.android.ec.sdk.helper.r;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SaasCouponService f152863a;

    public b(SaasCouponService r100) {
        this.f152863a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        boolean r102 = r.f48132a.isLogin();
        if (this.f152863a.g() == true) goto L17;
        if (r102 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.f152863a.f152829c.f19406c, "room_qcpx_coupon_popup") == true) goto L8;
    L9:
        Disposable r103 = this.f152863a.f152847u;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        SaasCouponService r104 = this.f152863a;
        r104.f152847u = null;
        r104.f152830d.removeCallbacks((Runnable) r104.f152843q.getValue());
        SaasCouponService r105 = this.f152863a;
        Runnable r106 = r105.f152845s;
        if (r106 == null) goto L15;
        r105.f152830d.removeCallbacks(r106);
    L15:
        this.f152863a.e(false, false);
        return;
    L8:
        if (this.f152863a.f152835i == false) goto L9;
        return;
    }
}
