package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = 0.0d;
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    public interface RoundRectHelper {
        void drawRoundRect(Canvas r100, RectF r101, float r102, Paint r103);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void buildShadowCorners() {
        float r100 = this.mCornerRadius;
        RectF r101 = new RectF(-r100, -r100, r100, r100);
        RectF r102 = new RectF(r101);
        float r103 = this.mShadowSize;
        r102.inset(-r103, -r103);
        Path r104 = this.mCornerShadowPath;
        if (r104 != null) goto L5;
        this.mCornerShadowPath = new Path();
    L6:
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(r102, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(r101, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float r105 = this.mCornerRadius;
        float r106 = r105 / (this.mShadowSize + r105);
        Paint r107 = this.mCornerShadowPaint;
        float r110 = this.mCornerRadius + this.mShadowSize;
        int r108 = this.mShadowStartColor;
        r107.setShader(new RadialGradient(0.0f, 0.0f, r110, new int[]{r108, r108, this.mShadowEndColor}, new float[]{0.0f, r106, 1.0f}, Shader.TileMode.CLAMP));
        Paint r109 = this.mEdgeShadowPaint;
        float r111 = this.mCornerRadius;
        float r112 = this.mShadowSize;
        int r113 = this.mShadowStartColor;
        r109.setShader(new LinearGradient(0.0f, (-r111) + r112, 0.0f, (-r111) - r112, new int[]{r113, r113, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r104.reset();
        goto L6
    }

    public float getMinHeight() {
        float r100 = this.mRawMaxShadowSize;
        return (Math.max(r100, (this.mCornerRadius + this.mInsetShadow) + ((r100 * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + this.mInsetShadow) * 2.0f);
    }

    public float getMinWidth() {
        float r100 = this.mRawMaxShadowSize;
        return (Math.max(r100, (this.mCornerRadius + this.mInsetShadow) + (r100 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r100 = this.mBackground;
        if (r100 == null) goto L7;
        if (r100.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    private void buildComponents(Rect r100) {
        float r101 = this.mRawMaxShadowSize;
        float r102 = 1.5f * r101;
        this.mCardBounds.set(r100.left + r101, r100.top + r102, r100.right - r101, r100.bottom - r102);
        buildShadowCorners();
    }

    private void drawShadow(Canvas r110) {
        float r100 = this.mCornerRadius;
        float r101 = (-r100) - this.mShadowSize;
        float r102 = (r100 + this.mInsetShadow) + (this.mRawShadowSize / 2.0f);
        float r103 = r102 * 2.0f;
        if ((this.mCardBounds.width() - r103) <= 0.0f) goto L5;
        boolean r104 = true;
    L7:
        if ((this.mCardBounds.height() - r103) <= 0.0f) goto L9;
        boolean r111 = true;
    L10:
        int r112 = r110.save();
        RectF r105 = this.mCardBounds;
        r110.translate(r105.left + r102, r105.top + r102);
        r110.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r104 == false) goto L13;
        r110.drawRect(0.0f, r101, this.mCardBounds.width() - r103, -this.mCornerRadius, this.mEdgeShadowPaint);
    L13:
        r110.restoreToCount(r112);
        int r113 = r110.save();
        RectF r106 = this.mCardBounds;
        r110.translate(r106.right - r102, r106.bottom - r102);
        r110.rotate(180.0f);
        r110.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r104 == false) goto L16;
        r110.drawRect(0.0f, r101, this.mCardBounds.width() - r103, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
    L16:
        r110.restoreToCount(r113);
        int r107 = r110.save();
        RectF r108 = this.mCardBounds;
        r110.translate(r108.left + r102, r108.bottom - r102);
        r110.rotate(270.0f);
        r110.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r111 == false) goto L19;
        r110.drawRect(0.0f, r101, this.mCardBounds.height() - r103, -this.mCornerRadius, this.mEdgeShadowPaint);
    L19:
        r110.restoreToCount(r107);
        int r109 = r110.save();
        RectF r114 = this.mCardBounds;
        r110.translate(r114.right - r102, r114.top + r102);
        r110.rotate(90.0f);
        r110.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r111 == false) goto L22;
        r110.drawRect(0.0f, r101, this.mCardBounds.height() - r103, -this.mCornerRadius, this.mEdgeShadowPaint);
    L22:
        r110.restoreToCount(r109);
        return;
    L9:
        r111 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    private void setBackground(ColorStateList r100) {
        if (r100 != null) goto L4;
        r100 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r100;
        this.mPaint.setColor(r100.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private int toEven(float r100) {
        int r101 = (int) (r100 + 0.5f);
        if ((r101 % 2) == 1) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (this.mDirty == false) goto L5;
        buildComponents(getBounds());
        this.mDirty = false;
    L5:
        r100.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(r100);
        r100.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(r100, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    public void getMaxShadowAndCornerPadding(Rect r100) {
        getPadding(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        int r101 = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int r102 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        r100.set(r102, r101, r102, r101);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        this.mDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        ColorStateList r101 = this.mBackground;
        int r102 = r101.getColorForState(r100, r101.getDefaultColor());
        if (this.mPaint.getColor() != r102) goto L6;
        return false;
    L6:
        this.mPaint.setColor(r102);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public void setAddPaddingForCorners(boolean r100) {
        this.mAddPaddingForCorners = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mPaint.setAlpha(r100);
        this.mCornerShadowPaint.setAlpha(r100);
        this.mEdgeShadowPaint.setAlpha(r100);
    }

    public void setColor(ColorStateList r100) {
        setBackground(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mPaint.setColorFilter(r100);
    }

    public void setCornerRadius(float r100) {
        if (r100 < 0.0f) goto L10;
        float r101 = (int) (r100 + 0.5f);
        if (this.mCornerRadius != r101) goto L7;
        return;
    L7:
        this.mCornerRadius = r101;
        this.mDirty = true;
        invalidateSelf();
        return;
    L10:
        throw new IllegalArgumentException("Invalid radius " + r100 + ". Must be >= 0");
    }

    public void setMaxShadowSize(float r100) {
        setShadowSize(this.mRawShadowSize, r100);
    }

    public void setShadowSize(float r100) {
        setShadowSize(r100, this.mRawMaxShadowSize);
    }

    private void setShadowSize(float r100, float r101) {
        if (r100 < 0.0f) goto L22;
        if (r101 < 0.0f) goto L20;
        float r102 = toEven(r100);
        float r103 = toEven(r101);
        if (r102 <= r103) goto L13;
        if (this.mPrintedShadowClipWarning == true) goto L11;
        this.mPrintedShadowClipWarning = true;
    L11:
        r102 = r103;
    L13:
        if (this.mRawShadowSize == r102) goto L15;
    L17:
        this.mRawShadowSize = r102;
        this.mRawMaxShadowSize = r103;
        this.mShadowSize = (int) (((r102 * 1.5f) + this.mInsetShadow) + 0.5f);
        this.mDirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.mRawMaxShadowSize != r103) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("Invalid max shadow size " + r101 + ". Must be >= 0");
    L22:
        throw new IllegalArgumentException("Invalid shadow size " + r100 + ". Must be >= 0");
    }

    public static float calculateHorizontalPadding(float r100, float r101, boolean r102) {
        if (r102 == true) goto L4;
        return r100;
    L4:
        return (float) (((double) r100) + ((1.0d - COS_45) * ((double) r101)));
    }

    public static float calculateVerticalPadding(float r100, float r101, boolean r102) {
        if (r102 == false) goto L7;
        return (float) (((double) (r100 * 1.5f)) + ((1.0d - COS_45) * ((double) r101)));
    L7:
        return r100 * 1.5f;
    }

    public RoundRectDrawableWithShadow(Resources r100, ColorStateList r101, float r102, float r103, float r104) {
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = r100.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = r100.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = r100.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(r101);
        Paint r105 = new Paint(5);
        this.mCornerShadowPaint = r105;
        r105.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (r102 + 0.5f);
        this.mCardBounds = new RectF();
        Paint r106 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = r106;
        r106.setAntiAlias(false);
        setShadowSize(r103, r104);
    }
}
