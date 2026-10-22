package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/widget/VerticalDashLineView;", "Landroid/view/View;", "", "bgColor", "", "setDashLineColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerticalDashLineView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f46055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f46056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f46057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f46058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f46059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DashPathEffect f46060f;

    public VerticalDashLineView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VerticalDashLineView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f46055a.setColor(this.f46057c);
        this.f46055a.setStrokeWidth(this.f46058d);
        this.f46055a.setPathEffect(this.f46060f);
        float r101 = getWidth() / 2;
        this.f46056b.reset();
        this.f46056b.moveTo(r101, getHeight() + this.f46059e);
        this.f46056b.lineTo(r101, 0.0f);
        r100.drawPath(this.f46056b, this.f46055a);
    }

    public final void setDashLineColor(int r100) {
        this.f46057c = r100;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    public VerticalDashLineView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        this.f46055a = r103;
        this.f46056b = new Path();
        this.f46057c = (int) 4294847573L;
        this.f46058d = 1.0f;
        r103.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ VerticalDashLineView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(float r100, float r101, float r102, float r103) {
        this.f46058d = r100;
        this.f46059e = r103;
        if (r101 != 0.0f) goto L5;
    L8:
        this.f46060f = null;
    L9:
        getLayoutParams().width = (int) ((getPaddingLeft() + getPaddingRight()) + r100);
        requestLayout();
        return;
    L5:
        if (r102 == 0.0f) goto L8;
        this.f46060f = new DashPathEffect(new float[]{r101, r102}, 0.0f);
        goto L9
    }
}
