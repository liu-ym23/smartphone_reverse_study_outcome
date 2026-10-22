package x;

import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\nJ+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00150\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00180\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lx/o;", "", "<init>", "()V", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfig", "", "dynamicRangeProfile", "LY8/t;", "c", "(Landroid/hardware/camera2/params/OutputConfiguration;J)V", "", "mirrorMode", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/params/OutputConfiguration;I)V", "streamUseCase", "e", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "extensionCharacteristics", "extension", "", "Landroid/hardware/camera2/CaptureRequest$Key;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraExtensionCharacteristics;I)Ljava/util/Set;", "Landroid/hardware/camera2/CaptureResult$Key;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", "f", "(Landroidx/camera/camera2/pipe/g;)Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5829o {

    /* renamed from: a, reason: collision with root package name */
    public static final C5829o f43431a = new C5829o();

    public static final Set<CaptureRequest.Key<Object>> a(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        kotlin.jvm.internal.p.i(extensionCharacteristics, "extensionCharacteristics");
        Set<CaptureRequest.Key<Object>> availableCaptureRequestKeys = extensionCharacteristics.getAvailableCaptureRequestKeys(extension);
        kotlin.jvm.internal.p.h(availableCaptureRequestKeys, "getAvailableCaptureRequestKeys(...)");
        return availableCaptureRequestKeys;
    }

    public static final Set<CaptureResult.Key<Object>> b(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        kotlin.jvm.internal.p.i(extensionCharacteristics, "extensionCharacteristics");
        Set<CaptureResult.Key<Object>> availableCaptureResultKeys = extensionCharacteristics.getAvailableCaptureResultKeys(extension);
        kotlin.jvm.internal.p.h(availableCaptureResultKeys, "getAvailableCaptureResultKeys(...)");
        return availableCaptureResultKeys;
    }

    public static final void c(OutputConfiguration outputConfig, long dynamicRangeProfile) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        outputConfig.setDynamicRangeProfile(dynamicRangeProfile);
    }

    public static final void d(OutputConfiguration outputConfig, int mirrorMode) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        outputConfig.setMirrorMode(mirrorMode);
    }

    public static final void e(OutputConfiguration outputConfig, long streamUseCase) {
        kotlin.jvm.internal.p.i(outputConfig, "outputConfig");
        outputConfig.setStreamUseCase(streamUseCase);
    }

    public final boolean f(androidx.camera.camera2.pipe.g cameraMetadata) {
        kotlin.jvm.internal.p.i(cameraMetadata, "cameraMetadata");
        return Z8.r.P(androidx.camera.camera2.pipe.g.INSTANCE.b(cameraMetadata), 2);
    }
}
