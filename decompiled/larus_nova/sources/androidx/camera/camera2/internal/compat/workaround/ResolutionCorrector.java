package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResolutionCorrector {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public ResolutionCorrector() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    public ResolutionCorrector(ExtraCroppingQuirk r100) {
        this.mExtraCroppingQuirk = r100;
    }

    public List<Size> insertOrPrioritize(SurfaceConfig.ConfigType r100, List<Size> r101) {
        ExtraCroppingQuirk r102 = this.mExtraCroppingQuirk;
        if (r102 != null) goto L5;
        return r101;
    L5:
        Size r103 = r102.getVerifiedResolution(r100);
        if (r103 != null) goto L8;
        return r101;
    L8:
        ArrayList r104 = new ArrayList();
        r104.add(r103);
        Iterator<Size> r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Size r106 = r105.next();
        if (r106.equals(r103) == true) goto L10;
        r104.add(r106);
        goto L10
    L14:
        return r104;
    }
}
