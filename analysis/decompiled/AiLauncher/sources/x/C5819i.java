package x;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lx/i;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfig", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "stateCallback", "Landroid/os/Handler;", "handler", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraDevice;Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$StateCallback;Landroid/os/Handler;)V", "Landroid/hardware/camera2/params/InputConfiguration;", "inputConfig", "outputs", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CameraDevice;Landroid/hardware/camera2/params/InputConfiguration;Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$StateCallback;Landroid/os/Handler;)V", "outputConfiguration", "", "c", "(Landroid/hardware/camera2/params/OutputConfiguration;)I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5819i {

    /* renamed from: a, reason: collision with root package name */
    public static final C5819i f43410a = new C5819i();

    public static final void a(CameraDevice cameraDevice, List<OutputConfiguration> outputConfig, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        cameraDevice.createCaptureSessionByOutputConfigurations(outputConfig, stateCallback, handler);
    }

    public static final void b(CameraDevice cameraDevice, InputConfiguration inputConfig, List<OutputConfiguration> outputs, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(inputConfig, "inputConfig");
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        cameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfig, outputs, stateCallback, handler);
    }

    public static final int c(OutputConfiguration outputConfiguration) {
        kotlin.jvm.internal.p.i(outputConfiguration, "outputConfiguration");
        return outputConfiguration.getSurfaceGroupId();
    }
}
