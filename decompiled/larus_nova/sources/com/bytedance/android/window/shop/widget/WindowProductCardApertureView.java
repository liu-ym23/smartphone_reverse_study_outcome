package com.bytedance.android.window.shop.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002R$\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowProductCardApertureView;", "Landroid/view/View;", "", "value", "", "setCurrentSpeedExternal", "radius", "setOutlineRadius", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "setCurrentSpeed", "(F)V", "currentSpeed", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getAnimator", "()Landroid/animation/ObjectAnimator;", "animator", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductCardApertureView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f189928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f189929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SweepGradient f189930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f189931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f189932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f189933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f189934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f189935h;

    public static final class a {
    }

    static {
    }

    public WindowProductCardApertureView(Context r100) {
        this(r100, null, 0.0f, 6);
    }

    public WindowProductCardApertureView(Context r100, AttributeSet r101) {
        this(r100, r101, 0.0f, 4);
    }

    private final ObjectAnimator getAnimator() {
        return (ObjectAnimator) this.f189929b.getValue();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAnimator().isStarted() == true) goto L6;
        getAnimator().start();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        getAnimator().cancel();
        super.onDetachedFromWindow();
    }

    private final void setCurrentSpeed(float r100) {
        this.f189928a = r100;
        invalidate();
    }

    private final void setCurrentSpeedExternal(float r100) {
        setCurrentSpeed(r100);
    }

    private final void setOutlineRadius(float r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setColor(com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_transparent));
        r101.setCornerRadius(a(r100 + 1.0f));
        Unit r102 = Unit.INSTANCE;
        setBackground(r101);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
    }

    public final float a(float r100) {
        Resources r101 = getResources();
        return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        r110.save();
        r110.rotate(this.f189928a, getWidth() / 2.0f, getHeight() / 2.0f);
        if (this.f189930c != null) goto L5;
        SweepGradient r100 = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, new int[]{com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_orange), com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_white), com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_pink), com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_red), com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_white), com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_red), com.bytedance.android.ec.window.base.utils.c.c(getContext(), R.color.ec_window_product_card_aperture_orange)}, new float[]{0.0f, 0.17f, 0.19f, 0.58f, 0.6f, 0.84f, 1.0f});
        this.f189930c = r100;
        this.f189931d.setShader(r100);
    L5:
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        r110.drawCircle(r101, r102, (float) Math.sqrt((r101 * r101) + (r102 * r102)), this.f189931d);
        r110.restore();
        this.f189934g.reset();
        Path r103 = this.f189934g;
        RectF r104 = this.f189933f;
        float r105 = this.f189935h;
        r103.addRoundRect(r104, r105, r105, Path.Direction.CW);
        r110.drawPath(this.f189934g, this.f189932e);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(View.resolveSize(getWidth(), r100), View.resolveSize(getHeight(), r101));
    }

    public WindowProductCardApertureView(Context r100, AttributeSet r101, float r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 8.0f;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f189929b = LazyKt.lazy(new WindowProductCardApertureView$animator$2(this));
        this.f189931d = new Paint(1);
        Paint r104 = new Paint(1);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Unit r105 = Unit.INSTANCE;
        this.f189932e = r104;
        this.f189933f = new RectF();
        this.f189934g = new Path();
        this.f189935h = a(r102);
        setLayerType(1, null);
        setOutlineRadius(r102);
        getAnimator().start();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f189930c = null;
        float r104 = a(2.0f);
        this.f189933f.set(r104, r104, r100 - r104, r101 - r104);
    }
}
