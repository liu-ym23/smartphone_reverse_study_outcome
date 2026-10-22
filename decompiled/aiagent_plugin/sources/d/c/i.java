package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: SafeContinuationJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i<T> implements d.c.b.a.e, d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f38424a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<i<?>, Object> f38425c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<T> f38426b;
    private volatile Object result;

    /* JADX INFO: compiled from: SafeContinuationJvm.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    @Override // d.c.b.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public i(d<? super T> r3, Object r4) {
        d<T> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r5, "delegate");
        this.f38426b = r5;
        this.result = r4;
    }

    public i(d<? super T> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "delegate");
        this(r4, d.c.a.a.f38397b);
    }

    @Override // d.c.d
    public g getContext() {
        return this.f38426b.getContext();
    }

    static {
        f38424a = new a(null);
        f38425c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");
    }

    @Override // d.c.d
    public void resumeWith(Object r4) {
    L2:
        Object r0 = this.result;
        if (r0 == d.c.a.a.f38397b) goto L5;
        if (r0 != d.c.a.b.a()) goto L14;
        if (f38425c.compareAndSet(this, d.c.a.b.a(), d.c.a.a.f38398c) == false) goto L2;
        this.f38426b.resumeWith(r4);
        return;
    L14:
        throw new IllegalStateException("Already resumed");
    L5:
        if (f38425c.compareAndSet(this, d.c.a.a.f38397b, r4) == false) goto L2;
    }

    public final Object a() {
        Object r0 = this.result;
        if (r0 != d.c.a.a.f38397b) goto L10;
        if (f38425c.compareAndSet(this, d.c.a.a.f38397b, d.c.a.b.a()) == true) goto L7;
        r0 = this.result;
        goto L10
    L7:
        return d.c.a.b.a();
    L10:
        if (r0 != d.c.a.a.f38398c) goto L13;
        return d.c.a.b.a();
    L13:
        if (ZeusTransformUtils.instanceOf(r0, n.b.class) == true) goto L16;
        return r0;
    L16:
        throw ((n.b) ZeusTransformUtils.preCheckCast(r0, n.b.class, "com.obric.aiagent.plugin")).f38562a;
    }

    @Override // d.c.b.a.e
    public d.c.b.a.e getCallerFrame() {
        d<T> r2 = this.f38426b;
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L7;
        return null;
    L7:
        return (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        return "SafeContinuation for " + this.f38426b;
    }
}
