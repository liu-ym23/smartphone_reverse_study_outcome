package com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u000b\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/carouseview/CarouselView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/carouseview/CarouselView$c;", "listener", "", "setCarouseViewListener", "", "height", "setViewHeight", "Landroid/os/Handler;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getCountDownHandler", "()Landroid/os/Handler;", "countDownHandler", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "h", "getValueAnimator", "()Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarouselView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f151872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f151873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f151874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f151875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f151876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f151877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f151878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f151879h;

    public static final class a {
    }

    public interface b {
        Long getRollingInterval();
    }

    public interface c {
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CarouselView f151880a;

        public d(CarouselView r100) {
            this.f151880a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CarouselView r100 = this.f151880a;     // Catch: Throwable -> L6
            if (r100.f151873b == false) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public CarouselView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CarouselView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Handler getCountDownHandler() {
        return (Handler) this.f151872a.getValue();
    }

    private final ValueAnimator getValueAnimator() {
        return (ValueAnimator) this.f151879h.getValue();
    }

    public void setCarouseViewListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void b() {
        b r100 = this.f151877f;
        if (r100 == null) goto L7;
        Long r101 = r100.getRollingInterval();
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L9:
        if (r102 < 0) goto L11;
        getCountDownHandler().postDelayed(this.f151874c, r102);
        return;
    L11:
        c();
        return;
    L7:
        r102 = this.f151875d;
        goto L9
    }

    public final void c() {
        if (this.f151873b == true) goto L5;
        return;
    L5:
        this.f151873b = false;
        getCountDownHandler().removeCallbacks(this.f151874c);
    }

    public final void a() {
        getValueAnimator().start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        getValueAnimator().cancel();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        c();
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public void setViewHeight(float r100) {
        this.f151876e = r100;
    }

    public CarouselView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f151872a = LazyKt.lazy(CarouselView$countDownHandler$2.INSTANCE);
        this.f151874c = new d(this);
        this.f151875d = 1;
        this.f151876e = UtilityKotlinExtentionsKt.c(12);
        this.f151878g = true;
        this.f151879h = LazyKt.lazy(new CarouselView$valueAnimator$2(this));
    }

    public /* synthetic */ CarouselView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
