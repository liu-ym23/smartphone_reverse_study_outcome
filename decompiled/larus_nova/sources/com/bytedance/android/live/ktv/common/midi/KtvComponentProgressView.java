package com.bytedance.android.live.ktv.common.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KtvComponentProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f69752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f69753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SweepGradient f69754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f69755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f69756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f69757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f69758g;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentProgressView f69759a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(KtvComponentProgressView r100) {
            this.f69759a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            KtvComponentProgressView r101 = this.f69759a;
            r101.f69752a = 0.0f;
            r101.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            KtvComponentProgressView r101 = this.f69759a;
            r101.f69752a = 0.0f;
            r101.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100, r101);
            KtvComponentProgressView r102 = this.f69759a;
            r102.f69752a = 0.0f;
            r102.invalidate();
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentProgressView f69760a;

        public c(KtvComponentProgressView r100) {
            this.f69760a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L9;
            float r103 = r102.floatValue();
            KtvComponentProgressView r104 = this.f69760a;
            r104.f69752a = r103;
            r104.invalidate();
            return;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentProgressView f69761a;

        public d(KtvComponentProgressView r100) {
            this.f69761a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "va");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L9;
            float r103 = r102.floatValue();
            KtvComponentProgressView r104 = this.f69761a;
            r104.f69752a = r103;
            r104.invalidate();
            return;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentProgressView f69762a;

        public e(KtvComponentProgressView r100) {
            this.f69762a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            KtvComponentProgressView r101 = this.f69762a;
            r101.f69752a = 100.0f;
            r101.invalidate();
        }
    }

    static {
    }

    public KtvComponentProgressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvComponentProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        ValueAnimator r100 = this.f69758g;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
    L5:
        ValueAnimator r101 = this.f69758g;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
    L8:
        ValueAnimator r102 = this.f69758g;
        if (r102 == null) goto L12;
        r102.cancel();
        return;
    }

    public final void b() {
        ValueAnimator r100 = this.f69758g;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
    L5:
        ValueAnimator r101 = this.f69758g;
        if (r101 == null) goto L9;
        r101.cancel();
    L9:
        if (this.f69752a <= 0) goto L26;
        ValueAnimator r102 = this.f69757f;
        if (r102 == null) goto L13;
        r102.removeAllUpdateListeners();
    L13:
        ValueAnimator r103 = this.f69757f;
        if (r103 == null) goto L16;
        r103.cancel();
    L16:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{this.f69752a, 0.0f}).setDuration(500);
        this.f69757f = r104;
        if (r104 == null) goto L19;
        r104.addListener(new b(this));
    L19:
        ValueAnimator r105 = this.f69757f;
        if (r105 == null) goto L22;
        r105.addUpdateListener(new c(this));
    L22:
        ValueAnimator r106 = this.f69757f;
        if (r106 == null) goto L27;
        r106.start();
        return;
    L27:
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f69757f;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
    L5:
        ValueAnimator r101 = this.f69757f;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        ValueAnimator r102 = this.f69758g;
        if (r102 == null) goto L11;
        r102.removeAllUpdateListeners();
    L11:
        ValueAnimator r103 = this.f69758g;
        if (r103 == null) goto L15;
        r103.cancel();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = (this.f69752a / 100.0f) * 360;
        r100.drawArc(this.f69756e, 270 - r101, r101, false, this.f69755d);
    }

    public final void setProgress(float r100) {
        ValueAnimator r101 = this.f69758g;
        if (r101 == null) goto L5;
        r101.removeAllUpdateListeners();
    L5:
        ValueAnimator r102 = this.f69758g;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        this.f69752a = r100;
        invalidate();
    }

    public final void c(long r100, long r101) {
        float r102 = this.f69752a;
        if (r102 < 100.0f) goto L5;
        return;
    L5:
        if (r102 != 0.0f) goto L9;
        float r103 = (r101 / r100) * 100;
        this.f69752a = r103;
        if (r103 < 100.0f) goto L9;
        return;
    L9:
        ValueAnimator r104 = this.f69758g;
        if (r104 == null) goto L12;
        r104.removeAllUpdateListeners();
    L12:
        ValueAnimator r105 = this.f69758g;
        if (r105 == null) goto L15;
        r105.removeAllListeners();
    L15:
        ValueAnimator r106 = this.f69758g;
        if (r106 == null) goto L18;
        r106.cancel();
    L18:
        long r107 = r100 - r101;
        if (r107 >= 0) goto L21;
        r107 = 0;
    L21:
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{this.f69752a, 100.0f});
        this.f69758g = r108;
        if (r108 == null) goto L24;
        r108.setDuration(r107);
    L24:
        ValueAnimator r109 = this.f69758g;
        if (r109 == null) goto L27;
        r109.addUpdateListener(new d(this));
    L27:
        ValueAnimator r110 = this.f69758g;
        if (r110 == null) goto L30;
        r110.addListener(new e(this));
    L30:
        ValueAnimator r111 = this.f69758g;
        if (r111 == null) goto L35;
        r111.start();
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f69754c != null) goto L6;
        SweepGradient r102 = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, new int[]{ColorProtector.parseColor("#FF72C8"), ColorProtector.parseColor("#63E5FF"), ColorProtector.parseColor("#FF72C8")}, null);
        this.f69754c = r102;
        this.f69755d.setShader(r102);
        RectF r103 = this.f69756e;
        float r104 = 0;
        float r105 = this.f69753b;
        r103.set((r105 / 2.0f) + r104, r104 + (r105 / 2.0f), getMeasuredWidth() - (this.f69753b / 2.0f), getMeasuredHeight() - (this.f69753b / 2));
        return;
    }

    public KtvComponentProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f69752a = 100.0f;
        float r103 = UtilityKotlinExtentionsKt.h(1.5f);
        this.f69753b = r103;
        Paint r104 = new Paint();
        this.f69755d = r104;
        this.f69756e = new RectF();
        r104.setAntiAlias(true);
        r104.setStrokeWidth(r103);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeCap(Paint.Cap.ROUND);
    }

    public /* synthetic */ KtvComponentProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
