package androidx.camera.camera2.compat.quirk;

import La.D;
import Z8.C1172u;
import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.pipe.g;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/UltraWideFlashCaptureUnderexposureQuirk;", "Landroidx/camera/camera2/compat/quirk/UseTorchAsFlashQuirk;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class UltraWideFlashCaptureUnderexposureQuirk implements UseTorchAsFlashQuirk {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f9497c = C1172u.e("sm-s921");

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/UltraWideFlashCaptureUnderexposureQuirk$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/g;)Z", "", "", "BUILD_MODEL_PREFIXES", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.UltraWideFlashCaptureUnderexposureQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final List<String> a() {
            return UltraWideFlashCaptureUnderexposureQuirk.f9497c;
        }

        public final boolean b(g cameraMetadata) {
            p.i(cameraMetadata, "cameraMetadata");
            List<String> listA = a();
            if (!(listA instanceof Collection) || !listA.isEmpty()) {
                Iterator<T> it = listA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    String MODEL = Build.MODEL;
                    p.h(MODEL, "MODEL");
                    String lowerCase = MODEL.toLowerCase(Locale.ROOT);
                    p.h(lowerCase, "toLowerCase(...)");
                    if (D.X(lowerCase, str, false, 2, null)) {
                        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
                        p.h(LENS_FACING, "LENS_FACING");
                        Integer num = (Integer) cameraMetadata.e0(LENS_FACING);
                        if (num != null && num.intValue() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public Companion() {
        }
    }
}
