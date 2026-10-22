package t;

import D.C0761b0;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lt/P;", "", "<init>", "()V", "Lt/v;", "cameraProperties", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lt/v;)V", Const.INTENT_KEY_PKGNAME, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class P {

    /* renamed from: a, reason: collision with root package name */
    public static final P f41841a = new P();

    public final void a(InterfaceC5494v cameraProperties) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        b(cameraProperties);
    }

    public final void b(InterfaceC5494v cameraProperties) {
        String str;
        androidx.camera.camera2.pipe.g metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        kotlin.jvm.internal.p.h(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
        Integer num = (Integer) metadata.h1(INFO_SUPPORTED_HARDWARE_LEVEL, -1);
        if (num != null && num.intValue() == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (num != null && num.intValue() == 4) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        } else if (num != null && num.intValue() == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (num != null && num.intValue() == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (num != null && num.intValue() == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else {
            str = "Unknown value: " + num;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.h("CXCP")) {
            Log.i(C5473b.TRUNCATED_TAG, "Device Level: " + str);
        }
    }
}
