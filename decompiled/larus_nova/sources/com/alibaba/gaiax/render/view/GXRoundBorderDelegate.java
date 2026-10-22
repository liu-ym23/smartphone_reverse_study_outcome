package com.alibaba.gaiax.render.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cJ \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010\u001f\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004J \u0010 \u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004J6\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u001e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0010J&\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXRoundBorderDelegate;", "", "()V", "measureHeight", "", "measureWidth", "roundCornerBorderColor", "", "Ljava/lang/Integer;", "roundCornerBorderPaint", "Landroid/graphics/Paint;", "roundCornerBorderPath", "Landroid/graphics/Path;", "roundCornerBorderPathIsDirty", "", "roundCornerBorderRadiusArray", "", "roundCornerBorderWidth", "Ljava/lang/Float;", "roundCornerRadiusArray", "roundCornerRadiusPaint", "roundCornerRadiusPath", "roundCornerRadiusPathIsDirty", "draw", "", "canvas", "Landroid/graphics/Canvas;", "callback", "Lkotlin/Function0;", "drawRoundBorder", "drawRoundCorner", "isNeedRound", "onDraw", "setRoundCornerBorder", "borderColor", "borderWidth", "topLeft", "topRight", "bottomLeft", "bottomRight", "radius", "setRoundCornerRadius", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXRoundBorderDelegate {
    private float measureHeight;
    private float measureWidth;
    private Integer roundCornerBorderColor;
    private Paint roundCornerBorderPaint;
    private Path roundCornerBorderPath;
    private boolean roundCornerBorderPathIsDirty;
    private float[] roundCornerBorderRadiusArray;
    private Float roundCornerBorderWidth;
    private float[] roundCornerRadiusArray;
    private Paint roundCornerRadiusPaint;
    private Path roundCornerRadiusPath;
    private boolean roundCornerRadiusPathIsDirty;

    public GXRoundBorderDelegate() {
    }

    public final void setRoundCornerRadius(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        this.roundCornerRadiusArray = r100;
        this.roundCornerRadiusPath = null;
        this.roundCornerRadiusPathIsDirty = true;
    }

    private final void drawRoundBorder(Canvas r100, float r101, float r110) {
        Integer r102 = this.roundCornerBorderColor;
        Float r103 = this.roundCornerBorderWidth;
        float[] r104 = this.roundCornerBorderRadiusArray;
        if (r102 == null) goto L28;
        if (r103 == null) goto L29;
        if (r104 != null) goto L7;
        return;
    L7:
        if (this.roundCornerBorderPaint != null) goto L10;
        Paint r105 = new Paint(1);
        this.roundCornerBorderPaint = r105;
        r105.setStyle(Paint.Style.STROKE);
    L10:
        if (this.roundCornerBorderPath != null) goto L12;
        this.roundCornerBorderPath = new Path();
    L12:
        Paint r106 = this.roundCornerBorderPaint;
        if (r106 == null) goto L16;
        r106.setStrokeWidth(r103.floatValue());
    L16:
        Paint r107 = this.roundCornerBorderPaint;
        if (r107 == null) goto L21;
        r107.setColor(r102.intValue());
    L21:
        if (this.roundCornerBorderPathIsDirty == false) goto L26;
        float r108 = 2;
        RectF r109 = new RectF(r103.floatValue() / r108, r103.floatValue() / r108, r101 - (r103.floatValue() / r108), r110 - (r103.floatValue() / r108));
        Path r111 = this.roundCornerBorderPath;
        if (r111 == null) goto L25;
        r111.addRoundRect(r109, r104, Path.Direction.CW);
    L25:
        this.roundCornerBorderPathIsDirty = false;
    L26:
        Path r112 = this.roundCornerBorderPath;
        Intrinsics.checkNotNull(r112);
        Paint r113 = this.roundCornerBorderPaint;
        Intrinsics.checkNotNull(r113);
        r100.drawPath(r112, r113);
        return;
    L29:
        return;
    }

    private final void drawRoundCorner(Canvas r100, float r101, float r102) {
        float[] r103 = this.roundCornerRadiusArray;
        if (r103 != null) goto L5;
        return;
    L5:
        if (this.roundCornerRadiusPaint != null) goto L19;
        Paint r104 = new Paint();
        this.roundCornerRadiusPaint = r104;
        r104.setAntiAlias(true);
        Paint r105 = this.roundCornerRadiusPaint;
        if (r105 == null) goto L10;
        r105.setStyle(Paint.Style.FILL);
    L10:
        Paint r106 = this.roundCornerRadiusPaint;
        if (r106 == null) goto L14;
        r106.setColor(-65536);
    L14:
        Paint r107 = this.roundCornerRadiusPaint;
        if (r107 == null) goto L19;
        r107.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    L19:
        if (this.roundCornerRadiusPath != null) goto L22;
        this.roundCornerRadiusPath = new Path();
    L22:
        if (this.roundCornerRadiusPathIsDirty == false) goto L30;
        RectF r108 = new RectF(0.0f, 0.0f, r101, r102);
        Path r109 = this.roundCornerRadiusPath;
        if (r109 == null) goto L26;
        r109.addRect(r108, Path.Direction.CW);
    L26:
        Path r110 = this.roundCornerRadiusPath;
        if (r110 == null) goto L29;
        r110.addRoundRect(r108, r103, Path.Direction.CCW);
    L29:
        this.roundCornerRadiusPathIsDirty = false;
    L30:
        Path r111 = this.roundCornerRadiusPath;
        Intrinsics.checkNotNull(r111);
        Paint r112 = this.roundCornerRadiusPaint;
        Intrinsics.checkNotNull(r112);
        r100.drawPath(r111, r112);
    }

    public final boolean isNeedRound(Canvas r100, float r101, float r102) {
        if (r100 != null) goto L4;
    L16:
        return false;
    L4:
        if (r101 <= 0.0f) goto L16;
        if (r102 <= 0.0f) goto L16;
        if (this.roundCornerRadiusArray == null) goto L10;
    L15:
        return true;
    L10:
        if (this.roundCornerBorderRadiusArray == null) goto L16;
        if (this.roundCornerBorderColor == null) goto L16;
        if (this.roundCornerBorderWidth == null) goto L16;
        goto L15
    }

    public final void onDraw(Canvas r100, float r101, float r102) {
        this.measureWidth = r101;
        this.measureHeight = r102;
        if (r100 == null) goto L6;
        drawRoundCorner(r100, r101, r102);
        drawRoundBorder(r100, r101, r102);
        return;
    }

    public final void setRoundCornerBorder(int r100, float r101, float[] r102) {
        Intrinsics.checkNotNullParameter(r102, "radius");
        this.roundCornerBorderColor = Integer.valueOf(r100);
        this.roundCornerBorderWidth = Float.valueOf(r101);
        this.roundCornerBorderRadiusArray = r102;
        this.roundCornerBorderPath = null;
        this.roundCornerBorderPathIsDirty = true;
    }

    public final void draw(Canvas r100, float r101, float r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r100 == null) goto L5;
        r100.saveLayer(0.0f, 0.0f, r101, r110, null);
    L5:
        r111.invoke();
        if (r100 == null) goto L9;
        r100.restore();
        return;
    }

    public final void setRoundCornerRadius(float r100, float r101, float r102, float r103) {
        setRoundCornerRadius(new float[]{r100, r100, r101, r101, r102, r102, r103, r103});
    }

    public final void setRoundCornerBorder(int r100, float r101, float r102, float r103, float r104, float r105) {
        float[] r106 = {r102, r102, r103, r103, r104, r104, r105, r105};
        Unit r107 = Unit.INSTANCE;
        setRoundCornerBorder(r100, r101, r106);
    }
}
