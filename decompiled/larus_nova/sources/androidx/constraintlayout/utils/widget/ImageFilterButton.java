package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class ImageFilterButton extends AppCompatImageButton {
    private float mCrossfade;
    private ImageFilterView.ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

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

    public ImageFilterButton(Context r100) {
        super(r100);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(r100, null);
    }

    public static /* synthetic */ float access$000(ImageFilterButton r100) {
        return r100.mRoundPercent;
    }

    public static /* synthetic */ float access$100(ImageFilterButton r100) {
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
        ImageFilterView.ImageMatrix r101 = this.mImageMatrix;
        r101.mBrightness = r100;
        r101.updateMatrix(this);
    }

    public void setContrast(float r100) {
        ImageFilterView.ImageMatrix r101 = this.mImageMatrix;
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
        ImageFilterView.ImageMatrix r101 = this.mImageMatrix;
        r101.mSaturation = r100;
        r101.updateMatrix(this);
    }

    public void setWarmth(float r100) {
        ImageFilterView.ImageMatrix r101 = this.mImageMatrix;
        r101.mWarmth = r100;
        r101.updateMatrix(this);
    }

    public ImageFilterButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(r100, r101);
    }

    private void init(Context r100, AttributeSet r101) {
        setPadding(0, 0, 0, 0);
        if (r101 == null) goto L41;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.altSrc, R.attr.blendSrc, R.attr.brightness, R.attr.contrast, R.attr.crossfade, R.attr.imagePanX, R.attr.imagePanY, R.attr.imageRotate, R.attr.imageZoom, R.attr.overlay, R.attr.round, R.attr.roundPercent, R.attr.saturation, R.attr.warmth});
        int r103 = r102.getIndexCount();
        Drawable r104 = r102.getDrawable(0);
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L28;
        int r106 = r102.getIndex(r105);
        if (r106 != 4) goto L10;
        this.mCrossfade = r102.getFloat(r106, 0.0f);
    L27:
        r105 = r105 + 1;
        goto L5
    L10:
        if (r106 != 13) goto L13;
        setWarmth(r102.getFloat(r106, 0.0f));
        goto L27
    L13:
        if (r106 != 12) goto L16;
        setSaturation(r102.getFloat(r106, 0.0f));
        goto L27
    L16:
        if (r106 != 3) goto L19;
        setContrast(r102.getFloat(r106, 0.0f));
        goto L27
    L19:
        if (r106 != 10) goto L22;
        setRound(r102.getDimension(r106, 0.0f));
        goto L27
    L22:
        if (r106 != 11) goto L25;
        setRoundPercent(r102.getFloat(r106, 0.0f));
        goto L27
    L25:
        if (r106 != 9) goto L27;
        setOverlay(r102.getBoolean(r106, this.mOverlay));
        goto L27
    L28:
        r102.recycle();
        if (r104 == null) goto L42;
        Drawable[] r107 = new Drawable[2];
        this.mLayers = r107;
        r107[0] = getDrawable();
        this.mLayers[1] = r104;
        LayerDrawable r108 = new LayerDrawable(this.mLayers);
        this.mLayer = r108;
        r108.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
        return;
    L42:
        return;
    }

    public ImageFilterButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(r100, r101);
    }
}
