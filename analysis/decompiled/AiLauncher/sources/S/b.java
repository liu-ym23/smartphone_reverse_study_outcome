package S;

import androidx.camera.core.i;
import androidx.camera.core.impl.l;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.utils.ImageUtil;

/* loaded from: classes.dex */
public class b {
    public boolean a() {
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk) R.c.b(ImageCaptureRotationOptionQuirk.class);
        return imageCaptureRotationOptionQuirk == null || imageCaptureRotationOptionQuirk.e(l.f11441i);
    }

    public boolean b(i iVar) {
        return a() && ImageUtil.h(iVar.getFormat());
    }
}
