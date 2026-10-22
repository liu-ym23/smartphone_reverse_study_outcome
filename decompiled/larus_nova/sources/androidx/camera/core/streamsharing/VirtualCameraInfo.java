package androidx.camera.core.streamsharing;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ForwardingCameraInfo;
import androidx.camera.core.impl.utils.TransformUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualCameraInfo extends ForwardingCameraInfo {
    private final String mVirtualCameraId;
    private int mVirtualCameraRotationDegrees;

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.mVirtualCameraId;
    }

    public VirtualCameraInfo(CameraInfoInternal r100) {
        super(r100);
        this.mVirtualCameraId = "virtual-" + r100.getCameraId() + "-" + UUID.randomUUID().toString();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int r100) {
        return TransformUtils.within360(super.getSensorRotationDegrees(r100) - this.mVirtualCameraRotationDegrees);
    }

    public void setVirtualCameraRotationDegrees(int r100) {
        this.mVirtualCameraRotationDegrees = r100;
    }
}
