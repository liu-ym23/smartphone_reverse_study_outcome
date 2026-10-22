package r;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.camera2.impl.a;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/impl/a$a;", "Landroidx/camera/core/impl/q;", "imageCaptureConfig", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/impl/a$a;Landroidx/camera/core/impl/q;)V", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5193k {
    @SuppressLint({"NewApi"})
    public static final void a(a.C0131a c0131a, androidx.camera.core.impl.q imageCaptureConfig) {
        kotlin.jvm.internal.p.i(c0131a, "<this>");
        kotlin.jvm.internal.p.i(imageCaptureConfig, "imageCaptureConfig");
        if (((ImageCapturePixelHDRPlusQuirk) q.f.f38470a.c(ImageCapturePixelHDRPlusQuirk.class)) != null && imageCaptureConfig.o0()) {
            int iI0 = imageCaptureConfig.i0();
            if (iI0 == 0) {
                CaptureRequest.Key CONTROL_ENABLE_ZSL = CaptureRequest.CONTROL_ENABLE_ZSL;
                kotlin.jvm.internal.p.h(CONTROL_ENABLE_ZSL, "CONTROL_ENABLE_ZSL");
                c0131a.g(CONTROL_ENABLE_ZSL, Boolean.TRUE);
            } else {
                if (iI0 != 1) {
                    return;
                }
                CaptureRequest.Key CONTROL_ENABLE_ZSL2 = CaptureRequest.CONTROL_ENABLE_ZSL;
                kotlin.jvm.internal.p.h(CONTROL_ENABLE_ZSL2, "CONTROL_ENABLE_ZSL");
                c0131a.g(CONTROL_ENABLE_ZSL2, Boolean.FALSE);
            }
        }
    }
}
