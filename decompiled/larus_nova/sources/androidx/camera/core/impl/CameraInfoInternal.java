package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraInfoInternal extends CameraInfo {

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraInfoInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static CameraInfoInternal $default$getImplementation(CameraInfoInternal r100) {
            return r100;
        }

        public static boolean $default$isCaptureProcessProgressSupported(CameraInfoInternal r100) {
            return false;
        }

        public static boolean $default$isPostviewSupported(CameraInfoInternal r100) {
            return false;
        }

        public static CameraSelector $default$getCameraSelector(final CameraInfoInternal r100) {
            return new CameraSelector.Builder().addCameraFilter(new d(r100)).addCameraFilter(new LensFacingCameraFilter(r100.getLensFacing())).build();
        }

        public static /* synthetic */ List $private$lambda$getCameraSelector$0(CameraInfoInternal r100, List r101) {
            String r102 = r100.getCameraId();
            Iterator r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L10;
            CameraInfo r104 = (CameraInfo) r103.next();
            Preconditions.checkArgument(r104 instanceof CameraInfoInternal);
            if (((CameraInfoInternal) r104).getCameraId().equals(r102) == false) goto L4;
            return Collections.singletonList(r104);
        L10:
            throw new IllegalStateException("Unable to find camera with id " + r102 + " from list of available cameras.");
        }
    }

    void addSessionCaptureCallback(Executor r100, CameraCaptureCallback r101);

    Object getCameraCharacteristics();

    String getCameraId();

    Quirks getCameraQuirks();

    @Override // androidx.camera.core.CameraInfo
    CameraSelector getCameraSelector();

    EncoderProfilesProvider getEncoderProfilesProvider();

    CameraInfoInternal getImplementation();

    Object getPhysicalCameraCharacteristics(String r100);

    Set<DynamicRange> getSupportedDynamicRanges();

    List<Size> getSupportedHighResolutions(int r100);

    Set<Integer> getSupportedOutputFormats();

    List<Size> getSupportedResolutions(int r100);

    Timebase getTimebase();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();

    boolean isPreviewStabilizationSupported();

    boolean isVideoStabilizationSupported();

    void removeSessionCaptureCallback(CameraCaptureCallback r100);
}
