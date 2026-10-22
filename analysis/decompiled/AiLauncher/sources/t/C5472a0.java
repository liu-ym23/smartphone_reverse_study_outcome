package t;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Handler;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\t2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001b\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u0019J1\u0010\u001e\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\u0003J\u0017\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lt/a0;", "Landroid/hardware/camera2/CameraCaptureSession;", "<init>", "()V", "Landroid/hardware/camera2/CameraDevice;", "getDevice", "()Landroid/hardware/camera2/CameraDevice;", "Landroid/view/Surface;", "surface", "LY8/t;", "prepare", "(Landroid/view/Surface;)V", "", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfigs", "finalizeOutputConfigurations", "(Ljava/util/List;)V", "Landroid/hardware/camera2/CaptureRequest;", "request", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "listener", "Landroid/os/Handler;", "handler", "", "capture", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I", "requests", "captureBurst", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I", "setRepeatingRequest", "setRepeatingBurst", "stopRepeating", "abortCaptures", "", "isReprocessable", "()Z", "getInputSurface", "()Landroid/view/Surface;", "close", "", "funcName", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: t.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5472a0 extends CameraCaptureSession {
    @Override // android.hardware.camera2.CameraCaptureSession
    public void abortCaptures() {
        throw new IllegalArgumentException(b("abortCaptures"));
    }

    public final String b(String funcName) {
        return "Current capture session is running on extensions mode which isn't allowed to invoke the " + funcName + " function!";
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int capture(CaptureRequest request, CameraCaptureSession.CaptureCallback listener, Handler handler) {
        kotlin.jvm.internal.p.i(request, "request");
        throw new IllegalArgumentException(b("capture"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int captureBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener, Handler handler) {
        kotlin.jvm.internal.p.i(requests, "requests");
        throw new IllegalArgumentException(b("captureBurst"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession, java.lang.AutoCloseable
    public void close() {
        throw new IllegalArgumentException(b("close"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public void finalizeOutputConfigurations(List<OutputConfiguration> outputConfigs) {
        throw new IllegalArgumentException(b("finalizeOutputConfigurations"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public CameraDevice getDevice() {
        throw new IllegalArgumentException(b("getDevice"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public Surface getInputSurface() {
        throw new IllegalArgumentException(b("getInputSurface"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public boolean isReprocessable() {
        throw new IllegalArgumentException(b("isReprocessable"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public void prepare(Surface surface) {
        kotlin.jvm.internal.p.i(surface, "surface");
        throw new IllegalArgumentException(b("prepare"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int setRepeatingBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener, Handler handler) {
        kotlin.jvm.internal.p.i(requests, "requests");
        throw new IllegalArgumentException(b("setRepeatingBurst"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int setRepeatingRequest(CaptureRequest request, CameraCaptureSession.CaptureCallback listener, Handler handler) {
        kotlin.jvm.internal.p.i(request, "request");
        throw new IllegalArgumentException(b("setRepeatingRequest"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public void stopRepeating() {
        throw new IllegalArgumentException(b("stopRepeating"));
    }
}
