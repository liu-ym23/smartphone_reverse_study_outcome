package c0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;
import j4.k;

/* renamed from: c0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0575e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f11943d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0576f f11944a;

    /* renamed from: b, reason: collision with root package name */
    private final C0574d f11945b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11946c;

    /* renamed from: c0.e$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final C0575e a(InterfaceC0576f interfaceC0576f) {
            k.g(interfaceC0576f, "owner");
            return new C0575e(interfaceC0576f, null);
        }

        private a() {
        }
    }

    public /* synthetic */ C0575e(InterfaceC0576f interfaceC0576f, j4.g gVar) {
        this(interfaceC0576f);
    }

    public static final C0575e a(InterfaceC0576f interfaceC0576f) {
        return f11943d.a(interfaceC0576f);
    }

    public final C0574d b() {
        return this.f11945b;
    }

    public final void c() {
        AbstractC0533m lifecycle = this.f11944a.getLifecycle();
        if (lifecycle.b() != AbstractC0533m.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new C0572b(this.f11944a));
        this.f11945b.e(lifecycle);
        this.f11946c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f11946c) {
            c();
        }
        AbstractC0533m lifecycle = this.f11944a.getLifecycle();
        if (!lifecycle.b().d(AbstractC0533m.b.STARTED)) {
            this.f11945b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.g(bundle, "outBundle");
        this.f11945b.g(bundle);
    }

    private C0575e(InterfaceC0576f interfaceC0576f) {
        this.f11944a = interfaceC0576f;
        this.f11945b = new C0574d();
    }
}
