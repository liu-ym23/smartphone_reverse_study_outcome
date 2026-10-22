package f4;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: f4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0721a {
    public static final void a(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                V3.a.a(th, th2);
            }
        }
    }
}
