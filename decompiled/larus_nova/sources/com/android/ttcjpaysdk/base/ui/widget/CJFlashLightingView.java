package com.android.ttcjpaysdk.base.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J(\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0014J\u0006\u0010%\u001a\u00020\u001bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJFlashLightingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animDuration", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "bitmapShader", "Landroid/graphics/BitmapShader;", "flashPaint", "Landroid/graphics/Paint;", "gradientMatrix", "Landroid/graphics/Matrix;", SVGRenderEngine.RECT, "Landroid/graphics/RectF;", "roundedCornerSize", "valueAnimator", "Landroid/animation/ValueAnimator;", "init", "", "defStyle", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "startAnim", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJFlashLightingView extends View {
    private float animDuration;
    private Bitmap bitmap;
    private BitmapShader bitmapShader;
    private Paint flashPaint;
    private Matrix gradientMatrix;
    private RectF rect;
    private float roundedCornerSize;
    private ValueAnimator valueAnimator;

    public final void startAnim() {
        ValueAnimator r100 = this.valueAnimator;     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.start();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJFlashLightingView#startAnim", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJFlashLightingView#startAnim", e);
    }

    public CJFlashLightingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.animDuration = 4.0f;
        init(null, 0);
    }

    public static final /* synthetic */ BitmapShader access$getBitmapShader$p(CJFlashLightingView r100) {
        return r100.bitmapShader;
    }

    public static final /* synthetic */ Matrix access$getGradientMatrix$p(CJFlashLightingView r100) {
        return r100.gradientMatrix;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = this.rect;     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        Paint r102 = this.flashPaint;     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        float r103 = this.roundedCornerSize;     // Catch: Exception -> L9
        r100.drawRoundRect(r101, r103, r103, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJFlashLightingView#onDraw", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJFlashLightingView#onDraw", e);
    }

    public CJFlashLightingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.animDuration = 4.0f;
        init(r101, 0);
    }

    private final void init(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.cjpay_animationDuration, R.attr.cjpay_roundedCornerRadius}, r101, 0);
        this.roundedCornerSize = r102.getDimension(1, this.roundedCornerSize);
        this.animDuration = r102.getFloat(0, this.animDuration);
        r102.recycle();
        this.flashPaint = new Paint(1);
        this.gradientMatrix = new Matrix();
        this.rect = new RectF();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.valueAnimator = r103;
        if (r103 == null) goto L10;
        r103.setRepeatCount(0);
        float r104 = this.animDuration;
        if (r104 <= 0.0f) goto L7;
        long r105 = (long) (r104 * 1000);
    L8:
        r103.setDuration(r105);
        r103.addUpdateListener(new CJFlashLightingView$init$1$1(this));
        return;
    L7:
        r105 = 4000;
        goto L8
    }

    public CJFlashLightingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.animDuration = 4.0f;
        init(r101, r102);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Context r104 = getContext();     // Catch: Exception -> L9
        if (r104 == null) goto L6;
        Resources r105 = r104.getResources();     // Catch: Exception -> L9
    L7:
        this.bitmap = BitmapFactory.decodeResource(r105, R.drawable.cj_pay_flick_icon);     // Catch: Exception -> L9
    L11:
        Bitmap r106 = this.bitmap;
        if (r106 == null) goto L29;
        Shader.TileMode r107 = Shader.TileMode.CLAMP;
        BitmapShader r108 = new BitmapShader(r106, r107, r107);
        this.bitmapShader = r108;
        Paint r109 = this.flashPaint;
        if (r109 == null) goto L17;
        r109.setShader(r108);
    L17:
        Paint r110 = this.flashPaint;
        if (r110 == null) goto L21;
        r110.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
    L21:
        RectF r111 = this.rect;
        if (r111 == null) goto L24;
        r111.set(0.0f, 0.0f, r100, r101);
    L24:
        if (r100 <= 0) goto L30;
        post(new CJFlashLightingView$onSizeChanged$1$1(this));
        return;
    L30:
        return;
    L29:
        return;
    L6:
        r105 = null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJFlashLightingView#onSizeChanged", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJFlashLightingView#onSizeChanged", e);
        goto L11
    }
}
