package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StillCaptureFlow {
    private final boolean mShouldStopRepeatingBeforeStillCapture;

    public StillCaptureFlow() {
        if (((StillCaptureFlashStopRepeatingQuirk) DeviceQuirks.get(StillCaptureFlashStopRepeatingQuirk.class)) == null) goto L5;
        boolean r100 = true;
    L6:
        this.mShouldStopRepeatingBeforeStillCapture = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public boolean shouldStopRepeatingBeforeCapture(List<CaptureRequest> r100, boolean r101) {
        if (this.mShouldStopRepeatingBeforeStillCapture == false) goto L15;
        if (r101 == false) goto L15;
        Iterator<CaptureRequest> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        int r103 = ((Integer) r102.next().get(CaptureRequest.CONTROL_AE_MODE)).intValue();
        if (r103 == 2) goto L13;
        if (r103 != 3) goto L8;
        return true;
    L13:
        return true;
    L15:
        return false;
    }
}
