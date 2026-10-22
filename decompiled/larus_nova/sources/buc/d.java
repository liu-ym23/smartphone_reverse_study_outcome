package buc;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLongFieldUpdater<d> f20770b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f20771a;
    private volatile long value;

    public static final class a {
    }

    static {
        f20770b = AtomicLongFieldUpdater.newUpdater(d.class, "value");
    }

    public final long d() {
        long r100 = f20770b.incrementAndGet(this);
        f r101 = this.f20771a;
        if (r101 == f.a.f20774a) goto L5;
        r101.getClass();
        f.a("incAndGet():" + r100);
    L5:
        return r100;
    }

    public final String toString() {
        return String.valueOf(this.value);
    }

    public final long c() {
        return this.value;
    }

    public final long a(long r100) {
        long r101 = f20770b.addAndGet(this, r100);
        f r102 = this.f20771a;
        if (r102 == f.a.f20774a) goto L5;
        r102.getClass();
        f.a("addAndGet(" + r100 + "):" + r101);
    L5:
        return r101;
    }

    public final void e(long r100) {
        this.value = r100;
        f r101 = this.f20771a;
        if (r101 == f.a.f20774a) goto L6;
        r101.getClass();
        f.a("set(" + r100 + ')');
        return;
    }

    public d(long r100, f.a r101) {
        Intrinsics.checkNotNullParameter(r101, "trace");
        this.f20771a = r101;
        this.value = r100;
    }

    public final boolean b(long r100, long r101) {
        boolean r102 = f20770b.compareAndSet(this, r100, r101);
        if (r102 == false) goto L7;
        f r103 = this.f20771a;
        if (r103 == f.a.f20774a) goto L7;
        r103.getClass();
        f.a("CAS(" + r100 + ", " + r101 + ')');
    L7:
        return r102;
    }
}
