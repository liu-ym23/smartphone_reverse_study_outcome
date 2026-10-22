package com.bytedance.android.livesdk.coupon;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.coupon.api.CouponApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f121819f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f121820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f121821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final at1.a f121822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f121823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f121824e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.coupon.a$a, reason: collision with other inner class name */
    public static final class C1770a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f121825a;

        public b(a r100) {
            this.f121825a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            if (r101 == null) goto L5;
            com.bytedance.android.livesdk.coupon.balancecoupon.model.c r102 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.c) r101.data;
        L6:
            if (r102 != null) goto L8;
            Logger.d("AbsCouponController", "query data is null");
            return;
        L8:
            this.f121825a.h((com.bytedance.android.livesdk.coupon.balancecoupon.model.c) r101.data);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f121826a;

        public c(a r100) {
            this.f121826a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f121826a.getClass();
            ALogger.e("AbsCouponController", "query error, " + ((Throwable) r100));
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f121827a;

        public d(a r100) {
            this.f121827a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            if (r101 == null) goto L5;
            com.bytedance.android.livesdk.coupon.balancecoupon.model.b r102 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.b) r101.data;
        L6:
            if (r102 != null) goto L8;
            Logger.d("AbsCouponController", "obtain data is null");
            return;
        L8:
            this.f121827a.g((com.bytedance.android.livesdk.coupon.balancecoupon.model.b) r101.data);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f121828a;

        public e(a r100) {
            this.f121828a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            a r101 = this.f121828a;
            r101.f((Throwable) r100);
        }
    }

    static {
    }

    public abstract Map<String, Object> b();

    public final boolean c() {
        T r100 = i(this.f121822c);     // Catch: Throwable -> L11
        this.f121821b = r100;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        return false;
    L6:
        Room r101 = (Room) this.f121822c.f16210b.get("data_room", null);
        if (r101 == null) goto L16;
        this.f121820a.add(((CouponApi) com.bytedance.android.live.network.c.b().e(CouponApi.class)).queryBenefitCoupon(r101.getRoomId(), r101.getAnchorId(), this.f121823d, b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this)));
        return true;
    L16:
        return true;
    L11:
        th = move-exception;
        ALogger.e("AbsCouponController", "coupon parseSchema error, " + th);
        return false;
    }

    public abstract boolean d();

    public abstract void f(Throwable r100);

    public abstract void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r100);

    public abstract void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r100);

    public abstract T i(at1.a r100);

    public Map<String, Object> a() {
        return new LinkedHashMap();
    }

    public final void e() {
        Room r100 = (Room) this.f121822c.f16210b.get("data_room", null);
        if (r100 != null) goto L5;
        return;
    L5:
        if (d() == false) goto L8;
        Logger.d("AbsCouponController", "coupon interceptObtain");
        return;
    L8:
        this.f121820a.add(((CouponApi) com.bytedance.android.live.network.c.b().e(CouponApi.class)).exchangeBenefitCoupon(r100.getRoomId(), r100.getAnchorId(), a()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), new e(this)));
    }

    public void j() {
        this.f121820a.dispose();
    }

    public a(at1.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "couponContext");
        this.f121822c = r100;
        this.f121823d = r101;
        this.f121824e = r102;
        this.f121820a = new CompositeDisposable();
    }
}
