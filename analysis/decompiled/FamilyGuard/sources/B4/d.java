package B4;

import V3.v;
import i4.InterfaceC0772l;
import i4.p;
import j4.j;
import j4.k;
import j4.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s4.InterfaceC1080k;
import s4.L0;
import x4.AbstractC1291C;
import x4.C1292D;
import x4.C1303c;

/* loaded from: classes.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f227c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head$volatile");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f228d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx$volatile");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f229e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail$volatile");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f230f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f231g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    private final int f232a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0772l<Throwable, v> f233b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* synthetic */ class a extends j implements p<Long, f, f> {

        /* renamed from: j, reason: collision with root package name */
        public static final a f234j = new a();

        a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ f invoke(Long l5, f fVar) {
            return j(l5.longValue(), fVar);
        }

        public final f j(long j5, f fVar) {
            return e.h(j5, fVar);
        }
    }

    static final class b extends l implements InterfaceC0772l<Throwable, v> {
        b() {
            super(1);
        }

        public final void b(Throwable th) {
            d.this.m();
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(Throwable th) {
            b(th);
            return v.f5542a;
        }
    }

    /* synthetic */ class c extends j implements p<Long, f, f> {

        /* renamed from: j, reason: collision with root package name */
        public static final c f236j = new c();

        c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ f invoke(Long l5, f fVar) {
            return j(l5.longValue(), fVar);
        }

        public final f j(long j5, f fVar) {
            return e.h(j5, fVar);
        }
    }

    public d(int i5, int i6) {
        this.f232a = i5;
        if (i5 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i5).toString());
        }
        if (i6 < 0 || i6 > i5) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i5).toString());
        }
        f fVar = new f(0L, null, 2);
        this.head$volatile = fVar;
        this.tail$volatile = fVar;
        this._availablePermits$volatile = i5 - i6;
        this.f233b = new b();
    }

    private final boolean d(L0 l02) {
        Object objC;
        f fVar = (f) f229e.get(this);
        long andIncrement = f230f.getAndIncrement(this);
        a aVar = a.f234j;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f229e;
        long j5 = andIncrement / e.f242f;
        loop0: while (true) {
            objC = C1303c.c(fVar, j5, aVar);
            if (!C1292D.c(objC)) {
                AbstractC1291C abstractC1291CB = C1292D.b(objC);
                while (true) {
                    AbstractC1291C abstractC1291C = (AbstractC1291C) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1291C.f23829c >= abstractC1291CB.f23829c) {
                        break loop0;
                    }
                    if (!abstractC1291CB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC1291C, abstractC1291CB)) {
                        if (abstractC1291C.p()) {
                            abstractC1291C.n();
                        }
                    } else if (abstractC1291CB.p()) {
                        abstractC1291CB.n();
                    }
                }
            } else {
                break;
            }
        }
        f fVar2 = (f) C1292D.b(objC);
        int i5 = (int) (andIncrement % e.f242f);
        if (fVar2.v().compareAndSet(i5, null, l02)) {
            l02.c(fVar2, i5);
            return true;
        }
        if (!fVar2.v().compareAndSet(i5, e.f238b, e.f239c)) {
            return false;
        }
        if (l02 instanceof InterfaceC1080k) {
            k.e(l02, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((InterfaceC1080k) l02).b(v.f5542a, this.f233b);
        } else {
            if (!(l02 instanceof A4.b)) {
                throw new IllegalStateException(("unexpected: " + l02).toString());
            }
            ((A4.b) l02).d(v.f5542a);
        }
        return true;
    }

    private final void e() {
        int i5;
        do {
            i5 = f231g.get(this);
            if (i5 <= this.f232a) {
                return;
            }
        } while (!f231g.compareAndSet(this, i5, this.f232a));
    }

    private final int f() {
        int andDecrement;
        do {
            andDecrement = f231g.getAndDecrement(this);
        } while (andDecrement > this.f232a);
        return andDecrement;
    }

    private final boolean o(Object obj) {
        if (!(obj instanceof InterfaceC1080k)) {
            if (obj instanceof A4.b) {
                return ((A4.b) obj).b(this, v.f5542a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        InterfaceC1080k interfaceC1080k = (InterfaceC1080k) obj;
        Object objE = interfaceC1080k.e(v.f5542a, null, this.f233b);
        if (objE == null) {
            return false;
        }
        interfaceC1080k.h(objE);
        return true;
    }

    private final boolean p() {
        Object objC;
        f fVar = (f) f227c.get(this);
        long andIncrement = f228d.getAndIncrement(this);
        long j5 = andIncrement / e.f242f;
        c cVar = c.f236j;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f227c;
        loop0: while (true) {
            objC = C1303c.c(fVar, j5, cVar);
            if (C1292D.c(objC)) {
                break;
            }
            AbstractC1291C abstractC1291CB = C1292D.b(objC);
            while (true) {
                AbstractC1291C abstractC1291C = (AbstractC1291C) atomicReferenceFieldUpdater.get(this);
                if (abstractC1291C.f23829c >= abstractC1291CB.f23829c) {
                    break loop0;
                }
                if (!abstractC1291CB.u()) {
                    break;
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC1291C, abstractC1291CB)) {
                    if (abstractC1291C.p()) {
                        abstractC1291C.n();
                    }
                } else if (abstractC1291CB.p()) {
                    abstractC1291CB.n();
                }
            }
        }
        f fVar2 = (f) C1292D.b(objC);
        fVar2.c();
        if (fVar2.f23829c > j5) {
            return false;
        }
        int i5 = (int) (andIncrement % e.f242f);
        Object andSet = fVar2.v().getAndSet(i5, e.f238b);
        if (andSet != null) {
            if (andSet == e.f241e) {
                return false;
            }
            return o(andSet);
        }
        int i6 = e.f237a;
        for (int i7 = 0; i7 < i6; i7++) {
            if (fVar2.v().get(i5) == e.f239c) {
                return true;
            }
        }
        return !fVar2.v().compareAndSet(i5, e.f238b, e.f240d);
    }

    protected final void c(InterfaceC1080k<? super v> interfaceC1080k) {
        while (f() <= 0) {
            k.e(interfaceC1080k, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((L0) interfaceC1080k)) {
                return;
            }
        }
        interfaceC1080k.b(v.f5542a, this.f233b);
    }

    public int g() {
        return Math.max(f231g.get(this), 0);
    }

    public void m() {
        do {
            int andIncrement = f231g.getAndIncrement(this);
            if (andIncrement >= this.f232a) {
                e();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f232a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!p());
    }

    public boolean n() {
        while (true) {
            int i5 = f231g.get(this);
            if (i5 > this.f232a) {
                e();
            } else {
                if (i5 <= 0) {
                    return false;
                }
                if (f231g.compareAndSet(this, i5, i5 - 1)) {
                    return true;
                }
            }
        }
    }
}
