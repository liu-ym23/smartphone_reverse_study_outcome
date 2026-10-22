package Z;

import Z.e;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.SessionConfiguration;

/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final CameraDevice.CameraDeviceSetup f7088a;

    public c(CameraManager cameraManager, String str) throws CameraAccessException {
        this.f7088a = cameraManager.getCameraDeviceSetup(str);
    }

    public static long b() {
        String property = System.getProperty("ro.build.date.utc");
        if (property == null) {
            return 0L;
        }
        try {
            return Long.parseLong(property) * 1000;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // Z.e
    public e.a a(SessionConfiguration sessionConfiguration) throws CameraAccessException {
        return new e.a(this.f7088a.isSessionConfigurationSupported(sessionConfiguration) ? 1 : 2, 2, b());
    }
}
