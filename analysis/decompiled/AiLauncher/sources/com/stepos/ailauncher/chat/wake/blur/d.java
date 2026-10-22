package com.stepos.ailauncher.chat.wake.blur;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/blur/d;", "Landroid/graphics/drawable/Drawable;", "", "cornerRadiusPx", "strokeWidthPx", "", "colors", "", "positions", "", "horizontal", "<init>", "(FF[I[FZ)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", "", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "F", "[I", "[F", "Z", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", Const.INTENT_KEY_APIKEY, "()F", "effectiveRadius", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends Drawable {
    private final int[] colors;
    private final float cornerRadiusPx;
    private final boolean horizontal;
    private final Paint paint;
    private final float[] positions;
    private final RectF rect;
    private final float strokeWidthPx;

    public d(float f10, float f11, int[] colors, float[] fArr, boolean z10) {
        p.i(colors, "colors");
        this.cornerRadiusPx = f10;
        this.strokeWidthPx = f11;
        this.colors = colors;
        this.positions = fArr;
        this.horizontal = z10;
        if (colors.length < 2) {
            throw new IllegalArgumentException("GradientStrokeDrawable requires at least 2 colors");
        }
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f11);
        this.paint = paint;
        this.rect = new RectF();
    }

    public final float a() {
        return C5685n.e(this.cornerRadiusPx - (this.strokeWidthPx / 2.0f), 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        p.i(canvas, "canvas");
        Rect bounds = getBounds();
        p.h(bounds, "getBounds(...)");
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        float f10 = this.strokeWidthPx / 2.0f;
        this.rect.set(bounds.left + f10, bounds.top + f10, bounds.right - f10, bounds.bottom - f10);
        canvas.drawRoundRect(this.rect, a(), a(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        p.i(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.paint.setShader(this.horizontal ? new LinearGradient(bounds.left, bounds.exactCenterY(), bounds.right, bounds.exactCenterY(), this.colors, this.positions, Shader.TileMode.CLAMP) : new LinearGradient(bounds.exactCenterX(), bounds.top, bounds.exactCenterX(), bounds.bottom, this.colors, this.positions, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.paint.getAlpha() != alpha) {
            this.paint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public /* synthetic */ d(float f10, float f11, int[] iArr, float[] fArr, boolean z10, int i10, i iVar) {
        this(f10, f11, iArr, (i10 & 8) != 0 ? null : fArr, (i10 & 16) != 0 ? true : z10);
    }
}
