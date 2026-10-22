package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public interface SurfaceProcessingQuirk extends Quirk {

    /* JADX INFO: renamed from: androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$workaroundBySurfaceProcessing(SurfaceProcessingQuirk r100) {
            return true;
        }

        public static boolean workaroundBySurfaceProcessing(Quirks r100) {
            Iterator r101 = r100.getAll(SurfaceProcessingQuirk.class).iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (((SurfaceProcessingQuirk) r101.next()).workaroundBySurfaceProcessing() == false) goto L4;
            return true;
        L9:
            return false;
        }
    }

    boolean workaroundBySurfaceProcessing();
}
