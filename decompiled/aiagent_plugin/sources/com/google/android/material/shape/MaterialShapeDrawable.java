package com.google.android.material.shape;

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
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialShapeDrawable extends Drawable implements androidx.core.graphics.drawable.c, q {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint = null;
    private final BitSet containsIncompatibleShadowOp;
    private final o.f[] cornerShadowOperation;
    private MaterialShapeDrawableState drawableState;
    private final o.f[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final n pathProvider;
    private final n.b pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final com.google.android.material.h.a shadowRenderer;
    private final Paint strokePaint;
    private m strokeShapeAppearance;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha;
        public ColorFilter colorFilter;
        public float elevation;
        public com.google.android.material.c.a elevationOverlayProvider;
        public ColorStateList fillColor;
        public float interpolation;
        public Rect padding;
        public Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;
        public m shapeAppearanceModel;
        public ColorStateList strokeColor;
        public ColorStateList strokeTintList;
        public float strokeWidth;
        public ColorStateList tintList;
        public PorterDuff.Mode tintMode;
        public float translationZ;
        public boolean useTintColorForShadow;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public MaterialShapeDrawableState(m r3, com.google.android.material.c.a r4) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r3;
            this.elevationOverlayProvider = r4;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState r3) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r3.shapeAppearanceModel;
            this.elevationOverlayProvider = r3.elevationOverlayProvider;
            this.strokeWidth = r3.strokeWidth;
            this.colorFilter = r3.colorFilter;
            this.fillColor = r3.fillColor;
            this.strokeColor = r3.strokeColor;
            this.tintMode = r3.tintMode;
            this.tintList = r3.tintList;
            this.alpha = r3.alpha;
            this.scale = r3.scale;
            this.shadowCompatOffset = r3.shadowCompatOffset;
            this.shadowCompatMode = r3.shadowCompatMode;
            this.useTintColorForShadow = r3.useTintColorForShadow;
            this.interpolation = r3.interpolation;
            this.parentAbsoluteElevation = r3.parentAbsoluteElevation;
            this.elevation = r3.elevation;
            this.translationZ = r3.translationZ;
            this.shadowCompatRadius = r3.shadowCompatRadius;
            this.shadowCompatRotation = r3.shadowCompatRotation;
            this.strokeTintList = r3.strokeTintList;
            this.paintStyle = r3.paintStyle;
            if (r3.padding == null) goto L6;
            this.padding = new Rect(r3.padding);
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialShapeDrawable r0 = new MaterialShapeDrawable(this, null);
            MaterialShapeDrawable.access$402(r0, true);
            return r0;
        }
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    private static int modulateAlpha(int r1, int r2) {
        return (r1 * (r2 + (r2 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* synthetic */ MaterialShapeDrawable(MaterialShapeDrawableState r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ BitSet access$000(MaterialShapeDrawable r0) {
        return r0.containsIncompatibleShadowOp;
    }

    static /* synthetic */ o.f[] access$100(MaterialShapeDrawable r0) {
        return r0.cornerShadowOperation;
    }

    static /* synthetic */ o.f[] access$200(MaterialShapeDrawable r0) {
        return r0.edgeShadowOperation;
    }

    static /* synthetic */ boolean access$402(MaterialShapeDrawable r0, boolean r1) {
        r0.pathDirty = r1;
        return r1;
    }

    static {
        Paint r0 = new Paint(1);
        clearPaint = r0;
        r0.setColor(-1);
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context r2) {
        return createWithElevationOverlay((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), 0.0f);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        int r0 = com.google.android.material.color.b.a(r5, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r1.initializeElevationOverlay(r5);
        r1.setFillColor(ColorStateList.valueOf(r0));
        r1.setElevation(r4);
        return r1;
    }

    public MaterialShapeDrawable() {
        this(new m());
    }

    public MaterialShapeDrawable(Context r3, AttributeSet r4, int r5, int r6) {
        this(m.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, r6).a());
    }

    @Deprecated
    public MaterialShapeDrawable(p r1) {
        this(r1);
    }

    public MaterialShapeDrawable(m r3) {
        this(new MaterialShapeDrawableState(r3, null));
    }

    private MaterialShapeDrawable(MaterialShapeDrawableState r6) {
        this.cornerShadowOperation = new o.f[4];
        this.edgeShadowOperation = new o.f[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint r0 = new Paint(1);
        this.fillPaint = r0;
        Paint r2 = new Paint(1);
        this.strokePaint = r2;
        this.shadowRenderer = new com.google.android.material.h.a();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        n r3 = n.a();
    L6:
        this.pathProvider = r3;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = r6;
        r2.setStyle(Paint.Style.STROKE);
        r0.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new AnonymousClass1(this);
        return;
    L5:
        r3 = new n();
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // com.google.android.material.shape.q
    public void setShapeAppearanceModel(m r2) {
        this.drawableState.shapeAppearanceModel = r2;
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.q
    public m getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Deprecated
    public void setShapedViewModel(p r1) {
        setShapeAppearanceModel(r1);
    }

    @Deprecated
    public p getShapedViewModel() {
        m r2 = getShapeAppearanceModel();
        if (ZeusTransformUtils.instanceOf(r2, p.class) == true) goto L7;
        return null;
    L7:
        return (p) ZeusTransformUtils.preCheckCast(r2, p.class, "com.obric.aiagent.plugin");
    }

    public void setFillColor(ColorStateList r2) {
        if (this.drawableState.fillColor == r2) goto L6;
        this.drawableState.fillColor = r2;
        onStateChange(getState());
        return;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public void setStrokeColor(ColorStateList r2) {
        if (this.drawableState.strokeColor == r2) goto L6;
        this.drawableState.strokeColor = r2;
        onStateChange(getState());
        return;
    }

    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.c
    public void setTintMode(PorterDuff.Mode r2) {
        if (this.drawableState.tintMode == r2) goto L6;
        this.drawableState.tintMode = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.c
    public void setTintList(ColorStateList r2) {
        this.drawableState.tintList = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.c
    public void setTint(int r1) {
        setTintList(ColorStateList.valueOf(r1));
    }

    public void setStrokeTint(ColorStateList r2) {
        this.drawableState.strokeTintList = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeTint(int r1) {
        setStrokeTint(ColorStateList.valueOf(r1));
    }

    public void setStroke(float r1, int r2) {
        setStrokeWidth(r1);
        setStrokeColor(ColorStateList.valueOf(r2));
    }

    public void setStroke(float r1, ColorStateList r2) {
        setStrokeWidth(r1);
        setStrokeColor(r2);
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    public void setStrokeWidth(float r2) {
        this.drawableState.strokeWidth = r2;
        invalidateSelf();
    }

    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.drawableState.alpha == r2) goto L6;
        this.drawableState.alpha = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.drawableState.colorFilter = r2;
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r0 = getBounds();
        this.transparentRegion.set(r0);
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    public void setCornerSize(float r2) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.a(r2));
    }

    public void setCornerSize(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.a(r4));
    }

    public boolean isPointInTransparentRegion(int r1, int r2) {
        return getTransparentRegion().contains(r1, r2);
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r2) {
        if (this.drawableState.padding == null) goto L7;
        r2.set(this.drawableState.padding);
        return true;
    L7:
        return super.getPadding(r2);
    }

    public void setPadding(int r3, int r4, int r5, int r6) {
        if (this.drawableState.padding != null) goto L5;
        MaterialShapeDrawableState r0 = this.drawableState;
        r0.padding = new Rect();
    L5:
        this.drawableState.padding.set(r3, r4, r5, r6);
        invalidateSelf();
    }

    public void setShadowCompatibilityMode(int r2) {
        if (this.drawableState.shadowCompatMode == r2) goto L6;
        this.drawableState.shadowCompatMode = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    @Deprecated
    public boolean isShadowEnabled() {
        if (this.drawableState.shadowCompatMode != 0) goto L5;
    L8:
        return true;
    L5:
        if (this.drawableState.shadowCompatMode == 2) goto L8;
        return false;
    }

    @Deprecated
    public void setShadowEnabled(boolean r1) {
        setShadowCompatibilityMode(!r1 ? 1 : 0);
    }

    public boolean isElevationOverlayEnabled() {
        if (this.drawableState.elevationOverlayProvider != null) goto L5;
    L7:
        return false;
    L5:
        if (this.drawableState.elevationOverlayProvider.a() == false) goto L7;
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.elevationOverlayProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void initializeElevationOverlay(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        MaterialShapeDrawableState r0 = this.drawableState;
        r0.elevationOverlayProvider = new com.google.android.material.c.a(r4);
        updateZ();
    }

    public int compositeElevationOverlayIfNeeded(int r3) {
        float r0 = getZ() + getParentAbsoluteElevation();
        if (this.drawableState.elevationOverlayProvider != null) goto L5;
        return r3;
    L5:
        return this.drawableState.elevationOverlayProvider.a(r3, r0);
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    public void setInterpolation(float r2) {
        if (this.drawableState.interpolation == r2) goto L6;
        this.drawableState.interpolation = r2;
        this.pathDirty = true;
        invalidateSelf();
        return;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    public void setParentAbsoluteElevation(float r2) {
        if (this.drawableState.parentAbsoluteElevation == r2) goto L6;
        this.drawableState.parentAbsoluteElevation = r2;
        updateZ();
        return;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    public void setElevation(float r2) {
        if (this.drawableState.elevation == r2) goto L6;
        this.drawableState.elevation = r2;
        updateZ();
        return;
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    public void setTranslationZ(float r2) {
        if (this.drawableState.translationZ == r2) goto L6;
        this.drawableState.translationZ = r2;
        updateZ();
        return;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void setZ(float r2) {
        setTranslationZ(r2 - getElevation());
    }

    private void updateZ() {
        float r0 = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil(SHADOW_RADIUS_MULTIPLIER * r0);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(r0 * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    @Deprecated
    public void setShadowElevation(int r1) {
        setElevation(r1);
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    public void setShadowBitmapDrawingEnable(boolean r1) {
        this.shadowBitmapDrawingEnable = r1;
    }

    public void setEdgeIntersectionCheckEnable(boolean r1) {
        this.pathProvider.a(r1);
    }

    public void setShadowVerticalOffset(int r2) {
        if (this.drawableState.shadowCompatOffset == r2) goto L6;
        this.drawableState.shadowCompatOffset = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public void setShadowCompatRotation(int r2) {
        if (this.drawableState.shadowCompatRotation == r2) goto L6;
        this.drawableState.shadowCompatRotation = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @Deprecated
    public void setShadowRadius(int r1) {
        this.drawableState.shadowCompatRadius = r1;
    }

    public boolean requiresCompatShadow() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L12:
        return true;
    L5:
        if (isRoundRect() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.path.isConvex() == true) goto L11;
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        goto L11
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public void setScale(float r2) {
        if (this.drawableState.scale == r2) goto L6;
        this.drawableState.scale = r2;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    public void setUseTintColorForShadow(boolean r2) {
        if (this.drawableState.useTintColorForShadow == r2) goto L6;
        this.drawableState.useTintColorForShadow = r2;
        invalidateSelf();
        return;
    }

    public void setShadowColor(int r2) {
        this.shadowRenderer.a(r2);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public void setPaintStyle(Paint.Style r2) {
        this.drawableState.paintStyle = r2;
        invalidateSelfIgnoreShape();
    }

    private boolean hasCompatShadow() {
        if (this.drawableState.shadowCompatMode != 1) goto L5;
    L11:
        return false;
    L5:
        if (this.drawableState.shadowCompatRadius <= 0) goto L11;
        if (this.drawableState.shadowCompatMode != 2) goto L9;
        return true;
    L9:
        if (requiresCompatShadow() == false) goto L11;
        return true;
    }

    private boolean hasFill() {
        if (this.drawableState.paintStyle != Paint.Style.FILL_AND_STROKE) goto L5;
    L8:
        return true;
    L5:
        if (this.drawableState.paintStyle == Paint.Style.FILL) goto L8;
        return false;
    }

    private boolean hasStroke() {
        if (this.drawableState.paintStyle == Paint.Style.FILL_AND_STROKE) goto L7;
        if (this.drawableState.paintStyle == Paint.Style.STROKE) goto L7;
    L9:
        return false;
    L7:
        if (this.strokePaint.getStrokeWidth() <= 0.0f) goto L9;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        this.pathDirty = true;
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int r0 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(r0, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int r1 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(r1, this.drawableState.alpha));
        if (this.pathDirty == false) goto L5;
        calculateStrokePath();
        calculatePath(getBoundsAsRectF(), this.path);
        this.pathDirty = false;
    L5:
        maybeDrawCompatShadow(r5);
        if (hasFill() == false) goto L9;
        drawFillShape(r5);
    L9:
        if (hasStroke() == false) goto L11;
        drawStrokeShape(r5);
    L11:
        this.fillPaint.setAlpha(r0);
        this.strokePaint.setAlpha(r1);
    }

    private void maybeDrawCompatShadow(Canvas r7) {
        if (hasCompatShadow() == true) goto L5;
        return;
    L5:
        r7.save();
        prepareCanvasForShadow(r7);
        if (this.shadowBitmapDrawingEnable == true) goto L9;
        drawCompatShadow(r7);
        r7.restore();
        return;
    L9:
        int r0 = (int) (this.pathBounds.width() - getBounds().width());
        int r1 = (int) (this.pathBounds.height() - getBounds().height());
        if (r0 < 0) goto L15;
        if (r1 < 0) goto L15;
        Bitmap r2 = Bitmap.createBitmap((((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2)) + r0, (((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2)) + r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        float r4 = (getBounds().left - this.drawableState.shadowCompatRadius) - r0;
        float r5 = (getBounds().top - this.drawableState.shadowCompatRadius) - r1;
        r3.translate(-r4, -r5);
        drawCompatShadow(r3);
        r7.drawBitmap(r2, r4, r5, null);
        r2.recycle();
        r7.restore();
        return;
    L15:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    public void drawShape(Canvas r8, Paint r9, Path r10, RectF r11) {
        drawShape(r8, r9, r10, this.drawableState.shapeAppearanceModel, r11);
    }

    private void drawShape(Canvas r2, Paint r3, Path r4, m r5, RectF r6) {
        if (r5.a(r6) == false) goto L5;
        float r7 = r5.g().a(r6) * this.drawableState.interpolation;
        r2.drawRoundRect(r6, r7, r7, r3);
        return;
    L5:
        r2.drawPath(r4, r3);
    }

    private void drawFillShape(Canvas r7) {
        drawShape(r7, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    public void drawStrokeShape(Canvas r7) {
        drawShape(r7, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    private void prepareCanvasForShadow(Canvas r5) {
        int r0 = getShadowOffsetX();
        int r1 = getShadowOffsetY();
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L7:
        r5.translate(r0, r1);
        return;
    L5:
        if (this.shadowBitmapDrawingEnable == false) goto L7;
        Rect r2 = r5.getClipBounds();
        r2.inset(-this.drawableState.shadowCompatRadius, -this.drawableState.shadowCompatRadius);
        r2.offset(r0, r1);
        r5.clipRect(r2, Region.Op.REPLACE);
        goto L7
    }

    private void drawCompatShadow(Canvas r5) {
        if (this.containsIncompatibleShadowOp.cardinality() <= 0) goto L6;
        INVOKESTATIC_com_google_android_material_shape_MaterialShapeDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L6:
        if (this.drawableState.shadowCompatOffset == 0) goto L8;
        r5.drawPath(this.path, this.shadowRenderer.a());
    L8:
        int r0 = 0;
    L10:
        if (r0 >= 4) goto L13;
        this.cornerShadowOperation[r0].a(this.shadowRenderer, this.drawableState.shadowCompatRadius, r5);
        this.edgeShadowOperation[r0].a(this.shadowRenderer, this.drawableState.shadowCompatRadius, r5);
        r0 = r0 + 1;
        goto L10
    L13:
        if (this.shadowBitmapDrawingEnable == false) goto L17;
        int r1 = getShadowOffsetX();
        int r2 = getShadowOffsetY();
        r5.translate(-r1, -r2);
        r5.drawPath(this.path, clearPaint);
        r5.translate(r1, r2);
        return;
    }

    public int getShadowOffsetX() {
        return (int) (((double) this.drawableState.shadowCompatOffset) * Math.sin(Math.toRadians(this.drawableState.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        return (int) (((double) this.drawableState.shadowCompatOffset) * Math.cos(Math.toRadians(this.drawableState.shadowCompatRotation)));
    }

    @Deprecated
    public void getPathForSize(int r3, int r4, Path r5) {
        calculatePathForSize(new RectF(0.0f, 0.0f, r3, r4), r5);
    }

    public final void calculatePathForSize(RectF r7, Path r8) {
        this.pathProvider.a(this.drawableState.shapeAppearanceModel, this.drawableState.interpolation, r7, this.pathShadowListener, r8);
    }

    private void calculateStrokePath() {
        final float r0 = -getStrokeInsetLength();
        m r1 = getShapeAppearanceModel().a(new AnonymousClass2(this, r0));
        this.strokeShapeAppearance = r1;
        this.pathProvider.a(r1, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r3) {
        if (this.drawableState.shadowCompatMode != 2) goto L6;
        return;
    L6:
        if (isRoundRect() == false) goto L9;
        float r0 = getTopLeftCornerResolvedSize() * this.drawableState.interpolation;
        r3.setRoundRect(getBounds(), r0);
        return;
    L9:
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() == false) goto L12;
    L16:
        r3.setConvexPath(this.path);     // Catch: IllegalArgumentException -> L15
        return;
    L19:
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L16;
    }

    private void calculatePath(RectF r6, Path r7) {
        calculatePathForSize(r6, r7);
        if (this.drawableState.scale == 1.0f) goto L5;
        this.matrix.reset();
        this.matrix.setScale(this.drawableState.scale, this.drawableState.scale, r6.width() / 2.0f, r6.height() / 2.0f);
        r7.transform(this.matrix);
    L5:
        r7.computeBounds(this.pathBounds, true);
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter r0 = this.tintFilter;
        PorterDuffColorFilter r1 = this.strokeTintFilter;
        this.tintFilter = calculateTintFilter(this.drawableState.tintList, this.drawableState.tintMode, this.fillPaint, true);
        this.strokeTintFilter = calculateTintFilter(this.drawableState.strokeTintList, this.drawableState.tintMode, this.strokePaint, false);
        if (this.drawableState.useTintColorForShadow == false) goto L6;
        this.shadowRenderer.a(this.drawableState.tintList.getColorForState(getState(), 0));
    L6:
        if (androidx.core.util.d.a(r0, this.tintFilter) == true) goto L8;
        return true;
    L8:
        if (androidx.core.util.d.a(r1, this.strokeTintFilter) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList r1, PorterDuff.Mode r2, Paint r3, boolean r4) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return calculateTintColorTintFilter(r1, r2, r4);
    L7:
        return calculatePaintColorTintFilter(r3, r4);
    }

    private PorterDuffColorFilter calculatePaintColorTintFilter(Paint r1, boolean r2) {
        if (r2 == false) goto L7;
        int r3 = r1.getColor();
        int r4 = compositeElevationOverlayIfNeeded(r3);
        this.resolvedTintColor = r4;
        if (r4 != r3) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN);
    L7:
        return null;
    }

    private PorterDuffColorFilter calculateTintColorTintFilter(ColorStateList r3, PorterDuff.Mode r4, boolean r5) {
        int r6 = r3.getColorForState(getState(), 0);
        if (r5 == false) goto L5;
        r6 = compositeElevationOverlayIfNeeded(r6);
    L5:
        this.resolvedTintColor = r6;
        return new PorterDuffColorFilter(r6, r4);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == false) goto L5;
    L22:
        return true;
    L5:
        if (this.drawableState.tintList == null) goto L9;
        if (this.drawableState.tintList.isStateful() == true) goto L22;
    L9:
        if (this.drawableState.strokeTintList == null) goto L13;
        if (this.drawableState.strokeTintList.isStateful() == true) goto L22;
    L13:
        if (this.drawableState.strokeColor == null) goto L17;
        if (this.drawableState.strokeColor.isStateful() == true) goto L22;
    L17:
        if (this.drawableState.fillColor != null) goto L19;
    L21:
        return false;
    L19:
        if (this.drawableState.fillColor.isStateful() == false) goto L21;
        goto L21
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.j.a
    public boolean onStateChange(int[] r2) {
        boolean r3 = updateColorsForState(r2);
        boolean r0 = updateTintFilter();
        if (r3 == true) goto L7;
        if (r0 == true) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
        invalidateSelf();
    L10:
        return r4;
    L7:
        r4 = true;
        goto L8
    }

    private boolean updateColorsForState(int[] r5) {
        if (this.drawableState.fillColor == null) goto L7;
        int r0 = this.fillPaint.getColor();
        int r2 = this.drawableState.fillColor.getColorForState(r5, r0);
        if (r0 == r2) goto L7;
        this.fillPaint.setColor(r2);
        boolean r1 = true;
    L9:
        if (this.drawableState.strokeColor == null) goto L14;
        int r3 = this.strokePaint.getColor();
        int r6 = this.drawableState.strokeColor.getColorForState(r5, r3);
        if (r3 == r6) goto L14;
        this.strokePaint.setColor(r6);
        return true;
    L14:
        return r1;
    L7:
        r1 = false;
        goto L9
    }

    private float getStrokeInsetLength() {
        if (hasStroke() == true) goto L5;
        return 0.0f;
    L5:
        return this.strokePaint.getStrokeWidth() / 2.0f;
    }

    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float r0 = getStrokeInsetLength();
        this.insetRectF.inset(r0, r0);
        return this.insetRectF;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.f().a(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.g().a(getBoundsAsRectF());
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.i().a(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.h().a(getBoundsAsRectF());
    }

    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.a(getBoundsAsRectF());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_shape_MaterialShapeDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
