package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f3548a = null;

    public static final class a implements SavedStateRegistry.AutoRecreated {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r10) {
            kotlin.jvm.internal.q.g(r10, "owner");
            if ((r10 instanceof ViewModelStoreOwner) == false) goto L13;
            ViewModelStore r11 = ((ViewModelStoreOwner) r10).getViewModelStore();
            SavedStateRegistry r12 = r10.getSavedStateRegistry();
            Iterator r13 = r11.c().iterator();
        L6:
            if (r13.hasNext() == false) goto L9;
            k0 r14 = r11.b((String) r13.next());
            kotlin.jvm.internal.q.d(r14);
            k.a(r14, r12, r10.getLifecycle());
            goto L6
        L9:
            if (r11.c().isEmpty() == true) goto L15;
            r12.i(a.class);
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
    }

    public static final class b implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f3549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SavedStateRegistry f3550b;

        public b(Lifecycle r10, SavedStateRegistry r11) {
            this.f3549a = r10;
            this.f3550b = r11;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            kotlin.jvm.internal.q.g(r10, "source");
            kotlin.jvm.internal.q.g(r11, "event");
            if (r11 != Lifecycle.Event.ON_START) goto L6;
            this.f3549a.d(this);
            this.f3550b.i(a.class);
            return;
        }
    }

    static {
        f3548a = new k();
    }

    public k() {
    }

    public static final void a(k0 r10, SavedStateRegistry r11, Lifecycle r12) {
        kotlin.jvm.internal.q.g(r10, "viewModel");
        kotlin.jvm.internal.q.g(r11, "registry");
        kotlin.jvm.internal.q.g(r12, "lifecycle");
        d0 r13 = (d0) r10.c("androidx.lifecycle.savedstate.vm.tag");
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.c() == true) goto L9;
        r13.a(r11, r12);
        f3548a.c(r11, r12);
        return;
    }

    public static final d0 b(SavedStateRegistry r10, Lifecycle r11, String r12, Bundle r13) {
        kotlin.jvm.internal.q.g(r10, "registry");
        kotlin.jvm.internal.q.g(r11, "lifecycle");
        kotlin.jvm.internal.q.d(r12);
        Bundle r14 = r10.b(r12);
        d0 r15 = new d0(r12, b0.f3500f.a(r14, r13));
        r15.a(r10, r11);
        f3548a.c(r10, r11);
        return r15;
    }

    public final void c(SavedStateRegistry r10, Lifecycle r11) {
        Lifecycle.State r12 = r11.b();
        if (r12 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r10.i(a.class);
        return;
    L5:
        if (r12.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r11.a(new b(r11, r10));
    }
}
