package androidx.camera.camera2.internal.concurrent;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class Camera2CameraCoordinator implements CameraCoordinator {
    private static final String TAG = "Camera2CameraCoordinator";
    private List<CameraInfo> mActiveConcurrentCameraInfos;
    private final CameraManagerCompat mCameraManager;
    private int mCameraOperatingMode;
    private final Map<String, List<String>> mConcurrentCameraIdMap;
    private Set<Set<String>> mConcurrentCameraIds;
    private final List<CameraCoordinator.ConcurrentCameraModeListener> mConcurrentCameraModeListeners;

    public static /* synthetic */ List a(String r100, List r101) {
        return lambda$createCameraSelectorById$0(r100, r101);
    }

    private void retrieveConcurrentCameraIds() {
        Set<Set<String>> r100 = new HashSet();
        r100 = this.mCameraManager.getConcurrentCameraIds();     // Catch: CameraAccessExceptionCompat -> L5
    L6:
        Iterator<Set<String>> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L28;
        ArrayList r102 = new ArrayList(r101.next());
        if (r102.size() < 2) goto L8;
        String r103 = (String) ListProtector.get(r102, 0);
        String r104 = (String) ListProtector.get(r102, 1);
    L17:
        Logger.d(TAG, "Concurrent camera id pair: (" + r103 + ", " + r104 + ") is not backward compatible");
    L18:
        boolean r105 = false;
    L19:
        if (r105 == false) goto L8;
        this.mConcurrentCameraIds.add(new HashSet(Arrays.asList(new String[]{r103, r104})));
        if (this.mConcurrentCameraIdMap.containsKey(r103) == true) goto L25;
        this.mConcurrentCameraIdMap.put(r103, new ArrayList());
    L25:
        if (this.mConcurrentCameraIdMap.containsKey(r104) == true) goto L27;
        this.mConcurrentCameraIdMap.put(r104, new ArrayList());
    L27:
        this.mConcurrentCameraIdMap.get(r103).add((String) ListProtector.get(r102, 1));
        this.mConcurrentCameraIdMap.get(r104).add((String) ListProtector.get(r102, 0));
        goto L8
    L13:
        if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, r103) == false) goto L18;
        if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, r104) == false) goto L18;
        r105 = true;
        goto L19
    L28:
        return;
    L5:
        Logger.e(TAG, "Failed to get concurrent camera ids");
        goto L6
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public List<List<CameraSelector>> getConcurrentCameraSelectors() {
        ArrayList r100 = new ArrayList();
        Iterator<Set<String>> r101 = this.mConcurrentCameraIds.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Set<String> r102 = r101.next();
        ArrayList r103 = new ArrayList();
        Iterator<String> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = r104.next();
        r103.add(createCameraSelectorById(this.mCameraManager, r105));
        goto L7
    L9:
        r100.add(r103);
        goto L4
    L10:
        return r100;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void shutdown() {
        this.mConcurrentCameraModeListeners.clear();
        this.mConcurrentCameraIdMap.clear();
        this.mActiveConcurrentCameraInfos.clear();
        this.mConcurrentCameraIds.clear();
        this.mCameraOperatingMode = 0;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public List<CameraInfo> getActiveConcurrentCameraInfos() {
        return this.mActiveConcurrentCameraInfos;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public int getCameraOperatingMode() {
        return this.mCameraOperatingMode;
    }

    public Camera2CameraCoordinator(CameraManagerCompat r100) {
        this.mCameraOperatingMode = 0;
        this.mCameraManager = r100;
        this.mConcurrentCameraIdMap = new HashMap();
        this.mConcurrentCameraIds = new HashSet();
        this.mConcurrentCameraModeListeners = new ArrayList();
        this.mActiveConcurrentCameraInfos = new ArrayList();
        retrieveConcurrentCameraIds();
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void addListener(CameraCoordinator.ConcurrentCameraModeListener r100) {
        this.mConcurrentCameraModeListeners.add(r100);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public String getPairedConcurrentCameraId(String r100) {
        if (this.mConcurrentCameraIdMap.containsKey(r100) == true) goto L5;
        return null;
    L5:
        Iterator<String> r101 = this.mConcurrentCameraIdMap.get(r100).iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        String r102 = r101.next();
        Iterator<CameraInfo> r103 = this.mActiveConcurrentCameraInfos.iterator();
    L10:
        if (r103.hasNext() == false) goto L7;
        if (r102.equals(Camera2CameraInfo.from(r103.next()).getCameraId()) == false) goto L10;
        return r102;
    L14:
        return null;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void removeListener(CameraCoordinator.ConcurrentCameraModeListener r100) {
        this.mConcurrentCameraModeListeners.remove(r100);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setActiveConcurrentCameraInfos(List<CameraInfo> r100) {
        this.mActiveConcurrentCameraInfos = new ArrayList(r100);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setCameraOperatingMode(int r100) {
        if (r100 == this.mCameraOperatingMode) goto L9;
        Iterator<CameraCoordinator.ConcurrentCameraModeListener> r101 = this.mConcurrentCameraModeListeners.iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        r101.next().onCameraOperatingModeUpdated(this.mCameraOperatingMode, r100);
    L9:
        if (this.mCameraOperatingMode != 2) goto L12;
        if (r100 == 2) goto L12;
        this.mActiveConcurrentCameraInfos.clear();
    L12:
        this.mCameraOperatingMode = r100;
    }

    private static CameraSelector createCameraSelectorById(CameraManagerCompat r100, final String r101) {
        CameraSelector.Builder r102 = new CameraSelector.Builder().addCameraFilter(new a(r101));
        r102.requireLensFacing(((Integer) r100.getCameraCharacteristicsCompat(r101).get(CameraCharacteristics.LENS_FACING)).intValue());     // Catch: CameraAccessExceptionCompat -> L6
        return r102.build();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static /* synthetic */ List lambda$createCameraSelectorById$0(String r100, List r101) {
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        CameraInfo r103 = (CameraInfo) r102.next();
        if (r100.equals(Camera2CameraInfo.from(r103).getCameraId()) == false) goto L4;
        return Collections.singletonList(r103);
    L10:
        throw new IllegalArgumentException("No camera can be find for id: " + r100);
    }
}
