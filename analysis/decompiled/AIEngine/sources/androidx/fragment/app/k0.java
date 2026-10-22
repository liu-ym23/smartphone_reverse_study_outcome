package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k0 implements androidx.lifecycle.i, w1.d, t0 {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f2159a;

    /* renamed from: b, reason: collision with root package name */
    public final s0 f2160b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.s f2161c = null;

    /* renamed from: d, reason: collision with root package name */
    public w1.c f2162d = null;

    public k0(Fragment fragment, s0 s0Var) {
        this.f2159a = fragment;
        this.f2160b = s0Var;
    }

    public final void a(Lifecycle.Event event) {
        this.f2161c.f(event);
    }

    public final void b() {
        if (this.f2161c == null) {
            this.f2161c = new androidx.lifecycle.s(this);
            x1.a aVar = new x1.a(this, new b6.g(this, 19));
            this.f2162d = new w1.c(aVar);
            aVar.a();
            androidx.lifecycle.i0.b(this);
        }
    }

    @Override // androidx.lifecycle.i
    public final q1.a getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.f2159a;
        Context applicationContext = fragment.requireContext().getApplicationContext();
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
        q1.b bVar = new q1.b((Object) null);
        LinkedHashMap linkedHashMap = bVar.f11486a;
        if (application != null) {
            linkedHashMap.put(r0.a.f2305d, application);
        }
        linkedHashMap.put(androidx.lifecycle.i0.f2273a, this);
        linkedHashMap.put(androidx.lifecycle.i0.f2274b, this);
        if (fragment.getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.i0.f2275c, fragment.getArguments());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.q
    public final Lifecycle getLifecycle() {
        b();
        return this.f2161c;
    }

    @Override // w1.d
    public final w1.b getSavedStateRegistry() {
        b();
        return this.f2162d.f13554b;
    }

    @Override // androidx.lifecycle.t0
    public final s0 getViewModelStore() {
        b();
        return this.f2160b;
    }
}
