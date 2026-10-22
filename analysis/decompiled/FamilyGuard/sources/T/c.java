package T;

import W3.C0403n;
import W3.E;
import W3.K;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.ComponentCallbacksC0511f;
import androidx.fragment.app.x;
import j4.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f5287a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static C0081c f5288b = C0081c.f5299d;

    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface b {
    }

    /* renamed from: T.c$c, reason: collision with other inner class name */
    public static final class C0081c {

        /* renamed from: c, reason: collision with root package name */
        public static final a f5298c = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final C0081c f5299d = new C0081c(K.b(), null, E.d());

        /* renamed from: a, reason: collision with root package name */
        private final Set<a> f5300a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, Set<Class<? extends i>>> f5301b;

        /* renamed from: T.c$c$a */
        public static final class a {
            public /* synthetic */ a(j4.g gVar) {
                this();
            }

            private a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0081c(Set<? extends a> set, b bVar, Map<String, ? extends Set<Class<? extends i>>> map) {
            k.g(set, "flags");
            k.g(map, "allowedViolations");
            this.f5300a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends i>>> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f5301b = linkedHashMap;
        }

        public final Set<a> a() {
            return this.f5300a;
        }

        public final b b() {
            return null;
        }

        public final Map<String, Set<Class<? extends i>>> c() {
            return this.f5301b;
        }
    }

    private c() {
    }

    private final C0081c b(ComponentCallbacksC0511f componentCallbacksC0511f) {
        while (componentCallbacksC0511f != null) {
            if (componentCallbacksC0511f.g0()) {
                x xVarK = componentCallbacksC0511f.K();
                k.f(xVarK, "declaringFragment.parentFragmentManager");
                if (xVarK.y0() != null) {
                    C0081c c0081cY0 = xVarK.y0();
                    k.d(c0081cY0);
                    return c0081cY0;
                }
            }
            componentCallbacksC0511f = componentCallbacksC0511f.J();
        }
        return f5288b;
    }

    private final void c(C0081c c0081c, final i iVar) {
        ComponentCallbacksC0511f componentCallbacksC0511fA = iVar.a();
        final String name = componentCallbacksC0511fA.getClass().getName();
        if (c0081c.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, iVar);
        }
        c0081c.b();
        if (c0081c.a().contains(a.PENALTY_DEATH)) {
            l(componentCallbacksC0511fA, new Runnable() { // from class: T.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(name, iVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, i iVar) {
        k.g(iVar, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, iVar);
        throw iVar;
    }

    private final void e(i iVar) {
        if (x.F0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + iVar.a().getClass().getName(), iVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        k.g(componentCallbacksC0511f, "fragment");
        k.g(str, "previousFragmentId");
        T.a aVar = new T.a(componentCallbacksC0511f, str);
        c cVar = f5287a;
        cVar.e(aVar);
        C0081c c0081cB = cVar.b(componentCallbacksC0511f);
        if (c0081cB.a().contains(a.DETECT_FRAGMENT_REUSE) && cVar.m(c0081cB, componentCallbacksC0511f.getClass(), aVar.getClass())) {
            cVar.c(c0081cB, aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(ComponentCallbacksC0511f componentCallbacksC0511f, ViewGroup viewGroup) {
        k.g(componentCallbacksC0511f, "fragment");
        d dVar = new d(componentCallbacksC0511f, viewGroup);
        c cVar = f5287a;
        cVar.e(dVar);
        C0081c c0081cB = cVar.b(componentCallbacksC0511f);
        if (c0081cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && cVar.m(c0081cB, componentCallbacksC0511f.getClass(), dVar.getClass())) {
            cVar.c(c0081cB, dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(ComponentCallbacksC0511f componentCallbacksC0511f) {
        k.g(componentCallbacksC0511f, "fragment");
        e eVar = new e(componentCallbacksC0511f);
        c cVar = f5287a;
        cVar.e(eVar);
        C0081c c0081cB = cVar.b(componentCallbacksC0511f);
        if (c0081cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.m(c0081cB, componentCallbacksC0511f.getClass(), eVar.getClass())) {
            cVar.c(c0081cB, eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(ComponentCallbacksC0511f componentCallbacksC0511f, ComponentCallbacksC0511f componentCallbacksC0511f2, int i5) {
        k.g(componentCallbacksC0511f, "violatingFragment");
        k.g(componentCallbacksC0511f2, "targetFragment");
        f fVar = new f(componentCallbacksC0511f, componentCallbacksC0511f2, i5);
        c cVar = f5287a;
        cVar.e(fVar);
        C0081c c0081cB = cVar.b(componentCallbacksC0511f);
        if (c0081cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.m(c0081cB, componentCallbacksC0511f.getClass(), fVar.getClass())) {
            cVar.c(c0081cB, fVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5) {
        k.g(componentCallbacksC0511f, "fragment");
        g gVar = new g(componentCallbacksC0511f, z5);
        c cVar = f5287a;
        cVar.e(gVar);
        C0081c c0081cB = cVar.b(componentCallbacksC0511f);
        if (c0081cB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && cVar.m(c0081cB, componentCallbacksC0511f.getClass(), gVar.getClass())) {
            cVar.c(c0081cB, gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(ComponentCallbacksC0511f componentCallbacksC0511f, ViewGroup viewGroup) {
        k.g(componentCallbacksC0511f, "fragment");
        k.g(viewGroup, "container");
        j jVar = new j(componentCallbacksC0511f, viewGroup);
        c cVar = f5287a;
        cVar.e(jVar);
        C0081c c0081cB = cVar.b(componentCallbacksC0511f);
        if (c0081cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && cVar.m(c0081cB, componentCallbacksC0511f.getClass(), jVar.getClass())) {
            cVar.c(c0081cB, jVar);
        }
    }

    private final void l(ComponentCallbacksC0511f componentCallbacksC0511f, Runnable runnable) {
        if (!componentCallbacksC0511f.g0()) {
            runnable.run();
            return;
        }
        Handler handlerG = componentCallbacksC0511f.K().s0().g();
        k.f(handlerG, "fragment.parentFragmentManager.host.handler");
        if (k.b(handlerG.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerG.post(runnable);
        }
    }

    private final boolean m(C0081c c0081c, Class<? extends ComponentCallbacksC0511f> cls, Class<? extends i> cls2) {
        Set<Class<? extends i>> set = c0081c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (k.b(cls2.getSuperclass(), i.class) || !C0403n.x(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
