package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r0;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import kotlin.collections.builders.MapBuilder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m0 extends r0.d implements r0.b {

    /* renamed from: a, reason: collision with root package name */
    public final Application f2287a;

    /* renamed from: b, reason: collision with root package name */
    public final r0.a f2288b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f2289c;

    /* renamed from: d, reason: collision with root package name */
    public final Lifecycle f2290d;

    /* renamed from: e, reason: collision with root package name */
    public final w1.b f2291e;

    @SuppressLint({"LambdaLast"})
    public m0(Application application, w1.d owner, Bundle bundle) {
        r0.a aVar;
        kotlin.jvm.internal.g.f(owner, "owner");
        this.f2291e = owner.getSavedStateRegistry();
        this.f2290d = owner.getLifecycle();
        this.f2289c = bundle;
        this.f2287a = application;
        if (application != null) {
            if (r0.a.f2304c == null) {
                r0.a.f2304c = new r0.a(application);
            }
            aVar = r0.a.f2304c;
            kotlin.jvm.internal.g.c(aVar);
        } else {
            aVar = new r0.a(null);
        }
        this.f2288b = aVar;
    }

    @Override // androidx.lifecycle.r0.b
    public final <T extends q0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) e(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.r0.b
    public final q0 b(kotlin.jvm.internal.c cVar, q1.b bVar) {
        return c(xb.a.e(cVar), bVar);
    }

    @Override // androidx.lifecycle.r0.b
    public final q0 c(Class cls, q1.b bVar) {
        LinkedHashMap linkedHashMap = bVar.f11486a;
        String str = (String) linkedHashMap.get(r0.f2303a);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(i0.f2273a) == null || linkedHashMap.get(i0.f2274b) == null) {
            if (this.f2290d != null) {
                return e(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(r0.a.f2305d);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? n0.a(cls, n0.f2294b) : n0.a(cls, n0.f2293a);
        return constructorA == null ? this.f2288b.c(cls, bVar) : (!zIsAssignableFrom || application == null) ? n0.b(cls, constructorA, i0.a(bVar)) : n0.b(cls, constructorA, application, i0.a(bVar));
    }

    @Override // androidx.lifecycle.r0.d
    public final void d(q0 q0Var) {
        Lifecycle lifecycle = this.f2290d;
        if (lifecycle != null) {
            w1.b bVar = this.f2291e;
            kotlin.jvm.internal.g.c(bVar);
            j.a(q0Var, bVar, lifecycle);
        }
    }

    public final q0 e(Class cls, String str) {
        f0 f0Var;
        AutoCloseable autoCloseable;
        Application application;
        Lifecycle lifecycle = this.f2290d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.f2287a == null) ? n0.a(cls, n0.f2294b) : n0.a(cls, n0.f2293a);
        if (constructorA == null) {
            if (this.f2287a != null) {
                return this.f2288b.a(cls);
            }
            if (r0.c.f2307a == null) {
                r0.c.f2307a = new r0.c();
            }
            kotlin.jvm.internal.g.c(r0.c.f2307a);
            return jd.b.p(cls);
        }
        w1.b bVar = this.f2291e;
        kotlin.jvm.internal.g.c(bVar);
        Bundle bundle = this.f2289c;
        Bundle bundleA = bVar.a(str);
        if (bundleA != null) {
            bundle = bundleA;
        }
        if (bundle == null) {
            f0Var = new f0();
        } else {
            ClassLoader classLoader = f0.class.getClassLoader();
            kotlin.jvm.internal.g.c(classLoader);
            bundle.setClassLoader(classLoader);
            MapBuilder mapBuilder = new MapBuilder(bundle.size());
            for (String str2 : bundle.keySet()) {
                kotlin.jvm.internal.g.c(str2);
                mapBuilder.put(str2, bundle.get(str2));
            }
            f0Var = new f0(mapBuilder.b());
        }
        h0 h0Var = new h0(str, f0Var);
        h0Var.K(lifecycle, bVar);
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.f2215b || stateB.compareTo(Lifecycle.State.f2217d) >= 0) {
            bVar.d();
        } else {
            lifecycle.a(new k(lifecycle, bVar));
        }
        q0 q0VarB = (!zIsAssignableFrom || (application = this.f2287a) == null) ? n0.b(cls, constructorA, f0Var) : n0.b(cls, constructorA, application, f0Var);
        q0VarB.getClass();
        r1.a aVar = q0VarB.f2302a;
        if (aVar == null) {
            return q0VarB;
        }
        if (aVar.f11684d) {
            r1.a.a(h0Var);
            return q0VarB;
        }
        synchronized (aVar.f11681a) {
            autoCloseable = (AutoCloseable) aVar.f11682b.put("androidx.lifecycle.savedstate.vm.tag", h0Var);
        }
        r1.a.a(autoCloseable);
        return q0VarB;
    }
}
