package z7;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class w0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11974g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x0 f11975h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(x0 x0Var, int i2) {
        super(0);
        this.f11974g = i2;
        this.f11975h = x0Var;
    }

    @Override // p7.a
    public final Object c() throws x7.a, SecurityException {
        switch (this.f11974g) {
            case 0:
                return new v0(this.f11975h);
            default:
                x0 x0Var = this.f11975h;
                Object objE = x0Var.E();
                try {
                    Object obj = k1.f11893p;
                    Object objP = x0Var.D() ? ib.k.p(x0Var.f11897m, x0Var.B()) : null;
                    if (objP == obj) {
                        objP = null;
                    }
                    x0Var.D();
                    AccessibleObject accessibleObject = objE != null ? (AccessibleObject) objE : null;
                    if (accessibleObject != null) {
                        accessibleObject.setAccessible(n7.a.o(x0Var));
                    }
                    if (objE == null) {
                        return null;
                    }
                    if (objE instanceof Field) {
                        return ((Field) objE).get(objP);
                    }
                    if (!(objE instanceof Method)) {
                        throw new AssertionError("delegate field/method " + objE + " neither field nor method");
                    }
                    int length = ((Method) objE).getParameterTypes().length;
                    if (length == 0) {
                        return ((Method) objE).invoke(null, null);
                    }
                    if (length == 1) {
                        Method method = (Method) objE;
                        if (objP == null) {
                            Class<?> cls = ((Method) objE).getParameterTypes()[0];
                            q7.k.d(cls, "fieldOrMethod.parameterTypes[0]");
                            objP = x1.e(cls);
                        }
                        return method.invoke(null, objP);
                    }
                    if (length == 2) {
                        Method method2 = (Method) objE;
                        Class<?> cls2 = ((Method) objE).getParameterTypes()[1];
                        q7.k.d(cls2, "fieldOrMethod.parameterTypes[1]");
                        return method2.invoke(null, objP, x1.e(cls2));
                    }
                    throw new AssertionError("delegate method " + objE + " should take 0, 1, or 2 parameters");
                } catch (IllegalAccessException e10) {
                    throw new x7.a("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", e10);
                }
        }
    }
}
