package ie;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p0 implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public k0 f6060a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f6061b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Class f6062c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ q0 f6063d;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        o oVarA;
        k0 k0Var = this.f6060a;
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f6061b;
        }
        k0Var.getClass();
        if (method.isDefault()) {
            Class<?> cls = this.f6062c;
            Constructor constructor = k0Var.f6004a;
            return (constructor != null ? (MethodHandles.Lookup) constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
        q0 q0Var = this.f6063d;
        o oVar = (o) q0Var.f6066a.get(method);
        if (oVar == null) {
            synchronized (q0Var.f6066a) {
                try {
                    oVarA = (o) q0Var.f6066a.get(method);
                    if (oVarA == null) {
                        oVarA = o.a(q0Var, method);
                        q0Var.f6066a.put(method, oVarA);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            oVar = oVarA;
        }
        v vVar = new v(oVar.f6051a, objArr, oVar.f6052b, oVar.f6053c);
        boolean z10 = false;
        switch (oVar.f6054d) {
            case 0:
                return oVar.f6055e.d(vVar);
            case 1:
                c cVar = (c) oVar.f6055e.d(vVar);
                nb.c cVar2 = (nb.c) objArr[objArr.length - 1];
                try {
                    kc.g gVar = new kc.g(1, td.h.y(cVar2));
                    gVar.u(new q(cVar, 0));
                    a2.i iVar = new a2.i(12);
                    iVar.f49f = gVar;
                    VarHandle.storeStoreFence();
                    cVar.i(iVar);
                    Object objR = gVar.r();
                    ob.a aVar = ob.a.f9351c;
                    return objR;
                } catch (Exception e10) {
                    return w0.q(e10, cVar2);
                }
            default:
                c cVar3 = (c) oVar.f6055e.d(vVar);
                nb.c cVar4 = (nb.c) objArr[objArr.length - 1];
                try {
                    kc.g gVar2 = new kc.g(1, td.h.y(cVar4));
                    gVar2.u(new q(cVar3, 1));
                    a1.g gVar3 = new a1.g(15, z10);
                    gVar3.f19f = gVar2;
                    VarHandle.storeStoreFence();
                    cVar3.i(gVar3);
                    Object objR2 = gVar2.r();
                    ob.a aVar2 = ob.a.f9351c;
                    return objR2;
                } catch (Exception e11) {
                    return w0.q(e11, cVar4);
                }
        }
    }
}
