package android.view;

import C7.r;
import H7.c;
import S7.a;
import android.view.Lifecycle;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.AbstractC1691I;
import m9.AbstractC1729v;
import m9.C1718k;
import m9.InterfaceC1717j;
import n9.C1748d;
import u9.d;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\n\u0010\t\u001a*\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\u000b\u0010\t\u001a2\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\u0006\u0010\r\u001a*\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\b\u0010\u000e\u001a*\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\n\u0010\u000e\u001a*\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H¢\u0006\u0004\b\u000b\u0010\u000e\u001a2\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081H¢\u0006\u0004\b\u000f\u0010\u0007\u001a@\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081@¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"R", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function0;", "block", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;LS7/a;LH7/c;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;LS7/a;LH7/c;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;LS7/a;LH7/c;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;LS7/a;LH7/c;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "", "dispatchNeeded", "Lm9/v;", "lifecycleDispatcher", "suspendWithStateAtLeastUnchecked", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLm9/v;LS7/a;LH7/c;)Ljava/lang/Object;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WithLifecycleStateKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    public static final class AnonymousClass2 implements a {
        final /* synthetic */ a $block;

        public AnonymousClass2(a aVar) {
            this.$block = aVar;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [R, java.lang.Object] */
        @Override // S7.a
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z10, final AbstractC1729v abstractC1729v, final a aVar, c<? super R> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final ?? r72 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // android.view.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Object objA;
                k.f(source, "source");
                k.f(event, "event");
                if (event != Lifecycle.Event.INSTANCE.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        c1718k.resumeWith(b.a(new LifecycleDestroyedException()));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                InterfaceC1717j interfaceC1717j = c1718k;
                try {
                    objA = aVar.invoke();
                } catch (Throwable th) {
                    objA = b.a(th);
                }
                interfaceC1717j.resumeWith(objA);
            }
        };
        if (z10) {
            abstractC1729v.dispatch(EmptyCoroutineContext.f4908a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r72);
                }
            });
        } else {
            lifecycle.addObserver(r72);
        }
        c1718k.j(new S7.k() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                AbstractC1729v abstractC1729v2 = abstractC1729v;
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f4908a;
                if (!abstractC1729v2.isDispatchNeeded(emptyCoroutineContext)) {
                    lifecycle.removeObserver(r72);
                    return;
                }
                AbstractC1729v abstractC1729v3 = abstractC1729v;
                final Lifecycle lifecycle2 = lifecycle;
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r72;
                abstractC1729v3.dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        lifecycle2.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                    }
                });
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, a aVar, c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, a aVar, c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, a aVar, c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, a aVar, c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, a aVar, c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, a aVar, c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, a aVar, c<? super R> cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, a aVar, c<? super R> cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            d dVar = AbstractC1691I.f5315a;
            C1748d c1748d = s9.k.f6003a.d;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, a aVar, c<? super R> cVar) {
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, a aVar, c<? super R> cVar) {
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, a aVar, c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, a aVar, c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, a aVar, c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, a aVar, c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            d dVar = AbstractC1691I.f5315a;
            C1748d c1748d = s9.k.f6003a.d;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, a aVar, c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, a aVar, c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, a aVar, c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        d dVar = AbstractC1691I.f5315a;
        C1748d c1748d = s9.k.f6003a.d;
        boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, a aVar, c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            d dVar = AbstractC1691I.f5315a;
            C1748d c1748d = s9.k.f6003a.d;
            boolean zIsDispatchNeeded = c1748d.isDispatchNeeded(cVar.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, c1748d, new AnonymousClass2(aVar), cVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
