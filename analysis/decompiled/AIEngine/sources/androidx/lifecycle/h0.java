package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h0 implements o, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final String f2270a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f2271b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2272c;

    public h0(String str, f0 f0Var) {
        this.f2270a = str;
        this.f2271b = f0Var;
    }

    public final void K(Lifecycle lifecycle, w1.b registry) {
        kotlin.jvm.internal.g.f(registry, "registry");
        kotlin.jvm.internal.g.f(lifecycle, "lifecycle");
        if (this.f2272c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f2272c = true;
        lifecycle.a(this);
        registry.c(this.f2270a, this.f2271b.f2268a.f11393e);
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f2272c = false;
            qVar.getLifecycle().c(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }
}
