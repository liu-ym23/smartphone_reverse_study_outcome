package androidx.lifecycle;

import android.os.Bundle;
import d0.C0534d;
import j0.C0631f;
import j0.InterfaceC0630e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f3945a = new o0();

    /* renamed from: b, reason: collision with root package name */
    public static final o0 f3946b = new o0();

    /* renamed from: c, reason: collision with root package name */
    public static final o0 f3947c = new o0();

    public static final void a(n0 viewModel, C0631f registry, AbstractC0328z lifecycle) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        f0 f0Var = (f0) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (f0Var == null || f0Var.f3940c) {
            return;
        }
        f0Var.b(lifecycle, registry);
        EnumC0327y enumC0327y = ((I) lifecycle).f3871d;
        if (enumC0327y == EnumC0327y.f3984b || enumC0327y.a(EnumC0327y.f3986d)) {
            registry.d();
        } else {
            lifecycle.a(new C0317n(lifecycle, registry));
        }
    }

    public static final e0 b(C0534d c0534d) {
        Intrinsics.checkNotNullParameter(c0534d, "<this>");
        j0.h hVar = (j0.h) c0534d.a(f3945a);
        if (hVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        u0 u0Var = (u0) c0534d.a(f3946b);
        if (u0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) c0534d.a(f3947c);
        String key = (String) c0534d.a(o0.f3974b);
        if (key == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        InterfaceC0630e interfaceC0630eB = hVar.getSavedStateRegistry().b();
        i0 i0Var = interfaceC0630eB instanceof i0 ? (i0) interfaceC0630eB : null;
        if (i0Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        Intrinsics.checkNotNullParameter(u0Var, "<this>");
        j0 j0Var = (j0) new android.support.v4.media.session.c(u0Var, new g0()).f(j0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
        e0 e0Var = (e0) j0Var.f3957a.get(key);
        if (e0Var != null) {
            return e0Var;
        }
        Class[] clsArr = e0.f3930f;
        Intrinsics.checkNotNullParameter(key, "key");
        i0Var.b();
        Bundle bundle2 = i0Var.f3952c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(key) : null;
        Bundle bundle4 = i0Var.f3952c;
        if (bundle4 != null) {
            bundle4.remove(key);
        }
        Bundle bundle5 = i0Var.f3952c;
        if (bundle5 != null && bundle5.isEmpty()) {
            i0Var.f3952c = null;
        }
        e0 e0VarE = y1.f.e(bundle3, bundle);
        j0Var.f3957a.put(key, e0VarE);
        return e0VarE;
    }

    public static final void c(j0.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        EnumC0327y enumC0327y = ((I) hVar.getLifecycle()).f3871d;
        if (enumC0327y != EnumC0327y.f3984b && enumC0327y != EnumC0327y.f3985c) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (hVar.getSavedStateRegistry().b() == null) {
            i0 i0Var = new i0(hVar.getSavedStateRegistry(), (u0) hVar);
            hVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", i0Var);
            hVar.getLifecycle().a(new C0312i(i0Var));
        }
    }
}
