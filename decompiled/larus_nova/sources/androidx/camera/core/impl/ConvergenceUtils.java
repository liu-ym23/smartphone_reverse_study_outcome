package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ConvergenceUtils {
    private static final Set<CameraCaptureMetaData.AeState> AE_CONVERGED_STATE_SET = null;
    private static final Set<CameraCaptureMetaData.AeState> AE_TORCH_AS_FLASH_CONVERGED_STATE_SET = null;
    private static final Set<CameraCaptureMetaData.AfState> AF_CONVERGED_STATE_SET = null;
    private static final Set<CameraCaptureMetaData.AwbState> AWB_CONVERGED_STATE_SET = null;
    private static final String TAG = "ConvergenceUtils";

    static {
        AF_CONVERGED_STATE_SET = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AfState.PASSIVE_FOCUSED, CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED));
        AWB_CONVERGED_STATE_SET = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AwbState.CONVERGED, CameraCaptureMetaData.AwbState.UNKNOWN));
        CameraCaptureMetaData.AeState r100 = CameraCaptureMetaData.AeState.CONVERGED;
        CameraCaptureMetaData.AeState r101 = CameraCaptureMetaData.AeState.FLASH_REQUIRED;
        CameraCaptureMetaData.AeState r102 = CameraCaptureMetaData.AeState.UNKNOWN;
        Set<CameraCaptureMetaData.AeState> r103 = Collections.unmodifiableSet(EnumSet.of(r100, r101, r102));
        AE_CONVERGED_STATE_SET = r103;
        EnumSet r104 = EnumSet.copyOf(r103);
        r104.remove(r101);
        r104.remove(r102);
        AE_TORCH_AS_FLASH_CONVERGED_STATE_SET = Collections.unmodifiableSet(r104);
    }

    private ConvergenceUtils() {
    }

    public static boolean is3AConverged(CameraCaptureResult r100, boolean r101) {
        if (r100.getAfMode() != CameraCaptureMetaData.AfMode.OFF) goto L5;
    L10:
        boolean r102 = true;
    L12:
        if (r100.getAeMode() != CameraCaptureMetaData.AeMode.OFF) goto L14;
        boolean r103 = true;
    L15:
        if (r101 == false) goto L22;
        if (r103 == false) goto L18;
    L21:
        boolean r104 = true;
    L27:
        if (r100.getAwbMode() != CameraCaptureMetaData.AwbMode.OFF) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == false) goto L32;
    L35:
        boolean r106 = true;
    L36:
        Logger.d(TAG, "checkCaptureResult, AE=" + r100.getAeState() + " AF =" + r100.getAfState() + " AWB=" + r100.getAwbState());
        if (r102 == false) goto L42;
        if (r104 == false) goto L43;
        if (r106 == false) goto L44;
        return true;
    L44:
        return false;
    L43:
        return false;
    L42:
        return false;
    L32:
        if (AWB_CONVERGED_STATE_SET.contains(r100.getAwbState()) == true) goto L35;
        r106 = false;
        goto L36
    L29:
        r105 = false;
        goto L30
    L18:
        if (AE_TORCH_AS_FLASH_CONVERGED_STATE_SET.contains(r100.getAeState()) == true) goto L21;
    L20:
        r104 = false;
        goto L27
    L22:
        if (r103 == true) goto L21;
        if (AE_CONVERGED_STATE_SET.contains(r100.getAeState()) == false) goto L20;
    L14:
        r103 = false;
        goto L15
    L5:
        if (r100.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN) goto L10;
        if (AF_CONVERGED_STATE_SET.contains(r100.getAfState()) == true) goto L10;
        r102 = false;
        goto L12
    }
}
