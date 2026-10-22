package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationExtras.Key f3520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CreationExtras.Key f3521b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CreationExtras.Key f3522c = null;

    public static final class a implements CreationExtras.Key {
        public a() {
        }
    }

    public static final class b implements CreationExtras.Key {
        public b() {
        }
    }

    public static final class c implements CreationExtras.Key {
        public c() {
        }
    }

    public static final class d implements ViewModelProvider.Factory {
        public d() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10, CreationExtras r11) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            kotlin.jvm.internal.q.g(r11, "extras");
            return new f0();
        }
    }

    static {
        f3520a = new b();
        f3521b = new c();
        f3522c = new a();
    }

    public static final b0 a(CreationExtras r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        SavedStateRegistryOwner r11 = (SavedStateRegistryOwner) r10.a(f3520a);
        if (r11 == null) goto L15;
        ViewModelStoreOwner r12 = (ViewModelStoreOwner) r10.a(f3521b);
        if (r12 == null) goto L13;
        Bundle r13 = (Bundle) r10.a(f3522c);
        String r14 = (String) r10.a(ViewModelProvider.b.f3491c);
        if (r14 == null) goto L11;
        return b(r11, r12, r14, r13);
    L11:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L13:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L15:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final b0 b(SavedStateRegistryOwner r10, ViewModelStoreOwner r11, String r12, Bundle r13) {
        SavedStateHandlesProvider r14 = d(r10);
        f0 r15 = e(r11);
        b0 r16 = (b0) r15.f().get(r12);
        if (r16 != null) goto L6;
        b0 r17 = b0.f3500f.a(r14.a(r12), r13);
        r15.f().put(r12, r17);
        return r17;
    L6:
        return r16;
    }

    public static final void c(SavedStateRegistryOwner r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Lifecycle.State r11 = r10.getLifecycle().b();
        if (r11 == Lifecycle.State.INITIALIZED) goto L10;
        if (r11 == Lifecycle.State.CREATED) goto L10;
        throw new IllegalArgumentException("Failed requirement.");
    L10:
        if (r10.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") != null) goto L13;
        SavedStateHandlesProvider r12 = new SavedStateHandlesProvider(r10.getSavedStateRegistry(), (ViewModelStoreOwner) r10);
        r10.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", r12);
        r10.getLifecycle().a(new c0(r12));
        return;
    }

    public static final SavedStateHandlesProvider d(SavedStateRegistryOwner r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        SavedStateRegistry.SavedStateProvider r11 = r10.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if ((r11 instanceof SavedStateHandlesProvider) == false) goto L5;
        SavedStateHandlesProvider r12 = (SavedStateHandlesProvider) r11;
    L6:
        if (r12 == null) goto L9;
        return r12;
    L9:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L5:
        r12 = null;
        goto L6
    }

    public static final f0 e(ViewModelStoreOwner r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return (f0) new ViewModelProvider(r10, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", f0.class);
    }
}
