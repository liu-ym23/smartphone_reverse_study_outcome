package e5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Le5/a;", "Landroid/graphics/drawable/Drawable;", "", "fillColor", "", "cornerRadiusPx", "<init>", "(IF)V", "Landroid/graphics/Rect;", "bounds", "LY8/t;", "onBoundsChange", "(Landroid/graphics/Rect;)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "I", "F", "Landroid/graphics/Paint;", "bitmapPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Bitmap;", "cache", "Landroid/graphics/Bitmap;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: e5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3994a extends Drawable {
    private final Paint bitmapPaint;
    private Bitmap cache;
    private final float cornerRadiusPx;
    private final int fillColor;

    public C3994a(int i10, float f10) {
        this.fillColor = i10;
        this.cornerRadiusPx = f10;
        this.bitmapPaint = new Paint(3);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        p.i(canvas, "canvas");
        Bitmap bitmap = this.cache;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, getBounds().left, getBounds().top, this.bitmapPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        p.i(bounds, "bounds");
        super.onBoundsChange(bounds);
        Bitmap bitmap = this.cache;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.cache = null;
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth <= 0 || iHeight <= 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
        p.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(this.fillColor);
        float f10 = this.cornerRadiusPx;
        if (f10 == Float.MAX_VALUE) {
            f10 = iHeight / 2.0f;
        }
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, iWidth, iHeight), f10, f10, paint);
        this.cache = bitmapCreateBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.bitmapPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.bitmapPaint.setColorFilter(colorFilter);
    }

    public /* synthetic */ C3994a(int i10, float f10, int i11, i iVar) {
        this(i10, (i11 & 2) != 0 ? Float.MAX_VALUE : f10);
    }
}
