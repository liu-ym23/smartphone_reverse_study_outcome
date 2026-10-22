package w0;

import com.bytedance.apm.FluencySwitchListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f25285a;

    static {
        f25285a = new ArrayList(2);
    }

    public static synchronized void a(FluencySwitchListener r10) {
        monitor-enter(h.class);
        f25285a.add(r10);     // Catch: Throwable -> L7
        monitor-exit(h.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(h1.e r10) {
        monitor-enter(h.class);
        Iterator r11 = f25285a.iterator();     // Catch: Throwable -> L11
    L6:
        if (r11.hasNext() == false) goto L13;
        FluencySwitchListener r12 = (FluencySwitchListener) r11.next();     // Catch: Throwable -> L11
        if (r12 == null) goto L6;
        r12.onRefresh(r10);     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(h.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
