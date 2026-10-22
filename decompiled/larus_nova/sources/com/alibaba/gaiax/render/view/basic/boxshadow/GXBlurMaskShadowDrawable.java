package com.alibaba.gaiax.render.view.basic.boxshadow;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/boxshadow/GXBlurMaskShadowDrawable;", "Lcom/alibaba/gaiax/render/view/basic/boxshadow/GXShadowDrawable;", "shadowPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "shadowPaint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onShadowChange", "blur", "", "color", "", "inset", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXBlurMaskShadowDrawable extends GXShadowDrawable {
    private final Paint shadowPaint;

    public GXBlurMaskShadowDrawable(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "shadowPath");
        super(r100);
        Paint r101 = new Paint();
        r101.setDither(true);
        r101.setAntiAlias(true);
        r101.setStyle(Paint.Style.FILL);
        this.shadowPaint = r101;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawPath(getShadowPath(), this.shadowPaint);
    }

    @Override // com.alibaba.gaiax.render.view.basic.boxshadow.GXShadowDrawable
    public void onShadowChange(float r100, int r101, boolean r102) {
        if (getShadowInset() == false) goto L5;
        BlurMaskFilter.Blur r103 = BlurMaskFilter.Blur.INNER;
    L6:
        Paint r104 = this.shadowPaint;
        if (getShadowBlur() != 0.0f) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        BlurMaskFilter r106 = null;
    L13:
        r104.setMaskFilter(r106);
        this.shadowPaint.setColor(r101);
        return;
    L12:
        r106 = new BlurMaskFilter(getShadowBlur(), r103);
        goto L13
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = BlurMaskFilter.Blur.NORMAL;
        goto L6
    }
}
