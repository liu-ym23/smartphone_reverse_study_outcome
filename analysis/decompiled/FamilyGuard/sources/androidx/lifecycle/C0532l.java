package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;
import c0.C0574d;
import c0.InterfaceC0576f;
import java.util.Iterator;

/* renamed from: androidx.lifecycle.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0532l {

    /* renamed from: a, reason: collision with root package name */
    public static final C0532l f10876a = new C0532l();

    /* renamed from: androidx.lifecycle.l$a */
    public static final class a implements C0574d.a {
        @Override // c0.C0574d.a
        public void a(InterfaceC0576f interfaceC0576f) throws NoSuchMethodException, SecurityException {
            j4.k.g(interfaceC0576f, "owner");
            if (!(interfaceC0576f instanceof X)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            W viewModelStore = ((X) interfaceC0576f).getViewModelStore();
            C0574d savedStateRegistry = interfaceC0576f.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                T tB = viewModelStore.b(it.next());
                j4.k.d(tB);
                C0532l.a(tB, savedStateRegistry, interfaceC0576f.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    /* renamed from: androidx.lifecycle.l$b */
    public static final class b implements InterfaceC0537q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0533m f10877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0574d f10878b;

        b(AbstractC0533m abstractC0533m, C0574d c0574d) {
            this.f10877a = abstractC0533m;
            this.f10878b = c0574d;
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) throws NoSuchMethodException, SecurityException {
            j4.k.g(interfaceC0539t, "source");
            j4.k.g(aVar, "event");
            if (aVar == AbstractC0533m.a.ON_START) {
                this.f10877a.d(this);
                this.f10878b.i(a.class);
            }
        }
    }

    private C0532l() {
    }

    public static final void a(T t5, C0574d c0574d, AbstractC0533m abstractC0533m) {
        j4.k.g(t5, "viewModel");
        j4.k.g(c0574d, "registry");
        j4.k.g(abstractC0533m, "lifecycle");
        L l5 = (L) t5.I("androidx.lifecycle.savedstate.vm.tag");
        if (l5 == null || l5.x()) {
            return;
        }
        l5.v(c0574d, abstractC0533m);
        f10876a.c(c0574d, abstractC0533m);
    }

    public static final L b(C0574d c0574d, AbstractC0533m abstractC0533m, String str, Bundle bundle) {
        j4.k.g(c0574d, "registry");
        j4.k.g(abstractC0533m, "lifecycle");
        j4.k.d(str);
        L l5 = new L(str, J.f10812f.a(c0574d.b(str), bundle));
        l5.v(c0574d, abstractC0533m);
        f10876a.c(c0574d, abstractC0533m);
        return l5;
    }

    private final void c(C0574d c0574d, AbstractC0533m abstractC0533m) throws NoSuchMethodException, SecurityException {
        AbstractC0533m.b bVarB = abstractC0533m.b();
        if (bVarB == AbstractC0533m.b.INITIALIZED || bVarB.d(AbstractC0533m.b.STARTED)) {
            c0574d.i(a.class);
        } else {
            abstractC0533m.a(new b(abstractC0533m, c0574d));
        }
    }
}
