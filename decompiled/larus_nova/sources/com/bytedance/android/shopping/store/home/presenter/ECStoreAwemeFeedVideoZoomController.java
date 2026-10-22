package com.bytedance.android.shopping.store.home.presenter;

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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECStoreAwemeFeedVideoZoomController;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreAwemeFeedVideoZoomController implements LifecycleObserver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f184093i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f184094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f184095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n83.m f184096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f184097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f184098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f184099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f184100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f184101h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECStoreAwemeFeedVideoZoomController f184102a;

        public b(ECStoreAwemeFeedVideoZoomController r100) {
            this.f184102a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECStoreAwemeFeedVideoZoomController r100 = this.f184102a;     // Catch: Throwable -> L4
            int r101 = ECStoreAwemeFeedVideoZoomController.f184093i;     // Catch: Throwable -> L4
            r100.b();     // Catch: Throwable -> L4
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
        public final /* synthetic */ ECStoreAwemeFeedVideoZoomController f184103a;

        public c(ECStoreAwemeFeedVideoZoomController r100) {
            this.f184103a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ECStoreAwemeFeedVideoZoomController r101 = this.f184103a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            ECStoreAwemeFeedVideoZoomController.a(r101, ((Integer) r102).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        ValueAnimator r100 = this.f184099f;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{this.f184098e, 0});
        r101.setDuration(150);
        r101.addUpdateListener(new x3(this));
        Unit r102 = Unit.INSTANCE;
        this.f184099f = r101;
        r101.start();
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        if (this.f184095b == true) goto L9;
        this.f184095b = true;
        if (this.f184101h == false) goto L7;
        new Handler().post(new b(this));
        return;
    L7:
        b();
        return;
    }

    public final void b() {
        ValueAnimator r100 = this.f184094a;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f184100g});
        r101.setDuration(150);
        r101.addUpdateListener(new c(this));
        Unit r102 = Unit.INSTANCE;
        this.f184094a = r101;
        r101.start();
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    public ECStoreAwemeFeedVideoZoomController(int r100, int r101) {
        this.f184100g = r100;
        this.f184101h = false;
        this.f184096c = kn.b.f504135a.get(Integer.valueOf(r101));
    }

    public static final void a(ECStoreAwemeFeedVideoZoomController r100, int r101) {
        if (r101 > r100.f184100g) goto L10;
        if (r101 < 0) goto L12;
        r100.f184098e = r101;
        n83.m r102 = r100.f184096c;
        if (r102 == null) goto L11;
        r102.a();
        return;
    L11:
        return;
    L12:
        return;
    }
}
