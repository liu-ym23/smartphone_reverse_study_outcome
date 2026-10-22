package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.U;
import c0.C0574d;
import c0.InterfaceC0576f;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final class P extends U.e implements U.c {

    /* renamed from: b, reason: collision with root package name */
    private Application f10832b;

    /* renamed from: c, reason: collision with root package name */
    private final U.c f10833c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f10834d;

    /* renamed from: e, reason: collision with root package name */
    private AbstractC0533m f10835e;

    /* renamed from: f, reason: collision with root package name */
    private C0574d f10836f;

    public P(Application application, InterfaceC0576f interfaceC0576f, Bundle bundle) {
        j4.k.g(interfaceC0576f, "owner");
        this.f10836f = interfaceC0576f.getSavedStateRegistry();
        this.f10835e = interfaceC0576f.getLifecycle();
        this.f10834d = bundle;
        this.f10832b = application;
        this.f10833c = application != null ? U.a.f10844f.a(application) : new U.a();
    }

    @Override // androidx.lifecycle.U.c
    public <T extends T> T a(Class<T> cls) {
        j4.k.g(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) e(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.U.c
    public <T extends T> T c(Class<T> cls, W.a aVar) {
        j4.k.g(cls, "modelClass");
        j4.k.g(aVar, "extras");
        String str = (String) aVar.a(U.d.f10852d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (aVar.a(M.f10823a) == null || aVar.a(M.f10824b) == null) {
            if (this.f10835e != null) {
                return (T) e(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) aVar.a(U.a.f10846h);
        boolean zIsAssignableFrom = C0521a.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? Q.c(cls, Q.f10838b) : Q.c(cls, Q.f10837a);
        return constructorC == null ? (T) this.f10833c.c(cls, aVar) : (!zIsAssignableFrom || application == null) ? (T) Q.d(cls, constructorC, M.a(aVar)) : (T) Q.d(cls, constructorC, application, M.a(aVar));
    }

    @Override // androidx.lifecycle.U.e
    public void d(T t5) {
        j4.k.g(t5, "viewModel");
        if (this.f10835e != null) {
            C0574d c0574d = this.f10836f;
            j4.k.d(c0574d);
            AbstractC0533m abstractC0533m = this.f10835e;
            j4.k.d(abstractC0533m);
            C0532l.a(t5, c0574d, abstractC0533m);
        }
    }

    public final <T extends T> T e(String str, Class<T> cls) {
        T t5;
        Application application;
        j4.k.g(str, "key");
        j4.k.g(cls, "modelClass");
        AbstractC0533m abstractC0533m = this.f10835e;
        if (abstractC0533m == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = C0521a.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.f10832b == null) ? Q.c(cls, Q.f10838b) : Q.c(cls, Q.f10837a);
        if (constructorC == null) {
            return this.f10832b != null ? (T) this.f10833c.a(cls) : (T) U.d.f10850b.a().a(cls);
        }
        C0574d c0574d = this.f10836f;
        j4.k.d(c0574d);
        L lB = C0532l.b(c0574d, abstractC0533m, str, this.f10834d);
        if (!zIsAssignableFrom || (application = this.f10832b) == null) {
            t5 = (T) Q.d(cls, constructorC, lB.w());
        } else {
            j4.k.d(application);
            t5 = (T) Q.d(cls, constructorC, application, lB.w());
        }
        t5.G("androidx.lifecycle.savedstate.vm.tag", lB);
        return t5;
    }
}
