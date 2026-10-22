package kotlin.reflect.jvm.internal.impl.storage;

import Y8.t;
import p9.InterfaceC5074l;
import xa.C5860c;
import xa.C5861d;

/* loaded from: classes5.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0458a f36071a = C0458a.f36072a;

    /* renamed from: kotlin.reflect.jvm.internal.impl.storage.a$a, reason: collision with other inner class name */
    public static final class C0458a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0458a f36072a = new C0458a();

        public final C5861d a(Runnable runnable, InterfaceC5074l<? super InterruptedException, t> interfaceC5074l) {
            return (runnable == null || interfaceC5074l == null) ? new C5861d(null, 1, null) : new C5860c(runnable, interfaceC5074l);
        }
    }

    void lock();

    void unlock();
}
