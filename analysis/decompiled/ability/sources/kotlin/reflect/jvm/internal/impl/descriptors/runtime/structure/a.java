package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import D7.q;
import G8.c;
import G8.f;
import H4.o;
import J4.b;
import j9.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import n8.AbstractC1744c;
import n8.d;
import n8.l;
import n8.t;
import n8.v;
import x8.InterfaceC2119b;
import x8.InterfaceC2120c;
import x8.InterfaceC2122e;

/* loaded from: classes4.dex */
public final class a extends l implements InterfaceC2119b, InterfaceC2120c, InterfaceC2122e {

    /* renamed from: a, reason: collision with root package name */
    public final Class f4985a;

    public a(Class klass) {
        k.f(klass, "klass");
        this.f4985a = klass;
    }

    @Override // x8.InterfaceC2119b
    public final d a(c fqName) {
        Annotation[] declaredAnnotations;
        k.f(fqName, "fqName");
        Class cls = this.f4985a;
        if (cls == null || (declaredAnnotations = cls.getDeclaredAnnotations()) == null) {
            return null;
        }
        return o.B(declaredAnnotations, fqName);
    }

    public final Collection b() throws SecurityException {
        Constructor<?>[] declaredConstructors = this.f4985a.getDeclaredConstructors();
        k.e(declaredConstructors, "getDeclaredConstructors(...)");
        return kotlin.sequences.a.o0(kotlin.sequences.a.m0(kotlin.sequences.a.g0(q.M(declaredConstructors), ReflectJavaClass$constructors$1.f4980a), ReflectJavaClass$constructors$2.f4981a));
    }

    public final Collection c() {
        Field[] declaredFields = this.f4985a.getDeclaredFields();
        k.e(declaredFields, "getDeclaredFields(...)");
        return kotlin.sequences.a.o0(kotlin.sequences.a.m0(kotlin.sequences.a.g0(q.M(declaredFields), ReflectJavaClass$fields$1.f4982a), ReflectJavaClass$fields$2.f4983a));
    }

    public final c d() {
        return AbstractC1744c.a(this.f4985a).a();
    }

    public final Collection e() throws SecurityException {
        Method[] declaredMethods = this.f4985a.getDeclaredMethods();
        k.e(declaredMethods, "getDeclaredMethods(...)");
        return kotlin.sequences.a.o0(kotlin.sequences.a.m0(kotlin.sequences.a.f0(q.M(declaredMethods), new b(this, 15)), ReflectJavaClass$methods$2.f4984a));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return k.b(this.f4985a, ((a) obj).f4985a);
        }
        return false;
    }

    public final f f() {
        Class cls = this.f4985a;
        if (!cls.isAnonymousClass()) {
            return f.e(cls.getSimpleName());
        }
        String name = cls.getName();
        return f.e(m.J0(name, ".", name));
    }

    public final ArrayList g() {
        Class clazz = this.f4985a;
        k.f(clazz, "clazz");
        u1.d dVar = z2.l.i;
        if (dVar == null) {
            try {
                dVar = new u1.d(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 19);
            } catch (NoSuchMethodException unused) {
                dVar = new u1.d(objArr, objArr, objArr, objArr, 19);
            }
            z2.l.i = dVar;
        }
        Method method = (Method) dVar.e;
        objArr = method != null ? (Object[]) method.invoke(clazz, null) : null;
        if (objArr == null) {
            objArr = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new t(obj));
        }
        return arrayList;
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        Annotation[] declaredAnnotations;
        Class cls = this.f4985a;
        return (cls == null || (declaredAnnotations = cls.getDeclaredAnnotations()) == null) ? EmptyList.f4893a : o.D(declaredAnnotations);
    }

    @Override // x8.InterfaceC2122e
    public final ArrayList getTypeParameters() {
        TypeVariable[] typeParameters = this.f4985a.getTypeParameters();
        k.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new v(typeVariable));
        }
        return arrayList;
    }

    public final boolean h() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class clazz = this.f4985a;
        k.f(clazz, "clazz");
        u1.d dVar = z2.l.i;
        Boolean bool = null;
        if (dVar == null) {
            try {
                dVar = new u1.d(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 19);
            } catch (NoSuchMethodException unused) {
                dVar = new u1.d(bool, bool, bool, bool, 19);
            }
            z2.l.i = dVar;
        }
        Method method = (Method) dVar.d;
        if (method != null) {
            Object objInvoke = method.invoke(clazz, null);
            k.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) objInvoke;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final int hashCode() {
        return this.f4985a.hashCode();
    }

    public final boolean i() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class clazz = this.f4985a;
        k.f(clazz, "clazz");
        u1.d dVar = z2.l.i;
        Boolean bool = null;
        if (dVar == null) {
            try {
                dVar = new u1.d(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 19);
            } catch (NoSuchMethodException unused) {
                dVar = new u1.d(bool, bool, bool, bool, 19);
            }
            z2.l.i = dVar;
        }
        Method method = (Method) dVar.b;
        if (method != null) {
            Object objInvoke = method.invoke(clazz, null);
            k.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) objInvoke;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.z(sb, a.class, ": ");
        sb.append(this.f4985a);
        return sb.toString();
    }
}
