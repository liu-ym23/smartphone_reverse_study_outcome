package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class AeFpsRangeLegacyQuirk implements Quirk {
    private final Range<Integer> mAeFpsRange;

    public Range<Integer> getRange() {
        return this.mAeFpsRange;
    }

    public AeFpsRangeLegacyQuirk(CameraCharacteristicsCompat r100) {
        this.mAeFpsRange = pickSuitableFpsRange((Range[]) r100.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    private Range<Integer> getCorrectedFpsRange(Range<Integer> r100) {
        int r101 = ((Integer) r100.getUpper()).intValue();
        int r102 = ((Integer) r100.getLower()).intValue();
        if (((Integer) r100.getUpper()).intValue() < 1000) goto L6;
        r101 = ((Integer) r100.getUpper()).intValue() / 1000;
    L6:
        if (((Integer) r100.getLower()).intValue() < 1000) goto L9;
        r102 = ((Integer) r100.getLower()).intValue() / 1000;
    L9:
        return new Range(Integer.valueOf(r102), Integer.valueOf(r101));
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        Integer r101 = (Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.intValue() != 2) goto L7;
        return true;
    }

    private Range<Integer> pickSuitableFpsRange(Range<Integer>[] r100) {
        Range<Integer> r101 = null;
        if (r100 != null) goto L5;
    L18:
        return r101;
    L5:
        if (r100.length == 0) goto L18;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L18;
        Range<Integer> r104 = getCorrectedFpsRange(r100[r103]);
        if (((Integer) r104.getUpper()).intValue() != 30) goto L17;
        if (r101 != null) goto L15;
    L16:
        r101 = r104;
        goto L17
    L15:
        if (((Integer) r104.getLower()).intValue() < ((Integer) r101.getLower()).intValue()) goto L16;
    L17:
        r103 = r103 + 1;
        goto L8
    }
}
