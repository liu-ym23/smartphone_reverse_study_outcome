package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements b.a {
        @Override // w1.b.a
        public final void a(w1.d dVar) {
            if (!(dVar instanceof t0)) {
                throw new IllegalStateException(("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: " + dVar).toString());
            }
            s0 viewModelStore = ((t0) dVar).getViewModelStore();
            w1.b savedStateRegistry = dVar.getSavedStateRegistry();
            viewModelStore.getClass();
            LinkedHashMap linkedHashMap = viewModelStore.f2318a;
            Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                kotlin.jvm.internal.g.f(key, "key");
                q0 q0Var = (q0) linkedHashMap.get(key);
                if (q0Var != null) {
                    j.a(q0Var, savedStateRegistry, dVar.getLifecycle());
                }
            }
            if (new HashSet(linkedHashMap.keySet()).isEmpty()) {
                return;
            }
            savedStateRegistry.d();
        }
    }

    public static final void a(q0 q0Var, w1.b registry, Lifecycle lifecycle) {
        AutoCloseable autoCloseable;
        kotlin.jvm.internal.g.f(registry, "registry");
        kotlin.jvm.internal.g.f(lifecycle, "lifecycle");
        r1.a aVar = q0Var.f2302a;
        if (aVar != null) {
            synchronized (aVar.f11681a) {
                autoCloseable = (AutoCloseable) aVar.f11682b.get("androidx.lifecycle.savedstate.vm.tag");
            }
        } else {
            autoCloseable = null;
        }
        h0 h0Var = (h0) autoCloseable;
        if (h0Var == null || h0Var.f2272c) {
            return;
        }
        h0Var.K(lifecycle, registry);
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.f2215b || stateB.compareTo(Lifecycle.State.f2217d) >= 0) {
            registry.d();
        } else {
            lifecycle.a(new k(lifecycle, registry));
        }
    }
}
