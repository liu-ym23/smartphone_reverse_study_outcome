package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.d;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class BorderDrawable extends Drawable {
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;

    @Nullable
    private ColorStateList borderTint;

    @Dimension
    float borderWidth;

    @ColorInt
    private int bottomInnerStrokeColor;

    @ColorInt
    private int bottomOuterStrokeColor;
    private final RectF boundsRectF;

    @ColorInt
    private int currentBorderTintColor;
    private boolean invalidateShader;

    @NonNull
    private final Paint paint;
    private final ShapeAppearancePathProvider pathProvider;
    private final Rect rect;
    private final RectF rectF;
    private ShapeAppearanceModel shapeAppearanceModel;
    private final Path shapePath;
    private final BorderState state;

    @ColorInt
    private int topInnerStrokeColor;

    @ColorInt
    private int topOuterStrokeColor;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.BorderDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BorderState extends Drawable.ConstantState {
        final /* synthetic */ BorderDrawable this$0;

        private BorderState(BorderDrawable r10) {
            this.this$0 = r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return this.this$0;
        }

        public /* synthetic */ BorderState(BorderDrawable r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public BorderDrawable(ShapeAppearanceModel r10) {
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
        this.shapePath = new Path();
        this.rect = new Rect();
        this.rectF = new RectF();
        this.boundsRectF = new RectF();
        this.state = new BorderState(this, null);
        this.invalidateShader = true;
        this.shapeAppearanceModel = r10;
        Paint r11 = new Paint(1);
        this.paint = r11;
        r11.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader createGradientShader() {
        Rect r10 = this.rect;
        copyBounds(r10);
        float r11 = this.borderWidth / r10.height();
        return new LinearGradient(0.0f, r10.top, 0.0f, r10.bottom, new int[]{d.g(this.topOuterStrokeColor, this.currentBorderTintColor), d.g(this.topInnerStrokeColor, this.currentBorderTintColor), d.g(d.k(this.topInnerStrokeColor, 0), this.currentBorderTintColor), d.g(d.k(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), d.g(this.bottomInnerStrokeColor, this.currentBorderTintColor), d.g(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, r11, 0.5f, 0.5f, 1.0f - r11, 1.0f}, Shader.TileMode.CLAMP);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        if (this.invalidateShader == false) goto L5;
        this.paint.setShader(createGradientShader());
        this.invalidateShader = false;
    L5:
        float r11 = this.paint.getStrokeWidth() / 2.0f;
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        float r12 = Math.min(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()), this.rectF.width() / 2.0f);
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) == false) goto L9;
        this.rectF.inset(r11, r11);
        r10.drawRoundRect(this.rectF, r12, r12, this.paint);
        return;
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.boundsRectF.set(getBounds());
        return this.boundsRectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.borderWidth <= 0.0f) goto L5;
        return -3;
    L5:
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r10) {
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) == false) goto L6;
        float r11 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
        r10.setRoundRect(getBounds(), r11);
        return;
    L6:
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.rectF, this.shapePath);
        if (this.shapePath.isConvex() == false) goto L10;
        r10.setConvexPath(this.shapePath);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r10) {
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) == false) goto L7;
        int r11 = Math.round(this.borderWidth);
        r10.set(r11, r11, r11, r11);
        return true;
    L7:
        return true;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r10 = this.borderTint;
        if (r10 == null) goto L7;
        if (r10.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        this.invalidateShader = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r10) {
        ColorStateList r11 = this.borderTint;
        if (r11 == null) goto L8;
        int r12 = r11.getColorForState(r10, this.currentBorderTintColor);
        if (r12 == this.currentBorderTintColor) goto L8;
        this.invalidateShader = true;
        this.currentBorderTintColor = r12;
    L8:
        if (this.invalidateShader == false) goto L11;
        invalidateSelf();
    L11:
        return this.invalidateShader;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r10) {
        this.paint.setAlpha(r10);
        invalidateSelf();
    }

    public void setBorderTint(@Nullable ColorStateList r10) {
        if (r10 == null) goto L4;
        this.currentBorderTintColor = r10.getColorForState(getState(), this.currentBorderTintColor);
    L4:
        this.borderTint = r10;
        this.invalidateShader = true;
        invalidateSelf();
    }

    public void setBorderWidth(@Dimension float r10) {
        if (this.borderWidth == r10) goto L6;
        this.borderWidth = r10;
        this.paint.setStrokeWidth(r10 * DRAW_STROKE_WIDTH_MULTIPLE);
        this.invalidateShader = true;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.paint.setColorFilter(r10);
        invalidateSelf();
    }

    public void setGradientColors(@ColorInt int r10, @ColorInt int r11, @ColorInt int r12, @ColorInt int r13) {
        this.topOuterStrokeColor = r10;
        this.topInnerStrokeColor = r11;
        this.bottomOuterStrokeColor = r12;
        this.bottomInnerStrokeColor = r13;
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel r10) {
        this.shapeAppearanceModel = r10;
        invalidateSelf();
    }
}
