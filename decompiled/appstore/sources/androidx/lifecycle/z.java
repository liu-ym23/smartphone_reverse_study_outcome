package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public class z implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.a f3593b;

    public z(Object r10) {
        this.f3592a = r10;
        this.f3593b = c.f3507c.c(r10.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        this.f3593b.a(r10, r11, this.f3592a);
    }
}
