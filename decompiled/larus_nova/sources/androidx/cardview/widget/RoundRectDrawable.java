package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
class RoundRectDrawable extends Drawable {
    private ColorStateList mBackground;
    private final RectF mBoundsF;
    private final Rect mBoundsI;
    private boolean mInsetForPadding;
    private boolean mInsetForRadius;
    private float mPadding;
    private final Paint mPaint;
    private float mRadius;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r100 = this.mTint;
        if (r100 != null) goto L5;
    L6:
        ColorStateList r101 = this.mBackground;
        if (r101 == null) goto L11;
        if (r101.isStateful() == false) goto L11;
    L12:
        return true;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    L5:
        if (r100.isStateful() == true) goto L12;
        goto L6
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public float getRadius() {
        return this.mRadius;
    }

    private void setBackground(ColorStateList r100) {
        if (r100 != null) goto L4;
        r100 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r100;
        this.mPaint.setColor(r100.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void updateBounds(Rect r100) {
        if (r100 != null) goto L4;
        r100 = getBounds();
    L4:
        this.mBoundsF.set(r100.left, r100.top, r100.right, r100.bottom);
        this.mBoundsI.set(r100);
        if (this.mInsetForPadding == false) goto L8;
        float r101 = RoundRectDrawableWithShadow.calculateVerticalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
        this.mBoundsI.inset((int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mPadding, this.mRadius, this.mInsetForRadius)), (int) Math.ceil(r101));
        this.mBoundsF.set(this.mBoundsI);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Paint r101 = this.mPaint;
        if (this.mTintFilter != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        RectF r103 = this.mBoundsF;
        float r104 = this.mRadius;
        r100.drawRoundRect(r103, r104, r104, r101);
        if (r102 == false) goto L12;
        r101.setColorFilter(null);
        return;
    L12:
        return;
    L5:
        if (r101.getColorFilter() != null) goto L7;
        r101.setColorFilter(this.mTintFilter);
        r102 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        r100.setRoundRect(this.mBoundsI, this.mRadius);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        updateBounds(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        ColorStateList r101 = this.mBackground;
        int r102 = r101.getColorForState(r100, r101.getDefaultColor());
        if (r102 == this.mPaint.getColor()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        this.mPaint.setColor(r102);
    L8:
        ColorStateList r104 = this.mTint;
        if (r104 == null) goto L14;
        PorterDuff.Mode r105 = this.mTintMode;
        if (r105 == null) goto L14;
        this.mTintFilter = createTintFilter(r104, r105);
        return true;
    L14:
        return r103;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mPaint.setAlpha(r100);
    }

    public void setColor(ColorStateList r100) {
        setBackground(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mPaint.setColorFilter(r100);
    }

    public void setRadius(float r100) {
        if (r100 != this.mRadius) goto L5;
        return;
    L5:
        this.mRadius = r100;
        updateBounds(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r100) {
        this.mTint = r100;
        this.mTintFilter = createTintFilter(r100, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r100) {
        this.mTintMode = r100;
        this.mTintFilter = createTintFilter(this.mTint, r100);
        invalidateSelf();
    }

    public RoundRectDrawable(ColorStateList r100, float r101) {
        this.mInsetForPadding = false;
        this.mInsetForRadius = true;
        this.mTintMode = PorterDuff.Mode.SRC_IN;
        this.mRadius = r101;
        this.mPaint = new Paint(5);
        setBackground(r100);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList r100, PorterDuff.Mode r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r100.getColorForState(getState(), 0), r101);
    L7:
        return null;
    }

    public void setPadding(float r100, boolean r101, boolean r102) {
        if (r100 == this.mPadding) goto L5;
    L9:
        this.mPadding = r100;
        this.mInsetForPadding = r101;
        this.mInsetForRadius = r102;
        updateBounds(null);
        invalidateSelf();
        return;
    L5:
        if (this.mInsetForPadding != r101) goto L9;
        if (this.mInsetForRadius != r102) goto L9;
    }
}
