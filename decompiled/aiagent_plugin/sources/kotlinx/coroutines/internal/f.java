package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.f;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f<N extends f<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39393b = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        f39392a = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_next$volatile");
        f39393b = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_prev$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f39392a;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater l() {
        return f39393b;
    }

    public abstract boolean h();

    public f(N r1) {
        this._prev$volatile = r1;
    }

    public static final /* synthetic */ Object b(f r0) {
        return r0.a();
    }

    private final Object a() {
        return k().get(this);
    }

    public final boolean a(N r3) {
        return k().compareAndSet(this, null, r3);
    }

    public final boolean d() {
        if (c() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final N e() {
        return (N) ZeusTransformUtils.preCheckCast(l().get(this), f.class, "com.obric.aiagent.plugin");
    }

    public final void f() {
        l().set(this, null);
    }

    public final boolean g() {
        return k().compareAndSet(this, null, e.a());
    }

    public final void i() {
        if (kotlinx.coroutines.aq.a() == false) goto L16;
        if (h() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L16;
        throw new AssertionError();
    L7:
        if (d() == true) goto L10;
        r0 = false;
    L16:
        if (d() == false) goto L18;
        return;
    L18:
        f r1 = b();
        f r2 = j();
        AtomicReferenceFieldUpdater r3 = l();
    L19:
        Object r4 = r3.get(r2);
        if (((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin")) != null) goto L22;
        f r5 = null;
    L24:
        if (r3.compareAndSet(r2, r4, r5) == false) goto L19;
        if (r1 == null) goto L28;
        k().set(r1, r2);
    L28:
        if (r2.h() == false) goto L31;
        if (r2.d() == false) goto L18;
    L31:
        if (r1 == null) goto L44;
        if (r1.h() == true) goto L18;
        return;
    L44:
        return;
    L22:
        r5 = r1;
        goto L24
    }

    private final N b() {
        N r2 = (N) e();
    L3:
        if (r2 == null) goto L7;
        if (r2.h() == false) goto L7;
        r2 = (N) ZeusTransformUtils.preCheckCast(l().get(r2), f.class, "com.obric.aiagent.plugin");
    L7:
        return r2;
    }

    private final N j() {
        if (kotlinx.coroutines.aq.a() == true) goto L5;
    L9:
        N r1 = (N) c();
        d.h.b.o.a(r1);
    L11:
        if (r1.h() == false) goto L16;
        f r0 = r1.c();
        if (r0 == null) goto L14;
        r1 = (N) r0;
        goto L11
    L14:
        return r1;
    L16:
        return r1;
    L5:
        if ((!d()) == true) goto L9;
        throw new AssertionError();
    }

    public final N c() {
        Object r2 = b(this);
        if (r2 != e.a()) goto L7;
        return null;
    L7:
        return (N) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin");
    }
}
