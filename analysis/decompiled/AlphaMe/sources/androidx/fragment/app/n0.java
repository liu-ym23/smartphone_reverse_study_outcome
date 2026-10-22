package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.InterfaceC0321s;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import d0.AbstractC0533c;
import d0.C0534d;
import j0.C0631f;
import j0.C0632g;

/* loaded from: classes.dex */
public final class n0 implements InterfaceC0321s, j0.h, u0 {

    /* renamed from: a, reason: collision with root package name */
    public final D f3786a;

    /* renamed from: b, reason: collision with root package name */
    public final t0 f3787b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.q0 f3788c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.I f3789d = null;

    /* renamed from: e, reason: collision with root package name */
    public C0632g f3790e = null;

    public n0(D d4, t0 t0Var) {
        this.f3786a = d4;
        this.f3787b = t0Var;
    }

    public final void a(EnumC0326x enumC0326x) {
        this.f3789d.e(enumC0326x);
    }

    public final void b() {
        if (this.f3789d == null) {
            this.f3789d = new androidx.lifecycle.I(this);
            C0632g c0632gE = E3.b.e(this);
            this.f3790e = c0632gE;
            c0632gE.a();
            androidx.lifecycle.h0.c(this);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0321s
    public final AbstractC0533c getDefaultViewModelCreationExtras() {
        Application application;
        D d4 = this.f3786a;
        Context applicationContext = d4.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        C0534d c0534d = new C0534d();
        if (application != null) {
            c0534d.b(androidx.lifecycle.o0.f3973a, application);
        }
        c0534d.b(androidx.lifecycle.h0.f3945a, this);
        c0534d.b(androidx.lifecycle.h0.f3946b, this);
        if (d4.getArguments() != null) {
            c0534d.b(androidx.lifecycle.h0.f3947c, d4.getArguments());
        }
        return c0534d;
    }

    @Override // androidx.lifecycle.InterfaceC0321s
    public final androidx.lifecycle.q0 getDefaultViewModelProviderFactory() {
        Application application;
        D d4 = this.f3786a;
        androidx.lifecycle.q0 defaultViewModelProviderFactory = d4.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(d4.mDefaultFactory)) {
            this.f3788c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f3788c == null) {
            Context applicationContext = d4.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f3788c = new androidx.lifecycle.k0(application, this, d4.getArguments());
        }
        return this.f3788c;
    }

    @Override // androidx.lifecycle.G
    public final AbstractC0328z getLifecycle() {
        b();
        return this.f3789d;
    }

    @Override // j0.h
    public final C0631f getSavedStateRegistry() {
        b();
        return this.f3790e.f13127b;
    }

    @Override // androidx.lifecycle.u0
    public final t0 getViewModelStore() {
        b();
        return this.f3787b;
    }
}
