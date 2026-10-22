package com.bytedance.android.shopping.deepfeed.slice.view.scrolling;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/scrolling/SlcScrollingView;", "Landroid/view/ViewGroup;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/scrolling/SlcScrollingView$b;", "listener", "", "setOnScrollAnimationEndListener", "", "speed", "setScrollingSpeed", "", "duration", "setWaitDuration", "delay", "setStartDelay", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcScrollingView extends ViewGroup {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f173629g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f173630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f173631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f173632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f173633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f173634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f173635f;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcScrollingView f173636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f173637b;

        public c(SlcScrollingView r100, int r101) {
            this.f173636a = r100;
            this.f173637b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            View r101 = this.f173636a.getChildAt(0);
            if (r101 != null) goto L5;
        L16:
            this.f173636a.c();
            return;
        L5:
            if (r101.getMeasuredWidth() != this.f173637b) goto L16;
            if ((!Intrinsics.areEqual(r100, this.f173636a.f173631b)) == false) goto L10;
            return;
        L10:
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L15;
            this.f173636a.b(((Float) r102).floatValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcScrollingView f173638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f173639b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f173640a;

            public a(d r100) {
                this.f173640a = r100;
            }

            public final void a() {
                d r100 = this.f173640a;
                SlcScrollingView r101 = r100.f173638a;
                int r102 = r100.f173639b;
                int r103 = SlcScrollingView.f173629g;
                if (r101.getChildCount() != 0) goto L5;
                r101.f173630a = false;
                return;
            L5:
                int r104 = r101.getChildAt(0).getMeasuredWidth();
                if (r101.getWidth() <= 0) goto L8;
                r102 = r101.getWidth();
            L8:
                int r105 = r104 - r102;
                if (r105 > 0) goto L13;
                r101.f173630a = false;
                r101.b(0.0f);
                b r106 = r101.f173632c;
                if (r106 == null) goto L16;
                r106.a();
                return;
            L16:
                return;
            L13:
                float r107 = r105;
                ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{r107, 0.0f});
                r108.setDuration(Math.max(0, (long) ((r107 / r101.f173633d) * 1000)));
                r108.addUpdateListener(new cd3.c(r101, r104));
                r108.addListener(new cd3.d(r101));
                r108.start();
                Unit r109 = Unit.INSTANCE;
                r101.f173631b = r108;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            SlcScrollingView r101 = this.f173638a;
            if (r101.f173630a == true) goto L5;
            return;
        L5:
            r101.postDelayed(new a(this), r101.f173634e);
        }

        public d(SlcScrollingView r100, int r101) {
            this.f173638a = r100;
            this.f173639b = r101;
        }
    }

    static {
    }

    public SlcScrollingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcScrollingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void c() {
        ValueAnimator r100 = this.f173631b;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f173631b = null;
        this.f173630a = false;
        b(0.0f);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public final void b(float r100) {
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getChildAt(r102).setTranslationX(-r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r100);
    L6:
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public final void setOnScrollAnimationEndListener(b r100) {
        this.f173632c = r100;
    }

    public final void setScrollingSpeed(float r100) {
        if (r100 <= 0) goto L6;
        this.f173633d = r100;
        return;
    }

    public final void setStartDelay(long r100) {
        this.f173635f = r100;
    }

    public final void setWaitDuration(long r100) {
        this.f173634e = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public final void a(int r100, int r101) {
        float r102 = r100 - r101;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, r102});
        r103.setDuration(Math.max(0, (long) ((r102 / this.f173633d) * 1000)));
        r103.addUpdateListener(new c(this, r100));
        r103.addListener(new d(this, r101));
        r103.start();
        Unit r104 = Unit.INSTANCE;
        this.f173631b = r103;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        View r105 = getChildAt(r103);
        r105.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r104 = Math.max(r104, r105.getMeasuredHeight());
        r103 = r103 + 1;
        goto L3
    L5:
        int r106 = View.MeasureSpec.getSize(r100);
        int r107 = View.MeasureSpec.getMode(r101);
        if (r107 != Integer.MIN_VALUE) goto L8;
        int r108 = Math.min((r104 + getPaddingTop()) + getPaddingBottom(), View.MeasureSpec.getSize(r101));
    L12:
        setMeasuredDimension(r106, r108);
        return;
    L8:
        if (r107 == 1073741824) goto L10;
        r108 = (r104 + getPaddingTop()) + getPaddingBottom();
        goto L12
    L10:
        r108 = View.MeasureSpec.getSize(r101);
        goto L12
    }

    public SlcScrollingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f173633d = 100.0f;
        this.f173634e = 1000;
        this.f173635f = 1000;
    }

    public /* synthetic */ SlcScrollingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop();
        int r107 = getChildCount();
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L8;
        View r109 = getChildAt(r108);
        if (r109.getVisibility() == 8) goto L7;
        r109.layout(r105, r106, r109.getMeasuredWidth() + r105, r109.getMeasuredHeight() + r106);
    L7:
        r108 = r108 + 1;
        goto L3
    }
}
