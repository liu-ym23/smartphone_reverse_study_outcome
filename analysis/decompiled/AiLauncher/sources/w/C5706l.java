package w;

import android.hardware.camera2.CameraAccessException;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Lw/l;", "", "", UxipConstants.f30680s, "p", "(I)I", "", "t", "(I)Z", "", "u", "(I)Ljava/lang/String;", "s", "other", "q", "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5706l {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f43007c = p(0);

    /* renamed from: d, reason: collision with root package name */
    public static final int f43008d = p(1);

    /* renamed from: e, reason: collision with root package name */
    public static final int f43009e = p(2);

    /* renamed from: f, reason: collision with root package name */
    public static final int f43010f = p(3);

    /* renamed from: g, reason: collision with root package name */
    public static final int f43011g = p(4);

    /* renamed from: h, reason: collision with root package name */
    public static final int f43012h = p(5);

    /* renamed from: i, reason: collision with root package name */
    public static final int f43013i = p(6);

    /* renamed from: j, reason: collision with root package name */
    public static final int f43014j = p(7);

    /* renamed from: k, reason: collision with root package name */
    public static final int f43015k = p(8);

    /* renamed from: l, reason: collision with root package name */
    public static final int f43016l = p(9);

    /* renamed from: m, reason: collision with root package name */
    public static final int f43017m = p(10);

    /* renamed from: n, reason: collision with root package name */
    public static final int f43018n = p(11);

    /* renamed from: o, reason: collision with root package name */
    public static final int f43019o = p(12);

    /* renamed from: p, reason: collision with root package name */
    public static final int f43020p = p(13);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010 \u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R\u0017\u0010\"\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u0017\u0010$\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0017\u0010&\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u0017\u0010(\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R\u0017\u0010*\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R\u0017\u0010,\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017R\u0017\u0010.\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017R\u0017\u00100\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017¨\u00062"}, d2 = {"Lw/l$a;", "", "<init>", "()V", "", "throwable", "Lw/l;", "c", "(Ljava/lang/Throwable;)I", "Landroid/hardware/camera2/CameraAccessException;", "exception", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CameraAccessException;)I", "", "stateCallbackError", Const.INTENT_KEY_APIKEY, "(I)I", "", "r", "(Ljava/lang/Throwable;)Z", "ERROR_UNDETERMINED", "I", "p", "()I", "ERROR_CAMERA_IN_USE", Const.INTENT_KEY_BACKGROUND_COMMAND, "ERROR_CAMERA_LIMIT_EXCEEDED", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "ERROR_CAMERA_DISABLED", "e", "ERROR_CAMERA_DEVICE", Const.INTENT_KEY_UMID, "ERROR_CAMERA_SERVICE", "k", "ERROR_CAMERA_DISCONNECTED", "f", "ERROR_ILLEGAL_ARGUMENT_EXCEPTION", "n", "ERROR_SECURITY_EXCEPTION", "o", "ERROR_GRAPH_CONFIG", "m", "ERROR_DO_NOT_DISTURB_ENABLED", "l", "ERROR_UNKNOWN_EXCEPTION", "q", "ERROR_CAMERA_OPENER", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "ERROR_CAMERA_OPEN_TIMEOUT", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.l$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a(int stateCallbackError) {
            if (stateCallbackError == 1) {
                return g();
            }
            if (stateCallbackError == 2) {
                return h();
            }
            if (stateCallbackError == 3) {
                return e();
            }
            if (stateCallbackError == 4) {
                return d();
            }
            if (stateCallbackError == 5) {
                return k();
            }
            throw new IllegalArgumentException("Unexpected StateCallback error code: " + stateCallbackError);
        }

        public final int b(CameraAccessException exception) {
            kotlin.jvm.internal.p.i(exception, "exception");
            int reason = exception.getReason();
            if (reason == 1) {
                return e();
            }
            if (reason == 2) {
                return f();
            }
            if (reason == 3) {
                return p();
            }
            if (reason == 4) {
                return g();
            }
            if (reason == 5) {
                return h();
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Unexpected CameraAccessException: " + exception);
            }
            return q();
        }

        public final int c(Throwable throwable) {
            kotlin.jvm.internal.p.i(throwable, "throwable");
            if (throwable instanceof CameraAccessException) {
                return b((CameraAccessException) throwable);
            }
            if (throwable instanceof IllegalArgumentException) {
                return n();
            }
            if (throwable instanceof SecurityException) {
                return o();
            }
            if (r(throwable)) {
                return l();
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Unexpected throwable: " + throwable);
            }
            return q();
        }

        public final int d() {
            return C5706l.f43011g;
        }

        public final int e() {
            return C5706l.f43010f;
        }

        public final int f() {
            return C5706l.f43013i;
        }

        public final int g() {
            return C5706l.f43008d;
        }

        public final int h() {
            return C5706l.f43009e;
        }

        public final int i() {
            return C5706l.f43019o;
        }

        public final int j() {
            return C5706l.f43020p;
        }

        public final int k() {
            return C5706l.f43012h;
        }

        public final int l() {
            return C5706l.f43017m;
        }

        public final int m() {
            return C5706l.f43016l;
        }

        public final int n() {
            return C5706l.f43014j;
        }

        public final int o() {
            return C5706l.f43015k;
        }

        public final int p() {
            return C5706l.f43007c;
        }

        public final int q() {
            return C5706l.f43018n;
        }

        public final boolean r(Throwable throwable) {
            kotlin.jvm.internal.p.i(throwable, "throwable");
            return false;
        }

        public Companion() {
        }
    }

    public /* synthetic */ C5706l(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ C5706l o(int i10) {
        return new C5706l(i10);
    }

    public static int p(int i10) {
        return i10;
    }

    public static boolean q(int i10, Object obj) {
        return (obj instanceof C5706l) && i10 == ((C5706l) obj).getValue();
    }

    public static final boolean r(int i10, int i11) {
        return i10 == i11;
    }

    public static int s(int i10) {
        return Integer.hashCode(i10);
    }

    public static final boolean t(int i10) {
        return r(i10, f43013i) || r(i10, f43008d) || r(i10, f43009e);
    }

    public static String u(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CameraError(");
        sb2.append(r(i10, f43007c) ? "ERROR_UNDETERMINED" : r(i10, f43008d) ? "ERROR_CAMERA_IN_USE" : r(i10, f43009e) ? "ERROR_CAMERA_LIMIT_EXCEEDED" : r(i10, f43010f) ? "ERROR_CAMERA_DISABLED" : r(i10, f43011g) ? "ERROR_CAMERA_DEVICE" : r(i10, f43012h) ? "ERROR_CAMERA_SERVICE" : r(i10, f43013i) ? "ERROR_CAMERA_DISCONNECTED" : r(i10, f43014j) ? "ERROR_ILLEGAL_ARGUMENT_EXCEPTION" : r(i10, f43015k) ? "ERROR_SECURITY_EXCEPTION" : r(i10, f43016l) ? "ERROR_GRAPH_CONFIG" : r(i10, f43017m) ? "ERROR_DO_NOT_DISTURB_ENABLED" : r(i10, f43018n) ? "ERROR_UNKNOWN_EXCEPTION" : r(i10, f43019o) ? "ERROR_CAMERA_OPENER" : r(i10, f43020p) ? "ERROR_CAMERA_OPEN_TIMEOUT" : "ERROR_UNKNOWN");
        sb2.append(')');
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        return q(this.value, obj);
    }

    public int hashCode() {
        return s(this.value);
    }

    public String toString() {
        return u(this.value);
    }

    /* renamed from: v, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
