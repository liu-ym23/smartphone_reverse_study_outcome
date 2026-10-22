package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.cm;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f39352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cm f39353b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f39354c = false;

    private aa() {
    }

    static {
        aa r0 = new aa();
        f39352a = r0;
        f39354c = am.a("kotlinx.coroutines.fast.service.loader", true);
        f39353b = r0.a();
    }

    private final cm a() {
    L25:
        th = move-exception;
        return (cm) ZeusTransformUtils.preCheckCast(ab.a(th, null, 2, null), cm.class, "com.obric.aiagent.plugin");
    L4:
        if (f39354c == false) goto L6;
        List<MainDispatcherFactory> r1 = q.f39412a.a();     // Catch: Throwable -> L25
    L7:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L25
        if (r2.hasNext() == true) goto L10;
        Object r3 = null;
    L19:
        MainDispatcherFactory r4 = (MainDispatcherFactory) ZeusTransformUtils.preCheckCast(r3, MainDispatcherFactory.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        cm r5 = ab.a(r4, r1);     // Catch: Throwable -> L25
        if (r5 == null) goto L23;
        return r5;
    L23:
        return (cm) ZeusTransformUtils.preCheckCast(ab.a(null, null, 3, null), cm.class, "com.obric.aiagent.plugin");
    L10:
        r3 = r2.next();     // Catch: Throwable -> L25
        if (r2.hasNext() == false) goto L19;
        int r6 = ((MainDispatcherFactory) ZeusTransformUtils.preCheckCast(r3, MainDispatcherFactory.class, "com.obric.aiagent.plugin")).getLoadPriority();     // Catch: Throwable -> L25
    L14:
        Object r7 = r2.next();     // Catch: Throwable -> L25
        int r8 = ((MainDispatcherFactory) ZeusTransformUtils.preCheckCast(r7, MainDispatcherFactory.class, "com.obric.aiagent.plugin")).getLoadPriority();     // Catch: Throwable -> L25
        if (r6 >= r8) goto L18;
        r3 = r7;
        r6 = r8;
    L18:
        if (r2.hasNext() == true) goto L14;
    L6:
        r1 = d.n.m.g(d.n.m.a(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));     // Catch: Throwable -> L25
        goto L7
    }
}
