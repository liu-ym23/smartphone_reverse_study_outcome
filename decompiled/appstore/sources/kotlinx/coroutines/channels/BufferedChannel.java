package kotlinx.coroutines.channels;

import com.bytedance.apm.constant.CommonKey;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.n;
import kotlinx.coroutines.p;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class BufferedChannel implements Channel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21321d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21322e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21323f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21324g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21325h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21326i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21327j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21328k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21329l = null;

    @Volatile
    @Nullable
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21331b;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f21332c;

    @Volatile
    @Nullable
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;

    @Volatile
    @Nullable
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    @Nullable
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    public final class a implements ChannelIterator, Waiter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f21333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n f21334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BufferedChannel f21335c;

        public a(BufferedChannel r10) {
            this.f21335c = r10;
            this.f21333a = BufferedChannelKt.m();
        }

        public static final /* synthetic */ void a(a r10) {
            r10.f();
        }

        public static final /* synthetic */ void b(a r10, n r11) {
            r10.f21334b = r11;
        }

        public static final /* synthetic */ void c(a r10, Object r11) {
            r10.f21333a = r11;
        }

        public final Object d(g r11, int r12, long r13, Continuation r15) {
            BufferedChannel r10 = this.f21335c;
            n r14 = p.b(IntrinsicsKt__IntrinsicsJvmKt.c(r15));
            b(this, r14);     // Catch: Throwable -> L6
            Object r16 = BufferedChannel.t(r10, r11, r12, r13, this);     // Catch: Throwable -> L6
            if (r16 != BufferedChannelKt.r()) goto L8;
            BufferedChannel.l(r10, this, r11, r12);     // Catch: Throwable -> L6
        L43:
            Object r17 = r14.q();
            if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L46;
            tf.d.c(r15);
        L46:
            return r17;
        L8:
            Function1 r18 = null;
            if (r16 == BufferedChannelKt.h()) goto L11;
            r11.b();     // Catch: Throwable -> L6
            c(this, r16);     // Catch: Throwable -> L6
            b(this, null);     // Catch: Throwable -> L6
            Boolean r19 = tf.a.a(true);     // Catch: Throwable -> L6
            Function1 r110 = r10.f21331b;     // Catch: Throwable -> L6
            if (r110 != null) goto L41;
        L36:
            r14.resume(r19, r18);     // Catch: Throwable -> L6
            goto L43
        L41:
            r18 = OnUndeliveredElementKt.a(r110, r16, r14.getContext());     // Catch: Throwable -> L6
            goto L36
        L11:
            if (r13 >= r10.N()) goto L13;
            r11.b();     // Catch: Throwable -> L6
        L13:
            g r111 = (g) BufferedChannel.d().get(r10);     // Catch: Throwable -> L6
        L15:
            if (r10.isClosedForReceive() == true) goto L16;
            long r112 = BufferedChannel.e().getAndIncrement(r10);     // Catch: Throwable -> L6
            int r113 = BufferedChannelKt.f21337b;     // Catch: Throwable -> L6
            long r20 = r112 / ((long) r113);     // Catch: Throwable -> L6
            int r114 = (int) (r112 % ((long) r113));     // Catch: Throwable -> L6
            if (r111.f21630c == r20) goto L23;
            g r21 = BufferedChannel.a(r10, r20, r111);     // Catch: Throwable -> L6
            if (r21 == null) goto L15;
            r111 = r21;
        L23:
            Object r22 = BufferedChannel.t(r10, r111, r114, r112, this);     // Catch: Throwable -> L6
            if (r22 == BufferedChannelKt.r()) goto L25;
            if (r22 != BufferedChannelKt.h()) goto L32;
            if (r112 >= r10.N()) goto L15;
            r111.b();     // Catch: Throwable -> L6
            goto L15
        L32:
            if (r22 == BufferedChannelKt.s()) goto L38;
            r111.b();     // Catch: Throwable -> L6
            c(this, r22);     // Catch: Throwable -> L6
            b(this, null);     // Catch: Throwable -> L6
            r19 = tf.a.a(true);     // Catch: Throwable -> L6
            Function1 r115 = r10.f21331b;     // Catch: Throwable -> L6
            if (r115 == null) goto L36;
            r18 = OnUndeliveredElementKt.a(r115, r22, r14.getContext());     // Catch: Throwable -> L6
            goto L36
        L38:
            throw new IllegalStateException("unexpected");     // Catch: Throwable -> L6
        L25:
            BufferedChannel.l(r10, this, r111, r114);     // Catch: Throwable -> L6
            goto L43
        L16:
            a(this);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            r14.A();
            throw th;
        }

        public final boolean e() {
            this.f21333a = BufferedChannelKt.z();
            Throwable r10 = this.f21335c.J();
            if (r10 != null) goto L7;
            return false;
        L7:
            throw a0.a(r10);
        }

        public final void f() {
            n r10 = this.f21334b;
            q.d(r10);
            this.f21334b = null;
            this.f21333a = BufferedChannelKt.z();
            Throwable r11 = this.f21335c.J();
            if (r11 != null) goto L5;
            Result.a r12 = Result.Companion;
            r10.resumeWith(Result.m35constructorimpl(Boolean.FALSE));
            return;
        L5:
            Result.a r13 = Result.Companion;
            r10.resumeWith(Result.m35constructorimpl(kotlin.c.a(r11)));
        }

        public final boolean g(Object r10) {
            n r11 = this.f21334b;
            q.d(r11);
            Function1 r12 = null;
            this.f21334b = null;
            this.f21333a = r10;
            Boolean r13 = Boolean.TRUE;
            Function1 r14 = this.f21335c.f21331b;
            if (r14 == null) goto L6;
            r12 = OnUndeliveredElementKt.a(r14, r10, r11.getContext());
        L6:
            return BufferedChannelKt.u(r11, r13, r12);
        }

        public final void h() {
            n r10 = this.f21334b;
            q.d(r10);
            this.f21334b = null;
            this.f21333a = BufferedChannelKt.z();
            Throwable r11 = this.f21335c.J();
            if (r11 != null) goto L5;
            Result.a r12 = Result.Companion;
            r10.resumeWith(Result.m35constructorimpl(Boolean.FALSE));
            return;
        L5:
            Result.a r13 = Result.Companion;
            r10.resumeWith(Result.m35constructorimpl(kotlin.c.a(r11)));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation r14) {
            BufferedChannel r10 = this.f21335c;
            g r11 = (g) BufferedChannel.d().get(r10);
        L4:
            if (r10.isClosedForReceive() == true) goto L37;
            long r12 = BufferedChannel.e().getAndIncrement(r10);
            int r13 = BufferedChannelKt.f21337b;
            long r15 = r12 / ((long) r13);
            int r16 = (int) (r12 % ((long) r13));
            if (r11.f21630c == r15) goto L12;
            g r17 = BufferedChannel.a(r10, r15, r11);
            if (r17 == null) goto L4;
            g r18 = r17;
        L13:
            Object r19 = BufferedChannel.t(r10, r18, r16, r12, null);
            if (r19 == BufferedChannelKt.r()) goto L28;
            if (r19 != BufferedChannelKt.h()) goto L22;
            if (r12 >= r10.N()) goto L20;
            r18.b();
        L20:
            r11 = r18;
            goto L4
        L22:
            if (r19 == BufferedChannelKt.s()) goto L24;
            r18.b();
            this.f21333a = r19;
            return tf.a.a(true);
        L24:
            return d(r18, r16, r12, r14);
        L28:
            throw new IllegalStateException("unreachable");
        L12:
            r18 = r11;
            goto L13
        L37:
            return tf.a.a(e());
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(y r10, int r11) {
            n r12 = this.f21334b;
            if (r12 == null) goto L6;
            r12.invokeOnCancellation(r10, r11);
            return;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public /* synthetic */ Object next(Continuation r10) {
            return ChannelIterator.DefaultImpls.a(this, r10);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object next() {
            Object r10 = this.f21333a;
            if (r10 == BufferedChannelKt.m()) goto L10;
            this.f21333a = BufferedChannelKt.m();
            if (r10 == BufferedChannelKt.z()) goto L8;
            return r10;
        L8:
            throw a0.a(BufferedChannel.c(this.f21335c));
        L10:
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
    }

    static {
        f21321d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
        f21322e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
        f21323f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
        f21324g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
        f21325h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
        f21326i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
        f21327j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
        f21328k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
        f21329l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");
    }

    public BufferedChannel(int r10, Function1 r11) {
        this.f21330a = r10;
        this.f21331b = r11;
        if (r10 < 0) goto L14;
        this.bufferEnd = BufferedChannelKt.t(r10);
        this.completedExpandBuffersAndPauseFlag = I();
        g r12 = new g(0, null, this, 3);
        this.sendSegment = r12;
        this.receiveSegment = r12;
        if (X() == false) goto L7;
        r12 = BufferedChannelKt.n();
        q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L7:
        this.bufferEndSegment = r12;
        if (r11 == null) goto L10;
        Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>> r13 = new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this);
    L11:
        this.f21332c = r13;
        this._closeCause = BufferedChannelKt.l();
        return;
    L10:
        r13 = null;
        goto L11
    L14:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r10 + ", should be >=0").toString());
    }

    public static /* synthetic */ Object C0(BufferedChannel r13, Object r14, Continuation r15) {
        g r10 = (g) f().get(r13);
    L3:
        long r11 = g().getAndIncrement(r13);
        long r12 = 1152921504606846975L & r11;
        boolean r16 = h(r13, r11);
        int r17 = BufferedChannelKt.f21337b;
        long r18 = r12 / ((long) r17);
        int r19 = (int) (r12 % ((long) r17));
        if (r10.f21630c == r18) goto L12;
        g r20 = b(r13, r18, r10);
        if (r20 == null) goto L7;
        r10 = r20;
        goto L12
    L7:
        if (r16 == false) goto L3;
        Object r110 = r13.i0(r14, r15);
        if (r110 != kotlin.coroutines.intrinsics.a.d()) goto L41;
        return r110;
    L41:
        return Unit.f21064a;
    L12:
        int r21 = u(r13, r10, r19, r14, r12, null, r16);
        if (r21 == 0) goto L39;
        if (r21 == 1) goto L41;
        if (r21 == 2) goto L35;
        if (r21 == 3) goto L32;
        if (r21 == 4) goto L27;
        if (r21 != 5) goto L3;
        r10.b();
        goto L3
    L27:
        if (r12 >= r13.L()) goto L29;
        r10.b();
    L29:
        Object r111 = r13.i0(r14, r15);
        if (r111 != kotlin.coroutines.intrinsics.a.d()) goto L41;
        return r111;
    L32:
        Object r112 = r13.D0(r10, r19, r14, r12, r15);
        if (r112 != kotlin.coroutines.intrinsics.a.d()) goto L41;
        return r112;
    L35:
        if (r16 == false) goto L41;
        r10.p();
        Object r113 = r13.i0(r14, r15);
        if (r113 != kotlin.coroutines.intrinsics.a.d()) goto L41;
        return r113;
    L39:
        r10.b();
        goto L41
    }

    public static /* synthetic */ void Q(BufferedChannel r10, long r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = 1;
    L6:
        r10.P(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    public static final /* synthetic */ g a(BufferedChannel r10, long r11, g r12) {
        return r10.G(r11, r12);
    }

    public static final /* synthetic */ g b(BufferedChannel r10, long r11, g r12) {
        return r10.H(r11, r12);
    }

    public static final /* synthetic */ Throwable c(BufferedChannel r10) {
        return r10.K();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater d() {
        return f21326i;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater e() {
        return f21322e;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater f() {
        return f21325h;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater g() {
        return f21321d;
    }

    public static final /* synthetic */ boolean h(BufferedChannel r10, long r11) {
        return r10.V(r11);
    }

    public static final /* synthetic */ void i(BufferedChannel r10, CancellableContinuation r11) {
        r10.e0(r11);
    }

    public static final /* synthetic */ void j(BufferedChannel r10, CancellableContinuation r11) {
        r10.f0(r11);
    }

    public static final /* synthetic */ void k(BufferedChannel r10, Object r11, CancellableContinuation r12) {
        r10.j0(r11, r12);
    }

    public static final /* synthetic */ void l(BufferedChannel r10, Waiter r11, g r12, int r13) {
        r10.m0(r11, r12, r13);
    }

    public static final /* synthetic */ void m(BufferedChannel r10, Waiter r11, g r12, int r13) {
        r10.n0(r11, r12, r13);
    }

    public static final /* synthetic */ Object n(BufferedChannel r10, Object r11, Object r12) {
        return r10.o0(r11, r12);
    }

    public static final /* synthetic */ Object o(BufferedChannel r10, Object r11, Object r12) {
        return r10.p0(r11, r12);
    }

    public static final /* synthetic */ Object p(BufferedChannel r10, Object r11, Object r12) {
        return r10.q0(r11, r12);
    }

    public static final /* synthetic */ Object q(BufferedChannel r10, Object r11, Object r12) {
        return r10.r0(r11, r12);
    }

    public static final /* synthetic */ Object r(BufferedChannel r10, g r11, int r12, long r13, Continuation r14) {
        return r10.u0(r11, r12, r13, r14);
    }

    public static final /* synthetic */ void s(BufferedChannel r10, SelectInstance r11, Object r12) {
        r10.w0(r11, r12);
    }

    public static /* synthetic */ Object s0(BufferedChannel r10, Continuation r11) {
        g r12 = (g) d().get(r10);
    L4:
        if (r10.isClosedForReceive() == true) goto L27;
        long r13 = e().getAndIncrement(r10);
        int r14 = BufferedChannelKt.f21337b;
        long r15 = r13 / ((long) r14);
        int r16 = (int) (r13 % ((long) r14));
        if (r12.f21630c == r15) goto L11;
        g r17 = a(r10, r15, r12);
        if (r17 == null) goto L4;
        r12 = r17;
    L11:
        Object r18 = t(r10, r12, r16, r13, null);
        if (r18 == BufferedChannelKt.r()) goto L25;
        if (r18 != BufferedChannelKt.h()) goto L19;
        if (r13 >= r10.N()) goto L4;
        r12.b();
        goto L4
    L19:
        if (r18 == BufferedChannelKt.s()) goto L21;
        r12.b();
        return r18;
    L21:
        return r10.v0(r12, r16, r13, r11);
    L25:
        throw new IllegalStateException("unexpected");
    L27:
        throw a0.a(r10.K());
    }

    public static final /* synthetic */ Object t(BufferedChannel r10, g r11, int r12, long r13, Object r14) {
        return r10.J0(r11, r12, r13, r14);
    }

    public static /* synthetic */ Object t0(BufferedChannel r13, Continuation r14) {
        if ((r14 instanceof BufferedChannel$receiveCatching$1) == false) goto L8;
        BufferedChannel$receiveCatching$1 r10 = (BufferedChannel$receiveCatching$1) r14;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L8;
        r10.label = r11 - Integer.MIN_VALUE;
    L7:
        BufferedChannel$receiveCatching$1 r12 = r10;
        Object r15 = r12.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r12.label;
        if (r17 == 0) goto L15;
        if (r17 != 1) goto L14;
        kotlin.c.b(r15);
        return ((f) r15).l();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlin.c.b(r15);
        g r18 = (g) d().get(r13);
    L17:
        if (r13.isClosedForReceive() == true) goto L52;
        long r19 = e().getAndIncrement(r13);
        int r20 = BufferedChannelKt.f21337b;
        long r21 = r19 / ((long) r20);
        int r22 = (int) (r19 % ((long) r20));
        if (r18.f21630c == r21) goto L25;
        g r23 = a(r13, r21, r18);
        if (r23 == null) goto L17;
        r18 = r23;
    L25:
        Object r24 = t(r13, r18, r22, r19, null);
        if (r24 == BufferedChannelKt.r()) goto L40;
        if (r24 != BufferedChannelKt.h()) goto L33;
        if (r19 >= r13.N()) goto L17;
        r18.b();
        goto L17
    L33:
        if (r24 != BufferedChannelKt.s()) goto L37;
        r12.label = 1;
        Object r110 = r13.u0(r18, r22, r19, r12);
        if (r110 != r16) goto L53;
        return r16;
    L53:
        return r110;
    L37:
        r18.b();
        return f.f21360b.c(r24);
    L40:
        throw new IllegalStateException("unexpected");
    L52:
        return f.f21360b.a(r13.J());
    L8:
        r10 = new BufferedChannel$receiveCatching$1(r13, r14);
        goto L7
    }

    public static final /* synthetic */ int u(BufferedChannel r10, g r11, int r12, Object r13, long r14, Object r15, boolean r16) {
        return r10.L0(r11, r12, r13, r14, r15, r16);
    }

    public final void A(long r10) {
        y0(B(r10));
    }

    public final void A0(Waiter r10) {
        B0(r10, false);
    }

    public final g B(long r10) {
        g r11 = y();
        if (W() == false) goto L7;
        long r12 = Y(r11);
        if (r12 == (-1)) goto L7;
        D(r12);
    L7:
        x(r11, r10);
        return r11;
    }

    public final void B0(Waiter r10, boolean r11) {
        if ((r10 instanceof CancellableContinuation) == false) goto L10;
        Continuation r12 = (Continuation) r10;
        Result.a r13 = Result.Companion;
        if (r11 == false) goto L7;
        Throwable r14 = K();
    L8:
        r12.resumeWith(Result.m35constructorimpl(kotlin.c.a(r14)));
        return;
    L7:
        r14 = M();
        goto L8
    L10:
        if ((r10 instanceof k) == false) goto L13;
        n r15 = ((k) r10).f21368a;
        Result.a r16 = Result.Companion;
        r15.resumeWith(Result.m35constructorimpl(f.b(f.f21360b.a(J()))));
        return;
    L13:
        if ((r10 instanceof a) == false) goto L16;
        ((a) r10).h();
        return;
    L16:
        if ((r10 instanceof SelectInstance) == false) goto L20;
        ((SelectInstance) r10).trySelect(this, BufferedChannelKt.z());
        return;
    L20:
        throw new IllegalStateException(("Unexpected waiter: " + r10).toString());
    }

    public final void C() {
        isClosedForSend();
    }

    public final void D(long r11) {
        g r10 = (g) f21326i.get(this);
    L3:
        AtomicLongFieldUpdater r12 = f21322e;
        long r13 = r12.get(this);
        if (r11 < Math.max(((long) this.f21330a) + r13, I())) goto L5;
        if (r12.compareAndSet(this, r13, r13 + 1) == false) goto L3;
        int r14 = BufferedChannelKt.f21337b;
        long r15 = r13 / ((long) r14);
        int r16 = (int) (r13 % ((long) r14));
        if (r10.f21630c == r15) goto L14;
        g r17 = G(r15, r10);
        if (r17 == null) goto L3;
        r10 = r17;
    L14:
        Object r18 = J0(r10, r16, r13, null);
        if (r18 == BufferedChannelKt.h()) goto L17;
        r10.b();
        Function1 r19 = this.f21331b;
        if (r19 == null) goto L3;
        UndeliveredElementException r20 = OnUndeliveredElementKt.d(r19, r18, null, 2, null);
        if (r20 == null) goto L3;
        throw r20;
    L17:
        if (r13 >= N()) goto L3;
        r10.b();
        goto L3
    }

    public final Object D0(g r21, int r22, Object r23, long r24, Continuation r26) {
        n r10 = p.b(IntrinsicsKt__IntrinsicsJvmKt.c(r26));
        int r11 = u(this, r21, r22, r23, r24, r10, false);     // Catch: Throwable -> L20
        if (r11 != 0) goto L6;
        r21.b();     // Catch: Throwable -> L20
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L20
        Object r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L20
    L48:
        r10.resumeWith(r13);     // Catch: Throwable -> L20
    L59:
        Object r14 = r10.q();
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L63;
        tf.d.c(r26);
    L63:
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L66;
        return r14;
    L66:
        return Unit.f21064a;
    L6:
        if (r11 != 1) goto L8;
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L20
        r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L20
        goto L48
    L8:
        if (r11 != 2) goto L10;
        m(this, r10, r21, r22);     // Catch: Throwable -> L20
        goto L59
    L10:
        if (r11 == 4) goto L53;
        if (r11 != 5) goto L51;
        r21.b();     // Catch: Throwable -> L20
        g r16 = (g) f().get(this);     // Catch: Throwable -> L20
    L14:
        long r17 = g().getAndIncrement(this);     // Catch: Throwable -> L20
        long r18 = r17 & 1152921504606846975L;     // Catch: Throwable -> L20
        boolean r19 = h(this, r17);     // Catch: Throwable -> L20
        int r20 = BufferedChannelKt.f21337b;     // Catch: Throwable -> L20
        long r25 = r18 / ((long) r20);     // Catch: Throwable -> L20
        int r27 = (int) (r18 % ((long) r20));     // Catch: Throwable -> L20
        if (r16.f21630c == r25) goto L23;
        g r28 = b(this, r25, r16);     // Catch: Throwable -> L20
        if (r28 == null) goto L18;
        g r29 = r28;
    L24:
        g r210 = r29;
        int r30 = u(this, r29, r27, r23, r18, r10, r19);     // Catch: Throwable -> L20
        if (r30 == 0) goto L49;
        if (r30 == 1) goto L47;
        if (r30 == 2) goto L40;
        if (r30 == 3) goto L39;
        if (r30 == 4) goto L36;
        if (r30 != 5) goto L34;
        r210.b();     // Catch: Throwable -> L20
    L34:
        r16 = r210;
        goto L14
    L36:
        if (r18 < L()) goto L37;
    L19:
        k(this, r23, r10);     // Catch: Throwable -> L20
        goto L59
    L37:
        r210.b();     // Catch: Throwable -> L20
        goto L19
    L39:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L20
    L40:
        if (r19 == false) goto L42;
        r210.p();     // Catch: Throwable -> L20
        goto L19
    L42:
        if (r10 == null) goto L44;
        n r31 = r10;
    L45:
        if (r31 == null) goto L59;
        m(this, r31, r210, r27);     // Catch: Throwable -> L20
        goto L59
    L44:
        r31 = null;
        goto L45
    L47:
        Result.a r32 = Result.Companion;     // Catch: Throwable -> L20
        r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L20
        goto L48
    L49:
        r210.b();     // Catch: Throwable -> L20
        Result.a r33 = Result.Companion;     // Catch: Throwable -> L20
        r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L20
        goto L48
    L18:
        if (r19 == false) goto L14;
    L23:
        r29 = r16;
        goto L24
    L51:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L20
    L53:
        if (r24 >= L()) goto L19;
        r21.b();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r10.A();
        throw th;
    }

    public final void E() {
        if (X() == false) goto L5;
        return;
    L5:
        g r10 = (g) f21327j.get(this);
    L6:
        long r11 = f21323f.getAndIncrement(this);
        int r12 = BufferedChannelKt.f21337b;
        long r13 = r11 / ((long) r12);
        if (N() <= r11) goto L9;
        if (r10.f21630c == r13) goto L22;
        g r14 = F(r13, r10, r11);
        if (r14 == null) goto L6;
        r10 = r14;
    L22:
        if (H0(r10, (int) (r11 % ((long) r12)), r11) == true) goto L23;
        Q(this, 0, 1, null);
        goto L6
    L23:
        Q(this, 0, 1, null);
        return;
    L9:
        if (r10.f21630c < r13) goto L11;
    L13:
        Q(this, 0, 1, null);
        return;
    L11:
        if (r10.e() == null) goto L13;
        c0(r13, r10);
        goto L13
    }

    public final boolean E0(long r10) {
        if (V(r10) == false) goto L7;
        return false;
    L7:
        return !v(r10 & 1152921504606846975L);
    }

    public final g F(long r16, g r18, long r19) {
        AtomicReferenceFieldUpdater r10 = f21327j;
        Function2 r11 = (Function2) BufferedChannelKt.y();
    L3:
        Object r12 = kotlinx.coroutines.internal.d.c(r18, r16, r11);
        if (z.c(r12) == true) goto L21;
        y r13 = z.b(r12);
    L6:
        y r14 = (y) r10.get(this);
        if (r14.f21630c >= r13.f21630c) goto L21;
        if (r13.q() == false) goto L3;
        if (androidx.concurrent.futures.a.a(r10, this, r14, r13) == true) goto L15;
        if (r13.m() == false) goto L6;
        r13.k();
        goto L6
    L15:
        if (r14.m() == false) goto L21;
        r14.k();
    L21:
        if (z.c(r12) == false) goto L23;
        C();
        c0(r16, r18);
        Q(this, 0, 1, null);
        return null;
    L23:
        g r15 = (g) z.b(r12);
        long r17 = r15.f21630c;
        if (r17 <= r16) goto L30;
        int r110 = BufferedChannelKt.f21337b;
        if (f21323f.compareAndSet(this, r19 + 1, ((long) r110) * r17) == false) goto L28;
        P((r15.f21630c * ((long) r110)) - r19);
        return null;
    L28:
        Q(this, 0, 1, null);
        return null;
    L30:
        return r15;
    }

    public final boolean F0(Object r10, Object r11) {
        if ((r10 instanceof SelectInstance) == true) goto L23;
        Function1 r12 = null;
        if ((r10 instanceof k) == false) goto L12;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        k r13 = (k) r10;
        n r14 = r13.f21368a;
        f r15 = f.b(f.f21360b.c(r11));
        Function1 r16 = this.f21331b;
        if (r16 == null) goto L24;
        r12 = OnUndeliveredElementKt.a(r16, r11, r13.f21368a.getContext());
    L24:
        return BufferedChannelKt.u(r14, r15, r12);
    L12:
        if ((r10 instanceof a) == false) goto L15;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        return ((a) r10).g(r11);
    L15:
        if ((r10 instanceof CancellableContinuation) == false) goto L22;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        CancellableContinuation r17 = (CancellableContinuation) r10;
        Function1 r18 = this.f21331b;
        if (r18 == null) goto L20;
        r12 = OnUndeliveredElementKt.a(r18, r11, r17.getContext());
    L20:
        return BufferedChannelKt.u(r17, r11, r12);
    L22:
        throw new IllegalStateException(("Unexpected receiver type: " + r10).toString());
    L23:
        return ((SelectInstance) r10).trySelect(this, r11);
    }

    public final g G(long r10, g r12) {
        AtomicReferenceFieldUpdater r11 = f21326i;
        Function2 r13 = (Function2) BufferedChannelKt.y();
    L3:
        Object r14 = kotlinx.coroutines.internal.d.c(r12, r10, r13);
        if (z.c(r14) == true) goto L21;
        y r15 = z.b(r14);
    L6:
        y r16 = (y) r11.get(this);
        if (r16.f21630c >= r15.f21630c) goto L21;
        if (r15.q() == false) goto L3;
        if (androidx.concurrent.futures.a.a(r11, this, r16, r15) == true) goto L15;
        if (r15.m() == false) goto L6;
        r15.k();
        goto L6
    L15:
        if (r16.m() == false) goto L21;
        r16.k();
    L21:
        if (z.c(r14) == false) goto L25;
        C();
        if ((r12.f21630c * ((long) BufferedChannelKt.f21337b)) >= N()) goto L64;
        r12.b();
        return null;
    L64:
        return null;
    L25:
        g r17 = (g) z.b(r14);
        if (X() == false) goto L28;
    L42:
        long r18 = r17.f21630c;
        if (r18 <= r10) goto L48;
        int r19 = BufferedChannelKt.f21337b;
        N0(r18 * ((long) r19));
        if ((r17.f21630c * ((long) r19)) >= N()) goto L66;
        r17.b();
        return null;
    L66:
        return null;
    L48:
        return r17;
    L28:
        if (r10 > (I() / ((long) BufferedChannelKt.f21337b))) goto L42;
        AtomicReferenceFieldUpdater r20 = f21327j;
    L30:
        y r21 = (y) r20.get(this);
        if (r21.f21630c >= r17.f21630c) goto L42;
        if (r17.q() == false) goto L42;
        if (androidx.concurrent.futures.a.a(r20, this, r21, r17) == true) goto L37;
        if (r17.m() == false) goto L30;
        r17.k();
        goto L30
    L37:
        if (r21.m() == false) goto L42;
        r21.k();
        goto L42
    }

    public final boolean G0(Object r10, g r11, int r12) {
        if ((r10 instanceof CancellableContinuation) == false) goto L6;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        return BufferedChannelKt.C((CancellableContinuation) r10, Unit.f21064a, null, 2, null);
    L6:
        if ((r10 instanceof SelectInstance) == false) goto L16;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult r13 = ((SelectImplementation) r10).s(this, Unit.f21064a);
        if (r13 != TrySelectDetailedResult.REREGISTER) goto L11;
        r11.s(r12);
    L11:
        if (r13 != TrySelectDetailedResult.SUCCESSFUL) goto L13;
        return true;
    L13:
        return false;
    L16:
        throw new IllegalStateException(("Unexpected waiter: " + r10).toString());
    }

    public final g H(long r10, g r12) {
        AtomicReferenceFieldUpdater r11 = f21325h;
        Function2 r13 = (Function2) BufferedChannelKt.y();
    L3:
        Object r14 = kotlinx.coroutines.internal.d.c(r12, r10, r13);
        if (z.c(r14) == true) goto L21;
        y r15 = z.b(r14);
    L6:
        y r16 = (y) r11.get(this);
        if (r16.f21630c >= r15.f21630c) goto L21;
        if (r15.q() == false) goto L3;
        if (androidx.concurrent.futures.a.a(r11, this, r16, r15) == true) goto L15;
        if (r15.m() == false) goto L6;
        r15.k();
        goto L6
    L15:
        if (r16.m() == false) goto L21;
        r16.k();
    L21:
        if (z.c(r14) == false) goto L25;
        C();
        if ((r12.f21630c * ((long) BufferedChannelKt.f21337b)) >= L()) goto L40;
        r12.b();
        return null;
    L40:
        return null;
    L25:
        g r17 = (g) z.b(r14);
        long r18 = r17.f21630c;
        if (r18 <= r10) goto L31;
        int r19 = BufferedChannelKt.f21337b;
        O0(r18 * ((long) r19));
        if ((r17.f21630c * ((long) r19)) >= L()) goto L42;
        r17.b();
        return null;
    L42:
        return null;
    L31:
        return r17;
    }

    public final boolean H0(g r10, int r11, long r12) {
        Object r13 = r10.w(r11);
        if ((r13 instanceof Waiter) == false) goto L14;
        if (r12 < f21322e.get(this)) goto L14;
        if (r10.r(r11, r13, BufferedChannelKt.p()) == false) goto L14;
        if (G0(r13, r10, r11) == false) goto L11;
        r10.A(r11, BufferedChannelKt.f21339d);
        return true;
    L11:
        r10.A(r11, BufferedChannelKt.j());
        r10.x(r11, false);
        return false;
    L14:
        return I0(r10, r11, r12);
    }

    public final long I() {
        return f21323f.get(this);
    }

    public final boolean I0(g r10, int r11, long r12) {
    L2:
        Object r13 = r10.w(r11);
        if ((r13 instanceof Waiter) == true) goto L5;
        if (r13 == BufferedChannelKt.j()) goto L18;
        if (r13 == null) goto L21;
        if (r13 == BufferedChannelKt.f21339d) goto L25;
        if (r13 == BufferedChannelKt.o()) goto L41;
        if (r13 == BufferedChannelKt.f()) goto L41;
        if (r13 == BufferedChannelKt.i()) goto L41;
        if (r13 == BufferedChannelKt.z()) goto L35;
        if (r13 == BufferedChannelKt.q()) goto L2;
        throw new IllegalStateException(("Unexpected cell state: " + r13).toString());
    L35:
        return true;
    L41:
        return true;
    L25:
        return true;
    L21:
        if (r10.r(r11, r13, BufferedChannelKt.k()) == false) goto L2;
        return true;
    L18:
        return false;
    L5:
        if (r12 < f21322e.get(this)) goto L7;
        if (r10.r(r11, r13, BufferedChannelKt.p()) == false) goto L2;
        if (G0(r13, r10, r11) == false) goto L14;
        r10.A(r11, BufferedChannelKt.f21339d);
        return true;
    L14:
        r10.A(r11, BufferedChannelKt.j());
        r10.x(r11, false);
        return false;
    L7:
        if (r10.r(r11, r13, new l((Waiter) r13)) == false) goto L2;
        return true;
    }

    public final Throwable J() {
        return (Throwable) f21328k.get(this);
    }

    public final Object J0(g r10, int r11, long r12, Object r13) {
        Object r14 = r10.w(r11);
        if (r14 != null) goto L14;
        if (r12 < (f21321d.get(this) & 1152921504606846975L)) goto L20;
        if (r13 != null) goto L10;
        return BufferedChannelKt.s();
    L10:
        if (r10.r(r11, r14, r13) == false) goto L20;
        E();
        return BufferedChannelKt.r();
    L20:
        return K0(r10, r11, r12, r13);
    L14:
        if (r14 != BufferedChannelKt.f21339d) goto L20;
        if (r10.r(r11, r14, BufferedChannelKt.f()) == false) goto L20;
        E();
        return r10.y(r11);
    }

    public final Throwable K() {
        Throwable r10 = J();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new ClosedReceiveChannelException("Channel was closed");
    }

    public final Object K0(g r10, int r11, long r12, Object r13) {
    L2:
        Object r14 = r10.w(r11);
        if (r14 == null) goto L41;
        if (r14 == BufferedChannelKt.k()) goto L41;
        if (r14 == BufferedChannelKt.f21339d) goto L10;
        if (r14 == BufferedChannelKt.j()) goto L16;
        if (r14 == BufferedChannelKt.o()) goto L20;
        if (r14 == BufferedChannelKt.z()) goto L23;
        if (r14 == BufferedChannelKt.p()) goto L2;
        if (r10.r(r11, r14, BufferedChannelKt.q()) == false) goto L2;
        boolean r15 = r14 instanceof l;
        if (r15 == false) goto L33;
        r14 = ((l) r14).f21369a;
    L33:
        if (G0(r14, r10, r11) == false) goto L35;
        r10.A(r11, BufferedChannelKt.f());
        E();
        return r10.y(r11);
    L35:
        r10.A(r11, BufferedChannelKt.j());
        r10.x(r11, false);
        if (r15 == false) goto L39;
        E();
    L39:
        return BufferedChannelKt.h();
    L23:
        E();
        return BufferedChannelKt.h();
    L20:
        return BufferedChannelKt.h();
    L16:
        return BufferedChannelKt.h();
    L10:
        if (r10.r(r11, r14, BufferedChannelKt.f()) == false) goto L2;
        E();
        return r10.y(r11);
    L41:
        if (r12 < (f21321d.get(this) & 1152921504606846975L)) goto L43;
        if (r13 == null) goto L48;
        if (r10.r(r11, r14, r13) == false) goto L2;
        E();
        return BufferedChannelKt.r();
    L48:
        return BufferedChannelKt.s();
    L43:
        if (r10.r(r11, r14, BufferedChannelKt.o()) == false) goto L2;
        E();
        return BufferedChannelKt.h();
    }

    public final long L() {
        return f21322e.get(this);
    }

    public final int L0(g r10, int r11, Object r12, long r13, Object r14, boolean r15) {
        r10.B(r11, r12);
        if (r15 == true) goto L5;
        Object r16 = r10.w(r11);
        if (r16 != null) goto L21;
        if (v(r13) == true) goto L11;
        if (r14 != null) goto L17;
        return 3;
    L17:
        if (r10.r(r11, null, r14) == false) goto L31;
        return 2;
    L31:
        return M0(r10, r11, r12, r13, r14, r15);
    L11:
        if (r10.r(r11, null, BufferedChannelKt.f21339d) == false) goto L31;
        return 1;
    L21:
        if ((r16 instanceof Waiter) == false) goto L31;
        r10.s(r11);
        if (F0(r16, r12) == false) goto L26;
        r10.A(r11, BufferedChannelKt.f());
        k0();
        return 0;
    L26:
        if (r10.t(r11, BufferedChannelKt.i()) == BufferedChannelKt.i()) goto L28;
        r10.x(r11, true);
    L28:
        return 5;
    L5:
        return M0(r10, r11, r12, r13, r14, r15);
    }

    public final Throwable M() {
        Throwable r10 = J();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new ClosedSendChannelException("Channel was closed");
    }

    public final int M0(g r10, int r11, Object r12, long r13, Object r14, boolean r15) {
    L2:
        Object r16 = r10.w(r11);
        if (r16 == null) goto L5;
        if (r16 != BufferedChannelKt.k()) goto L28;
        if (r10.r(r11, r16, BufferedChannelKt.f21339d) == false) goto L2;
        return 1;
    L28:
        if (r16 != BufferedChannelKt.i()) goto L32;
        r10.s(r11);
        return 5;
    L32:
        if (r16 != BufferedChannelKt.o()) goto L36;
        r10.s(r11);
        return 5;
    L36:
        if (r16 != BufferedChannelKt.z()) goto L39;
        r10.s(r11);
        C();
        return 4;
    L39:
        r10.s(r11);
        if ((r16 instanceof l) == false) goto L43;
        r16 = ((l) r16).f21369a;
    L43:
        if (F0(r16, r12) == false) goto L46;
        r10.A(r11, BufferedChannelKt.f());
        k0();
        return 0;
    L46:
        if (r10.t(r11, BufferedChannelKt.i()) == BufferedChannelKt.i()) goto L49;
        r10.x(r11, true);
    L49:
        return 5;
    L5:
        if (v(r13) == false) goto L10;
        if (r15 == true) goto L10;
        if (r10.r(r11, null, BufferedChannelKt.f21339d) == false) goto L2;
        return 1;
    L10:
        if (r15 == true) goto L12;
        if (r14 == null) goto L16;
        if (r10.r(r11, null, r14) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r10.r(r11, null, BufferedChannelKt.j()) == false) goto L2;
        r10.x(r11, false);
        return 4;
    }

    public final long N() {
        return f21321d.get(this) & 1152921504606846975L;
    }

    public final void N0(long r10) {
        AtomicLongFieldUpdater r11 = f21322e;
    L3:
        long r12 = r11.get(this);
        if (r12 >= r10) goto L5;
        if (f21322e.compareAndSet(this, r12, r10) == false) goto L3;
        return;
    }

    public final boolean O() {
    L2:
        AtomicReferenceFieldUpdater r10 = f21326i;
        g r11 = (g) r10.get(this);
        long r12 = L();
        if (N() <= r12) goto L4;
        int r13 = BufferedChannelKt.f21337b;
        long r14 = r12 / ((long) r13);
        if (r11.f21630c == r14) goto L12;
        r11 = G(r14, r11);
        if (r11 != null) goto L12;
        if (((g) r10.get(this)).f21630c >= r14) goto L2;
        return false;
    L12:
        r11.b();
        if (S(r11, (int) (r12 % ((long) r13)), r12) == true) goto L14;
        f21322e.compareAndSet(this, r12, r12 + 1);
        goto L2
    L14:
        return true;
    L4:
        return false;
    }

    public final void O0(long r10) {
        AtomicLongFieldUpdater r11 = f21321d;
    L3:
        long r12 = r11.get(this);
        long r13 = 1152921504606846975L & r12;
        if (r13 >= r10) goto L5;
        long r14 = BufferedChannelKt.b(r13, (int) (r12 >> 60));
        if (f21321d.compareAndSet(this, r12, r14) == false) goto L3;
        return;
    }

    public final void P(long r10) {
        if ((f21324g.addAndGet(this, r10) & Longs.MAX_POWER_OF_TWO) != 0) goto L5;
        return;
    L5:
        if ((f21324g.get(this) & Longs.MAX_POWER_OF_TWO) != 0) goto L5;
    }

    public final void P0(long r14) {
        if (X() == false) goto L6;
        return;
    L6:
        if (I() <= r14) goto L6;
        int r15 = BufferedChannelKt.g();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L16;
        long r10 = I();
        if (r10 != (4611686018427387903L & f21324g.get(this))) goto L15;
        if (r10 != I()) goto L15;
        return;
    L15:
        r16 = r16 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r11 = f21324g;
    L17:
        long r12 = r11.get(this);
        if (r11.compareAndSet(this, r12, BufferedChannelKt.a(r12 & 4611686018427387903L, true)) == false) goto L17;
    L19:
        long r17 = I();
        AtomicLongFieldUpdater r13 = f21324g;
        long r18 = r13.get(this);
        long r19 = r18 & 4611686018427387903L;
        if ((Longs.MAX_POWER_OF_TWO & r18) == 0) goto L22;
        boolean r20 = true;
    L24:
        if (r17 == r19) goto L26;
    L30:
        if (r20 == true) goto L19;
        r13.compareAndSet(this, r18, BufferedChannelKt.a(r19, true));
        goto L19
    L26:
        if (r17 != I()) goto L30;
    L27:
        long r21 = r13.get(this);
        if (r13.compareAndSet(this, r21, BufferedChannelKt.a(r21 & 4611686018427387903L, false)) == false) goto L27;
        return;
    L22:
        r20 = false;
        goto L24
    }

    public final void R() {
        AtomicReferenceFieldUpdater r10 = f21329l;
    L3:
        Object r11 = r10.get(this);
        if (r11 != null) goto L6;
        b0 r12 = BufferedChannelKt.d();
    L8:
        if (androidx.concurrent.futures.a.a(r10, this, r11, r12) == false) goto L3;
        if (r11 != null) goto L11;
        return;
    L11:
        Function1 r13 = (Function1) kotlin.jvm.internal.y.e(r11, 1);
        ((Function1) r11).invoke(J());
        return;
    L6:
        r12 = BufferedChannelKt.e();
        goto L8
    }

    public final boolean S(g r10, int r11, long r12) {
    L2:
        Object r13 = r10.w(r11);
        if (r13 == null) goto L33;
        if (r13 == BufferedChannelKt.k()) goto L33;
        if (r13 != BufferedChannelKt.f21339d) goto L11;
        return true;
    L11:
        if (r13 != BufferedChannelKt.j()) goto L14;
        return false;
    L14:
        if (r13 != BufferedChannelKt.z()) goto L17;
        return false;
    L17:
        if (r13 != BufferedChannelKt.f()) goto L20;
        return false;
    L20:
        if (r13 != BufferedChannelKt.o()) goto L23;
        return false;
    L23:
        if (r13 != BufferedChannelKt.p()) goto L26;
        return true;
    L26:
        if (r13 != BufferedChannelKt.q()) goto L29;
        return false;
    L29:
        if (r12 == L()) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r10.r(r11, r13, BufferedChannelKt.o()) == false) goto L2;
        E();
        return false;
    }

    public final boolean T(long r10, boolean r11) {
        int r12 = (int) (r10 >> 60);
        if (r12 != 0) goto L5;
        return false;
    L5:
        if (r12 != 1) goto L7;
        return false;
    L7:
        if (r12 != 2) goto L9;
        B(r10 & 1152921504606846975L);
        if (r11 == true) goto L17;
    L21:
        return true;
    L17:
        if (O() == false) goto L21;
        return false;
    L9:
        if (r12 != 3) goto L13;
        A(r10 & 1152921504606846975L);
        goto L21
    L13:
        throw new IllegalStateException(("unexpected close status: " + r12).toString());
    }

    public final boolean U(long r10) {
        return T(r10, true);
    }

    public final boolean V(long r10) {
        return T(r10, false);
    }

    public boolean W() {
        return false;
    }

    public final boolean X() {
        long r10 = I();
        if (r10 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 == Long.MAX_VALUE) goto L8;
        return false;
    }

    public final long Y(g r10) {
    L2:
        int r11 = BufferedChannelKt.f21337b;
    L3:
        r11 = r11 - 1;
        if ((-1) >= r11) goto L20;
        long r12 = (r10.f21630c * ((long) BufferedChannelKt.f21337b)) + ((long) r11);
        if (r12 < L()) goto L7;
    L8:
        Object r13 = r10.w(r11);
        if (r13 == null) goto L17;
        if (r13 == BufferedChannelKt.k()) goto L17;
        if (r13 != BufferedChannelKt.f21339d) goto L3;
        return r12;
    L17:
        if (r10.r(r11, r13, BufferedChannelKt.z()) == false) goto L8;
        r10.p();
        goto L3
    L7:
        return -1;
    L20:
        r10 = (g) r10.g();
        if (r10 != null) goto L2;
        return -1;
    }

    public final void Z() {
        AtomicLongFieldUpdater r10 = f21321d;
    L3:
        long r11 = r10.get(this);
        if (((int) (r11 >> 60)) != 0) goto L7;
        if (r10.compareAndSet(this, r11, BufferedChannelKt.b(1152921504606846975L & r11, 1)) == false) goto L3;
        return;
    }

    public final void a0() {
        AtomicLongFieldUpdater r10 = f21321d;
    L3:
        long r11 = r10.get(this);
        if (r10.compareAndSet(this, r11, BufferedChannelKt.b(1152921504606846975L & r11, 3)) == false) goto L3;
    }

    public final void b0() {
        AtomicLongFieldUpdater r10 = f21321d;
    L3:
        long r11 = r10.get(this);
        int r12 = (int) (r11 >> 60);
        if (r12 != 0) goto L6;
        long r13 = BufferedChannelKt.b(r11 & 1152921504606846975L, 2);
    L12:
        if (r10.compareAndSet(this, r11, r13) == false) goto L3;
        return;
    L6:
        if (r12 != 1) goto L7;
        r13 = BufferedChannelKt.b(r11 & 1152921504606846975L, 3);
        goto L12
    }

    public final void c0(long r10, g r11) {
    L3:
        if (r11.f21630c >= r10) goto L9;
        g r12 = (g) r11.e();
        if (r12 == null) goto L9;
        r11 = r12;
    L9:
        if (r11.h() == false) goto L14;
        g r13 = (g) r11.e();
        if (r13 == null) goto L14;
        r11 = r13;
    L14:
        AtomicReferenceFieldUpdater r14 = f21327j;
    L15:
        y r15 = (y) r14.get(this);
        if (r15.f21630c >= r11.f21630c) goto L46;
        if (r11.q() == false) goto L9;
        if (androidx.concurrent.futures.a.a(r14, this, r15, r11) == true) goto L24;
        if (r11.m() == false) goto L15;
        r11.k();
        goto L15
    L24:
        if (r15.m() == false) goto L45;
        r15.k();
        return;
    L45:
        return;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable r10) {
        return w(r10);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r10) {
        return z(r10, false);
    }

    public void d0() {
    }

    public final void e0(CancellableContinuation r10) {
        Result.a r11 = Result.Companion;
        r10.resumeWith(Result.m35constructorimpl(f.b(f.f21360b.a(J()))));
    }

    public final void f0(CancellableContinuation r10) {
        Result.a r11 = Result.Companion;
        r10.resumeWith(Result.m35constructorimpl(kotlin.c.a(K())));
    }

    public final void g0(SelectInstance r10) {
        r10.selectInRegistrationPhase(BufferedChannelKt.z());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceive() {
        BufferedChannel$onReceive$1 r10 = BufferedChannel$onReceive$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) kotlin.jvm.internal.y.e(r10, 3);
        BufferedChannel$onReceive$2 r12 = BufferedChannel$onReceive$2.INSTANCE;
        q.e(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, r11, (Function3) kotlin.jvm.internal.y.e(r12, 3), this.f21332c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 r10 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) kotlin.jvm.internal.y.e(r10, 3);
        BufferedChannel$onReceiveCatching$2 r12 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        q.e(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, r11, (Function3) kotlin.jvm.internal.y.e(r12, 3), this.f21332c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 r10 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) kotlin.jvm.internal.y.e(r10, 3);
        BufferedChannel$onReceiveOrNull$2 r12 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        q.e(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, r11, (Function3) kotlin.jvm.internal.y.e(r12, 3), this.f21332c);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 getOnSend() {
        BufferedChannel$onSend$1 r10 = BufferedChannel$onSend$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) kotlin.jvm.internal.y.e(r10, 3);
        BufferedChannel$onSend$2 r12 = BufferedChannel$onSend$2.INSTANCE;
        q.e(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.e(this, r11, (Function3) kotlin.jvm.internal.y.e(r12, 3), null, 8, null);
    }

    public final void h0(Object r10, SelectInstance r11) {
        Function1 r12 = this.f21331b;
        if (r12 == null) goto L5;
        OnUndeliveredElementKt.b(r12, r10, r11.getContext());
    L5:
        r11.selectInRegistrationPhase(BufferedChannelKt.z());
    }

    public final Object i0(Object r10, Continuation r11) {
        n r12 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r11), 1);
        r12.initCancellability();
        Function1 r13 = this.f21331b;
        if (r13 == null) goto L7;
        UndeliveredElementException r14 = OnUndeliveredElementKt.d(r13, r10, null, 2, null);
        if (r14 == null) goto L7;
        kotlin.a.a(r14, M());
        Result.a r15 = Result.Companion;
        r12.resumeWith(Result.m35constructorimpl(kotlin.c.a(r14)));
    L8:
        Object r16 = r12.q();
        if (r16 != kotlin.coroutines.intrinsics.a.d()) goto L12;
        tf.d.c(r11);
    L12:
        if (r16 != kotlin.coroutines.intrinsics.a.d()) goto L15;
        return r16;
    L15:
        return Unit.f21064a;
    L7:
        Throwable r17 = M();
        Result.a r18 = Result.Companion;
        r12.resumeWith(Result.m35constructorimpl(kotlin.c.a(r17)));
        goto L8
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 r10) {
        AtomicReferenceFieldUpdater r11 = f21329l;
        if (androidx.concurrent.futures.a.a(r11, this, null, r10) == false) goto L5;
        return;
    L5:
        Object r12 = r11.get(this);
        if (r12 != BufferedChannelKt.d()) goto L12;
        if (androidx.concurrent.futures.a.a(f21329l, this, BufferedChannelKt.d(), BufferedChannelKt.e()) == false) goto L5;
        r10.invoke(J());
        return;
    L12:
        if (r12 != BufferedChannelKt.e()) goto L16;
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
    L16:
        throw new IllegalStateException(("Another handler is already registered: " + r12).toString());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return U(f21321d.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return V(f21321d.get(this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() == false) goto L6;
        return false;
    L6:
        if (O() == false) goto L9;
        return false;
    L9:
        return !isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator iterator() {
        return new a(this);
    }

    public final void j0(Object r10, CancellableContinuation r11) {
        Function1 r12 = this.f21331b;
        if (r12 == null) goto L5;
        OnUndeliveredElementKt.b(r12, r10, r11.getContext());
    L5:
        Throwable r13 = M();
        Result.a r14 = Result.Companion;
        r11.resumeWith(Result.m35constructorimpl(kotlin.c.a(r13)));
    }

    public void k0() {
    }

    public void l0() {
    }

    public final void m0(Waiter r10, g r11, int r12) {
        l0();
        r10.invokeOnCancellation(r11, r12);
    }

    public final void n0(Waiter r10, g r11, int r12) {
        r10.invokeOnCancellation(r11, r12 + BufferedChannelKt.f21337b);
    }

    public final Object o0(Object r10, Object r11) {
        if (r11 == BufferedChannelKt.z()) goto L6;
        return r11;
    L6:
        throw K();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(Object r10) {
        return Channel.a.a(this, r10);
    }

    public final Object p0(Object r10, Object r11) {
        if (r11 != BufferedChannelKt.z()) goto L5;
        Object r12 = f.f21360b.a(J());
    L7:
        return f.b(r12);
    L5:
        r12 = f.f21360b.c(r11);
        goto L7
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object poll() {
        return Channel.a.b(this);
    }

    public final Object q0(Object r10, Object r11) {
        if (r11 == BufferedChannelKt.z()) goto L5;
        return r11;
    L5:
        if (J() != null) goto L8;
        return null;
    L8:
        throw K();
    }

    public final Object r0(Object r10, Object r11) {
        if (r11 == BufferedChannelKt.z()) goto L6;
        return this;
    L6:
        throw M();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation r10) {
        return s0(this, r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo51receiveCatchingJP2dKIU(Continuation r10) {
        return t0(this, r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receiveOrNull(Continuation r10) {
        return Channel.a.c(this, r10);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(Object r10, Continuation r11) {
        return C0(this, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        int r11 = (int) (f21321d.get(this) >> 60);
        if (r11 == 2) goto L7;
        if (r11 != 3) goto L8;
        r10.append("cancelled,");
    L8:
        r10.append("capacity=" + this.f21330a + ',');
        r10.append("data=[");
        int r12 = 0;
        List r13 = t.l(new g[]{f21326i.get(this), f21325h.get(this), f21327j.get(this)});
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();
        if (((g) r16) == BufferedChannelKt.n()) goto L10;
        r14.add(r16);
        goto L10
    L14:
        Iterator r17 = r14.iterator();
        if (r17.hasNext() == false) goto L97;
        Object r18 = r17.next();
        if (r17.hasNext() == false) goto L25;
        long r19 = ((g) r18).f21630c;
    L20:
        Object r20 = r17.next();
        long r110 = ((g) r20).f21630c;
        if (r19 <= r110) goto L24;
        r18 = r20;
        r19 = r110;
    L24:
        if (r17.hasNext() == true) goto L20;
    L25:
        g r21 = (g) r18;
        long r111 = L();
        long r112 = N();
    L26:
        int r22 = BufferedChannelKt.f21337b;
        int r23 = r12;
    L27:
        if (r23 >= r22) goto L88;
        long r24 = (r21.f21630c * ((long) BufferedChannelKt.f21337b)) + ((long) r23);
        if (r24 >= r112) goto L31;
    L32:
        Object r113 = r21.w(r23);
        Object r114 = r21.v(r23);
        if ((r113 instanceof CancellableContinuation) == false) goto L43;
        if (r24 >= r111) goto L38;
        if (r24 < r112) goto L38;
        String r25 = "receive";
    L84:
        if (r114 == null) goto L86;
        r10.append('(' + r25 + ',' + r114 + "),");
    L87:
        r23 = r23 + 1;
        goto L27
    L86:
        r10.append(r25 + ',');
    L38:
        if (r24 >= r112) goto L41;
        if (r24 < r111) goto L41;
        r25 = CommonKey.KEY_SEND;
    L41:
        r25 = "cont";
        goto L84
    L43:
        if ((r113 instanceof SelectInstance) == false) goto L53;
        if (r24 >= r111) goto L48;
        if (r24 < r112) goto L48;
        r25 = "onReceive";
    L48:
        if (r24 >= r112) goto L51;
        if (r24 < r111) goto L51;
        r25 = "onSend";
    L51:
        r25 = "select";
        goto L84
    L53:
        if ((r113 instanceof k) == false) goto L56;
        r25 = "receiveCatching";
        goto L84
    L56:
        if ((r113 instanceof l) == false) goto L59;
        r25 = "EB(" + r113 + ')';
        goto L84
    L59:
        if (q.b(r113, BufferedChannelKt.q()) == false) goto L61;
        boolean r26 = true;
    L62:
        if (r26 == false) goto L64;
        r25 = "resuming_sender";
        goto L84
    L64:
        if (r113 != null) goto L66;
        boolean r27 = true;
    L67:
        if (r27 == false) goto L69;
        boolean r28 = true;
    L70:
        if (r28 == false) goto L72;
        boolean r29 = true;
    L73:
        if (r29 == false) goto L75;
        boolean r30 = true;
    L76:
        if (r30 == false) goto L78;
        boolean r31 = true;
    L79:
        if (r31 == false) goto L81;
        boolean r32 = true;
    L82:
        if (r32 == true) goto L87;
        r25 = r113.toString();
        goto L84
    L81:
        r32 = q.b(r113, BufferedChannelKt.z());
        goto L82
    L78:
        r31 = q.b(r113, BufferedChannelKt.j());
        goto L79
    L75:
        r30 = q.b(r113, BufferedChannelKt.i());
        goto L76
    L72:
        r29 = q.b(r113, BufferedChannelKt.o());
        goto L73
    L69:
        r28 = q.b(r113, BufferedChannelKt.f());
        goto L70
    L66:
        r27 = q.b(r113, BufferedChannelKt.k());
        goto L67
    L61:
        r26 = q.b(r113, BufferedChannelKt.p());
        goto L62
    L31:
        if (r24 < r111) goto L32;
    L91:
        if (kotlin.text.q.E0(r10) != ',') goto L93;
        q.f(r10.deleteCharAt(r10.length() - 1), "this.deleteCharAt(index)");
    L93:
        r10.append("]");
        return r10.toString();
    L88:
        r21 = (g) r21.e();
        if (r21 == null) goto L91;
        r12 = 0;
        goto L26
    L97:
        throw new NoSuchElementException();
    L7:
        r10.append("closed,");
        goto L8
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo52tryReceivePtdJZtk() {
        long r10 = f21322e.get(this);
        long r11 = f21321d.get(this);
        if (U(r11) == false) goto L7;
        return f.f21360b.a(J());
    L7:
        if (r10 >= (r11 & 1152921504606846975L)) goto L9;
        Object r12 = BufferedChannelKt.i();
        g r13 = (g) d().get(this);
    L12:
        if (isClosedForReceive() == true) goto L50;
        long r14 = e().getAndIncrement(this);
        int r15 = BufferedChannelKt.f21337b;
        long r16 = r14 / ((long) r15);
        int r17 = (int) (r14 % ((long) r15));
        if (r13.f21630c == r16) goto L20;
        g r18 = a(this, r16, r13);
        if (r18 == null) goto L12;
        g r19 = r18;
    L21:
        Object r20 = t(this, r19, r17, r14, r12);
        if (r20 == BufferedChannelKt.r()) goto L24;
        if (r20 != BufferedChannelKt.h()) goto L37;
        if (r14 >= N()) goto L35;
        r19.b();
    L35:
        r13 = r19;
        goto L12
    L37:
        if (r20 == BufferedChannelKt.s()) goto L41;
        r19.b();
        return f.f21360b.c(r20);
    L41:
        throw new IllegalStateException("unexpected");
    L24:
        if ((r12 instanceof Waiter) == false) goto L26;
        Waiter r21 = (Waiter) r12;
    L27:
        if (r21 == null) goto L29;
        l(this, r21, r19, r17);
    L29:
        P0(r14);
        r19.p();
        return f.f21360b.b();
    L26:
        r21 = null;
        goto L27
    L20:
        r19 = r13;
        goto L21
    L50:
        return f.f21360b.a(J());
    L9:
        return f.f21360b.b();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo53trySendJP2dKIU(Object r15) {
        if (E0(f21321d.get(this)) == true) goto L5;
        Object r10 = BufferedChannelKt.j();
        g r11 = (g) f().get(this);
    L7:
        long r12 = g().getAndIncrement(this);
        long r13 = r12 & 1152921504606846975L;
        boolean r14 = h(this, r12);
        int r16 = BufferedChannelKt.f21337b;
        long r17 = r13 / ((long) r16);
        int r18 = (int) (r13 % ((long) r16));
        if (r11.f21630c == r17) goto L14;
        g r19 = b(this, r17, r11);
        if (r19 == null) goto L11;
        g r110 = r19;
    L15:
        int r20 = u(this, r110, r18, r15, r13, r10, r14);
        if (r20 == 0) goto L45;
        if (r20 == 1) goto L60;
        if (r20 == 2) goto L35;
        if (r20 == 3) goto L34;
        if (r20 == 4) goto L31;
        if (r20 != 5) goto L29;
        r110.b();
    L29:
        r11 = r110;
        goto L7
    L31:
        if (r13 >= L()) goto L46;
        r110.b();
    L46:
        return f.f21360b.a(M());
    L34:
        throw new IllegalStateException("unexpected");
    L35:
        if (r14 == false) goto L38;
        r110.p();
        goto L46
    L38:
        if ((r10 instanceof Waiter) == false) goto L40;
        Waiter r21 = (Waiter) r10;
    L41:
        if (r21 == null) goto L43;
        m(this, r21, r110, r18);
    L43:
        r110.p();
        return f.f21360b.b();
    L40:
        r21 = null;
    L60:
        return f.f21360b.c(Unit.f21064a);
    L45:
        r110.b();
        goto L60
    L11:
        if (r14 == false) goto L7;
    L14:
        r110 = r11;
        goto L15
    L5:
        return f.f21360b.b();
    }

    public final Object u0(g r11, int r12, long r13, Continuation r15) {
        if ((r15 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) == false) goto L7;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r10 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r15;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r10.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        g r19 = (g) r10.L$1;
        BufferedChannel r110 = (BufferedChannel) r10.L$0;
        kotlin.c.b(r16);
    L61:
        return ((f) r16).l();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r16);
        r10.L$0 = this;
        r10.L$1 = r11;
        r10.I$0 = r12;
        r10.J$0 = r13;
        r10.label = 1;
        n r111 = p.b(IntrinsicsKt__IntrinsicsJvmKt.c(r10));
        q.e(r111, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");     // Catch: Throwable -> L18
        k r20 = new k(r111);     // Catch: Throwable -> L18
        Object r21 = t(this, r11, r12, r13, r20);     // Catch: Throwable -> L18
        if (r21 != BufferedChannelKt.r()) goto L20;
        l(this, r20, r11, r12);     // Catch: Throwable -> L18
    L55:
        r16 = r111.q();
        if (r16 != kotlin.coroutines.intrinsics.a.d()) goto L58;
        tf.d.c(r10);
    L58:
        if (r16 != r17) goto L61;
        return r17;
    L20:
        Function1 r22 = null;
        if (r21 == BufferedChannelKt.h()) goto L23;
        r11.b();     // Catch: Throwable -> L18
        f r112 = f.b(f.f21360b.c(r21));     // Catch: Throwable -> L18
        Function1 r113 = this.f21331b;     // Catch: Throwable -> L18
        if (r113 != null) goto L53;
    L48:
        r111.resume(r112, r22);     // Catch: Throwable -> L18
        goto L55
    L53:
        r22 = OnUndeliveredElementKt.a(r113, r21, r111.getContext());     // Catch: Throwable -> L18
        goto L48
    L23:
        if (r13 >= N()) goto L25;
        r11.b();     // Catch: Throwable -> L18
    L25:
        g r114 = (g) d().get(this);     // Catch: Throwable -> L18
    L27:
        if (isClosedForReceive() == true) goto L28;
        long r115 = e().getAndIncrement(this);     // Catch: Throwable -> L18
        int r116 = BufferedChannelKt.f21337b;     // Catch: Throwable -> L18
        long r23 = r115 / ((long) r116);     // Catch: Throwable -> L18
        int r117 = (int) (r115 % ((long) r116));     // Catch: Throwable -> L18
        if (r114.f21630c == r23) goto L35;
        g r24 = a(this, r23, r114);     // Catch: Throwable -> L18
        if (r24 == null) goto L27;
        r114 = r24;
    L35:
        Object r25 = t(this, r114, r117, r115, r20);     // Catch: Throwable -> L18
        if (r25 == BufferedChannelKt.r()) goto L37;
        if (r25 != BufferedChannelKt.h()) goto L44;
        if (r115 >= N()) goto L27;
        r114.b();     // Catch: Throwable -> L18
        goto L27
    L44:
        if (r25 == BufferedChannelKt.s()) goto L50;
        r114.b();     // Catch: Throwable -> L18
        r112 = f.b(f.f21360b.c(r25));     // Catch: Throwable -> L18
        Function1 r118 = this.f21331b;     // Catch: Throwable -> L18
        if (r118 == null) goto L48;
        r22 = OnUndeliveredElementKt.a(r118, r25, r111.getContext());     // Catch: Throwable -> L18
        goto L48
    L50:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L18
    L37:
        l(this, r20, r114, r117);     // Catch: Throwable -> L18
        goto L55
    L28:
        i(this, r111);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r111.A();
        throw th;
    L7:
        r10 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r15);
        goto L8
    }

    public final boolean v(long r10) {
        if (r10 >= I()) goto L5;
    L8:
        return true;
    L5:
        if (r10 < (L() + ((long) this.f21330a))) goto L8;
        return false;
    }

    public final Object v0(g r10, int r11, long r12, Continuation r13) {
        n r14 = p.b(IntrinsicsKt__IntrinsicsJvmKt.c(r13));
        Object r15 = t(this, r10, r11, r12, r14);     // Catch: Throwable -> L6
        if (r15 != BufferedChannelKt.r()) goto L8;
        l(this, r14, r10, r11);     // Catch: Throwable -> L6
    L46:
        Object r16 = r14.q();
        if (r16 != kotlin.coroutines.intrinsics.a.d()) goto L49;
        tf.d.c(r13);
    L49:
        return r16;
    L8:
        Function1 r17 = null;
        r17 = null;
        n r18 = null;
        if (r15 == BufferedChannelKt.h()) goto L11;
        r10.b();     // Catch: Throwable -> L6
        Function1 r19 = this.f21331b;     // Catch: Throwable -> L6
        if (r19 != null) goto L44;
    L39:
        r14.resume(r15, r17);     // Catch: Throwable -> L6
        goto L46
    L44:
        r17 = OnUndeliveredElementKt.a(r19, r15, r14.getContext());     // Catch: Throwable -> L6
        goto L39
    L11:
        if (r12 >= N()) goto L13;
        r10.b();     // Catch: Throwable -> L6
    L13:
        g r20 = (g) d().get(this);     // Catch: Throwable -> L6
    L15:
        if (isClosedForReceive() == true) goto L16;
        long r110 = e().getAndIncrement(this);     // Catch: Throwable -> L6
        int r111 = BufferedChannelKt.f21337b;     // Catch: Throwable -> L6
        long r21 = r110 / ((long) r111);     // Catch: Throwable -> L6
        int r112 = (int) (r110 % ((long) r111));     // Catch: Throwable -> L6
        if (r20.f21630c == r21) goto L23;
        g r22 = a(this, r21, r20);     // Catch: Throwable -> L6
        if (r22 == null) goto L15;
        r20 = r22;
    L23:
        r15 = t(this, r20, r112, r110, r14);     // Catch: Throwable -> L6
        if (r15 == BufferedChannelKt.r()) goto L25;
        if (r15 != BufferedChannelKt.h()) goto L35;
        if (r110 >= N()) goto L15;
        r20.b();     // Catch: Throwable -> L6
        goto L15
    L35:
        if (r15 == BufferedChannelKt.s()) goto L41;
        r20.b();     // Catch: Throwable -> L6
        Function1 r23 = this.f21331b;     // Catch: Throwable -> L6
        if (r23 == null) goto L39;
        r17 = OnUndeliveredElementKt.a(r23, r15, r14.getContext());     // Catch: Throwable -> L6
        goto L39
    L41:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L6
    L25:
        if (r14 == null) goto L27;
        r18 = r14;
    L27:
        if (r18 == null) goto L46;
        l(this, r18, r20, r112);     // Catch: Throwable -> L6
        goto L46
    L16:
        j(this, r14);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r14.A();
        throw th;
    }

    public boolean w(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new CancellationException("Channel was cancelled");
    L5:
        return z(r10, true);
    }

    public final void w0(SelectInstance r10, Object r11) {
        g r12 = (g) d().get(this);
    L4:
        if (isClosedForReceive() == true) goto L5;
        long r13 = e().getAndIncrement(this);
        int r14 = BufferedChannelKt.f21337b;
        long r15 = r13 / ((long) r14);
        int r16 = (int) (r13 % ((long) r14));
        if (r12.f21630c == r15) goto L12;
        g r17 = a(this, r15, r12);
        if (r17 == null) goto L4;
        r12 = r17;
    L12:
        Object r18 = t(this, r12, r16, r13, r10);
        if (r18 == BufferedChannelKt.r()) goto L15;
        if (r18 != BufferedChannelKt.h()) goto L26;
        if (r13 >= N()) goto L4;
        r12.b();
        goto L4
    L26:
        if (r18 == BufferedChannelKt.s()) goto L30;
        r12.b();
        r10.selectInRegistrationPhase(r18);
        return;
    L30:
        throw new IllegalStateException("unexpected");
    L15:
        if ((r10 instanceof Waiter) == false) goto L17;
        Waiter r19 = (Waiter) r10;
    L18:
        if (r19 == null) goto L42;
        l(this, r19, r12, r16);
        return;
    L42:
        return;
    L17:
        r19 = null;
        goto L18
    L5:
        g0(r10);
    }

    public final void x(g r10, long r11) {
        Object r12 = kotlinx.coroutines.internal.k.b(null, 1, null);
    L4:
        if (r10 == null) goto L29;
        int r13 = BufferedChannelKt.f21337b - 1;
    L6:
        if ((-1) >= r13) goto L28;
        if (((r10.f21630c * ((long) BufferedChannelKt.f21337b)) + ((long) r13)) < r11) goto L29;
    L9:
        Object r14 = r10.w(r13);
        if (r14 == null) goto L25;
        if (r14 == BufferedChannelKt.k()) goto L25;
        if ((r14 instanceof l) == true) goto L17;
        if ((r14 instanceof Waiter) == false) goto L27;
        if (r10.r(r13, r14, BufferedChannelKt.z()) == false) goto L9;
        r12 = kotlinx.coroutines.internal.k.c(r12, r14);
        r10.x(r13, true);
    L27:
        r13 = r13 - 1;
        goto L6
    L17:
        if (r10.r(r13, r14, BufferedChannelKt.z()) == false) goto L9;
        r12 = kotlinx.coroutines.internal.k.c(r12, ((l) r14).f21369a);
        r10.x(r13, true);
    L25:
        if (r10.r(r13, r14, BufferedChannelKt.z()) == false) goto L9;
        r10.p();
        goto L27
    L28:
        r10 = (g) r10.g();
    L29:
        if (r12 != null) goto L31;
        return;
    L31:
        if ((r12 instanceof ArrayList) == true) goto L33;
        z0((Waiter) r12);
        return;
    L33:
        q.e(r12, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r15 = (ArrayList) r12;
        int r16 = r15.size() - 1;
    L34:
        if ((-1) >= r16) goto L58;
        z0((Waiter) r15.get(r16));
        r16 = r16 - 1;
        goto L34
    }

    public void x0(SelectInstance r14, Object r15) {
        g r10 = (g) f().get(this);
    L3:
        long r11 = g().getAndIncrement(this);
        long r12 = 1152921504606846975L & r11;
        boolean r13 = h(this, r11);
        int r16 = BufferedChannelKt.f21337b;
        long r17 = r12 / ((long) r16);
        int r18 = (int) (r12 % ((long) r16));
        if (r10.f21630c == r17) goto L10;
        g r19 = b(this, r17, r10);
        if (r19 == null) goto L7;
        r10 = r19;
        goto L10
    L7:
        if (r13 == false) goto L3;
    L8:
        h0(r15, r14);
        return;
    L10:
        int r20 = u(this, r10, r18, r15, r12, r14, r13);
        if (r20 == 0) goto L38;
        if (r20 == 1) goto L37;
        if (r20 == 2) goto L29;
        if (r20 == 3) goto L28;
        if (r20 == 4) goto L25;
        if (r20 != 5) goto L3;
        r10.b();
        goto L3
    L25:
        if (r12 >= L()) goto L8;
        r10.b();
        goto L8
    L28:
        throw new IllegalStateException("unexpected");
    L29:
        if (r13 == false) goto L32;
        r10.p();
        goto L8
    L32:
        if ((r14 instanceof Waiter) == false) goto L34;
        Waiter r110 = (Waiter) r14;
    L35:
        if (r110 == null) goto L54;
        m(this, r110, r10, r18);
        return;
    L54:
        return;
    L34:
        r110 = null;
    L37:
        r14.selectInRegistrationPhase(Unit.f21064a);
        return;
    L38:
        r10.b();
        goto L37
    }

    public final g y() {
        Object r10 = f21327j.get(this);
        g r11 = (g) f21325h.get(this);
        if (r11.f21630c <= ((g) r10).f21630c) goto L5;
        r10 = r11;
    L5:
        g r12 = (g) f21326i.get(this);
        if (r12.f21630c <= ((g) r10).f21630c) goto L9;
        r10 = r12;
    L9:
        return (g) kotlinx.coroutines.internal.d.b((kotlinx.coroutines.internal.e) r10);
    }

    public final void y0(g r12) {
        Function1 r10 = this.f21331b;
        UndeliveredElementException r11 = null;
        Object r13 = kotlinx.coroutines.internal.k.b(null, 1, null);
    L3:
        int r14 = BufferedChannelKt.f21337b - 1;
    L5:
        if ((-1) >= r14) goto L50;
        long r15 = (r12.f21630c * ((long) BufferedChannelKt.f21337b)) + ((long) r14);
    L7:
        Object r16 = r12.w(r14);
        if (r16 == BufferedChannelKt.f()) goto L52;
        if (r16 == BufferedChannelKt.f21339d) goto L12;
        if (r16 == BufferedChannelKt.k()) goto L47;
        if (r16 == null) goto L47;
        if ((r16 instanceof Waiter) == true) goto L36;
        if ((r16 instanceof l) == true) goto L36;
        if (r16 == BufferedChannelKt.p()) goto L52;
        if (r16 == BufferedChannelKt.q()) goto L52;
        if (r16 == BufferedChannelKt.p()) goto L7;
    L49:
        r14 = r14 - 1;
    L36:
        if (r15 < L()) goto L52;
        if ((r16 instanceof l) == false) goto L40;
        Waiter r17 = ((l) r16).f21369a;
    L42:
        if (r12.r(r14, r16, BufferedChannelKt.z()) == false) goto L7;
        if (r10 == null) goto L45;
        r11 = OnUndeliveredElementKt.c(r10, r12.v(r14), r11);
    L45:
        r13 = kotlinx.coroutines.internal.k.c(r13, r17);
        r12.s(r14);
        r12.p();
        goto L49
    L40:
        r17 = (Waiter) r16;
    L47:
        if (r12.r(r14, r16, BufferedChannelKt.z()) == false) goto L7;
        r12.p();
        goto L49
    L12:
        if (r15 < L()) goto L52;
        if (r12.r(r14, r16, BufferedChannelKt.z()) == false) goto L7;
        if (r10 == null) goto L17;
        r11 = OnUndeliveredElementKt.c(r10, r12.v(r14), r11);
    L17:
        r12.s(r14);
        r12.p();
    L52:
        if (r13 != null) goto L54;
    L59:
        if (r11 != null) goto L61;
        return;
    L61:
        throw r11;
    L54:
        if ((r13 instanceof ArrayList) == true) goto L56;
        A0((Waiter) r13);
        goto L59
    L56:
        q.e(r13, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r18 = (ArrayList) r13;
        int r19 = r18.size() - 1;
    L57:
        if ((-1) >= r19) goto L59;
        A0((Waiter) r18.get(r19));
        r19 = r19 - 1;
        goto L57
    L50:
        r12 = (g) r12.g();
        if (r12 != null) goto L3;
        goto L52
    }

    public boolean z(Throwable r10, boolean r11) {
        if (r11 == false) goto L4;
        Z();
    L4:
        boolean r12 = androidx.concurrent.futures.a.a(f21328k, this, BufferedChannelKt.l(), r10);
        if (r11 == false) goto L7;
        a0();
    L8:
        C();
        d0();
        if (r12 == false) goto L11;
        R();
    L11:
        return r12;
    L7:
        b0();
        goto L8
    }

    public final void z0(Waiter r10) {
        B0(r10, true);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        w(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException r10) {
        w(r10);
    }
}
