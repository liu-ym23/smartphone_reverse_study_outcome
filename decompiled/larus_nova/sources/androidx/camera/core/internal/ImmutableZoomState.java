package androidx.camera.core.internal;

import androidx.camera.core.ZoomState;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableZoomState implements ZoomState {
    public ImmutableZoomState() {
    }

    @Override // androidx.camera.core.ZoomState
    public abstract float getLinearZoom();

    @Override // androidx.camera.core.ZoomState
    public abstract float getMaxZoomRatio();

    @Override // androidx.camera.core.ZoomState
    public abstract float getMinZoomRatio();

    @Override // androidx.camera.core.ZoomState
    public abstract float getZoomRatio();

    public static ZoomState create(ZoomState r100) {
        return new AutoValue_ImmutableZoomState(r100.getZoomRatio(), r100.getMaxZoomRatio(), r100.getMinZoomRatio(), r100.getLinearZoom());
    }

    public static ZoomState create(float r100, float r101, float r102, float r103) {
        return new AutoValue_ImmutableZoomState(r100, r101, r102, r103);
    }
}
