package x;

import android.hardware.HardwareBuffer;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.Image;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0018H\u0007¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b,\u0010-J/\u00102\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J'\u00105\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00101\u001a\u000204H\u0007¢\u0006\u0004\b5\u00106J1\u0010<\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00107*\u00020\u00012\u0006\u00109\u001a\u0002082\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0007¢\u0006\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lx/k;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "Landroid/hardware/camera2/params/SessionConfiguration;", "sessionConfig", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraDevice;Landroid/hardware/camera2/params/SessionConfiguration;)V", "Landroid/hardware/camera2/CameraCharacteristics;", "cameraCharacteristics", "", "Landroid/hardware/camera2/CaptureRequest$Key;", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CameraCharacteristics;)Ljava/util/List;", "c", "", "", "e", "(Landroid/hardware/camera2/CameraCharacteristics;)Ljava/util/Set;", "", "sessionType", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputs", "Ljava/util/concurrent/Executor;", "executor", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "stateCallback", "f", "(ILjava/util/List;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraCaptureSession$StateCallback;)Landroid/hardware/camera2/params/SessionConfiguration;", "Landroid/hardware/camera2/params/InputConfiguration;", "inputConfig", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/hardware/camera2/params/SessionConfiguration;Landroid/hardware/camera2/params/InputConfiguration;)V", "Landroid/hardware/camera2/CaptureRequest;", "params", "k", "(Landroid/hardware/camera2/params/SessionConfiguration;Landroid/hardware/camera2/CaptureRequest;)V", "outputConfig", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/params/OutputConfiguration;)I", "cameraId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/hardware/camera2/params/OutputConfiguration;Ljava/lang/String;)V", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "callback", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V", "Landroid/hardware/camera2/CameraManager$AvailabilityCallback;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/hardware/camera2/CameraManager;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraManager$AvailabilityCallback;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/media/Image;", "image", "Lw9/d;", "type", "l", "(Landroid/media/Image;Lw9/d;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5823k {

    /* renamed from: a, reason: collision with root package name */
    public static final C5823k f43416a = new C5823k();

    public static final void a(CameraDevice cameraDevice, SessionConfiguration sessionConfig) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        cameraDevice.createCaptureSession(sessionConfig);
    }

    public static final List<CaptureRequest.Key<?>> b(CameraCharacteristics cameraCharacteristics) {
        kotlin.jvm.internal.p.i(cameraCharacteristics, "cameraCharacteristics");
        return cameraCharacteristics.getAvailablePhysicalCameraRequestKeys();
    }

    public static final List<CaptureRequest.Key<?>> c(CameraCharacteristics cameraCharacteristics) {
        kotlin.jvm.internal.p.i(cameraCharacteristics, "cameraCharacteristics");
        return cameraCharacteristics.getAvailableSessionKeys();
    }

    public static final int d(OutputConfiguration outputConfig) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        return outputConfig.getMaxSharedSurfaceCount();
    }

    public static final Set<String> e(CameraCharacteristics cameraCharacteristics) {
        kotlin.jvm.internal.p.i(cameraCharacteristics, "cameraCharacteristics");
        Set<String> physicalCameraIds = cameraCharacteristics.getPhysicalCameraIds();
        kotlin.jvm.internal.p.h(physicalCameraIds, "getPhysicalCameraIds(...)");
        return physicalCameraIds;
    }

    public static final SessionConfiguration f(int sessionType, List<OutputConfiguration> outputs, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        return new SessionConfiguration(sessionType, outputs, executor, stateCallback);
    }

    public static final void g(CameraManager cameraManager, String cameraId, Executor executor, CameraDevice.StateCallback callback) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(callback, "callback");
        cameraManager.openCamera(cameraId, executor, callback);
    }

    public static final void h(CameraManager cameraManager, Executor executor, CameraManager.AvailabilityCallback callback) {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(callback, "callback");
        cameraManager.registerAvailabilityCallback(executor, callback);
    }

    public static final void i(SessionConfiguration sessionConfig, InputConfiguration inputConfig) {
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        kotlin.jvm.internal.p.i(inputConfig, "inputConfig");
        sessionConfig.setInputConfiguration(inputConfig);
    }

    public static final void j(OutputConfiguration outputConfig, String cameraId) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        outputConfig.setPhysicalCameraId(cameraId);
    }

    public static final void k(SessionConfiguration sessionConfig, CaptureRequest params) {
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        kotlin.jvm.internal.p.i(params, "params");
        sessionConfig.setSessionParameters(params);
    }

    public static final <T> T l(Image image, InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(image, "image");
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(HardwareBuffer.class))) {
            return (T) image.getHardwareBuffer();
        }
        return null;
    }
}
