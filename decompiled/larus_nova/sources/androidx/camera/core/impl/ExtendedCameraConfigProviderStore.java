package androidx.camera.core.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ExtendedCameraConfigProviderStore {
    private static final Map<Object, CameraConfigProvider> CAMERA_CONFIG_PROVIDERS = null;
    private static final Object LOCK = null;

    static {
        LOCK = new Object();
        CAMERA_CONFIG_PROVIDERS = new HashMap();
    }

    public static void clear() {
        Object r100 = LOCK;
        monitor-enter(r100);
        CAMERA_CONFIG_PROVIDERS.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ExtendedCameraConfigProviderStore() {
    }

    public static CameraConfigProvider getConfigProvider(Object r100) {
        Object r101 = LOCK;
        monitor-enter(r101);
        CameraConfigProvider r102 = CAMERA_CONFIG_PROVIDERS.get(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        if (r102 == null) goto L8;
        return r102;
    L8:
        return CameraConfigProvider.EMPTY;
    L9:
        th = move-exception;
        throw th;
    }

    public static void addConfig(Object r100, CameraConfigProvider r101) {
        Object r102 = LOCK;
        monitor-enter(r102);
        CAMERA_CONFIG_PROVIDERS.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
