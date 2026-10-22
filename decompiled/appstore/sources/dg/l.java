package dg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f19220b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f19221c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f19222d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f19223e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f19224a;

    @Volatile
    private volatile int blockingTasksInBuffer;

    @Volatile
    private volatile int consumerIndex;

    @Volatile
    @Nullable
    private volatile Object lastScheduledTask;

    @Volatile
    private volatile int producerIndex;

    static {
        f19220b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask");
        f19221c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex");
        f19222d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex");
        f19223e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer");
    }

    public l() {
        this.f19224a = new AtomicReferenceArray(128);
    }

    public final g a(g r10, boolean r11) {
        if (r11 == true) goto L4;
        g r12 = (g) f19220b.getAndSet(this, r10);
        if (r12 != null) goto L10;
        return null;
    L10:
        return b(r12);
    L4:
        return b(r10);
    }

    public final g b(g r10) {
        if (d() != 127) goto L6;
        return r10;
    L6:
        if (r10.f19208b.getTaskMode() != 1) goto L8;
        f19223e.incrementAndGet(this);
    L8:
        int r11 = f19221c.get(this) & 127;
    L10:
        if (this.f19224a.get(r11) == null) goto L12;
        Thread.yield();
        goto L10
    L12:
        this.f19224a.lazySet(r11, r10);
        f19221c.incrementAndGet(this);
        return null;
    }

    public final void c(g r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.f19208b.getTaskMode() != 1) goto L8;
        f19223e.decrementAndGet(this);
        return;
    }

    public final int d() {
        return f19221c.get(this) - f19222d.get(this);
    }

    public final int e() {
        Object r10 = f19220b.get(this);
        int r11 = d();
        if (r10 != null) goto L5;
        return r11;
    L5:
        return r11 + 1;
    }

    public final void f(c r10) {
        g r11 = (g) f19220b.getAndSet(this, null);
        if (r11 == null) goto L6;
        r10.a(r11);
    L6:
        if (j(r10) == true) goto L6;
    }

    public final g g() {
        g r10 = (g) f19220b.getAndSet(this, null);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return i();
    }

    public final g h() {
        return k(true);
    }

    public final g i() {
    L2:
        AtomicIntegerFieldUpdater r10 = f19222d;
        int r11 = r10.get(this);
        if ((r11 - f19221c.get(this)) == 0) goto L4;
        int r12 = r11 & 127;
        if (r10.compareAndSet(this, r11, r11 + 1) == false) goto L2;
        g r13 = (g) this.f19224a.getAndSet(r12, null);
        if (r13 == null) goto L2;
        c(r13);
        return r13;
    L4:
        return null;
    }

    public final boolean j(c r10) {
        g r11 = i();
        if (r11 != null) goto L6;
        return false;
    L6:
        r10.a(r11);
        return true;
    }

    public final g k(boolean r10) {
    L2:
        AtomicReferenceFieldUpdater r11 = f19220b;
        g r12 = (g) r11.get(this);
        if (r12 == null) goto L13;
        boolean r13 = true;
        if (r12.f19208b.getTaskMode() == 1) goto L9;
        r13 = false;
    L9:
        if (r13 != r10) goto L13;
        if (androidx.concurrent.futures.a.a(r11, this, r12, null) == false) goto L2;
        return r12;
    L13:
        int r14 = f19222d.get(this);
        int r15 = f19221c.get(this);
    L14:
        if (r14 == r15) goto L22;
        if (r10 == true) goto L17;
    L19:
        r15 = r15 - 1;
        g r16 = m(r15, r10);
        if (r16 == null) goto L14;
        return r16;
    L17:
        if (f19223e.get(this) != 0) goto L19;
        return null;
    L22:
        return null;
    }

    public final g l(int r10) {
        int r11 = f19222d.get(this);
        int r12 = f19221c.get(this);
        boolean r13 = true;
        if (r10 == 1) goto L7;
        r13 = false;
    L7:
        if (r11 == r12) goto L16;
        if (r13 == true) goto L10;
    L12:
        int r14 = r11 + 1;
        g r15 = m(r11, r13);
        if (r15 != null) goto L15;
        r11 = r14;
        goto L7
    L15:
        return r15;
    L10:
        if (f19223e.get(this) != 0) goto L12;
        return null;
    L16:
        return null;
    }

    public final g m(int r10, boolean r11) {
        int r12 = r10 & 127;
        g r13 = (g) this.f19224a.get(r12);
        if (r13 == null) goto L14;
        boolean r14 = true;
        if (r13.f19208b.getTaskMode() == 1) goto L8;
        r14 = false;
    L8:
        if (r14 != r11) goto L14;
        if (com.google.common.util.concurrent.b.a(this.f19224a, r12, r13, null) == false) goto L14;
        if (r11 == false) goto L13;
        f19223e.decrementAndGet(this);
    L13:
        return r13;
    L14:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int r10, Ref$ObjectRef r11) {
        if (r10 != 3) goto L5;
        T r12 = i();
    L6:
        if (r12 == 0) goto L10;
        r11.element = r12;
        return -1;
    L10:
        return o(r10, r11);
    L5:
        r12 = l(r10);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, dg.g, java.lang.Object] */
    public final long o(int r10, Ref$ObjectRef r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = f19220b;
        ?? r13 = (g) r12.get(this);
        if (r13 == 0) goto L4;
        int r14 = 1;
        if (r13.f19208b.getTaskMode() == 1) goto L10;
        r14 = 2;
    L10:
        if ((r14 & r10) == 0) goto L11;
        long r15 = j.f19216f.a() - r13.f19207a;
        long r16 = j.f19212b;
        if (r15 < r16) goto L15;
        if (androidx.concurrent.futures.a.a(r12, this, r13, null) == false) goto L2;
        r11.element = r13;
        return -1;
    L15:
        return r16 - r15;
    L11:
        return -2;
    L4:
        return -2;
    }
}
