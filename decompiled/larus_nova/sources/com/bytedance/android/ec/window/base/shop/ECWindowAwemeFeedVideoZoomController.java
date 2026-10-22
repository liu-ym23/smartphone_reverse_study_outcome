package com.bytedance.android.ec.window.base.shop;

import android.animation.ValueAnimator;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/ECWindowAwemeFeedVideoZoomController;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowAwemeFeedVideoZoomController implements LifecycleObserver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f49561i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f49562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f49563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n83.m f49564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f49565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f49566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f49567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f49568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f49569h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowAwemeFeedVideoZoomController f49570a;

        public b(ECWindowAwemeFeedVideoZoomController r100) {
            this.f49570a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowAwemeFeedVideoZoomController r100 = this.f49570a;     // Catch: Throwable -> L4
            int r101 = ECWindowAwemeFeedVideoZoomController.f49561i;     // Catch: Throwable -> L4
            r100.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowAwemeFeedVideoZoomController f49571a;

        public c(ECWindowAwemeFeedVideoZoomController r100) {
            this.f49571a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ECWindowAwemeFeedVideoZoomController r101 = this.f49571a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            int r103 = ((Integer) r102).intValue();
            int r104 = ECWindowAwemeFeedVideoZoomController.f49561i;
            r101.b(r103);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        ValueAnimator r100 = this.f49567f;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{this.f49566e, 0});
        r101.setDuration(150);
        r101.addUpdateListener(new com.bytedance.android.ec.window.base.shop.b(this));
        Unit r102 = Unit.INSTANCE;
        this.f49567f = r101;
        r101.start();
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        if (this.f49563b == true) goto L9;
        this.f49563b = true;
        if (this.f49569h == false) goto L7;
        new Handler().post(new b(this));
        return;
    L7:
        a();
        return;
    }

    public final void a() {
        ValueAnimator r100 = this.f49562a;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f49568g});
        r101.setDuration(150);
        r101.addUpdateListener(new c(this));
        Unit r102 = Unit.INSTANCE;
        this.f49562a = r101;
        r101.start();
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    public final void b(int r100) {
        if (r100 > this.f49568g) goto L10;
        if (r100 < 0) goto L12;
        this.f49566e = r100;
        n83.m r101 = this.f49564c;
        if (r101 == null) goto L11;
        r101.a();
        return;
    L11:
        return;
    L12:
        return;
    }

    public ECWindowAwemeFeedVideoZoomController(int r100, int r101) {
        this.f49568g = r100;
        this.f49569h = true;
        this.f49564c = rp.b.f538831a.get(Integer.valueOf(r101));
    }
}
