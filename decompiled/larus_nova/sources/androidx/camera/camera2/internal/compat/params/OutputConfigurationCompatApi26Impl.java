package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class OutputConfigurationCompatApi26Impl extends OutputConfigurationCompatApi24Impl {
    private static final String MAX_SHARED_SURFACES_COUNT_FIELD = "MAX_SURFACES_COUNT";
    private static final String SURFACES_FIELD = "mSurfaces";

    public static final class OutputConfigurationParamsApi26 {
        long mDynamicRangeProfile;
        final OutputConfiguration mOutputConfiguration;
        String mPhysicalCameraId;

        public int hashCode() {
            int r100 = this.mOutputConfiguration.hashCode() ^ 31;
            int r101 = (r100 << 5) - r100;
            String r102 = this.mPhysicalCameraId;
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = r103 ^ r101;
            int r105 = (r104 << 5) - r104;
            long r106 = this.mDynamicRangeProfile;
            return ((int) (r106 ^ (r106 >>> 32))) ^ r105;
        L5:
            r103 = r102.hashCode();
            goto L6
        }

        public OutputConfigurationParamsApi26(OutputConfiguration r100) {
            this.mDynamicRangeProfile = 1;
            this.mOutputConfiguration = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof OutputConfigurationParamsApi26) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi26 r101 = (OutputConfigurationParamsApi26) r100;
            if (Objects.equals(this.mOutputConfiguration, r101.mOutputConfiguration) == true) goto L8;
            return false;
        L8:
            if (this.mDynamicRangeProfile == r101.mDynamicRangeProfile) goto L10;
            return false;
        L10:
            if (Objects.equals(this.mPhysicalCameraId, r101.mPhysicalCameraId) == false) goto L15;
            return true;
        L15:
            return false;
        }
    }

    private static int getMaxSharedSurfaceCountApi26() throws NoSuchFieldException, IllegalAccessException {
        Field r100 = OutputConfiguration.class.getDeclaredField(MAX_SHARED_SURFACES_COUNT_FIELD);
        r100.setAccessible(true);
        return r100.getInt(null);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi26) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi26);
        return ((OutputConfigurationParamsApi26) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi26) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final boolean isSurfaceSharingEnabled() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfiguration) getOutputConfiguration()).enableSurfaceSharing();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return getMaxSharedSurfaceCountApi26();
    L6:
        e = move-exception;
        Logger.e("OutputConfigCompat", "Unable to retrieve max shared surface count.", e);
        return super.getMaxSharedSurfaceCount();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public List<Surface> getSurfaces() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaces();
    }

    public OutputConfigurationCompatApi26Impl(Surface r100) {
        this(new OutputConfigurationParamsApi26(new OutputConfiguration(r100)));
    }

    private static List<Surface> getMutableSurfaceListApi26(OutputConfiguration r100) throws NoSuchFieldException, IllegalAccessException {
        Field r101 = OutputConfiguration.class.getDeclaredField(SURFACES_FIELD);
        r101.setAccessible(true);
        return (List) r101.get(r100);
    }

    public static OutputConfigurationCompatApi26Impl wrap(OutputConfiguration r100) {
        return new OutputConfigurationCompatApi26Impl(new OutputConfigurationParamsApi26(r100));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(Surface r100) {
        ((OutputConfiguration) getOutputConfiguration()).addSurface(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(Surface r100) {
        if (getSurface() == r100) goto L15;
    L11:
        e = move-exception;
        Logger.e("OutputConfigCompat", "Unable to remove surface from this output configuration.", e);
        return;
    L5:
        if (getMutableSurfaceListApi26((OutputConfiguration) getOutputConfiguration()).remove(r100) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Surface is not part of this output configuration");     // Catch: NoSuchFieldException -> L9 Throwable -> L11
    L15:
        throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r100) {
        ((OutputConfigurationParamsApi26) this.mObject).mDynamicRangeProfile = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r100) {
        ((OutputConfigurationParamsApi26) this.mObject).mPhysicalCameraId = r100;
    }

    public OutputConfigurationCompatApi26Impl(Object r100) {
        super(r100);
    }

    public OutputConfigurationCompatApi26Impl(int r100, Surface r101) {
        this(new OutputConfigurationParamsApi26(new OutputConfiguration(r100, r101)));
    }
}
