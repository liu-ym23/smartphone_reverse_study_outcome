package sa;

import java.lang.invoke.VarHandle;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final r5.a f12171a;

    static {
        r5.a aVar = new r5.a(1);
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        n.b bVar = new n.b(1);
        bVar.f8613f = new AtomicInteger(0);
        VarHandle.storeStoreFence();
        aVar.f10462f = new ScheduledThreadPoolExecutor(iAvailableProcessors, bVar, new com.stepos.statsapp.v3.lib.plugin.emitter.remote.b(1));
        VarHandle.storeStoreFence();
        f12171a = aVar;
    }
}
