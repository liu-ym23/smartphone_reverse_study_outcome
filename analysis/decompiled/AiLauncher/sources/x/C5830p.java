package x;

import android.graphics.ColorSpace;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lx/p;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "extensionCharacteristics", "", "extension", "", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CameraExtensionCharacteristics;I)Z", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/params/ExtensionSessionConfiguration;", "extensionSessionConfiguration", "Landroid/hardware/camera2/params/OutputConfiguration;", "postviewOutputConfiguration", "LY8/t;", "e", "(Landroid/hardware/camera2/params/ExtensionSessionConfiguration;Landroid/hardware/camera2/params/OutputConfiguration;)V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "c", "(Landroidx/camera/camera2/pipe/g;)Z", "Landroid/hardware/camera2/params/SessionConfiguration;", "sessionConfiguration", "Landroid/graphics/ColorSpace$Named;", "colorSpace", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/params/SessionConfiguration;Landroid/graphics/ColorSpace$Named;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5830p {

    /* renamed from: a, reason: collision with root package name */
    public static final C5830p f43433a = new C5830p();

    public static final boolean a(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        kotlin.jvm.internal.p.i(extensionCharacteristics, "extensionCharacteristics");
        return extensionCharacteristics.isCaptureProcessProgressAvailable(extension);
    }

    public static final boolean b(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        kotlin.jvm.internal.p.i(extensionCharacteristics, "extensionCharacteristics");
        return extensionCharacteristics.isPostviewAvailable(extension);
    }

    public static final boolean c(androidx.camera.camera2.pipe.g cameraMetadata) {
        kotlin.jvm.internal.p.i(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key CONTROL_AVAILABLE_SETTINGS_OVERRIDES = CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES;
        kotlin.jvm.internal.p.h(CONTROL_AVAILABLE_SETTINGS_OVERRIDES, "CONTROL_AVAILABLE_SETTINGS_OVERRIDES");
        int[] iArr = (int[]) cameraMetadata.e0(CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
        return iArr != null && Z8.r.P(iArr, 1);
    }

    public static final void d(SessionConfiguration sessionConfiguration, ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.p.i(sessionConfiguration, "sessionConfiguration");
        kotlin.jvm.internal.p.i(colorSpace, "colorSpace");
        sessionConfiguration.setColorSpace(colorSpace);
    }

    public static final void e(ExtensionSessionConfiguration extensionSessionConfiguration, OutputConfiguration postviewOutputConfiguration) {
        kotlin.jvm.internal.p.i(extensionSessionConfiguration, "extensionSessionConfiguration");
        kotlin.jvm.internal.p.i(postviewOutputConfiguration, "postviewOutputConfiguration");
        extensionSessionConfiguration.setPostviewOutputConfiguration(postviewOutputConfiguration);
    }
}
