package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class DynamicRangesCompatApi33Impl implements DynamicRangesCompat.DynamicRangeProfilesCompatImpl {
    private final DynamicRangeProfiles mDynamicRangeProfiles;

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return profileSetToDynamicRangeSet(this.mDynamicRangeProfiles.getSupportedProfiles());
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public DynamicRangeProfiles unwrap() {
        return this.mDynamicRangeProfiles;
    }

    public DynamicRangesCompatApi33Impl(Object r100) {
        this.mDynamicRangeProfiles = (DynamicRangeProfiles) r100;
    }

    private Long dynamicRangeToFirstSupportedProfile(DynamicRange r100) {
        return DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(r100, this.mDynamicRangeProfiles);
    }

    private static Set<DynamicRange> profileSetToDynamicRangeSet(Set<Long> r100) {
        if (r100.isEmpty() == true) goto L5;
        HashSet r101 = new HashSet(r100.size());
        Iterator<Long> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        r101.add(profileToDynamicRange(r102.next().longValue()));
        goto L8
    L11:
        return Collections.unmodifiableSet(r101);
    L5:
        return Collections.emptySet();
    }

    private static DynamicRange profileToDynamicRange(long r100) {
        return (DynamicRange) Preconditions.checkNotNull(DynamicRangeConversions.profileToDynamicRange(r100), "Dynamic range profile cannot be converted to a DynamicRange object: " + r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r100) {
        Long r101 = dynamicRangeToFirstSupportedProfile(r100);
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "DynamicRange is not supported: " + r100);
        return profileSetToDynamicRangeSet(this.mDynamicRangeProfiles.getProfileCaptureRequestConstraints(r101.longValue()));
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public boolean isExtraLatencyPresent(DynamicRange r100) {
        Long r101 = dynamicRangeToFirstSupportedProfile(r100);
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "DynamicRange is not supported: " + r100);
        return this.mDynamicRangeProfiles.isExtraLatencyPresent(r101.longValue());
    L5:
        r102 = false;
        goto L6
    }
}
