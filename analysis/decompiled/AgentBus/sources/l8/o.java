package l8;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends s implements v8.b, v8.e {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5878a;

    public o(Class cls) {
        q7.k.e(cls, "klass");
        this.f5878a = cls;
    }

    @Override // v8.b
    public final e a(e9.c cVar) {
        Annotation[] declaredAnnotations;
        q7.k.e(cVar, "fqName");
        Class cls = this.f5878a;
        if (cls == null || (declaredAnnotations = cls.getDeclaredAnnotations()) == null) {
            return null;
        }
        return a.a.M(declaredAnnotations, cVar);
    }

    public final List b() {
        Field[] declaredFields = this.f5878a.getDeclaredFields();
        q7.k.d(declaredFields, "klass.declaredFields");
        return fa.l.v0(fa.l.t0(new fa.f(d7.n.T(declaredFields), false, l.f5875n), m.f5876n));
    }

    public final e9.c c() {
        return d.a(this.f5878a).b();
    }

    public final List d() throws SecurityException {
        Method[] declaredMethods = this.f5878a.getDeclaredMethods();
        q7.k.d(declaredMethods, "klass.declaredMethods");
        return fa.l.v0(fa.l.t0(new fa.f(d7.n.T(declaredMethods), true, new c1.w(15, this)), n.f5877n));
    }

    public final ArrayList e() {
        Class cls = this.f5878a;
        q7.k.e(cls, "clazz");
        i5.f fVar = w7.e0.f10865b;
        if (fVar == null) {
            try {
                fVar = new i5.f(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 11);
            } catch (NoSuchMethodException unused) {
                fVar = new i5.f(objArr, objArr, objArr, objArr, 11);
            }
            w7.e0.f10865b = fVar;
        }
        Method method = (Method) fVar.f4656j;
        objArr = method != null ? (Object[]) method.invoke(cls, null) : null;
        if (objArr == null) {
            objArr = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new a0(obj));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return q7.k.a(this.f5878a, ((o) obj).f5878a);
        }
        return false;
    }

    public final boolean f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = this.f5878a;
        q7.k.e(cls, "clazz");
        i5.f fVar = w7.e0.f10865b;
        Boolean bool = null;
        if (fVar == null) {
            try {
                fVar = new i5.f(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 11);
            } catch (NoSuchMethodException unused) {
                fVar = new i5.f(bool, bool, bool, bool, 11);
            }
            w7.e0.f10865b = fVar;
        }
        Method method = (Method) fVar.f4655i;
        if (method != null) {
            Object objInvoke = method.invoke(cls, null);
            q7.k.c(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) objInvoke;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean g() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = this.f5878a;
        q7.k.e(cls, "clazz");
        i5.f fVar = w7.e0.f10865b;
        Boolean bool = null;
        if (fVar == null) {
            try {
                fVar = new i5.f(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 11);
            } catch (NoSuchMethodException unused) {
                fVar = new i5.f(bool, bool, bool, bool, 11);
            }
            w7.e0.f10865b = fVar;
        }
        Method method = (Method) fVar.f4653g;
        if (method != null) {
            Object objInvoke = method.invoke(cls, null);
            q7.k.c(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) objInvoke;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        Annotation[] declaredAnnotations;
        Class cls = this.f5878a;
        return (cls == null || (declaredAnnotations = cls.getDeclaredAnnotations()) == null) ? d7.z.f2978f : a.a.P(declaredAnnotations);
    }

    @Override // v8.e
    public final ArrayList getTypeParameters() {
        TypeVariable[] typeParameters = this.f5878a.getTypeParameters();
        q7.k.d(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new c0(typeVariable));
        }
        return arrayList;
    }

    public final int hashCode() {
        return this.f5878a.hashCode();
    }

    public final String toString() {
        return o.class.getName() + ": " + this.f5878a;
    }
}
