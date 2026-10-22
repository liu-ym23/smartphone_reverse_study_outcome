package androidx.lifecycle;

import j0.C0631f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f0 implements E {

    /* renamed from: a, reason: collision with root package name */
    public final String f3938a;

    /* renamed from: b, reason: collision with root package name */
    public final e0 f3939b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3940c;

    public f0(String key, e0 handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.f3938a = key;
        this.f3939b = handle;
    }

    @Override // androidx.lifecycle.E
    public final void a(G source, EnumC0326x event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == EnumC0326x.ON_DESTROY) {
            this.f3940c = false;
            source.getLifecycle().b(this);
        }
    }

    public final void b(AbstractC0328z lifecycle, C0631f registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (!(!this.f3940c)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f3940c = true;
        lifecycle.a(this);
        registry.c(this.f3938a, this.f3939b.f3935e);
    }
}
