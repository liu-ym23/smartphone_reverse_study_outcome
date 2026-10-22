package androidx.camera.core;

import androidx.camera.core.impl.Identifier;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraFilter {
    public static final Identifier DEFAULT_ID = null;

    /* JADX INFO: renamed from: androidx.camera.core.CameraFilter$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Identifier $default$getIdentifier(CameraFilter r100) {
            return CameraFilter.DEFAULT_ID;
        }
    }

    List<CameraInfo> filter(List<CameraInfo> r100);

    Identifier getIdentifier();

    static {
        DEFAULT_ID = Identifier.create(new Object());
    }
}
