package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraConfigProvider {
    public static final CameraConfigProvider EMPTY = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraConfigProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            CameraConfigProvider r100 = CameraConfigProvider.EMPTY;
        }

        public static /* synthetic */ CameraConfig lambda$static$0(CameraInfo r100, Context r101) {
            return null;
        }
    }

    CameraConfig getConfig(CameraInfo r100, Context r101);

    static {
        EMPTY = new a();
    }
}
