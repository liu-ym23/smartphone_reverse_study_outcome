package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class TargetAspectRatio {
    public static final int RATIO_16_9 = 1;
    public static final int RATIO_4_3 = 0;
    public static final int RATIO_MAX_JPEG = 2;
    public static final int RATIO_ORIGINAL = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Ratio {
    }

    public TargetAspectRatio() {
    }

    public int get(String r100, CameraCharacteristicsCompat r101) {
        Nexus4AndroidLTargetAspectRatioQuirk r102 = (Nexus4AndroidLTargetAspectRatioQuirk) DeviceQuirks.get(Nexus4AndroidLTargetAspectRatioQuirk.class);
        if (r102 != null) goto L5;
        AspectRatioLegacyApi21Quirk r103 = (AspectRatioLegacyApi21Quirk) CameraQuirks.get(r100, r101).get(AspectRatioLegacyApi21Quirk.class);
        if (r103 != null) goto L9;
        return 3;
    L9:
        return r103.getCorrectedAspectRatio();
    L5:
        return r102.getCorrectedAspectRatio();
    }
}
