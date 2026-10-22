package buc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<e<?>, Object> f20772b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f20773a;
    private volatile T value;

    public static final class a {
    }

    static {
        f20772b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "value");
    }

    public final String toString() {
        return String.valueOf(this.value);
    }

    public final T c() {
        return this.value;
    }

    public final T b(T r100) {
        T r101 = (T) f20772b.getAndSet(this, r100);
        f r102 = this.f20773a;
        if (r102 == f.a.f20774a) goto L5;
        r102.getClass();
        f.a("getAndSet(" + r100 + "):" + r101);
    L5:
        return r101;
    }

    public final void d(T r100) {
        this.value = r100;
        f r101 = this.f20773a;
        if (r101 == f.a.f20774a) goto L6;
        r101.getClass();
        f.a("set(" + r100 + ')');
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object r100, f.a r101) {
        Intrinsics.checkNotNullParameter(r101, "trace");
        this.f20773a = r101;
        this.value = r100;
    }

    public final boolean a(T r100, T r101) {
        AtomicReferenceFieldUpdater<e<?>, Object> r102 = f20772b;
    L4:
        if (r102.compareAndSet(this, r100, r101) == true) goto L5;
        if (r102.get(this) == r100) goto L4;
        boolean r103 = false;
    L9:
        if (r103 == false) goto L13;
        f r104 = this.f20773a;
        if (r104 == f.a.f20774a) goto L13;
        r104.getClass();
        f.a("CAS(" + r100 + ", " + r101 + ')');
    L13:
        return r103;
    L5:
        r103 = true;
        goto L9
    }
}
