package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.style.SmoothCornerH;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RadiusLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0003J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J0\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0018\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0007H\u0016J\u000e\u00102\u001a\u00020!2\u0006\u00103\u001a\u000204J&\u00102\u001a\u00020!2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u000204J\u0016\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007J&\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010@\u001a\u00020!H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "hasStroke", "", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "measureHeightUnspecified", "getMeasureHeightUnspecified", "()Z", "setMeasureHeightUnspecified", "(Z)V", "outPath", "Landroid/graphics/Path;", "outRectF", "Landroid/graphics/RectF;", "radiusArray", "", "showStroke", "strokePaint", "Landroid/graphics/Paint;", "suppressChildMeasureAndLayout", "clipRound", "", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "draw", "drawStroke", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColor", "color", "setRadius", "r", "", "lt", "rt", "lb", "rb", "setStroke", "strokeColor", "strokeWidth", "strokeDash", "strokeGap", "setSuppressChildMeasureAndLayout", "suppress", "updateBackground", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RadiusLayout extends FrameLayout {
    private int backgroundColor;
    private boolean hasStroke;
    private int maxHeight;
    private boolean measureHeightUnspecified;
    private final Path outPath;
    private final RectF outRectF;
    private float[] radiusArray;
    private boolean showStroke;
    private Paint strokePaint;
    private boolean suppressChildMeasureAndLayout;

    public RadiusLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public RadiusLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ RadiusLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public RadiusLayout(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.showStroke = true;
        this.outRectF = new RectF();
        this.outPath = new Path();
        boolean r2 = false;
        if ((getBackground() instanceof ColorDrawable) == false) goto L9;
        Drawable r1 = getBackground();
        if (r1 == null) goto L8;
        int r3 = ((ColorDrawable) r1).getColor();
    L10:
        this.backgroundColor = r3;
        TypedArray r14 = r11.obtainStyledAttributes(r12, R.styleable.ORadiusLayout, r13, 0);
        Intrinsics.checkNotNullExpressionValue(r14, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r15 = r14.getDimension(R.styleable.ORadiusLayout_oui_cornerRadius, 0.0f);
        float r4 = r14.getDimension(R.styleable.ORadiusLayout_oui_cornerRadiusLeftTop, r15);
        float r5 = r14.getDimension(R.styleable.ORadiusLayout_oui_cornerRadiusRightTop, r15);
        float r6 = r14.getDimension(R.styleable.ORadiusLayout_oui_cornerRadiusLeftBottom, r15);
        float r7 = r14.getDimension(R.styleable.ORadiusLayout_oui_cornerRadiusRightBottom, r15);
        int r8 = r14.getColor(R.styleable.ORadiusLayout_oui_radiusStrokeColor, -16777216);
        int r9 = r14.getDimensionPixelOffset(R.styleable.ORadiusLayout_oui_radiusStrokeWidth, 0);
        int r10 = r14.getDimensionPixelOffset(R.styleable.ORadiusLayout_oui_radiusStrokeDashWidth, 0);
        int r16 = r14.getDimensionPixelOffset(R.styleable.ORadiusLayout_oui_radiusStrokeDashGapWidth, 0);
        if (r15 != 0.0f) goto L13;
        r2 = true;
    L13:
        if (r2 == false) goto L15;
        setRadius(r4, r5, r6, r7);
    L16:
        setStroke(r8, r9, r10, r16);
        r14.recycle();
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
        return;
    L15:
        setRadius(r15);
        goto L16
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L9:
        r3 = 0;
        goto L10
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
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r1 = null;
    L5:
        r0.setCornerRadii(r1);
        r0.setColor(ColorStateList.valueOf(this.backgroundColor));
        setBackground(r0);
    }

    public final void setStroke(int r6, int r7, int r8, int r9) {
        Paint r0 = new Paint();
        boolean r1 = true;
        r0.setAntiAlias(true);
        r0.setColor(r6);
        r0.setStyle(Paint.Style.STROKE);
        if (r8 == 0) goto L6;
        if (r9 == 0) goto L6;
        r0.setPathEffect(new DashPathEffect(new float[]{r8, r9}, 0.0f));
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
    protected void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
        if (this.hasStroke == true) goto L5;
        return;
    L5:
        if (this.showStroke == false) goto L9;
        drawStroke(r2);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.draw(r2);
    }

    @Deprecated(message = "Not used anymore")
    private final void clipRound(Canvas r6) {
        this.outRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        this.outPath.reset();
        SmoothCornerH r0 = SmoothCornerH.INSTANCE;
        Path r1 = this.outPath;
        RectF r2 = this.outRectF;
        float[] r3 = this.radiusArray;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r3 = null;
    L5:
        r0.addRoundRect(r1, r2, r3, Path.Direction.CW);
        r6.clipPath(this.outPath);
    }

    private final void drawStroke(Canvas r7) {
        Paint r0 = this.strokePaint;
        if (r0 != null) goto L5;
        return;
    L5:
        this.outRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        this.outPath.reset();
        SmoothCornerH r1 = SmoothCornerH.INSTANCE;
        Path r2 = this.outPath;
        RectF r3 = this.outRectF;
        float[] r4 = this.radiusArray;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r4 = null;
    L8:
        r1.addRoundRect(r2, r3, r4, Path.Direction.CW);
        r7.drawPath(this.outPath, r0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r5, int r6) {
        if (this.suppressChildMeasureAndLayout == false) goto L14;
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        int r1 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        if (r0 == Integer.MIN_VALUE) goto L8;
        if (r0 == 1073741824) goto L8;
        r7 = RangesKt.coerceAtLeast(getMeasuredWidth(), getSuggestedMinimumWidth());
    L8:
        if (r1 == Integer.MIN_VALUE) goto L11;
        if (r1 == 1073741824) goto L11;
        r8 = RangesKt.coerceAtLeast(getMeasuredHeight(), getSuggestedMinimumHeight());
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
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.suppressChildMeasureAndLayout == false) goto L5;
        return;
    L5:
        super.onLayout(r2, r3, r4, r5, r6);
    }
}
