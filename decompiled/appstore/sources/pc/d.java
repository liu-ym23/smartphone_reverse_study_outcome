package pc;

import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap f23451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f23452b = 0.0f;

    static {
        if (OMaterialHelper.p() < 4) goto L5;
        float r10 = 2.0f;
    L6:
        f23452b = r10;
        return;
    L5:
        r10 = 4.0f;
        goto L6
    }

    public static ConcurrentHashMap a(Object r10) {
        ConcurrentHashMap r11 = f23451a;
        if (r11 == null) goto L5;
    L15:
        return r11;
    L5:
        monitor-enter(d.class);
        r11 = f23451a;     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        ConcurrentHashMap r12 = q.b(r10, Float.class);     // Catch: Throwable -> L9
        f23451a = r12;     // Catch: Throwable -> L9
        r11 = r12;
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static Float b(Object r10, String r11) {
        return (Float) q.d(r11, a(r10));
    }

    public static void c(Object r10, Object r11, boolean r12) {
        q.e(a(r10), r11, Float.class, r12);
    }

    public static void d(Object r10, Map r11, boolean r12) {
        q.f(a(r10), r11, r12);
    }
}
