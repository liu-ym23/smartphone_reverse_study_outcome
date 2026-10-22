package bh2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<w> f19019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f19020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Class<?>> f19021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Class<?>, am3.c<?>> f19022d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f19023e = null;

    public x() {
    }

    static {
        f19023e = new x();
        f19019a = new ArrayList();
        f19021c = new LinkedHashMap();
        f19022d = new LinkedHashMap();
    }

    public final synchronized am3.c<?> a(Class<?> r100) {
        monitor-enter(this);
        Map<Class<?>, am3.c<?>> r101 = f19022d;     // Catch: Throwable -> L21
        am3.c<?> r102 = (am3.c) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L21
        if (r102 == null) goto L9;
        monitor-exit(this);
        return r102;
    L9:
        if (vh7.h.class.isAssignableFrom(r100) == true) goto L24;
    L15:
        y r103 = null;
    L16:
        if (r103 == null) goto L19;
        monitor-exit(this);
        return r103;
    L19:
        monitor-exit(this);
        return null;
    L24:
        r103 = new y(r100.getConstructor(new Class[]{am3.g.class}));     // Catch: NoSuchMethodException -> L13 Throwable -> L21
        r101.put(r100, r103);     // Catch: NoSuchMethodException -> L13 Throwable -> L21
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
