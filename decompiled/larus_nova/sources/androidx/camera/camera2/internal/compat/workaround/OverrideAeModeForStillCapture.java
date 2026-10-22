package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class OverrideAeModeForStillCapture {
    private boolean mAePrecaptureStarted;
    private final boolean mHasAutoFlashUnderExposedQuirk;

    public void onAePrecaptureFinished() {
        this.mAePrecaptureStarted = false;
    }

    public void onAePrecaptureStarted() {
        this.mAePrecaptureStarted = true;
    }

    public OverrideAeModeForStillCapture(Quirks r100) {
        boolean r101 = false;
        this.mAePrecaptureStarted = false;
        if (r100.get(AutoFlashUnderExposedQuirk.class) == null) goto L5;
        r101 = true;
    L5:
        this.mHasAutoFlashUnderExposedQuirk = r101;
    }

    public boolean shouldSetAeModeAlwaysFlash(int r100) {
        if (this.mAePrecaptureStarted == false) goto L8;
        if (r100 != 0) goto L8;
        if (this.mHasAutoFlashUnderExposedQuirk == false) goto L8;
        return true;
    L8:
        return false;
    }
}
