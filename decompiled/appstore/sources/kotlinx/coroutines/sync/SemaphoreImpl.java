package kotlinx.coroutines.sync;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.common.util.concurrent.b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.n;
import kotlinx.coroutines.p;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.Nullable;
import tf.d;

/* JADX INFO: loaded from: classes4.dex */
public class SemaphoreImpl implements Semaphore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21743c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21744d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21745e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21746f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21747g = null;

    @Volatile
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21749b;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    @Nullable
    private volatile Object head;

    @Volatile
    @Nullable
    private volatile Object tail;

    static {
        f21743c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, ServerElements.HEAD);
        f21744d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
        f21745e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
        f21746f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
        f21747g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    }

    public SemaphoreImpl(int r10, int r11) {
        this.f21748a = r10;
        if (r10 <= 0) goto L11;
        if (r11 < 0) goto L9;
        if (r11 > r10) goto L9;
        a r12 = new a(0, null, 2);
        this.head = r12;
        this.tail = r12;
        this._availablePermits = r10 - r11;
        this.f21749b = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L9:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r10).toString());
    L11:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r10).toString());
    }

    public static final /* synthetic */ boolean a(SemaphoreImpl r10, Waiter r11) {
        return r10.e(r11);
    }

    public static /* synthetic */ Object c(SemaphoreImpl r10, Continuation r11) {
        if (r10.g() > 0) goto L5;
        Object r12 = r10.d(r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        return r12;
    L10:
        return Unit.f21064a;
    L5:
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation r10) {
        return c(this, r10);
    }

    public final void b(CancellableContinuation r10) {
    L3:
        if (g() > 0) goto L4;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (e((Waiter) r10) == false) goto L3;
        return;
    L4:
        r10.resume(Unit.f21064a, this.f21749b);
    }

    public final Object d(Continuation r10) {
        n r11 = p.b(IntrinsicsKt__IntrinsicsJvmKt.c(r10));
    L7:
        th = move-exception;
        r11.A();
        throw th;
    L4:
        if (a(this, r11) == true) goto L9;
        b(r11);     // Catch: Throwable -> L7
    L9:
        Object r12 = r11.q();
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L13;
        d.c(r10);
    L13:
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L16;
        return r12;
    L16:
        return Unit.f21064a;
    }

    public final boolean e(Waiter r15) {
        AtomicReferenceFieldUpdater r10 = f21745e;
        a r11 = (a) r10.get(this);
        long r12 = f21746f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r13 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long r14 = r12 / ((long) SemaphoreKt.f());
    L3:
        Object r16 = kotlinx.coroutines.internal.d.c(r11, r14, r13);
        if (z.c(r16) == true) goto L20;
        y r17 = z.b(r16);
    L6:
        y r18 = (y) r10.get(this);
        if (r18.f21630c >= r17.f21630c) goto L20;
        if (r17.q() == false) goto L3;
        if (androidx.concurrent.futures.a.a(r10, this, r18, r17) == true) goto L15;
        if (r17.m() == false) goto L6;
        r17.k();
        goto L6
    L15:
        if (r18.m() == false) goto L20;
        r18.k();
    L20:
        a r19 = (a) z.b(r16);
        int r20 = (int) (r12 % ((long) SemaphoreKt.f()));
        if (b.a(r19.r(), r20, null, r15) == false) goto L25;
        r15.invokeOnCancellation(r19, r20);
        return true;
    L25:
        if (b.a(r19.r(), r20, SemaphoreKt.e(), SemaphoreKt.g()) == true) goto L27;
        return false;
    L27:
        if ((r15 instanceof CancellableContinuation) == false) goto L30;
        q.e(r15, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        ((CancellableContinuation) r15).resume(Unit.f21064a, this.f21749b);
    L32:
        return true;
    L30:
        if ((r15 instanceof SelectInstance) == false) goto L34;
        ((SelectInstance) r15).selectInRegistrationPhase(Unit.f21064a);
        goto L32
    L34:
        throw new IllegalStateException(("unexpected: " + r15).toString());
    }

    public final void f() {
    L2:
        AtomicIntegerFieldUpdater r10 = f21747g;
        int r11 = r10.get(this);
        int r12 = this.f21748a;
        if (r11 <= r12) goto L6;
        if (r10.compareAndSet(this, r11, r12) == false) goto L2;
        return;
    }

    public final int g() {
    L2:
        int r10 = f21747g.getAndDecrement(this);
        if (r10 > this.f21748a) goto L2;
        return r10;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(f21747g.get(this), 0);
    }

    public final void h(SelectInstance r10, Object r11) {
    L3:
        if (g() > 0) goto L4;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (e((Waiter) r10) == false) goto L3;
        return;
    L4:
        r10.selectInRegistrationPhase(Unit.f21064a);
    }

    public final boolean i(Object r10) {
        if ((r10 instanceof CancellableContinuation) == false) goto L9;
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        CancellableContinuation r11 = (CancellableContinuation) r10;
        Object r12 = r11.tryResume(Unit.f21064a, null, this.f21749b);
        if (r12 == null) goto L7;
        r11.completeResume(r12);
        return true;
    L7:
        return false;
    L9:
        if ((r10 instanceof SelectInstance) == false) goto L13;
        return ((SelectInstance) r10).trySelect(this, Unit.f21064a);
    L13:
        throw new IllegalStateException(("unexpected: " + r10).toString());
    }

    public final boolean j() {
        AtomicReferenceFieldUpdater r10 = f21743c;
        a r11 = (a) r10.get(this);
        long r12 = f21744d.getAndIncrement(this);
        long r13 = r12 / ((long) SemaphoreKt.f());
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 r14 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
    L3:
        Object r15 = kotlinx.coroutines.internal.d.c(r11, r13, r14);
        if (z.c(r15) == true) goto L20;
        y r16 = z.b(r15);
    L6:
        y r17 = (y) r10.get(this);
        if (r17.f21630c >= r16.f21630c) goto L20;
        if (r16.q() == false) goto L3;
        if (androidx.concurrent.futures.a.a(r10, this, r17, r16) == true) goto L15;
        if (r16.m() == false) goto L6;
        r16.k();
        goto L6
    L15:
        if (r17.m() == false) goto L20;
        r17.k();
    L20:
        a r18 = (a) z.b(r15);
        r18.b();
        int r19 = 0;
        if (r18.f21630c <= r13) goto L23;
        return false;
    L23:
        int r20 = (int) (r12 % ((long) SemaphoreKt.f()));
        Object r21 = r18.r().getAndSet(r20, SemaphoreKt.e());
        if (r21 != null) goto L35;
        int r110 = SemaphoreKt.d();
    L27:
        if (r19 >= r110) goto L33;
        if (r18.r().get(r20) == SemaphoreKt.g()) goto L30;
        r19 = r19 + 1;
        goto L27
    L30:
        return true;
    L33:
        return !b.a(r18.r(), r20, SemaphoreKt.e(), SemaphoreKt.b());
    L35:
        if (r21 != SemaphoreKt.c()) goto L38;
        return false;
    L38:
        return i(r21);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
    L2:
        int r10 = f21747g.getAndIncrement(this);
        if (r10 >= this.f21748a) goto L9;
        if (r10 >= 0) goto L5;
        if (j() == false) goto L2;
        return;
    L5:
        return;
    L9:
        f();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f21748a).toString());
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
    L2:
        AtomicIntegerFieldUpdater r10 = f21747g;
        int r11 = r10.get(this);
        if (r11 > this.f21748a) goto L4;
        if (r11 <= 0) goto L6;
        if (r10.compareAndSet(this, r11, r11 - 1) == false) goto L2;
        return true;
    L6:
        return false;
    L4:
        f();
        goto L2
    }
}
