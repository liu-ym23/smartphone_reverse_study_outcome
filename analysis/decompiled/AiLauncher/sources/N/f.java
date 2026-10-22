package N;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ScheduledExecutorService f4783a;

    public static ScheduledExecutorService a() {
        if (f4783a != null) {
            return f4783a;
        }
        synchronized (f.class) {
            try {
                if (f4783a == null) {
                    f4783a = new c(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4783a;
    }
}
