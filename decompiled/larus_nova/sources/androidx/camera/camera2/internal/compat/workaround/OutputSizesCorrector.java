package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OutputSizesCorrector {
    private static final String TAG = "OutputSizesCorrector";
    private final String mCameraId;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final ExtraSupportedOutputSizeQuirk mExtraSupportedOutputSizeQuirk;

    public OutputSizesCorrector(String r100) {
        this.mExtraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.get(ExtraSupportedOutputSizeQuirk.class);
        this.mCameraId = r100;
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(r100);
    }

    private void addExtraSupportedOutputSizesByClass(List<Size> r100, Class<?> r101) {
        ExtraSupportedOutputSizeQuirk r102 = this.mExtraSupportedOutputSizeQuirk;
        if (r102 != null) goto L5;
        return;
    L5:
        Size[] r103 = r102.getExtraSupportedResolutions(r101);
        if (r103.length <= 0) goto L9;
        r100.addAll(Arrays.asList(r103));
        return;
    }

    private void addExtraSupportedOutputSizesByFormat(List<Size> r100, int r101) {
        ExtraSupportedOutputSizeQuirk r102 = this.mExtraSupportedOutputSizeQuirk;
        if (r102 != null) goto L5;
        return;
    L5:
        Size[] r103 = r102.getExtraSupportedResolutions(r101);
        if (r103.length <= 0) goto L9;
        r100.addAll(Arrays.asList(r103));
        return;
    }

    private void excludeProblematicOutputSizesByClass(List<Size> r100, Class<?> r101) {
        List<Size> r102 = this.mExcludedSupportedSizesContainer.get(r101);
        if (r102.isEmpty() == false) goto L5;
        return;
    L5:
        r100.removeAll(r102);
    }

    private void excludeProblematicOutputSizesByFormat(List<Size> r100, int r101) {
        List<Size> r102 = this.mExcludedSupportedSizesContainer.get(r101);
        if (r102.isEmpty() == false) goto L5;
        return;
    L5:
        r100.removeAll(r102);
    }

    public Size[] applyQuirks(Size[] r100, int r101) {
        ArrayList r102 = new ArrayList(Arrays.asList(r100));
        addExtraSupportedOutputSizesByFormat(r102, r101);
        excludeProblematicOutputSizesByFormat(r102, r101);
        if (r102.isEmpty() == false) goto L6;
        Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
    L6:
        return (Size[]) r102.toArray(new Size[0]);
    }

    public <T> Size[] applyQuirks(Size[] r100, Class<T> r101) {
        ArrayList r102 = new ArrayList(Arrays.asList(r100));
        addExtraSupportedOutputSizesByClass(r102, r101);
        excludeProblematicOutputSizesByClass(r102, r101);
        if (r102.isEmpty() == false) goto L6;
        Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
    L6:
        return (Size[]) r102.toArray(new Size[0]);
    }
}
