package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicRangesCompat {
    private final DynamicRangeProfilesCompatImpl mImpl;

    public interface DynamicRangeProfilesCompatImpl {
        Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r100);

        Set<DynamicRange> getSupportedDynamicRanges();

        boolean isExtraLatencyPresent(DynamicRange r100);

        DynamicRangeProfiles unwrap();
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mImpl.getSupportedDynamicRanges();
    }

    public DynamicRangeProfiles toDynamicRangeProfiles() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.mImpl.unwrap();
    L5:
        r100 = false;
        goto L6
    }

    public DynamicRangesCompat(DynamicRangeProfilesCompatImpl r100) {
        this.mImpl = r100;
    }

    public static DynamicRangesCompat fromCameraCharacteristics(CameraCharacteristicsCompat r100) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        DynamicRangesCompat r101 = toDynamicRangesCompat((DynamicRangeProfiles) r100.get(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES));
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return DynamicRangesCompatBaseImpl.COMPAT_INSTANCE;
    L5:
        r101 = null;
        goto L6
    }

    public static DynamicRangesCompat toDynamicRangesCompat(DynamicRangeProfiles r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L8;
        boolean r101 = true;
    L9:
        Preconditions.checkState(r101, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new DynamicRangesCompat(new DynamicRangesCompatApi33Impl(r100));
    L8:
        r101 = false;
        goto L9
    }

    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r100) {
        return this.mImpl.getDynamicRangeCaptureRequestConstraints(r100);
    }

    public boolean isExtraLatencyPresent(DynamicRange r100) {
        return this.mImpl.isExtraLatencyPresent(r100);
    }
}
