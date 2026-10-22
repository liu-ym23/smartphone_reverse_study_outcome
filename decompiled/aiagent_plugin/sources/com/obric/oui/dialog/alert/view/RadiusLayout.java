package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.l;
import com.obric.oui.material.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Objects;

/* JADX INFO: compiled from: RadiusLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class RadiusLayout extends FrameLayout {
    private int backgroundColor;
    private boolean enableMaterial;
    private boolean hasStroke;
    private final float materialEdgeWidth;
    private int maxHeight;
    private boolean measureHeightUnspecified;
    private final Path outPath;
    private final RectF outRectF;
    private float[] radiusArray;
    private boolean showStroke;
    private Paint strokePaint;
    private boolean suppressChildMeasureAndLayout;

    public RadiusLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public RadiusLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ RadiusLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public RadiusLayout(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r16, "context");
        super(r16, r17, r15);
        this.showStroke = true;
        this.outRectF = new RectF();
        this.outPath = new Path();
        this.enableMaterial = k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        this.materialEdgeWidth = 3.0f;
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L5;
        Drawable r2 = getBackground();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        int r1 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r2, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor();
    L6:
        this.backgroundColor = r1;
        TypedArray r18 = r16.obtainStyledAttributes(r17, R.styleable.ORadiusLayout, r15, 0);
        o.c(r18, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r19 = r18.getDimension(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_cornerRadius, "styleable", "ORadiusLayout_oui_cornerRadius"), 0.0f);
        float r4 = r18.getDimension(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_cornerRadiusLeftTop, "styleable", "ORadiusLayout_oui_cornerRadiusLeftTop"), r19);
        float r5 = r18.getDimension(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_cornerRadiusRightTop, "styleable", "ORadiusLayout_oui_cornerRadiusRightTop"), r19);
        float r6 = r18.getDimension(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_cornerRadiusLeftBottom, "styleable", "ORadiusLayout_oui_cornerRadiusLeftBottom"), r19);
        float r7 = r18.getDimension(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_cornerRadiusRightBottom, "styleable", "ORadiusLayout_oui_cornerRadiusRightBottom"), r19);
        int r8 = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_radiusStrokeColor, "styleable", "ORadiusLayout_oui_radiusStrokeColor"), -16777216);
        int r9 = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_radiusStrokeWidth, "styleable", "ORadiusLayout_oui_radiusStrokeWidth"), 0);
        int r10 = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_radiusStrokeDashWidth, "styleable", "ORadiusLayout_oui_radiusStrokeDashWidth"), 0);
        int r110 = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ORadiusLayout_oui_radiusStrokeDashGapWidth, "styleable", "ORadiusLayout_oui_radiusStrokeDashGapWidth"), 0);
        if (r19 != 0.0f) goto L9;
        r3 = true;
    L9:
        if (r3 == false) goto L11;
        setRadius(r4, r5, r6, r7);
    L12:
        setStroke(r8, r9, r10, r110);
        r18.recycle();
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
        return;
    L11:
        setRadius(r19);
        goto L12
    L5:
        r1 = 0;
        goto L6
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final void setMaxHeight(int r1) {
        this.maxHeight = r1;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.measureHeightUnspecified;
    }

    public final void setMeasureHeightUnspecified(boolean r1) {
        this.measureHeightUnspecified = r1;
    }

    public final void setSuppressChildMeasureAndLayout(boolean r2) {
        if (this.suppressChildMeasureAndLayout != r2) goto L5;
        return;
    L5:
        this.suppressChildMeasureAndLayout = r2;
        if (r2 == true) goto L9;
        requestLayout();
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        super.setBackgroundColor(r1);
        this.backgroundColor = r1;
        updateBackground();
    }

    public final void setRadius(float r1) {
        setRadius(r1, r1, r1, r1);
    }

    public final void setRadius(float r3, float r4, float r5, float r6) {
        this.radiusArray = new float[]{r3, r3, r4, r4, r6, r6, r5, r5};
        updateBackground();
        invalidate();
    }

    private final void updateBackground() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        float[] r1 = this.radiusArray;
        if (r1 != null) goto L5;
        o.c("radiusArray");
        r1 = null;
    L5:
        r0.setCornerRadii(r1);
        r0.setColor(ColorStateList.valueOf(this.backgroundColor));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin"));
    }

    public final void setStroke(int r6, int r7, int r8, int r9) {
        Paint r0 = new Paint();
        boolean r1 = true;
        r0.setAntiAlias(true);
        r0.setColor(r6);
        r0.setStyle(Paint.Style.STROKE);
        if (r8 == 0) goto L6;
        if (r9 == 0) goto L6;
        r0.setPathEffect((PathEffect) ZeusTransformUtils.preCheckCast(new DashPathEffect(new float[]{r8, r9}, 0.0f), PathEffect.class, "com.obric.aiagent.plugin"));
    L6:
        r0.setStrokeWidth(r7);
        this.strokePaint = r0;
        if ((r6 & (-16777216)) == 0) goto L10;
        if (r7 == 0) goto L10;
    L11:
        this.hasStroke = r1;
        invalidate();
        return;
    L10:
        r1 = false;
        goto L11
    }

    public final void setStroke(int r4, int r5) {
        Paint r0 = new Paint();
        boolean r1 = true;
        r0.setAntiAlias(true);
        r0.setColor(r4);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeWidth(r5);
        this.strokePaint = r0;
        if ((r4 & (-16777216)) == 0) goto L6;
        if (r5 == 0) goto L6;
    L7:
        this.hasStroke = r1;
        invalidate();
        return;
    L6:
        r1 = false;
        goto L7
    }

    public final void showStroke(boolean r1) {
        this.showStroke = r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r2) {
        o.e(r2, "canvas");
        if (this.enableMaterial == false) goto L5;
        clipRound(r2);
    L5:
        super.dispatchDraw(r2);
        if (this.hasStroke == true) goto L8;
        return;
    L8:
        if (this.showStroke == false) goto L12;
        drawStroke(r2);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        o.e(r2, "canvas");
        super.draw(r2);
    }

    private final void clipRound(Canvas r5) {
        this.outRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        this.outRectF.inset(0.0f, this.materialEdgeWidth);
        this.outPath.reset();
        Path r1 = this.outPath;
        RectF r2 = this.outRectF;
        float[] r3 = this.radiusArray;
        if (r3 != null) goto L10;
        o.c("radiusArray");
        r3 = null;
    L10:
        r1.addRoundRect(r2, r3, Path.Direction.CW);
        r5.clipPath(this.outPath);
        return;
    L11:
        r5.clipRect(this.outRectF);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void drawStroke(Canvas r7) {
        Paint r0 = this.strokePaint;
        if (r0 != null) goto L5;
        return;
    L5:
        this.outRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        this.outPath.reset();
        l r2 = l.f34562a;
        Path r3 = this.outPath;
        RectF r4 = this.outRectF;
        float[] r5 = this.radiusArray;
        if (r5 != null) goto L13;
        o.c("radiusArray");
        r5 = null;
    L13:
        r2.a(r3, r4, r5, Path.Direction.CW);
        r7.drawPath(this.outPath, r0);
        return;
    L14:
        r7.drawRect(this.outRectF, r0);
        return;
    L8:
        r1 = false;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        if (this.suppressChildMeasureAndLayout == false) goto L14;
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        int r1 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        if (r0 == Integer.MIN_VALUE) goto L8;
        if (r0 == 1073741824) goto L8;
        r7 = n.c(getMeasuredWidth(), getSuggestedMinimumWidth());
    L8:
        if (r1 == Integer.MIN_VALUE) goto L11;
        if (r1 == 1073741824) goto L11;
        r8 = n.c(getMeasuredHeight(), getSuggestedMinimumHeight());
    L11:
        setMeasuredDimension(r7, r8);
        return;
    L14:
        if (this.measureHeightUnspecified == false) goto L21;
        boolean r9 = false;
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r10 = getMeasuredHeight();
        int r2 = this.maxHeight;
        if (1 > r2) goto L19;
        if (r2 >= r10) goto L19;
        r9 = true;
    L19:
        if (r9 == false) goto L23;
        setMeasuredDimension(getMeasuredWidth(), this.maxHeight);
        return;
    L23:
        return;
    L21:
        super.onMeasure(r5, r6);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.suppressChildMeasureAndLayout == false) goto L5;
        return;
    L5:
        super.onLayout(r2, r3, r4, r5, r6);
    }
}
