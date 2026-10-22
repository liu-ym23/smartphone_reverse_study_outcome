package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h1;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends n implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f3430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f3431b;

    public LifecycleCoroutineScopeImpl(Lifecycle r10, CoroutineContext r11) {
        kotlin.jvm.internal.q.g(r10, "lifecycle");
        kotlin.jvm.internal.q.g(r11, "coroutineContext");
        this.f3430a = r10;
        this.f3431b = r11;
        if (a().b() != Lifecycle.State.DESTROYED) goto L6;
        h1.d(getCoroutineContext(), null, 1, null);
        return;
    }

    @Override // androidx.lifecycle.n
    public Lifecycle a() {
        return this.f3430a;
    }

    public final void b() {
        kotlinx.coroutines.h.d(this, kotlinx.coroutines.l0.c().e(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f3431b;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        a().d(this);
        h1.d(getCoroutineContext(), null, 1, null);
        return;
    }
}
