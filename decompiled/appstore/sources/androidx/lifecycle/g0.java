package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends ViewModelProvider.c implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f3529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewModelProvider.Factory f3530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f3531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle f3532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SavedStateRegistry f3533e;

    public g0(Application r10, SavedStateRegistryOwner r11, Bundle r12) {
        kotlin.jvm.internal.q.g(r11, "owner");
        this.f3533e = r11.getSavedStateRegistry();
        this.f3532d = r11.getLifecycle();
        this.f3531c = r12;
        this.f3529a = r10;
        if (r10 == null) goto L5;
        ViewModelProvider.a r13 = ViewModelProvider.a.f3484e.a(r10);
    L6:
        this.f3530b = r13;
        return;
    L5:
        r13 = new ViewModelProvider.a();
        goto L6
    }

    @Override // androidx.lifecycle.ViewModelProvider.c
    public void a(k0 r10) {
        kotlin.jvm.internal.q.g(r10, "viewModel");
        if (this.f3532d == null) goto L6;
        SavedStateRegistry r11 = this.f3533e;
        kotlin.jvm.internal.q.d(r11);
        Lifecycle r12 = this.f3532d;
        kotlin.jvm.internal.q.d(r12);
        k.a(r10, r11, r12);
        return;
    }

    public final k0 b(String r10, Class r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        kotlin.jvm.internal.q.g(r11, "modelClass");
        Lifecycle r12 = this.f3532d;
        if (r12 == null) goto L25;
        boolean r13 = b.class.isAssignableFrom(r11);
        if (r13 == true) goto L7;
    L9:
        Constructor r14 = h0.c(r11, h0.b());
    L10:
        if (r14 == null) goto L12;
        SavedStateRegistry r15 = this.f3533e;
        kotlin.jvm.internal.q.d(r15);
        d0 r16 = k.b(r15, r12, r10, this.f3531c);
        if (r13 == false) goto L21;
        Application r17 = this.f3529a;
        if (r17 == null) goto L21;
        kotlin.jvm.internal.q.d(r17);
        k0 r18 = h0.d(r11, r14, new Object[]{r17, r16.b()});
    L22:
        r18.e("androidx.lifecycle.savedstate.vm.tag", r16);
        return r18;
    L21:
        r18 = h0.d(r11, r14, new Object[]{r16.b()});
        goto L22
    L12:
        if (this.f3529a == null) goto L15;
        return this.f3530b.create(r11);
    L15:
        return ViewModelProvider.b.f3489a.a().create(r11);
    L7:
        if (this.f3529a == null) goto L9;
        r14 = h0.c(r11, h0.a());
        goto L10
    L25:
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        kotlin.jvm.internal.q.g(r11, "extras");
        String r12 = (String) r11.a(ViewModelProvider.b.f3491c);
        if (r12 == null) goto L27;
        if (r11.a(e0.f3520a) == null) goto L21;
        if (r11.a(e0.f3521b) == null) goto L21;
        Application r13 = (Application) r11.a(ViewModelProvider.a.f3486g);
        boolean r14 = b.class.isAssignableFrom(r10);
        if (r14 == false) goto L12;
        if (r13 == null) goto L12;
        Constructor r15 = h0.c(r10, h0.a());
    L13:
        if (r15 == null) goto L15;
        if (r14 == false) goto L29;
        if (r13 == null) goto L29;
        return h0.d(r10, r15, new Object[]{r13, e0.a(r11)});
    L29:
        return h0.d(r10, r15, new Object[]{e0.a(r11)});
    L15:
        return this.f3530b.create(r10, r11);
    L12:
        r15 = h0.c(r10, h0.b());
    L21:
        if (this.f3532d == null) goto L25;
        return b(r12, r10);
    L25:
        throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    L27:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        String r11 = r10.getCanonicalName();
        if (r11 == null) goto L7;
        return b(r11, r10);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
