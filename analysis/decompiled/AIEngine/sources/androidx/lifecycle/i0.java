package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r0;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import q1.a;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2273a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final c f2274b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final d f2275c = new d();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements r0.b {
        @Override // androidx.lifecycle.r0.b
        public final q0 b(kotlin.jvm.internal.c cVar, q1.b bVar) {
            return new l0();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d {
    }

    public static final f0 a(q1.b bVar) {
        f0 f0Var;
        LinkedHashMap linkedHashMap = bVar.f11486a;
        w1.d dVar = (w1.d) linkedHashMap.get(f2273a);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        t0 t0Var = (t0) linkedHashMap.get(f2274b);
        if (t0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f2275c);
        String str = (String) linkedHashMap.get(r0.f2303a);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        b.InterfaceC0161b interfaceC0161bB = dVar.getSavedStateRegistry().b();
        Bundle bundle2 = null;
        k0 k0Var = interfaceC0161bB instanceof k0 ? (k0) interfaceC0161bB : null;
        if (k0Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = c(t0Var).f2284b;
        f0 f0Var2 = (f0) linkedHashMap2.get(str);
        if (f0Var2 != null) {
            return f0Var2;
        }
        k0Var.b();
        Bundle bundle3 = k0Var.f2282c;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                kotlin.collections.b.d0();
                bundle4 = r0.b.a((Pair[]) Arrays.copyOf(new Pair[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                k0Var.f2282c = null;
            }
            bundle2 = bundle4;
        }
        if (bundle2 != null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            f0Var = new f0();
        } else {
            ClassLoader classLoader = f0.class.getClassLoader();
            kotlin.jvm.internal.g.c(classLoader);
            bundle.setClassLoader(classLoader);
            MapBuilder mapBuilder = new MapBuilder(bundle.size());
            for (String str2 : bundle.keySet()) {
                kotlin.jvm.internal.g.c(str2);
                mapBuilder.put(str2, bundle.get(str2));
            }
            f0Var = new f0(mapBuilder.b());
        }
        linkedHashMap2.put(str, f0Var);
        return f0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends w1.d & t0> void b(T t8) {
        Lifecycle.State stateB = t8.getLifecycle().b();
        if (stateB != Lifecycle.State.f2215b && stateB != Lifecycle.State.f2216c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (t8.getSavedStateRegistry().b() == null) {
            k0 k0Var = new k0(t8.getSavedStateRegistry(), t8);
            t8.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", k0Var);
            t8.getLifecycle().a(new g0(k0Var));
        }
    }

    public static final l0 c(t0 t0Var) {
        a aVar = new a();
        q1.a extras = t0Var instanceof i ? ((i) t0Var).getDefaultViewModelCreationExtras() : a.C0127a.f11487b;
        kotlin.jvm.internal.g.f(extras, "extras");
        s0 store = t0Var.getViewModelStore();
        kotlin.jvm.internal.g.f(store, "store");
        return (l0) new r1.b(store, aVar, extras).a(kotlin.jvm.internal.i.a(l0.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
