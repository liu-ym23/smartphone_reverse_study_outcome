package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import d0.C0534d;
import j0.C0631f;
import java.io.IOException;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class k0 extends s0 implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public final Application f3959a;

    /* renamed from: b, reason: collision with root package name */
    public final p0 f3960b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f3961c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0328z f3962d;

    /* renamed from: e, reason: collision with root package name */
    public final C0631f f3963e;

    public k0(Application application, j0.h owner, Bundle bundle) {
        p0 p0Var;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f3963e = owner.getSavedStateRegistry();
        this.f3962d = owner.getLifecycle();
        this.f3961c = bundle;
        this.f3959a = application;
        if (application != null) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (p0.f3976c == null) {
                Intrinsics.checkNotNullParameter(application, "application");
                p0.f3976c = new p0(application);
            }
            p0Var = p0.f3976c;
            Intrinsics.checkNotNull(p0Var);
        } else {
            p0Var = new p0(null);
        }
        this.f3960b = p0Var;
    }

    @Override // androidx.lifecycle.q0
    public final n0 a(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return b(modelClass, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final n0 b(Class modelClass, String key) throws NoSuchMethodException, IOException, SecurityException {
        n0 n0VarB;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        AbstractC0328z lifecycle = this.f3962d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0304a.class.isAssignableFrom(modelClass);
        Application application = this.f3959a;
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? l0.a(modelClass, l0.f3965b) : l0.a(modelClass, l0.f3964a);
        if (constructorA == null) {
            if (application != null) {
                return this.f3960b.a(modelClass);
            }
            if (r0.f3981a == null) {
                r0.f3981a = new r0();
            }
            r0 r0Var = r0.f3981a;
            Intrinsics.checkNotNull(r0Var);
            return r0Var.a(modelClass);
        }
        C0631f registry = this.f3963e;
        Intrinsics.checkNotNull(registry);
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNull(key);
        Bundle bundleA = registry.a(key);
        Class[] clsArr = e0.f3930f;
        e0 e0VarE = y1.f.e(bundleA, this.f3961c);
        f0 f0Var = new f0(key, e0VarE);
        f0Var.b(lifecycle, registry);
        EnumC0327y enumC0327y = ((I) lifecycle).f3871d;
        if (enumC0327y == EnumC0327y.f3984b || enumC0327y.a(EnumC0327y.f3986d)) {
            registry.d();
        } else {
            lifecycle.a(new C0317n(lifecycle, registry));
        }
        if (!zIsAssignableFrom || application == null) {
            n0VarB = l0.b(modelClass, constructorA, e0VarE);
        } else {
            Intrinsics.checkNotNull(application);
            n0VarB = l0.b(modelClass, constructorA, application, e0VarE);
        }
        n0VarB.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", f0Var);
        return n0VarB;
    }

    @Override // androidx.lifecycle.q0
    public final n0 c(Class modelClass, C0534d extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        String str = (String) extras.a(o0.f3974b);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(h0.f3945a) == null || extras.a(h0.f3946b) == null) {
            if (this.f3962d != null) {
                return b(modelClass, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(o0.f3973a);
        boolean zIsAssignableFrom = AbstractC0304a.class.isAssignableFrom(modelClass);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? l0.a(modelClass, l0.f3965b) : l0.a(modelClass, l0.f3964a);
        return constructorA == null ? this.f3960b.c(modelClass, extras) : (!zIsAssignableFrom || application == null) ? l0.b(modelClass, constructorA, h0.b(extras)) : l0.b(modelClass, constructorA, application, h0.b(extras));
    }
}
