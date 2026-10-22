package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.a.a.a;
import androidx.appcompat.widget.AppCompatImageButton;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageFilterView.a mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private float mPanX;
    private float mPanY;
    private Path mPath;
    RectF mRect;
    private float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    private float mZoom;

    static /* synthetic */ float access$000(ImageFilterButton r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterButton r0) {
        return r0.mRound;
    }

    public ImageFilterButton(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4);
        this.mImageMatrix = new ImageFilterView.a();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r4, null);
    }

    public ImageFilterButton(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mImageMatrix = new ImageFilterView.a();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r5, r6);
    }

    public ImageFilterButton(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mImageMatrix = new ImageFilterView.a();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r6, r7);
    }

    private void init(Context r9, AttributeSet r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        setPadding(0, 0, 0, 0);
        if (r12 == null) goto L70;
        TypedArray r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r12, R.styleable.ImageFilterView);
        int r0 = r13.getIndexCount();
        this.mAltDrawable = r13.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_altSrc, "styleable", "ImageFilterView_altSrc"));
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L44;
        int r3 = r13.getIndex(r1);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_crossfade, "styleable", "ImageFilterView_crossfade")) goto L10;
        this.mCrossfade = r13.getFloat(r3, 0.0f);
    L43:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_warmth, "styleable", "ImageFilterView_warmth")) goto L13;
        setWarmth(r13.getFloat(r3, 0.0f));
        goto L43
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_saturation, "styleable", "ImageFilterView_saturation")) goto L16;
        setSaturation(r13.getFloat(r3, 0.0f));
        goto L43
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_contrast, "styleable", "ImageFilterView_contrast")) goto L19;
        setContrast(r13.getFloat(r3, 0.0f));
        goto L43
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_round, "styleable", "ImageFilterView_round")) goto L24;
        if (Build.VERSION.SDK_INT < 21) goto L43;
        setRound(r13.getDimension(r3, 0.0f));
        goto L43
    L24:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_roundPercent, "styleable", "ImageFilterView_roundPercent")) goto L29;
        if (Build.VERSION.SDK_INT < 21) goto L43;
        setRoundPercent(r13.getFloat(r3, 0.0f));
        goto L43
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_overlay, "styleable", "ImageFilterView_overlay")) goto L32;
        setOverlay(r13.getBoolean(r3, this.mOverlay));
        goto L43
    L32:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imagePanX, "styleable", "ImageFilterView_imagePanX")) goto L35;
        setImagePanX(r13.getFloat(r3, this.mPanX));
        goto L43
    L35:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imagePanY, "styleable", "ImageFilterView_imagePanY")) goto L38;
        setImagePanY(r13.getFloat(r3, this.mPanY));
        goto L43
    L38:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imageRotate, "styleable", "ImageFilterView_imageRotate")) goto L41;
        setImageRotate(r13.getFloat(r3, this.mRotate));
        goto L43
    L41:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imageZoom, "styleable", "ImageFilterView_imageZoom")) goto L43;
        setImageZoom(r13.getFloat(r3, this.mZoom));
        goto L43
    L44:
        r13.recycle();
        Drawable r14 = getDrawable();
        this.mDrawable = r14;
        if (this.mAltDrawable == null) goto L51;
        if (r14 == null) goto L51;
        Drawable[] r15 = this.mLayers;
        Drawable r2 = getDrawable().mutate();
        this.mDrawable = r2;
        r15[0] = r2;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r16 = new LayerDrawable(this.mLayers);
        this.mLayer = r16;
        r16.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L50;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L50:
        super.setImageDrawable(this.mLayer);
        return;
    L51:
        Drawable r17 = getDrawable();
        this.mDrawable = r17;
        if (r17 == null) goto L72;
        Drawable[] r4 = this.mLayers;
        Drawable r18 = r17.mutate();
        this.mDrawable = r18;
        r4[0] = r18;
        return;
    L72:
        return;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public void setImagePanX(float r1) {
        this.mPanX = r1;
        updateViewMatrix();
    }

    public void setImagePanY(float r1) {
        this.mPanY = r1;
        updateViewMatrix();
    }

    public void setImageZoom(float r1) {
        this.mZoom = r1;
        updateViewMatrix();
    }

    public void setImageRotate(float r1) {
        this.mRotate = r1;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable r3) {
        if (this.mAltDrawable == null) goto L6;
        if (r3 == null) goto L6;
        Drawable r4 = r3.mutate();
        this.mDrawable = r4;
        Drawable[] r0 = this.mLayers;
        r0[0] = r4;
        r0[1] = this.mAltDrawable;
        LayerDrawable r5 = new LayerDrawable(this.mLayers);
        this.mLayer = r5;
        super.setImageDrawable(r5);
        setCrossfade(this.mCrossfade);
        return;
    L6:
        super.setImageDrawable(r3);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int r4) {
        if (this.mAltDrawable == null) goto L5;
        Drawable r5 = a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4).mutate();
        this.mDrawable = r5;
        Drawable[] r0 = this.mLayers;
        r0[0] = r5;
        r0[1] = this.mAltDrawable;
        LayerDrawable r6 = new LayerDrawable(this.mLayers);
        this.mLayer = r6;
        super.setImageDrawable(r6);
        setCrossfade(this.mCrossfade);
        return;
    L5:
        super.setImageResource(r4);
    }

    public void setAltImageResource(int r4) {
        Drawable r5 = a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4).mutate();
        this.mAltDrawable = r5;
        Drawable[] r0 = this.mLayers;
        r0[0] = this.mDrawable;
        r0[1] = r5;
        LayerDrawable r6 = new LayerDrawable(this.mLayers);
        this.mLayer = r6;
        super.setImageDrawable(r6);
        setCrossfade(this.mCrossfade);
    }

    private void updateViewMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L12:
        setMatrix();
        return;
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L12;
        if (Float.isNaN(this.mZoom) == false) goto L12;
        if (Float.isNaN(this.mRotate) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private void setMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L11:
        float r1 = 0.0f;
        if (Float.isNaN(this.mPanX) == false) goto L14;
        float r0 = 0.0f;
    L16:
        if (Float.isNaN(this.mPanY) == false) goto L18;
        float r2 = 0.0f;
    L20:
        if (Float.isNaN(this.mZoom) == false) goto L22;
        float r3 = 1.0f;
    L24:
        if (Float.isNaN(this.mRotate) == true) goto L27;
        r1 = this.mRotate;
    L27:
        Matrix r4 = new Matrix();
        r4.reset();
        float r5 = getDrawable().getIntrinsicWidth();
        float r6 = getDrawable().getIntrinsicHeight();
        float r7 = getWidth();
        float r8 = getHeight();
        if ((r5 * r8) >= (r6 * r7)) goto L30;
        float r9 = r7 / r5;
    L31:
        float r10 = r3 * r9;
        r4.postScale(r10, r10);
        float r11 = r5 * r10;
        float r12 = r10 * r6;
        r4.postTranslate((((r0 * (r7 - r11)) + r7) - r11) * 0.5f, (((r2 * (r8 - r12)) + r8) - r12) * 0.5f);
        r4.postRotate(r1, r7 / 2.0f, r8 / 2.0f);
        setImageMatrix(r4);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r9 = r8 / r6;
        goto L31
    L22:
        r3 = this.mZoom;
        goto L24
    L18:
        r2 = this.mPanY;
        goto L20
    L14:
        r0 = this.mPanX;
        goto L16
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L11;
        if (Float.isNaN(this.mZoom) == false) goto L11;
        if (Float.isNaN(this.mRotate) == false) goto L11;
    }

    private void setOverlay(boolean r1) {
        this.mOverlay = r1;
    }

    public void setSaturation(float r2) {
        this.mImageMatrix.f935e = r2;
        this.mImageMatrix.a(this);
    }

    public float getSaturation() {
        return this.mImageMatrix.f935e;
    }

    public void setContrast(float r2) {
        this.mImageMatrix.f = r2;
        this.mImageMatrix.a(this);
    }

    public float getContrast() {
        return this.mImageMatrix.f;
    }

    public void setWarmth(float r2) {
        this.mImageMatrix.g = r2;
        this.mImageMatrix.a(this);
    }

    public float getWarmth() {
        return this.mImageMatrix.g;
    }

    public void setCrossfade(float r4) {
        this.mCrossfade = r4;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public void setBrightness(float r2) {
        this.mImageMatrix.f934d = r2;
        this.mImageMatrix.a(this);
    }

    public void setRoundPercent(float r7) {
        if (this.mRoundPercent == r7) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = r7;
        if (r7 == 0.0f) goto L22;
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (Build.VERSION.SDK_INT >= 21) goto L17;
    L20:
        int r8 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r8, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r8, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
    L24:
        if (r0 == true) goto L26;
        return;
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L30;
        invalidateOutline();
        return;
    L30:
        return;
    L17:
        if (this.mViewOutlineProvider != null) goto L19;
        ViewOutlineProvider r9 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r9;
        setOutlineProvider(r9);
    L19:
        setClipToOutline(true);
        goto L20
    L22:
        if (Build.VERSION.SDK_INT < 21) goto L24;
        setClipToOutline(false);
        goto L24
    L5:
        r0 = false;
        goto L6
    }

    public void setRound(float r6) {
        if (Float.isNaN(r6) == false) goto L7;
        this.mRound = r6;
        float r7 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r7);
        return;
    L7:
        if (this.mRound == r6) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = r6;
        if (r6 == 0.0f) goto L26;
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (Build.VERSION.SDK_INT >= 21) goto L21;
    L24:
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r8 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r8.addRoundRect(r1, r2, r2, Path.Direction.CW);
    L28:
        if (r0 == true) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L34;
        invalidateOutline();
        return;
    L34:
        return;
    L21:
        if (this.mViewOutlineProvider != null) goto L23;
        ViewOutlineProvider r9 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r9;
        setOutlineProvider(r9);
    L23:
        setClipToOutline(true);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L28;
        setClipToOutline(false);
        goto L28
    L9:
        r0 = false;
        goto L10
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getRound() {
        return this.mRound;
    }

    @Override // android.view.View
    public void draw(Canvas r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r0 = false;
    L10:
        super.draw(r3);
        if (r0 == false) goto L14;
        r3.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRound == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r0 = true;
        r3.save();
        r3.clipPath(this.mPath);
        goto L10
    }

    @Override // android.view.View
    public void layout(int r1, int r2, int r3, int r4) {
        super.layout(r1, r2, r3, r4);
        setMatrix();
    }
}
