package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
class ZoomStateImpl implements ZoomState {
    private float mLinearZoom;
    private final float mMaxZoomRatio;
    private final float mMinZoomRatio;
    private float mZoomRatio;

    @Override // androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.mLinearZoom;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.mMaxZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    private float getPercentageByRatio(float r100) {
        float r101 = this.mMaxZoomRatio;
        float r102 = this.mMinZoomRatio;
        if (r101 != r102) goto L6;
        return 0.0f;
    L6:
        if (r100 != r101) goto L9;
        return 1.0f;
    L9:
        if (r100 != r102) goto L11;
        return 0.0f;
    L11:
        float r103 = 1.0f / r102;
        return ((1.0f / r100) - r103) / ((1.0f / r101) - r103);
    }

    private float getRatioByPercentage(float r110) {
        if (r110 != 1.0f) goto L7;
        return this.mMaxZoomRatio;
    L7:
        if (r110 == 0.0f) goto L9;
        float r100 = this.mMaxZoomRatio;
        float r101 = this.mMinZoomRatio;
        double r102 = 1.0f / r101;
        return (float) MathUtils.clamp(1.0d / (r102 + ((((double) (1.0f / r100)) - r102) * ((double) r110))), r101, r100);
    L9:
        return this.mMinZoomRatio;
    }

    public void setLinearZoom(float r100) throws IllegalArgumentException {
        if (r100 > 1.0f) goto L9;
        if (r100 < 0.0f) goto L9;
        this.mLinearZoom = r100;
        this.mZoomRatio = getRatioByPercentage(r100);
        return;
    L9:
        throw new IllegalArgumentException("Requested linearZoom " + r100 + " is not within valid range [0..1]");
    }

    public void setZoomRatio(float r100) throws IllegalArgumentException {
        if (r100 > this.mMaxZoomRatio) goto L9;
        if (r100 < this.mMinZoomRatio) goto L9;
        this.mZoomRatio = r100;
        this.mLinearZoom = getPercentageByRatio(r100);
        return;
    L9:
        throw new IllegalArgumentException("Requested zoomRatio " + r100 + " is not within valid range [" + this.mMinZoomRatio + " , " + this.mMaxZoomRatio + "]");
    }

    public ZoomStateImpl(float r100, float r101) {
        this.mMaxZoomRatio = r100;
        this.mMinZoomRatio = r101;
    }
}
