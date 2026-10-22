package c0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import c0.C0572b;
import j4.k;
import java.util.Iterator;
import java.util.Map;
import n.C0870b;

/* renamed from: c0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0574d {

    /* renamed from: g, reason: collision with root package name */
    private static final b f11936g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private boolean f11938b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f11939c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11940d;

    /* renamed from: e, reason: collision with root package name */
    private C0572b.C0155b f11941e;

    /* renamed from: a, reason: collision with root package name */
    private final C0870b<String, c> f11937a = new C0870b<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f11942f = true;

    /* renamed from: c0.d$a */
    public interface a {
        void a(InterfaceC0576f interfaceC0576f);
    }

    /* renamed from: c0.d$b */
    private static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        private b() {
        }
    }

    /* renamed from: c0.d$c */
    public interface c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C0574d c0574d, InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        k.g(c0574d, "this$0");
        k.g(interfaceC0539t, "<anonymous parameter 0>");
        k.g(aVar, "event");
        if (aVar == AbstractC0533m.a.ON_START) {
            c0574d.f11942f = true;
        } else if (aVar == AbstractC0533m.a.ON_STOP) {
            c0574d.f11942f = false;
        }
    }

    public final Bundle b(String str) {
        k.g(str, "key");
        if (!this.f11940d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f11939c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f11939c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f11939c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f11939c = null;
        return bundle2;
    }

    public final c c(String str) {
        k.g(str, "key");
        Iterator<Map.Entry<String, c>> it = this.f11937a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            k.f(next, "components");
            String key = next.getKey();
            c value = next.getValue();
            if (k.b(key, str)) {
                return value;
            }
        }
        return null;
    }

    public final void e(AbstractC0533m abstractC0533m) {
        k.g(abstractC0533m, "lifecycle");
        if (this.f11938b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        abstractC0533m.a(new InterfaceC0537q() { // from class: c0.c
            @Override // androidx.lifecycle.InterfaceC0537q
            public final void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
                C0574d.d(this.f11935a, interfaceC0539t, aVar);
            }
        });
        this.f11938b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f11938b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f11940d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f11939c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f11940d = true;
    }

    public final void g(Bundle bundle) {
        k.g(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f11939c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0870b<String, c>.d dVarF = this.f11937a.f();
        k.f(dVarF, "this.components.iteratorWithAdditions()");
        while (dVarF.hasNext()) {
            Map.Entry next = dVarF.next();
            bundle2.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        k.g(str, "key");
        k.g(cVar, "provider");
        if (this.f11937a.m(str, cVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class<? extends a> cls) throws NoSuchMethodException, SecurityException {
        k.g(cls, "clazz");
        if (!this.f11942f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        C0572b.C0155b c0155b = this.f11941e;
        if (c0155b == null) {
            c0155b = new C0572b.C0155b(this);
        }
        this.f11941e = c0155b;
        try {
            cls.getDeclaredConstructor(null);
            C0572b.C0155b c0155b2 = this.f11941e;
            if (c0155b2 != null) {
                String name = cls.getName();
                k.f(name, "clazz.name");
                c0155b2.b(name);
            }
        } catch (NoSuchMethodException e6) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
        }
    }
}
