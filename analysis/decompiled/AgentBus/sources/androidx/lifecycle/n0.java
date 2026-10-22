package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final class n0 implements r0 {

    /* renamed from: f, reason: collision with root package name */
    public final Application f1012f;

    /* renamed from: g, reason: collision with root package name */
    public final q0 f1013g;

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f1014h;

    /* renamed from: i, reason: collision with root package name */
    public final x f1015i;

    /* renamed from: j, reason: collision with root package name */
    public final q6.b f1016j;

    public n0(Application application, i3.e eVar, Bundle bundle) {
        q0 q0Var;
        c.i iVar = (c.i) eVar;
        this.f1016j = (q6.b) iVar.f1687i.f8787g;
        this.f1015i = iVar.f4074f;
        this.f1014h = bundle;
        this.f1012f = application;
        if (application != null) {
            if (q0.f1026i == null) {
                q0.f1026i = new q0(application);
            }
            q0Var = q0.f1026i;
            q7.k.b(q0Var);
        } else {
            q0Var = new q0(null);
        }
        this.f1013g = q0Var;
    }

    @Override // androidx.lifecycle.r0
    public final p0 b(Class cls) throws NoSuchMethodException, SecurityException {
        AutoCloseable autoCloseable;
        Application application;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        x xVar = this.f1015i;
        if (xVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.f1012f == null) ? o0.a(cls, o0.f1018b) : o0.a(cls, o0.f1017a);
        if (constructorA == null) {
            if (this.f1012f != null) {
                return this.f1013g.b(cls);
            }
            if (s9.d.f9628g == null) {
                s9.d.f9628g = new s9.d(6);
            }
            q7.k.b(s9.d.f9628g);
            return w7.e0.p(cls);
        }
        q6.b bVar = this.f1016j;
        q7.k.b(bVar);
        g0 g0VarB = j0.b(bVar.y0(canonicalName), this.f1014h);
        h0 h0Var = new h0(canonicalName, g0VarB);
        h0Var.g(xVar, bVar);
        q qVar = xVar.f1035c;
        if (qVar == q.f1021g || qVar.compareTo(q.f1023i) >= 0) {
            bVar.N0();
        } else {
            xVar.a(new h(xVar, bVar));
        }
        p0 p0VarB = (!zIsAssignableFrom || (application = this.f1012f) == null) ? o0.b(cls, constructorA, g0VarB) : o0.b(cls, constructorA, application, g0VarB);
        p0VarB.getClass();
        c3.a aVar = p0VarB.f1019a;
        if (aVar == null) {
            return p0VarB;
        }
        if (aVar.f1894d) {
            c3.a.a(h0Var);
            return p0VarB;
        }
        synchronized (aVar.f1891a) {
            autoCloseable = (AutoCloseable) aVar.f1892b.put("androidx.lifecycle.savedstate.vm.tag", h0Var);
        }
        c3.a.a(autoCloseable);
        return p0VarB;
    }
}
