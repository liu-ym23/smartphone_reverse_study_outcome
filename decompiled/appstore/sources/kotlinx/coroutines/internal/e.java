package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21586b = null;

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    @Nullable
    private volatile Object _prev;

    static {
        f21585a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");
        f21586b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");
    }

    public e(e r10) {
        this._prev = r10;
    }

    public static final /* synthetic */ Object a(e r10) {
        return r10.f();
    }

    public final void b() {
        f21586b.lazySet(this, null);
    }

    public final e c() {
        e r10 = g();
    L3:
        if (r10 == null) goto L7;
        if (r10.h() == false) goto L7;
        r10 = (e) f21586b.get(r10);
    L7:
        return r10;
    }

    public final e d() {
        e r10 = e();
        kotlin.jvm.internal.q.d(r10);
    L4:
        if (r10.h() == false) goto L9;
        e r11 = r10.e();
        if (r11 == null) goto L7;
        r10 = r11;
        goto L4
    L7:
        return r10;
    L9:
        return r10;
    }

    public final e e() {
        Object r10 = a(this);
        if (r10 != d.a()) goto L7;
        return null;
    L7:
        return (e) r10;
    }

    public final Object f() {
        return f21585a.get(this);
    }

    public final e g() {
        return (e) f21586b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        if (e() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean j() {
        return androidx.concurrent.futures.a.a(f21585a, this, null, d.a());
    }

    public final void k() {
        if (i() == false) goto L5;
        return;
    L5:
        e r10 = c();
        e r11 = d();
        AtomicReferenceFieldUpdater r12 = f21586b;
    L6:
        Object r13 = r12.get(r11);
        if (((e) r13) != null) goto L9;
        e r14 = null;
    L11:
        if (androidx.concurrent.futures.a.a(r12, r11, r13, r14) == false) goto L6;
        if (r10 == null) goto L15;
        f21585a.set(r10, r11);
    L15:
        if (r11.h() == false) goto L18;
        if (r11.i() == false) goto L5;
    L18:
        if (r10 == null) goto L21;
        if (r10.h() == true) goto L5;
        return;
    L21:
        return;
    L9:
        r14 = r10;
        goto L11
    }

    public final boolean l(e r10) {
        return androidx.concurrent.futures.a.a(f21585a, this, null, r10);
    }
}
