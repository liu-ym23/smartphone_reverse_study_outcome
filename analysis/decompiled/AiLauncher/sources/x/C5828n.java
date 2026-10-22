package x;

import Z8.C1174w;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraExtensionSession;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010#J7\u0010*\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00142\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010,\u001a\u00020!H\u0007¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lx/n;", "", "<init>", "()V", "", "Lx/u0;", "inputConfigData", "", "cameraId", "Landroid/hardware/camera2/params/InputConfiguration;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;Ljava/lang/String;)Landroid/hardware/camera2/params/InputConfiguration;", "Landroid/hardware/camera2/TotalCaptureResult;", "totalCaptureResult", "", "Landroid/hardware/camera2/CaptureResult;", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/TotalCaptureResult;)Ljava/util/Map;", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfiguration", "", "sensorPixelMode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/params/OutputConfiguration;I)V", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "Landroid/hardware/camera2/params/ExtensionSessionConfiguration;", "extensionConfiguration", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CameraDevice;Landroid/hardware/camera2/params/ExtensionSessionConfiguration;)V", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "c", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;)Landroid/hardware/camera2/CameraExtensionCharacteristics;", "extensionMode", "outputs", "Ljava/util/concurrent/Executor;", "executor", "Landroid/hardware/camera2/CameraExtensionSession$StateCallback;", "stateCallback", "f", "(ILjava/util/List;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraExtensionSession$StateCallback;)Landroid/hardware/camera2/params/ExtensionSessionConfiguration;", "extensionCharacteristics", "e", "(Landroid/hardware/camera2/CameraExtensionCharacteristics;)Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5828n {

    /* renamed from: a, reason: collision with root package name */
    public static final C5828n f43429a = new C5828n();

    public static final void a(OutputConfiguration outputConfiguration, int sensorPixelMode) {
        kotlin.jvm.internal.p.i(outputConfiguration, "outputConfiguration");
        outputConfiguration.addSensorPixelModeUsed(sensorPixelMode);
    }

    public static final void b(CameraDevice cameraDevice, ExtensionSessionConfiguration extensionConfiguration) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(extensionConfiguration, "extensionConfiguration");
        cameraDevice.createExtensionSession(extensionConfiguration);
    }

    public static final CameraExtensionCharacteristics c(CameraManager cameraManager, String cameraId) throws CameraAccessException {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        CameraExtensionCharacteristics cameraExtensionCharacteristics = cameraManager.getCameraExtensionCharacteristics(cameraId);
        kotlin.jvm.internal.p.h(cameraExtensionCharacteristics, "getCameraExtensionCharacteristics(...)");
        return cameraExtensionCharacteristics;
    }

    public static final Map<String, CaptureResult> d(TotalCaptureResult totalCaptureResult) {
        kotlin.jvm.internal.p.i(totalCaptureResult, "totalCaptureResult");
        return totalCaptureResult.getPhysicalCameraTotalResults();
    }

    public static final List<Integer> e(CameraExtensionCharacteristics extensionCharacteristics) {
        kotlin.jvm.internal.p.i(extensionCharacteristics, "extensionCharacteristics");
        List<Integer> supportedExtensions = extensionCharacteristics.getSupportedExtensions();
        kotlin.jvm.internal.p.h(supportedExtensions, "getSupportedExtensions(...)");
        return supportedExtensions;
    }

    public static final ExtensionSessionConfiguration f(int extensionMode, List<OutputConfiguration> outputs, Executor executor, CameraExtensionSession.StateCallback stateCallback) {
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        return new ExtensionSessionConfiguration(extensionMode, outputs, executor, stateCallback);
    }

    public static final InputConfiguration g(List<InputConfigData> inputConfigData, String cameraId) {
        kotlin.jvm.internal.p.i(inputConfigData, "inputConfigData");
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        if (inputConfigData.isEmpty()) {
            throw new IllegalStateException("Call to create InputConfiguration but list of InputConfigData is empty.");
        }
        if (inputConfigData.size() == 1) {
            InputConfigData inputConfigData2 = (InputConfigData) Z8.F.q0(inputConfigData);
            return new InputConfiguration(inputConfigData2.getWidth(), inputConfigData2.getHeight(), inputConfigData2.getFormat());
        }
        List<InputConfigData> list = inputConfigData;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (InputConfigData inputConfigData3 : list) {
            arrayList.add(new MultiResolutionStreamInfo(inputConfigData3.getWidth(), inputConfigData3.getHeight(), cameraId));
        }
        return new InputConfiguration(arrayList, ((InputConfigData) Z8.F.q0(inputConfigData)).getFormat());
    }
}
