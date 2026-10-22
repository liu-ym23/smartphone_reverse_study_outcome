package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21580a = null;

    @Volatile
    @Nullable
    private volatile Object _consensus;

    static {
        f21580a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    }

    public b() {
        this._consensus = a.f21576a;
    }

    @Override // kotlinx.coroutines.internal.u
    public final Object a(Object r10) {
        Object r11 = f21580a.get(this);
        if (r11 != a.f21576a) goto L5;
        r11 = c(d(r10));
    L5:
        b(r10, r11);
        return r11;
    }

    public abstract void b(Object r10, Object r11);

    public final Object c(Object r10) {
        AtomicReferenceFieldUpdater r11 = f21580a;
        Object r12 = r11.get(this);
        Object r13 = a.f21576a;
        if (r12 == r13) goto L6;
        return r12;
    L6:
        if (androidx.concurrent.futures.a.a(r11, this, r13, r10) == false) goto L9;
        return r10;
    L9:
        return r11.get(this);
    }

    public abstract Object d(Object r10);
}
