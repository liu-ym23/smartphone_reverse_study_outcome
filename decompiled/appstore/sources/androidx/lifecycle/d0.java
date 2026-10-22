package androidx.lifecycle;

import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f3517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3518c;

    public d0(String r10, b0 r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        kotlin.jvm.internal.q.g(r11, "handle");
        this.f3516a = r10;
        this.f3517b = r11;
    }

    public final void a(SavedStateRegistry r10, Lifecycle r11) {
        kotlin.jvm.internal.q.g(r10, "registry");
        kotlin.jvm.internal.q.g(r11, "lifecycle");
        if (this.f3518c == true) goto L7;
        this.f3518c = true;
        r11.a(this);
        r10.h(this.f3516a, this.f3517b.e());
        return;
    L7:
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    public final b0 b() {
        return this.f3517b;
    }

    public final boolean c() {
        return this.f3518c;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "event");
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L6;
        this.f3518c = false;
        r10.getLifecycle().d(this);
        return;
    }
}
