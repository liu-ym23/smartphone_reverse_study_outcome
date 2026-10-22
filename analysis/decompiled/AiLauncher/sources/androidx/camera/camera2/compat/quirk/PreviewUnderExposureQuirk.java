package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
import android.annotation.SuppressLint;
import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/PreviewUnderExposureQuirk;", "LK/s0;", "<init>", "()V", "", "c", "()Z", "Z", "isTclDevice", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class PreviewUnderExposureQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name */
    public static final PreviewUnderExposureQuirk f9480b = new PreviewUnderExposureQuirk();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final boolean isTclDevice = D.L(Build.BRAND, "TCL", true);

    private PreviewUnderExposureQuirk() {
    }

    public static final boolean c() {
        return isTclDevice;
    }
}
