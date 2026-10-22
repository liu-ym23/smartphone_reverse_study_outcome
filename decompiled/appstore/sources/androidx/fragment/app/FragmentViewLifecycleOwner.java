package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
public class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f3271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewModelStore f3272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f3273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewModelProvider.Factory f3274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LifecycleRegistry f3275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SavedStateRegistryController f3276f;

    public FragmentViewLifecycleOwner(Fragment r10, ViewModelStore r11, Runnable r12) {
        this.f3275e = null;
        this.f3276f = null;
        this.f3271a = r10;
        this.f3272b = r11;
        this.f3273c = r12;
    }

    public void a() {
        if (this.f3275e != null) goto L6;
        this.f3275e = new LifecycleRegistry(this);
        SavedStateRegistryController r10 = SavedStateRegistryController.a(this);
        this.f3276f = r10;
        r10.c();
        this.f3273c.run();
        return;
    }

    public boolean b() {
        if (this.f3275e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void c(Bundle r10) {
        this.f3276f.d(r10);
    }

    public void d(Bundle r10) {
        this.f3276f.e(r10);
    }

    public void e(Lifecycle.State r10) {
        this.f3275e.n(r10);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r10 = this.f3271a.requireContext().getApplicationContext();
    L4:
        if ((r10 instanceof ContextWrapper) == false) goto L9;
        if ((r10 instanceof Application) == true) goto L7;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L4
    L7:
        Application r11 = (Application) r10;
    L10:
        androidx.lifecycle.viewmodel.a r12 = new androidx.lifecycle.viewmodel.a();
        if (r11 == null) goto L13;
        r12.c(ViewModelProvider.a.f3486g, r11);
    L13:
        r12.c(androidx.lifecycle.e0.f3520a, this.f3271a);
        r12.c(androidx.lifecycle.e0.f3521b, this);
        if (this.f3271a.getArguments() == null) goto L16;
        r12.c(androidx.lifecycle.e0.f3522c, this.f3271a.getArguments());
    L16:
        return r12;
    L9:
        r11 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory r10 = this.f3271a.getDefaultViewModelProviderFactory();
        if (r10.equals(this.f3271a.mDefaultFactory) == true) goto L7;
        this.f3274d = r10;
        return r10;
    L7:
        if (this.f3274d != null) goto L18;
        Context r11 = this.f3271a.requireContext().getApplicationContext();
    L10:
        if ((r11 instanceof ContextWrapper) == false) goto L15;
        if ((r11 instanceof Application) == true) goto L13;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L10
    L13:
        Application r12 = (Application) r11;
    L16:
        Fragment r13 = this.f3271a;
        this.f3274d = new androidx.lifecycle.g0(r12, r13, r13.getArguments());
        goto L18
    L15:
        r12 = null;
    L18:
        return this.f3274d;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        a();
        return this.f3275e;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        a();
        return this.f3276f.b();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        a();
        return this.f3272b;
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event r10) {
        this.f3275e.handleLifecycleEvent(r10);
    }
}
