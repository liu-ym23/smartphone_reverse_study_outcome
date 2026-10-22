package com.bytedance.ai.view.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018J&\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ai/view/popup/RadiusLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "showStroke", "", "strokePaint", "Landroid/graphics/Paint;", "hasStroke", "radiusArray", "", "outRectF", "Landroid/graphics/RectF;", "outPath", "Landroid/graphics/Path;", "setRadius", "", "r", "", "setRadiusNew", "radius", "lt", "rt", "lb", "rb", "setStroke", "strokeColor", "strokeWidth", "strokeDash", "strokeGap", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "clipRound", "drawStroke", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f37816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f37817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f37818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f37819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f37820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f37821f;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f37822a;

        public a(float r100) {
            this.f37822a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r101 != null) goto L6;
            return;
        L6:
            int r102 = r100.getWidth();
            int r103 = r100.getHeight();
            float r104 = this.f37822a;
            r101.setRoundRect(0, 0, r102, r103 + ((int) r104), r104);
        }
    }

    public RadiusLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RadiusLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f37818c == true) goto L5;
        return;
    L5:
        if (this.f37816a == false) goto L15;
        Paint r101 = this.f37817b;
        if (r101 == null) goto L16;
        this.f37820e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f37821f.reset();
        Path r102 = this.f37821f;
        RectF r103 = this.f37820e;
        float[] r104 = this.f37819d;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r104 = null;
    L12:
        r102.addRoundRect(r103, r104, Path.Direction.CW);
        r100.drawPath(this.f37821f, r101);
        return;
    L16:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
    }

    public final void setRadius(float r100) {
        this.f37819d = new float[]{r100, r100, r100, r100, r100, r100, r100, r100};
        invalidate();
    }

    public final void setRadiusNew(float r100) {
        setClipToOutline(true);
        setOutlineProvider(new a(r100));
        invalidate();
    }

    public RadiusLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f37816a = true;
        this.f37820e = new RectF();
        this.f37821f = new Path();
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setColor(0);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(0);
        this.f37817b = r103;
        this.f37818c = false;
        invalidate();
    }

    public /* synthetic */ RadiusLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
