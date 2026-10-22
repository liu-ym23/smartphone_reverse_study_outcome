package n;

import id.k;
import java.lang.invoke.VarHandle;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import m4.d;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f8609d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f8610e = new d(1);

    /* renamed from: c, reason: collision with root package name */
    public final c f8611c;

    public a() {
        c cVar = new c();
        cVar.f8614c = new Object();
        b bVar = new b(0);
        bVar.f8613f = new AtomicInteger(0);
        VarHandle.storeStoreFence();
        cVar.f8615d = Executors.newFixedThreadPool(4, bVar);
        VarHandle.storeStoreFence();
        this.f8611c = cVar;
    }

    public static a W() {
        if (f8609d != null) {
            return f8609d;
        }
        synchronized (a.class) {
            try {
                if (f8609d == null) {
                    f8609d = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f8609d;
    }
}
