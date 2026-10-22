package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCapturePixelHDRPlus {
    public ImageCapturePixelHDRPlus() {
    }

    public void toggleHDRPlus(int r100, Camera2ImplConfig.Builder r101) {
        if (((ImageCapturePixelHDRPlusQuirk) DeviceQuirks.get(ImageCapturePixelHDRPlusQuirk.class)) != null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        r101.setCaptureRequestOption(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
        return;
    L7:
        if (r100 != 1) goto L13;
        r101.setCaptureRequestOption(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
        return;
    }
}
