package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class CameraCharacteristicsBaseImpl implements CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl {
    protected final CameraCharacteristics mCameraCharacteristics;

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    public Set<String> getPhysicalCameraIds() {
        return Collections.emptySet();
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    public CameraCharacteristics unwrap() {
        return this.mCameraCharacteristics;
    }

    public CameraCharacteristicsBaseImpl(CameraCharacteristics r100) {
        this.mCameraCharacteristics = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    public <T> T get(CameraCharacteristics.Key<T> r100) {
        return (T) this.mCameraCharacteristics.get(r100);
    }
}
