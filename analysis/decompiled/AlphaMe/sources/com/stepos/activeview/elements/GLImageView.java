package com.stepos.activeview.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import com.stepos.activeview.json.ApertureData;
import com.stepos.activeview.json.WaveData;
import com.stepos.activeview.texture.GLImageRender;
import com.stepos.alphame.utils.Property;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class GLImageView extends TextureView {
    private ApertureData mEndApertureData;
    private WaveData mEndWaveData;
    private GLImageRender mGlImageRender;
    private float mScalRate;

    public GLImageView(Context context) {
        this(context, null);
    }

    private float getFractionValue(float f4, float f5, float f6) {
        return AbstractC0831a.c(f5, f4, f6, f4);
    }

    public ApertureData getAperture() {
        return this.mEndApertureData;
    }

    public float getBlur() {
        GLImageRender gLImageRender = this.mGlImageRender;
        return gLImageRender != null ? gLImageRender.getBlur() : Property.DEFAULT_FLOAT_VALUE;
    }

    public WaveData getWaveData() {
        return this.mEndWaveData;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        setAlpha(Property.DEFAULT_FLOAT_VALUE);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        setAlpha(Property.DEFAULT_FLOAT_VALUE);
        super.onDetachedFromWindow();
    }

    public void setBlur(float f4) {
        this.mGlImageRender.setBlur(f4);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mGlImageRender.setImageBitmap(bitmap);
    }

    public void setScalRate(float f4) {
        this.mScalRate = f4;
    }

    public void setStartEndApertureData(ApertureData apertureData, ApertureData apertureData2, float f4) {
        if (apertureData == null || apertureData2 == null) {
            return;
        }
        this.mEndApertureData = apertureData2;
        float fFloatValue = apertureData.getR().floatValue();
        float fFloatValue2 = apertureData2.getR().floatValue();
        float[] centerLocation = apertureData.getCenterLocation(getContext(), this.mScalRate);
        float[] centerLocation2 = apertureData2.getCenterLocation(getContext(), this.mScalRate);
        this.mGlImageRender.setApertureData(getFractionValue(fFloatValue, fFloatValue2, f4), new float[]{getFractionValue(centerLocation[0], centerLocation2[0], f4), getFractionValue(centerLocation[1], centerLocation2[1], f4)});
    }

    public void setStartEndWaveData(WaveData waveData, WaveData waveData2, float f4) {
        if (waveData == null || waveData2 == null) {
            return;
        }
        this.mEndWaveData = waveData2;
        this.mGlImageRender.setPoints(waveData.getEndCellsValue(getContext(), this.mScalRate), waveData2.getEndCellsValue(getContext(), this.mScalRate), f4);
    }

    public void setSurfaceTextureListener(GLImageRender gLImageRender) {
        this.mGlImageRender = gLImageRender;
        gLImageRender.setView(this);
        super.setSurfaceTextureListener((TextureView.SurfaceTextureListener) gLImageRender);
    }

    public GLImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GLImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mGlImageRender = null;
        this.mScalRate = 1.0f;
    }
}
