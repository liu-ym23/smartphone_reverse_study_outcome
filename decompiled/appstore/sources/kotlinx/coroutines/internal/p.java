package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21615a = null;

    @Volatile
    @Nullable
    private volatile Object _cur;

    static {
        f21615a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    }

    public p(boolean r10) {
        this._cur = new q(8, r10);
    }

    public final boolean a(Object r10) {
        AtomicReferenceFieldUpdater r11 = f21615a;
    L3:
        q r12 = (q) r11.get(this);
        int r13 = r12.a(r10);
        if (r13 == 0) goto L12;
        if (r13 != 1) goto L7;
        androidx.concurrent.futures.a.a(f21615a, this, r12, r12.i());
        goto L3
    L7:
        if (r13 != 2) goto L3;
        return false;
    L12:
        return true;
    }

    public final void b() {
        AtomicReferenceFieldUpdater r10 = f21615a;
    L3:
        q r11 = (q) r10.get(this);
        if (r11.d() == true) goto L5;
        androidx.concurrent.futures.a.a(f21615a, this, r11, r11.i());
        goto L3
    }

    public final int c() {
        return ((q) f21615a.get(this)).f();
    }

    public final Object d() {
        AtomicReferenceFieldUpdater r10 = f21615a;
    L3:
        q r11 = (q) r10.get(this);
        Object r12 = r11.j();
        if (r12 != q.f21619h) goto L5;
        androidx.concurrent.futures.a.a(f21615a, this, r11, r11.i());
        goto L3
    L5:
        return r12;
    }
}
