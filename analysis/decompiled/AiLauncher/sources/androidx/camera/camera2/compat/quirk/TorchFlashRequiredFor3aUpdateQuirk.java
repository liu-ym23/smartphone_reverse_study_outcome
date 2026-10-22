package androidx.camera.camera2.compat.quirk;

import K.s0;
import Z8.C1173v;
import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.pipe.g;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/compat/quirk/TorchFlashRequiredFor3aUpdateQuirk;", "LK/s0;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "<init>", "(Landroidx/camera/camera2/pipe/g;)V", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/g;", "c", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class TorchFlashRequiredFor3aUpdateQuirk implements s0 {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f9492d = C1173v.s("PIXEL 6A", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7A", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO");

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g cameraMetadata;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u00020\u0006*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/compat/quirk/TorchFlashRequiredFor3aUpdateQuirk$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", "c", "(Landroidx/camera/camera2/pipe/g;)Z", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_UMID, "isFrontCamera", "", "", "AFFECTED_PIXEL_MODELS", "Ljava/util/List;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(g cameraMetadata) {
            return b() && d(cameraMetadata);
        }

        public final boolean b() {
            for (String str : TorchFlashRequiredFor3aUpdateQuirk.f9492d) {
                String MODEL = Build.MODEL;
                p.h(MODEL, "MODEL");
                String upperCase = MODEL.toUpperCase(Locale.ROOT);
                p.h(upperCase, "toUpperCase(...)");
                if (p.d(upperCase, str)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean c(g cameraMetadata) {
            p.i(cameraMetadata, "cameraMetadata");
            return a(cameraMetadata);
        }

        public final boolean d(g gVar) {
            CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
            p.h(LENS_FACING, "LENS_FACING");
            Integer num = (Integer) gVar.e0(LENS_FACING);
            return num != null && num.intValue() == 0;
        }

        public Companion() {
        }
    }

    public TorchFlashRequiredFor3aUpdateQuirk(g cameraMetadata) {
        p.i(cameraMetadata, "cameraMetadata");
        this.cameraMetadata = cameraMetadata;
    }
}
