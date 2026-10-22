package com.bytedance.android.ui.base.widget.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R$\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011¨\u0006*"}, d2 = {"Lcom/bytedance/android/ui/base/widget/round/RoundFrameLayoutLite;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "value", "", "leftBottomRadius", "getLeftBottomRadius", "()F", "setLeftBottomRadius", "(F)V", "leftTopRadius", "getLeftTopRadius", "setLeftTopRadius", "radius", "", "rectF", "Landroid/graphics/RectF;", "rightBottomRadius", "getRightBottomRadius", "setRightBottomRadius", "rightTopRadius", "getRightTopRadius", "setRightTopRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", "setBackgroundColor", "color", "setBackgroundResource", "resid", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoundFrameLayoutLite extends FrameLayout {
    private final Path clipPath;
    private float leftBottomRadius;
    private float leftTopRadius;
    private final float[] radius;
    private final RectF rectF;
    private float rightBottomRadius;
    private float rightTopRadius;

    public RoundFrameLayoutLite(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public RoundFrameLayoutLite(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public final float getLeftBottomRadius() {
        return this.leftBottomRadius;
    }

    public final float getLeftTopRadius() {
        return this.leftTopRadius;
    }

    public final float getRightBottomRadius() {
        return this.rightBottomRadius;
    }

    public final float getRightTopRadius() {
        return this.rightTopRadius;
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.clipPath.reset();
        this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        float[] r101 = this.radius;
        float r102 = this.leftTopRadius;
        r101[0] = r102;
        r101[1] = r102;
        float r103 = this.rightTopRadius;
        r101[2] = r103;
        r101[3] = r103;
        float r104 = this.leftBottomRadius;
        r101[4] = r104;
        r101[5] = r104;
        float r105 = this.rightBottomRadius;
        r101[6] = r105;
        r101[7] = r105;
        this.clipPath.addRoundRect(this.rectF, r101, Path.Direction.CW);
        r100.clipPath(this.clipPath);
        super.draw(r100);
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        super.setBackground(r100);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        super.setBackgroundResource(r100);
    }

    public final void setLeftBottomRadius(float r100) {
        this.leftBottomRadius = r100;
        invalidate();
    }

    public final void setLeftTopRadius(float r100) {
        this.leftTopRadius = r100;
        invalidate();
    }

    public final void setRightBottomRadius(float r100) {
        this.rightBottomRadius = r100;
        invalidate();
    }

    public final void setRightTopRadius(float r100) {
        this.rightTopRadius = r100;
        invalidate();
    }

    public RoundFrameLayoutLite(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.clipPath = new Path();
        this.rectF = new RectF();
        this.radius = new float[8];
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.left_bottom_radius, R.attr.left_top_radius, R.attr.right_bottom_radius, R.attr.right_top_radius});
        setLeftTopRadius(r103.getDimension(1, 0.0f));
        setRightTopRadius(r103.getDimension(3, 0.0f));
        setLeftBottomRadius(r103.getDimension(0, 0.0f));
        setRightBottomRadius(r103.getDimension(2, 0.0f));
        r103.recycle();
    L5:
        setWillNotDraw(false);
    }

    public /* synthetic */ RoundFrameLayoutLite(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
