package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 implements a1 {

    /* renamed from: c, reason: collision with root package name */
    public Application f1443c;

    /* renamed from: f, reason: collision with root package name */
    public z0 f1444f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f1445g;

    /* renamed from: h, reason: collision with root package name */
    public q f1446h;
    public t4.d i;

    @Override // androidx.lifecycle.a1
    public final y0 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        g5.f.s("Local and anonymous classes can not be ViewModels");
        return null;
    }

    @Override // androidx.lifecycle.a1
    public final y0 b(yb.e eVar, h4.c cVar) {
        Class cls = eVar.f16088a;
        cls.getClass();
        return c(cls, cVar);
    }

    @Override // androidx.lifecycle.a1
    public final y0 c(Class cls, h4.c cVar) {
        LinkedHashMap linkedHashMap = cVar.f5290a;
        String str = (String) linkedHashMap.get(b1.f1361b);
        if (str == null) {
            od.f.e("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
            return null;
        }
        if (linkedHashMap.get(s0.f1433a) == null || linkedHashMap.get(s0.f1434b) == null) {
            if (this.f1446h != null) {
                return d(cls, str);
            }
            od.f.e("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        Application application = (Application) linkedHashMap.get(z0.f1463j);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? w0.a(cls, w0.f1448b) : w0.a(cls, w0.f1447a);
        return constructorA == null ? this.f1444f.c(cls, cVar) : (!zIsAssignableFrom || application == null) ? w0.b(cls, constructorA, s0.c(cVar)) : w0.b(cls, constructorA, application, s0.c(cVar));
    }

    public final y0 d(Class cls, String str) throws NoSuchMethodException, SecurityException {
        Application application = this.f1443c;
        q qVar = this.f1446h;
        if (qVar == null) {
            g5.f.o("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? w0.a(cls, w0.f1448b) : w0.a(cls, w0.f1447a);
        if (constructorA == null) {
            if (application != null) {
                return this.f1444f.a(cls);
            }
            if (f7.f.f3933f == null) {
                f7.f.f3933f = new f7.f(15);
            }
            f7.f.f3933f.getClass();
            return id.c.m(cls);
        }
        t4.d dVar = this.i;
        dVar.getClass();
        p0 p0VarB = s0.b(dVar.a(str), this.f1445g);
        q0 q0Var = new q0();
        q0Var.f1425c = str;
        q0Var.f1426f = p0VarB;
        VarHandle.storeStoreFence();
        q0Var.n(dVar, qVar);
        p pVarB = qVar.b();
        if (pVarB == p.f1419f || pVarB.compareTo(p.f1421h) >= 0) {
            dVar.d();
        } else {
            h hVar = new h(1);
            hVar.f1389f = qVar;
            hVar.f1390g = dVar;
            VarHandle.storeStoreFence();
            qVar.a(hVar);
        }
        y0 y0VarB = (!zIsAssignableFrom || application == null) ? w0.b(cls, constructorA, p0VarB) : w0.b(cls, constructorA, application, p0VarB);
        y0VarB.a("androidx.lifecycle.savedstate.vm.tag", q0Var);
        return y0VarB;
    }
}
