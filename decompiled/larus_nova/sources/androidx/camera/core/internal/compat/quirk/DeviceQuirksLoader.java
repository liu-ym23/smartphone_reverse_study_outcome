package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings r100) {
        ArrayList r101 = new ArrayList();
        if (r100.shouldEnableQuirk(ImageCaptureRotationOptionQuirk.class, ImageCaptureRotationOptionQuirk.load()) == false) goto L6;
        r101.add(new ImageCaptureRotationOptionQuirk());
    L6:
        if (r100.shouldEnableQuirk(SurfaceOrderQuirk.class, SurfaceOrderQuirk.load()) == false) goto L9;
        r101.add(new SurfaceOrderQuirk());
    L9:
        if (r100.shouldEnableQuirk(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.load()) == false) goto L12;
        r101.add(new CaptureFailedRetryQuirk());
    L12:
        if (r100.shouldEnableQuirk(LowMemoryQuirk.class, LowMemoryQuirk.load()) == false) goto L15;
        r101.add(new LowMemoryQuirk());
    L15:
        if (r100.shouldEnableQuirk(LargeJpegImageQuirk.class, LargeJpegImageQuirk.load()) == false) goto L18;
        r101.add(new LargeJpegImageQuirk());
    L18:
        if (r100.shouldEnableQuirk(IncorrectJpegMetadataQuirk.class, IncorrectJpegMetadataQuirk.load()) == false) goto L20;
        r101.add(new IncorrectJpegMetadataQuirk());
    L20:
        return r101;
    }
}
