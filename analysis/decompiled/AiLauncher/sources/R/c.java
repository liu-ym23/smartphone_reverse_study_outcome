package R;

import D.C0761b0;
import K.s0;
import K.t0;
import K.u0;
import K.w0;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile w0 f5518a;

    static {
        u0.b().c(N.a.a(), new B0.a() { // from class: R.b
            @Override // B0.a
            public final void accept(Object obj) {
                c.a((t0) obj);
            }
        });
    }

    public static /* synthetic */ void a(t0 t0Var) {
        f5518a = new w0(d.a(t0Var));
        C0761b0.a("DeviceQuirks", "core DeviceQuirks = " + w0.d(f5518a));
    }

    public static <T extends s0> T b(Class<T> cls) {
        return (T) f5518a.b(cls);
    }

    public static w0 c() {
        return f5518a;
    }
}
