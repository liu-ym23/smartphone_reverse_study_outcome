package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CameraCharacteristicsCompat {
    private final CameraCharacteristicsCompatImpl mCameraCharacteristicsImpl;
    private final String mCameraId;
    private StreamConfigurationMapCompat mStreamConfigurationMapCompat;
    private final Map<CameraCharacteristics.Key<?>, Object> mValuesCache;

    public interface CameraCharacteristicsCompatImpl {
        <T> T get(CameraCharacteristics.Key<T> r100);

        Set<String> getPhysicalCameraIds();

        CameraCharacteristics unwrap();
    }

    public Set<String> getPhysicalCameraIds() {
        return this.mCameraCharacteristicsImpl.getPhysicalCameraIds();
    }

    public StreamConfigurationMapCompat getStreamConfigurationMapCompat() {
        if (this.mStreamConfigurationMapCompat != null) goto L15;
        StreamConfigurationMap r100 = (StreamConfigurationMap) get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: AssertionError -> L9 Throwable -> L11
        if (r100 == null) goto L8;
        this.mStreamConfigurationMapCompat = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(r100, new OutputSizesCorrector(this.mCameraId));
        goto L15
    L8:
        throw new IllegalArgumentException("StreamConfigurationMap is null!");
    L11:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage());
    L15:
        return this.mStreamConfigurationMapCompat;
    }

    public boolean isZoomOverrideAvailable() {
        if (Build.VERSION.SDK_INT < 34) goto L12;
        int[] r100 = (int[]) this.mCameraCharacteristicsImpl.get(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
        if (r100 == null) goto L12;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L12;
        if (r100[r102] == 1) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    }

    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristicsImpl.unwrap();
    }

    private boolean isKeyNonCacheable(CameraCharacteristics.Key<?> r100) {
        return r100.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    public <T> T get(CameraCharacteristics.Key<T> r100) {
        if (isKeyNonCacheable(r100) == true) goto L5;
        monitor-enter(this);
        T r101 = (T) this.mValuesCache.get(r100);
        if (r101 == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L16
        return r101;
    L11:
        T r102 = (T) this.mCameraCharacteristicsImpl.get(r100);
        if (r102 == null) goto L14;
        this.mValuesCache.put((CameraCharacteristics.Key<?>) r100, r102);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r102;
    L16:
        th = move-exception;
        throw th;
    L5:
        return (T) this.mCameraCharacteristicsImpl.get(r100);
    }

    private CameraCharacteristicsCompat(CameraCharacteristics r100, String r101) {
        this.mValuesCache = new HashMap();
        this.mStreamConfigurationMapCompat = null;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mCameraCharacteristicsImpl = new CameraCharacteristicsApi28Impl(r100);
    L6:
        this.mCameraId = r101;
        return;
    L5:
        this.mCameraCharacteristicsImpl = new CameraCharacteristicsBaseImpl(r100);
        goto L6
    }

    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(CameraCharacteristics r100, String r101) {
        return new CameraCharacteristicsCompat(r100, r101);
    }
}
