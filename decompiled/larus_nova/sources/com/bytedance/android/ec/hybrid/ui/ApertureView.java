package com.bytedance.android.ec.hybrid.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B\u001b\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003R$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR#\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/ApertureView;", "Landroid/view/View;", "", "value", "", "setCurrentSpeedExternal", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "setCurrentSpeed", "(F)V", "currentSpeed", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getAnimator", "()Landroid/animation/ObjectAnimator;", "animator", "Landroid/graphics/RectF;", "f", "getRectF", "()Landroid/graphics/RectF;", "rectF", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ApertureView extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f47638g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f47639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f47640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SweepGradient f47641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f47642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f47643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f47644f;

    public static final class a {
    }

    private final ObjectAnimator getAnimator() {
        return (ObjectAnimator) this.f47640b.getValue();
    }

    private final RectF getRectF() {
        return (RectF) this.f47644f.getValue();
    }

    static {
        f47638g = UIToolsKt.a(2);
    }

    public final void a() {
        if (this.f47641c != null) goto L6;
        SweepGradient r100 = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, new int[]{ColorProtector.parseColor("#FFAA00"), ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), ColorProtector.parseColor("#FFB5BB"), ColorProtector.parseColor("#FF3344"), ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), ColorProtector.parseColor("#FF3344"), ColorProtector.parseColor("#FFAA00")}, new float[]{0.0f, 0.17f, 0.19f, 0.58f, 0.6f, 0.84f, 1.0f});
        this.f47641c = r100;
        this.f47642d.setShader(r100);
        return;
    }

    private final void setCurrentSpeed(float r100) {
        this.f47639a = r100;
        invalidate();
    }

    private final void setCurrentSpeedExternal(float r100) {
        setCurrentSpeed(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = r100.save();
        r100.rotate(this.f47639a, r100.getWidth() / 2.0f, r100.getHeight() / 2.0f);     // Catch: Throwable -> L6
        a();     // Catch: Throwable -> L6
        float r102 = r100.getWidth() / 2.0f;     // Catch: Throwable -> L6
        float r103 = r100.getHeight() / 2.0f;     // Catch: Throwable -> L6
        r100.drawCircle(r102, r103, (float) Math.sqrt((r102 * r102) + (r103 * r103)), this.f47642d);     // Catch: Throwable -> L6
        r100.restoreToCount(r101);
        r100.drawRoundRect(getRectF(), UIToolsKt.a(12), UIToolsKt.a(12), this.f47643e);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r101);
        throw th;
    }

    public ApertureView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f47640b = LazyKt.lazy(new ApertureView$animator$2(this));
        setLayerType(1, null);
        Intrinsics.checkNotNullParameter(this, "$this$setRadius");
        setOutlineProvider(new com.bytedance.android.ec.hybrid.tools.h(UIUtils.dip2Px(getContext(), 13.0f)));
        setClipToOutline(true);
        getAnimator().start();
        this.f47642d = new Paint(1);
        Paint r102 = new Paint(1);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Unit r103 = Unit.INSTANCE;
        this.f47643e = r102;
        this.f47644f = LazyKt.lazy(new ApertureView$rectF$2(this));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(View.resolveSize(getWidth(), r100), View.resolveSize(getHeight(), r101));
    }
}
