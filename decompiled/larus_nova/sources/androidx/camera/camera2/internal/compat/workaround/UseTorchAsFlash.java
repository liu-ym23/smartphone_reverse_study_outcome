package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class UseTorchAsFlash {
    private final boolean mHasUseTorchAsFlashQuirk;

    public boolean shouldUseTorchAsFlash() {
        return this.mHasUseTorchAsFlashQuirk;
    }

    public UseTorchAsFlash(Quirks r100) {
        this.mHasUseTorchAsFlashQuirk = r100.contains(UseTorchAsFlashQuirk.class);
    }
}
