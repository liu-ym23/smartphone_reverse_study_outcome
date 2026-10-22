package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class OutputConfigurationCompatApi28Impl extends OutputConfigurationCompatApi26Impl {

    public static final class OutputConfigurationParamsApi28 {
        long mDynamicRangeProfile;
        final OutputConfiguration mOutputConfiguration;

        public int hashCode() {
            int r100 = this.mOutputConfiguration.hashCode() ^ 31;
            int r101 = (r100 << 5) - r100;
            long r102 = this.mDynamicRangeProfile;
            return ((int) (r102 ^ (r102 >>> 32))) ^ r101;
        }

        public OutputConfigurationParamsApi28(OutputConfiguration r100) {
            this.mDynamicRangeProfile = 1;
            this.mOutputConfiguration = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof OutputConfigurationParamsApi28) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi28 r101 = (OutputConfigurationParamsApi28) r100;
            if (Objects.equals(this.mOutputConfiguration, r101.mOutputConfiguration) == true) goto L8;
            return false;
        L8:
            if (this.mDynamicRangeProfile != r101.mDynamicRangeProfile) goto L12;
            return true;
        L12:
            return false;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi28);
        return ((OutputConfigurationParamsApi28) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return ((OutputConfiguration) getOutputConfiguration()).getMaxSharedSurfaceCount();
    }

    public OutputConfigurationCompatApi28Impl(Surface r100) {
        this(new OutputConfigurationParamsApi28(new OutputConfiguration(r100)));
    }

    public static OutputConfigurationCompatApi28Impl wrap(OutputConfiguration r100) {
        return new OutputConfigurationCompatApi28Impl(new OutputConfigurationParamsApi28(r100));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(Surface r100) {
        ((OutputConfiguration) getOutputConfiguration()).removeSurface(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r100) {
        ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r100) {
        ((OutputConfiguration) getOutputConfiguration()).setPhysicalCameraId(r100);
    }

    public OutputConfigurationCompatApi28Impl(Object r100) {
        super(r100);
    }

    public OutputConfigurationCompatApi28Impl(int r100, Surface r101) {
        this(new OutputConfigurationParamsApi28(new OutputConfiguration(r100, r101)));
    }
}
