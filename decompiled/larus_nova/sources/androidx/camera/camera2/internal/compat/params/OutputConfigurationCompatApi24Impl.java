package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    public static final class OutputConfigurationParamsApi24 {
        long mDynamicRangeProfile;
        boolean mIsShared;
        final OutputConfiguration mOutputConfiguration;
        String mPhysicalCameraId;

        public int hashCode() {
            int r100 = this.mOutputConfiguration.hashCode() ^ 31;
            int r101 = (r100 << 5) - r100;
            int r102 = (this.mIsShared ? 1 : 0) ^ r101;
            int r103 = (r102 << 5) - r102;
            String r104 = this.mPhysicalCameraId;
            if (r104 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = r105 ^ r103;
            int r107 = (r106 << 5) - r106;
            long r108 = this.mDynamicRangeProfile;
            return ((int) (r108 ^ (r108 >>> 32))) ^ r107;
        L5:
            r105 = r104.hashCode();
            goto L6
        }

        public OutputConfigurationParamsApi24(OutputConfiguration r100) {
            this.mDynamicRangeProfile = 1;
            this.mOutputConfiguration = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof OutputConfigurationParamsApi24) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi24 r101 = (OutputConfigurationParamsApi24) r100;
            if (Objects.equals(this.mOutputConfiguration, r101.mOutputConfiguration) == true) goto L8;
            return false;
        L8:
            if (this.mIsShared == r101.mIsShared) goto L10;
            return false;
        L10:
            if (this.mDynamicRangeProfile == r101.mDynamicRangeProfile) goto L12;
            return false;
        L12:
            if (Objects.equals(this.mPhysicalCameraId, r101.mPhysicalCameraId) == false) goto L18;
            return true;
        L18:
            return false;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaceGroupId();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public List<Surface> getSurfaces() {
        return Collections.singletonList(getSurface());
    }

    public OutputConfigurationCompatApi24Impl(Surface r100) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(r100)));
    }

    public static OutputConfigurationCompatApi24Impl wrap(OutputConfiguration r100) {
        return new OutputConfigurationCompatApi24Impl(new OutputConfigurationParamsApi24(r100));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r100) {
        ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r100) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = r100;
    }

    public OutputConfigurationCompatApi24Impl(Object r100) {
        super(r100);
    }

    public OutputConfigurationCompatApi24Impl(int r100, Surface r101) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(r100, r101)));
    }
}
