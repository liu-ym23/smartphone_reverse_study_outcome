package androidx.lifecycle;

import W.a;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.U;
import c0.C0574d;
import c0.InterfaceC0576f;

/* loaded from: classes.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b<InterfaceC0576f> f10823a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b<X> f10824b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b<Bundle> f10825c = new a();

    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    public static final class b implements a.b<InterfaceC0576f> {
        b() {
        }
    }

    public static final class c implements a.b<X> {
        c() {
        }
    }

    public static final class d implements U.c {
        d() {
        }

        @Override // androidx.lifecycle.U.c
        public <T extends T> T c(Class<T> cls, W.a aVar) {
            j4.k.g(cls, "modelClass");
            j4.k.g(aVar, "extras");
            return new O();
        }
    }

    public static final J a(W.a aVar) {
        j4.k.g(aVar, "<this>");
        InterfaceC0576f interfaceC0576f = (InterfaceC0576f) aVar.a(f10823a);
        if (interfaceC0576f == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        X x5 = (X) aVar.a(f10824b);
        if (x5 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f10825c);
        String str = (String) aVar.a(U.d.f10852d);
        if (str != null) {
            return b(interfaceC0576f, x5, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final J b(InterfaceC0576f interfaceC0576f, X x5, String str, Bundle bundle) {
        N nD = d(interfaceC0576f);
        O oE = e(x5);
        J j5 = oE.K().get(str);
        if (j5 != null) {
            return j5;
        }
        J jA = J.f10812f.a(nD.b(str), bundle);
        oE.K().put(str, jA);
        return jA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends InterfaceC0576f & X> void c(T t5) {
        j4.k.g(t5, "<this>");
        AbstractC0533m.b bVarB = t5.getLifecycle().b();
        if (bVarB != AbstractC0533m.b.INITIALIZED && bVarB != AbstractC0533m.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (t5.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            N n5 = new N(t5.getSavedStateRegistry(), t5);
            t5.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", n5);
            t5.getLifecycle().a(new K(n5));
        }
    }

    public static final N d(InterfaceC0576f interfaceC0576f) {
        j4.k.g(interfaceC0576f, "<this>");
        C0574d.c cVarC = interfaceC0576f.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        N n5 = cVarC instanceof N ? (N) cVarC : null;
        if (n5 != null) {
            return n5;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final O e(X x5) {
        j4.k.g(x5, "<this>");
        return (O) new U(x5, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", O.class);
    }
}
