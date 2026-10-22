package com.bytedance.android.annie.api.view;

import a7.b;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/annie/api/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "La7/b;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public class RadiusLayout extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f38413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f38414b;

    public RadiusLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f38414b = new Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float[] r101 = this.f38413a;
        if (r101 == null) goto L5;
        RectF r102 = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f38414b.reset();
        this.f38414b.addRoundRect(r102, r101, Path.Direction.CW);
        r100.clipPath(this.f38414b);
    L5:
        super.dispatchDraw(r100);
    }

    public void setRadius(float r100) {
        this.f38413a = new float[]{r100, r100, r100, r100, r100, r100, r100, r100};
        invalidate();
    }

    public RadiusLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f38414b = new Path();
    }

    public RadiusLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f38414b = new Path();
    }

    public void setRadius(float r100, float r101, float r102, float r103) {
        float r104 = 0;
        if (r100 <= r104) goto L5;
    L10:
        this.f38413a = new float[]{r100, r100, r101, r101, r102, r102, r103, r103};
        invalidate();
        return;
    L5:
        if (r101 > r104) goto L10;
        if (r103 > r104) goto L10;
        if (r102 > r104) goto L10;
    }
}
