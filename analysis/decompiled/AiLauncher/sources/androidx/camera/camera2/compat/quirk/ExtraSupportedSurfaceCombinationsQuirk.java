package androidx.camera.camera2.compat.quirk;

import K.B0;
import K.s0;
import La.D;
import Z8.C1172u;
import Z8.C1173v;
import Z8.Y;
import android.os.Build;
import androidx.camera.core.impl.SurfaceConfig;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q.d;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraSupportedSurfaceCombinationsQuirk;", "LK/s0;", "<init>", "()V", "", "cameraId", "", "LK/B0;", "e", "(Ljava/lang/String;)Ljava/util/List;", "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtraSupportedSurfaceCombinationsQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    public static final B0 f9437c;

    /* renamed from: d, reason: collision with root package name */
    public static final B0 f9438d;

    /* renamed from: e, reason: collision with root package name */
    public static final B0 f9439e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<String> f9440f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f9441g;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraSupportedSurfaceCombinationsQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()Z", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "LK/B0;", Const.INTENT_KEY_APIKEY, "()LK/B0;", Const.INTENT_KEY_PKGNAME, "c", "e", "isSamsungS7", "", "TAG", "Ljava/lang/String;", "FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION", "LK/B0;", "FULL_LEVEL_YUV_YUV_YUV_CONFIGURATION", "LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION", "", "SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS", "Ljava/util/Set;", "SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final B0 a() {
            B0 b02 = new B0();
            SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
            SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.VGA, null, 4, null));
            b02.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
            return b02;
        }

        public final B0 b() {
            B0 b02 = new B0();
            SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
            SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.VGA, null, 4, null));
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
            return b02;
        }

        public final B0 c() {
            B0 b02 = new B0();
            SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
            SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
            b02.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.VGA, null, 4, null));
            b02.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
            return b02;
        }

        public final boolean d() {
            return e() || f() || g();
        }

        public final boolean e() {
            String str = Build.DEVICE;
            return D.L("heroqltevzw", str, true) || D.L("heroqltetmo", str, true);
        }

        public final boolean f() {
            if (!d.f38469a.d()) {
                return false;
            }
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            String upperCase = MODEL.toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
            return ExtraSupportedSurfaceCombinationsQuirk.f9440f.contains(upperCase);
        }

        public final boolean g() {
            if (!d.f38469a.o()) {
                return false;
            }
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            String upperCase = MODEL.toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
            Iterator it = ExtraSupportedSurfaceCombinationsQuirk.f9441g.iterator();
            while (it.hasNext()) {
                if (D.X(upperCase, (String) it.next(), false, 2, null)) {
                    return true;
                }
            }
            return false;
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f9437c = companion.a();
        f9438d = companion.b();
        f9439e = companion.c();
        f9440f = Y.j("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO", "PIXEL 9", "PIXEL 9 PRO", "PIXEL 9 PRO XL", "PIXEL 9 PRO FOLD");
        f9441g = Y.j("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26", "SM-S931", "SM-S936", "SM-S937", "SM-S938", "SCG31", "SCG32", "SC-51F", "SC-52F");
    }

    public final List<B0> e(String cameraId) {
        p.i(cameraId, "cameraId");
        Companion companion = INSTANCE;
        return companion.e() ? f(cameraId) : (companion.f() || companion.g()) ? C1172u.e(f9439e) : C1173v.m();
    }

    public final List<B0> f(String cameraId) {
        ArrayList arrayList = new ArrayList();
        if (p.d(cameraId, "1")) {
            arrayList.add(f9437c);
        }
        return arrayList;
    }
}
