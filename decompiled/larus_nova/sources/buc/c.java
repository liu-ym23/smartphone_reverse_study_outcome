package buc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater<c> f20768b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f20769a;
    private volatile int value;

    public static final class a {
    }

    public final int a() {
        int r100 = f20768b.addAndGet(this, 1);
        f r101 = this.f20769a;
        if (r101 == f.a.f20774a) goto L5;
        r101.getClass();
        f.a("addAndGet(1):" + r100);
    L5:
        return r100;
    }

    static {
        f20768b = AtomicIntegerFieldUpdater.newUpdater(c.class, "value");
    }

    public final int c() {
        int r100 = f20768b.incrementAndGet(this);
        f r101 = this.f20769a;
        if (r101 == f.a.f20774a) goto L5;
        r101.getClass();
        f.a("incAndGet():" + r100);
    L5:
        return r100;
    }

    public final String toString() {
        return String.valueOf(this.value);
    }

    public final int b() {
        return this.value;
    }

    public c(f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        this.f20769a = r100;
        this.value = 0;
    }

    public final void d(int r100) {
        this.value = r100;
        f r101 = this.f20769a;
        if (r101 == f.a.f20774a) goto L6;
        r101.getClass();
        f.a("set(" + r100 + ')');
        return;
    }
}
