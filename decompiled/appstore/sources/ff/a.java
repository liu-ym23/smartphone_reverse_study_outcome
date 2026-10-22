package ff;

import android.os.HandlerThread;
import com.ss.thor.ThorCallback;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HandlerThread f19678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThorCallback f19679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicInteger f19680c;

    static {
        f19680c = new AtomicInteger(0);
    }

    public static void a() {
        HandlerThread r10 = f19678a;
        if (r10 == null) goto L6;
        r10.quit();
        f19679b.onStop();
        f19678a = null;
        f19679b = null;
        return;
    }
}
