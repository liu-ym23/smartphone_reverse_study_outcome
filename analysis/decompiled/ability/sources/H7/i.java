package H7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* loaded from: classes3.dex */
public final class i implements c, J7.b {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");

    /* renamed from: a, reason: collision with root package name */
    public final c f759a;
    private volatile Object result;

    public i(c cVar, CoroutineSingletons coroutineSingletons) {
        this.f759a = cVar;
        this.result = coroutineSingletons;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.b;
        if (obj == coroutineSingletons) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.f4909a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, coroutineSingletons, coroutineSingletons2)) {
                return coroutineSingletons2;
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.c) {
            return CoroutineSingletons.f4909a;
        }
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).f4888a;
        }
        return obj;
    }

    @Override // J7.b
    public final J7.b getCallerFrame() {
        c cVar = this.f759a;
        if (cVar instanceof J7.b) {
            return (J7.b) cVar;
        }
        return null;
    }

    @Override // H7.c
    public final h getContext() {
        return this.f759a.getContext();
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.b;
            if (obj2 != coroutineSingletons) {
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.f4909a;
                if (obj2 != coroutineSingletons2) {
                    throw new IllegalStateException("Already resumed");
                }
                if (b.compareAndSet(this, coroutineSingletons2, CoroutineSingletons.c)) {
                    this.f759a.resumeWith(obj);
                    return;
                }
            } else if (b.compareAndSet(this, coroutineSingletons, obj)) {
                return;
            }
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.f759a;
    }
}
