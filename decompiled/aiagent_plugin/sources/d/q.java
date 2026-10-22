package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
final class q<T> implements f<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.h.a.a<? extends T> f38683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f38684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f38685c;

    public q(d.h.a.a<? extends T> r3, Object r4) {
        d.h.a.a<? extends T> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "initializer");
        this.f38683a = r5;
        this.f38684b = v.f38691a;
        if (r4 != null) goto L5;
        r4 = this;
    L5:
        this.f38685c = r4;
    }

    public /* synthetic */ q(d.h.a.a r2, Object r3, int r4, d.h.b.h r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r6, r3);
    }

    @Override // d.f
    public T b() {
        T r0 = (T) this.f38684b;
        if (r0 == v.f38691a) goto L5;
        return r0;
    L5:
        Object r1 = this.f38685c;
        monitor-enter(r1);
        T r2 = (T) this.f38684b;
        if (r2 != v.f38691a) goto L11;
        d.h.a.a<? extends T> r3 = this.f38683a;     // Catch: Throwable -> L13
        d.h.b.o.a(r3);     // Catch: Throwable -> L13
        r2 = r3.invoke();     // Catch: Throwable -> L13
        this.f38684b = r2;     // Catch: Throwable -> L13
        this.f38683a = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r1);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean a() {
        if (this.f38684b == v.f38691a) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (a() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(b());
    }
}
