package androidx.camera.core.impl;

import android.content.Context;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraDeviceSurfaceManager {

    public interface Provider {
        CameraDeviceSurfaceManager newInstance(Context r100, Object r101, Set<String> r102) throws InitializationException;
    }

    Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecs(int r100, String r101, List<AttachedSurfaceInfo> r102, Map<UseCaseConfig<?>, List<Size>> r103, boolean r104, boolean r105);

    SurfaceConfig transformSurfaceConfig(int r100, String r101, int r102, Size r103);
}
