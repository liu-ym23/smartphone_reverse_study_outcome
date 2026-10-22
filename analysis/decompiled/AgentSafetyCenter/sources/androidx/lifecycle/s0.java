package androidx.lifecycle;

import android.os.Bundle;
import android.view.View;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kc.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f7.f f1433a = new f7.f(10);

    /* renamed from: b, reason: collision with root package name */
    public static final f7.f f1434b = new f7.f(11);

    /* renamed from: c, reason: collision with root package name */
    public static final f7.f f1435c = new f7.f(12);

    /* renamed from: d, reason: collision with root package name */
    public static final j4.b f1436d = new j4.b();

    public static final void a(y0 y0Var, t4.d dVar, q qVar) throws NoSuchMethodException, SecurityException {
        dVar.getClass();
        qVar.getClass();
        q0 q0Var = (q0) y0Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (q0Var == null || q0Var.f1427g) {
            return;
        }
        q0Var.n(dVar, qVar);
        p pVarB = qVar.b();
        if (pVarB == p.f1419f || pVarB.compareTo(p.f1421h) >= 0) {
            dVar.d();
            return;
        }
        h hVar = new h(1);
        hVar.f1389f = qVar;
        hVar.f1390g = dVar;
        VarHandle.storeStoreFence();
        qVar.a(hVar);
    }

    public static p0 b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            p0 p0Var = new p0();
            new LinkedHashMap();
            p0Var.f1423a = new ad.y(kb.t.f7405c);
            return p0Var;
        }
        ClassLoader classLoader = p0.class.getClassLoader();
        classLoader.getClass();
        bundle.setClassLoader(classLoader);
        lb.f fVar = new lb.f(bundle.size());
        for (String str : bundle.keySet()) {
            str.getClass();
            fVar.put(str, bundle.get(str));
        }
        lb.f fVarB = fVar.b();
        p0 p0Var2 = new p0();
        new LinkedHashMap();
        p0Var2.f1423a = new ad.y(fVarB);
        return p0Var2;
    }

    public static final p0 c(h4.c cVar) {
        LinkedHashMap linkedHashMap = cVar.f5290a;
        t4.f fVar = (t4.f) linkedHashMap.get(f1433a);
        if (fVar == null) {
            g5.f.s("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
            return null;
        }
        d1 d1Var = (d1) linkedHashMap.get(f1434b);
        if (d1Var == null) {
            g5.f.s("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            return null;
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f1435c);
        String str = (String) linkedHashMap.get(b1.f1361b);
        if (str == null) {
            g5.f.s("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            return null;
        }
        t4.c cVarB = fVar.getSavedStateRegistry().b();
        Bundle bundle2 = null;
        t0 t0Var = cVarB instanceof t0 ? (t0) cVarB : null;
        if (t0Var == null) {
            od.f.e("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
            return null;
        }
        LinkedHashMap linkedHashMap2 = g(d1Var).f1442b;
        p0 p0Var = (p0) linkedHashMap2.get(str);
        if (p0Var != null) {
            return p0Var;
        }
        t0Var.b();
        Bundle bundle3 = t0Var.f1439c;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = h5.t.o((jb.g[]) Arrays.copyOf(new jb.g[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                t0Var.f1439c = null;
            }
            bundle2 = bundle4;
        }
        p0 p0VarB = b(bundle2, bundle);
        linkedHashMap2.put(str, p0VarB);
        return p0VarB;
    }

    public static final x d(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            x xVar = tag instanceof x ? (x) tag : null;
            if (xVar != null) {
                return xVar;
            }
            Object objS = id.c.s(view);
            view = objS instanceof View ? (View) objS : null;
        }
        return null;
    }

    public static final d1 e(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
            d1 d1Var = tag instanceof d1 ? (d1) tag : null;
            if (d1Var != null) {
                return d1Var;
            }
            Object objS = id.c.s(view);
            view = objS instanceof View ? (View) objS : null;
        }
        return null;
    }

    public static final s f(x xVar) {
        s sVar;
        lc.d dVar;
        nb.c cVar;
        xVar.getClass();
        q lifecycle = xVar.getLifecycle();
        lifecycle.getClass();
        b1 b1Var = lifecycle.f1424a;
        do {
            s sVar2 = (s) ((AtomicReference) b1Var.f1362a).get();
            if (sVar2 != null) {
                return sVar2;
            }
            k1 k1VarC = kc.w.c();
            rc.e eVar = kc.e0.f7430a;
            dVar = pc.n.f9978a;
            nb.g gVarN = ac.a.N(k1VarC, dVar.i);
            gVarN.getClass();
            sVar = new s();
            sVar.f1431c = lifecycle;
            sVar.f1432f = gVarN;
            cVar = null;
            if (lifecycle.b() == p.f1418c) {
                kc.w.e(gVarN, null);
            }
            VarHandle.storeStoreFence();
        } while (!((AtomicReference) b1Var.f1362a).compareAndSet(null, sVar));
        kc.w.u(sVar, dVar.i, null, new r(sVar, cVar, 0), 2);
        return sVar;
    }

    public static final u0 g(d1 d1Var) {
        b1 b1VarE = f7.f.e(d1Var, new r0(), 4);
        return (u0) ((p5.i) b1VarE.f1362a).y(yb.v.a(u0.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static final j4.a h(y0 y0Var) {
        j4.a aVar;
        y0Var.getClass();
        synchronized (f1436d) {
            aVar = (j4.a) y0Var.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (aVar == null) {
                nb.g gVar = nb.h.f8811c;
                try {
                    rc.e eVar = kc.e0.f7430a;
                    gVar = pc.n.f9978a.i;
                } catch (IllegalStateException | jb.f unused) {
                }
                nb.g gVarPlus = gVar.plus(kc.w.c());
                gVarPlus.getClass();
                j4.a aVar2 = new j4.a();
                aVar2.f6552c = gVarPlus;
                VarHandle.storeStoreFence();
                y0Var.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }
}
