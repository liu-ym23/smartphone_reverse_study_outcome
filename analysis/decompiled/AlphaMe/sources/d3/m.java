package d3;

import Z2.I;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12465a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12466b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_prev");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12467c = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_removedRef");

    @Volatile
    @Nullable
    private volatile Object _next = this;

    @Volatile
    @Nullable
    private volatile Object _prev = this;

    @Volatile
    @Nullable
    private volatile Object _removedRef;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        if (r5.compareAndSet(r4, r3, ((d3.s) r6).f12478a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d3.m d() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = d3.m.f12466b
            java.lang.Object r1 = r0.get(r9)
            d3.m r1 = (d3.m) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = d3.m.f12465a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L1e
            if (r1 != r3) goto L16
            return r3
        L16:
            boolean r0 = r0.compareAndSet(r9, r1, r3)
            if (r0 != 0) goto L1d
            goto L0
        L1d:
            return r3
        L1e:
            boolean r7 = r9.h()
            if (r7 == 0) goto L25
            return r2
        L25:
            if (r6 != 0) goto L28
            return r3
        L28:
            boolean r7 = r6 instanceof d3.r
            if (r7 == 0) goto L32
            d3.r r6 = (d3.r) r6
            r6.a(r3)
            goto L0
        L32:
            boolean r7 = r6 instanceof d3.s
            if (r7 == 0) goto L4c
            if (r4 == 0) goto L45
            d3.s r6 = (d3.s) r6
            d3.m r6 = r6.f12478a
            boolean r3 = r5.compareAndSet(r4, r3, r6)
            if (r3 != 0) goto L43
            goto L0
        L43:
            r3 = r4
            goto La
        L45:
            java.lang.Object r3 = r0.get(r3)
            d3.m r3 = (d3.m) r3
            goto Lb
        L4c:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            r4 = r6
            d3.m r4 = (d3.m) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.m.d():d3.m");
    }

    public final void e(m mVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        m mVar2;
        do {
            atomicReferenceFieldUpdater = f12466b;
            mVar2 = (m) atomicReferenceFieldUpdater.get(mVar);
            if (f() != mVar) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(mVar, mVar2, this));
        if (h()) {
            mVar.d();
        }
    }

    public final Object f() {
        while (true) {
            Object obj = f12465a.get(this);
            if (!(obj instanceof r)) {
                return obj;
            }
            ((r) obj).a(this);
        }
    }

    public final m g() {
        m mVar;
        Object objF = f();
        s sVar = objF instanceof s ? (s) objF : null;
        if (sVar != null && (mVar = sVar.f12478a) != null) {
            return mVar;
        }
        Intrinsics.checkNotNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (m) objF;
    }

    public boolean h() {
        return f() instanceof s;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: d3.l
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return this.receiver.getClass().getSimpleName();
            }
        } + '@' + I.p(this);
    }
}
