package com.bytedance.android.livesdk.antiaddiction.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/antiaddiction/view/VideoPinchViewContainer;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getRadius", "()F", "setRadius", "(F)V", "radius", "Landroid/view/View$OnTouchListener;", "d", "Landroid/view/View$OnTouchListener;", "getPinchListener", "()Landroid/view/View$OnTouchListener;", "setPinchListener", "(Landroid/view/View$OnTouchListener;)V", "pinchListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPinchViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f103696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f103697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f103698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnTouchListener f103699d;

    public VideoPinchViewContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoPinchViewContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View.OnTouchListener getPinchListener() {
        return this.f103699d;
    }

    public final float getRadius() {
        return this.f103696a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        View.OnTouchListener r101 = this.f103699d;
        if (r101 == null) goto L6;
        r101.onTouch(this, r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f103696a <= 0.0f) goto L5;
        r100.clipPath(this.f103697b);
    L5:
        super.onDraw(r100);
    }

    public final void setPinchListener(View.OnTouchListener r100) {
        this.f103699d = r100;
    }

    public final void setRadius(float r100) {
        this.f103696a = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f103696a <= 0.0f) goto L6;
        this.f103697b.reset();
        this.f103698c.top = getPaddingTop();
        this.f103698c.left = getPaddingLeft();
        this.f103698c.right = getMeasuredWidth() - getPaddingRight();
        this.f103698c.bottom = getMeasuredHeight() - getPaddingBottom();
        Path r102 = this.f103697b;
        RectF r103 = this.f103698c;
        float r104 = this.f103696a;
        r102.addRoundRect(r103, r104, r104, Path.Direction.CW);
        return;
    }

    public VideoPinchViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f103697b = new Path();
        this.f103698c = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ VideoPinchViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
