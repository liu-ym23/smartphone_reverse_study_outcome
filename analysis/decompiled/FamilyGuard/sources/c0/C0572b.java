package c0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import c0.C0574d;
import j4.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: c0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0572b implements InterfaceC0537q {

    /* renamed from: b, reason: collision with root package name */
    public static final a f11932b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0576f f11933a;

    /* renamed from: c0.b$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: c0.b$b, reason: collision with other inner class name */
    public static final class C0155b implements C0574d.c {

        /* renamed from: a, reason: collision with root package name */
        private final Set<String> f11934a;

        public C0155b(C0574d c0574d) {
            k.g(c0574d, "registry");
            this.f11934a = new LinkedHashSet();
            c0574d.h("androidx.savedstate.Restarter", this);
        }

        @Override // c0.C0574d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f11934a));
            return bundle;
        }

        public final void b(String str) {
            k.g(str, "className");
            this.f11934a.add(str);
        }
    }

    public C0572b(InterfaceC0576f interfaceC0576f) {
        k.g(interfaceC0576f, "owner");
        this.f11933a = interfaceC0576f;
    }

    private final void b(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, C0572b.class.getClassLoader()).asSubclass(C0574d.a.class);
            k.f(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    k.f(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((C0574d.a) objNewInstance).a(this.f11933a);
                } catch (Exception e6) {
                    throw new RuntimeException("Failed to instantiate " + str, e6);
                }
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e7);
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("Class " + str + " wasn't found", e8);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        k.g(interfaceC0539t, "source");
        k.g(aVar, "event");
        if (aVar != AbstractC0533m.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0539t.getLifecycle().d(this);
        Bundle bundleB = this.f11933a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        int size = stringArrayList.size();
        int i5 = 0;
        while (i5 < size) {
            String str = stringArrayList.get(i5);
            i5++;
            b(str);
        }
    }
}
