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
import androidx.cardview.R;

/* JADX INFO: loaded from: classes.dex */
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

    interface RoundRectHelper {
        void drawRoundRect(Canvas r1, RectF r2, float r3, Paint r4);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    RoundRectDrawableWithShadow(Resources r3, ColorStateList r4, float r5, float r6, float r7) {
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = r3.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = r3.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = r3.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(r4);
        Paint r8 = new Paint(5);
        this.mCornerShadowPaint = r8;
        r8.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (r5 + 0.5f);
        this.mCardBounds = new RectF();
        Paint r9 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = r9;
        r9.setAntiAlias(false);
        setShadowSize(r6, r7);
    }

    private void setBackground(ColorStateList r3) {
        if (r3 != null) goto L4;
        r3 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r3;
        this.mPaint.setColor(r3.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private int toEven(float r2) {
        int r1 = (int) (r2 + 0.5f);
        if ((r1 % 2) == 1) goto L5;
        return r1;
    L5:
        return r1 - 1;
    }

    void setAddPaddingForCorners(boolean r1) {
        this.mAddPaddingForCorners = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.mPaint.setAlpha(r2);
        this.mCornerShadowPaint.setAlpha(r2);
        this.mEdgeShadowPaint.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        this.mDirty = true;
    }

    private void setShadowSize(float r4, float r5) {
        if (r4 < 0.0f) goto L22;
        if (r5 < 0.0f) goto L20;
        float r6 = toEven(r4);
        float r7 = toEven(r5);
        if (r6 <= r7) goto L13;
        if (this.mPrintedShadowClipWarning == true) goto L11;
        this.mPrintedShadowClipWarning = true;
    L11:
        r6 = r7;
    L13:
        if (this.mRawShadowSize == r6) goto L15;
    L17:
        this.mRawShadowSize = r6;
        this.mRawMaxShadowSize = r7;
        this.mShadowSize = (int) (((r6 * SHADOW_MULTIPLIER) + this.mInsetShadow) + 0.5f);
        this.mDirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.mRawMaxShadowSize != r7) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("Invalid max shadow size " + r5 + ". Must be >= 0");
    L22:
        throw new IllegalArgumentException("Invalid shadow size " + r4 + ". Must be >= 0");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r4) {
        int r0 = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int r3 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        r4.set(r3, r0, r3, r0);
        return true;
    }

    static float calculateVerticalPadding(float r6, float r7, boolean r8) {
        if (r8 == false) goto L7;
        return (float) (((double) (r6 * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) r7)));
    L7:
        return r6 * SHADOW_MULTIPLIER;
    }

    static float calculateHorizontalPadding(float r6, float r7, boolean r8) {
        if (r8 == true) goto L4;
        return r6;
    L4:
        return (float) (((double) r6) + ((1.0d - COS_45) * ((double) r7)));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r3) {
        ColorStateList r0 = this.mBackground;
        int r4 = r0.getColorForState(r3, r0.getDefaultColor());
        if (this.mPaint.getColor() != r4) goto L6;
        return false;
    L6:
        this.mPaint.setColor(r4);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r0 = this.mBackground;
        if (r0 == null) goto L7;
        if (r0.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.mPaint.setColorFilter(r1);
    }

    void setCornerRadius(float r3) {
        if (r3 < 0.0f) goto L10;
        float r4 = (int) (r3 + 0.5f);
        if (this.mCornerRadius != r4) goto L7;
        return;
    L7:
        this.mCornerRadius = r4;
        this.mDirty = true;
        invalidateSelf();
        return;
    L10:
        throw new IllegalArgumentException("Invalid radius " + r3 + ". Must be >= 0");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r4) {
        if (this.mDirty == false) goto L5;
        buildComponents(getBounds());
        this.mDirty = false;
    L5:
        r4.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(r4);
        r4.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(r4, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    private void drawShadow(Canvas r13) {
        float r0 = this.mCornerRadius;
        float r1 = (-r0) - this.mShadowSize;
        float r2 = (r0 + this.mInsetShadow) + (this.mRawShadowSize / 2.0f);
        float r9 = r2 * 2.0f;
        if ((this.mCardBounds.width() - r9) <= 0.0f) goto L5;
        boolean r3 = true;
    L7:
        if ((this.mCardBounds.height() - r9) <= 0.0f) goto L9;
        boolean r10 = true;
    L10:
        int r11 = r13.save();
        r13.translate(this.mCardBounds.left + r2, this.mCardBounds.top + r2);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r3 == false) goto L13;
        r13.drawRect(0.0f, r1, this.mCardBounds.width() - r9, -this.mCornerRadius, this.mEdgeShadowPaint);
    L13:
        r13.restoreToCount(r11);
        int r12 = r13.save();
        r13.translate(this.mCardBounds.right - r2, this.mCardBounds.bottom - r2);
        r13.rotate(180.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r3 == false) goto L16;
        r13.drawRect(0.0f, r1, this.mCardBounds.width() - r9, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
    L16:
        r13.restoreToCount(r12);
        int r4 = r13.save();
        r13.translate(this.mCardBounds.left + r2, this.mCardBounds.bottom - r2);
        r13.rotate(270.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r10 == false) goto L19;
        r13.drawRect(0.0f, r1, this.mCardBounds.height() - r9, -this.mCornerRadius, this.mEdgeShadowPaint);
    L19:
        r13.restoreToCount(r4);
        int r5 = r13.save();
        r13.translate(this.mCardBounds.right - r2, this.mCardBounds.top + r2);
        r13.rotate(90.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r10 == false) goto L22;
        r13.drawRect(0.0f, r1, this.mCardBounds.height() - r9, -this.mCornerRadius, this.mEdgeShadowPaint);
    L22:
        r13.restoreToCount(r5);
        return;
    L9:
        r10 = false;
        goto L10
    L5:
        r3 = false;
        goto L7
    }

    private void buildShadowCorners() {
        float r2 = this.mCornerRadius;
        RectF r1 = new RectF(-r2, -r2, r2, r2);
        RectF r3 = new RectF(r1);
        float r4 = this.mShadowSize;
        r3.inset(-r4, -r4);
        Path r5 = this.mCornerShadowPath;
        if (r5 != null) goto L5;
        this.mCornerShadowPath = new Path();
    L6:
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(r3, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(r1, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float r6 = this.mCornerRadius;
        float r7 = r6 / (this.mShadowSize + r6);
        Paint r8 = this.mCornerShadowPaint;
        float r11 = this.mCornerRadius + this.mShadowSize;
        int r9 = this.mShadowStartColor;
        r8.setShader(new RadialGradient(0.0f, 0.0f, r11, new int[]{r9, r9, this.mShadowEndColor}, new float[]{0.0f, r7, 1.0f}, Shader.TileMode.CLAMP));
        Paint r10 = this.mEdgeShadowPaint;
        float r12 = this.mCornerRadius;
        float r13 = this.mShadowSize;
        int r14 = this.mShadowStartColor;
        r10.setShader(new LinearGradient(0.0f, (-r12) + r13, 0.0f, (-r12) - r13, new int[]{r14, r14, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r5.reset();
        goto L6
    }

    private void buildComponents(Rect r7) {
        float r0 = this.mRawMaxShadowSize * SHADOW_MULTIPLIER;
        this.mCardBounds.set(r7.left + this.mRawMaxShadowSize, r7.top + r0, r7.right - this.mRawMaxShadowSize, r7.bottom - r0);
        buildShadowCorners();
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect r1) {
        getPadding(r1);
    }

    void setShadowSize(float r2) {
        setShadowSize(r2, this.mRawMaxShadowSize);
    }

    void setMaxShadowSize(float r2) {
        setShadowSize(this.mRawShadowSize, r2);
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinWidth() {
        float r0 = this.mRawMaxShadowSize;
        return (Math.max(r0, (this.mCornerRadius + this.mInsetShadow) + (r0 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
    }

    float getMinHeight() {
        float r0 = this.mRawMaxShadowSize;
        return (Math.max(r0, (this.mCornerRadius + this.mInsetShadow) + ((r0 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + this.mInsetShadow) * 2.0f);
    }

    void setColor(ColorStateList r1) {
        setBackground(r1);
        invalidateSelf();
    }

    ColorStateList getColor() {
        return this.mBackground;
    }
}
