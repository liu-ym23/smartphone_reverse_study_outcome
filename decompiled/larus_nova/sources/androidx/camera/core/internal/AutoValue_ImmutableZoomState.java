package androidx.camera.core.internal;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_ImmutableZoomState extends ImmutableZoomState {
    private final float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.zoomRatio) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.maxZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.minZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.linearZoom);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.zoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", linearZoom=" + this.linearZoom + i.f25855d;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.linearZoom;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableZoomState) == false) goto L18;
        ImmutableZoomState r101 = (ImmutableZoomState) r100;
        if (Float.floatToIntBits(this.zoomRatio) == Float.floatToIntBits(r101.getZoomRatio())) goto L10;
    L16:
        return false;
    L10:
        if (Float.floatToIntBits(this.maxZoomRatio) != Float.floatToIntBits(r101.getMaxZoomRatio())) goto L16;
        if (Float.floatToIntBits(this.minZoomRatio) != Float.floatToIntBits(r101.getMinZoomRatio())) goto L16;
        if (Float.floatToIntBits(this.linearZoom) != Float.floatToIntBits(r101.getLinearZoom())) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_ImmutableZoomState(float r100, float r101, float r102, float r103) {
        this.zoomRatio = r100;
        this.maxZoomRatio = r101;
        this.minZoomRatio = r102;
        this.linearZoom = r103;
    }
}
