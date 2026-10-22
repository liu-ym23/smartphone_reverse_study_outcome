package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;

/* JADX INFO: loaded from: classes2.dex */
public class DisplaySizeCorrector {
    private final SmallDisplaySizeQuirk mSmallDisplaySizeQuirk;

    public Size getDisplaySize() {
        SmallDisplaySizeQuirk r100 = this.mSmallDisplaySizeQuirk;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDisplaySize();
    }

    public DisplaySizeCorrector() {
        this.mSmallDisplaySizeQuirk = (SmallDisplaySizeQuirk) DeviceQuirks.get(SmallDisplaySizeQuirk.class);
    }
}
