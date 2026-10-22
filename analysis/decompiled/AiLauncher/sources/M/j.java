package M;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Handler f4489a;

    public static Handler a() {
        if (f4489a != null) {
            return f4489a;
        }
        synchronized (j.class) {
            try {
                if (f4489a == null) {
                    f4489a = x0.f.a(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4489a;
    }
}
