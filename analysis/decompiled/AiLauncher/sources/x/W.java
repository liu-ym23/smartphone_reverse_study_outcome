package x;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.pipe.compat.AndroidCameraState;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JK\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lx/W;", "", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDeviceWrapper", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "androidCameraState", "Landroidx/camera/camera2/pipe/compat/j;", "audioRestrictionController", "", "shouldReopenCamera", "shouldCreateEmptyCaptureSession", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Landroid/hardware/camera2/CameraDevice;Landroidx/camera/camera2/pipe/compat/AndroidCameraState;Landroidx/camera/camera2/pipe/compat/j;ZZ)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface W {
    static /* synthetic */ void b(W w10, androidx.camera.camera2.pipe.compat.p pVar, CameraDevice cameraDevice, AndroidCameraState androidCameraState, androidx.camera.camera2.pipe.compat.j jVar, boolean z10, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeCamera");
        }
        if ((i10 & 1) != 0) {
            pVar = null;
        }
        if ((i10 & 2) != 0) {
            cameraDevice = null;
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        if ((i10 & 32) != 0) {
            z11 = false;
        }
        w10.a(pVar, cameraDevice, androidCameraState, jVar, z10, z11);
    }

    void a(androidx.camera.camera2.pipe.compat.p cameraDeviceWrapper, CameraDevice cameraDevice, AndroidCameraState androidCameraState, androidx.camera.camera2.pipe.compat.j audioRestrictionController, boolean shouldReopenCamera, boolean shouldCreateEmptyCaptureSession);
}
