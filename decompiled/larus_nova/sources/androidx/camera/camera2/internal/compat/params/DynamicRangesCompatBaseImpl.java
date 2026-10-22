package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class DynamicRangesCompatBaseImpl implements DynamicRangesCompat.DynamicRangeProfilesCompatImpl {
    static final DynamicRangesCompat COMPAT_INSTANCE = null;
    private static final Set<DynamicRange> SDR_ONLY = null;

    public DynamicRangesCompatBaseImpl() {
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public DynamicRangeProfiles unwrap() {
        return null;
    }

    static {
        COMPAT_INSTANCE = new DynamicRangesCompat(new DynamicRangesCompatBaseImpl());
        SDR_ONLY = Collections.singleton(DynamicRange.SDR);
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return SDR_ONLY;
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r100) {
        Preconditions.checkArgument(DynamicRange.SDR.equals(r100), "DynamicRange is not supported: " + r100);
        return SDR_ONLY;
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public boolean isExtraLatencyPresent(DynamicRange r100) {
        Preconditions.checkArgument(DynamicRange.SDR.equals(r100), "DynamicRange is not supported: " + r100);
        return false;
    }
}
