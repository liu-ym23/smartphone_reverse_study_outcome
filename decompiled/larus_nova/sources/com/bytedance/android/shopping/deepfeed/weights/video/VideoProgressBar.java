package com.bytedance.android.shopping.deepfeed.weights.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.utils.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tc3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoProgressBar;", "Landroid/view/View;", "", "getDragProgress", "getProgressHeight", "()F", "progressHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressBar extends View {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f174262m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f174263n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f174264o = 0.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f174265p = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f174266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f174267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f174268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f174269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f174270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f174271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f174272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f174273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f174274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public fd3.a f174275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f174276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f174277l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProgressBar f174278a;

        public b(VideoProgressBar r100) {
            this.f174278a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            VideoProgressBar r101 = this.f174278a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            float r103 = ((Float) r102).floatValue();
            float r104 = VideoProgressBar.f174262m;
            r101.c(r103);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProgressBar f174279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f174280b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f174280b == true) goto L8;
            fd3.a r101 = this.f174279a.f174275j;
            if (r101 == null) goto L9;
            r101.onDragEnd();
            return;
        L9:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f174280b == false) goto L8;
            fd3.a r101 = this.f174279a.f174275j;
            if (r101 == null) goto L9;
            r101.onDragStart();
            return;
        L9:
            return;
        }

        public c(VideoProgressBar r100, boolean r101) {
            this.f174279a = r100;
            this.f174280b = r101;
        }
    }

    public VideoProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        f174262m = q.a(2);
        f174263n = q.a(12);
        f174264o = q.a(8);
        f174265p = q.a(16);
    }

    private final float getProgressHeight() {
        if (f.f() == false) goto L6;
        return 2.0f;
    L6:
        return f174262m;
    }

    public final float getDragProgress() {
        return this.f174269d;
    }

    public final boolean a(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L6:
        if (r101 != null) goto L9;
    L18:
        if (r101 != null) goto L21;
    L23:
        if (r101 != null) goto L26;
    L32:
        if (r101 != null) goto L35;
    L45:
        return true;
    L35:
        if (r101.intValue() != 2) goto L45;
        if (this.f174274i == false) goto L45;
        if (this.f174273h == true) goto L41;
        this.f174273h = true;
        b(true);
    L41:
        float r102 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.f174269d + ((r100.getX() - this.f174272g) / getWidth()), 1.0f), 0.0f);
        this.f174269d = r102;
        fd3.a r103 = this.f174275j;
        if (r103 == null) goto L44;
        r103.b(r102);
    L44:
        invalidate();
        this.f174272g = r100.getX();
        goto L45
    L26:
        if (r101.intValue() != 3) goto L32;
    L28:
        if (this.f174273h == false) goto L45;
        this.f174273h = false;
        b(false);
        float r104 = this.f174269d;
        this.f174268c = r104;
        fd3.a r105 = this.f174275j;
        if (r105 == null) goto L45;
        r105.a(r104);
        goto L45
    L21:
        if (r101.intValue() != 1) goto L23;
    L9:
        if (r101.intValue() != 0) goto L18;
        if (r100.getY() >= (getBottom() - com.bytedance.android.shopping.extensions.b.a(15))) goto L14;
        this.f174274i = false;
        return false;
    L14:
        this.f174274i = true;
        this.f174272g = r100.getX();
        this.f174273h = false;
        ViewParent r106 = getParent();
        if (r106 == null) goto L17;
        r106.requestDisallowInterceptTouchEvent(true);
    L17:
        this.f174269d = this.f174268c;
        goto L45
    L4:
        r101 = null;
        goto L6
    }

    public final void b(boolean r100) {
        ValueAnimator r101 = this.f174271f;
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        if (r100 == false) goto L8;
        float r102 = 0.0f;
    L9:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r102, 1.0f - r102});
        r103.setDuration(200);
        r103.addUpdateListener(new b(this));
        r103.addListener(new c(this, r100));
        r103.start();
        Unit r104 = Unit.INSTANCE;
        this.f174271f = r103;
        return;
    L8:
        r102 = 1.0f;
        goto L9
    }

    public final void c(float r100) {
        this.f174267b = r100;
        fd3.a r101 = this.f174275j;
        if (r101 == null) goto L5;
        r101.c(r100);
    L5:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = (this.f174267b * (f174263n - getProgressHeight())) + getProgressHeight();
        float r101 = r100 / 2.0f;
        float r102 = getWidth();
        float r103 = 0;
        if (this.f174267b <= r103) goto L5;
        float r104 = this.f174269d;
    L6:
        float r105 = r102 * r104;
        float r106 = 0.0f;
        if (this.f174276k == false) goto L9;
        this.f174270e.set(0.0f, (getHeight() - r100) / 2.0f, getWidth(), (getHeight() + r100) / 2.0f);
    L10:
        this.f174266a.setColor(1476395007);
        r110.drawRoundRect(this.f174270e, r101, r101, this.f174266a);
        this.f174266a.setColor(-1056964609);
        RectF r107 = this.f174270e;
        r107.right = r105;
        r110.drawRoundRect(r107, r101, r101, this.f174266a);
        if (this.f174267b <= r103) goto L22;
        this.f174266a.setColor(-1);
        RectF r108 = this.f174270e;
        float r109 = f174264o;
        float r111 = this.f174267b;
        float r112 = f174265p;
        r108.set(((-r109) / 2.0f) * r111, ((-r112) / 2.0f) * r111, (r109 / 2.0f) * r111, (r112 / 2.0f) * r111);
        float r113 = 2;
        float r114 = r105 - (r101 - (this.f174270e.width() / r113));
        if (r114 < r103) goto L17;
        r106 = r114;
    L17:
        if (this.f174276k == false) goto L19;
        this.f174270e.offset(r106, getHeight() / 2.0f);
    L20:
        float r115 = this.f174270e.width() / r113;
        r110.drawRoundRect(this.f174270e, r115, r115, this.f174266a);
        return;
    L19:
        this.f174270e.offset(r106, getHeight() - r101);
        goto L20
    L22:
        return;
    L9:
        this.f174270e.set(0.0f, getHeight() - r100, getWidth(), getHeight());
        goto L10
    L5:
        r104 = this.f174268c;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        Integer r103 = this.f174277l;
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        setMeasuredDimension(r102, r104);
        return;
    L5:
        r104 = (int) f174263n;
        goto L6
    }

    public VideoProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f174266a = new Paint(1);
        this.f174270e = new RectF();
    }

    public /* synthetic */ VideoProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
