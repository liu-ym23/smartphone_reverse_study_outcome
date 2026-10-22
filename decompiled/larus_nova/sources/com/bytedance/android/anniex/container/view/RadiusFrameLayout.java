package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/container/view/RadiusFrameLayout;", "Landroid/widget/FrameLayout;", "", "radius", "", "setRadius", "", "radii", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class RadiusFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f40632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f40633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f40634c;

    public RadiusFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f40633b = new Path();
        this.f40634c = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float[] r101 = this.f40632a;
        if (r101 == null) goto L5;
        this.f40634c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f40633b.reset();
        this.f40633b.addRoundRect(this.f40634c, r101, Path.Direction.CW);
        r100.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r100.clipPath(this.f40633b);
    L5:
        super.dispatchDraw(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float[] r101 = this.f40632a;
        if (r101 == null) goto L5;
        this.f40634c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f40633b.reset();
        this.f40633b.addRoundRect(this.f40634c, r101, Path.Direction.CW);
        r100.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r100.clipPath(this.f40633b);
    L5:
        super.draw(r100);
    }

    public final void setRadius(float r100) {
        this.f40632a = new float[]{r100, r100, r100, r100, r100, r100, r100, r100};
        invalidate();
    }

    public final void setRadius(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "radii");
        this.f40632a = r100;
        invalidate();
    }

    public RadiusFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f40633b = new Path();
        this.f40634c = new RectF();
    }

    public RadiusFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f40633b = new Path();
        this.f40634c = new RectF();
    }

    public final void a(float r100, float r101, float r102, float r103) {
        float r104 = 0;
        if (r100 <= r104) goto L5;
    L10:
        this.f40632a = new float[]{r100, r100, r101, r101, r102, r102, r103, r103};
        invalidate();
        return;
    L5:
        if (r101 > r104) goto L10;
        if (r103 > r104) goto L10;
        if (r102 > r104) goto L10;
    }
}
