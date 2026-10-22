package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class AeFpsRange {
    private final Range<Integer> mAeTargetFpsRange;

    public AeFpsRange(Quirks r100) {
        AeFpsRangeLegacyQuirk r101 = (AeFpsRangeLegacyQuirk) r100.get(AeFpsRangeLegacyQuirk.class);
        if (r101 != null) goto L5;
        this.mAeTargetFpsRange = null;
        return;
    L5:
        this.mAeTargetFpsRange = r101.getRange();
    }

    public void addAeFpsRangeOptions(Camera2ImplConfig.Builder r100) {
        Range<Integer> r101 = this.mAeTargetFpsRange;
        if (r101 == null) goto L6;
        r100.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, r101, Config.OptionPriority.REQUIRED);
        return;
    }
}
