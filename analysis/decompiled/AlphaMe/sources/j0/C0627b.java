package j0;

import android.os.Bundle;
import androidx.lifecycle.C0322t;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import androidx.lifecycle.h0;
import androidx.lifecycle.n0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0627b implements E {

    /* renamed from: a, reason: collision with root package name */
    public final h f13118a;

    public C0627b(h owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f13118a = owner;
    }

    @Override // androidx.lifecycle.E
    public final void a(G source, EnumC0326x event) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != EnumC0326x.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().b(this);
        h owner = this.f13118a;
        Bundle bundleA = owner.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, C0627b.class.getClassLoader()).asSubclass(InterfaceC0629d.class);
                Intrinsics.checkNotNullExpressionValue(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n                constr…wInstance()\n            }");
                        ((C0322t) ((InterfaceC0629d) objNewInstance)).getClass();
                        Intrinsics.checkNotNullParameter(owner, "owner");
                        if (!(owner instanceof u0)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
                        }
                        t0 viewModelStore = ((u0) owner).getViewModelStore();
                        C0631f savedStateRegistry = owner.getSavedStateRegistry();
                        viewModelStore.getClass();
                        LinkedHashMap linkedHashMap = viewModelStore.f3982a;
                        Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                        while (it.hasNext()) {
                            String key = (String) it.next();
                            Intrinsics.checkNotNullParameter(key, "key");
                            n0 n0Var = (n0) linkedHashMap.get(key);
                            Intrinsics.checkNotNull(n0Var);
                            h0.a(n0Var, savedStateRegistry, owner.getLifecycle());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.d();
                        }
                    } catch (Exception e4) {
                        throw new RuntimeException(B0.g.m("Failed to instantiate ", str), e4);
                    }
                } catch (NoSuchMethodException e5) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
                }
            } catch (ClassNotFoundException e6) {
                throw new RuntimeException(B0.g.n("Class ", str, " wasn't found"), e6);
            }
        }
    }
}
