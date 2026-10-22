package androidx.camera.core.internal.compat.quirk;

import K.s0;
import android.os.Build;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.l;

/* loaded from: classes.dex */
public final class ImageCaptureRotationOptionQuirk implements s0 {
    public static boolean c() {
        return "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean f() {
        return d() || c();
    }

    public boolean e(Config.a<?> aVar) {
        return aVar != l.f11441i;
    }
}
