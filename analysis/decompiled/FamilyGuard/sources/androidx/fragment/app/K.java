package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.C0541v;
import androidx.lifecycle.InterfaceC0531k;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import c0.C0574d;
import c0.C0575e;
import c0.InterfaceC0576f;

/* loaded from: classes.dex */
class K implements InterfaceC0531k, InterfaceC0576f, X {

    /* renamed from: a, reason: collision with root package name */
    private final ComponentCallbacksC0511f f10480a;

    /* renamed from: b, reason: collision with root package name */
    private final W f10481b;

    /* renamed from: c, reason: collision with root package name */
    private U.c f10482c;

    /* renamed from: d, reason: collision with root package name */
    private C0541v f10483d = null;

    /* renamed from: e, reason: collision with root package name */
    private C0575e f10484e = null;

    K(ComponentCallbacksC0511f componentCallbacksC0511f, W w5) {
        this.f10480a = componentCallbacksC0511f;
        this.f10481b = w5;
    }

    void a(AbstractC0533m.a aVar) {
        this.f10483d.i(aVar);
    }

    void b() {
        if (this.f10483d == null) {
            this.f10483d = new C0541v(this);
            C0575e c0575eA = C0575e.a(this);
            this.f10484e = c0575eA;
            c0575eA.c();
            androidx.lifecycle.M.c(this);
        }
    }

    boolean c() {
        return this.f10483d != null;
    }

    void d(Bundle bundle) {
        this.f10484e.d(bundle);
    }

    void e(Bundle bundle) {
        this.f10484e.e(bundle);
    }

    void f(AbstractC0533m.b bVar) {
        this.f10483d.n(bVar);
    }

    @Override // androidx.lifecycle.InterfaceC0531k
    public W.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f10480a.A1().getApplicationContext();
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
        W.b bVar = new W.b();
        if (application != null) {
            bVar.c(U.a.f10846h, application);
        }
        bVar.c(androidx.lifecycle.M.f10823a, this);
        bVar.c(androidx.lifecycle.M.f10824b, this);
        if (this.f10480a.u() != null) {
            bVar.c(androidx.lifecycle.M.f10825c, this.f10480a.u());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.InterfaceC0531k
    public U.c getDefaultViewModelProviderFactory() {
        Application application;
        U.c defaultViewModelProviderFactory = this.f10480a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f10480a.f10626Y)) {
            this.f10482c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f10482c == null) {
            Context applicationContext = this.f10480a.A1().getApplicationContext();
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
            this.f10482c = new P(application, this, this.f10480a.u());
        }
        return this.f10482c;
    }

    @Override // androidx.lifecycle.InterfaceC0539t
    public AbstractC0533m getLifecycle() {
        b();
        return this.f10483d;
    }

    @Override // c0.InterfaceC0576f
    public C0574d getSavedStateRegistry() {
        b();
        return this.f10484e.b();
    }

    @Override // androidx.lifecycle.X
    public W getViewModelStore() {
        b();
        return this.f10481b;
    }
}
