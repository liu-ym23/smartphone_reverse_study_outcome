package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.UseCaseConfigFactory;
import f.a;
import f.b;
import f.c;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Camera2Config {

    public static final class DefaultProvider implements CameraXConfig.Provider {
        public DefaultProvider() {
        }

        @Override // androidx.camera.core.CameraXConfig.Provider
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }

    public static /* synthetic */ UseCaseConfigFactory a(Context r100) {
        return lambda$defaultConfig$1(r100);
    }

    public static /* synthetic */ CameraDeviceSurfaceManager b(Context r100, Object r101, Set r102) {
        return lambda$defaultConfig$0(r100, r101, r102);
    }

    public static CameraXConfig defaultConfig() {
        CameraFactory.Provider r100 = new a();
        CameraDeviceSurfaceManager.Provider r101 = new b();
        UseCaseConfigFactory.Provider r102 = new c();
        return new CameraXConfig.Builder().setCameraFactoryProvider(r100).setDeviceSurfaceManagerProvider(r101).setUseCaseConfigFactoryProvider(r102).build();
    }

    private Camera2Config() {
    }

    private static /* synthetic */ UseCaseConfigFactory lambda$defaultConfig$1(Context r100) throws InitializationException {
        return new Camera2UseCaseConfigFactory(r100);
    }

    private static /* synthetic */ CameraDeviceSurfaceManager lambda$defaultConfig$0(Context r100, Object r101, Set r102) throws InitializationException {
        return new Camera2DeviceSurfaceManager(r100, r101, r102);
    L4:
        e = move-exception;
        throw new InitializationException(e);
    }
}
