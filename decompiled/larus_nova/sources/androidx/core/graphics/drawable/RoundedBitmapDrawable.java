package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes17.dex */
public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    final Rect mDstRect;
    private final RectF mDstRectF;
    private int mGravity;
    private boolean mIsCircular;
    private final Paint mPaint;
    private final Matrix mShaderMatrix;
    private int mTargetDensity;

    private static boolean isGreaterThanZero(float r100) {
        if (r100 <= 0.05f) goto L5;
        return true;
    L5:
        return false;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mGravity == 119) goto L5;
        return -3;
    L5:
        if (this.mIsCircular == true) goto L22;
        Bitmap r100 = this.mBitmap;
        if (r100 != null) goto L10;
        return -3;
    L10:
        if (r100.hasAlpha() == false) goto L12;
        return -3;
    L12:
        if (this.mPaint.getAlpha() >= 255) goto L14;
        return -3;
    L14:
        if (isGreaterThanZero(this.mCornerRadius) == true) goto L23;
        return -1;
    L23:
        return -3;
    L22:
        return -3;
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public void updateDstRect() {
        if (this.mApplyGravity == true) goto L5;
        return;
    L5:
        if (this.mIsCircular == false) goto L7;
        int r100 = Math.min(this.mBitmapWidth, this.mBitmapHeight);
        gravityCompatApply(this.mGravity, r100, r100, getBounds(), this.mDstRect);
        int r101 = Math.min(this.mDstRect.width(), this.mDstRect.height());
        this.mDstRect.inset(Math.max(0, (this.mDstRect.width() - r101) / 2), Math.max(0, (this.mDstRect.height() - r101) / 2));
        this.mCornerRadius = r101 * 0.5f;
    L8:
        this.mDstRectF.set(this.mDstRect);
        if (this.mBitmapShader == null) goto L11;
        Matrix r102 = this.mShaderMatrix;
        RectF r103 = this.mDstRectF;
        r102.setTranslate(r103.left, r103.top);
        this.mShaderMatrix.preScale(this.mDstRectF.width() / this.mBitmap.getWidth(), this.mDstRectF.height() / this.mBitmap.getHeight());
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mPaint.setShader(this.mBitmapShader);
    L11:
        this.mApplyGravity = false;
        return;
    L7:
        gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
        goto L8
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_graphics_drawable_RoundedBitmapDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Bitmap r101 = this.mBitmap;
        if (r101 != null) goto L5;
        return;
    L5:
        updateDstRect();
        if (this.mPaint.getShader() != null) goto L8;
        r100.drawBitmap(r101, null, this.mDstRect, this.mPaint);
        return;
    L8:
        RectF r102 = this.mDstRectF;
        float r103 = this.mCornerRadius;
        r100.drawRoundRect(r102, r103, r103, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        if (this.mIsCircular == false) goto L5;
        updateCircularCornerRadius();
    L5:
        this.mApplyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (r100 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r100);
        invalidateSelf();
        return;
    }

    public void setAntiAlias(boolean r100) {
        this.mPaint.setAntiAlias(r100);
        invalidateSelf();
    }

    public void setCircular(boolean r100) {
        this.mIsCircular = r100;
        this.mApplyGravity = true;
        if (r100 == false) goto L5;
        updateCircularCornerRadius();
        this.mPaint.setShader(this.mBitmapShader);
        invalidateSelf();
        return;
    L5:
        setCornerRadius(0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mPaint.setColorFilter(r100);
        invalidateSelf();
    }

    public void setCornerRadius(float r100) {
        if (this.mCornerRadius != r100) goto L5;
        return;
    L5:
        this.mIsCircular = false;
        if (isGreaterThanZero(r100) == false) goto L8;
        this.mPaint.setShader(this.mBitmapShader);
    L9:
        this.mCornerRadius = r100;
        invalidateSelf();
        return;
    L8:
        this.mPaint.setShader(null);
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r100) {
        this.mPaint.setDither(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r100) {
        this.mPaint.setFilterBitmap(r100);
        invalidateSelf();
    }

    public void setGravity(int r100) {
        if (this.mGravity == r100) goto L6;
        this.mGravity = r100;
        this.mApplyGravity = true;
        invalidateSelf();
        return;
    }

    public void setMipMap(boolean r100) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(int r100) {
        if (this.mTargetDensity == r100) goto L11;
        if (r100 != 0) goto L6;
        r100 = 160;
    L6:
        this.mTargetDensity = r100;
        if (this.mBitmap == null) goto L9;
        computeBitmapSize();
    L9:
        invalidateSelf();
        return;
    }

    public void setTargetDensity(Canvas r100) {
        setTargetDensity(r100.getDensity());
    }

    public void setTargetDensity(DisplayMetrics r100) {
        setTargetDensity(r100.densityDpi);
    }

    public RoundedBitmapDrawable(Resources r100, Bitmap r101) {
        this.mTargetDensity = 160;
        this.mGravity = 119;
        this.mPaint = new Paint(3);
        this.mShaderMatrix = new Matrix();
        this.mDstRect = new Rect();
        this.mDstRectF = new RectF();
        this.mApplyGravity = true;
        if (r100 == null) goto L5;
        this.mTargetDensity = INVOKEVIRTUAL_androidx_core_graphics_drawable_RoundedBitmapDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100).densityDpi;
    L5:
        this.mBitmap = r101;
        if (r101 == null) goto L8;
        computeBitmapSize();
        Shader.TileMode r102 = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(r101, r102, r102);
        return;
    L8:
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.mBitmapShader = null;
    }

    public void gravityCompatApply(int r100, int r101, int r102, Rect r103, Rect r104) {
        throw new UnsupportedOperationException();
    }
}
