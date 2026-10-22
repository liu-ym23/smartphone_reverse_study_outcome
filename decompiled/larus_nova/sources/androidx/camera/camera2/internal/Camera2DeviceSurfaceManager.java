package androidx.camera.camera2.internal;

import android.content.Context;
import android.util.Pair;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Camera2DeviceSurfaceManager implements CameraDeviceSurfaceManager {
    private static final String TAG = "Camera2DeviceSurfaceManager";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final Map<String, SupportedSurfaceCombination> mCameraSupportedSurfaceCombinationMap;

    public Camera2DeviceSurfaceManager(Context r100, Object r101, Set<String> r102) throws CameraUnavailableException {
        this(r100, new AnonymousClass1(), r101, r102);
    }

    private void init(Context r100, CameraManagerCompat r101, Set<String> r102) throws CameraUnavailableException {
        Preconditions.checkNotNull(r100);
        Iterator<String> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        this.mCameraSupportedSurfaceCombinationMap.put(r104, new SupportedSurfaceCombination(r100, r104, r101, this.mCamcorderProfileHelper));
        goto L4
    }

    public Camera2DeviceSurfaceManager(Context r100, CamcorderProfileHelper r101, Object r102, Set<String> r103) throws CameraUnavailableException {
        this.mCameraSupportedSurfaceCombinationMap = new HashMap();
        Preconditions.checkNotNull(r101);
        this.mCamcorderProfileHelper = r101;
        if ((r102 instanceof CameraManagerCompat) == false) goto L5;
        CameraManagerCompat r104 = (CameraManagerCompat) r102;
    L6:
        init(r100, r104, r103);
        return;
    L5:
        r104 = CameraManagerCompat.from(r100);
        goto L6
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public SurfaceConfig transformSurfaceConfig(int r100, String r101, int r102, Size r103) {
        SupportedSurfaceCombination r104 = this.mCameraSupportedSurfaceCombinationMap.get(r101);
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.transformSurfaceConfig(r100, r102, r103);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecs(int r100, String r101, List<AttachedSurfaceInfo> r110, Map<UseCaseConfig<?>, List<Size>> r111, boolean r112, boolean r113) {
        Preconditions.checkArgument(!r111.isEmpty(), "No new use cases to be bound.");
        SupportedSurfaceCombination r102 = this.mCameraSupportedSurfaceCombinationMap.get(r101);
        if (r102 == null) goto L7;
        return r102.getSuggestedStreamSpecifications(r100, r110, r111, r112, r113);
    L7:
        throw new IllegalArgumentException("No such camera id in supported combination list: " + r101);
    }
}
