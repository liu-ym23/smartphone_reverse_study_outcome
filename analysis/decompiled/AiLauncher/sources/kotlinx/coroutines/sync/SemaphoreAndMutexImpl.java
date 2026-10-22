package kotlinx.coroutines.sync;

import Ua.C1072o;
import Ua.InterfaceC1066l;
import Ua.U0;
import Y8.t;
import Za.A;
import Za.C1182b;
import Za.z;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import eb.j;
import eb.k;
import f9.C4063a;
import g9.f;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.c;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import p9.q;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0010*\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0018\u0010\tJ\u001d\u0010\u001a\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR,\u0010$\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000bR\u0011\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004R\u000b\u0010*\u001a\u00020)8\u0002X\u0082\u0004R\u0011\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004R\u000b\u0010,\u001a\u00020)8\u0002X\u0082\u0004R\u000b\u0010.\u001a\u00020-8\u0002X\u0082\u0004¨\u0006/"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "", "", "permits", "acquiredPermits", "<init>", "(II)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Le9/c;)Ljava/lang/Object;", "o", "()I", "n", "()V", "LUa/U0;", "waiter", "", "k", "(LUa/U0;)Z", "x", "()Z", "w", "(Ljava/lang/Object;)Z", "v", "c", "LUa/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LUa/l;)V", "release", Const.INTENT_KEY_APIKEY, "I", "Lkotlin/Function3;", "", "Lkotlin/coroutines/d;", Const.INTENT_KEY_PKGNAME, "Lp9/q;", "onCancellationRelease", "availablePermits", "LOa/e;", "Leb/k;", "head", "LOa/d;", "deqIdx", "tail", "enqIdx", "LOa/c;", "_availablePermits", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SemaphoreAndMutexImpl {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36818c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36819d = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36820e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36821f = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f36822g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int permits;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final q<Throwable, t, d, t> onCancellationRelease;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public SemaphoreAndMutexImpl(int i10, int i11) {
        this.permits = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
        }
        if (i11 < 0 || i11 > i10) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        k kVar = new k(0L, null, 2);
        this.head$volatile = kVar;
        this.tail$volatile = kVar;
        this._availablePermits$volatile = i10 - i11;
        this.onCancellationRelease = new q() { // from class: eb.h
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SemaphoreAndMutexImpl.u(this.f32436a, (Throwable) obj, (t) obj2, (kotlin.coroutines.d) obj3);
            }
        };
    }

    public static final t u(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Throwable th, t tVar, d dVar) {
        semaphoreAndMutexImpl.release();
        return t.f7040a;
    }

    public final int a() {
        return Math.max(f36822g.get(this), 0);
    }

    public final Object c(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ;
        return (o() <= 0 && (objJ = j(interfaceC4014c)) == C4063a.g()) ? objJ : t.f7040a;
    }

    public final void h(InterfaceC1066l<? super t> waiter) {
        while (o() <= 0) {
            p.g(waiter, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (k((U0) waiter)) {
                return;
            }
        }
        waiter.w(t.f7040a, this.onCancellationRelease);
    }

    public final Object j(InterfaceC4014c<? super t> interfaceC4014c) {
        c cVarB = C1072o.b(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c));
        try {
            if (!k(cVarB)) {
                h(cVarB);
            }
            Object objC = cVarB.C();
            if (objC == C4063a.g()) {
                f.c(interfaceC4014c);
            }
            return objC == C4063a.g() ? objC : t.f7040a;
        } catch (Throwable th) {
            cVarB.Q();
            throw th;
        }
    }

    public final boolean k(U0 waiter) {
        Object objC;
        k kVar = (k) f36820e.get(this);
        long andIncrement = f36821f.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.f36825a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36820e;
        long j10 = andIncrement / j.f32442f;
        loop0: while (true) {
            objC = C1182b.c(kVar, j10, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!A.c(objC)) {
                z zVarB = A.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.id >= zVarB.id) {
                        break loop0;
                    }
                    if (!zVarB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, zVarB)) {
                        if (zVar.p()) {
                            zVar.n();
                        }
                    } else if (zVarB.p()) {
                        zVarB.n();
                    }
                }
            } else {
                break;
            }
        }
        k kVar2 = (k) A.b(objC);
        int i10 = (int) (andIncrement % j.f32442f);
        if (kVar2.getF32443e().compareAndSet(i10, null, waiter)) {
            waiter.h(kVar2, i10);
            return true;
        }
        if (!kVar2.getF32443e().compareAndSet(i10, j.f32438b, j.f32439c)) {
            return false;
        }
        if (waiter instanceof InterfaceC1066l) {
            p.g(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((InterfaceC1066l) waiter).w(t.f7040a, this.onCancellationRelease);
        } else {
            if (!(waiter instanceof cb.j)) {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            ((cb.j) waiter).d(t.f7040a);
        }
        return true;
    }

    public final void n() {
        int i10;
        do {
            i10 = f36822g.get(this);
            if (i10 <= this.permits) {
                return;
            }
        } while (!f36822g.compareAndSet(this, i10, this.permits));
    }

    public final int o() {
        int andDecrement;
        do {
            andDecrement = f36822g.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    public final void release() {
        do {
            int andIncrement = f36822g.getAndIncrement(this);
            if (andIncrement >= this.permits) {
                n();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!x());
    }

    public final boolean v() {
        while (true) {
            int i10 = f36822g.get(this);
            if (i10 > this.permits) {
                n();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (f36822g.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean w(Object obj) {
        if (!(obj instanceof InterfaceC1066l)) {
            if (obj instanceof cb.j) {
                return ((cb.j) obj).f(this, t.f7040a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        InterfaceC1066l interfaceC1066l = (InterfaceC1066l) obj;
        Object objL = interfaceC1066l.l(t.f7040a, null, this.onCancellationRelease);
        if (objL == null) {
            return false;
        }
        interfaceC1066l.x(objL);
        return true;
    }

    public final boolean x() {
        Object objC;
        k kVar = (k) f36818c.get(this);
        long andIncrement = f36819d.getAndIncrement(this);
        long j10 = andIncrement / j.f32442f;
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.f36826a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36818c;
        loop0: while (true) {
            objC = C1182b.c(kVar, j10, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (A.c(objC)) {
                break;
            }
            z zVarB = A.b(objC);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.id >= zVarB.id) {
                    break loop0;
                }
                if (!zVarB.u()) {
                    break;
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, zVarB)) {
                    if (zVar.p()) {
                        zVar.n();
                    }
                } else if (zVarB.p()) {
                    zVarB.n();
                }
            }
        }
        k kVar2 = (k) A.b(objC);
        kVar2.b();
        if (kVar2.id > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % j.f32442f);
        Object andSet = kVar2.getF32443e().getAndSet(i10, j.f32438b);
        if (andSet != null) {
            if (andSet == j.f32441e) {
                return false;
            }
            return w(andSet);
        }
        int i11 = j.f32437a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (kVar2.getF32443e().get(i10) == j.f32439c) {
                return true;
            }
        }
        return !kVar2.getF32443e().compareAndSet(i10, j.f32438b, j.f32440d);
    }
}
