package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.utils.ImageUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ExifRotationAvailability {
    public ExifRotationAvailability() {
    }

    public boolean isRotationOptionSupported() {
        ImageCaptureRotationOptionQuirk r100 = (ImageCaptureRotationOptionQuirk) DeviceQuirks.get(ImageCaptureRotationOptionQuirk.class);
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isSupported(CaptureConfig.OPTION_ROTATION) == true) goto L8;
        return false;
    }

    public boolean shouldUseExifOrientation(ImageProxy r100) {
        if (isRotationOptionSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (ImageUtil.isJpegFormats(r100.getFormat()) == false) goto L7;
        return true;
    }
}
