package g4;

import X.f;

/* renamed from: g4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0743a {
    public static final void a(AutoCloseable autoCloseable, Throwable th) throws Exception {
        if (autoCloseable != null) {
            if (th == null) {
                f.a(autoCloseable);
                return;
            }
            try {
                f.a(autoCloseable);
            } catch (Throwable th2) {
                V3.a.a(th, th2);
            }
        }
    }
}
