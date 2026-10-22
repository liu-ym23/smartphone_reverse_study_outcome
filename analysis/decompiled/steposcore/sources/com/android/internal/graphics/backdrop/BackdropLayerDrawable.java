package com.android.internal.graphics.backdrop;

import android.graphics.BackdropMaterialParams;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.graphics.TextureLayer;
import android.graphics.drawable.Drawable;
import android.hardware.display.StepOSDisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewRootImpl;
import com.android.internal.graphics.backdrop.BackdropLayer;
import com.stepos.feature.StepOSFeature;

/* loaded from: classes.dex */
public class BackdropLayerDrawable extends Drawable {
    private static final int OFF_FILL_COLOR = 0;
    private int mBlurRadius;
    private float mCornerRadiusBL;
    private float mCornerRadiusBR;
    private float mCornerRadiusTL;
    private float mCornerRadiusTR;
    private float mCornerSmoothness;
    private final Handler mHandler;
    private BackdropMaterialParams mMaterialParams;
    private Paint mOffPaint;
    private final Paint mPaint;
    private final RenderNode mRenderNode;
    private TextureLayer mTextureLayer;
    private final ViewRootImpl mViewRootImpl;
    private static final String TAG = "BackdropLayerDrawable";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final PathProvider sSimpleRoundRectProvider = new PathProvider() { // from class: com.android.internal.graphics.backdrop.BackdropLayerDrawable.3
        private final float[] mTmpRadii = new float[8];
        private final Path mDrawPath = new Path();

        @Override // com.android.internal.graphics.backdrop.BackdropLayerDrawable.PathProvider
        public Path providePath(Rect bounds, float radiusTL, float radiusTR, float radiusBL, float radiusBR) {
            float[] fArr = this.mTmpRadii;
            this.mTmpRadii[1] = radiusTL;
            fArr[0] = radiusTL;
            float[] fArr2 = this.mTmpRadii;
            this.mTmpRadii[3] = radiusTR;
            fArr2[2] = radiusTR;
            float[] fArr3 = this.mTmpRadii;
            this.mTmpRadii[5] = radiusBL;
            fArr3[4] = radiusBL;
            float[] fArr4 = this.mTmpRadii;
            this.mTmpRadii[7] = radiusBR;
            fArr4[6] = radiusBR;
            this.mDrawPath.reset();
            this.mDrawPath.addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mTmpRadii, Path.Direction.CW);
            return this.mDrawPath;
        }
    };
    private final Rect mRect = new Rect();
    private boolean mRectVisible = true;
    private final int[] mTmpLocation = new int[2];
    private boolean mCapturingBackdrop = false;
    private boolean mVisible = true;
    private int mAlpha = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
    private final Path mDrawPath = new Path();
    private BackdropLayerEffect mLayerEffect = BackdropLayerEffect.DODGE;
    private float mBlendColor = 0.1f;
    private int mColor = -1;
    private PathProvider mRoundRectProvider = sSimpleRoundRectProvider;
    private int mMaterialBlendMode = 2;
    private int[] mBlendTypes = null;
    private int[] mBlendColors = null;
    private boolean mStrokeEnabled = false;
    private float mStrokeWidth = 2.0f;
    private float mStrokeSoftness = 2.0f;
    private float mStrokeIntensity = 1.0f;
    private float mStrokeSpread = 2.0f;
    private float mStrokeR = 1.0f;
    private float mStrokeG = 1.0f;
    private float mStrokeB = 1.0f;
    private float mStrokeA = 1.0f;
    private float mLight0X = -0.7071f;
    private float mLight0Y = -0.7071f;
    private float mLight1X = 0.7071f;
    private float mLight1Y = 0.7071f;
    private boolean mInnerShadowEnabled = false;
    private float mInnerR = 0.0f;
    private float mInnerG = 0.0f;
    private float mInnerB = 0.0f;
    private float mInnerA = 1.0f;
    private float mInnerRadius = 8.0f;
    private float mInnerOffsetX = 0.0f;
    private float mInnerOffsetY = 0.0f;
    private float mInnerIntensity = 1.0f;
    private boolean mRefractEnabled = false;
    private float mRefractStrength = 20.0f;
    private float mRefractWidth = 40.0f;
    private float mRefractDepth = 0.4f;
    private float mFrost = 0.0f;
    private float mDispersion = 0.0f;
    private float mAmbient = 0.0f;
    private int mGradientBlurMode = 0;
    private int mGradientBlurScale = 0;
    private boolean mAnisoRim = false;
    private int mEdgeColor = -3355444;
    private int mDarkColor = -3092272;
    private float mDarkWidth = 1.0f;
    private float mEdgeWidth = 1.0f;
    private int mCgStart = 0;
    private int mCgMiddle = 0;
    private int mCgEnd = 0;
    private float mCgMidpoint = 0.5f;
    private int mCgMode = 0;
    private float mSdfScale = 96.0f;
    private float mErode = 2.0f;
    private int mTextShapeMode = 0;
    private final RenderNode.PositionUpdateListener mPositionUpdateListener = new RenderNode.PositionUpdateListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayerDrawable.1
        public void positionChanged(long frameNumber, int left, int top, int right, int bottom) {
            BackdropLayerDrawable.this.updatePosition(left, top, right, bottom);
        }

        public void positionLost(long frameNumber) {
            BackdropLayerDrawable.this.updatePosition(0, 0, 0, 0);
        }
    };
    private final BackdropLayer.BackdropLayerListener mBackdropLayerListener = new BackdropLayer.BackdropLayerListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayerDrawable.2
        @Override // com.android.internal.graphics.backdrop.BackdropLayer.BackdropLayerListener
        public void onBackdropLayerCreated(TextureLayer layer) {
            BackdropLayerDrawable.this.mTextureLayer = layer;
            BackdropLayerDrawable.this.invalidateSelf();
        }

        @Override // com.android.internal.graphics.backdrop.BackdropLayer.BackdropLayerListener
        public void onBackdropLayerUpdated() {
            BackdropLayerDrawable.this.invalidateSelf();
        }

        @Override // com.android.internal.graphics.backdrop.BackdropLayer.BackdropLayerListener
        public void onBackdropLayerDestroyed() {
            BackdropLayerDrawable.this.mTextureLayer = null;
            BackdropLayerDrawable.this.invalidateSelf();
        }
    };
    private int mGlassState = -1;

    public interface PathProvider {
        Path providePath(Rect rect, float f, float f2, float f3, float f4);
    }

    private boolean needsBackdrop() {
        return this.mBlurRadius > 0 || this.mTextShapeMode != 0;
    }

    public BackdropLayerDrawable(ViewRootImpl viewRootImpl) {
        this.mViewRootImpl = viewRootImpl;
        Looper looper = Looper.myLooper();
        this.mHandler = new Handler(looper == null ? Looper.getMainLooper() : looper);
        this.mRenderNode = new RenderNode(TAG);
        this.mRenderNode.addPositionUpdateListener(this.mPositionUpdateListener);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePosition(int left, int top, int right, int bottom) {
        boolean isRectVisible;
        this.mRect.set(left, top, right, bottom);
        Log.d(TAG, "[BLUR] updatePosition mRect=" + this.mRect + " bounds=" + getBounds() + " window=" + this.mViewRootImpl.getWidth() + "x" + this.mViewRootImpl.getHeight());
        invalidateSelf();
        if (this.mRect.isEmpty()) {
            isRectVisible = false;
        } else {
            boolean z = false;
            Rect windowFrame = new Rect(0, 0, this.mViewRootImpl.getWidth(), this.mViewRootImpl.getHeight());
            if (windowFrame.width() == 0 || windowFrame.height() == 0 || (windowFrame.left < this.mRect.right && this.mRect.left < windowFrame.right && windowFrame.top < this.mRect.bottom && this.mRect.top < windowFrame.bottom)) {
                z = true;
            }
            isRectVisible = z;
        }
        if (this.mRectVisible != isRectVisible) {
            this.mRectVisible = isRectVisible;
            this.mHandler.post(new Runnable() { // from class: com.android.internal.graphics.backdrop.BackdropLayerDrawable$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updateCaptureState();
                }
            });
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        if (changed) {
            this.mVisible = visible;
            updateCaptureState();
            invalidateSelf();
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.mAlpha != alpha) {
            this.mPaint.setAlpha(alpha);
            this.mAlpha = alpha;
            updateCaptureState();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    public void setBlurRadius(int blurRadius) {
        if (this.mBlurRadius != blurRadius) {
            this.mBlurRadius = blurRadius;
            updateCaptureState();
            invalidateSelf();
        }
    }

    public void setDodge(float dodge) {
        this.mBlendColor = dodge;
        this.mLayerEffect = BackdropLayerEffect.DODGE;
        this.mMaterialBlendMode = 2;
        updateMaterial();
        invalidateSelf();
    }

    public void setOverlay(float overlay) {
        this.mBlendColor = overlay;
        this.mLayerEffect = BackdropLayerEffect.OVERLAY;
        this.mMaterialBlendMode = 3;
        updateMaterial();
        invalidateSelf();
    }

    public void setColor(int color) {
        this.mPaint.setColor(color);
        this.mColor = color;
        updateMaterial();
        invalidateSelf();
    }

    public void setBlendMode(int blendMode) {
        this.mMaterialBlendMode = blendMode;
        updateMaterial();
        invalidateSelf();
    }

    public void setBlendArray(int[] types, int[] colors) {
        this.mBlendTypes = types;
        this.mBlendColors = colors;
        updateMaterial();
        invalidateSelf();
    }

    public void setGlassStroke(boolean enabled, float width, float softness, float intensity, int color) {
        this.mStrokeEnabled = enabled;
        this.mStrokeWidth = width;
        this.mStrokeSoftness = softness;
        this.mStrokeIntensity = intensity;
        this.mStrokeA = Color.alpha(color) / 255.0f;
        this.mStrokeR = Color.red(color) / 255.0f;
        this.mStrokeG = Color.green(color) / 255.0f;
        this.mStrokeB = Color.blue(color) / 255.0f;
        updateMaterial();
        invalidateSelf();
    }

    public void setLightDirs(float l0x, float l0y, float l1x, float l1y) {
        this.mLight0X = l0x;
        this.mLight0Y = l0y;
        this.mLight1X = l1x;
        this.mLight1Y = l1y;
        updateMaterial();
        invalidateSelf();
    }

    public void setStrokeSpread(float spread) {
        this.mStrokeSpread = spread;
        updateMaterial();
        invalidateSelf();
    }

    public void setRefraction(boolean enabled, float strength, float width) {
        this.mRefractEnabled = enabled;
        this.mRefractStrength = strength;
        this.mRefractWidth = width;
        updateMaterial();
        invalidateSelf();
    }

    public void setRefractionDepth(float depth) {
        this.mRefractDepth = depth;
        updateMaterial();
        invalidateSelf();
    }

    public void setFrost(float frost) {
        this.mFrost = frost;
        updateMaterial();
        invalidateSelf();
    }

    public void setDispersion(float dispersion) {
        this.mDispersion = dispersion;
        updateMaterial();
        invalidateSelf();
    }

    public void setBlurGradient(int mode, int scale) {
        this.mGradientBlurMode = mode;
        this.mGradientBlurScale = scale;
        Log.d(TAG, "setBlurGradient mode=" + mode + " scale=" + scale);
        updateMaterial();
        invalidateSelf();
    }

    public void setColorGradient(int startArgb, int middleArgb, int endArgb, float midpoint, int direction) {
        this.mCgStart = startArgb;
        this.mCgMiddle = middleArgb;
        this.mCgEnd = endArgb;
        this.mCgMidpoint = midpoint;
        this.mCgMode = direction;
        Log.d(TAG, "setColorGradient mode=" + direction + " mid=" + midpoint);
        updateMaterial();
        invalidateSelf();
    }

    public void setAmbient(float ambient) {
        this.mAmbient = ambient;
        updateMaterial();
        invalidateSelf();
    }

    public void setAnisoRim(boolean on) {
        this.mAnisoRim = on;
        updateMaterial();
        invalidateSelf();
    }

    public void setEdgeColors(int edgeColor, int darkColor) {
        this.mEdgeColor = edgeColor;
        this.mDarkColor = darkColor;
        updateMaterial();
        invalidateSelf();
    }

    public void setDarkWidth(float px) {
        this.mDarkWidth = px;
        updateMaterial();
        invalidateSelf();
    }

    public void setEdgeWidth(float px) {
        this.mEdgeWidth = px;
        updateMaterial();
        invalidateSelf();
    }

    public void setInnerShadow(boolean enabled, int color, float radius, float offsetX, float offsetY, float intensity) {
        this.mInnerShadowEnabled = enabled;
        this.mInnerA = Color.alpha(color) / 255.0f;
        this.mInnerR = Color.red(color) / 255.0f;
        this.mInnerG = Color.green(color) / 255.0f;
        this.mInnerB = Color.blue(color) / 255.0f;
        this.mInnerRadius = radius;
        this.mInnerOffsetX = offsetX;
        this.mInnerOffsetY = offsetY;
        this.mInnerIntensity = intensity;
        updateMaterial();
        invalidateSelf();
    }

    public void setGlassText(boolean enabled, float sdfScale, float erode) {
        int i;
        if (enabled) {
            i = 1;
        } else {
            i = 2;
        }
        this.mTextShapeMode = i;
        this.mSdfScale = sdfScale;
        this.mErode = erode;
        updateMaterial();
        updateCaptureState();
        invalidateSelf();
    }

    private void updateMaterial() {
        Rect b = getBounds();
        BackdropMaterialParams.Builder builder = new BackdropMaterialParams.Builder().setBlend(this.mMaterialBlendMode, this.mBlendColor, Color.alpha(this.mColor) / 255.0f).setBlendArray(this.mBlendTypes, this.mBlendColors).setStroke(this.mStrokeEnabled, this.mStrokeWidth, this.mStrokeSoftness, this.mStrokeIntensity, this.mStrokeR, this.mStrokeG, this.mStrokeB, this.mStrokeA).setStrokeSpread(this.mStrokeSpread).setLightDirs(this.mLight0X, this.mLight0Y, this.mLight1X, this.mLight1Y).setInnerShadow(this.mInnerShadowEnabled, this.mInnerR, this.mInnerG, this.mInnerB, this.mInnerA, this.mInnerRadius, this.mInnerOffsetX, this.mInnerOffsetY, this.mInnerIntensity).setRefraction(this.mRefractEnabled, this.mRefractStrength, this.mRefractWidth).setDepthEffect(this.mRefractDepth).setFrost(this.mFrost).setDispersion(this.mDispersion).setAmbient(this.mAmbient).setAnisoRim(this.mAnisoRim).setEdgeColor(this.mEdgeColor).setDarkColor(this.mDarkColor).setDarkWidth(this.mDarkWidth).setEdgeWidth(this.mEdgeWidth).setCornerSmoothness(this.mCornerSmoothness).setBlurGradient(this.mGradientBlurMode, this.mGradientBlurScale).setColorGradient(this.mCgStart, this.mCgMiddle, this.mCgEnd, this.mCgMidpoint, this.mCgMode).setUseShapeAlpha(this.mStrokeEnabled || this.mInnerShadowEnabled);
        if (this.mTextShapeMode == 1) {
            builder.setGlassText(this.mSdfScale, this.mErode);
        } else if (this.mTextShapeMode == 2) {
            builder.setTextMask();
        }
        if (b.width() > 0 && b.height() > 0) {
            builder.setGeometry(b.width(), b.height(), this.mCornerRadiusTL, this.mCornerRadiusTR, this.mCornerRadiusBR, this.mCornerRadiusBL);
        }
        this.mMaterialParams = builder.build();
    }

    public void setCornerRadius(float cornerRadius) {
        setCornerRadius(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
    }

    public void setCornerSmoothness(float smoothness) {
        if (this.mCornerSmoothness != smoothness) {
            this.mCornerSmoothness = smoothness;
            updateMaterial();
            invalidateSelf();
        }
    }

    public void setCornerRadius(float cornerRadiusTL, float cornerRadiusTR, float cornerRadiusBL, float cornerRadiusBR) {
        if (this.mCornerRadiusTL != cornerRadiusTL || this.mCornerRadiusTR != cornerRadiusTR || this.mCornerRadiusBL != cornerRadiusBL || this.mCornerRadiusBR != cornerRadiusBR) {
            this.mCornerRadiusTL = cornerRadiusTL;
            this.mCornerRadiusTR = cornerRadiusTR;
            this.mCornerRadiusBL = cornerRadiusBL;
            this.mCornerRadiusBR = cornerRadiusBR;
            updatePath();
            updateMaterial();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.mRenderNode.setPosition(0, 0, right - left, bottom - top);
        updatePath();
        updateMaterial();
    }

    public void setPathProvider(PathProvider roundRectProvider) {
        this.mRoundRectProvider = roundRectProvider;
        if (roundRectProvider == null) {
            this.mTextShapeMode = 0;
            updateMaterial();
            updateCaptureState();
        }
        updatePath();
        invalidateSelf();
    }

    private void updatePath() {
        Rect b = getBounds();
        Rect local = new Rect(0, 0, b.width(), b.height());
        Path path = null;
        PathProvider roundRectProvider = this.mRoundRectProvider;
        if (roundRectProvider != null) {
            path = roundRectProvider.providePath(local, this.mCornerRadiusTL, this.mCornerRadiusTR, this.mCornerRadiusBL, this.mCornerRadiusBR);
        }
        if (path == null) {
            path = sSimpleRoundRectProvider.providePath(local, this.mCornerRadiusTL, this.mCornerRadiusTR, this.mCornerRadiusBL, this.mCornerRadiusBR);
        }
        if (path != null) {
            this.mDrawPath.reset();
            this.mDrawPath.set(path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCaptureState() {
        boolean captureBackdropLayer = this.mAlpha > 0 && this.mVisible && this.mRectVisible && needsBackdrop();
        if (captureBackdropLayer) {
            if (!this.mCapturingBackdrop) {
                this.mViewRootImpl.requestBackdropCapture(this.mBackdropLayerListener);
                this.mCapturingBackdrop = true;
                return;
            }
            return;
        }
        if (this.mCapturingBackdrop) {
            this.mViewRootImpl.removeBackdropCapture(this.mBackdropLayerListener);
            this.mCapturingBackdrop = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (Thread.currentThread() == this.mHandler.getLooper().getThread()) {
            super.invalidateSelf();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.android.internal.graphics.backdrop.BackdropLayerDrawable$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$invalidateSelf$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$invalidateSelf$0() {
        super.invalidateSelf();
    }

    private void maybeSeedInitialPosition(Rect b) {
        int l;
        int t;
        int r;
        int bottom;
        if (!this.mRect.isEmpty() || !needsBackdrop()) {
            return;
        }
        if (b.left != 0 || b.top != 0) {
            l = b.left;
            t = b.top;
            r = b.right;
            bottom = b.bottom;
        } else {
            Drawable.Callback cb = getCallback();
            if (!(cb instanceof View)) {
                return;
            }
            View host = (View) cb;
            if (host.getWidth() <= 0 || host.getHeight() <= 0) {
                return;
            }
            host.getLocationInWindow(this.mTmpLocation);
            l = this.mTmpLocation[0];
            t = this.mTmpLocation[1];
            r = host.getWidth() + l;
            bottom = host.getHeight() + t;
        }
        if (r <= l || bottom <= t) {
            return;
        }
        this.mRect.set(l, t, r, bottom);
        this.mRectVisible = true;
        updateCaptureState();
    }

    private boolean glassEnabled() {
        if (this.mGlassState < 0) {
            this.mGlassState = StepOSFeature.isEnabled(33) ? 1 : 0;
        }
        return this.mGlassState == 1;
    }

    private Paint offPaint() {
        if (this.mOffPaint == null) {
            this.mOffPaint = new Paint();
            this.mOffPaint.setAntiAlias(true);
            this.mOffPaint.setColor(0);
        }
        return this.mOffPaint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDrawPath.isEmpty() || !isVisible() || getAlpha() == 0) {
            return;
        }
        if (!glassEnabled()) {
            canvas.drawPath(this.mDrawPath, offPaint());
            return;
        }
        if (!(canvas instanceof RecordingCanvas)) {
            Log.e(TAG, "Skip drawRenderNode for software rendering");
            return;
        }
        Rect b = getBounds();
        maybeSeedInitialPosition(b);
        boolean offset = (b.left == 0 && b.top == 0) ? false : true;
        if (offset) {
            canvas.save();
            canvas.translate(b.left, b.top);
        }
        canvas.drawRenderNode(this.mRenderNode);
        if (this.mTextShapeMode == 2 && this.mTextureLayer == null) {
            if (offset) {
                canvas.restore();
                return;
            }
            return;
        }
        if (this.mTextureLayer != null && needsBackdrop()) {
            ((RecordingCanvas) canvas).drawBackdropLayer(this.mTextureLayer, this.mRect.left, this.mRect.top, this.mAlpha, this.mBlurRadius, this.mLayerEffect.getEffect(), this.mBlendColor, this.mColor, this.mDrawPath, this.mMaterialParams != null ? this.mMaterialParams.getNativeInstance() : 0L);
        } else {
            long materialHandle = this.mMaterialParams != null ? this.mMaterialParams.getNativeInstance() : 0L;
            if (materialHandle == 0 || (!this.mStrokeEnabled && !this.mInnerShadowEnabled && Color.alpha(this.mColor) <= 0)) {
                canvas.drawPath(this.mDrawPath, this.mPaint);
            } else {
                ((RecordingCanvas) canvas).drawBackdropMaterial(this.mDrawPath, this.mAlpha, this.mColor, materialHandle);
            }
        }
        if (offset) {
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new IllegalArgumentException("not implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
