package com.bytedance.android.ec.hybrid.xelement.ecomimage.ecgyroscopeimageview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/hybrid/xelement/ecomimage/ecgyroscopeimageview/ECGyroscopeImageView;", "Landroid/widget/ImageView;", "", "getAngleX", "getAngleY", "angleX", "", "setAngleX", "angleY", "setAngleY", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-xelement_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGyroscopeImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f47785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f47786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f47787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f47788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f47789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f47790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f47791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f47792h;

    public ECGyroscopeImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECGyroscopeImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final double getAngleX() {
        return this.f47789e;
    }

    public final double getAngleY() {
        return this.f47790f;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getDrawable() != null) goto L5;
    L9:
        super.onDraw(r100);
        return;
    L5:
        if (isInEditMode() == true) goto L9;
        this.f47791g = (float) (((double) this.f47787c) * this.f47785a);
        this.f47792h = (float) (((double) this.f47788d) * this.f47786b);
        r100.save();
        r100.translate(this.f47791g, this.f47792h);
        super.onDraw(r100);
        r100.restore();
    }

    public final void setAngleX(double r100) {
        this.f47789e = r100;
    }

    public final void setAngleY(double r100) {
        this.f47790f = r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize((r100 - getPaddingLeft()) - getPaddingRight());
        int r103 = View.MeasureSpec.getSize((r101 - getPaddingTop()) - getPaddingBottom());
        if (getDrawable() == null) goto L6;
        int r104 = getDrawable().getIntrinsicWidth();
        int r105 = getDrawable().getIntrinsicHeight();
        this.f47787c = Math.abs((r104 - r102) * 0.5f);
        this.f47788d = Math.abs((r105 - r103) * 0.5f);
        return;
    }

    public final void update(double r100, double r101) {
        this.f47785a = r100;
        this.f47786b = r101;
        invalidate();
    }

    public ECGyroscopeImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setScaleType(ImageView.ScaleType.CENTER);
    }

    public /* synthetic */ ECGyroscopeImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
