package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OutputConfigurationCompatApi33Impl extends OutputConfigurationCompatApi28Impl {
    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfiguration);
        return this.mObject;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfiguration) getOutputConfiguration()).getDynamicRangeProfile();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ int getMaxSharedSurfaceCount() {
        return super.getMaxSharedSurfaceCount();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMirrorMode() {
        return ((OutputConfiguration) getOutputConfiguration()).getMirrorMode();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ String getPhysicalCameraId() {
        return super.getPhysicalCameraId();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getStreamUseCase() {
        return ((OutputConfiguration) getOutputConfiguration()).getStreamUseCase();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ Surface getSurface() {
        return super.getSurface();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ int getSurfaceGroupId() {
        return super.getSurfaceGroupId();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ List getSurfaces() {
        return super.getSurfaces();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ void enableSurfaceSharing() {
        super.enableSurfaceSharing();
    }

    public OutputConfigurationCompatApi33Impl(Surface r100) {
        super(new OutputConfiguration(r100));
    }

    public static OutputConfigurationCompatApi33Impl wrap(OutputConfiguration r100) {
        return new OutputConfigurationCompatApi33Impl(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ void addSurface(Surface r100) {
        super.addSurface(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public /* bridge */ /* synthetic */ boolean equals(Object r100) {
        return super.equals(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ void removeSurface(Surface r100) {
        super.removeSurface(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r100) {
        ((OutputConfiguration) getOutputConfiguration()).setDynamicRangeProfile(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setMirrorMode(int r100) {
        ((OutputConfiguration) getOutputConfiguration()).setMirrorMode(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public /* bridge */ /* synthetic */ void setPhysicalCameraId(String r100) {
        super.setPhysicalCameraId(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setStreamUseCase(long r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        ((OutputConfiguration) getOutputConfiguration()).setStreamUseCase(r100);
    }

    public OutputConfigurationCompatApi33Impl(Object r100) {
        super(r100);
    }

    public OutputConfigurationCompatApi33Impl(int r100, Surface r101) {
        this(new OutputConfiguration(r100, r101));
    }
}
