package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import com.alibaba.gaiax.render.view.basic.boxshadow.GXBlurMaskBitmapShadowDrawable;
import com.alibaba.gaiax.render.view.basic.boxshadow.GXBlurMaskShadowDrawable;
import com.alibaba.gaiax.render.view.basic.boxshadow.GXShadowDrawable;
import com.alibaba.gaiax.template.GXBoxShadow;
import com.alibaba.gaiax.template.GXRoundedCorner;
import com.alibaba.gaiax.template.GXSize;
import com.alibaba.gaiax.template.GXStyle;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\nJ\u0006\u0010-\u001a\u00020\nJ\u001a\u0010.\u001a\u00020 2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010/\u001a\u00020\u0017J(\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\b\u00105\u001a\u00020 H\u0002J\u000e\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\nJ(\u00106\u001a\u00020 2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nH\u0007J\u000e\u0010<\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010=\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010?\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010@\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010A\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010B\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010DJ<\u0010E\u001a\u00020 *\u00020\u00102\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXShadowLayout;", "Landroid/widget/AbsoluteLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomLeftBoxRadius", "", "bottomRightBoxRadius", "boxRadius", "clipPaint", "Landroid/graphics/Paint;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "shadowBlur", "shadowColor", "shadowDrawable", "Lcom/alibaba/gaiax/render/view/basic/boxshadow/GXShadowDrawable;", "shadowHorizontalOffset", "shadowInset", "", "shadowPath", "shadowPathOffsetX", "shadowPathOffsetY", "shadowSpread", "shadowVerticalOffset", "topLeftBoxRadius", "topRightBoxRadius", "clipRadius", "", "canvas", "Landroid/graphics/Canvas;", "draw", "drawShadow", "getBottomLeftRadius", "getBottomRightRadius", "getRadius", "getShadowColor", "getShadowHorizontalOffset", "getShadowSpread", "getShadowVerticalOffset", "getTopLeftRadius", "getTopRightRadius", "init", "isShadowInset", "onSizeChanged", "w", "h", "oldw", "oldh", "resetShadowOffset", "setBoxRadius", "radius", "topLeft", "topRight", "bottomLeft", "bottomRight", "setShadowBlur", "setShadowColor", "setShadowInset", "setShadowSpread", "setShadowXOffset", "setShadowYOffset", "setStyle", "style", "Lcom/alibaba/gaiax/template/GXStyle;", "addRoundRect2", "tL", "tR", "bL", "bR", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXShadowLayout extends AbsoluteLayout {
    private float bottomLeftBoxRadius;
    private float bottomRightBoxRadius;
    private float boxRadius;
    private final Paint clipPaint;
    private final Path clipPath;
    private float shadowBlur;
    private int shadowColor;
    private final GXShadowDrawable shadowDrawable;
    private float shadowHorizontalOffset;
    private boolean shadowInset;
    private final Path shadowPath;
    private float shadowPathOffsetX;
    private float shadowPathOffsetY;
    private float shadowSpread;
    private float shadowVerticalOffset;
    private float topLeftBoxRadius;
    private float topRightBoxRadius;

    public GXShadowLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public GXShadowLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void resetShadowOffset() {
        this.shadowPath.offset(-this.shadowPathOffsetX, -this.shadowPathOffsetY);
        float r100 = this.shadowSpread;
        float r101 = (-r100) + this.shadowHorizontalOffset;
        this.shadowPathOffsetX = r101;
        float r102 = (-r100) + this.shadowVerticalOffset;
        this.shadowPathOffsetY = r102;
        this.shadowPath.offset(r101, r102);
        this.shadowDrawable.invalidateCache();
    }

    public final float getBottomLeftRadius() {
        return this.bottomLeftBoxRadius;
    }

    public final float getBottomRightRadius() {
        return this.bottomRightBoxRadius;
    }

    public final float getRadius() {
        return this.boxRadius;
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final float getShadowHorizontalOffset() {
        return this.shadowHorizontalOffset;
    }

    public final float getShadowSpread() {
        return this.shadowSpread;
    }

    public final float getShadowVerticalOffset() {
        return this.shadowVerticalOffset;
    }

    public final float getTopLeftRadius() {
        return this.topLeftBoxRadius;
    }

    public final float getTopRightRadius() {
        return this.topRightBoxRadius;
    }

    public final boolean isShadowInset() {
        return this.shadowInset;
    }

    private final void clipRadius(Canvas r100) {
        if (this.boxRadius <= 0.0f) goto L5;
    L12:
        r100.drawPath(this.clipPath, this.clipPaint);
        return;
    L5:
        if (this.topLeftBoxRadius > 0.0f) goto L12;
        if (this.topRightBoxRadius > 0.0f) goto L12;
        if (this.bottomLeftBoxRadius > 0.0f) goto L12;
        if (this.bottomRightBoxRadius > 0.0f) goto L12;
    }

    private final void drawShadow(Canvas r100) {
        this.shadowDrawable.draw(r100);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        drawShadow(r100);
        int r101 = r100.saveLayer(null, null);
        super.draw(r100);     // Catch: Throwable -> L6
        clipRadius(r100);     // Catch: Throwable -> L6
        r100.restoreToCount(r101);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r101);
        throw th;
    }

    public final void setBoxRadius(float r100) {
        float r101 = Math.abs(r100);
        this.boxRadius = r101;
        setBoxRadius(r101, r101, r101, r101);
    }

    public final void setShadowBlur(float r100) {
        this.shadowBlur = r100;
        this.shadowDrawable.setShadowBlur(r100);
        invalidate();
    }

    public final void setShadowColor(int r100) {
        this.shadowColor = r100;
        this.shadowDrawable.setShadowColor(r100);
        invalidate();
    }

    public final void setShadowInset(boolean r100) {
        this.shadowInset = r100;
        this.shadowDrawable.setShadowInset(r100);
        invalidate();
    }

    public final void setShadowSpread(float r100) {
        this.shadowSpread = r100;
        resetShadowOffset();
        invalidate();
    }

    public final void setShadowXOffset(float r100) {
        this.shadowHorizontalOffset = r100;
        resetShadowOffset();
        invalidate();
    }

    public final void setShadowYOffset(float r100) {
        this.shadowVerticalOffset = r100;
        resetShadowOffset();
        invalidate();
    }

    public final void setStyle(GXStyle r100) {
        GXRoundedCorner r101 = null;
        if (r100 == null) goto L5;
        GXBoxShadow r102 = r100.getBoxShadow();
    L6:
        if (r102 == null) goto L8;
        setShadowYOffset(r102.getYOffset().getValueFloat());
        setShadowXOffset(r102.getXOffset().getValueFloat());
        setShadowColor(r102.getColor().value(getContext()));
        setShadowBlur(r102.getBlurOffset().getValueFloat());
        setShadowSpread(r102.getSpreadOffset().getValueFloat());
    L8:
        if (r100 == null) goto L10;
        r101 = r100.getBorderRadius();
    L10:
        if (r101 == null) goto L28;
        GXSize r103 = r101.getTopLeft();
        float r104 = 0.0f;
        if (r103 == null) goto L14;
        float r105 = r103.getValueFloat();
    L15:
        GXSize r106 = r101.getTopRight();
        if (r106 == null) goto L18;
        float r107 = r106.getValueFloat();
    L19:
        GXSize r108 = r101.getBottomLeft();
        if (r108 == null) goto L22;
        float r109 = r108.getValueFloat();
    L23:
        GXSize r110 = r101.getBottomRight();
        if (r110 == null) goto L26;
        r104 = r110.getValueFloat();
    L26:
        setBoxRadius(r105, r107, r109, r104);
        return;
    L22:
        r109 = 0.0f;
        goto L23
    L18:
        r107 = 0.0f;
        goto L19
    L14:
        r105 = 0.0f;
        goto L15
    L28:
        return;
    L5:
        r102 = null;
        goto L6
    }

    private final void init(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.box_radius, R.attr.box_radiusBottomLeft, R.attr.box_radiusBottomRight, R.attr.box_radiusTopLeft, R.attr.box_radiusTopRight, R.attr.box_shadowBlur, R.attr.box_shadowColor, R.attr.box_shadowInset, R.attr.box_shadowOffsetHorizontal, R.attr.box_shadowOffsetVertical, R.attr.box_shadowSpread}, r101, 0);
        setShadowYOffset(r102.getDimension(9, 0.0f));
        setShadowXOffset(r102.getDimension(8, 0.0f));
        setShadowColor(r102.getColor(6, FakePickerAvatarCreator.GRAY));
        setShadowBlur(r102.getDimension(5, 0.0f));
        setShadowInset(r102.getBoolean(7, false));
        setShadowSpread(r102.getDimension(10, 0.0f));
        this.boxRadius = r102.getDimension(0, 0.0f);
        if (r102.hasValue(3) == false) goto L5;
    L12:
        setBoxRadius(r102.getDimension(3, this.boxRadius), r102.getDimension(4, this.boxRadius), r102.getDimension(1, this.boxRadius), r102.getDimension(2, this.boxRadius));
    L13:
        r102.recycle();
        return;
    L5:
        if (r102.hasValue(4) == true) goto L12;
        if (r102.hasValue(1) == true) goto L12;
        if (r102.hasValue(2) == true) goto L12;
        setBoxRadius(this.boxRadius);
        goto L13
    }

    public GXShadowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.shadowColor = FakePickerAvatarCreator.GRAY;
        this.clipPath = new Path();
        Paint r103 = new Paint();
        r103.setDither(true);
        r103.setAntiAlias(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.clipPaint = r103;
        Path r104 = new Path();
        this.shadowPath = r104;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        GXShadowDrawable r105 = new GXBlurMaskShadowDrawable(r104);
    L6:
        this.shadowDrawable = r105;
        setWillNotDraw(false);
        init(r101, r102);
        return;
    L5:
        r105 = new GXBlurMaskBitmapShadowDrawable(r104);
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.shadowDrawable.setBounds(0, 0, r100, r101);
        setBoxRadius(this.topLeftBoxRadius, this.topRightBoxRadius, this.bottomLeftBoxRadius, this.bottomRightBoxRadius);
    }

    public final void setBoxRadius(float r100, float r110, float r111, float r112) {
        this.topLeftBoxRadius = Math.abs(r100);
        this.topRightBoxRadius = Math.abs(r110);
        this.bottomLeftBoxRadius = Math.abs(r111);
        this.bottomRightBoxRadius = Math.abs(r112);
        this.clipPath.reset();
        this.clipPath.setFillType(Path.FillType.INVERSE_WINDING);
        addRoundRect2(this.clipPath, this.topLeftBoxRadius, this.topRightBoxRadius, this.bottomLeftBoxRadius, this.bottomRightBoxRadius, getWidth(), getHeight());
        this.shadowPath.reset();
        this.shadowPathOffsetX = 0.0f;
        this.shadowPathOffsetY = 0.0f;
        this.shadowPath.setFillType(Path.FillType.WINDING);
        float r113 = 2;
        addRoundRect2(this.shadowPath, this.topLeftBoxRadius, this.topRightBoxRadius, this.bottomLeftBoxRadius, this.bottomRightBoxRadius, getWidth() + (this.shadowSpread * r113), getHeight() + (this.shadowSpread * r113));
        resetShadowOffset();
        invalidate();
    }

    public /* synthetic */ GXShadowLayout(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    private final void addRoundRect2(Path r100, float r110, float r111, float r112, float r113, float r114, float r115) {
        r100.addRoundRect(0.0f, 0.0f, r114, r115, new float[]{r110, r110, r111, r111, r113, r113, r112, r112}, Path.Direction.CW);
    }
}
