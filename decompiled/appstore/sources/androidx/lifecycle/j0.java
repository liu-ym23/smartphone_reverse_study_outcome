package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeneratedAdapter f3547a;

    public j0(GeneratedAdapter r10) {
        kotlin.jvm.internal.q.g(r10, "generatedAdapter");
        this.f3547a = r10;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "event");
        this.f3547a.callMethods(r10, r11, false, null);
        this.f3547a.callMethods(r10, r11, true, null);
    }
}
