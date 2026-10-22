package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class UseFlashModeTorchFor3aUpdate {
    private static final String TAG = "UseFlashModeTorchFor3aUpdate";
    private final TorchFlashRequiredFor3aUpdateQuirk mTorchFlashRequiredFor3AUpdateQuirk;

    public boolean shouldUseFlashModeTorch() {
        TorchFlashRequiredFor3aUpdateQuirk r100 = this.mTorchFlashRequiredFor3AUpdateQuirk;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Logger.d(TAG, "shouldUseFlashModeTorch: " + r101);
        return r101;
    L5:
        if (r100.isFlashModeTorchRequired() == false) goto L7;
        r101 = true;
        goto L8
    }

    public UseFlashModeTorchFor3aUpdate(Quirks r100) {
        this.mTorchFlashRequiredFor3AUpdateQuirk = (TorchFlashRequiredFor3aUpdateQuirk) r100.get(TorchFlashRequiredFor3aUpdateQuirk.class);
    }
}
