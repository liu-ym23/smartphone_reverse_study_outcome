package com.alibaba.gaiax.render.view.basic.boxshadow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0015J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0017J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/boxshadow/GXBitmapShadowDrawable;", "Lcom/alibaba/gaiax/render/view/basic/boxshadow/GXShadowDrawable;", "shadowPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "bitmapDrawOver", "", "createBitmap", "", "draw", "canvas", "Landroid/graphics/Canvas;", "drawBitmap", "invalidateCache", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onDrawBitmap", "onShadowChange", "blur", "", "color", "", "inset", "setShadowBlur", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class GXBitmapShadowDrawable extends GXShadowDrawable {
    private Bitmap bitmap;
    private boolean bitmapDrawOver;

    @Override // com.alibaba.gaiax.render.view.basic.boxshadow.GXShadowDrawable
    public void invalidateCache() {
        this.bitmapDrawOver = false;
    }

    public abstract void onDrawBitmap(Bitmap r100);

    private final void createBitmap() {
        float r100 = 4;
        int r101 = (int) (getBounds().width() + (getShadowBlur() * r100));
        int r102 = (int) (getBounds().height() + (getShadowBlur() * r100));
        Bitmap r103 = this.bitmap;
        if (r103 != null) goto L5;
    L9:
        if (r103 == null) goto L11;
        r103.recycle();
    L11:
        this.bitmap = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        invalidateCache();
        return;
    L5:
        if (r103.getWidth() < r101) goto L9;
        if (r103.getHeight() < r102) goto L9;
    }

    public GXBitmapShadowDrawable(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "shadowPath");
        super(r100);
    }

    private final void drawBitmap(Bitmap r100) {
        if (this.bitmapDrawOver == false) goto L5;
        return;
    L5:
        onDrawBitmap(r100);
        this.bitmapDrawOver = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        createBitmap();
        Bitmap r101 = this.bitmap;
        if (r101 != null) goto L5;
        return;
    L5:
        drawBitmap(r101);
        float r102 = 2;
        r100.drawBitmap(r101, (-getShadowBlur()) * r102, (-getShadowBlur()) * r102, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        invalidateCache();
    }

    @Override // com.alibaba.gaiax.render.view.basic.boxshadow.GXShadowDrawable
    public void setShadowBlur(float r100) {
        super.setShadowBlur(r100);
        invalidateCache();
    }

    @Override // com.alibaba.gaiax.render.view.basic.boxshadow.GXShadowDrawable
    public void onShadowChange(float r100, int r101, boolean r102) {
        invalidateCache();
    }
}
