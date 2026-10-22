package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class SupportedRepeatingSurfaceSize {
    private static final Size MINI_PREVIEW_SIZE_HUAWEI_MATE_9 = null;
    private static final Comparator<Size> SIZE_COMPARATOR = null;
    private final RepeatingStreamConstraintForVideoRecordingQuirk mQuirk;

    static {
        MINI_PREVIEW_SIZE_HUAWEI_MATE_9 = new Size(320, 240);
        SIZE_COMPARATOR = new CompareSizesByArea();
    }

    public SupportedRepeatingSurfaceSize() {
        this.mQuirk = (RepeatingStreamConstraintForVideoRecordingQuirk) DeviceQuirks.get(RepeatingStreamConstraintForVideoRecordingQuirk.class);
    }

    public Size[] getSupportedSizes(Size[] r100) {
        if (this.mQuirk != null) goto L5;
        return r100;
    L5:
        if (RepeatingStreamConstraintForVideoRecordingQuirk.isHuaweiMate9() == false) goto L18;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        Size r104 = r100[r103];
        if (SIZE_COMPARATOR.compare(r104, MINI_PREVIEW_SIZE_HUAWEI_MATE_9) < 0) goto L11;
        r101.add(r104);
    L11:
        r103 = r103 + 1;
        goto L7
    L13:
        return (Size[]) r101.toArray(new Size[0]);
    L18:
        return r100;
    }
}
