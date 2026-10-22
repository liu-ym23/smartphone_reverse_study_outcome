package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class ImageFilterView extends AppCompatImageView {
    private float mCrossfade;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    public static class ImageMatrix {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float[] f15336m;
        float mBrightness;
        ColorMatrix mColorMatrix;
        float mContrast;
        float mSaturation;
        ColorMatrix mTmpColorMatrix;
        float mWarmth;

        public ImageMatrix() {
            this.f15336m = new float[20];
            this.mColorMatrix = new ColorMatrix();
            this.mTmpColorMatrix = new ColorMatrix();
            this.mBrightness = 1.0f;
            this.mSaturation = 1.0f;
            this.mContrast = 1.0f;
            this.mWarmth = 1.0f;
        }

        private void brightness(float r100) {
            float[] r101 = this.f15336m;
            r101[0] = r100;
            r101[1] = 0.0f;
            r101[2] = 0.0f;
            r101[3] = 0.0f;
            r101[4] = 0.0f;
            r101[5] = 0.0f;
            r101[6] = r100;
            r101[7] = 0.0f;
            r101[8] = 0.0f;
            r101[9] = 0.0f;
            r101[10] = 0.0f;
            r101[11] = 0.0f;
            r101[12] = r100;
            r101[13] = 0.0f;
            r101[14] = 0.0f;
            r101[15] = 0.0f;
            r101[16] = 0.0f;
            r101[17] = 0.0f;
            r101[18] = 1.0f;
            r101[19] = 0.0f;
        }

        private void saturation(float r100) {
            float r101 = 1.0f - r100;
            float r102 = 0.2999f * r101;
            float r103 = 0.587f * r101;
            float r104 = r101 * 0.114f;
            float[] r105 = this.f15336m;
            r105[0] = r102 + r100;
            r105[1] = r103;
            r105[2] = r104;
            r105[3] = 0.0f;
            r105[4] = 0.0f;
            r105[5] = r102;
            r105[6] = r103 + r100;
            r105[7] = r104;
            r105[8] = 0.0f;
            r105[9] = 0.0f;
            r105[10] = r102;
            r105[11] = r103;
            r105[12] = r104 + r100;
            r105[13] = 0.0f;
            r105[14] = 0.0f;
            r105[15] = 0.0f;
            r105[16] = 0.0f;
            r105[17] = 0.0f;
            r105[18] = 1.0f;
            r105[19] = 0.0f;
        }

        private void warmth(float r110) {
            if (r110 > 0.0f) goto L5;
            r110 = 0.01f;
        L5:
            float r100 = (5000.0f / r110) / 100.0f;
            if (r100 <= 66.0f) goto L8;
            double r101 = r100 - 60.0f;
            float r102 = ((float) Math.pow(r101, -0.13320475816726685d)) * 329.69873f;
            float r103 = ((float) Math.pow(r101, 0.07551484555006027d)) * 288.12216f;
        L10:
            if (r100 < 66.0f) goto L12;
            float r104 = 255.0f;
        L16:
            float r105 = Math.min(255.0f, Math.max(r102, 0.0f));
            float r106 = Math.min(255.0f, Math.max(r103, 0.0f));
            float r107 = Math.min(255.0f, Math.max(r104, 0.0f));
            float r108 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r111 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r109 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r112 = Math.min(255.0f, Math.max(r108, 0.0f));
            float r113 = r107 / Math.min(255.0f, Math.max(r111, 0.0f));
            float[] r114 = this.f15336m;
            r114[0] = r105 / r109;
            r114[1] = 0.0f;
            r114[2] = 0.0f;
            r114[3] = 0.0f;
            r114[4] = 0.0f;
            r114[5] = 0.0f;
            r114[6] = r106 / r112;
            r114[7] = 0.0f;
            r114[8] = 0.0f;
            r114[9] = 0.0f;
            r114[10] = 0.0f;
            r114[11] = 0.0f;
            r114[12] = r113;
            r114[13] = 0.0f;
            r114[14] = 0.0f;
            r114[15] = 0.0f;
            r114[16] = 0.0f;
            r114[17] = 0.0f;
            r114[18] = 1.0f;
            r114[19] = 0.0f;
            return;
        L12:
            if (r100 <= 19.0f) goto L14;
            r104 = (((float) Math.log(r100 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L16
        L14:
            r104 = 0.0f;
            goto L16
        L8:
            r103 = (((float) Math.log(r100)) * 99.4708f) - 161.11957f;
            r102 = 255.0f;
            goto L10
        }

        public void updateMatrix(ImageView r100) {
            this.mColorMatrix.reset();
            float r101 = this.mSaturation;
            boolean r102 = true;
            if (r101 == 1.0f) goto L5;
            saturation(r101);
            this.mColorMatrix.set(this.f15336m);
            boolean r103 = true;
        L6:
            float r104 = this.mContrast;
            if (r104 == 1.0f) goto L9;
            this.mTmpColorMatrix.setScale(r104, r104, r104, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r103 = true;
        L9:
            float r105 = this.mWarmth;
            if (r105 == 1.0f) goto L12;
            warmth(r105);
            this.mTmpColorMatrix.set(this.f15336m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r103 = true;
        L12:
            float r106 = this.mBrightness;
            if (r106 == 1.0f) goto L15;
            brightness(r106);
            this.mTmpColorMatrix.set(this.f15336m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
        L16:
            if (r102 == false) goto L18;
            r100.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            return;
        L18:
            r100.clearColorFilter();
            return;
        L15:
            r102 = r103;
            goto L16
        L5:
            r103 = false;
            goto L6
        }
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public ImageFilterView(Context r100) {
        super(r100);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r100, null);
    }

    public static /* synthetic */ float access$000(ImageFilterView r100) {
        return r100.mRoundPercent;
    }

    public static /* synthetic */ float access$100(ImageFilterView r100) {
        return r100.mRound;
    }

    private void setOverlay(boolean r100) {
        this.mOverlay = r100;
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
    }

    public void setBrightness(float r100) {
        ImageMatrix r101 = this.mImageMatrix;
        r101.mBrightness = r100;
        r101.updateMatrix(this);
    }

    public void setContrast(float r100) {
        ImageMatrix r101 = this.mImageMatrix;
        r101.mContrast = r100;
        r101.updateMatrix(this);
    }

    public void setCrossfade(float r100) {
        this.mCrossfade = r100;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    public void setRound(float r100) {
        if (Float.isNaN(r100) == false) goto L7;
        this.mRound = r100;
        float r101 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r101);
        return;
    L7:
        if (this.mRound == r100) goto L9;
        boolean r102 = true;
    L10:
        this.mRound = r100;
        if (r100 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r102 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (this.mViewOutlineProvider != null) goto L21;
        ViewOutlineProvider r103 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r103;
        setOutlineProvider(r103);
    L21:
        setClipToOutline(true);
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r104 = this.mPath;
        RectF r105 = this.mRect;
        float r106 = this.mRound;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        goto L23
    L9:
        r102 = false;
        goto L10
    }

    public void setRoundPercent(float r100) {
        if (this.mRoundPercent == r100) goto L5;
        boolean r101 = true;
    L6:
        this.mRoundPercent = r100;
        if (r100 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r101 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (this.mViewOutlineProvider != null) goto L17;
        ViewOutlineProvider r102 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r102;
        setOutlineProvider(r102);
    L17:
        setClipToOutline(true);
        int r103 = getWidth();
        int r104 = getHeight();
        float r105 = (Math.min(r103, r104) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r103, r104);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r105, r105, Path.Direction.CW);
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public void setSaturation(float r100) {
        ImageMatrix r101 = this.mImageMatrix;
        r101.mSaturation = r100;
        r101.updateMatrix(this);
    }

    public void setWarmth(float r100) {
        ImageMatrix r101 = this.mImageMatrix;
        r101.mWarmth = r100;
        r101.updateMatrix(this);
    }

    public ImageFilterView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r100, r101);
    }

    private void init(Context r100, AttributeSet r101) {
        if (r101 == null) goto L40;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.altSrc, R.attr.blendSrc, R.attr.brightness, R.attr.contrast, R.attr.crossfade, R.attr.imagePanX, R.attr.imagePanY, R.attr.imageRotate, R.attr.imageZoom, R.attr.overlay, R.attr.round, R.attr.roundPercent, R.attr.saturation, R.attr.warmth});
        int r103 = r102.getIndexCount();
        Drawable r104 = r102.getDrawable(0);
        int r105 = 0;
    L4:
        if (r105 >= r103) goto L27;
        int r106 = r102.getIndex(r105);
        if (r106 != 4) goto L9;
        this.mCrossfade = r102.getFloat(r106, 0.0f);
    L26:
        r105 = r105 + 1;
        goto L4
    L9:
        if (r106 != 13) goto L12;
        setWarmth(r102.getFloat(r106, 0.0f));
        goto L26
    L12:
        if (r106 != 12) goto L15;
        setSaturation(r102.getFloat(r106, 0.0f));
        goto L26
    L15:
        if (r106 != 3) goto L18;
        setContrast(r102.getFloat(r106, 0.0f));
        goto L26
    L18:
        if (r106 != 10) goto L21;
        setRound(r102.getDimension(r106, 0.0f));
        goto L26
    L21:
        if (r106 != 11) goto L24;
        setRoundPercent(r102.getFloat(r106, 0.0f));
        goto L26
    L24:
        if (r106 != 9) goto L26;
        setOverlay(r102.getBoolean(r106, this.mOverlay));
        goto L26
    L27:
        r102.recycle();
        if (r104 == null) goto L41;
        Drawable[] r107 = new Drawable[2];
        this.mLayers = r107;
        r107[0] = getDrawable();
        this.mLayers[1] = r104;
        LayerDrawable r108 = new LayerDrawable(this.mLayers);
        this.mLayer = r108;
        r108.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
        return;
    L41:
        return;
    }

    public ImageFilterView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r100, r101);
    }
}
