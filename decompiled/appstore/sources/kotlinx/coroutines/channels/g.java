package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BufferedChannel f21364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f21365f;

    public g(long r10, g r11, BufferedChannel r12, int r13) {
        super(r10, r11, r13);
        this.f21364e = r12;
        this.f21365f = new AtomicReferenceArray(BufferedChannelKt.f21337b * 2);
    }

    public final void A(int r10, Object r11) {
        this.f21365f.set((r10 * 2) + 1, r11);
    }

    public final void B(int r10, Object r11) {
        z(r10, r11);
    }

    @Override // kotlinx.coroutines.internal.y
    public int n() {
        return BufferedChannelKt.f21337b;
    }

    @Override // kotlinx.coroutines.internal.y
    public void o(int r10, Throwable r11, CoroutineContext r12) {
        int r13 = BufferedChannelKt.f21337b;
        if (r10 < r13) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        r10 = r10 - r13;
    L8:
        Object r15 = v(r10);
    L9:
        Object r16 = w(r10);
        if ((r16 instanceof Waiter) == true) goto L41;
        if ((r16 instanceof l) == true) goto L41;
        if (r16 == BufferedChannelKt.j()) goto L35;
        if (r16 == BufferedChannelKt.i()) goto L35;
        if (r16 == BufferedChannelKt.p()) goto L9;
        if (r16 == BufferedChannelKt.q()) goto L9;
        if (r16 != BufferedChannelKt.f()) goto L27;
        return;
    L27:
        if (r16 != BufferedChannelKt.f21339d) goto L30;
        return;
    L30:
        if (r16 != BufferedChannelKt.z()) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r16).toString());
    L35:
        s(r10);
        if (r14 == false) goto L65;
        Function1 r17 = u().f21331b;
        if (r17 == null) goto L66;
        OnUndeliveredElementKt.b(r17, r15, r12);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r14 == false) goto L43;
        b0 r18 = BufferedChannelKt.j();
    L45:
        if (r(r10, r16, r18) == false) goto L9;
        s(r10);
        x(r10, !r14);
        if (r14 == false) goto L67;
        Function1 r19 = u().f21331b;
        if (r19 == null) goto L68;
        OnUndeliveredElementKt.b(r19, r15, r12);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r18 = BufferedChannelKt.i();
        goto L45
    L5:
        r14 = false;
        goto L6
    }

    public final boolean r(int r10, Object r11, Object r12) {
        return com.google.common.util.concurrent.b.a(this.f21365f, (r10 * 2) + 1, r11, r12);
    }

    public final void s(int r10) {
        z(r10, null);
    }

    public final Object t(int r10, Object r11) {
        return this.f21365f.getAndSet((r10 * 2) + 1, r11);
    }

    public final BufferedChannel u() {
        BufferedChannel r10 = this.f21364e;
        q.d(r10);
        return r10;
    }

    public final Object v(int r10) {
        return this.f21365f.get(r10 * 2);
    }

    public final Object w(int r10) {
        return this.f21365f.get((r10 * 2) + 1);
    }

    public final void x(int r10, boolean r11) {
        if (r11 == false) goto L4;
        u().P0((this.f21630c * ((long) BufferedChannelKt.f21337b)) + ((long) r10));
    L4:
        p();
    }

    public final Object y(int r10) {
        Object r11 = v(r10);
        s(r10);
        return r11;
    }

    public final void z(int r10, Object r11) {
        this.f21365f.lazySet(r10 * 2, r11);
    }
}
