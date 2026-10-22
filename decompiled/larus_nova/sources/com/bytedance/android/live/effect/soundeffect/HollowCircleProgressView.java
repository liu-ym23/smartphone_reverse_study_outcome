package com.bytedance.android.live.effect.soundeffect;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/HollowCircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "maxProgress", "setMaxProgress", "color", "setBgCircleColor", "", "width", "setCircleWidth", "angle", "setStartAngle", "c", "I", "getWidth$liveeffect_saasRelease", "()I", "setWidth$liveeffect_saasRelease", "(I)V", "d", "getHeight$liveeffect_saasRelease", "setHeight$liveeffect_saasRelease", "height", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HollowCircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f68080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f68081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f68086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f68087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f68088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f68089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f68090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f68091l;

    public final int getHeight$liveeffect_saasRelease() {
        return this.f68083d;
    }

    public final int getWidth$liveeffect_saasRelease() {
        return this.f68082c;
    }

    public HollowCircleProgressView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = r110.saveLayer(0.0f, 0.0f, this.f68082c, this.f68083d, null);
        float r101 = this.f68088i;
        Paint r102 = this.f68080a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r110.drawCircle(r101, r101, r101, r102);
        float r103 = this.f68089j;
        if (r103 <= 0) goto L8;
        RectF r104 = this.f68091l;
        float r105 = this.f68082c / 2;
        float r106 = r105 + r103;
        r104.set(r105 - r103, (this.f68083d / 2) - r103, r106, r106);
    L9:
        RectF r107 = this.f68091l;
        float r108 = this.f68087h - 90;
        float r109 = ((this.f68085f * 1.0f) / this.f68086g) * 360;
        Paint r111 = this.f68081b;
        if (r111 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L12:
        r110.drawArc(r107, r108, r109, false, r111);
        r110.restoreToCount(r100);
        return;
    L8:
        RectF r112 = this.f68091l;
        float r113 = this.f68088i;
        r112.set(r113, r113, this.f68082c - r113, this.f68083d - r113);
        goto L9
    }

    public final void setBgCircleColor(int r100) {
        Paint r101 = this.f68080a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r101.setColor(r100);
    }

    public final void setCircleWidth(float r100) {
        Paint r101 = this.f68081b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r101.setStrokeWidth(r100);
    }

    public final void setHeight$liveeffect_saasRelease(int r100) {
        this.f68083d = r100;
    }

    public final void setMaxProgress(int r100) {
        this.f68086g = r100;
    }

    public final void setProgress(int r100) {
        this.f68085f = r100;
        invalidate();
    }

    public final void setStartAngle(int r100) {
        this.f68087h = r100;
    }

    public final void setWidth$liveeffect_saasRelease(int r100) {
        this.f68082c = r100;
    }

    public HollowCircleProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f68086g = 100;
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_effect_background_color, R.attr.ttlive_effect_loading_circle_radius, R.attr.ttlive_effect_loading_circle_width, R.attr.ttlive_effect_loading_max_progress, R.attr.ttlive_effect_loading_progress});
        this.f68089j = r102.getDimension(1, -1.0f);
        this.f68090k = r102.getDimension(2, -1.0f);
        this.f68084e = r102.getColor(0, 0);
        this.f68085f = r102.getInteger(4, 0);
        this.f68086g = r102.getInteger(3, 100);
        r102.recycle();
    L5:
        Paint r103 = new Paint();
        this.f68080a = r103;
        r103.setColor(this.f68084e);
        Paint r104 = this.f68080a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L8:
        r104.setAntiAlias(true);
        Paint r105 = this.f68080a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L11:
        r105.setStyle(Paint.Style.FILL);
        Paint r106 = new Paint();
        this.f68081b = r106;
        r106.setColor(-16777216);
        Paint r107 = this.f68081b;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L14:
        r107.setStyle(Paint.Style.STROKE);
        Paint r108 = this.f68081b;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L17:
        r108.setStrokeWidth(this.f68090k);
        Paint r109 = this.f68081b;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L20:
        r109.setStrokeCap(Paint.Cap.ROUND);
        Paint r110 = this.f68081b;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L23:
        r110.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f68091l = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f68082c = View.MeasureSpec.getSize(r100);
        this.f68083d = View.MeasureSpec.getSize(r101);
        float r102 = this.f68082c / 2.0f;
        this.f68088i = r102;
        if (this.f68089j != (-1.0f)) goto L6;
        this.f68089j = (3 * r102) / 7;
    L6:
        if (this.f68090k != (-1.0f)) goto L9;
        float r103 = (r102 * 2) / 7;
        this.f68090k = r103;
        setCircleWidth(r103);
        return;
    }
}
