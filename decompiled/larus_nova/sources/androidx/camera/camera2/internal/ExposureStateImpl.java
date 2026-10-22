package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.ExposureState;

/* JADX INFO: loaded from: classes2.dex */
class ExposureStateImpl implements ExposureState {
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private int mExposureCompensation;
    private final Object mLock;

    @Override // androidx.camera.core.ExposureState
    public int getExposureCompensationIndex() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mExposureCompensation;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ExposureState
    public Range<Integer> getExposureCompensationRange() {
        return (Range) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
    }

    @Override // androidx.camera.core.ExposureState
    public boolean isExposureCompensationSupported() {
        Range r100 = (Range) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (((Integer) r100.getLower()).intValue() == 0) goto L9;
        if (((Integer) r100.getUpper()).intValue() == 0) goto L9;
        return true;
    }

    @Override // androidx.camera.core.ExposureState
    public Rational getExposureCompensationStep() {
        if (isExposureCompensationSupported() == true) goto L7;
        return Rational.ZERO;
    L7:
        return (Rational) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
    }

    public void setExposureCompensationIndex(int r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mExposureCompensation = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ExposureStateImpl(CameraCharacteristicsCompat r100, int r101) {
        this.mLock = new Object();
        this.mCameraCharacteristics = r100;
        this.mExposureCompensation = r101;
    }
}
