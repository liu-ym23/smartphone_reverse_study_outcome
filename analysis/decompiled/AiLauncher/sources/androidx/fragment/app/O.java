package androidx.fragment.app;

import V0.CreationExtras;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.C1399q;
import android.view.InterfaceC1391i;
import android.view.Lifecycle;
import android.view.U;
import android.view.V;
import android.view.W;

/* loaded from: classes.dex */
public class O implements InterfaceC1391i, g1.h, W {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f14046a;

    /* renamed from: b, reason: collision with root package name */
    public final V f14047b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f14048c;

    /* renamed from: d, reason: collision with root package name */
    public U.c f14049d;

    /* renamed from: e, reason: collision with root package name */
    public C1399q f14050e = null;

    /* renamed from: f, reason: collision with root package name */
    public g1.g f14051f = null;

    public O(Fragment fragment, V v10, Runnable runnable) {
        this.f14046a = fragment;
        this.f14047b = v10;
        this.f14048c = runnable;
    }

    public void a(Lifecycle.Event event) {
        this.f14050e.i(event);
    }

    public void b() {
        if (this.f14050e == null) {
            this.f14050e = new C1399q(this);
            g1.g gVarA = g1.g.a(this);
            this.f14051f = gVarA;
            gVarA.c();
            this.f14048c.run();
        }
    }

    public boolean c() {
        return this.f14050e != null;
    }

    public void d(Bundle bundle) {
        this.f14051f.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f14051f.e(bundle);
    }

    public void f(Lifecycle.State state) {
        this.f14050e.n(state);
    }

    @Override // android.view.InterfaceC1391i
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f14046a.requireContext().getApplicationContext();
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
        V0.b bVar = new V0.b();
        if (application != null) {
            bVar.c(U.a.f14255h, application);
        }
        bVar.c(android.view.I.f14182a, this.f14046a);
        bVar.c(android.view.I.f14183b, this);
        if (this.f14046a.getArguments() != null) {
            bVar.c(android.view.I.f14184c, this.f14046a.getArguments());
        }
        return bVar;
    }

    @Override // android.view.InterfaceC1391i
    public U.c getDefaultViewModelProviderFactory() {
        Application application;
        U.c defaultViewModelProviderFactory = this.f14046a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f14046a.mDefaultFactory)) {
            this.f14049d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f14049d == null) {
            Context applicationContext = this.f14046a.requireContext().getApplicationContext();
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
            Fragment fragment = this.f14046a;
            this.f14049d = new android.view.M(application, fragment, fragment.getArguments());
        }
        return this.f14049d;
    }

    @Override // android.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        b();
        return this.f14050e;
    }

    @Override // g1.h
    public g1.e getSavedStateRegistry() {
        b();
        return this.f14051f.getSavedStateRegistry();
    }

    @Override // android.view.W
    public V getViewModelStore() {
        b();
        return this.f14047b;
    }
}
