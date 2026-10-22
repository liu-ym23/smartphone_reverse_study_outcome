package androidx.camera.core.internal.compat.workaround;

import android.media.MediaCodec;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceSorter {
    private static final int PRIORITY_MEDIA_CODEC_SURFACE = 2;
    private static final int PRIORITY_OTHERS = 1;
    private static final int PRIORITY_PREVIEW_SURFACE = 0;
    private final boolean mHasQuirk;

    public static /* synthetic */ int a(SurfaceSorter r100, SessionConfig.OutputConfig r101, SessionConfig.OutputConfig r102) {
        return r100.lambda$sort$0(r101, r102);
    }

    public SurfaceSorter() {
        if (DeviceQuirks.get(SurfaceOrderQuirk.class) == null) goto L5;
        boolean r100 = true;
    L6:
        this.mHasQuirk = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    private int getSurfacePriority(DeferrableSurface r100) {
        if (r100.getContainerClass() != MediaCodec.class) goto L7;
        return 2;
    L7:
        if (r100.getContainerClass() != Preview.class) goto L10;
        return 0;
    L10:
        return 1;
    }

    public void sort(List<SessionConfig.OutputConfig> r100) {
        if (this.mHasQuirk == true) goto L5;
        return;
    L5:
        Collections.sort(r100, new a(this));
    }

    private /* synthetic */ int lambda$sort$0(SessionConfig.OutputConfig r100, SessionConfig.OutputConfig r101) {
        return getSurfacePriority(r100.getSurface()) - getSurfacePriority(r101.getSurface());
    }
}
