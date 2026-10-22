package xd;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final o f13909a = o.f13857b;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13910b = new Object[0];

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f13911c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f13912d;

    public s(t tVar, Class cls) {
        this.f13912d = tVar;
        this.f13911c = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        u uVarB;
        o oVar = this.f13909a;
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f13910b;
        }
        oVar.getClass();
        if (method.isDefault()) {
            Class<?> cls = this.f13911c;
            Constructor<MethodHandles.Lookup> constructor = oVar.f13858a;
            return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
        t tVar = this.f13912d;
        u uVar = (u) tVar.f13913a.get(method);
        if (uVar == null) {
            synchronized (tVar.f13913a) {
                try {
                    uVarB = (u) tVar.f13913a.get(method);
                    if (uVarB == null) {
                        uVarB = u.b(tVar, method);
                        tVar.f13913a.put(method, uVarB);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            uVar = uVarB;
        }
        return uVar.a(objArr);
    }
}
