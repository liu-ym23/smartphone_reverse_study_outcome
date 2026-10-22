package androidx.camera.view.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings r100) {
        ArrayList r101 = new ArrayList();
        if (r100.shouldEnableQuirk(SurfaceViewStretchedQuirk.class, SurfaceViewStretchedQuirk.load()) == false) goto L6;
        r101.add(new SurfaceViewStretchedQuirk());
    L6:
        if (r100.shouldEnableQuirk(SurfaceViewNotCroppedByParentQuirk.class, SurfaceViewNotCroppedByParentQuirk.load()) == false) goto L8;
        r101.add(new SurfaceViewNotCroppedByParentQuirk());
    L8:
        return r101;
    }
}
