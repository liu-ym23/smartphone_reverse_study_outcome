package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.dk;
import kotlinx.coroutines.internal.ad;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.al;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i<E> extends ai<i<E>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<E> f38813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f38814c;

    private final /* synthetic */ AtomicReferenceArray m() {
        return this.f38814c;
    }

    public i(long r3, i<E> r5, b<E> r6, int r7) {
        super(r3, (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin"), r7);
        this.f38813b = r6;
        this.f38814c = new AtomicReferenceArray(c.f38799a * 2);
    }

    public final b<E> a() {
        b<E> r0 = this.f38813b;
        d.h.b.o.a(r0);
        return r0;
    }

    @Override // kotlinx.coroutines.internal.ai
    public int b() {
        return c.f38799a;
    }

    public final void a(int r1, E r2) {
        d(r1, r2);
    }

    public final E a(int r1) {
        return (E) m().get(r1 * 2);
    }

    public final E b(int r2) {
        E r0 = a(r2);
        c(r2);
        return r0;
    }

    public final void c(int r2) {
        d(r2, null);
    }

    private final void d(int r1, Object r2) {
        m().set(r1 * 2, r2);
    }

    public final Object d(int r1) {
        return m().get((r1 * 2) + 1);
    }

    public final void b(int r1, Object r2) {
        m().set((r1 * 2) + 1, r2);
    }

    public final boolean a(int r1, Object r2, Object r3) {
        return m().compareAndSet((r1 * 2) + 1, r2, r3);
    }

    public final Object c(int r1, Object r2) {
        return m().getAndSet((r1 * 2) + 1, r2);
    }

    @Override // kotlinx.coroutines.internal.ai
    public void a(int r4, Throwable r5, d.c.g r6) {
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin");
        if (r4 < c.f38799a) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        r4 = r4 - c.f38799a;
    L8:
        E r0 = a(r4);
    L9:
        Object r1 = d(r4);
        if (ZeusTransformUtils.instanceOf(r1, dk.class) == true) goto L41;
        if (ZeusTransformUtils.instanceOf(r1, u.class) == true) goto L41;
        if (r1 == c.e()) goto L35;
        if (r1 == c.g()) goto L35;
        if (r1 == c.m()) goto L9;
        if (r1 == c.n()) goto L9;
        if (r1 != c.f()) goto L27;
        return;
    L27:
        if (r1 != c.f38800b) goto L30;
        return;
    L30:
        if (r1 != c.b()) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r1).toString());
    L35:
        c(r4);
        if (r8 == false) goto L65;
        d.h.a.b<E, x> r3 = a().f38777a;
        if (r3 == null) goto L66;
        ad.a(r3, r0, r7);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r8 == false) goto L43;
        al r2 = c.e();
    L45:
        if (a(r4, r1, r2) == false) goto L9;
        c(r4);
        a(r4, !r8);
        if (r8 == false) goto L67;
        d.h.a.b<E, x> r9 = a().f38777a;
        if (r9 == null) goto L68;
        ad.a(r9, r0, r7);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r2 = c.g();
        goto L45
    L5:
        r8 = false;
        goto L6
    }

    public final void a(int r5, boolean r6) {
        if (r6 == false) goto L4;
        a().b((this.f39364a * ((long) c.f38799a)) + ((long) r5));
    L4:
        l();
    }
}
