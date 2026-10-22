package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.b;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint = null;
    private final BitSet containsIncompatibleShadowOp;
    private final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    private MaterialShapeDrawableState drawableState;
    private final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;

    @NonNull
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;

    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;

    @Nullable
    private PorterDuffColorFilter strokeTintFilter;

    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha;

        @Nullable
        public ColorFilter colorFilter;
        public float elevation;

        @Nullable
        public ElevationOverlayProvider elevationOverlayProvider;

        @Nullable
        public ColorStateList fillColor;
        public float interpolation;

        @Nullable
        public Rect padding;
        public Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;

        @NonNull
        public ShapeAppearanceModel shapeAppearanceModel;

        @Nullable
        public ColorStateList strokeColor;

        @Nullable
        public ColorStateList strokeTintList;
        public float strokeWidth;

        @Nullable
        public ColorStateList tintList;

        @Nullable
        public PorterDuff.Mode tintMode;
        public float translationZ;
        public boolean useTintColorForShadow;

        public MaterialShapeDrawableState(ShapeAppearanceModel r10, ElevationOverlayProvider r11) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = PrivateKeyType.INVALID;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r10;
            this.elevationOverlayProvider = r11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable r10 = new MaterialShapeDrawable(this, null);
            MaterialShapeDrawable.access$402(r10, true);
            return r10;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState r10) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = PrivateKeyType.INVALID;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r10.shapeAppearanceModel;
            this.elevationOverlayProvider = r10.elevationOverlayProvider;
            this.strokeWidth = r10.strokeWidth;
            this.colorFilter = r10.colorFilter;
            this.fillColor = r10.fillColor;
            this.strokeColor = r10.strokeColor;
            this.tintMode = r10.tintMode;
            this.tintList = r10.tintList;
            this.alpha = r10.alpha;
            this.scale = r10.scale;
            this.shadowCompatOffset = r10.shadowCompatOffset;
            this.shadowCompatMode = r10.shadowCompatMode;
            this.useTintColorForShadow = r10.useTintColorForShadow;
            this.interpolation = r10.interpolation;
            this.parentAbsoluteElevation = r10.parentAbsoluteElevation;
            this.elevation = r10.elevation;
            this.translationZ = r10.translationZ;
            this.shadowCompatRadius = r10.shadowCompatRadius;
            this.shadowCompatRotation = r10.shadowCompatRotation;
            this.strokeTintList = r10.strokeTintList;
            this.paintStyle = r10.paintStyle;
            if (r10.padding == null) goto L6;
            this.padding = new Rect(r10.padding);
            return;
        }
    }

    static {
        clearPaint = new Paint(1);
    }

    public /* synthetic */ MaterialShapeDrawable(MaterialShapeDrawableState r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ BitSet access$000(MaterialShapeDrawable r10) {
        return r10.containsIncompatibleShadowOp;
    }

    public static /* synthetic */ ShapePath.ShadowCompatOperation[] access$100(MaterialShapeDrawable r10) {
        return r10.cornerShadowOperation;
    }

    public static /* synthetic */ ShapePath.ShadowCompatOperation[] access$200(MaterialShapeDrawable r10) {
        return r10.edgeShadowOperation;
    }

    public static /* synthetic */ boolean access$402(MaterialShapeDrawable r10, boolean r11) {
        r10.pathDirty = r11;
        return r11;
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint r10, boolean r11) {
        if (r11 == false) goto L7;
        int r12 = r10.getColor();
        int r13 = compositeElevationOverlayIfNeeded(r12);
        if (r13 != r12) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r13, PorterDuff.Mode.SRC_IN);
    L7:
        return null;
    }

    private void calculatePath(@NonNull RectF r10, @NonNull Path r11) {
        calculatePathForSize(r10, r11);
        if (this.drawableState.scale == 1.0f) goto L5;
        this.matrix.reset();
        Matrix r12 = this.matrix;
        float r13 = this.drawableState.scale;
        r12.setScale(r13, r13, r10.width() / 2.0f, r10.height() / 2.0f);
        r11.transform(this.matrix);
    L5:
        r11.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        final float r10 = -getStrokeInsetLength();
        ShapeAppearanceModel r11 = getShapeAppearanceModel().withTransformedCornerSizes(new AnonymousClass2(this, r10));
        this.strokeShapeAppearance = r11;
        this.pathProvider.calculatePath(r11, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList r10, @NonNull PorterDuff.Mode r11, boolean r12) {
        int r13 = r10.getColorForState(getState(), 0);
        if (r12 == false) goto L6;
        r13 = compositeElevationOverlayIfNeeded(r13);
    L6:
        return new PorterDuffColorFilter(r13, r11);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList r10, @Nullable PorterDuff.Mode r11, @NonNull Paint r12, boolean r13) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        return calculateTintColorTintFilter(r10, r11, r13);
    L7:
        return calculatePaintColorTintFilter(r12, r13);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r10) {
        return createWithElevationOverlay(r10, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas r10) {
        if (this.containsIncompatibleShadowOp.cardinality() <= 0) goto L6;
        Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L6:
        if (this.drawableState.shadowCompatOffset == 0) goto L8;
        r10.drawPath(this.path, this.shadowRenderer.getShadowPaint());
    L8:
        int r11 = 0;
    L10:
        if (r11 >= 4) goto L13;
        this.cornerShadowOperation[r11].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, r10);
        this.edgeShadowOperation[r11].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, r10);
        r11 = r11 + 1;
        goto L10
    L13:
        if (this.shadowBitmapDrawingEnable == false) goto L17;
        int r12 = getShadowOffsetX();
        int r13 = getShadowOffsetY();
        r10.translate(-r12, -r13);
        r10.drawPath(this.path, clearPaint);
        r10.translate(r12, r13);
        return;
    }

    private void drawFillShape(@NonNull Canvas r10) {
        drawShape(r10, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    private void drawStrokeShape(@NonNull Canvas r10) {
        drawShape(r10, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float r10 = getStrokeInsetLength();
        this.insetRectF.inset(r10, r10);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke() == true) goto L5;
        return 0.0f;
    L5:
        return this.strokePaint.getStrokeWidth() / 2.0f;
    }

    private boolean hasCompatShadow() {
        MaterialShapeDrawableState r10 = this.drawableState;
        int r11 = r10.shadowCompatMode;
        if (r11 != 1) goto L5;
    L11:
        return false;
    L5:
        if (r10.shadowCompatRadius <= 0) goto L11;
        if (r11 != 2) goto L9;
        return true;
    L9:
        if (requiresCompatShadow() == false) goto L11;
        return true;
    }

    private boolean hasFill() {
        Paint.Style r10 = this.drawableState.paintStyle;
        if (r10 != Paint.Style.FILL_AND_STROKE) goto L5;
    L8:
        return true;
    L5:
        if (r10 == Paint.Style.FILL) goto L8;
        return false;
    }

    private boolean hasStroke() {
        Paint.Style r10 = this.drawableState.paintStyle;
        if (r10 == Paint.Style.FILL_AND_STROKE) goto L7;
        if (r10 == Paint.Style.STROKE) goto L7;
    L9:
        return false;
    L7:
        if (this.strokePaint.getStrokeWidth() <= 0.0f) goto L9;
        return true;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas r10) {
        if (hasCompatShadow() == true) goto L5;
        return;
    L5:
        r10.save();
        prepareCanvasForShadow(r10);
        if (this.shadowBitmapDrawingEnable == true) goto L9;
        drawCompatShadow(r10);
        r10.restore();
        return;
    L9:
        int r11 = (int) (this.pathBounds.width() - getBounds().width());
        int r12 = (int) (this.pathBounds.height() - getBounds().height());
        if (r11 < 0) goto L15;
        if (r12 < 0) goto L15;
        Bitmap r13 = Bitmap.createBitmap((((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2)) + r11, (((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2)) + r12, Bitmap.Config.ARGB_8888);
        Canvas r14 = new Canvas(r13);
        float r15 = (getBounds().left - this.drawableState.shadowCompatRadius) - r11;
        float r16 = (getBounds().top - this.drawableState.shadowCompatRadius) - r12;
        r14.translate(-r15, -r16);
        drawCompatShadow(r14);
        r10.drawBitmap(r13, r15, r16, null);
        r13.recycle();
        r10.restore();
        return;
    L15:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int r10, int r11) {
        return (r10 * (r11 + (r11 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas r10) {
        r10.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] r10) {
        if (this.drawableState.fillColor == null) goto L7;
        int r11 = this.fillPaint.getColor();
        int r12 = this.drawableState.fillColor.getColorForState(r10, r11);
        if (r11 == r12) goto L7;
        this.fillPaint.setColor(r12);
        boolean r13 = true;
    L9:
        if (this.drawableState.strokeColor == null) goto L14;
        int r14 = this.strokePaint.getColor();
        int r15 = this.drawableState.strokeColor.getColorForState(r10, r14);
        if (r14 == r15) goto L14;
        this.strokePaint.setColor(r15);
        return true;
    L14:
        return r13;
    L7:
        r13 = false;
        goto L9
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter r10 = this.tintFilter;
        PorterDuffColorFilter r11 = this.strokeTintFilter;
        MaterialShapeDrawableState r12 = this.drawableState;
        this.tintFilter = calculateTintFilter(r12.tintList, r12.tintMode, this.fillPaint, true);
        MaterialShapeDrawableState r13 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(r13.strokeTintList, r13.tintMode, this.strokePaint, false);
        MaterialShapeDrawableState r14 = this.drawableState;
        if (r14.useTintColorForShadow == false) goto L6;
        this.shadowRenderer.setShadowColor(r14.tintList.getColorForState(getState(), 0));
    L6:
        if (b.a(r10, this.tintFilter) == true) goto L8;
        return true;
    L8:
        if (b.a(r11, this.strokeTintFilter) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private void updateZ() {
        float r10 = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil(SHADOW_RADIUS_MULTIPLIER * r10);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(r10 * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF r10, @NonNull Path r11) {
        ShapeAppearancePathProvider r12 = this.pathProvider;
        MaterialShapeDrawableState r13 = this.drawableState;
        r12.calculatePath(r13.shapeAppearanceModel, r13.interpolation, r10, this.pathShadowListener, r11);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int r10) {
        float r11 = getZ() + getParentAbsoluteElevation();
        ElevationOverlayProvider r12 = this.drawableState.elevationOverlayProvider;
        if (r12 != null) goto L5;
        return r10;
    L5:
        return r12.compositeOverlayIfNeeded(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int r11 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(r11, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int r12 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(r12, this.drawableState.alpha));
        if (this.pathDirty == false) goto L5;
        calculateStrokePath();
        calculatePath(getBoundsAsRectF(), this.path);
        this.pathDirty = false;
    L5:
        maybeDrawCompatShadow(r10);
        if (hasFill() == false) goto L9;
        drawFillShape(r10);
    L9:
        if (hasStroke() == false) goto L11;
        drawStrokeShape(r10);
    L11:
        this.fillPaint.setAlpha(r11);
        this.strokePaint.setAlpha(r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas r10, @NonNull Paint r11, @NonNull Path r12, @NonNull RectF r13) {
        drawShape(r10, r11, r12, this.drawableState.shapeAppearanceModel, r13);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r10) {
        if (this.drawableState.shadowCompatMode != 2) goto L6;
        return;
    L6:
        if (isRoundRect() == false) goto L9;
        float r11 = getTopLeftCornerResolvedSize() * this.drawableState.interpolation;
        r10.setRoundRect(getBounds(), r11);
        return;
    L9:
        calculatePath(getBoundsAsRectF(), this.path);
        this.path.isConvex();
        r10.setConvexPath(this.path);     // Catch: IllegalArgumentException -> L12
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r10) {
        Rect r11 = this.drawableState.padding;
        if (r11 == null) goto L7;
        r10.set(r11);
        return true;
    L7:
        return super.getPadding(r10);
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @Deprecated
    public void getPathForSize(int r10, int r11, @NonNull Path r12) {
        calculatePathForSize(new RectF(0.0f, 0.0f, r10, r11), r12);
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState r10 = this.drawableState;
        return (int) (((double) r10.shadowCompatOffset) * Math.sin(Math.toRadians(r10.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState r10 = this.drawableState;
        return (int) (((double) r10.shadowCompatOffset) * Math.cos(Math.toRadians(r10.shadowCompatRotation)));
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel r10 = getShapeAppearanceModel();
        if ((r10 instanceof ShapePathModel) == true) goto L7;
        return null;
    L7:
        return (ShapePathModel) r10;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r10 = getBounds();
        this.transparentRegion.set(r10);
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        r11.elevationOverlayProvider = new ElevationOverlayProvider(r10);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider r10 = this.drawableState.elevationOverlayProvider;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isThemeElevationOverlayEnabled() == false) goto L7;
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.elevationOverlayProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPointInTransparentRegion(int r10, int r11) {
        return getTransparentRegion().contains(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int r10 = this.drawableState.shadowCompatMode;
        if (r10 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 2) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == true) goto L22;
        ColorStateList r10 = this.drawableState.tintList;
        if (r10 != null) goto L7;
    L8:
        ColorStateList r11 = this.drawableState.strokeTintList;
        if (r11 != null) goto L11;
    L12:
        ColorStateList r12 = this.drawableState.strokeColor;
        if (r12 != null) goto L15;
    L16:
        ColorStateList r13 = this.drawableState.fillColor;
        if (r13 != null) goto L19;
    L21:
        return false;
    L19:
        if (r13.isStateful() == false) goto L21;
    L15:
        if (r12.isStateful() == true) goto L22;
    L11:
        if (r11.isStateful() == true) goto L22;
    L7:
        if (r10.isStateful() == false) goto L8;
    L22:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        this.pathDirty = true;
        super.onBoundsChange(r10);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r10) {
        boolean r11 = updateColorsForState(r10);
        boolean r12 = updateTintFilter();
        if (r11 == true) goto L7;
        if (r12 == true) goto L7;
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        invalidateSelf();
    L10:
        return r13;
    L7:
        r13 = true;
        goto L8
    }

    public boolean requiresCompatShadow() {
        if (isRoundRect() == true) goto L7;
        this.path.isConvex();
        return false;
    L7:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.alpha == r10) goto L6;
        r11.alpha = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.drawableState.colorFilter = r10;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float r10) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(r10));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean r10) {
        this.pathProvider.setEdgeIntersectionCheckEnable(r10);
    }

    public void setElevation(float r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.elevation == r10) goto L6;
        r11.elevation = r10;
        updateZ();
        return;
    }

    public void setFillColor(@Nullable ColorStateList r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.fillColor == r10) goto L6;
        r11.fillColor = r10;
        onStateChange(getState());
        return;
    }

    public void setInterpolation(float r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.interpolation == r10) goto L6;
        r11.interpolation = r10;
        this.pathDirty = true;
        invalidateSelf();
        return;
    }

    public void setPadding(int r10, int r11, int r12, int r13) {
        MaterialShapeDrawableState r14 = this.drawableState;
        if (r14.padding != null) goto L5;
        r14.padding = new Rect();
    L5:
        this.drawableState.padding.set(r10, r11, r12, r13);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style r10) {
        this.drawableState.paintStyle = r10;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.parentAbsoluteElevation == r10) goto L6;
        r11.parentAbsoluteElevation = r10;
        updateZ();
        return;
    }

    public void setScale(float r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.scale == r10) goto L6;
        r11.scale = r10;
        invalidateSelf();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean r10) {
        this.shadowBitmapDrawingEnable = r10;
    }

    public void setShadowColor(int r10) {
        this.shadowRenderer.setShadowColor(r10);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.shadowCompatRotation == r10) goto L6;
        r11.shadowCompatRotation = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    public void setShadowCompatibilityMode(int r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.shadowCompatMode == r10) goto L6;
        r11.shadowCompatMode = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    @Deprecated
    public void setShadowElevation(int r10) {
        setElevation(r10);
    }

    @Deprecated
    public void setShadowEnabled(boolean r10) {
        setShadowCompatibilityMode(!r10 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int r10) {
        this.drawableState.shadowCompatRadius = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.shadowCompatOffset == r10) goto L6;
        r11.shadowCompatOffset = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        this.drawableState.shapeAppearanceModel = r10;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel r10) {
        setShapeAppearanceModel(r10);
    }

    public void setStroke(float r10, @ColorInt int r11) {
        setStrokeWidth(r10);
        setStrokeColor(ColorStateList.valueOf(r11));
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.strokeColor == r10) goto L6;
        r11.strokeColor = r10;
        onStateChange(getState());
        return;
    }

    public void setStrokeTint(ColorStateList r10) {
        this.drawableState.strokeTintList = r10;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float r10) {
        this.drawableState.strokeWidth = r10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r10) {
        setTintList(ColorStateList.valueOf(r10));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r10) {
        this.drawableState.tintList = r10;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.tintMode == r10) goto L6;
        r11.tintMode = r10;
        updateTintFilter();
        invalidateSelfIgnoreShape();
        return;
    }

    public void setTranslationZ(float r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.translationZ == r10) goto L6;
        r11.translationZ = r10;
        updateZ();
        return;
    }

    public void setUseTintColorForShadow(boolean r10) {
        MaterialShapeDrawableState r11 = this.drawableState;
        if (r11.useTintColorForShadow == r10) goto L6;
        r11.useTintColorForShadow = r10;
        invalidateSelf();
        return;
    }

    public void setZ(float r10) {
        setTranslationZ(r10 - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r10, float r11) {
        int r12 = MaterialColors.getColor(r10, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable r13 = new MaterialShapeDrawable();
        r13.initializeElevationOverlay(r10);
        r13.setFillColor(ColorStateList.valueOf(r12));
        r13.setElevation(r11);
        return r13;
    }

    private void drawShape(@NonNull Canvas r10, @NonNull Paint r11, @NonNull Path r12, @NonNull ShapeAppearanceModel r13, @NonNull RectF r14) {
        if (r13.isRoundRect(r14) == false) goto L5;
        float r15 = r13.getTopRightCornerSize().getCornerSize(r14) * this.drawableState.interpolation;
        r10.drawRoundRect(r14, r15, r15, r11);
        return;
    L5:
        r10.drawPath(r12, r11);
    }

    public void setCornerSize(@NonNull CornerSize r10) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(r10));
    }

    public MaterialShapeDrawable(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        this(ShapeAppearanceModel.builder(r10, r11, r12, r13).build());
    }

    public void setStroke(float r10, @Nullable ColorStateList r11) {
        setStrokeWidth(r10);
        setStrokeColor(r11);
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel r10) {
        this(r10);
    }

    public void setStrokeTint(@ColorInt int r10) {
        setStrokeTint(ColorStateList.valueOf(r10));
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel r10) {
        this(new MaterialShapeDrawableState(r10, null));
    }

    private MaterialShapeDrawable(@NonNull MaterialShapeDrawableState r10) {
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint r11 = new Paint(1);
        this.fillPaint = r11;
        Paint r12 = new Paint(1);
        this.strokePaint = r12;
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        ShapeAppearancePathProvider r13 = ShapeAppearancePathProvider.getInstance();
    L6:
        this.pathProvider = r13;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = r10;
        r12.setStyle(Paint.Style.STROKE);
        r11.setStyle(Paint.Style.FILL);
        Paint r14 = clearPaint;
        r14.setColor(-1);
        r14.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new AnonymousClass1(this);
        return;
    L5:
        r13 = new ShapeAppearancePathProvider();
        goto L6
    }
}
