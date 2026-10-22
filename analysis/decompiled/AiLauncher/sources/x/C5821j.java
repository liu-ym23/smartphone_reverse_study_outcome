package x;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lx/j;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraCaptureSession;", "cameraCaptureSession", "", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfiguration", "LY8/t;", "c", "(Landroid/hardware/camera2/CameraCaptureSession;Ljava/util/List;)V", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Ljava/lang/Class;", "klass", Const.INTENT_KEY_UMID, "(Landroid/util/Size;Ljava/lang/Class;)Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfig", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/params/OutputConfiguration;)V", "Landroid/view/Surface;", "surface", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/params/OutputConfiguration;Landroid/view/Surface;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5821j {

    /* renamed from: a, reason: collision with root package name */
    public static final C5821j f43415a = new C5821j();

    public static final void a(OutputConfiguration outputConfig, Surface surface) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        kotlin.jvm.internal.p.i(surface, "surface");
        outputConfig.addSurface(surface);
    }

    public static final void b(OutputConfiguration outputConfig) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        outputConfig.enableSurfaceSharing();
    }

    public static final void c(CameraCaptureSession cameraCaptureSession, List<OutputConfiguration> outputConfiguration) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraCaptureSession, "cameraCaptureSession");
        kotlin.jvm.internal.p.i(outputConfiguration, "outputConfiguration");
        cameraCaptureSession.finalizeOutputConfigurations(outputConfiguration);
    }

    public static final OutputConfiguration d(Size size, Class<?> klass) {
        kotlin.jvm.internal.p.i(size, "size");
        kotlin.jvm.internal.p.i(klass, "klass");
        return new OutputConfiguration(size, klass);
    }
}
