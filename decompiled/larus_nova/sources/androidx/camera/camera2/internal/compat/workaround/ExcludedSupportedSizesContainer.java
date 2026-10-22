package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExcludedSupportedSizesContainer {
    private final String mCameraId;

    public ExcludedSupportedSizesContainer(String r100) {
        this.mCameraId = r100;
    }

    public List<Size> get(int r100) {
        ExcludedSupportedSizesQuirk r101 = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (r101 != null) goto L7;
        return new ArrayList();
    L7:
        return r101.getExcludedSizes(this.mCameraId, r100);
    }

    public List<Size> get(Class<?> r100) {
        ExcludedSupportedSizesQuirk r101 = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (r101 != null) goto L7;
        return new ArrayList();
    L7:
        return r101.getExcludedSizes(this.mCameraId, r100);
    }
}
