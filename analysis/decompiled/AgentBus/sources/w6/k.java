package w6;

import android.content.Context;
import ia.b0;
import ia.d0;
import ia.n0;
import ia.x1;
import java.util.List;
import s2.z;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f10807a = {q7.w.f8821a.f(new q7.p(1, k.class, q7.b.f8796f, "publicKeyDataStore", "getPublicKeyDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;"))};

    /* renamed from: b, reason: collision with root package name */
    public static final v2.b f10808b;

    static {
        pa.e eVar = n0.f4982a;
        pa.d dVar = pa.d.f8556h;
        x1 x1VarC = d0.c();
        dVar.getClass();
        f10808b = new v2.b(v2.a.f10378g, d0.b(g7.i.plus(dVar, x1VarC)));
    }

    public static final s2.f access$getPublicKeyDataStore(Context context) {
        o4.d0 d0Var;
        v2.b bVar = f10808b;
        w7.t tVar = f10807a[0];
        bVar.getClass();
        q7.k.e(context, "thisRef");
        q7.k.e(tVar, "property");
        o4.d0 d0Var2 = bVar.f10382d;
        if (d0Var2 != null) {
            return d0Var2;
        }
        synchronized (bVar.f10381c) {
            try {
                if (bVar.f10382d == null) {
                    Context applicationContext = context.getApplicationContext();
                    p7.k kVar = bVar.f10379a;
                    q7.k.d(applicationContext, "applicationContext");
                    List list = (List) kVar.invoke(applicationContext);
                    b0 b0Var = bVar.f10380b;
                    t9.h hVar = new t9.h(applicationContext, bVar);
                    q7.k.e(list, "migrations");
                    z zVar = new z(new u2.f(ob.o.f8022a, new t9.h(10, hVar)), a.a.S(new p.v(list, (g7.d) null, 3)), new h4.n(22, false), b0Var);
                    bVar.f10382d = new o4.d0(16, new o4.d0(16, zVar));
                }
                d0Var = bVar.f10382d;
                q7.k.b(d0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        return d0Var;
    }
}
