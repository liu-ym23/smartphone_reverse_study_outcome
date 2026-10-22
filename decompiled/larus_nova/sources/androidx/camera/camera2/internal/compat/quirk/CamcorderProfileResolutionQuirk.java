package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CamcorderProfileResolutionQuirk implements Quirk {
    private static final String TAG = "CamcorderProfileResolutionQuirk";
    private final StreamConfigurationMapCompat mStreamConfigurationMapCompat;
    private List<Size> mSupportedResolutions;

    public List<Size> getSupportedResolutions() {
        if (this.mSupportedResolutions != null) goto L10;
        Size[] r100 = this.mStreamConfigurationMapCompat.getOutputSizes(34);
        if (r100 == null) goto L7;
        List<Size> r101 = Arrays.asList((Size[]) r100.clone());
    L8:
        this.mSupportedResolutions = r101;
        Logger.d(TAG, "mSupportedResolutions = " + this.mSupportedResolutions);
        goto L10
    L7:
        r101 = Collections.emptyList();
    L10:
        return new ArrayList(this.mSupportedResolutions);
    }

    public CamcorderProfileResolutionQuirk(CameraCharacteristicsCompat r100) {
        this.mSupportedResolutions = null;
        this.mStreamConfigurationMapCompat = r100.getStreamConfigurationMapCompat();
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        Integer r101 = (Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.intValue() != 2) goto L7;
        return true;
    }
}
