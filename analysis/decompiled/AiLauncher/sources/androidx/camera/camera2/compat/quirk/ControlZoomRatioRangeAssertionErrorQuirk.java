package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
import android.annotation.SuppressLint;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ControlZoomRatioRangeAssertionErrorQuirk;", "LK/s0;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class ControlZoomRatioRangeAssertionErrorQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ControlZoomRatioRangeAssertionErrorQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ControlZoomRatioRangeAssertionErrorQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return b() || c() || d();
        }

        public final boolean b() {
            if (!d.f38469a.g()) {
                return false;
            }
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            return D.V(MODEL, "LS1542QW", true);
        }

        public final boolean c() {
            if (!d.f38469a.o()) {
                return false;
            }
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            return D.V(MODEL, "SM-A025", true) || D.L(MODEL, "SM-S124DL", true);
        }

        public final boolean d() {
            return d.f38469a.s() && D.L(Build.MODEL, "VIVO 2039", true);
        }

        public Companion() {
        }
    }
}
