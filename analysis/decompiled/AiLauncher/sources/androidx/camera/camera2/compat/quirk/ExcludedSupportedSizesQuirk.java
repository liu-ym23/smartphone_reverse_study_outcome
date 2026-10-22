package androidx.camera.camera2.compat.quirk;

import D.C0761b0;
import K.s0;
import La.D;
import La.H;
import Z8.C1172u;
import Z8.C1173v;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q.d;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000bJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J3\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u000b¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExcludedSupportedSizesQuirk;", "LK/s0;", "<init>", "()V", "", "cameraId", "", "imageFormat", "", "Landroid/util/Size;", "c", "(Ljava/lang/String;I)Ljava/util/List;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Class;", "klass", Const.INTENT_KEY_UMID, "(Ljava/lang/String;ILjava/lang/Class;)Ljava/util/List;", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Ljava/util/List;", "e", "l", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class ExcludedSupportedSizesQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExcludedSupportedSizesQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_UMID, "isOnePlus6", "e", "isOnePlus6T", Const.INTENT_KEY_PKGNAME, "isHuaweiP20Lite", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "isSamsungJ7PrimeApi27Above", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "isSamsungJ7Api27Above", "f", "isRedmiNote9Pro", Const.INTENT_KEY_BACKGROUND_COMMAND, "isSamsungA05s", "c", "isNokia7Plus", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "isSamsungZFold4", "", "TAG", "Ljava/lang/String;", "", "UNKNOWN_IMAGE_FORMAT", "I", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ExcludedSupportedSizesQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return d() || e() || b() || i() || h() || f() || g() || c() || j();
        }

        public final boolean b() {
            return d.f38469a.e() && D.L("HWANE", Build.DEVICE, true);
        }

        public final boolean c() {
            if (!d.f38469a.i()) {
                return false;
            }
            String str = Build.DEVICE;
            return D.L("B2N", str, true) || D.L("B2N_sprout", str, true);
        }

        public final boolean d() {
            return d.f38469a.j() && D.L("OnePlus6", Build.DEVICE, true);
        }

        public final boolean e() {
            return d.f38469a.j() && D.L("OnePlus6T", Build.DEVICE, true);
        }

        public final boolean f() {
            return d.f38469a.n() && D.L("joyeuse", Build.DEVICE, true);
        }

        public final boolean g() {
            if (d.f38469a.o() && D.L("a05s", Build.DEVICE, true)) {
                String MODEL = Build.MODEL;
                p.h(MODEL, "MODEL");
                String upperCase = MODEL.toUpperCase(Locale.ROOT);
                p.h(upperCase, "toUpperCase(...)");
                if (H.g0(upperCase, "SM-A057", false, 2, null)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean h() {
            return d.f38469a.o() && D.L("J7XELTE", Build.DEVICE, true);
        }

        public final boolean i() {
            return d.f38469a.o() && D.L("ON7XELTE", Build.DEVICE, true);
        }

        public final boolean j() {
            if (!d.f38469a.o()) {
                return false;
            }
            String str = Build.DEVICE;
            return D.L("q4q", str, true) || D.L("SCG16", str, true) || D.L("SC-55C", str, true);
        }

        public Companion() {
        }
    }

    public final List<Size> c(String cameraId, int imageFormat) {
        p.i(cameraId, "cameraId");
        Companion companion = INSTANCE;
        if (companion.d()) {
            return f(cameraId, imageFormat);
        }
        if (companion.e()) {
            return g(cameraId, imageFormat);
        }
        if (companion.b()) {
            return d(cameraId, imageFormat, null);
        }
        if (companion.i()) {
            return k(cameraId, imageFormat, null);
        }
        if (companion.h()) {
            return j(cameraId, imageFormat, null);
        }
        if (companion.f()) {
            return h(cameraId, imageFormat);
        }
        if (companion.g()) {
            return i(imageFormat);
        }
        if (companion.c()) {
            return e(imageFormat);
        }
        if (companion.j()) {
            return l(cameraId, imageFormat);
        }
        C0761b0.o("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
        return C1173v.m();
    }

    public final List<Size> d(String cameraId, int imageFormat, Class<?> klass) {
        return (p.d(cameraId, "0") && (imageFormat == 34 || imageFormat == 35 || klass != null)) ? C1173v.p(new Size(720, 720), new Size(Const.I_TILE_TINY, Const.I_TILE_TINY)) : C1173v.m();
    }

    public final List<Size> e(int imageFormat) {
        return imageFormat == 35 ? C1173v.p(new Size(4032, 3024), new Size(4000, 3000), new Size(3264, 2448), new Size(3200, 2400), new Size(3024, 3024), new Size(2976, 2976), new Size(2448, 2448)) : C1173v.m();
    }

    public final List<Size> f(String cameraId, int imageFormat) {
        return (p.d(cameraId, "0") && imageFormat == 256) ? C1173v.p(new Size(4160, 3120), new Size(4000, 3000)) : C1173v.m();
    }

    public final List<Size> g(String cameraId, int imageFormat) {
        return (p.d(cameraId, "0") && imageFormat == 256) ? C1173v.p(new Size(4160, 3120), new Size(4000, 3000)) : C1173v.m();
    }

    public final List<Size> h(String cameraId, int imageFormat) {
        return (p.d(cameraId, "0") && imageFormat == 256) ? C1172u.e(new Size(9280, 6944)) : C1173v.m();
    }

    public final List<Size> i(int imageFormat) {
        return imageFormat == 35 ? C1173v.p(new Size(3840, 2160), new Size(3264, 2448), new Size(3200, 2400), new Size(2688, 1512), new Size(2592, 1944), new Size(2592, 1940), new Size(1920, 1440)) : C1173v.m();
    }

    public final List<Size> j(String cameraId, int imageFormat, Class<?> klass) {
        if (p.d(cameraId, "0")) {
            if (imageFormat == 34 || klass != null) {
                return C1173v.p(new Size(4128, 3096), new Size(4128, 2322), new Size(3088, 3088), new Size(3264, 2448), new Size(3264, 1836), new Size(2048, 1536), new Size(2048, 1152), new Size(1920, 1080));
            }
            if (imageFormat == 35) {
                return C1173v.p(new Size(2048, 1536), new Size(2048, 1152), new Size(1920, 1080));
            }
        } else if (p.d(cameraId, "1") && (imageFormat == 34 || imageFormat == 35 || klass != null)) {
            return C1173v.p(new Size(2576, 1932), new Size(2560, 1440), new Size(1920, 1920), new Size(2048, 1536), new Size(2048, 1152), new Size(1920, 1080));
        }
        return C1173v.m();
    }

    public final List<Size> k(String cameraId, int imageFormat, Class<?> klass) {
        if (p.d(cameraId, "0")) {
            if (imageFormat == 34 || klass != null) {
                return C1173v.p(new Size(4128, 3096), new Size(4128, 2322), new Size(3088, 3088), new Size(3264, 2448), new Size(3264, 1836), new Size(2048, 1536), new Size(2048, 1152), new Size(1920, 1080));
            }
            if (imageFormat == 35) {
                return C1173v.p(new Size(4128, 2322), new Size(3088, 3088), new Size(3264, 2448), new Size(3264, 1836), new Size(2048, 1536), new Size(2048, 1152), new Size(1920, 1080));
            }
        } else if (p.d(cameraId, "1") && (imageFormat == 34 || imageFormat == 35 || klass != null)) {
            return C1173v.p(new Size(3264, 2448), new Size(3264, 1836), new Size(2448, 2448), new Size(1920, 1920), new Size(2048, 1536), new Size(2048, 1152), new Size(1920, 1080));
        }
        return C1173v.m();
    }

    public final List<Size> l(String cameraId, int imageFormat) {
        return (p.d(cameraId, "1") && imageFormat == 35) ? C1173v.p(new Size(1280, 720), new Size(1920, 1080), new Size(2304, 1296), new Size(640, 360), new Size(177, 144), new Size(2336, 1080), new Size(2400, 1080), new Size(1920, 824), new Size(1088, 1088), new Size(1728, 1728), new Size(2736, 2736), new Size(1824, 712)) : C1173v.m();
    }
}
