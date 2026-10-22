package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
import Z8.C1172u;
import Z8.C1173v;
import android.annotation.SuppressLint;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ZslDisablerQuirk;", "LK/s0;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class ZslDisablerQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f9500c = C1173v.p("SM-F936", "SM-S901U", "SM-S908U", "SM-S908U1", "SM-F721U1", "SM-S928U1");

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f9501d = C1172u.e("MI 8");

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ZslDisablerQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()Z", Const.INTENT_KEY_PKGNAME, "c", "", "", "modelList", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Z", "AFFECTED_SAMSUNG_MODEL", "Ljava/util/List;", "AFFECTED_XIAOMI_MODEL", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ZslDisablerQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(List<String> modelList) {
            for (String str : modelList) {
                String MODEL = Build.MODEL;
                p.h(MODEL, "MODEL");
                String upperCase = MODEL.toUpperCase(Locale.ROOT);
                p.h(upperCase, "toUpperCase(...)");
                if (D.X(upperCase, str, false, 2, null)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean b() {
            return d.f38469a.o() && a(ZslDisablerQuirk.f9500c);
        }

        public final boolean c() {
            return d.f38469a.t() && a(ZslDisablerQuirk.f9501d);
        }

        public final boolean d() {
            return b() || c();
        }

        public Companion() {
        }
    }
}
