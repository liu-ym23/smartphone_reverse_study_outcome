package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class OCircleImageView extends AppCompatImageView {
    private static final Bitmap.Config BITMAP_CONFIG = null;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_CIRCLE_BACKGROUND_COLOR = 0;
    private static final int DEFAULT_IMAGE_ALPHA = 255;
    private static final ImageView.ScaleType SCALE_TYPE = null;
    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;
    private final Paint mBitmapPaint;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private int mCircleBackgroundColor;
    private final Paint mCircleBackgroundPaint;
    private ColorFilter mColorFilter;
    private int mContentPadding;
    private boolean mDisableCircularTransformation;
    private boolean mDrawableDirty;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private int mImageAlpha;
    private boolean mInitialized;
    private boolean mRebuildShader;
    private final Matrix mShaderMatrix;

    /* JADX INFO: renamed from: com.obric.oui.avatar.OCircleImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class OutlineProvider extends ViewOutlineProvider {
        final /* synthetic */ OCircleImageView this$0;

        private OutlineProvider(OCircleImageView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OutlineProvider(OCircleImageView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r2, Outline r3) {
            if (OCircleImageView.access$100(this.this$0) == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r2, r3);
            return;
        L5:
            Rect r4 = new Rect();
            OCircleImageView.access$200(this.this$0).roundOut(r4);
            r3.setRoundRect(r4, r4.width() / 2.0f);
        }
    }

    static /* synthetic */ boolean access$100(OCircleImageView r0) {
        return r0.mDisableCircularTransformation;
    }

    static /* synthetic */ RectF access$200(OCircleImageView r0) {
        return r0.mBorderRect;
    }

    static {
        SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
        BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = DEFAULT_BORDER_COLOR;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        this.mImageAlpha = DEFAULT_IMAGE_ALPHA;
        init();
    }

    public OCircleImageView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public OCircleImageView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r6);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = DEFAULT_BORDER_COLOR;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        this.mImageAlpha = DEFAULT_IMAGE_ALPHA;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.OCircleImageView, r6, 0);
        this.mBorderWidth = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCircleImageView_o_civ_border_width, "styleable", "OCircleImageView_o_civ_border_width"), 0);
        this.mBorderColor = r9.getColor(ZeusTransformUtils.mapRes(R.styleable.OCircleImageView_o_civ_border_color, "styleable", "OCircleImageView_o_civ_border_color"), DEFAULT_BORDER_COLOR);
        this.mBorderOverlay = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCircleImageView_o_civ_border_overlay, "styleable", "OCircleImageView_o_civ_border_overlay"), false);
        this.mCircleBackgroundColor = r9.getColor(ZeusTransformUtils.mapRes(R.styleable.OCircleImageView_o_civ_circle_background_color, "styleable", "OCircleImageView_o_civ_circle_background_color"), 0);
        r9.recycle();
        init();
    }

    private void init() {
        this.mInitialized = true;
        super.setScaleType(SCALE_TYPE);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setDither(true);
        this.mBitmapPaint.setFilterBitmap(true);
        this.mBitmapPaint.setAlpha(this.mImageAlpha);
        this.mBitmapPaint.setColorFilter(this.mColorFilter);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mCircleBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mCircleBackgroundPaint.setAntiAlias(true);
        this.mCircleBackgroundPaint.setColor(this.mCircleBackgroundColor);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new OutlineProvider(this, null));
        return;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r3) {
        if (r3 != SCALE_TYPE) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r3}));
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r5) {
        if (this.mDisableCircularTransformation == false) goto L7;
        super.onDraw(r5);
        return;
    L7:
        if (this.mCircleBackgroundColor == 0) goto L10;
        r5.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mCircleBackgroundPaint);
    L10:
        if (this.mBitmap == null) goto L21;
        if (this.mDrawableDirty == false) goto L17;
        if (this.mBitmapCanvas == null) goto L17;
        this.mDrawableDirty = false;
        Drawable r0 = getDrawable();
        r0.setBounds(0, 0, this.mBitmapCanvas.getWidth(), this.mBitmapCanvas.getHeight());
        r0.draw(this.mBitmapCanvas);
    L17:
        if (this.mRebuildShader == false) goto L19;
        this.mRebuildShader = false;
        BitmapShader r1 = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        r1.setLocalMatrix(this.mShaderMatrix);
        this.mBitmapPaint.setShader(r1);
    L19:
        r5.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
    L21:
        if (this.mBorderWidth <= 0) goto L24;
        r5.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
        return;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        this.mDrawableDirty = true;
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateDimensions();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        updateDimensions();
        invalidate();
    }

    public void setContentPadding(int r1) {
        this.mContentPadding = r1;
        updateDimensions();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
        updateDimensions();
        invalidate();
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int r2) {
        if (r2 != this.mBorderColor) goto L5;
        return;
    L5:
        this.mBorderColor = r2;
        this.mBorderPaint.setColor(r2);
        invalidate();
    }

    public int getCircleBackgroundColor() {
        return this.mCircleBackgroundColor;
    }

    public void setCircleBackgroundColor(int r2) {
        if (r2 != this.mCircleBackgroundColor) goto L5;
        return;
    L5:
        this.mCircleBackgroundColor = r2;
        this.mCircleBackgroundPaint.setColor(r2);
        invalidate();
    }

    public void setBorderGradientColor(int r10, int r11) {
        float r1 = this.mBorderRect.left;
        float r0 = this.mBorderRect.top;
        float r2 = (this.mBorderRect.height() / 2.0f) + r0;
        float r4 = this.mBorderRect.right;
        float r3 = this.mBorderRect.top;
        LinearGradient r8 = new LinearGradient(r1, r2, r4, (this.mBorderRect.height() / 2.0f) + r3, r10, r11, Shader.TileMode.MIRROR);
        this.mBorderPaint.setShader(r8);
        invalidate();
    }

    public void resetPaint() {
        this.mBorderPaint.reset();
        this.mBitmapPaint.reset();
        this.mCircleBackgroundPaint.reset();
        init();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(int r4) {
        setCircleBackgroundColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getColor(r4));
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int r2) {
        if (r2 != this.mBorderWidth) goto L5;
        return;
    L5:
        this.mBorderWidth = r2;
        this.mBorderPaint.setStrokeWidth(r2);
        updateDimensions();
        invalidate();
    }

    public boolean isBorderOverlay() {
        return this.mBorderOverlay;
    }

    public void setBorderOverlay(boolean r2) {
        if (r2 != this.mBorderOverlay) goto L5;
        return;
    L5:
        this.mBorderOverlay = r2;
        updateDimensions();
        invalidate();
    }

    public boolean isDisableCircularTransformation() {
        return this.mDisableCircularTransformation;
    }

    public void setDisableCircularTransformation(boolean r2) {
        if (r2 != this.mDisableCircularTransformation) goto L5;
        return;
    L5:
        this.mDisableCircularTransformation = r2;
        if (r2 == false) goto L8;
        this.mBitmap = null;
        this.mBitmapCanvas = null;
        this.mBitmapPaint.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        initializeBitmap();
        goto L9
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        initializeBitmap();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        initializeBitmap();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r1) {
        super.setImageResource(r1);
        initializeBitmap();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        initializeBitmap();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r2) {
        int r3 = r2 & DEFAULT_IMAGE_ALPHA;
        if (r3 != this.mImageAlpha) goto L5;
        return;
    L5:
        this.mImageAlpha = r3;
        if (this.mInitialized == false) goto L9;
        this.mBitmapPaint.setAlpha(r3);
        invalidate();
        return;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.mImageAlpha;
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r2) {
        if (r2 != this.mColorFilter) goto L5;
        return;
    L5:
        this.mColorFilter = r2;
        if (this.mInitialized == false) goto L9;
        this.mBitmapPaint.setColorFilter(r2);
        invalidate();
        return;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    private Bitmap getBitmapFromDrawable(Drawable r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, BitmapDrawable.class) == true) goto L8;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, ColorDrawable.class) == false) goto L12;
        Bitmap r0 = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);     // Catch: Exception -> L15
    L13:
        Canvas r1 = new Canvas(r0);     // Catch: Exception -> L15
        r6.setBounds(0, 0, r1.getWidth(), r1.getHeight());     // Catch: Exception -> L15
        r6.draw(r1);     // Catch: Exception -> L15
        return r0;
    L12:
        r0 = Bitmap.createBitmap(r6.getIntrinsicWidth(), r6.getIntrinsicHeight(), BITMAP_CONFIG);     // Catch: Exception -> L15
        goto L13
    L8:
        return ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r6, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap();
    }

    private void initializeBitmap() {
        Bitmap r0 = getBitmapFromDrawable(getDrawable());
        this.mBitmap = r0;
        if (r0 != null) goto L5;
    L7:
        this.mBitmapCanvas = null;
    L9:
        if (this.mInitialized == true) goto L12;
        return;
    L12:
        if (this.mBitmap == null) goto L14;
        updateShaderMatrix();
        return;
    L14:
        this.mBitmapPaint.setShader(null);
        return;
    L5:
        if (r0.isMutable() == false) goto L7;
        this.mBitmapCanvas = new Canvas(this.mBitmap);
        goto L9
    }

    private void updateDimensions() {
        this.mBorderRect.set(calculateBounds());
        this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        this.mDrawableRect.set(calculateContentBounds());
        if (this.mBorderOverlay == true) goto L7;
        int r0 = this.mBorderWidth;
        if (r0 <= 0) goto L7;
        this.mDrawableRect.inset(r0 - 1.0f, r0 - 1.0f);
    L7:
        this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        updateShaderMatrix();
    }

    private RectF calculateBounds() {
        int r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r1 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r2 = Math.min(r0, r1);
        float r3 = getPaddingLeft() + ((r0 - r2) / 2.0f);
        float r5 = getPaddingTop() + ((r1 - r2) / 2.0f);
        float r4 = r2;
        return new RectF(r3, r5, r3 + r4, r4 + r5);
    }

    private RectF calculateContentBounds() {
        int r0 = getWidth() - (this.mContentPadding * 2);
        int r1 = getHeight() - (this.mContentPadding * 2);
        int r2 = Math.min(r1, r0);
        int r5 = this.mContentPadding;
        float r3 = r5 + ((r0 - r2) / 2.0f);
        float r6 = r5 + ((r1 - r2) / 2.0f);
        float r4 = r2;
        return new RectF(r3, r6, r3 + r4, r4 + r6);
    }

    private void updateShaderMatrix() {
        if (this.mBitmap != null) goto L5;
        return;
    L5:
        this.mShaderMatrix.set(null);
        int r0 = this.mBitmap.getHeight();
        float r1 = this.mBitmap.getWidth();
        float r2 = r0;
        float r3 = 0.0f;
        if ((this.mDrawableRect.height() * r1) <= (this.mDrawableRect.width() * r2)) goto L8;
        float r4 = this.mDrawableRect.height() / r2;
        float r5 = (this.mDrawableRect.width() - (r1 * r4)) * 0.5f;
        float r6 = 0.0f;
        r3 = r5;
    L9:
        this.mShaderMatrix.setScale(r4, r4);
        this.mShaderMatrix.postTranslate(((int) (r3 + 0.5f)) + this.mDrawableRect.left, ((int) (r6 + 0.5f)) + this.mDrawableRect.top);
        this.mRebuildShader = true;
        return;
    L8:
        r4 = this.mDrawableRect.width() / r1;
        r6 = (this.mDrawableRect.height() - (r2 * r4)) * 0.5f;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (this.mDisableCircularTransformation == false) goto L7;
        return super.onTouchEvent(r3);
    L7:
        if (inTouchableArea(r3.getX(), r3.getY()) == true) goto L9;
    L11:
        return false;
    L9:
        if (super.onTouchEvent(r3) == false) goto L11;
        return true;
    }

    private boolean inTouchableArea(float r7, float r8) {
        if (this.mBorderRect.isEmpty() == false) goto L6;
        return true;
    L6:
        if ((Math.pow(r7 - this.mBorderRect.centerX(), 2.0d) + Math.pow(r8 - this.mBorderRect.centerY(), 2.0d)) <= Math.pow(this.mBorderRadius, 2.0d)) goto L10;
        return false;
    L10:
        return true;
    }
}
