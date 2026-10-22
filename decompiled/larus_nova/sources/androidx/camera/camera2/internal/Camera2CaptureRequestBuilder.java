package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class Camera2CaptureRequestBuilder {
    private static final String TAG = "Camera2CaptureRequestBuilder";

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static CaptureRequest.Builder createReprocessCaptureRequest(CameraDevice r100, TotalCaptureResult r101) throws CameraAccessException {
            return r100.createReprocessCaptureRequest(r101);
        }
    }

    private Camera2CaptureRequestBuilder() {
    }

    private static void applyAeFpsRange(CaptureConfig r100, CaptureRequest.Builder r101) {
        if (r100.getExpectedFrameRateRange().equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED) == true) goto L6;
        r101.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, r100.getExpectedFrameRateRange());
        return;
    }

    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder r100, Config r101) {
        CaptureRequestOptions r102 = CaptureRequestOptions.Builder.from(r101).build();
        Iterator r103 = r102.listOptions().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Config.Option r104 = (Config.Option) r103.next();
        CaptureRequest.Key r105 = (CaptureRequest.Key) r104.getToken();
        r100.set(r105, r102.retrieveOption(r104));     // Catch: IllegalArgumentException -> L8
    L8:
        Logger.e(TAG, "CaptureRequest.Key is not supported: " + r105);
        goto L4
    }

    public static void applyVideoStabilization(CaptureConfig r100, CaptureRequest.Builder r101) {
        if (r100.getPreviewStabilizationMode() != 1) goto L5;
    L13:
        r101.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        return;
    L5:
        if (r100.getVideoStabilizationMode() == 1) goto L13;
        if (r100.getPreviewStabilizationMode() != 2) goto L11;
        r101.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        return;
    L11:
        if (r100.getVideoStabilizationMode() != 2) goto L16;
        r101.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        return;
    }

    private static List<Surface> getConfiguredSurfaces(List<DeferrableSurface> r100, Map<DeferrableSurface, Surface> r101) {
        ArrayList r102 = new ArrayList();
        Iterator<DeferrableSurface> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Surface r104 = r101.get(r103.next());
        if (r104 == null) goto L9;
        r102.add(r104);
        goto L4
    L9:
        throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
    L10:
        return r102;
    }

    private static void applyTemplateParamsOverrideWorkaround(CaptureRequest.Builder r100, int r101, TemplateParamsOverride r102) {
        Iterator<Map.Entry<CaptureRequest.Key<?>, Object>> r103 = r102.getOverrideParams(r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<CaptureRequest.Key<?>, Object> r104 = r103.next();
        r100.set(r104.getKey(), r104.getValue());
        goto L4
    }

    public static CaptureRequest buildWithoutTarget(CaptureConfig r100, CameraDevice r101, TemplateParamsOverride r102) throws CameraAccessException {
        if (r101 != null) goto L5;
        return null;
    L5:
        Logger.d(TAG, "template type = " + r100.getTemplateType());
        CaptureRequest.Builder r103 = r101.createCaptureRequest(r100.getTemplateType());
        applyTemplateParamsOverrideWorkaround(r103, r100.getTemplateType(), r102);
        applyImplementationOptionToCaptureBuilder(r103, r100.getImplementationOptions());
        return r103.build();
    }

    public static CaptureRequest build(CaptureConfig r100, CameraDevice r101, Map<DeferrableSurface, Surface> r102, boolean r103, TemplateParamsOverride r104) throws CameraAccessException {
        if (r101 != null) goto L5;
        return null;
    L5:
        List<Surface> r105 = getConfiguredSurfaces(r100.getSurfaces(), r102);
        if (r105.isEmpty() == false) goto L8;
        return null;
    L8:
        CameraCaptureResult r106 = r100.getCameraCaptureResult();
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L16:
        Logger.d(TAG, "createCaptureRequest");
        if (r100.getTemplateType() != 5) goto L22;
        if (r103 == false) goto L20;
        int r107 = 1;
    L21:
        CaptureRequest.Builder r108 = r101.createCaptureRequest(r107);
    L23:
        applyTemplateParamsOverrideWorkaround(r108, r100.getTemplateType(), r104);
        applyAeFpsRange(r100, r108);
        applyVideoStabilization(r100, r108);
        Config r109 = r100.getImplementationOptions();
        Config.Option<Integer> r110 = CaptureConfig.OPTION_ROTATION;
        if (r109.containsOption(r110) == false) goto L26;
        r108.set(CaptureRequest.JPEG_ORIENTATION, (Integer) r100.getImplementationOptions().retrieveOption(r110));
    L26:
        Config r111 = r100.getImplementationOptions();
        Config.Option<Integer> r112 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (r111.containsOption(r112) == false) goto L29;
        r108.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) r100.getImplementationOptions().retrieveOption(r112)).byteValue()));
    L29:
        applyImplementationOptionToCaptureBuilder(r108, r100.getImplementationOptions());
        Iterator<Surface> r113 = r105.iterator();
    L31:
        if (r113.hasNext() == false) goto L33;
        r108.addTarget(r113.next());
        goto L31
    L33:
        r108.setTag(r100.getTagBundle());
        return r108.build();
    L20:
        r107 = 2;
        goto L21
    L22:
        r108 = r101.createCaptureRequest(r100.getTemplateType());
        goto L23
    L11:
        if (r100.getTemplateType() != 5) goto L16;
        if (r106 == null) goto L16;
        if ((r106.getCaptureResult() instanceof TotalCaptureResult) == false) goto L16;
        Logger.d(TAG, "createReprocessCaptureRequest");
        r108 = Api23Impl.createReprocessCaptureRequest(r101, (TotalCaptureResult) r106.getCaptureResult());
        goto L23
    }
}
