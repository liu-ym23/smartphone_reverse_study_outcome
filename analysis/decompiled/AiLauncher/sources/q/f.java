package q;

import D.C0761b0;
import K.s0;
import K.t0;
import K.u0;
import K.w0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lq/f;", "", "<init>", "()V", "LK/s0;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "quirkClass", "c", "(Ljava/lang/Class;)LK/s0;", "LK/w0;", Const.INTENT_KEY_PKGNAME, "LK/w0;", Const.INTENT_KEY_UMID, "()LK/w0;", "e", "(LK/w0;)V", "getAll$annotations", "all", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f38470a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static volatile w0 all;

    static {
        u0.b().c(N.a.a(), new B0.a() { // from class: q.e
            @Override // B0.a
            public final void accept(Object obj) {
                f.b((t0) obj);
            }
        });
    }

    public static final void b(t0 t0Var) {
        androidx.camera.camera2.compat.quirk.b bVar = androidx.camera.camera2.compat.quirk.b.f9506a;
        p.f(t0Var);
        e(new w0(bVar.a(t0Var)));
        C0761b0.a("DeviceQuirks", "camera2 DeviceQuirks = " + w0.d(d()));
    }

    public static final w0 d() {
        w0 w0Var = all;
        if (w0Var != null) {
            return w0Var;
        }
        p.A("all");
        return null;
    }

    public static final void e(w0 w0Var) {
        p.i(w0Var, "<set-?>");
        all = w0Var;
    }

    public final <T extends s0> T c(Class<T> quirkClass) {
        p.i(quirkClass, "quirkClass");
        return (T) d().b(quirkClass);
    }
}
