package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
final class p<T> implements f<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38666a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<p<?>, Object> f38667e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile d.h.a.a<? extends T> f38668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Object f38669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f38670d;

    /* JADX INFO: compiled from: LazyJVM.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public p(d.h.a.a<? extends T> r3) {
        d.h.a.a<? extends T> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "initializer");
        this.f38668b = r4;
        this.f38669c = v.f38691a;
        this.f38670d = v.f38691a;
    }

    @Override // d.f
    public T b() {
        T r0 = (T) this.f38669c;
        if (r0 == v.f38691a) goto L5;
        return r0;
    L5:
        d.h.a.a<? extends T> r1 = this.f38668b;
        if (r1 == null) goto L12;
        T r2 = r1.invoke();
        if (f38667e.compareAndSet(this, v.f38691a, r2) == false) goto L12;
        this.f38668b = null;
        return r2;
    L12:
        return (T) this.f38669c;
    }

    public boolean a() {
        if (this.f38669c == v.f38691a) goto L5;
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

    static {
        f38666a = new a(null);
        f38667e = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "c");
    }
}
