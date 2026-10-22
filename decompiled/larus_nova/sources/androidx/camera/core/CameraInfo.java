package androidx.camera.core;

import android.util.Range;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.internal.compat.MediaActionSoundCompat;
import androidx.lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraInfo {
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;

    /* JADX INFO: renamed from: androidx.camera.core.CameraInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static float $default$getIntrinsicZoomRatio(CameraInfo r100) {
            return 1.0f;
        }

        public static int $default$getLensFacing(CameraInfo r100) {
            return -1;
        }

        public static boolean $default$isFocusMeteringSupported(CameraInfo r100, FocusMeteringAction r101) {
            return false;
        }

        public static boolean $default$isLogicalMultiCameraSupported(CameraInfo r100) {
            return false;
        }

        public static boolean $default$isPrivateReprocessingSupported(CameraInfo r100) {
            return false;
        }

        public static boolean $default$isZslSupported(CameraInfo r100) {
            return false;
        }

        public static boolean mustPlayShutterSound() {
            return MediaActionSoundCompat.mustPlayShutterSound();
        }

        public static Set $default$getPhysicalCameraInfos(CameraInfo r100) {
            return Collections.emptySet();
        }

        public static Set $default$getSupportedFrameRateRanges(CameraInfo r100) {
            return Collections.emptySet();
        }

        public static Set $default$querySupportedDynamicRanges(CameraInfo r100, Set r101) {
            return DynamicRanges.findAllPossibleMatches(r101, Collections.singleton(DynamicRange.SDR));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImplementationType {
    }

    CameraSelector getCameraSelector();

    LiveData<CameraState> getCameraState();

    ExposureState getExposureState();

    String getImplementationType();

    float getIntrinsicZoomRatio();

    int getLensFacing();

    Set<CameraInfo> getPhysicalCameraInfos();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int r100);

    Set<Range<Integer>> getSupportedFrameRateRanges();

    LiveData<Integer> getTorchState();

    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    boolean isFocusMeteringSupported(FocusMeteringAction r100);

    boolean isLogicalMultiCameraSupported();

    boolean isPrivateReprocessingSupported();

    boolean isZslSupported();

    Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> r100);
}
