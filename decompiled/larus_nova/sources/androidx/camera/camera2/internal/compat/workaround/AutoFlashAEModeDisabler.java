package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class AutoFlashAEModeDisabler {
    private final boolean mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled;
    private final boolean mIsImageCaptureFailWithAutoFlashQuirkEnabled;

    public AutoFlashAEModeDisabler(Quirks r100) {
        this.mIsImageCaptureFailWithAutoFlashQuirkEnabled = r100.contains(ImageCaptureFailWithAutoFlashQuirk.class);
        if (DeviceQuirks.get(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) == null) goto L5;
        boolean r101 = true;
    L6:
        this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public int getCorrectedAeMode(int r100) {
        if (this.mIsImageCaptureFailWithAutoFlashQuirkEnabled == true) goto L7;
        if (this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled == true) goto L7;
        return r100;
    L7:
        if (r100 != 2) goto L11;
        return 1;
    L11:
        return r100;
    }
}
