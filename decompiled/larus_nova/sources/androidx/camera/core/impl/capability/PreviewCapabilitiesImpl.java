package androidx.camera.core.impl.capability;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.PreviewCapabilities;
import androidx.camera.core.impl.CameraInfoInternal;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewCapabilitiesImpl implements PreviewCapabilities {
    private boolean mIsStabilizationSupported;

    @Override // androidx.camera.core.PreviewCapabilities
    public boolean isStabilizationSupported() {
        return this.mIsStabilizationSupported;
    }

    public PreviewCapabilitiesImpl(CameraInfoInternal r100) {
        this.mIsStabilizationSupported = r100.isPreviewStabilizationSupported();
    }

    public static PreviewCapabilities from(CameraInfo r100) {
        return new PreviewCapabilitiesImpl((CameraInfoInternal) r100);
    }
}
