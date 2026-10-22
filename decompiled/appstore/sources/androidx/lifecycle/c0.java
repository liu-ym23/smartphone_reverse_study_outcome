package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SavedStateHandlesProvider f3514a;

    public c0(SavedStateHandlesProvider r10) {
        kotlin.jvm.internal.q.g(r10, "provider");
        this.f3514a = r10;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "event");
        if (r11 != Lifecycle.Event.ON_CREATE) goto L7;
        r10.getLifecycle().d(this);
        this.f3514a.c();
        return;
    L7:
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + r11).toString());
    }
}
