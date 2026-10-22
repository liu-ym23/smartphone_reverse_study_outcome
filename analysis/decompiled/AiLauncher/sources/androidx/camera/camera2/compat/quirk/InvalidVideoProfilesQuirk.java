package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/InvalidVideoProfilesQuirk;", "LK/s0;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class InvalidVideoProfilesQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f9465c = C1173v.p("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f9466d = C1173v.p("cph2417", "cph2451");

    /* renamed from: e, reason: collision with root package name */
    public static final List<String> f9467e = C1173v.p("cph2437", "cph2525", "pht110");

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/compat/quirk/InvalidVideoProfilesQuirk$a;", "", "<init>", "()V", "", "k", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "e", "f", "n", "l", "m", Const.INTENT_KEY_APIKEY, "", "", "AFFECTED_PIXEL_MODELS", "Ljava/util/List;", "AFFECTED_ONE_PLUS_MODELS", "AFFECTED_OPPO_MODELS", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.InvalidVideoProfilesQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return false;
        }

        public final boolean b() {
            return c() && a();
        }

        public final boolean c() {
            List list = InvalidVideoProfilesQuirk.f9466d;
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            String lowerCase = MODEL.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            return list.contains(lowerCase);
        }

        public final boolean d() {
            return e() && a();
        }

        public final boolean e() {
            List list = InvalidVideoProfilesQuirk.f9467e;
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            String lowerCase = MODEL.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            return list.contains(lowerCase);
        }

        public final boolean f() {
            return n() || l();
        }

        public final boolean g() {
            return h() && f();
        }

        public final boolean h() {
            List list = InvalidVideoProfilesQuirk.f9465c;
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            String lowerCase = MODEL.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            return list.contains(lowerCase);
        }

        public final boolean i() {
            return d.f38469a.o() && n();
        }

        public final boolean j() {
            d dVar = d.f38469a;
            if (dVar.t() || dVar.n()) {
                return m() || n();
            }
            return false;
        }

        public final boolean k() {
            return i() || g() || j() || d() || b();
        }

        public final boolean l() {
            String ID = Build.ID;
            p.h(ID, "ID");
            return D.V(ID, "TD1A", true);
        }

        public final boolean m() {
            String ID = Build.ID;
            p.h(ID, "ID");
            return D.V(ID, "TKQ1", true);
        }

        public final boolean n() {
            String ID = Build.ID;
            p.h(ID, "ID");
            return D.V(ID, "TP1A", true);
        }

        public Companion() {
        }
    }
}
