package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewPixelHDRnet {
    public static final Rational ASPECT_RATIO_16_9 = null;

    static {
        ASPECT_RATIO_16_9 = new Rational(16, 9);
    }

    private PreviewPixelHDRnet() {
    }

    private static boolean isAspectRatioMatch(Size r100, Rational r101) {
        return r101.equals(new Rational(r100.getWidth(), r100.getHeight()));
    }

    public static void setHDRnet(Size r100, SessionConfig.Builder r101) {
        if (((PreviewPixelHDRnetQuirk) DeviceQuirks.get(PreviewPixelHDRnetQuirk.class)) != null) goto L6;
        return;
    L6:
        if (isAspectRatioMatch(r100, ASPECT_RATIO_16_9) == false) goto L8;
        return;
    L8:
        Camera2ImplConfig.Builder r102 = new Camera2ImplConfig.Builder();
        r102.setCaptureRequestOption(CaptureRequest.TONEMAP_MODE, 2);
        r101.addImplementationOptions(r102.build());
    }
}
