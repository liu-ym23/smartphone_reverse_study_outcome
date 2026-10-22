package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewModelProvider.c implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0034a f3495d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SavedStateRegistry f3496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Lifecycle f3497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f3498c;

    /* JADX INFO: renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    public static final class C0034a {
        public /* synthetic */ C0034a(DefaultConstructorMarker r10) {
            this();
        }

        public C0034a() {
        }
    }

    static {
        f3495d = new C0034a(null);
    }

    public a(SavedStateRegistryOwner r10, Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "owner");
        this.f3496a = r10.getSavedStateRegistry();
        this.f3497b = r10.getLifecycle();
        this.f3498c = r11;
    }

    private final k0 b(String r10, Class r11) {
        SavedStateRegistry r12 = this.f3496a;
        kotlin.jvm.internal.q.d(r12);
        Lifecycle r13 = this.f3497b;
        kotlin.jvm.internal.q.d(r13);
        d0 r14 = k.b(r12, r13, r10, this.f3498c);
        k0 r15 = c(r10, r11, r14.b());
        r15.e("androidx.lifecycle.savedstate.vm.tag", r14);
        return r15;
    }

    @Override // androidx.lifecycle.ViewModelProvider.c
    public void a(k0 r10) {
        kotlin.jvm.internal.q.g(r10, "viewModel");
        SavedStateRegistry r11 = this.f3496a;
        if (r11 == null) goto L6;
        kotlin.jvm.internal.q.d(r11);
        Lifecycle r12 = this.f3497b;
        kotlin.jvm.internal.q.d(r12);
        k.a(r10, r11, r12);
        return;
    }

    public abstract k0 c(String r10, Class r11, b0 r12);

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        kotlin.jvm.internal.q.g(r11, "extras");
        String r12 = (String) r11.a(ViewModelProvider.b.f3491c);
        if (r12 == null) goto L10;
        if (this.f3496a == null) goto L8;
        return b(r12, r10);
    L8:
        return c(r12, r10, e0.a(r11));
    L10:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        String r11 = r10.getCanonicalName();
        if (r11 == null) goto L11;
        if (this.f3497b == null) goto L9;
        return b(r11, r10);
    L9:
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    L11:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
